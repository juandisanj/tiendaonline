package es.curso.registro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@GetMapping("/action")
	public String accionCarrito(@RequestParam("action") String accion, @RequestParam("idProducto") int idProducto) {
		
		return "product/index";
	}

}
