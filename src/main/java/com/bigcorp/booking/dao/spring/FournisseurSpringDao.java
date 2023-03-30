package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Fournisseur;

@Repository
public interface FournisseurSpringDao extends CrudRepository<Fournisseur, Integer>  {
	
	List<Fournisseur> findByNom(@Param("nom") String nom); }