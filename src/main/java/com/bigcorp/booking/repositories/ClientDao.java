package com.bigcorp.booking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Client;

@Repository
public interface ClientDao extends CrudRepository<Client, Integer>  {
	
	public Client save(Client client);
	
	public List<Client> findById(@Param("id") int id); 
	
	// public List<Client> findByNom(@Param("nom") String nom); 
	
	public void deleteById(Integer id);
	
}