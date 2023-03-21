package com.bigcorp.booking.service;

import com.bigcorp.booking.dao.spring.ArticleDao;
import com.bigcorp.booking.dao.spring.FournisseurDao;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private FournisseurDao fournisseurDao;

	@Transactional
	public void save(Article article) {
		if (article.getNom() != "NOM") {
			this.articleDao.save(article);
			LOGGER.info("Article successfully saved!");
		} else
			LOGGER.info("Article couldn't be saved.");

	}

	@Transactional
	public void delete(int id) {
		if (id != 0) {
			this.articleDao.deleteById(id);
			LOGGER.info("Article successfully removed!");
		} else
			LOGGER.info("Article couldn't be removed.");
	}

	@Transactional
	public Article getById(int id) {
		if (id == 0)
			return null;

		return this.articleDao.findById(id).orElse(null);
	}

	@Transactional
	public List<Article> getByName(String name) {
		if (name == "")
			return null;

		List<Article> articles = this.articleDao.findByName(name);

		return articles.isEmpty() ? null : articles;
	}

	@Transactional
	public Article associateWithFournisseur(int articleId, int fournisseurId) {

		Article article = this.getById(articleId);
		
		if(article == null) return null;
		
		Fournisseur fournisseur = fournisseurDao.findById(fournisseurId)
												.orElseThrow();

		article.setFournisseur(fournisseur);

		return articleDao.save(article);
	}
}
