package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientSpringDao;
import com.bigcorp.booking.model.Client;

/**
 * Service pour l'entité Client.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class ClientService {

	@Autowired
	private ClientSpringDao clientSpringDao;
	
	
	
	public List<Client> findByNom(String nom) {
		return this.clientSpringDao.MaMethodeDeRechercheAvecUneQueryExplicite(nom);
	}


	/**
	 * Sauvegarde client
	 * @param client
	 * @return 
	 */
	
	
	@Transactional
	public Client sauvegarde(Client client) {
		return this.clientSpringDao.save(client);
	}
	
	@Transactional
	public void supprimer(Integer id) {
		this.clientSpringDao.deleteById(id);
	}
	
	@Transactional
	public Client get(Integer id) {
		return this.clientSpringDao.findById(id).orElse(null);
	}
	
	
	

	/**
	 * Récupère Client par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	/*
	public Client findById(Long id) {
		return this.clientSpringDao.findById(id).orElse(null);
	} */
	

	/**
	 * Renvoie tous les Client présents en base
	 */
	
	/*
	public Iterable<Client> findAll(){
		return this.clientSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Client présentes en base
	 * @return
	 */
	
	/*
	public long count() {
		return this.clientSpringDao.count();
	}

	/**
	 * Supprime un Client par son identifiant.
	 * @param id
	 */
	
	/*
	@Transactional
	public void delete(Long id) {
		this.clientSpringDao.deleteById(id);
	}
*/
}