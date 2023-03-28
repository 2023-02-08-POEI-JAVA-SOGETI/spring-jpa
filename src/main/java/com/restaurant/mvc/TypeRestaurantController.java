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

import com.restaurant.model.TypeRestaurant;
import com.restaurant.service.TypeRestaurantService;

@Controller
@RequestMapping("/typeRestaurant")
public class TypeRestaurantController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TypeRestaurantController.class);
	
	@Autowired
	private TypeRestaurantService typeRestaurantService;
	
	@GetMapping("")
    public String index(Model model) {
    	LOGGER.info("Affichage de l'index des TypeRestaurant");
        model.addAttribute("reservation", typeRestaurantService.findAll());
        return "index-type-restaurant";
    }
	
	@GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) {
		LOGGER.info("show : {}", id);
		TypeRestaurant typeRestaurant = typeRestaurantService.findById(id);
       	LOGGER.debug("Type restaurant trouvé : {}", typeRestaurant);
        ModelAndView show = new ModelAndView("show-type-restaurant");
        show.addObject("typeRestaurant", typeRestaurant);
        return show;
    }
	
	@GetMapping("/new")
    public String newTypeRestaurant(Model model) {
    	LOGGER.info("Affichage du formulaire de création de type de restaurant");
        model.addAttribute("typeRestaurant", new TypeRestaurant());
        return "new-type-restaurant";
    }
	
	@PostMapping("/save")
    public String createTypeRestaurant(@ModelAttribute("typeRestaurant") TypeRestaurant typeRestaurant, BindingResult result) {
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la création des types de restaurant {}", typeRestaurant);
            return "new-type-restaurant";
        }
        LOGGER.info("Création du type de restaurant {}", typeRestaurant);
        typeRestaurantService.save(typeRestaurant);
        LOGGER.info("Type créé avec succès {}", typeRestaurant);
        return "redirect:/typeRestaurant/" + typeRestaurant.getId();
    }

	@GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
    	LOGGER.info("Affichage du formulaire de modification du type de restaurant {}", id);
        TypeRestaurant typeRestaurant = typeRestaurantService.findById(id);
        model.addAttribute("typeRestaurant", typeRestaurant);
        return "edit-type-restaurant";
    }

    @PostMapping("/{id}/update")
    public String updateTypeRestaurant(@PathVariable("id") Integer id, @ModelAttribute("typeRestaurant") TypeRestaurant typeRestaurant,
                                BindingResult result) {
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la modification du type de restaurant {}", typeRestaurant);
            return "typeRestaurant/edit";
        }
        LOGGER.info("Modification du type {}", typeRestaurant);
        typeRestaurantService.save(typeRestaurant);
        return "redirect:/typeRestaurant/" + typeRestaurant.getId();
    }

    @PostMapping("/{id}/delete")
    public String deleteTypeRestaurant(@PathVariable("id") Integer id) {
    	LOGGER.info("Suppression du type {}", id);
    	typeRestaurantService.delete(id);
        return "redirect:/typeRestaurant";
    }

    @ModelAttribute("listTypeRestaurant")
    public Iterable<TypeRestaurant> listTypeRestaurant() {
        return typeRestaurantService.findAll();
    }

    @ModelAttribute("isTypeRestaurantListEmpty")
    public Boolean isEmpty() {
        boolean isEmpty = !listTypeRestaurant().iterator().hasNext();
        LOGGER.info("Vérification si la liste des types restaurant est vide : {}", isEmpty);
        return isEmpty;
    }
    
}
