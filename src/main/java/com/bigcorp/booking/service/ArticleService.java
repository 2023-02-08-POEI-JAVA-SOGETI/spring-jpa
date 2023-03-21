package com.bigcorp.booking.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

@Service
public class ArticleService {	
	
	@Autowired
	private ArticleSpringDao articleSpringDao;
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;
	private static final Logger logger = LoggerFactory.getLogger(FournisseurService.class);
	
	
	@Transactional
	public Article save(Article article) {
		logger.info("Save article: {}", article);
		return this.articleSpringDao.save(article);
	}
	
	public void delete(Long  id) {
		logger.info("Delete article: {}", id);
		articleSpringDao.deleteById(id);
	}
	
	public Optional<Article> findById(Long id) {
		logger.info("Find article: {}", id);
		return articleSpringDao.findById(id);
	}
	
	public Iterable<Article> ListArticles(){
		logger.info("List article: ");
		return articleSpringDao.findAll();
	}
	
	public List<Article> findByName(String name) {
		logger.info("Find article: {}", name);
		return articleSpringDao.findByNom(name);
	}
	
	public Article linkFournisseurToArticle(Long articleId, Long fournisseurId) {
		if (articleId == null) {
			throw new IllegalArgumentException("id article ne peut etre null");
		} else if (fournisseurId == null) {
			throw new IllegalArgumentException("id fournisseur ne peut etre null");		
		}
		
		Article article = articleSpringDao.findById(articleId).get();
		Fournisseur fournisseur = fournisseurSpringDao.findById(fournisseurId).get();
		
		
		if (article == null) {
			throw new IllegalArgumentException("l'article n'a pas pu être trouvé" );
		} else if (fournisseur == null) {
			throw new IllegalArgumentException("le fournisseur n'a pas pu être trouvé" );
		}
		
		article.setFournisseur(fournisseur);
        return articleSpringDao.save(article);
	}

	public Iterable<Article> findAll() {
		return articleSpringDao.findAll();
	}
}
