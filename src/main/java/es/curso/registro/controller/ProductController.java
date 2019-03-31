package es.curso.registro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping("/index")
	public String indexProduct() {
		
		return "producto/indexProductos";
	}
	
	@GetMapping("/formProduct")
	public String formProduct() {
		return "producto/formProduct";
	}

}
