package com.bigcorp.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;

@Service
public class FournisseurService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	
	/**
	 * Sauvegarde example
	 * @param fournisseur
	 */
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		LOGGER.info("Appelle méthode save() de FournisseurService.java");
		return this.fournisseurSpringDao.save(fournisseur);
	}
	
	/**
	 * Récupère Fournisseur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Fournisseur findById(Integer id) {
		LOGGER.info("Appelle méthode findById() de FournisseurService.java");
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}
	
	/**
	 * Supprime un Fournisseur par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Appelle méthode delete() de FournisseurService.java");
		this.fournisseurSpringDao.deleteById(id);
	}
	
	/**
	 * Récupère Fournisseur par son nom, ou null
	 * si aucune ligne ne correspond en base.
	 * @param nom
	 * @return
	 */
	public List<Fournisseur> findByNom(String nom) {
		LOGGER.info("Appelle méthode findByNom() de ArticleService.java");
		return this.fournisseurSpringDao.findFournisseurByName(nom);
	}
}
