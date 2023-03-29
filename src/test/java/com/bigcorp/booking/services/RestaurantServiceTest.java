package com.bigcorp.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

	
	private Restaurant createRestaurantTest() {
		TypeRestaurant typeRestaurant1 = new TypeRestaurant("Pizzeria");
		Restaurant restaurant1 = new Restaurant.Builder().withNom("JOJO Pizza").withAdresse("70 cours Vitton")
				.withPrix(Prix.CHER).withTypeRestaurant(typeRestaurant1).build();
		return restaurant1;
	}
	
	
	
	@Test
	@DisplayName("Testing if service correctly saves Restaurant from RestaurantDto")
	public void testSaveFromDto() {
		// Préparation des données de test

		Restaurant restaurant1 = createRestaurantTest();
		RestaurantDto restoDto1 = new RestaurantDto(restaurant1);
		RestaurantDto restoDtoSaved = restaurantService.save(restoDto1);
		// Assertion
		Assertions.assertEquals("JOJO Pizza", restoDtoSaved.getNom());
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
	
	
	@Test
	@DisplayName("Testing if service correctly finds Restaurant by Id")
	public void testFindById() {

		Restaurant restaurant1 = createRestaurantTest();
		
		RestaurantDto restoDto1 = new RestaurantDto(restaurant1);

		RestaurantDto restaurantDtoSave = restaurantService.save(restoDto1);
		
		RestaurantDto findDto = restaurantService.findById(restaurantDtoSave.getId());


		// Assertion
		Assertions.assertEquals(restaurant1.getNom(), findDto.getNom());
		Assertions.assertEquals(restaurantDtoSave.getPrix(), findDto.getPrix());
		
	}
	
	
	@Test
	@DisplayName("Testing if service correctly update a Restaurant")
	public void testUpdate() {

		Restaurant restaurant1 = createRestaurantTest();
		RestaurantDto restaurantDto = new RestaurantDto(restaurant1);
		RestaurantDto savedDto = restaurantService.save(restaurantDto);
		savedDto.setNom("UPDATE DU NOM");
		RestaurantDto updateDto = restaurantService.update(savedDto);
		
		Assertions.assertEquals("UPDATE DU NOM", updateDto.getNom());

	}

}