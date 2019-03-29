package es.curso.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.LineaPedido;

@Repository
public interface LineaPedidoRepository extends JpaRepository<LineaPedido, Integer>  {

}
