package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bigcorp.booking.model.Article;

public interface ArticleSpringDao extends CrudRepository<Article, Integer> {

	@Query("from Article where nom = :nom ")
	List<Article> findArticleByName(@Param("nom") String nom);
}
