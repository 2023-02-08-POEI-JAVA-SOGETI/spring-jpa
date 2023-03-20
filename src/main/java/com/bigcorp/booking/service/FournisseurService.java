package com.bigcorp.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.ExampleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;

/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class FournisseurService {

	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurService.class);

	/**
	 * Sauvegarde example
	 * @param example
	 */
	@Transactional
	public Fournisseur save(Fournisseur fournisseur) {
		LOGGER.info("save : " + fournisseur.getId() + " - " + fournisseur.getNom());
		return this.fournisseurSpringDao.save(fournisseur);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	@Transactional
	public Fournisseur findById(Integer id) {
		LOGGER.info("findById : " + id);
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
//	public Iterable<Example> findAll(){
//		return this.exampleSpringDao.findAll();
//	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
//	public long count() {
//		return this.exampleSpringDao.count();
//	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void deleteById(Integer id) {
		LOGGER.info("deleteById : " + id);
		this.fournisseurSpringDao.deleteById(id);
	}

}