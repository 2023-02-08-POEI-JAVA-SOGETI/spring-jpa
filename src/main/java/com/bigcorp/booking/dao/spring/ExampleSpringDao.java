package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Example;


@Repository
public interface ExampleSpringDao extends CrudRepository<Example, Long>  {
	
	public List<Example> findByNom(String nom);
	
//	@Query("from exemple where nom = :nom and id = 3 order by taille desc, id")
//	List<Example> maRequete(@Param("nom") String nom);
	
	
}
