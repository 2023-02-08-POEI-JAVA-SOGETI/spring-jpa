package com.bigcorp.booking.service;

<<<<<<< HEAD
=======
import java.util.List;


>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSpringDao;
import com.bigcorp.booking.model.Utilisateur;

<<<<<<< HEAD
/**
 * Service pour l'entité Utilisateur.
 */
@Service
public class UtilisateurService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurService.class);

	@Autowired
	private UtilisateurSpringDao utilisateurSpringDao;

	/**
	 * Sauvegarde utilisateur
	 * @param utilisateur
	 * @return l'utilisateur sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument utilisateur
	 */
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		LOGGER.info("Sauvegarde de : {}" , utilisateur);
		return this.utilisateurSpringDao.save(utilisateur);
	}

	/**
	 * Récupère Utilisateur par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Utilisateur findById(Integer id) {
		LOGGER.info("Récupération de utilisateur avec l'id : {}" , id);
		return this.utilisateurSpringDao.findById(id).orElse(null);
	}

	/**
	 * Supprime un Utilisateur par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de utilisateur avec l'id : {}" , id);
		this.utilisateurSpringDao.deleteById(id);
	}

	

}
=======
@Service
public class UtilisateurService {
	@Autowired
	private  UtilisateurSpringDao utilisateurSpringDao ;
	private static final Logger logger = LoggerFactory.getLogger(FournisseurService.class);
	
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		logger.info("Save utilisateur: {}", utilisateur);
		return this.utilisateurSpringDao.save(utilisateur);
	}
	
	public void delete(Integer  id) {
		logger.info("Delete utilisateur: {}", id);
		utilisateurSpringDao.deleteById(id);
	}
	
	public Utilisateur findById(Integer id) {
		logger.info("Find utilisateur: {}", id);
		return utilisateurSpringDao.findById(id).orElse(null);
	}
	
	public Iterable<Utilisateur> ListArticles(){
		logger.info("List utilisateurs:");
		return utilisateurSpringDao.findAll();
	}
	
	public List<Utilisateur> findByName(String name) {
		logger.info("Find utilisateur: {}", name);
		return utilisateurSpringDao.findByNom(name);
	}

	public Iterable<Utilisateur> findAll() {
		return utilisateurSpringDao.findAll();
		}
}
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
