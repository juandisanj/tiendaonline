package es.curso.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
