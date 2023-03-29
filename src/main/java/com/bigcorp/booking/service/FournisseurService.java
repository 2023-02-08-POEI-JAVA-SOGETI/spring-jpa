package com.bigcorp.booking.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.exception.FournisseurException;

/**
 * Service pour l'entité Fournisseur.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class FournisseurService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurService.class);

	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	
	
	
	public FournisseurService() {
		super();
	}

	public List<Fournisseur> findByNom(String nom) {
		return this.fournisseurSpringDao.maMethodeDeRechercheAvecUneQueryExplicite(nom);
	}
	
	public Fournisseur findById(Integer id) {
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}


	/**
	 * Sauvegarde fournisseur
	 * @param fournisseur
	 * @return 
	 */
	
	
	@Transactional
	public Fournisseur sauvegarde(Fournisseur fournisseur) throws FournisseurException {
		LOGGER.info("Sauvegarde de : {}" , fournisseur);
		try {
			return this.fournisseurSpringDao.save(fournisseur);
		}catch(PersistenceException exception) {
			throw new FournisseurException(exception);
		}
	}
	
	
	@Transactional
	public void supprimer(Integer id) {
		this.fournisseurSpringDao.deleteById(id);
	}
	
	
	public Fournisseur get(Integer id) {
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}


	public Iterable<Fournisseur> findAll() {
		
		return this.fournisseurSpringDao.findAll();
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