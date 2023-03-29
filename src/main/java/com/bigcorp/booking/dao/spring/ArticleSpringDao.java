package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;

@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer> {

	public List<Article> findByNom(String nom);

	@Query("from Article where nom = :nom")
	List<Article> maMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom);

	public List<Article> findByEtatArticle(EtatArticle etatArticle);

	@Query("from Article where etatArticle = :etatArticle")
	List<Article> maMethodeDeRechercheAvecUneQueryExplicite2(@Param("etatArticle") EtatArticle etatArticle);

}