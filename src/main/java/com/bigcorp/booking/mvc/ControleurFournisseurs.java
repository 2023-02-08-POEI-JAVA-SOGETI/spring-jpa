package com.bigcorp.booking.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.service.spring.ArticleSpringService;
import com.bigcorp.booking.service.spring.FournisseurSpringService;
import com.bigcorp.booking.model.Fournisseurs;

@Controller
public class ControleurFournisseurs {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleSpringService.class);
	@Autowired
	private FournisseurSpringService fournisseurService;

	@RequestMapping("/fournisseurs")
	private ModelAndView showPageFournisseurs() {
		LOGGER.info("Affichage de la page des fournisseurs");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-fournisseurs");
		Iterable<Fournisseurs> fournisseursIterable = fournisseurService.findAll();
		mav.addObject("fournisseursModel", fournisseursIterable);
		LOGGER.info("Rendu de la page des fournisseurs terminé");
		return mav;

	}

	@RequestMapping("/fournisseurs/{id}")
	private ModelAndView showPageFournisseur(@PathVariable("id") int id) {
		LOGGER.info("Affichage de la page du fournisseur avec l'ID {}", id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vue-fournisseur");
		Fournisseurs fournisseurById = fournisseurService.findById(id);
		mav.addObject("fournisseurModel", fournisseurById);
		LOGGER.info("Rendu de la page du fournisseur avec l'ID {} terminé", id);
		return mav;
	}

	@PostMapping("/fournisseurs/{id}")
	public ModelAndView processSubmit(@Validated @ModelAttribute("fournisseurModel") Fournisseurs fournisseur,
			BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			//modelAndView.setViewName("redirect:/fournisseurs/" + fournisseur.getiD());
			modelAndView.setViewName("vue-fournisseur");
			modelAndView.addObject("fournisseurModel", fournisseur);
			LOGGER.warn("Erreur lors de la soumission du fournisseur avec l'ID {}", fournisseur.getiD());
			return modelAndView;
		}

		String view = "redirect:/fournisseurs/" + fournisseur.getiD();

		ModelAndView mav = new ModelAndView(view);
		mav.addObject("fournisseur", fournisseur);

		fournisseurService.save(fournisseur);
		LOGGER.info("Modification réussie dans la BDD pour le fournisseur avec l'ID {}", fournisseur.getiD());
		return mav;
	}
}
