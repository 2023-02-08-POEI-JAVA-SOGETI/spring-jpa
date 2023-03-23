package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;

@Controller
public class FournisseurDetailsController {
	
	@Autowired
	FournisseurService fournisseurService;
	
//	@RequestMapping("fournisseurs/edit")
//	public String formFournisseur() {
//		return "editFournisseur";
//	}
	
 /**
  *  TODO: Ajouter la logique 
  *  	   Notamment une méthode qui va permettre la sauvegarde des données du formulaire 
  *        Et rediriger vers la page du fournisseur en question)
  */
	
	@RequestMapping("fournisseurs/edit")
	public ModelAndView showFournisseurDetailsWithAttributes(@RequestParam("fournisseurId") Integer id) {
    	
		System.out.println(fournisseurService.getById(id));
		
		ModelAndView mav = new ModelAndView();
    	
		mav.setViewName("editFournisseur");
    	mav.addObject("fournisseur", fournisseurService.getById(id));
        
    	return mav;
	}
	
	@PostMapping("/save-fournisseur")
	public ModelAndView processSubmit(@ModelAttribute("fournisseur") Fournisseur fournisseur, BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("fournisseurs");
			mav.addObject("fournisseur", fournisseur);
			
			return mav;
		}
		
	    System.out.println(fournisseur);
	    System.out.println(fournisseur.getNom()); 
		
		fournisseurService.save(fournisseur);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/fournisseurs?id=" + fournisseur.getId());
		
		return mav;
	}
}
