package com.bigcorp.booking.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.ClientRestDto;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;

@RestController
public class ClientRestController {
	private static Logger LOGGER = LoggerFactory.getLogger(ClientRestController.class);

	@Autowired
	ClientService clientService;

	@GetMapping("/clients/{clientId}")
	public ClientRestDto getById(@PathVariable("clientId") Integer clientId) {
		Client client = clientService.getById(clientId);

		if (client == null) {
			LOGGER.info(HttpStatus.NOT_FOUND + ": Customer doesn't exist.");

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No customer with id : " + clientId + " found");
		}

		LOGGER.info(HttpStatus.OK + ": Customer retrieved!");

		return new ClientRestDto(client);
	}

	@PostMapping("/clients")
	public ClientRestDto save(@RequestBody ClientRestDto clientRestDto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			
			for(ObjectError objectError : bindingResult.getAllErrors()) {
				sb.append(objectError.getObjectName()).append(objectError.getDefaultMessage());
			}
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
		}
		
		Client client = new Client();
		
		if(clientRestDto.getId() != 0) {
			client = clientService.getById(clientRestDto.getId());
			
			if(client == null) {
				LOGGER.info(HttpStatus.NOT_FOUND + ": couldn't find customer with ID " + clientRestDto.getId());
				
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "couldn't find customer with ID " + clientRestDto.getId());
			}
		}
		
		clientRestDto.build(client);
		
		try {
			client = clientService.save(client);
			
			clientService.attache(client.getId(), clientRestDto.getUtilisateurId());
			
			LOGGER.info(HttpStatus.OK + ": Customer saved successfully.");	
		} catch(Exception ex) {
			LOGGER.error("Something wrong happened while saving customer");
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect customer requested");
		}
		
		return new ClientRestDto(this.clientService.getById(client.getId()));
	}

	
	@DeleteMapping("/clients/{clientId}")
	public ResponseEntity<?> deleteById(@PathVariable("clientId") Integer clientId) {

		if (clientService.getById(clientId) == null) {
			LOGGER.info(HttpStatus.NOT_FOUND + ": Customer with ID " + clientId + " doesn't exist");
		}

		LOGGER.info(HttpStatus.OK + ": Customer deleted successfully!");

		clientService.delete(clientId);

		return ResponseEntity.ok().body("Customer " + clientId + " was successfully removed.");
	}

	@RequestMapping("/clients")
	public String showClients() {
		LOGGER.info("Controller is working.");

		return "clients";
	}
}
