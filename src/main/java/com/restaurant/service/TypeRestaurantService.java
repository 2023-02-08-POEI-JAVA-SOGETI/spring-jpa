package com.restaurant.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.TypeRestaurantDao;
import com.restaurant.model.Restaurant;
import com.restaurant.model.TypeRestaurant;

@Service
public class TypeRestaurantService {
	
	@Autowired
	private TypeRestaurantDao typeRestaurantDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TypeRestaurantService.class);
	
	@Transactional
	public TypeRestaurant save(TypeRestaurant typeRestaurant) {
		logger.info("Save typeRestaurant : {}", typeRestaurant);
		return this.typeRestaurantDao.save(typeRestaurant);
	}

	@Transactional
	public void delete(Integer  id) {
		logger.info("delete : {}", id);
		typeRestaurantDao.deleteById(id);
	}
	
	public Iterable<TypeRestaurant> findAll() {
		return typeRestaurantDao.findAll();
	}
	
	public TypeRestaurant findById(Integer id) {
		logger.info("findById : {}", id);
		return typeRestaurantDao.findById(id).orElse(null);
	}

	public List<Restaurant> findRestaurantsByType(TypeRestaurant type){
		logger.info("findRestaurantsByType : ");
		return typeRestaurantDao.findRestaurantsByType(type.getId());
	}	
}
