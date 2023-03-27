package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.mvc.rest.dto.ClientRestDto;
import com.bigcorp.booking.service.ClientService;

import tp_spring_jpa_pablo.model.Client;

@RestController
public class ClientRestControleur {   
    
	@Autowired
    private ClientService clientService;
	
	@GetMapping("/client/get/{clientid}")
	public ClientRestDto getByIdPath(@PathVariable("clientid") Integer clientid) {
		Client client = clientService.findById(clientid);
		if (client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun client trouvé avec l'id : "
					+ clientid);
		}
		return new ClientRestDto(client);
	}	
    
	@GetMapping("/client/get")
	public ClientRestDto getByIdParameter(@RequestParam("id") Integer id) {
		Client client = clientService.findById(id);
		if (client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun client trouvé avec l'id : "
					+ id);
		}
		return new ClientRestDto(client);
	}
	
	@PostMapping("/client/save")
	public ClientRestDto saveClient(@RequestBody ClientRestDto clientRestDto) {
		Client client = new Client();
	    client = clientRestDto.remplisClient(client);
	    client = clientService.save(client);
	    return new ClientRestDto(client);
	}

	@DeleteMapping("/client/delete/{clientid}")
	public void deleteClient(@PathVariable("clientid") Integer clientid) {
		Client client = clientService.findById(clientid);
		if (client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun client trouvé avec l'id : "
					+ clientid);
		}
		clientService.deleteById(clientid);
	}
    
}