package com.bigcorp.booking.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import com.bigcorp.booking.service.spring.FournisseurSpringService;
import com.bigcorp.booking.model.Fournisseurs;


@Controller
public class ControleurFournisseurs {
	@Autowired
	private FournisseurSpringService fournisseurService;

	@RequestMapping("/fournisseurs")
	private ModelAndView showPageFournisseurs() {
		System.out.println("Le contrôleur de fournisseurs agit ! ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-fournisseurs");
		Iterable<Fournisseurs> fournisseursIterable = fournisseurService.findAll();
		mav.addObject("fournisseursModel", fournisseursIterable);
		System.out.println("Rendu terminé (normalement hein)");
		return mav;

	}

	@RequestMapping("/fournisseurs/{id}")
	private ModelAndView showPageFournisseur(@PathVariable("id") int id) {
		System.out.println("J'affiche le détail du fournisseur à partir du chemin : " + id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-fournisseur");
		Fournisseurs fournisseurById = fournisseurService.findById(id);
		mav.addObject("fournisseurModel", fournisseurById);
		System.out.println("Rendu terminé (normalement hein)");
		return mav;
	}

	// not done yet
	@PostMapping("/fournisseur")
	public ModelAndView processSubmit(@Validated @ModelAttribute("fournisseurModel") Fournisseurs fournisseur,
			BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/fournisseurs/" + fournisseur.getiD());
			modelAndView.addObject("fournisseurModel", fournisseur);
			return modelAndView;
		}

		String view = "redirect:/fournisseurs/" + fournisseur.getiD();

		ModelAndView mav = new ModelAndView(view);
		mav.addObject("fournisseur", fournisseur);
		if (result.hasErrors()) {
			return mav;
		} else {
			fournisseurService.save(fournisseur);
		}
		return mav;
	}
}
