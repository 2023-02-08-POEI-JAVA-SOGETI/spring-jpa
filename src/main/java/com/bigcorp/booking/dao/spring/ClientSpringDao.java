package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.bigcorp.booking.model.Client;



public interface ClientSpringDao extends CrudRepository<Client, Integer>  {

	List<Client> findByNomContaining(String nom);
	
	
}