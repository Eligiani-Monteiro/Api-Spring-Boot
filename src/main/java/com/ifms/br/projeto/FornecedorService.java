package com.ifms.br.projeto;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.br.projeto.exceptions.ResourceNotFoundException;

@Service
public class FornecedorService {

	private Logger logger = Logger.getLogger(FornecedorService.class.getName());
	
	@Autowired
	private FornecedorRepository repository;
	
	
	public Fornecedor findById(Long id) {
		logger.info("Fiding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		
	}
	public List<Fornecedor> findAll(){
		logger.info("Fiding all client!");
		return repository.findAll();
	}
	public Fornecedor create(Fornecedor fornecedor) {
		logger.info("creating one person!");
		return repository.save(fornecedor);
	}

	public Fornecedor update(Fornecedor fornecedor) {
		logger.info("Updating one cliente!");
		var entity = repository.findById(fornecedor.getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		entity.setId(fornecedor.getId());
		entity.setNome(fornecedor.getNome());
		entity.setEndereco(fornecedor.getEndereco());
		entity.setCidade(fornecedor.getCidade());
		entity.setEstado(fornecedor.getEstado());
		entity.setCep(fornecedor.getCep());
		entity.setTelefone(fornecedor.getTelefone());
		entity.setCnpj(fornecedor.getCnpj());
		return repository.save(fornecedor);
		
	}

	public void delete(Long id) {
		logger.info("Deleting one fornecedor!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		repository.delete(entity);
	}
}
