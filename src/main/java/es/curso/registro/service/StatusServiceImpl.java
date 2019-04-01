package es.curso.registro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Status;
import es.curso.registro.repository.StatusRepository;

@Service	
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	StatusRepository statusRepository;
	
	@Override
	public List<Status> getAll() {
		return statusRepository.findAll();
	}

	@Override
	public Status getById(int idStatus) {
		return statusRepository.findById(idStatus).get();
	}

	@Override
	public void create(Status status) {
		statusRepository.save(status);
	}

	@Override
	public void delete(int idStatus) {
		Status status=statusRepository.findById(idStatus).get();
		statusRepository.delete(status);
	}

	@Override
	public void update(Status status) {
		statusRepository.save(status);
	}
	
}
