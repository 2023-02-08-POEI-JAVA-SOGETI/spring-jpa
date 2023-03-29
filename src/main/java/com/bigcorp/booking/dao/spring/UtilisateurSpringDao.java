package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Utilisateur;

@Repository
public interface UtilisateurSpringDao extends CrudRepository<Utilisateur, Integer> {



	public List<Utilisateur> findByNom(String nom);

	@Query("from Utilisateur where nom = :nom")
	List<Utilisateur> maMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom);

}