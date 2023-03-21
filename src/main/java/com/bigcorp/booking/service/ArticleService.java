package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleDao;
import com.bigcorp.booking.model.Article;

/**
 * Service pour l'entité Article.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	/**
	 * Sauvegarde article
	 * @param article
	 */
	@Transactional
	public Article save(Article article) {
		return this.articleDao.save(article);
	}

	/**
	 * Récupère Article par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Article findById(Integer id) {
		return this.articleDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Article présents en base
	 */
	public Iterable<Article> findAll(){
		return this.articleDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Article présentes en base
	 * @return
	 */
	public long count() {
		return this.articleDao.count();
	}

	/**
	 * Supprime un Article par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		this.articleDao.deleteById(id);
	}

	/**
	 * Récupère Article par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	

}