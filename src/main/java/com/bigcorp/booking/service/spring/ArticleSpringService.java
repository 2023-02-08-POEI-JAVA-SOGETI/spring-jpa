package com.bigcorp.booking.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.model.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ArticleSpringService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleSpringService.class);
	@Autowired
	private ArticleSpringDao articleSpringDao;

	@Transactional
	public void save(Article article) {
		LOGGER.info("Saving");
		this.articleSpringDao.save(article);
		LOGGER.info("Saved");
	}

	public Article findById(Integer id) {
		LOGGER.info("Searching");
		return this.articleSpringDao.findById(id).orElse(null);
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
}
