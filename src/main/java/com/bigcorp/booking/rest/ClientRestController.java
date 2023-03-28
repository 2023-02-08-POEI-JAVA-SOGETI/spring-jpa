package com.bigcorp.booking.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.ClientDto;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;

@RestController
public class ClientRestController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/restClient/{clientId}")
	public ClientDto getById(@PathVariable("clientId") Integer clientId) {
	    Client client = clientService.findById(clientId);
	    if (client == null) {
	        throw new ResponseStatusException(
	            HttpStatus.NOT_FOUND, "Client not found with ID: " + clientId);
	    }
	    ClientDto clientDto = new ClientDto(client);
	    return clientDto;
	}
	
	@GetMapping("/restClients")
	public List<ClientDto> getAllClient() {
		List<Client> clients =  clientService.findAll();
		List<ClientDto> clientDtos = new ArrayList<>();
		for (Client client : clients) {
			clientDtos.add(new ClientDto(client));
		}
		return clientDtos;
	}
	
	@DeleteMapping("/restClient/{clientId}/delete")
	public void deleteById(@PathVariable("clientId") Integer clientId) {
		clientService.delete(clientId);
	}
	
	@PostMapping("/restClient/{clientId}")
	public ClientDto save(@RequestBody ClientDto clientDto, @PathVariable("clientId") Integer clientId) {
	    Client client = new Client(clientDto);
	    client.setId(clientId);	
	    client = clientService.save(client);
	    return new ClientDto(client);
	}
}