package com.restaurant.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@GetMapping("")
    public String index(Model model) {
    	LOGGER.info("Affichage de l'index des restaurants");
        model.addAttribute("restaurant", restaurantService.findAll());
        return "index-restaurant";
    }
	
	@GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) {
    	LOGGER.info("Affichage de la restaurant avec l'ID : {}", id);
        Restaurant restaurant = restaurantService.findById(id);
       	LOGGER.debug("restaurant trouvé : {}", restaurant);
        ModelAndView show = new ModelAndView("show-restaurant");
        show.addObject("restaurant", restaurant);
        return show;
    }
	
	@GetMapping("/new")
    public String newRestaurant(Model model) {
    	LOGGER.info("Affichage du formulaire de création d'un restaurant ");
        model.addAttribute("restaurant", new Restaurant());
        return "new-restaurant";
    }
	
	@PostMapping("/save")
    public String createRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, BindingResult result) {
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la création d'un restaurantn {}", restaurant);
            return "new-restaurant";
        }
        LOGGER.info("Création de la reservation {}", restaurant);
        restaurantService.save(restaurant);
        LOGGER.info("Reservation créée avec succès {}", restaurant);
        return "redirect:/restaurant/" + restaurant.getId();
    }

    @ModelAttribute("listRestaurant")
    public Iterable<Restaurant> listRestaurant() {
        return restaurantService.findAll();
    }

    @ModelAttribute("isRestaurantListEmpty")
    public Boolean isEmpty() {
        boolean isEmpty = !listRestaurant().iterator().hasNext();
        LOGGER.info("Vérification si la liste des restaurant est vide : {}", isEmpty);
        return isEmpty;
    }
    
}
