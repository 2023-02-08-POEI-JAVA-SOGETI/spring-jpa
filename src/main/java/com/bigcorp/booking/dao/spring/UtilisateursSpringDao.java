package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Utilisateurs;

@Repository
public interface UtilisateursSpringDao extends CrudRepository<Utilisateurs, Integer>  {

	
	
	
}
