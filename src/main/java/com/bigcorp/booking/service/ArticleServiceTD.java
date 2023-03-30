package com.bigcorp.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDaoTD;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;

/**
 * Service pour l'entité Article.
 */
@Service
public class ArticleServiceTD {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceTD.class);

	@Autowired
	private ArticleSpringDaoTD articleSpringDaoTD;

	/**
	 * Sauvegarde article
	 * @param article
	 * @return l'article sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument article
	 */
	@Transactional
	public Article save(Article article) {
		LOGGER.info("Sauvegarde de : {}" , article);
		return this.articleSpringDaoTD.save(article);
	}

	/**
	 * Récupère Article par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Article findById(Integer id) {
		LOGGER.info("Récupération de article avec l'id : {}" , id);
		return this.articleSpringDaoTD.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Article présents en base
	 */
	public Iterable<Article> findAll(){
		LOGGER.info("Récupération de tous les articles");
		return this.articleSpringDaoTD.findAll();
	}
	

	/**
	 * Supprime un Article par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de article avec l'id : {}" , id);
		this.articleSpringDaoTD.deleteById(id);
	}


	/**
	 * Récupère des articles selon leur état.
	 * La liste des articles est triée par nom.
	 * @param etat
	 * @return la liste des articles triée par nom
	 */
	public List<Article> findByEtat(EtatArticle etat) {
		LOGGER.info("Récupération des articles avec l'état: {}" , etat);
		return this.articleSpringDaoTD.findByEtatArticleOrderByNom(etat);
	}
	

	//doit être persisté en base. Si l'identifiant d'article est null : 
	//une exception est lancée. Si l'identifiant du fournisseur est null,
	//l'article n'est plus rattaché à aucun fournisseur (si votre BDD le permet). 
	//La méthode renvoie l'article modifié en base. La méthode doit être 
	//testée avec un test JUnit.

	}

