package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Producto;

public interface ProductoService {
	List <Producto> getAll();
	
	Producto getById(int idProducto);
	
	void create(Producto producto);
	
	void delete(int id);
	
	void update(Producto producto);
}
