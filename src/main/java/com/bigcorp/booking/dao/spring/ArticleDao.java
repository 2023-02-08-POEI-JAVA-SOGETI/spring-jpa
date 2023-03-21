package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.exercice.model.many_to_one.Article;


@Repository
public interface ArticleDao  extends JpaRepository<Article, Integer>{
	
	
	@Query("from Article where type = :type")
	public List<Article> getArticleByType(@Param("type")String type);

}
