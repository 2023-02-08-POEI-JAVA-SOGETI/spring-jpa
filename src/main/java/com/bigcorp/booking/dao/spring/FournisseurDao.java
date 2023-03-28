package com.bigcorp.booking.dao.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;


@Repository
public interface FournisseurDao extends JpaRepository<Fournisseur, Integer>{
	
	@Query("from Fournisseur f "
			+ " left join fetch f.articles"
			+ " WHERE f.id= :id")
	public Fournisseur findFournisseurWithArticles(@Param("id")Integer id);

}
