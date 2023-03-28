package com.bigcorp.booking.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseur;

/**
 * Service pour l'entité Article.
 */
@Service
public class ArticleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleSpringDao articleSpringDao;
	
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;

	/**
	 * Sauvegarde article
	 * @param article
	 * @return l'article sauvegardé : instance à utiliser car
	 * potentiellement différente de l'argument article
	 */
	@Transactional
	public Article save(Article article) {
		LOGGER.info("Sauvegarde de : {}" , article);
		return this.articleSpringDao.save(article);
	}

	/**
	 * Récupère Article par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Article findById(Integer id) {
		LOGGER.info("Récupération de article avec l'id : {}" , id);
		return this.articleSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Article présents en base
	 */
	public Iterable<Article> findAll(){
		LOGGER.info("Récupération de tous les articles");
		return this.articleSpringDao.findAll();
	}
	

	/**
	 * Supprime un Article par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Suppression de article avec l'id : {}" , id);
		this.articleSpringDao.deleteById(id);
	}


	/**
	 * Récupère des articles selon leur état.
	 * La liste des articles est triée par nom.
	 * @param etat
	 * @return la liste des articles triée par nom
	 */
	public List<Article> findByEtat(EtatArticle etat) {
		LOGGER.info("Récupération des articles avec l'état: {}" , etat);
		return this.articleSpringDao.findByEtatArticleOrderByNom(etat);
	}
	

	//doit être persisté en base. Si l'identifiant d'article est null : 
	//une exception est lancée. Si l'identifiant du fournisseur est null,
	//l'article n'est plus rattaché à aucun fournisseur (si votre BDD le permet). 
	//La méthode renvoie l'article modifié en base. La méthode doit être 
	//testée avec un test JUnit.

	/**
	 * Attache l'article avec l'id articleId au fournisseur avec
	 * l'id fournisseurId. idARticle est non null et correspond à 
	 * un Article en base,sinon, une Exception est lancée
	 * @param articleId
	 * @param fournisseurId
	 * @return
	 * @throws IllegalArgumentException si articleId est null
	 * @throws NoSuchElementException si articleId ne correspond à rien en base de données
	 */
	public Article attache(Integer articleId, Integer fournisseurId) {
		LOGGER.info("Rattachement de l'article : {} avec le fournisseur : {} " , articleId, fournisseurId);
		if(articleId == null) {
			throw new IllegalArgumentException("articleId ne peut être null");
		}
		Optional<Article> optionalArticle = this.articleSpringDao.findById(articleId);
		Article article = optionalArticle.orElse(null);
		
		Fournisseur fournisseur = null;
		if(fournisseurId != null) {
			fournisseur = fournisseurSpringDao.findById(fournisseurId).orElse(null);			
		}
		article.setFournisseur(fournisseur);
		
		return this.articleSpringDao.save(article);
		
	}
	

}