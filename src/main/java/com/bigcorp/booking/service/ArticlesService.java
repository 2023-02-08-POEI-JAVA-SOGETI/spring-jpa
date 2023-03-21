package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticlesSpringDao;
import com.bigcorp.booking.model.Articles;


/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Service
public class ArticlesService {


	@Autowired

	private ArticlesSpringDao articleSpringDao;
	/**
	 * Sauvegarde example
	 * @param example
	 * @return 
	 */
	@Transactional
	public Articles save(Articles article) {
		return this.articleSpringDao.save(article);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Articles findById(Integer id) {
		return this.articleSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
	public Iterable<Articles> findAll(){
		return this.articleSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
	public long count() {
		return this.articleSpringDao.count();
	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		this.articleSpringDao.deleteById(id);
	}

//	public Articles update(Integer id) {
//		// TODO Auto-generated method stub
//		return this.articleSpringDao.save(articleToUpdate);
//	}

}
