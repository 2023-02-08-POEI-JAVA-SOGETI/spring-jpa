package com.bigcorp.booking.mvc;

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

import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

@Controller
public class UtilisateurController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);
	
    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping("/utilisateurs")
    public String index(Model model) {
	    LOGGER.info("Affichage de l'index Utilisateurs");
        return "index-utilisateur";
    }

    @GetMapping("/utilisateur/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) {
    	LOGGER.info("Affichage de l'article avec l'ID : {}", id);
        Utilisateur utilisateur = utilisateurService.findById(id);
        LOGGER.debug("Article trouvé : {}", utilisateur);
        ModelAndView show = new ModelAndView("show-utilisateur");
        show.addObject("utilisateur", utilisateur);
        return show;
    }

    @GetMapping("/utilisateur/new")
    public String newUtilisateur(Model model) {
    	LOGGER.info("Affichage du formulaire de création d'un nouvel article");
    	model.addAttribute("utilisateur", new Utilisateur());
    	return  "new-utilisateur";
    }

    @PostMapping("/utilisateur/create")
    public String createUtilisateur(@ModelAttribute("utilisateur") @Valid Utilisateur utilisateur, BindingResult result) {
    	utilisateur.setNumero_employe(new Random().nextInt());
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la création de l'utilisateur {}", utilisateur);
            return "new-utilisateur";
        }
        LOGGER.info("Création de l'utilisateur {}", utilisateur);
        utilisateurService.save(utilisateur);
        LOGGER.info("Utilisateur créée avec succès {}", utilisateur);
        return "redirect:/utilisateur/" + utilisateur.getId();
    }

    @GetMapping("/utilisateur/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
    	LOGGER.info("Affichage du formulaire de modification de l'utilisateur {}", id);
    	Utilisateur utilisateur = utilisateurService.findById(id);
        model.addAttribute("utilisateur", utilisateur);
        return "edit-utilisateur";
    }

    @PostMapping("/utilisateur/save")
    public String updateUtilisateur(@ModelAttribute("utilisateur") @Valid Utilisateur utilisateur,
                             BindingResult result) {
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la modification de l'utilisateur  {}", utilisateur);
            return "update_utilisateur";
        }
        LOGGER.info("Modification de l'utilisateur  {}", utilisateur);
        utilisateurService.save(utilisateur);
        LOGGER.info("Utilisateur modifié avec succès");
        return "redirect:/utilisateur/" + utilisateur.getId();
    }

    @PostMapping("/utilisateur/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
        utilisateurService.delete(id);
        return "redirect:/utilisateurs";
    }
    
    @ModelAttribute("listUtilisateurs")
	public Iterable<Utilisateur> listUtilisateurs() {
	    LOGGER.debug("Récupération de la liste des Utilisateurs");
	    return utilisateurService.findAll();
	}

	@ModelAttribute("isUtilisateursListEmpty")
	public Boolean isEmpty() {
		Boolean isEmpty = !listUtilisateurs().iterator().hasNext();
		 LOGGER.info("Vérification si la liste des Utilisateurs est vide : {}", isEmpty);
	    return !listUtilisateurs().iterator().hasNext();
	}
}
