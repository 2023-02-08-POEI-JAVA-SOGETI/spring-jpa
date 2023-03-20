package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Example;


@Repository
public interface ExampleSpringDao extends CrudRepository<Example, Long>  {

	//on veut recup une liste d'examples dont le nom vaut un param de la methode
//	public List<Example> findByName(String nom);
	
	
}
