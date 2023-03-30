package com.bigcorp.booking.service;

import com.bigcorp.booking.dao.spring.ClientDao;
import com.bigcorp.booking.dao.spring.UtilisateurDao;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Utilisateur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientDao clientDao;
	
	@Autowired UtilisateurDao utilisateurDao;

	@Transactional
	public Client save(Client client) {
        LOGGER.info("Client successfully saved!");

		return this.clientDao.save(client);
	}

	@Transactional
	public void delete(int id) {
		if (id != 0) {
			this.clientDao.deleteById(id);
			LOGGER.info("Client successfully removed!");
		} else
			LOGGER.info("Client couldn't be removed.");
	}

	@Transactional
	public Client getById(int id) {
		if (id == 0)
			return null;

		return this.clientDao.findById(id).orElse(null);
	}

	@Transactional
	public List<Client> getByName(String name) {
		if (name == "")
			return null;

		List<Client> clients = this.clientDao.findByName(name);

		return clients.isEmpty() ? null : clients;
	}
	
	public Client attache(Integer clientId, Integer utilisateurId) {
		LOGGER.info("Rattachement du client : {} avec l'utilisateur: {} " , clientId, utilisateurId);
		
		if(clientId == null) {
			throw new IllegalArgumentException("articleId ne peut être null");
		}
		
		Optional<Client> optionalClient = this.clientDao.findById(clientId);
		
		Client client = optionalClient.orElse(null);
		
		Utilisateur utilisateur = null;
		
		if(utilisateurId != null) {
			utilisateur = utilisateurDao.findById(utilisateurId).orElse(null);			
		}
		
		client.setUtilisateur(utilisateur);
		
		return this.clientDao.save(client);
		
	}
	
}
