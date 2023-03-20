package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;



public interface ArticleSpringDao extends CrudRepository<Article, Integer>  {

	List<Article> findByNomContaining(String nom);
	
	
}
