package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller // indique à spring que la classe peut traiter des requetes http
public class PageFournisseursController {
	
	@Autowired
	private FournisseurService fournisseurService;
	/**
	 * Intercepte les requêtes /salut , effectue des instructions (ici un simple
	 * System.out) puis renvoie vers la vue salut.
	 * 
	 * @return
	 */
	@RequestMapping("/pagefournisseurs")
	public String maPage1() {
		System.out.println("Le contrôleur de la page des fournisseurs agit ! ");
		return "ma-page-fournisseurs";
	}
	
	@RequestMapping("/fournisseur1")
	public String maPageFournisseur1() {
		System.out.println("Le contrôleur de la page de fournisseur1 agit ! ");
		return "fournisseur1";
	}
	
	@RequestMapping("/fournisseur2")
	public String maPageFournisseur2() {
		System.out.println("Le contrôleur de la page de fournisseur2 agit ! ");
		return "fournisseur2";
	}
	
	@ModelAttribute("toto")
	public Boolean monBoolean() {
		Boolean toto = true;
		return toto;
	}
	
	@ModelAttribute("listeFournisseurs")

	public Iterable<Fournisseur> mesFournisseurs() {

		return fournisseurService.findAll();
	}

}