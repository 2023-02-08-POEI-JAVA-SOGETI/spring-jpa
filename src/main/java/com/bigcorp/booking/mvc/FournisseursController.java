package com.bigcorp.booking.mvc;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;

@Controller
public class FournisseursController {
	
	@Autowired
	FournisseurService fournisseurService;
	
	@RequestMapping("/fournisseurs")
	public String showFournisseurs() {
		System.out.println("Works");
		
		return "fournisseurs";
	}
	
	@ModelAttribute("fournisseurs")
	public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
		
		return fournisseurs;
	}
	
	@RequestMapping("/fournisseurs")
	public ModelAndView getFournisseurDetails(@RequestParam("id") Long id) {

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("fournisseurs");
		mav.addObject(this.getFournisseurs().get(id.intValue()));
		
		return mav;
	}
}
