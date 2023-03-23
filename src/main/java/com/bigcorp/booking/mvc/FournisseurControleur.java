package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.service.FournisseurService;

import tp_spring_jpa_pablo.model.Fournisseur;

@Controller
public class FournisseurControleur {   
    
	@RequestMapping("/fournisseur")
    public String showSayHello() {
    	System.out.println("PAGE FOURNISSEUR ");
        return "fournisseur";
    }
	
	@PostMapping("/fournisseur")
	public ModelAndView saveFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur,
			BindingResult result) {
		
		if(result.hasErrors()) {
    		return new ModelAndView("fournisseur", "fournisseur", fournisseur);
    	}
		
	    fournisseurService.save(fournisseur);
	    ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:/formulaire-fournisseur?id=" + fournisseur.getId());
	    return mav;
	}
	
	@Autowired
    private FournisseurService fournisseurService;
	
	@RequestMapping("/formulaire-fournisseur")
    public String showFormulaire(@RequestParam("id") Integer id, Model model) {
        Fournisseur fournisseur = fournisseurService.findById(id);
        model.addAttribute("fournisseur", fournisseur);
        System.out.println("FORMULAIRE DU FOURNISSEIR N " + id);
        return "formulaire-fournisseur";
    }
	
	@ModelAttribute("listeFournisseur")
	public List<Fournisseur> getFournisseurList() {
	    Iterable<Fournisseur> fournisseurIterable = fournisseurService.findAll();
	    List<Fournisseur> fournisseurList = new ArrayList<>();
	    fournisseurIterable.forEach(fournisseurList::add);
	    return fournisseurList;
	}
    
    
}