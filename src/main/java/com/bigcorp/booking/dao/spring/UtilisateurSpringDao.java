package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Utilisateur;

@Repository
public interface UtilisateurSpringDao extends CrudRepository<Utilisateur, Integer>  {
	
	
}