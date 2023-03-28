package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class FournisseurDetailControleur {
	
	@Autowired
	private FournisseurService fournisseurService;
    
    /**
     * Intercepte les requêtes /planete , attend le paramètre de requête "id" et
     * le met dans l'argument id de la méthode.
     * @return
     */
    @RequestMapping("/fournisseur")
    public String afficheDetailFournisseurParAttribut(@RequestParam("id") Integer id) {
    	System.out.println("J'affiche le détail du fournisseur à partir de son attribut : " + id);
        return "fournisseur";
    }
    
    /**
     * Intercepte les requêtes /planetes/{id} , attend le paramètre "id" dans le chemin et
     * le met dans l'argument id de la méthode.
     * @return
     */
    @RequestMapping("/fournisseurs/{id}")
    public ModelAndView afficheDetailFournisseurParChemin(@PathVariable("id") Integer id) {
    	System.out.println("J'affiche le détail du fournisseur à partir du chemin  : " + id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("fournisseur");
    	mav.addObject("fournisseur", fournisseurService.findById(id));
        return mav;
    }
    
    /**
     * Sauvegarde fournisseur
     * @param fournisseur
     * @param result
     * @return
     */
    @PostMapping("/fournisseur")
    public ModelAndView processSubmit(@Validated @ModelAttribute("fournisseur") Fournisseur fournisseur, 
    		BindingResult result) {
    	if(result.hasErrors()) {
    		return new ModelAndView("fournisseur", "fournisseur", fournisseur);
    	}
    	
    	String view = "fournisseur";
    	if(fournisseur != null && fournisseur.getId() != null) {
    		view = "redirect:/fournisseurs/" + fournisseur.getId();
    	}
    	else if(fournisseur != null && fournisseur.getNumero() != null) {
    		view = "redirect:/fournisseurs/" + fournisseur.getNumero();
    	}
    	else if(fournisseur != null && fournisseur.getNom() != null) {
    		view = "redirect:/fournisseurs/" + fournisseur.getNom();
    	}
    	else if(fournisseur != null && fournisseur.getEmail() != null) {
    		view = "redirect:/fournisseurs/" + fournisseur.getEmail();
    	}
    	else if(fournisseur != null && fournisseur.getAdresse() != null) {
    		view = "redirect:/fournisseurs/" + fournisseur.getEmail();
    	}
    	ModelAndView mav = new ModelAndView(view);
    	mav.addObject("fournisseur", fournisseur);
        if (result.hasErrors()) {
            return mav;
        }
        // else
        fournisseurService.save(fournisseur);
        return mav;
    }
    
    
}