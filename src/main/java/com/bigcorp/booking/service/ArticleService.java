package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.ExampleSpringDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Example;
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

	/**
	 * Sauvegarde example
	 * @param example
	 */
	@Transactional
	public Article save(Article article) {
		return this.articleSpringDao.save(article);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Article findById(Integer id) {
		return this.articleSpringDao.findById(id).orElse(null);
	}

	
	public List<Article> findByFournisseurId(Integer id){
		return this.articleSpringDao.findbyFournisseur(id);
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
		this.articleSpringDao.deleteById(id);
	}

}