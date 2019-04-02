package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Pedido;
import es.curso.registro.model.Status;

public interface PedidoService {
	
	List<Pedido> getAll();
	
	List<Pedido> getByStatus(Status status);
	
	Pedido getById(int idPedido);
	
	void create(Pedido pedido);
	
	void update(Pedido pedido);
	
	void delete(int idPedido);

}
