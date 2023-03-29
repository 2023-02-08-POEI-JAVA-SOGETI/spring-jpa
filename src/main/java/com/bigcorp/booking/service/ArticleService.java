package com.bigcorp.booking.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;

import tp_spring_jpa_pablo.model.Article;

@Service
public class ArticleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
	
	@Autowired
	private ArticleSpringDao articleSpringDao;
	
	public Iterable<Article> findAll(){
		return this.articleSpringDao.findAll();
	}
	
	@Transactional
	public Article save(Article article) {
		LOGGER.info("SAVE ARTICLE : {}" , article);		
		return this.articleSpringDao.save(article);
	}
	
	public Article findById(Integer id) {
		LOGGER.info("RECOVER ARTICLE N : {}" , id);	
		return this.articleSpringDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		LOGGER.info("DELETE ARTICLE N : {}" , id);	
		this.articleSpringDao.deleteById(id);
	}
	
	// Crée dans le cours
	public void findByNom(String nomArticle) {
		LOGGER.info("RECOVER ARTICLE : {}" , nomArticle);
		this.articleSpringDao.findByNom(nomArticle);
	}
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
    public void deleteByFournisseurId(Integer fournisseurId) {
		LOGGER.info("DELETE ALL THE ARTICLES ASSOCIATED WITH THE FOURNISSEUR N : {}" , fournisseurId);
		List<Article> articlesToDelete = articleSpringDao.findByFournisseurId (fournisseurId);
        for (Article article : articlesToDelete) {
            articleSpringDao.delete(article);
        }
    }
	

}
