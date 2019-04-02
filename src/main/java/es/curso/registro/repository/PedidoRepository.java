package es.curso.registro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.Pedido;
import es.curso.registro.model.Status;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	List<Pedido> findByStatus(Status status);
	
}
