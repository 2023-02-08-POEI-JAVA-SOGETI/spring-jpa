package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.service.spring.FournisseurSpringService;
import com.bigcorp.booking.model.Fournisseurs;

@Controller
public class ControleurFournisseurs {
	@Autowired
	private FournisseurSpringService fournisseurService;

	@RequestMapping("/fournisseurs")
	private ModelAndView showPageFournisseur() {
		System.out.println("Le contrôleur de fournisseurs agit ! ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-fournisseurs");
		/*Fournisseurs fourn1 = new Fournisseurs();
		Fournisseurs fourn2 = new Fournisseurs();
		Fournisseurs fourn3 = new Fournisseurs();
		fourn3.setNom("Emile");
		fourn2.setNom("Emule");
		fourn1.setNom("Emole");*/
		Iterable<Fournisseurs> fournisseursIterable = fournisseurService.findAll();
		/*fournisseursList.add(fourn1);
		fournisseursList.add(fourn2);
		fournisseursList.add(fourn3);*/
		mav.addObject("fournisseursModel", fournisseursIterable);
		System.out.println("Rendu terminé (normalement hein)");
		return mav;
		
	}
}
