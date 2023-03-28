package com.bigcorp.booking.controllers.vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.models.Restaurant;
import com.bigcorp.booking.services.RestaurantService;

@Controller
public class RestaurantVueControleur {
	
	@Autowired
	private RestaurantService restaurantService;
	
    @ModelAttribute("listeRestaurants")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        for (String nom : Arrays.asList(
                "Les bons copains", "La bonne fourchette", "Le bon appétit"
        )) {
            restaurants.add(new Restaurant.Builder().withNom(nom).build());
        }
        return restaurants ;
    }
    
    @RequestMapping("/restaurants")
    public String afficherRestaurants() {
    	System.out.println("Le contrôleur de restaurants agit !");
        return "vue-restaurants";
    }


}