package es.curso.registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.curso.registro.model.Role;
import es.curso.registro.model.User;
import es.curso.registro.service.PedidoService;
import es.curso.registro.service.UserService;
import es.curso.registro.util.Constantes;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	@Autowired
	private PedidoService pedidoService;
	
    @GetMapping("/")
    public String root(Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();
    	model.addAttribute("listaPedidos", userService.findByEmail(username).getListaPedido());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
  
    @GetMapping("/index")
    public String userIndex2() {
        return "index";
    }
    @GetMapping("/admin/home")
    public String listaUsuarios(Model model) {
        model.addAttribute("listaUsuarios" , userService.getAll() );
        return "listaUsuarios";
    }
    
    @GetMapping("/admin/quitarPrivilegios/{id}")
    public String quitarPrivilegiosAdmin(Model model, 
    		@PathVariable("id") Long id) {
        User user =  userService.findById(id);
        Role roleToDelete = userService.getRoleWithName(Constantes.ROLE_ADMIN);
        userService.deleteRolesWithRoleIdUserId(roleToDelete.getId(), id);
        userService.update(user);
        return "index";
    }

    @GetMapping("/admin/darPrivilegios/{id}")
    public String darPrivilegiosAdmin(Model model, 
    		@PathVariable("id") Long id) {
        User user =  userService.findById(id);
        Role roleToAdd = userService.getRoleWithName(Constantes.ROLE_ADMIN);
        user.getRoles().add(roleToAdd);
        userService.update(user);
        return "index";
    }

}
