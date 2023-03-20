package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleSDao;

import tp_spring_jpa_pablo.model.Article;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleSDao articleSDao;
	
	public Iterable<Article> findAll(){
		return this.articleSDao.findAll();
	}
	
	@Transactional
	public Article save(Article article) {
		System.out.println("INSIDE SAVE FUNCTION");
		return this.articleSDao.save(article);
	}
	
	public Article findById(Integer id) {
		return this.articleSDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void delete(Integer id) {
		this.articleSDao.deleteById(id);
	}
	
	// Crée dans le cours
	public void findByNom(String nomArticle) {
		this.articleSDao.findByNom(nomArticle);
	}
	

}
