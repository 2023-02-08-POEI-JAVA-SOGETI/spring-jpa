package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.bigcorp.booking.model.Utilisateur;



public interface UtilisateurSpringDao extends CrudRepository<Utilisateur, Integer>  {

	List<Utilisateur> findByNomContaining(String nom);
	
	
}