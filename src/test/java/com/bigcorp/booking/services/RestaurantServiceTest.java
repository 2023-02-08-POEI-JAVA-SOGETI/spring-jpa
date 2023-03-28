package com.bigcorp.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.dto.RestaurantDto;
import com.bigcorp.booking.models.Prix;
import com.bigcorp.booking.models.Restaurant;
import com.bigcorp.booking.models.TypeRestaurant;
import com.bigcorp.booking.spring.SpringConfiguration;
import com.bigcorp.booking.services.RestaurantService;

@SpringJUnitConfig(SpringConfiguration.class)
public class RestaurantServiceTest {

	@Autowired
	private RestaurantService restaurantService;

	@Test
	@DisplayName("Testing if service correctly saves Restaurant from RestaurantDto")
	public void testSaveFromDto() {
		// Préparation des données de test

		TypeRestaurant typeRestaurant1 = new TypeRestaurant("Pizzeria");
		Restaurant restaurant1 = new Restaurant.Builder().withNom("JOJO Pizza").withAdresse("70 cours Vitton")
				.withPrix(Prix.CHER).withTypeRestaurant(typeRestaurant1).build();

		RestaurantDto restoDto1 = new RestaurantDto(restaurant1);

		Restaurant restoSaved1 = restaurantService.save(restoDto1);
		// Assertion
		Assertions.assertEquals("JOJO Pizza", restoSaved1.getNom());
	}

	@Test
	@DisplayName("Testing if service correctly finds all Restaurants")
	public void testFindAll() {

		TypeRestaurant typeRestaurant1 = new TypeRestaurant("Pizzeria");
		Restaurant restaurant1 = new Restaurant.Builder().withNom("JOJO Pizza").withAdresse("70 cours Vitton")
				.withPrix(Prix.CHER).withTypeRestaurant(typeRestaurant1).build();
		Restaurant restaurant2 = new Restaurant.Builder().withNom("Silvio Pizza").withAdresse("4 rue des Lilas")
				.withPrix(Prix.CHER).withTypeRestaurant(typeRestaurant1).build();

		RestaurantDto restoDto1 = new RestaurantDto(restaurant1);
		RestaurantDto restoDto2 = new RestaurantDto(restaurant2);

		restaurantService.save(restoDto1);
		restaurantService.save(restoDto2);

		List<Restaurant> listeRestaurants = restaurantService.findAll();

		// Assertion
		Assertions.assertFalse(listeRestaurants.isEmpty());
	}

}