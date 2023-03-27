package com.bigcorp.booking.mvc;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;

@RestController
public class FournisseurControleur {

	
	private FournisseurService fournisseurService;
		
	public FournisseurControleur(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	
	@RequestMapping("/fournisseur/{id}")
	public ModelAndView displayFournisseur(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fournisseur");
		
		Fournisseur f = fournisseurService.findById(id);
		mav.addObject("fournisseur", f);
		return mav;
	}
	
	@PostMapping("/fournisseur")
	public ModelAndView processSubmit(@ModelAttribute("fournisseur") Fournisseur f, BindingResult result) {
		String view = "fournisseur";
		if (f != null && f.getId() != null)
			view = "redirect:/fournisseur/" + f.getId();
		
		ModelAndView mav = new ModelAndView(view);
		
		mav.addObject("fournisseur", f);
		if (result.hasErrors())
			return mav;
		fournisseurService.save(f);
		return mav;
	}
	
	@RequestMapping("/restFournisseur/{id}")
	public Fournisseur restFournisseur(@PathVariable("id") Integer id) {
		return new Fournisseur(1,"aaa", "bbb", "ccc");
	}
}
