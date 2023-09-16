package com.ifms.br.projeto;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.br.projeto.exceptions.ResourceNotFoundException;

@Service
public class BalconistaService {

	private Logger logger = Logger.getLogger(BalconistaService.class.getName());
	
	@Autowired
	private BalconistaRepository repository;
	
	
	public Balconista findById(Long id) {
		logger.info("Fiding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		
	}
	public List<Balconista> findAll(){
		logger.info("Fiding all client!");
		return repository.findAll();
	}
	public Balconista create(Balconista balconista) {
		logger.info("creating one person!");
		return repository.save(balconista);
	}

	public Balconista update(Balconista balconista) {
		logger.info("Updating one cliente!");
		var entity = repository.findById(balconista.getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		entity.setId(balconista.getId());
		entity.setNomeusuario(balconista.getNomeusuario());
		entity.setSenha(balconista.getSenha());
		entity.setNivelacesso(balconista.getNivelacesso());
		return repository.save(balconista);
		
	}

	public void delete(Long id) {
		logger.info("Deleting one cliente!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		repository.delete(entity);
	}
}
