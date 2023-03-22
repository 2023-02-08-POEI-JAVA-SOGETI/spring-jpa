package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.service.FournisseursService;

@Controller
public class FournisseurControleur {
	
	@Autowired
	private FournisseursService fournisseurService;
	
	@RequestMapping("/listeFournisseurs")
    public String showSayHello() {
    	System.out.println("Le contrôleur de coucou agit ! ");
        return "vue-fournisseurs";
    }
	
	//liste fournisseurs avec lien (page1)
	@ModelAttribute("fournisseurs")
	public Iterable<Fournisseurs> metDansLeContexteConnexion() {
		return fournisseurService.findAll();
	}
	
	//page formulaire



	
	@RequestMapping("/modifierFournisseur")
	public String modifierFournisseur(@ModelAttribute Fournisseurs fournisseur) {
	    fournisseurService.save(fournisseur);
	    return "redirect:/formulaireFournisseurs?id=" + fournisseur.getId();
	}

}
