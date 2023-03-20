package com.bigcorp.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSpringDao;
import com.bigcorp.booking.model.Utilisateur;

@Service
public class UtilisateurService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired
	private UtilisateurSpringDao utilisateurSpringDao;
	
	/**
	 * Sauvegarde example
	 * @param utilisateur
	 */
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		LOGGER.info("Appelle méthode save() de UtilisateurService.java");
		return this.utilisateurSpringDao.save(utilisateur);
	}
	
	/**
	 * Récupère Utilisateur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Utilisateur findById(Integer id) {
		LOGGER.info("Appelle méthode findById() de UtilisateurService.java");
		return this.utilisateurSpringDao.findById(id).orElse(null);
	}
	
	/**
	 * Supprime un Utilisateur par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Appelle méthode delete() de UtilisateurService.java");
		this.utilisateurSpringDao.deleteById(id);
	}
	
	/**
	 * Récupère Utilisateur par son nom, ou null
	 * si aucune ligne ne correspond en base.
	 * @param nom
	 * @return
	 */
	public List<Utilisateur> findByNom(String nom) {
		LOGGER.info("Appelle méthode findByNom() de UtilisateurService.java");
		return this.utilisateurSpringDao.findUtilisateurByName(nom);
	}
}
