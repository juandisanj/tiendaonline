package es.curso.registro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.User;
import es.curso.registro.service.LineaPedidoService;
import es.curso.registro.service.PedidoService;
import es.curso.registro.service.ProductoService;
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
	@Autowired
	private LineaPedidoService lineaService;
	@Autowired
	private ProductoService productService;

	@GetMapping("/detail")
	public String detallePedido(@SessionAttribute List<LineaPedido> listaCarrito, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userService.findByEmail(email);
		
		Pedido pedido = new Pedido();
		pedido.setStatus(statusService.getById(1));
		pedido.setListaLineas(listaCarrito);
		pedido.setUser(user);

		model.addAttribute("listStatus", statusService.getAll());
		model.addAttribute("pedido", pedido);
		return "pedido/detailPedido";
	}

	@GetMapping("/form/{email}")
	public String crearPedido(@PathVariable(value = "email") String email,
			HttpSession httpSession, Model model, RedirectAttributes flash) {
		List<LineaPedido> listaCarrito = (List<LineaPedido>) httpSession.getAttribute("listaCarrito");
		
		if(listaCarrito == null) {
			listaCarrito = new ArrayList<LineaPedido>();
			httpSession.setAttribute("listaCarrito", listaCarrito);
		}

		User user = userService.findByEmail(email);
		
		Pedido pedido = new Pedido();
		pedido.setUser(user);
		pedido.setListaLineas(listaCarrito);

		if (user == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/index";
		}

		model.addAttribute("listStatus", statusService.getAll());
		model.addAttribute("listProducts", productService.getAll());
		model.addAttribute("pedido", pedido);

		return "pedido/formPedido";
	}

	@PostMapping("/form")
	public String savePedido(Pedido pedido, @SessionAttribute List<LineaPedido> listaCarrito) {
		
		if(listaCarrito.size() == 0) {
			return "redirect:/product/index";
		}
		
		pedido.setListaLineas(listaCarrito);
		
		pedidoService.create(pedido);
		
		listaCarrito.clear();

		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updatePedido(@RequestParam("idPedido") int idPedido, Model model) {
		
		Pedido pedido = pedidoService.getById(idPedido);
		model.addAttribute("listStatus", statusService.getAll());
		model.addAttribute("listProducts", productService.getAll());
		model.addAttribute("pedido", pedido);
		return "pedido/formPedido";
	}

}
