package com.restaurant.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.restaurant.dto.RestaurantDto;
import com.restaurant.model.Restaurant;
import com.restaurant.model.TypeRestaurant;
import com.restaurant.service.RestaurantService;
import com.restaurant.service.TypeRestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/restaurant")
public class RestaurantRestController {

		@Autowired
		private RestaurantService restaurantService;

		@Autowired
		private TypeRestaurantService typeRestaurantService;
		
		private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantRestController.class);
		
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/list-restaurants")
	    public List<RestaurantDto> getAllRestaurants() {
	        List<Restaurant> restaurants = (List<Restaurant>) restaurantService.findAll();
	        return restaurants.stream().map(RestaurantDto::new).collect(Collectors.toList());
	    }
		
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/category/{id}")
	    public List<RestaurantDto> getAllRestaurantsByCategory(@PathVariable("id") Integer id) {
	        List<Restaurant> restaurants = (List<Restaurant>) restaurantService.findRestaurantsByType(id);
	        return restaurants.stream().map(RestaurantDto::new).collect(Collectors.toList());
	    }

		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/{id}")
		public RestaurantDto getRestaurantById(@PathVariable("id") Integer id) {
			Restaurant r = restaurantService.findById(id);
			if (r == null) {
				LOGGER.info("getRestaurantById : Restaurant non trouvé - renvoi 404");	
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun restaurant trouvé avec l'id " + id);			
			}
			LOGGER.info("getRestaurantById : Restaurant " + r.getId() + " - " + r.getNom());
			return new RestaurantDto(r);
		}

		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("")
		public RestaurantDto createRestaurant(@Valid @RequestBody RestaurantDto restaurantDto, BindingResult result) {
			if (result.hasErrors()) {
				String reason = "Erreur : " + result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" "));
				LOGGER.info("createArticle : " + reason);
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, reason);
			}
			
			Restaurant restaurant = new Restaurant();
			restaurantDto.remplisRestaurant(restaurant);
			
			TypeRestaurant typeRestaurant = typeRestaurantService.findById(restaurantDto.getTypeId());
			if (typeRestaurant == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "TypeId inconnu");
			}
			
			restaurant.setType(typeRestaurant);
			
			return new RestaurantDto(restaurantService.save(restaurant));
		}

		@CrossOrigin(origins = "http://localhost:4200")
		@DeleteMapping("/{id}")
		public void deleteRestaurant(@PathVariable("id") Integer id) {
			Restaurant restaurant = restaurantService.findById(id);
			if (restaurant == null) {
				LOGGER.info("deleteRestaurant : Restaurant non trouvé - renvoi 404");	
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun restaurant à supprimer avec l'id " + id);			
			}
			LOGGER.info("deleteRestaurant : Suppression du restaurant" + restaurant.getId());
			restaurantService.delete(id);
		}
}
