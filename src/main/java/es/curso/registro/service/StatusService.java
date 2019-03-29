package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Producto;
import es.curso.registro.model.Status;

public interface StatusService {
	List <Status> getAll();
	
	Status getById(int idStatus);
	
	void create(Status status);
	
	void delete(int id);
	
	void update(Status status);
}
