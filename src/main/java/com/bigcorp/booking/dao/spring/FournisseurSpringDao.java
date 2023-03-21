package com.bigcorp.booking.dao.spring;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.dao.PersistenceSingleton;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;

@Repository
public interface FournisseurSpringDao extends CrudRepository<Fournisseur, Integer> {



	public List<Fournisseur> findByNom(String nom);

	@Query("from Fournisseur where nom = :nom")
	List<Fournisseur> maMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom);

}