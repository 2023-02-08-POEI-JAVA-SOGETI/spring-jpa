package com.bigcorp.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientSpringDao;
import com.bigcorp.booking.model.Client;

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
		
		public void delete(Long  id) {
			logger.info("Delete client: {}", id);
			clientSpringDao.deleteById(id);
		}
		
		public Optional<Client> findById(Long id) {
			logger.info("find client: {}", id);
			return clientSpringDao.findById(id);
		}
		
		public Iterable<Client> ListArticles(){
			logger.info("list clients: ");
			return clientSpringDao.findAll();
		}
		
		public List<Client> findByName(String name) {
			logger.info("find client: {}", name);
			return clientSpringDao.findByNom(name);
		}

		public Iterable<Client> findAll() {
			return clientSpringDao.findAll();
		}
}
