package es.curso.registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.curso.registro.model.Pedido;
import es.curso.registro.model.User;
import es.curso.registro.service.UserService;

@Controller
@RequestMapping("/pedido")
@SessionAttributes("pedido")
public class PedidoController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/form/{userId}")
	public String crearPedido(@PathVariable(value="userId") Long userId, Model model, RedirectAttributes flash) {
		
		User user = userService.findById(userId);
		
		if(user == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/index";
		}
		
		Pedido pedido = new Pedido();
		pedido.setUser(user);
		
		model.addAttribute("pedido", pedido);
		
		return "pedido/formPedido";
	}
	
	@PostMapping("/form")
	public String savePedido(@RequestParam("pedido") Pedido pedido) {
		
		return "index/{pedido.idPedido}";
	}

}
