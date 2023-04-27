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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.Reservation;
import com.restaurant.model.Restaurant;
import com.restaurant.service.ReservationService;
import com.restaurant.service.RestaurantService;


@RequestMapping("/reservation")
@Controller
public class ReservationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("")
    public String index(Model model) {
    	LOGGER.info("Affichage de l'index des reservations");
        model.addAttribute("reservation", reservationService.findAll());
        return "index-reservation";
    }
	
	@GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) {
    	LOGGER.info("Affichage de la reservation avec l'ID : {}", id);
        Reservation reservation = reservationService.findById(id);
        
       	LOGGER.debug("reservation trouvé : {}", reservation);
        ModelAndView show = new ModelAndView("show-reservation");
        show.addObject("reservation", reservation);
        return show;
    }
	
	@GetMapping("/new/{id}")
    public String newReservation(@PathVariable("id") Integer id, Model model) {
    	LOGGER.info("Affichage du formulaire de création d'une nouvelle reservation");
    	
    	Restaurant restaurant = restaurantService.findById(id);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("reservation", new Reservation());
        return "new-reservation";
    }
	
	@PostMapping("/save/{id}")
    public String createReservation(@ModelAttribute("reservation") Reservation reservation, @PathVariable("id") Integer restaurant_id, BindingResult result) {
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la création de la reservation {}", reservation);
            return "new-reservation";
        }
        LOGGER.info("Création de la reservation {}", reservation);
        Restaurant restaurant = restaurantService.findById(restaurant_id);
        reservation.setRestaurant(restaurant);
        
        reservationService.save(reservation);
        LOGGER.info("Reservation créée avec succès {}", reservation);
        return "redirect:/reservation/" + reservation.getId();
    }
	
    @ModelAttribute("listReservation")
    public Iterable<Reservation> listReservation() {
        return reservationService.findAll();
    }

    @ModelAttribute("isReservationListEmpty")
    public Boolean isEmpty() {
        boolean isEmpty = !listReservation().iterator().hasNext();
        LOGGER.info("Vérification si la liste des reservations est vide : {}", isEmpty);
        return isEmpty;
    }
    

	
}
