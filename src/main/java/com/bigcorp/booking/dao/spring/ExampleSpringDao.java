package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Example;

@Repository
public interface ExampleSpringDao extends CrudRepository<Example, Long>  {
	
	//On veut récupérer une liste de Example dont le nom vaut : un paramètre de la méthode
	List<Example> findByNom(@Param("nom") String nom); 

	@Query("from Example where nom = :nom and id = 3 order by taille desc, id")
	List<Example> maMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom); 
	
}