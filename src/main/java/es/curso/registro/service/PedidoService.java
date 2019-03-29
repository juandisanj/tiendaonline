package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Pedido;

public interface PedidoService {
	
	List<Pedido> getAll();
	
	Pedido getById(int idPedido);
	
	void create(Pedido pedido);
	
	void update(Pedido pedido);
	
	void delete(int idPedido);

}
