package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientSpringDao;

import tp_spring_jpa_pablo.model.Client;

@Service
public class ClientService {
	
	@Autowired
	private ClientSpringDao clientSpringDao;
	
	public Iterable<Client> findAll(){
		return this.clientSpringDao.findAll();
	}
	
	@Transactional
	public Client save(Client client) {
		return this.clientSpringDao.save(client);
	}
	
	public Client findById(Integer id) {
		return this.clientSpringDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		this.clientSpringDao.deleteById(id);
	}	
	
	// Crée dans le cours
	public Iterable<Client> findByNom(String nomClient) {
	    return clientSpringDao.findByNom(nomClient);
	}


}
