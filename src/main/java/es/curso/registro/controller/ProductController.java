package es.curso.registro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Producto;
import es.curso.registro.service.ProductoService;

@Controller
@RequestMapping("/product")
@SessionAttributes("listaCarrito")
public class ProductController {
	
	@Autowired
	private ProductoService productoService;
	
	@ModelAttribute("listaCarrito")
	public List<LineaPedido> getListaCarrito(){
		return new ArrayList<LineaPedido>();
	}
	
	@GetMapping("/index")
	public String indexProduct(Model model) {
		
		List<LineaPedido> listaCarrito = new ArrayList<>();
		model.addAttribute("productoFiltro", new Producto());

		
		model.addAttribute("productos", productoService.getAll());
		return "producto/indexProductos";
	}
	
	@PostMapping("/index")	
	public String filtroProduct(Model model, @ModelAttribute("productoFiltro") 
	Producto productoFiltro) {
		if(productoFiltro==null) {
			model.addAttribute("productos", productoService.getAll());
		}
		else if(productoFiltro.getNombre()!=null || productoFiltro.getDescripcion()!=null || 
				productoFiltro.getPrecio()!=null){
			model.addAttribute("productos", 
					productoService.findByFiltro(productoFiltro.getNombre(), 
							productoFiltro.getDescripcion(), productoFiltro.getPrecio()));
		}
		return "producto/indexProductos";
	}
	
	@GetMapping("/detailProduct")
	public String getLineaPedido(@RequestParam("idProducto") Integer idProducto, Model model) {
		
		Producto producto = productoService.getById(idProducto);
		LineaPedido lineaPedido = new LineaPedido();
		lineaPedido.setProducto(producto);
		model.addAttribute("lineaPedido", lineaPedido);
		return "producto/detailProduct";
	}
	
	@GetMapping("/formProduct")
	public String formProduct() {
		return "producto/formProduct";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model) {
		
		model.addAttribute("producto", new Producto());
		return "producto/formProduct";
	}
	
	@PostMapping("/add")
	public String addProduct(Producto producto, Model model) {
		
		productoService.create(producto);
		return "redirect:/product/index";
	}
	
	@GetMapping("/update")
	public String formProduct(@RequestParam("idProducto") Integer idProduct, Model model) {
		
		Producto producto = productoService.getById(idProduct);
		model.addAttribute("producto", producto);
		return "producto/formProduct";
	}
	
	@PostMapping("/update")
	public String updateProduct(Producto producto) {
		
		productoService.update(producto);
		return "redirect:/producto/indexProductos";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("idProducto") Integer idProduct, Model model, RedirectAttributes redir) {
		
		productoService.delete(idProduct);
		redir.addFlashAttribute("deleteOk", "Producto eliminado correctamente");
		return "redirect:/product/index";
	}

}
