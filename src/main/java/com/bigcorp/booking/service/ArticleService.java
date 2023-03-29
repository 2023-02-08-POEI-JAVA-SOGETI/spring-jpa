package com.bigcorp.booking.service;

import java.util.List;

import javax.persistence.PersistenceException;

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
import com.bigcorp.booking.service.exception.ArticleException;

/**
 * Service pour l'entité Article. Contient de nombreux appels passés au DAO pour
 * illustrer les capacités de Spring Data JPA
 */
@Service
public class ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleSpringDao articleSpringDao;
	private FournisseurSpringDao fournisseurSpringDao;

	public List<Article> findByNom(String nom) {
		return this.articleSpringDao.maMethodeDeRechercheAvecUneQueryExplicite(nom);
	}

	public Article findById(Integer id) {
		return this.articleSpringDao.findById(id).orElse(null);
	}

	public List<Article> findByEtatArticle(EtatArticle etatArticle) {
		return this.articleSpringDao.maMethodeDeRechercheAvecUneQueryExplicite2(etatArticle);
	}

	@Transactional
	public void attache(Integer articleId, Integer fournisseurId) {
		// Récupérer l'objet Article correspondant à l'ID articleId
		Article article = articleSpringDao.findById(articleId)
				.orElseThrow(() -> new IllegalArgumentException("L'article avec l'ID " + articleId + " n'existe pas."));

		// Récupérer l'objet Fournisseur correspondant à l'ID fournisseurId
		Fournisseur fournisseur = fournisseurSpringDao.findById(fournisseurId).orElseThrow(
				() -> new IllegalArgumentException("Le fournisseur avec l'ID " + fournisseurId + " n'existe pas."));

		// Ajouter l'objet Fournisseur à l'objet Article
		article.setFournisseur(fournisseur);

		// Enregistrer les modifications dans la base de données
		articleSpringDao.save(article);
	}

	/**
	 * Sauvegarde article
	 * 
	 * @param article
	 * @return
	 */

	@Transactional
	public Article sauvegarde(Article article) throws ArticleException {
		LOGGER.info("Sauvegarde de : {}", article);
		try {
			return this.articleSpringDao.save(article);
		} catch (PersistenceException exception) {
			throw new ArticleException(exception);
		}
	}

	@Transactional
	public void supprimer(Integer id) {
		this.articleSpringDao.deleteById(id);
	}

	public Article get(Integer id) {
		return this.articleSpringDao.findById(id).orElse(null);
	}

	/**
	 * Récupère Article par son id, ou null si aucune ligne ne correspond en base.
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * public Article findById(Long id) { return
	 * this.articleSpringDao.findById(id).orElse(null); }
	 */

	/**
	 * Renvoie tous les Article présents en base
	 */

	/*
	 * public Iterable<Article> findAll(){ return this.articleSpringDao.findAll(); }
	 * 
	 * /** Compte toutes les lignes d'Article présentes en base
	 * 
	 * @return
	 */

	/*
	 * public long count() { return this.articleSpringDao.count(); }
	 * 
	 * /** Supprime un Article par son identifiant.
	 * 
	 * @param id
	 */

	/*
	 * @Transactional public void delete(Long id) {
	 * this.articleSpringDao.deleteById(id); }
	 */
}