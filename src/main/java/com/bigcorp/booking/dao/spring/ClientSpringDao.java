package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Client;

@Repository
public interface ClientSpringDao extends CrudRepository<Client, Integer> {



	public List<Client> findByNom(String nom);

	@Query("from Client where nom = :nom")
	List<Client> maMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom);

}