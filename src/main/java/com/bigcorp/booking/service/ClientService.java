package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientSDao;

import tp_spring_jpa_pablo.model.Client;

@Service
public class ClientService {
	
	@Autowired
	private ClientSDao clientSDao;
	
	public Iterable<Client> findAll(){
		return this.clientSDao.findAll();
	}
	
	@Transactional
	public Client save(Client client) {
		return this.clientSDao.save(client);
	}
	
	public Client findById(Integer id) {
		return this.clientSDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		this.clientSDao.deleteById(id);
	}	
	
	// Crée dans le cours
	public void findByNom(String nomClient) {
		this.clientSDao.findByNom(nomClient);
	}

}
