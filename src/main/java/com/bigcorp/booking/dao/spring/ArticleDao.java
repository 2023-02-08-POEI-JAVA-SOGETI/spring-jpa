package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;

@Repository
public interface ArticleDao extends CrudRepository<Article, Integer>  {
	
	public Article save(Article article);
	
	public List<Article> findById(@Param("id") int id); 
	
	
	public void deleteById(Integer id);
	
}