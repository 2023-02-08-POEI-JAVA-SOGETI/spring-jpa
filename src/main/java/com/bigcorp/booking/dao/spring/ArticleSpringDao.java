package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;

@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer>  {
	
	public List<Article> findByEtatArticleOrderByNom(EtatArticle etatArticle);

}