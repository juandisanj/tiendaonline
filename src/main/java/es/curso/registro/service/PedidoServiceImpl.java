package es.curso.registro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Pedido;
import es.curso.registro.model.Status;
import es.curso.registro.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> getAll() {
		
		return pedidoRepository.findAll();
	}
	
	@Override
	public List<Pedido> getByStatus(Status status) {
		
		return pedidoRepository.findByStatus(status);
	}

	@Override
	public Pedido getById(int idPedido) {
		
		return pedidoRepository.findById(idPedido).get();
	}

	@Transactional
	@Override
	public void create(Pedido pedido) {
		
		pedidoRepository.save(pedido);

	}

	@Override
	public void update(Pedido pedido) {

		pedidoRepository.save(pedido);

	}

	@Override
	public void delete(int idPedido) {

		Pedido pedido = pedidoRepository.findById(idPedido).get();
		pedidoRepository.delete(pedido);

	}

}
