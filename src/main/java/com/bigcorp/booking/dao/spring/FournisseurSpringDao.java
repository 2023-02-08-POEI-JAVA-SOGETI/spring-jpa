package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Fournisseur;

@Repository
public interface FournisseurSpringDao extends CrudRepository<Fournisseur, Integer>  {
	
}