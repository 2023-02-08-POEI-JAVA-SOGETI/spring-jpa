package com.bigcorp.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;


/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleSpringDao articleSpringDao;
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	/**
	 * Sauvegarde example
	 * @param example
	 */
	@Transactional
	public Article save(Article article) {
		LOGGER.info("save : " + article.getId() + " - " + article.getNom());
		return this.articleSpringDao.save(article);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	@Transactional
	public Article findById(Integer id) {
		LOGGER.info("findById : " + id);
		return this.articleSpringDao.findById(id).orElse(null);
	}

	@Transactional
	public List<Article> findByFournisseurId(Integer id){
		LOGGER.info("findByFournisseurId : " +id);
		return this.articleSpringDao.findbyFournisseur(id);
	}
	/**
	 * Renvoie tous les Example présents en base
	 */
//	public Iterable<Example> findAll(){
//		return this.exampleSpringDao.findAll();
//	}
	
	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void deleteById(Integer id) {
		LOGGER.info("deleteById :" +id);
		this.articleSpringDao.deleteById(id);
	}
	

	@Transactional
	public Article saveArticleAndFournisseur (Integer idArticle, Integer idFournisseur) throws NullPointerException {

		LOGGER.info("saveArticleAndFournisseur : idArticle=" + idArticle + " - idFournisseur=" + idFournisseur);
		Article a = this.articleSpringDao.findById(idArticle).orElseThrow(NullPointerException::new);
		
		Fournisseur f = this.fournisseurSpringDao.findById(idFournisseur).orElse(null);
		if (f == null) {
			a.setFournisseur(null);
			return this.articleSpringDao.save(a);
		}
		
		// association du fournisseur à l'article
		LOGGER.info("saveArticleAndFournisseur : association article et fournisseur");
		a.setFournisseur(f);

		LOGGER.info("saveArticleAndFournisseur : persistence de l'article");
		return this.articleSpringDao.save(a);
	}

}