package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Example;


@Repository
public interface ExampleSpringDao extends CrudRepository<Example, Long>  {

	
	
	
}
