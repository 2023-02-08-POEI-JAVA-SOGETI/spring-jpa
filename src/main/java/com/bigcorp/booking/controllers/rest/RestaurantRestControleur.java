package com.bigcorp.booking.controllers.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.RestaurantDto;
import com.bigcorp.booking.services.RestaurantService;

@RestController
@RequestMapping("/rest/restaurant")
public class RestaurantRestControleur {

	@Autowired
	private RestaurantService restaurantService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantRestControleur.class);
	
	
	@PostMapping("/")
	public RestaurantDto createRestaurant(@Validated @RequestBody RestaurantDto restaurantDto)
	{
		LOGGER.info("Création d'un nouveau restaurant");
		
		if(restaurantDto == null )
	 	{
	 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun restaurant crée");
	 	}
		
		return restaurantService.save(restaurantDto);
	}
	
	
	@GetMapping("/{id}")
	public RestaurantDto getRestaurantById( @PathVariable("id") Integer id)
	{
		LOGGER.info("Récupération du restaurant n° " + id);
		
		RestaurantDto dto = restaurantService.findById(id);
		if (dto == null) {
			
			LOGGER.error("Id incorrect");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun restaurant trouvé avec l'id : "
					+ id);
		}
		
		return dto;
		
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Integer id)
	{
	
		LOGGER.info("Suppression du restaurant n° " + id);
		
		if(restaurantService.findById(id) == null )
	 	{
			LOGGER.error("Id incorrect");
	 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun Restaurant trouvé avec cet Id");
	 	}
		
			restaurantService.deleteById(id);
			return "Le restaurant numéro " + id + " a été supprimé."; 
	}
	
	@PutMapping("/")
	public RestaurantDto udpate(@RequestBody RestaurantDto restaurantDto)
	{
		LOGGER.info("Mise à jour du Restaurant" );

		if(restaurantService.findById(restaurantDto.getId()) == null )
	 	{
			LOGGER.error("Restaurant null");
	 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun Restaurant trouvé avec cet Id");
	 	}
		
		return restaurantService.update(restaurantDto);
	}
	
}