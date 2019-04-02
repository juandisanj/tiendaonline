package es.curso.registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.curso.registro.filterModel.PedidoForm;
import es.curso.registro.model.Role;
import es.curso.registro.model.User;
import es.curso.registro.service.PedidoService;
import es.curso.registro.service.StatusService;
import es.curso.registro.service.UserService;
import es.curso.registro.util.Constantes;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private StatusService statusService;
	
    @GetMapping("/")
    public String root(Model model, @ModelAttribute(value="pedidoForm") PedidoForm pedidoForm) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();
    	
    	System.out.println("Entra en método raiz");
    	
    	
    	
    	if(pedidoForm.getStatus() != null) {
    		model.addAttribute("listaPedidos", pedidoService.getByStatus(pedidoForm.getStatus()));
    	}else {
    		model.addAttribute("listaPedidos", userService.findByEmail(username).getListaPedido());
    	}
    	
    	model.addAttribute("listStatus", statusService.getAll());
    	model.addAttribute("pedidoForm", new PedidoForm());
        return "index";
    }
    
    @PostMapping("/")
    public String rootFilter(PedidoForm pedidoForm, RedirectAttributes redir) {
    	
    	redir.addFlashAttribute("pedidoForm", pedidoForm);
    	return "redirect:/";
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
