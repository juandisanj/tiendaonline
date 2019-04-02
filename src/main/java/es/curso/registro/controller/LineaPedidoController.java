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
	
	@GetMapping("/addLinea")
	public String getLineaPedido(@RequestParam("idProducto") Integer idProducto, Model model) {
		
		Producto producto = productoService.getById(idProducto);
		LineaPedido lineaPedido = new LineaPedido();
		lineaPedido.setProducto(producto);
		model.addAttribute("lineaPedido", lineaPedido);
		return "lineapedido/formLineaPedido";
	}
	
	@PostMapping("/addLineaCarrito")
	public String addLinea(LineaPedido lineaPedido, @SessionAttribute(name="listaCarrito") List<LineaPedido> listaCarrito) {
		
		lineaPedido.getImporteLinea();
		System.out.println("Precio línea: " + lineaPedido.getPrecioLinea());
		listaCarrito.add(lineaPedido);
		
		for(LineaPedido l : listaCarrito) {
			System.out.println("Producto " + l.getProducto().getNombre());
		}
		
		return "redirect:/product/index";
	}
	
	

}
