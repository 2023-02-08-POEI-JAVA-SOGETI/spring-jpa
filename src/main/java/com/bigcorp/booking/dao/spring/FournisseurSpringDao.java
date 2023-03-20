package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bigcorp.booking.model.Fournisseur;

public interface FournisseurSpringDao extends CrudRepository<Fournisseur, Integer>{

	@Query("from Fournisseur where nom = :nom")
	List<Fournisseur> findFournisseurByName(@Param("nom") String nom);
}
