package es.curso.registro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.User;
import es.curso.registro.service.PedidoService;
import es.curso.registro.service.StatusService;
import es.curso.registro.service.UserService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private UserService userService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/detail")
	public String detallePedido(@SessionAttribute("listaCarrito") List<LineaPedido> listaCarrito, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userService.findByEmail(email);
		
		Pedido pedido = new Pedido();
		pedido.setStatus(statusService.getById(1));
		pedido.setListaLineas(listaCarrito);
		pedido.setUser(user);

		model.addAttribute("pedido", pedido);
		return "pedido/detailPedido";
	}

	@GetMapping("/form/{email}")
	public String crearPedido(@PathVariable(value = "email") String email,
			@SessionAttribute List<LineaPedido> listaCarrito, Model model, RedirectAttributes flash) {

		User user = userService.findByEmail(email);

		if (user == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/index";
		}

		
		model.addAttribute("pedidoCarrito", listaCarrito);

		return "pedido/formPedido";
	}

	@PostMapping("/form")
	public String savePedido(Pedido pedido) {
		
		System.out.println("Antes de guardar");
		
		System.out.println("Usuario que realiza el pedido: " + pedido.getUser().getNombre());
		System.out.println("Número de elementos de la lista: " + pedido.getListaLineas().size());
		
		pedidoService.create(pedido);

		return "redirect:/";
	}

}
