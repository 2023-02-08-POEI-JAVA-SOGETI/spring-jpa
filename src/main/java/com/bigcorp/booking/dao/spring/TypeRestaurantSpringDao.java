package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.TypeRestaurant;


@Repository
public interface TypeRestaurantSpringDao extends CrudRepository<TypeRestaurant, Integer>  {
	
}