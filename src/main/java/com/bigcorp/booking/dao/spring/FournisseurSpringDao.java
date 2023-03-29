package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Fournisseur;


import java.util.List;





@Repository
public interface FournisseurSpringDao  extends CrudRepository<Fournisseur, Integer>{
	List<Fournisseur> findByNom(String name);
	@Query("FROM Fournisseur  fourn left outer join fetch fourn.articles where fourn.id = :id")
	Fournisseur findByIdWithArticles(@Param("id") Integer id);
}
