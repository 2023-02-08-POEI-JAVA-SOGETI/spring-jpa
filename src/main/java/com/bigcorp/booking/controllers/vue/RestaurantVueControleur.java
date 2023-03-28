package com.bigcorp.booking.controllers.vue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bigcorp.booking.services.RestaurantService;

@Controller
public class RestaurantVueControleur {

	@Autowired
	private RestaurantService restaurantService;

	
}