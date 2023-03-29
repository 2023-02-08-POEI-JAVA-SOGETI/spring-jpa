package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp_spring_jpa_pablo.model.Client;

@Repository
public interface ClientSpringDao extends CrudRepository<Client, Integer> {    
	// JPQL requetes SQL en JPA
	public List<Client> findByNom(String nomClient);
	
}
