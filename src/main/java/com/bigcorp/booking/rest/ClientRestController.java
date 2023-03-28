package com.bigcorp.booking.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Logger logger = LoggerFactory.getLogger(ClientRestController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping("/restClient/{clientId}")
    public ResponseEntity<ClientDto> getById(@PathVariable("clientId") Integer clientId) {
        logger.info("Récupération du client par ID: {}", clientId);
        Client client = clientService.findById(clientId);
        if (client == null) {
            logger.warn("Client non trouvé avec l'ID: {}", clientId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé avec l'ID: " + clientId);
        }
        ClientDto clientDto = new ClientDto(client);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping("/restClients")
    public ResponseEntity<List<ClientDto>> getAllClient() {
        logger.info("Récupération de tous les clients");
        List<Client> clients = clientService.findAll();
        List<ClientDto> clientsDto = new ArrayList<>();
        for (Client client : clients) {
            clientsDto.add(new ClientDto(client));
        }
        return ResponseEntity.ok(clientsDto);
    }

    @DeleteMapping("/restClient/{clientId}/delete")
    public void deleteById(@PathVariable("clientId") Integer clientId) {
        logger.info("Suppression du client par ID: {}", clientId);
        Client client = clientService.findById(clientId);
        if (client == null) {
            logger.warn("Client non trouvé avec l'ID: {}", clientId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé avec l'ID: " + clientId);
        }
        clientService.delete(clientId);
    }

    @PostMapping("/restClient")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        logger.info("Enregistrement d'un nouveau client");
        if (clientDto.getId() != null) {
            logger.warn("Un nouveau client ne peut pas déjà avoir un ID");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Un nouveau client ne peut pas déjà avoir un ID");
        }
        Client client = new Client(clientDto);
        client = clientService.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientDto(client));
    }
}