package com.restaurant.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.Restaurant;

@Repository
public interface RestaurantDao extends CrudRepository<Restaurant, Integer> {

}
