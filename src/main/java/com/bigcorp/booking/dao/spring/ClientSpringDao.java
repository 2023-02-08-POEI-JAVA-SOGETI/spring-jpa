package com.bigcorp.booking.dao.spring;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.dao.PersistenceSingleton;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;

@Repository
public interface ClientSpringDao extends CrudRepository<Client, Integer> {



	public List<Client> findByNom(String nom);

	@Query("from Client where nom = :nom")
	List<Client> MaMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom);

}