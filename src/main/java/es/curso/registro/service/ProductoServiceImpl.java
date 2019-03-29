package es.curso.registro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Producto;
import es.curso.registro.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto getById(int idProducto) {
		return productoRepository.findById(idProducto).get();
	}

	@Override
	public void create(Producto producto) {
		productoRepository.save(producto);		
	}

	@Override
	public void delete(int idProducto) {
		Producto producto=productoRepository.findById(idProducto).get();
		productoRepository.delete(producto);
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
	}
}
