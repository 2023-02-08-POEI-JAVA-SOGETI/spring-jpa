package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurDao;
import com.bigcorp.booking.model.Fournisseur;

/**
 * Service pour l'entité Fournisseur.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class FournisseurService {

	@Autowired
	private FournisseurDao fournisseurDao;

	/**
	 * Sauvegarde fournisseur
	 * @param fournisseur
	 */
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		return this.fournisseurDao.save(fournisseur);
	}

	/**
	 * Récupère Fournisseur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Fournisseur findById(Integer id) {
		return this.fournisseurDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Fournisseur présents en base
	 */
	public Iterable<Fournisseur> findAll(){
		return this.fournisseurDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Fournisseur présentes en base
	 * @return
	 */
	public long count() {
		return this.fournisseurDao.count();
	}

	/**
	 * Supprime un Fournisseur par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		this.fournisseurDao.deleteById(id);
	}

	/**
	 * Récupère Fournisseur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	

}