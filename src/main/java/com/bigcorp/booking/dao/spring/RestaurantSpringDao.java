package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Restaurant;


@Repository
public interface RestaurantSpringDao extends CrudRepository<Restaurant, Integer>  {
	
	

}