package com.bigcorp.booking.controllers.vue;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.models.Restaurant;
import com.bigcorp.booking.services.RestaurantService;

@Controller
public class RestaurantVueControleur {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantVueControleur.class);
	@Autowired
	private RestaurantService restaurantService;
	
    @ModelAttribute("listeRestaurants")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantService.findAll();   
        
        if (restaurants.size() == 0) {
        	LOGGER.info("Aucun restaurant retourne");
        }
        
        return restaurants ;
    }

/*	@ModelAttribute("listeRestaurants")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        for (String nom : Arrays.asList(
                "Les bons copains", "La bonne fourchette", "Le bon appétit"
        )) {
            restaurants.add(new Restaurant.Builder().withNom(nom).build());
        }
        return restaurants ;
    }
*/
    
    @GetMapping("/vue/restaurants")
    public String afficherRestaurants() {
    	System.out.println("Le contrôleur de restaurants agit !");
        return "vue-restaurants";
    }
    
    @RequestMapping("/rest/reservation/save")
    public String creerReservation() {
    	System.out.println("Le contrôleur de reservation agit !");
        return "vue-restaurants";
    }

}