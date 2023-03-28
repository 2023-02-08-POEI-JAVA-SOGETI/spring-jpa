package com.bigcorp.booking.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcorp.booking.models.TypeRestaurant;
import com.bigcorp.booking.repositories.TypeRestaurantDao;

@Service
public class TypeRestaurantService {

	@Autowired
	private TypeRestaurantDao typeRestaurantDao;

}