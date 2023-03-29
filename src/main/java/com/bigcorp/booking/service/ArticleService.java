package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.repositories.ArticleDao;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Transactional
	public Article save(Article article) {
		return this.articleDao.save(article);
	}

	public Article findById(Integer id) {
		return this.articleDao.findById(id).orElse(null);
	}

	public Iterable<Article> findAll() {
		return this.articleDao.findAll();
	}

	public long count() {
		return this.articleDao.count();
	}

	@Transactional
	public void delete(Integer id) {
		this.articleDao.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return this.articleDao.existsById(id);
	}

}