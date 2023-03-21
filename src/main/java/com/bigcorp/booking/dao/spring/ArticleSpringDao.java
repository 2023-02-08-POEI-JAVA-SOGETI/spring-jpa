package com.bigcorp.booking.dao.spring;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.dao.PersistenceSingleton;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;

@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer> {



	public List<Article> findByNom(String nom);

	@Query("from Article where nom = :nom")
	List<Article> maMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom);

}