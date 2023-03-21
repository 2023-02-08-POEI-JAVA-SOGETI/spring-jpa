package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientDao;
import com.bigcorp.booking.model.Client;


// Service pour l'entité Client.
// Contient de nombreux appels passés au DAO pour illustrer les capacités de Spring Data JPA
@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	// Sauvegarde client

	@Transactional
	public Client save(Client client) {
		return this.clientDao.save(client);
	}

	 // Récupère Client par son id, ou null

	public Client findById(Integer id) {
		return this.clientDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Client présents en base
	 */
	public Iterable<Client> findAll(){
		return this.clientDao.findAll();
	}
	

	 //Compte toutes les lignes d'Client présentes en base

	public long count() {
		return this.clientDao.count();
	}

	 // Supprime un Client par son identifiant.

	@Transactional
	public void delete(Integer id) {
		this.clientDao.deleteById(id);
	}


	

}