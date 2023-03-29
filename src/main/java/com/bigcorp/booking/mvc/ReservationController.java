package com.bigcorp.booking.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.service.RestaurantService;




@Controller
public class ReservationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	private RestaurantService restaurantService;

//	@PostMapping("/fournisseurs/{id}")
//	public ModelAndView processSubmit(@Validated @ModelAttribute("fournisseurModel") Fournisseurs fournisseur,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			ModelAndView modelAndView = new ModelAndView();
//			//modelAndView.setViewName("redirect:/fournisseurs/" + fournisseur.getiD());
//			modelAndView.setViewName("vue-fournisseur");
//			modelAndView.addObject("fournisseurModel", fournisseur);
//			LOGGER.warn("Erreur lors de la soumission du fournisseur avec l'ID {}", fournisseur.getiD());
//			return modelAndView;
//		}
//
//		String view = "redirect:/fournisseurs/" + fournisseur.getiD();
//
//		ModelAndView mav = new ModelAndView(view);
//		mav.addObject("fournisseur", fournisseur);
//
//		fournisseurService.save(fournisseur);
//		LOGGER.info("Modification réussie dans la BDD pour le fournisseur avec l'ID {}", fournisseur.getiD());
//		return mav;
//	}
	
}

