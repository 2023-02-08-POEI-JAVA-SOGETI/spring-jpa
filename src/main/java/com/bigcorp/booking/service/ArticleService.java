package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.model.Article;

/**
 * Service pour l'entité Article.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleSpringDao articleSpringDao;
	
	
	
	public List<Article> findByNom(String nom) {
		return this.articleSpringDao.maMethodeDeRechercheAvecUneQueryExplicite(nom);
	}
	
	public Article findById(Integer id) {
		return this.articleSpringDao.findById(id).orElse(null);
	}


	/**
	 * Sauvegarde article
	 * @param article
	 * @return 
	 */
	
	
	@Transactional
	public Article sauvegarde(Article article) {
		return this.articleSpringDao.save(article);
	}
	
	@Transactional
	public void supprimer(Integer id) {
		this.articleSpringDao.deleteById(id);
	}
	
	
	public Article get(Integer id) {
		return this.articleSpringDao.findById(id).orElse(null);
	}
	
	

	/**
	 * Récupère Article par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	/*
	public Article findById(Long id) {
		return this.articleSpringDao.findById(id).orElse(null);
	} */
	

	/**
	 * Renvoie tous les Article présents en base
	 */
	
	/*
	public Iterable<Article> findAll(){
		return this.articleSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Article présentes en base
	 * @return
	 */
	
	/*
	public long count() {
		return this.articleSpringDao.count();
	}

	/**
	 * Supprime un Article par son identifiant.
	 * @param id
	 */
	
	/*
	@Transactional
	public void delete(Long id) {
		this.articleSpringDao.deleteById(id);
	}
*/
}