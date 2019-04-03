package es.curso.registro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Producto;
import es.curso.registro.service.ProductoService;

@Controller
@RequestMapping("/lineaPedido")
public class LineaPedidoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/addLineaCarrito")
	public String addLinea(LineaPedido lineaPedido, @SessionAttribute(name="listaCarrito") List<LineaPedido> listaCarrito) {
		
//		if(listaCarrito.contains(lineaPedido)) {
//			System.out.println("El artículo ya existe en la cesta");
//		}
		
		
		lineaPedido.getImporteLinea();
		listaCarrito.add(lineaPedido);
		
		return "redirect:/product/index";
	}
	
	

}
