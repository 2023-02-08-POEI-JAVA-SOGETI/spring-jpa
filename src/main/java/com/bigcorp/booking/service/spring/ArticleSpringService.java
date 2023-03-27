package com.bigcorp.booking.service.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.dao.spring.FournisseurSpringDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseurs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ArticleSpringService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleSpringService.class);
	@Autowired
	private ArticleSpringDao articleSpringDao;
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;

	@Transactional
	public Article save(Article article) {
		LOGGER.info("Saving");
		return this.articleSpringDao.save(article);
		/*LOGGER.info("Saved");*/
	}

	public Article findById(Integer id) {
		LOGGER.info("Searching");
		return this.articleSpringDao.findById(id).orElse(null);
	}
	
	public Iterable<Article> findAll() {
		LOGGER.info("Searching");
		return this.articleSpringDao.findAll();
	}

	public List<Article> findContainingName(String name) {
		LOGGER.info("Searching");
		return this.articleSpringDao.findByNomContaining(name);
	}

	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Deleting");
		this.articleSpringDao.deleteById(id);
		LOGGER.info("Deleted");
	}

	@Transactional
	public Article saveWithFournisseur(Integer idArticle, Integer idFournisseur) {
		Article bonArticle = findById(idArticle);
		if (bonArticle == null) {
			throw new IllegalArgumentException("L'article n'existe pas");
		}
		Fournisseurs bonFournisseur = fournisseurSpringDao.findById(idFournisseur).orElseThrow();
		bonArticle.setFournisseur(bonFournisseur);
		save(bonArticle);
		return bonArticle;
	}

}
