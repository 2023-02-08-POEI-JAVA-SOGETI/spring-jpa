package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ClientsSpringDao;
import com.bigcorp.booking.model.Clients;


/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class ClientsService {

	@Autowired
	private ClientsSpringDao clientSpringDao;

	/**
	 * Sauvegarde example
	 * @param example
	 * @return 
	 */
	@Transactional
	public Clients save(Clients client) {
		return this.clientSpringDao.save(client);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Clients findById(Long id) {
		return this.clientSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
	public Iterable<Clients> findAll(){
		return this.clientSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
	public long count() {
		return this.clientSpringDao.count();
	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		this.clientSpringDao.deleteById(id);
	}

}