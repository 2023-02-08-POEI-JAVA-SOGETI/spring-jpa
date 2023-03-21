package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;

/**
 * Service pour l'entité Fournisseur.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class FournisseurService {

	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	
	
	
	public List<Fournisseur> findByNom(String nom) {
		return this.fournisseurSpringDao.maMethodeDeRechercheAvecUneQueryExplicite(nom);
	}


	/**
	 * Sauvegarde fournisseur
	 * @param fournisseur
	 * @return 
	 */
	
	
	@Transactional
	public Fournisseur sauvegarde(Fournisseur fournisseur) {
		return this.fournisseurSpringDao.save(fournisseur);
	}
	
	@Transactional
	public void supprimer(Integer id) {
		this.fournisseurSpringDao.deleteById(id);
	}
	
	
	public Fournisseur get(Integer id) {
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}
	
	

	/**
	 * Récupère Fournisseur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	/*
	public Fournisseur findById(Long id) {
		return this.fournisseurSpringDao.findById(id).orElse(null);
	} */
	

	/**
	 * Renvoie tous les Fournisseur présents en base
	 */
	
	/*
	public Iterable<Fournisseur> findAll(){
		return this.fournisseurSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Fournisseur présentes en base
	 * @return
	 */
	
	/*
	public long count() {
		return this.fournisseurSpringDao.count();
	}

	/**
	 * Supprime un Fournisseur par son identifiant.
	 * @param id
	 */
	
	/*
	@Transactional
	public void delete(Long id) {
		this.fournisseurSpringDao.deleteById(id);
	}
*/
}