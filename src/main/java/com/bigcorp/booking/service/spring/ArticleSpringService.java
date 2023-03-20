package com.bigcorp.booking.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSpringDao;
import com.bigcorp.booking.model.Article;


@Service
public class ArticleSpringService {
	
	@Autowired
	private ArticleSpringDao articleSpringDao;

	@Transactional
	public void save(Article article) {
		this.articleSpringDao.save(article);
	}

	public Article findById(Integer id) {
		return this.articleSpringDao.findById(id).orElse(null);
	}
	
	public List<Article> findContainingName(String name) {
		return this.articleSpringDao.findByNomContaining(name);
	}

	@Transactional
	public void delete(Integer id) {
		this.articleSpringDao.deleteById(id);
	}
}
