package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Camion;
import com.bigcorp.booking.service.FournisseurService;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller
public class ExoControleur {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@RequestMapping("/exocontroleur")
	public String showSayHello() {
		System.out.println("Le contrôleur de l'exo agit ! ");
		return "vue-exo-controleur";
	}

	@RequestMapping("/camions/{id}")
	public ModelAndView afficheDetailCamionParChemin(@PathVariable("id") int id) {
		System.out.println("J'affiche le détail du camion à partir du chemin : " + id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-detail-camion");
		mav.addObject("camion", new Camion(id, "Volvo"));
		return mav;

	}
	
	@RequestMapping("/camions")
	public ModelAndView afficheDetailCamionParCheminRequestParam(@RequestParam("id") int id) {
		System.out.println("J'affiche le détail du camion à partir du chemin : " + id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-detail-camion");
		mav.addObject("camion", new Camion(id, "Volvo"));
		return mav;

	}

	@ModelAttribute("monMessage")
	public String metMessageDansContexte() {
		return "Voici mon message généré dynamiquement grâce à ThymeLeaf et au @ModelAttribute de Spring MVC";
	}

	@ModelAttribute("booleenAffichage")
	public boolean metBoleenAffichageDansContexte() {
		return true;
	}

	@ModelAttribute("listeElements")
	public ArrayList<String> metListeDansContexte() {
		ArrayList<String> liste = new ArrayList<>();
		liste.add("element1");
		liste.add("element2");
		liste.add("element3");
		return liste;
	}

	@ModelAttribute("listeCamion")
	public ArrayList<Camion> metListeCamionDansContexte() {
		ArrayList<Camion> listeCamion = new ArrayList<>();
		listeCamion.add(new Camion(0, "Camion Volvo"));
		listeCamion.add(new Camion(1, "Camion Renault"));
		listeCamion.add(new Camion(2, "Camion Mercedes"));
		return listeCamion;
	}
	
	@RequestMapping("/fournisseurs")
	public ModelAndView afficheListeFournisseurs() {
		ModelAndView mav = new ModelAndView("fournisseurs");
		mav.setViewName("vue-liste-fournisseurs");
		mav.addObject("fournisseurs", fournisseurService.findAll());
		return mav;
	}
	

	
	@RequestMapping("/fournisseurs/edit")
	public ModelAndView afficheFormulaireEditionFournisseurParCheminRequestParam(@RequestParam("id") int id) {
		System.out.println("J'affiche le formulaire d'édition du fournisseur à partir du chemin : " + id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-edition-fournisseur");
		mav.addObject("fournisseur", fournisseurService.findById(id));
		return mav;


	}

}