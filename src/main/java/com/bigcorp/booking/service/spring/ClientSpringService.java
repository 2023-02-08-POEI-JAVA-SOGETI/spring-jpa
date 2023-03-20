package com.bigcorp.booking.service.spring;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientSpringDao;

import com.bigcorp.booking.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ClientSpringService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientSpringService.class);
	@Autowired
	private ClientSpringDao clientSpringDao;

	@Transactional
	public void save(Client client) {
		LOGGER.info("Saving");
		this.clientSpringDao.save(client);
		LOGGER.info("Saved");
	}

	public Client findById(Integer id) {
		LOGGER.info("Searching");
		return this.clientSpringDao.findById(id).orElse(null);
	}

	public List<Client> findContainingName(String name) {
		LOGGER.info("Searching");
		return this.clientSpringDao.findByNomContaining(name);
	}

	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Deleting");
		this.clientSpringDao.deleteById(id);
		LOGGER.info("Deleted");
	}
}
