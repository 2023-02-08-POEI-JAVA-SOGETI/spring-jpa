package com.bigcorp.booking.service;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
import java.util.List;


>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientSpringDao;
import com.bigcorp.booking.model.Client;

<<<<<<< HEAD
/**
 * Service pour l'entité Client.
 */
@Service
public class ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired
	private ClientSpringDao clientSpringDao;

	/**
	 * Sauvegarde client
	 * @param client
	 * @return le client sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument client
	 */
	@Transactional
	public Client save(Client client) {
		LOGGER.info("Sauvegarde de : {}" , client);
		return this.clientSpringDao.save(client);
	}

	/**
	 * Récupère Client par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Client findById(Integer id) {
		LOGGER.info("Récupération de client avec l'id : {}" , id);
		return this.clientSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Client présents en base
	 */
	public Iterable<Client> findAll(){
		LOGGER.info("Récupération de tous les clients");
		return this.clientSpringDao.findAll();
	}
	
	/**
	 * Supprime un Client par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de client avec l'id : {}" , id);
		this.clientSpringDao.deleteById(id);
	}

	

}
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class ClientService {
		@Autowired
		private  ClientSpringDao clientSpringDao ;
		private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

		
		@Transactional
		public Client save(Client client) {
			logger.info("Saving client: {}", client);
			return this.clientSpringDao.save(client);
		}
		
		public void delete(Integer  id) {
			logger.info("Delete client: {}", id);
			clientSpringDao.deleteById(id);
		}
		
		public Client findById(Integer id) {
			logger.info("find client: {}", id);
			return clientSpringDao.findById(id).orElse(null);
		}
		
		public Iterable<Client> ListArticles(){
			logger.info("list clients: ");
			return clientSpringDao.findAll();
		}
		
		public List<Client> findByName(String name) {
			logger.info("find client: {}", name);
			return clientSpringDao.findByNom(name);
		}

		public List<Client> findAll() {
			return (List<Client>) clientSpringDao.findAll();
		}
}
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
