package com.bigcorp.booking.dao.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;


@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer>  {

	@Query("from Article where fournisseur_id = :id")
	public List<Article> findbyFournisseur(@Param("id") Integer id);	
}
