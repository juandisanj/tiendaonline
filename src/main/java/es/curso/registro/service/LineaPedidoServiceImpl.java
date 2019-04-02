package es.curso.registro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.repository.LineaPedidoRepository;

@Service
public class LineaPedidoServiceImpl implements LineaPedidoService {
	
	@Autowired
	private LineaPedidoRepository lineaPedidoRepository;

	@Override
	public List<LineaPedido> getAll() {
		
		return lineaPedidoRepository.findAll();
	}

	@Override
	public LineaPedido getById(int idLineaPedido) {
		
		return lineaPedidoRepository.findById(idLineaPedido).get();
	}

	@Transactional
	@Override
	public void create(LineaPedido lineaPedido) {

		lineaPedidoRepository.save(lineaPedido);

	}

	@Override
	public void update(LineaPedido lineaPedido) {

		lineaPedidoRepository.save(lineaPedido);

	}

	@Override
	public void delete(int idPedido) {
		
		LineaPedido lineaPedido = lineaPedidoRepository.findById(idPedido).get();
		lineaPedidoRepository.delete(lineaPedido);

	}

}
