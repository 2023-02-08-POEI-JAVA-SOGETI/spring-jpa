package com.bigcorp.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.model.Article;

@Service
public class ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ArticleSpringDao articleSpringDao;
	
	/**
	 * Sauvegarde example
	 * @param article
	 */
	@Transactional
	public Article save(Article article) {
		LOGGER.info("Appelle méthode save() de ArticleService.java");
		return this.articleSpringDao.save(article);
	}
	
	/**
	 * Récupère Article par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Article findById(Integer id) {
		LOGGER.info("Appelle méthode findById() de ArticleService.java");
		return this.articleSpringDao.findById(id).orElse(null);
	}
	
	/**
	 * Supprime un Article par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Appelle méthode delete() de ArticleService.java");
		this.articleSpringDao.deleteById(id);
	}
	
	/**
	 * Récupère Article par son nom, ou null
	 * si aucune ligne ne correspond en base.
	 * @param nom
	 * @return
	 */
	public List<Article> findByNom(String nom) {
		LOGGER.info("Appelle méthode findByNom() de ArticleService.java");
		return this.articleSpringDao.findArticleByName(nom);
	}
	
	//METHODE BONUS A COMPLETERE
//	public Article persistArticleWithFournisseur(Integer idArticle, Integer idFournisseur) {	
//		return Article ;
//	}
}
