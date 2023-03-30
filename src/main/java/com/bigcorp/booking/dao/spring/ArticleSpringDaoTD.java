package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;

@Repository
public interface ArticleSpringDaoTD extends CrudRepository<Article, Integer>  {
	
	public List<Article> findByNom(@Param("nom")String nom);

	public List<Article> findByEtatArticleOrderByNom(EtatArticle etatArticle);

}