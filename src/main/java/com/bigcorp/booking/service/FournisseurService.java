package com.bigcorp.booking.service;

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
 */
@Service
public class FournisseurService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurService.class);
	
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;

	/**
	 * Sauvegarde fournisseur
	 * @param fournisseur
	 * @return le fournisseur sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument fournisseur
	 * @throws FournisseurException 
	 */
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) throws FournisseurException {
		LOGGER.info("Sauvegarde de : {}" , fournisseur);
		try {
			return this.fournisseurSpringDao.save(fournisseur);
		}catch(PersistenceException exception) {
			throw new FournisseurException(exception);
		}
	}

	/**
	 * Récupère Fournisseur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Fournisseur findById(Integer id) {
		LOGGER.info("Récupération de fournisseur avec l'id : {}" , id);
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Fournisseur présents en base
	 */
	public Iterable<Fournisseur> findAll(){
		LOGGER.info("Récupération de tous les fournisseurs");
		return this.fournisseurSpringDao.findAll();
	}
	
	/**
	 * Supprime un Fournisseur par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de fournisseur avec l'id : {}" , id);
		this.fournisseurSpringDao.deleteById(id);
	}

}