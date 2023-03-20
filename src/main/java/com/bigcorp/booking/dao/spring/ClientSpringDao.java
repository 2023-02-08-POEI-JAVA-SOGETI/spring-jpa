package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Client;

@Repository
public interface ClientSpringDao extends CrudRepository<Client, Integer> {

	@Query("from Client where nom = :nom ")
	List<Client> findClientByName(@Param("nom") String nom);
}
