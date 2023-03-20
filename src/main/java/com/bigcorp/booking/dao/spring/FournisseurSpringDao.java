package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



import com.bigcorp.booking.model.Fournisseurs;



public interface FournisseurSpringDao extends CrudRepository<Fournisseurs, Integer>  {

	List<Fournisseurs> findByNomContaining(String nom);
	
	
}