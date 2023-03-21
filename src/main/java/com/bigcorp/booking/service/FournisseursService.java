package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseursSpringDao;
import com.bigcorp.booking.model.Fournisseurs;

/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class FournisseursService {

	@Autowired
	private FournisseursSpringDao fournisseurSpringDao;

	/**
	 * Sauvegarde example
	 * @param example
	 */
	@Transactional
	public void save(Fournisseurs fournisseur) {
		this.fournisseurSpringDao.save(fournisseur);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Fournisseurs findById(Integer id) {
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
	public Iterable<Fournisseurs> findAll(){
		return this.fournisseurSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
	public long count() {
		return this.fournisseurSpringDao.count();
	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		this.fournisseurSpringDao.deleteById(id);
	}

}
