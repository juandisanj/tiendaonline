package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.LineaPedido;

public interface LineaPedidoService {

	List<LineaPedido> getAll();

	LineaPedido getById(int idLineaPedido);

	void create(LineaPedido linePedido);

	void update(LineaPedido linePedido);

	void delete(int idPedido);

}
