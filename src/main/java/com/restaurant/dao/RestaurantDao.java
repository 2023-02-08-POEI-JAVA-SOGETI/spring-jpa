package com.restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.Restaurant;

@Repository
public interface RestaurantDao extends CrudRepository<Restaurant, Integer> {
	@Query("from Restaurant r left outer join fetch r.type")
	public List<Restaurant> findAllWithType();
	
}