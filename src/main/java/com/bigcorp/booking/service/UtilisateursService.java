package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateursSpringDao;
import com.bigcorp.booking.model.Utilisateurs;



/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class UtilisateursService {

	@Autowired
	private UtilisateursSpringDao utilisateurSpringDao;

	/**
	 * Sauvegarde example
	 * @param example
	 * @return 
	 */
	@Transactional
	public Utilisateurs save(Utilisateurs utilisateur) {
		return this.utilisateurSpringDao.save(utilisateur);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Utilisateurs findById(Integer id) {
		return this.utilisateurSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
	public Iterable<Utilisateurs> findAll(){
		return this.utilisateurSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
	public long count() {
		return this.utilisateurSpringDao.count();
	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		this.utilisateurSpringDao.deleteById(id);
	}

}
