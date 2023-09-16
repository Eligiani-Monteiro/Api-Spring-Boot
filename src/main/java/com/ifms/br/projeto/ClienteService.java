package com.ifms.br.projeto;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.br.projeto.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	private Logger logger = Logger.getLogger(ClienteService.class.getName());
	
	@Autowired
	private ClienteRepository repository;
	
	
	public Cliente findById(Long id) {
		logger.info("Fiding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		
	}
	public List<Cliente> findAll(){
		logger.info("Fiding all client!");
		return repository.findAll();
	}
	public Cliente create(Cliente cliente) {
		logger.info("creating one person!");
		return repository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		logger.info("Updating one cliente!");
		var entity = repository.findById(cliente.getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		entity.setNome(cliente.getNome());
		entity.setEndereco(cliente.getEndereco());
		entity.setCidade(cliente.getCidade());
		entity.setEstado(cliente.getEstado());
		entity.setCep(cliente.getCep());
		entity.setTelefone(cliente.getTelefone());
		return repository.save(cliente);
		
	}

	public void delete(Long id) {
		logger.info("Deleting one cliente!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		repository.delete(entity);
	}
}
