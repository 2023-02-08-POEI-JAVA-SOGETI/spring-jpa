package com.restaurant.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.restaurant.dto.TypeRestaurantDto;
import com.restaurant.model.TypeRestaurant;
import com.restaurant.service.TypeRestaurantService;

@RestController
@RequestMapping("/rest/type-restaurant")
public class TypeRestaurantRestController {
	
	@Autowired
	private TypeRestaurantService typeRestaurantService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantRestController.class);
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/list-type-restaurant")
	public List<TypeRestaurantDto> getAllRestaurantTypes(){
		 List<TypeRestaurant> restaurantsTypes = (List<TypeRestaurant>) typeRestaurantService.findAll();
		 return restaurantsTypes.stream().map(TypeRestaurantDto::new).collect(Collectors.toList());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/{id}")
	    public TypeRestaurantDto getTypeRestaurantById(@PathVariable("id") Integer id) {
	        TypeRestaurant tr = typeRestaurantService.findById(id);
	        if (tr == null) {
	            LOGGER.info("getTypeRestaurantById : TypeRestaurant non trouvé - renvoi 404");
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
	                    "Aucun type de restaurant trouvé avec l'id " + id);
	        }
	        LOGGER.info("getTypeRestaurantById : TypeRestaurant " + tr.getId() + " - " + tr.getNom());
	        return new TypeRestaurantDto(tr);
	    }
	@CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping
	    public TypeRestaurantDto createTypeRestaurant(@RequestBody TypeRestaurantDto typeRestaurantDto) {
	        TypeRestaurant typeRestaurant = new TypeRestaurant();
	        typeRestaurant.setNom(typeRestaurantDto.getNom());
	        return new TypeRestaurantDto(typeRestaurantService.save(typeRestaurant));
	    }
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public void deleteTypeRestaurant(@PathVariable("id") Integer id) {
		TypeRestaurant typeRestaurant = typeRestaurantService.findById(id);
		if (typeRestaurant == null) {
			LOGGER.info("deleteTypeRestaurant : TypeRestaurant non trouvé - renvoi 404");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun type restaurant à supprimer avec l'id " + id);
		}
		LOGGER.info("deleteTypeRestaurant : supresssion du restaurant " + typeRestaurant.getId());
		typeRestaurantService.delete(id);
	}
	
}
