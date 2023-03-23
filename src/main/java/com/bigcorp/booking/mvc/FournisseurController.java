package com.bigcorp.booking.mvc;

import java.util.Optional;

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

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;

@Controller
public class FournisseurController {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	
	@RequestMapping("/fournisseurs")
	public String index() {
	    	System.out.println("génération de l'index fournisseur ! ");
	        return "index-fournisseur";
	 }
	
	@RequestMapping("/fournisseur/{id}")
	public ModelAndView show(@PathVariable("id") Integer id) {
    	System.out.println("génération de la show fournisseur ! ");
    	Fournisseur fournisseur = fournisseurService.findById(id);
		ModelAndView show = new ModelAndView();
		show.setViewName("show-fournisseur");
		show.addObject("fournisseur", fournisseur);
		return show;
	}
	@GetMapping("/fournisseur/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
	    Fournisseur fournisseur = fournisseurService.findById(id);
	    model.addAttribute("fournisseur", fournisseur);
	    return  "edit-fournisseur";
	}
	
	@PostMapping("/fournisseur/save")
	public String save(@ModelAttribute("fournisseur") Fournisseur fournisseur, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit-fournisseur";
		} else {
			fournisseurService.save(fournisseur);
			return "redirect:/fournisseur/" + fournisseur.getId();			
		}
	}
	
	@ModelAttribute("listFournisseurs")
	public Iterable<Fournisseur> listFournisseurs() {
	    return fournisseurService.findAll();
	}

	@ModelAttribute("isFournisseursListEmpty")
	public Boolean isEmpty() {
	    return !listFournisseurs().iterator().hasNext();
	}
}
