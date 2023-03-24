package com.bigcorp.booking.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class FournisseurControleur {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurControleur.class);
	
	@Autowired
	private FournisseurService fournisseurService;
	
	/**
	 * Affiche la page des fournisseurs.
	 * Ajoute fournisseurs dans le modele.
	 * @return
	 */
    @RequestMapping("/fournisseurs")
    public ModelAndView afficheFournisseurs() {
    	LOGGER.info("Affichage de tous les fournisseurs");
    	Iterable<Fournisseur> fournisseurs = fournisseurService.findAll();
    	
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("fournisseur/fournisseurs");
    	mav.addObject("fournisseurs", fournisseurs);
        return mav;
    }
    
    @RequestMapping("/fournisseur-detail")
    public ModelAndView afficheDetailPlaneteParAttribut(@RequestParam("id") Integer id) {
    	LOGGER.info("Affichage du fournisseur avec l'id : {}", id);
    	Fournisseur fournisseur = fournisseurService.findById(id);
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("fournisseur/fournisseur-detail");
    	mav.addObject("fournisseur", fournisseur);
        return mav;
    }
    
    @PostMapping("/fournisseur-sauvegarde")
    public ModelAndView processSubmit( 
    		@Validated @ModelAttribute("fournisseur") Fournisseur fournisseur, 
    		BindingResult result) {
    	if(result.hasErrors()) {
    		//return new ModelAndView("fournisseur", "fournisseur", fournisseur);
        	ModelAndView mav = new ModelAndView();
        	mav.setViewName("fournisseur/fournisseur-detail");
        	mav.addObject("fournisseur", fournisseur);
            return mav;
    	}
    	Fournisseur fournisseurSauvegarde = fournisseurService.save(fournisseur);
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:/fournisseur-detail?id=" + fournisseurSauvegarde.getId());
        return mav;
    }
    
}