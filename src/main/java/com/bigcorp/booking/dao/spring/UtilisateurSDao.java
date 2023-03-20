package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp_spring_jpa_pablo.model.Utilisateur;

@Repository
public interface UtilisateurSDao extends CrudRepository<Utilisateur, Integer> {    
    
	
}
