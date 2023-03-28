package com.bigcorp.booking.service;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
import java.util.List;

>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;

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
=======
import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Fournisseur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	@SuppressWarnings("unused")
	@Autowired
	private  ArticleSpringDao articleSpringDao;
	private static final Logger logger = LoggerFactory.getLogger(FournisseurService.class);
	
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		logger.info("Save fournisseur: {}", fournisseur);
		return this.fournisseurSpringDao.save(fournisseur);
	}
	
	public void delete(Integer  id) {
		logger.info("Delete fournisseur: {}", id);
		fournisseurSpringDao.deleteById(id);
	}
	
	public Fournisseur findById(Integer id) {
		logger.info("Find fournisseur: {}", id);
		return fournisseurSpringDao.findById(id).orElse(null);
	}
	
	public Iterable<Fournisseur> findAll(){
		logger.info("list fournisseurs: ");
		return fournisseurSpringDao.findAll();
	}
	
	public List<Fournisseur> findByName(String name) {
		logger.info("Find fournisseur: {}", name);
		return fournisseurSpringDao.findByNom(name);
	}
	
	public Fournisseur findByIdWithArticles(Integer id) {
		logger.info("Find fournisseur: {}", id);
		return fournisseurSpringDao.findByIdWithArticles(id);
	}

}
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
