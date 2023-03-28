package com.restaurant.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.TypeRestaurant;

@Repository
public interface TypeRestaurantDao extends CrudRepository<TypeRestaurant, Integer> {

}
