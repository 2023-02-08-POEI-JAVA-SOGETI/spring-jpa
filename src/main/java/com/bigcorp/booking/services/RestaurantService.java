package com.bigcorp.booking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.booking.dto.RestaurantDto;
import com.bigcorp.booking.models.Restaurant;
import com.bigcorp.booking.repositories.RestaurantDao;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

	@Transactional
	public List<Restaurant> findAll() {

		return this.restaurantDao.findAll();
	}

	@Transactional
	public RestaurantDto save(RestaurantDto restaurantDto) {
		Restaurant restaurant = new Restaurant();
		restaurant = restaurantDto.rempliRestaurant(restaurant);
		Restaurant savedRestaurant = restaurantDao.save(restaurant);
		RestaurantDto savedDto = new RestaurantDto(savedRestaurant);
		return savedDto;
	}

	@Transactional
	public RestaurantDto findById(Integer id) {
		Restaurant restaurant = restaurantDao.findById(id)

				.orElse(null);
		
		if (restaurant == null)
		{
			return null;
		}

		RestaurantDto restaurantDto = new RestaurantDto(restaurant);
		return restaurantDto;
	}

	@Transactional

	public RestaurantDto update(RestaurantDto restaurantDto) {
	
			Restaurant restaurant = restaurantDto.rempliRestaurant(new Restaurant());
			Restaurant savedRestaurant = restaurantDao.save(restaurant);
			RestaurantDto dto = new RestaurantDto(savedRestaurant);
			return dto;
		
	}

	@Transactional
	public void deleteById(Integer id){
			restaurantDao.deleteById(id);

	}

}