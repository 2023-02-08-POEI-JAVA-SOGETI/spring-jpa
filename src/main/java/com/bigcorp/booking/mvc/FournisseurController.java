package com.bigcorp.booking.mvc;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.spring.service.FournisseurService;

@Controller
public class FournisseurController {
	
	@Autowired
	private FournisseurService service;
	
	@RequestMapping(path = "/fournisseurs-list", method = RequestMethod.GET)
    public String fournisseurList() {
    	System.out.println("Le contrôleur du fournisseur agit ! ");
        return "liste-fournisseurs";
	
	}
	
	
	 @RequestMapping(path= "/fournisseur/{id}", method = RequestMethod.GET)
	 public ModelAndView afficheDetailsFournisseur(@PathVariable("id") Integer id)
	    {
		 	System.out.println("Le fournisseur " + id + " va s'afficher");
	    	
		 	Fournisseur monFournisseur = service.getFournisseurById(id);
		 	
	    	ModelAndView mav = new ModelAndView("mon-fournisseur");
	    	mav.addObject("monFournisseur", monFournisseur);

	    	return mav;
	    }
	
	
	
	 @PostMapping("/update-fournisseur")
	 public ModelAndView updateFournisseur(@RequestParam("id") Integer id, 
			 								@ModelAttribute("monFournisseur") Fournisseur fournisseur)
	 {
		 System.out.println("Le fournisseur " + id + " va etre mis à jour");
		 
		 Fournisseur newfournisseur = service.updateFournisseur(id, fournisseur);
		 
		 ModelAndView mav = new ModelAndView("redirect:/fournisseurs-list");
		 mav.addObject(newfournisseur);
		 
		return mav;
		 
	 }
	
	 
	 
	
	@ModelAttribute("fournisseur_list")
    public List<Fournisseur> attributFournisseurList()
    {
		return service.getAllFournisseur();
    }
	
	
	
}
