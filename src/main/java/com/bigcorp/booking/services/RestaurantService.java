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
	public Restaurant save(RestaurantDto restaurantDto) {
		Restaurant restaurant = new Restaurant();
		restaurant = restaurantDto.rempliRestaurant(restaurant);
		return this.restaurantDao.save(restaurant);
	}

	@Transactional
	public RestaurantDto findById(Integer id) {
		Restaurant restaurant = restaurantDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Aucun restaurant avec l'id" + id));
		RestaurantDto restaurantDto = new RestaurantDto(restaurant);
		return restaurantDto;
	}

	@Transactional
	public Restaurant update(RestaurantDto restaurantDto) {
		if(restaurantDto.getId() == null) {
			throw new IllegalArgumentException("Mise à jour impossible, le restaurant n'existe pas");
		} else {
			Restaurant restaurant = restaurantDto.rempliRestaurant(new Restaurant());
			Restaurant savedRestaurant = restaurantDao.save(restaurant);
			return savedRestaurant;
		}
	}

	@Transactional
	public void deleteById(Integer id) {
		restaurantDao.deleteById(id);
	}

}