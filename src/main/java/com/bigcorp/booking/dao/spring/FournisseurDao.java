package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Fournisseur;

@Repository
public interface FournisseurDao extends CrudRepository<Fournisseur, Integer>  {
	
	public Fournisseur save(Fournisseur fournisseur);
	
	public List<Fournisseur> findById(@Param("id") int id); 
	
	public List<Fournisseur> findByNom(@Param("nom") String nom); 
	
	public void deleteById(Integer id);
	
}