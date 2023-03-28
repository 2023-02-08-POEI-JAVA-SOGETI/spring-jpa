package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Client;

@Repository
public interface ClientSpringDao  extends CrudRepository<Client, Integer>{
	List<Client> findByNom(String nom);
}
