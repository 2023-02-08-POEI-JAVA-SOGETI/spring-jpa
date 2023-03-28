package com.restaurant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.model.Restaurant;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;
	
	private static final Logger logger = LoggerFactory.getLogger(RestaurantService.class);
	
	@Transactional
	public Restaurant save(Restaurant restaurant) {
		logger.info("Save restaurant : {}", restaurant);
		return this.restaurantDao.save(restaurant);
	}
	
	public void delete(Integer  id) {
		logger.info("Delete restaurant : {}", id);
		restaurantDao.deleteById(id);
	}
	
	public Iterable<Restaurant> findAll() {
		return restaurantDao.findAll();
	}
	
	public Restaurant findById(Integer id) {
		logger.info("Find restaurant: {}", id);
		return restaurantDao.findById(id).orElse(null);
	}
	
	public Iterable<Restaurant> ListRestaurant(){
		logger.info("List restaurant : ");
		return restaurantDao.findAll();
	}


	
}
