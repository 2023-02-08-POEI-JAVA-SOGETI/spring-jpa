package com.bigcorp.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;

/**
 * Service pour l'entité Fournisseur.
 */
@Service
public class NPMFournisseurService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NPMFournisseurService.class);
	
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;

	/**
	 * Sauvegarde fournisseur
	 * @param fournisseur
	 * @return le fournisseur sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument fournisseur
	 */
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		LOGGER.info("Sauvegarde de : {}" , fournisseur);
		return this.fournisseurSpringDao.save(fournisseur);
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