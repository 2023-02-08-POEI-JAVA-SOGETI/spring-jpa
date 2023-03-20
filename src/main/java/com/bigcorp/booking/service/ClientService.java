package com.bigcorp.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientSpringDao;
import com.bigcorp.booking.model.Client;




@Service
public class ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientSpringDao clientSpringDao;
	
	/**
	 * Sauvegarde example
	 * @param client
	 */
	@Transactional
	public Client save(Client client) {
		LOGGER.info("Appelle méthode save() de ClientService.java");
		return this.clientSpringDao.save(client);
	}
	
	/**
	 * Récupère Client par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Client findById(Integer id) {
		LOGGER.info("Appelle méthode findById() de ClientService.java");
		return this.clientSpringDao.findById(id).orElse(null);
	}
	
	/**
	 * Supprime un Client par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Appelle méthode delete() de ClientService.java");
		this.clientSpringDao.deleteById(id);
	}
	
	/**
	 * Récupère Client par son nom, ou null
	 * si aucune ligne ne correspond en base.
	 * @param nom
	 * @return
	 */
	public List<Client> findByNom(String nom) {
		LOGGER.info("Appelle méthode findByNom() de ClientService.java");
		return this.clientSpringDao.findClientByName(nom);
	}
}
