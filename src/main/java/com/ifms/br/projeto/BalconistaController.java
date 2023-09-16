package com.ifms.br.projeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balconista")
public class BalconistaController {

	@Autowired
	private BalconistaService service;
	
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Balconista findById (@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id);
	}
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Balconista> findAll () {
		return service.findAll();
	}
	@RequestMapping(method=RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Balconista create (@RequestBody Balconista balconista){
		return service.create(balconista);
	}
	@RequestMapping(method=RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Balconista update (@RequestBody Balconista balconista){
		return service.update(balconista);
	}
}
