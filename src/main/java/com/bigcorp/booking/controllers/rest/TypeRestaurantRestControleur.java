package com.bigcorp.booking.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.services.TypeRestaurantService;

@RestController
public class TypeRestaurantRestControleur {

	@Autowired
	private TypeRestaurantService typeRestaurantService;

	
}