package com.ifms.br.projeto;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.br.projeto.exceptions.ResourceNotFoundException;

@Service
public class LivroService {

	private Logger logger = Logger.getLogger(LivroService.class.getName());
	
	@Autowired
	private LivroRepository repository;
	
	
	public Livro findById(Long id) {
		logger.info("Fiding one livro!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		
	}
	public List<Livro> findAll(){
		logger.info("Fiding all livro!");
		return repository.findAll();
	}
	public Livro create(Livro livro) {
		logger.info("creating one livro!");
		return repository.save(livro);
	}

	public Livro update(Livro livro) {
		logger.info("Updating one cliente!");
		var entity = repository.findById(livro.getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		entity.setId(livro.getId());
		entity.setTitulo(livro.getTitulo());
		entity.setAutor(livro.getAutor());
		entity.setIsbn(livro.getIsbn());
		entity.setPreco(livro.getPreco());
		return repository.save(livro);
		
	}

	public void delete(Long id) {
		logger.info("Deleting one cliente!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registo encontrado"));
		repository.delete(entity);
	}
}
