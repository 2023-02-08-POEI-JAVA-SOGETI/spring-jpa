package com.bigcorp.booking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Utilisateur;

@Repository
public interface UtilisateurDao extends CrudRepository<Utilisateur, Integer>  {
public Utilisateur save(Utilisateur fournisseur);
	
	public List<Utilisateur> findById(@Param("id") int id); 
	
	// public List<Utilisateur> findByNom(@Param("nom") String nom); 
	
	public void deleteById(Integer id);
	
	
}