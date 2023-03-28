package com.bigcorp.booking.mvc;

import java.util.Random;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;

@Controller
public class FournisseurController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurController.class);
	
	@Autowired
	private FournisseurService fournisseurService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/fournisseurs")
	public String index() {
	    LOGGER.info("Affichage de l'index fournisseur");
	    return "index-fournisseur";
	}
	
	@RequestMapping("/fournisseur/{id}")
	public ModelAndView show(@PathVariable("id") Integer id) {
	    LOGGER.info("Affichage du fournisseur avec l'ID : {}", id);
	    Fournisseur fournisseur = fournisseurService.findByIdWithArticles(id);
	    LOGGER.debug("Fournisseur trouvé : {}", fournisseur);
	    ModelAndView show = new ModelAndView();
	    show.setViewName("show-fournisseur");
	    show.addObject("fournisseur", fournisseur);
	    return show;
	}
	
	@GetMapping("/fournisseur/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
	    LOGGER.info("Affichage de la page de modification pour le fournisseur avec l'ID : {}", id);
	    Fournisseur fournisseur = fournisseurService.findById(id);
	    LOGGER.debug("Fournisseur trouvé : {}", fournisseur);
	    model.addAttribute("fournisseur", fournisseur);
	    return "edit-fournisseur";
	}
	
	@RequestMapping("/fournisseur/new")
	public String newFournisseur(Model model) {
	    LOGGER.info("Affichage de la page de création d'un nouveau fournisseur");
	    model.addAttribute("fournisseur", new Fournisseur());
	    return "new-fournisseur";
	}
	
	@PostMapping("/fournisseur/create")
	public String createFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur, BindingResult result) {
	    LOGGER.info("Création d'un nouveau fournisseur : {}", fournisseur);
	    if (result.hasErrors()) {
	        return "new-fournisseur";
	    }
	    fournisseur.setNumero_fournisseur(new Random().nextInt());
	  
	    fournisseurService.save(fournisseur);
	    LOGGER.debug("Fournisseur créé avec succès : {}", fournisseur);
	    return "redirect:/fournisseur/" + fournisseur.getId();
	}
	
	@PostMapping("/fournisseur/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {
	    LOGGER.info("Suppression du fournisseur avec l'ID : {}", id);
	    fournisseurService.delete(id);
	    return "redirect:/fournisseurs";
	}


	@PostMapping("/fournisseur/save")
	public String save(@ModelAttribute("fournisseur") Fournisseur fournisseur, BindingResult bindingResult) {
		LOGGER.info("Sauvegarde du fournisseur : {} ", fournisseur);
		if (bindingResult.hasErrors()) {
			return "edit-fournisseur";
		} else {
			fournisseurService.save(fournisseur);
			LOGGER.info("Fournisseur sauvegardé avec succès : {}", fournisseur);
			return "redirect:/fournisseur/" + fournisseur.getId();			
		}
	}
	
	@ModelAttribute("listFournisseurs")
	public Iterable<Fournisseur> listFournisseurs() {
		LOGGER.info("Récupération de la liste des fournisseurs");
	    return fournisseurService.findAll();
	}
	
	@ModelAttribute("listArticles")
	public Iterable<Article> listArticles() {
		LOGGER.info("Récupération de la liste des articles");
	    return articleService.findAll();
	}

	@ModelAttribute("isFournisseursListEmpty")
	public Boolean isEmpty() {
		boolean isEmpty = !listFournisseurs().iterator().hasNext();
		LOGGER.info("Vérification si la liste des fournisseurs est vide {}", isEmpty);
	    return !listFournisseurs().iterator().hasNext();
	}
}
