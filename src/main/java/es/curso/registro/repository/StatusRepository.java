package es.curso.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.registro.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{

}
