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

	@Transactional
	public Article save(Article article) {
		LOGGER.info("save : " + article.getId() + " - " + article.getNom());
		return this.articleSpringDao.save(article);
	}

	public Article findById(Integer id) {
		LOGGER.info("findById : " + id);
		return this.articleSpringDao.findById(id).orElse(null);
	}

	public List<Article> findByFournisseurId(Integer id){
		LOGGER.info("findByFournisseurId : " +id);
		return this.articleSpringDao.findbyFournisseur(id);
	}
	
	@Transactional
	public List<Article> findAll(){
		return (List<Article>) this.articleSpringDao.findAll();
	}

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
		
		// association du fournisseur à l'article
		LOGGER.info("saveArticleAndFournisseur : association article et fournisseur");
		a.setFournisseur(f);

		LOGGER.info("saveArticleAndFournisseur : persistence de l'article");
		return this.articleSpringDao.save(a);
	}
}