package com.bigcorp.booking.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.booking.models.Restaurant;
import com.bigcorp.booking.repositories.RestaurantDao;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

}