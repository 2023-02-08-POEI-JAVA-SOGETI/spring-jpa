package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.service.exception.FournisseurException;

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
	// Sans le ModelAndView
//	@RequestMapping("/pagefournisseurs")
//	public String affichFournisseurs() {
//		System.out.println("Le contrôleur de la page des fournisseurs agit ! ");
//		return "ma-page-fournisseurs";
//	}
	// Avec le ModelAndView
	@RequestMapping("/pagefournisseurs")
	public ModelAndView affichFournisseurs() {
		System.out.println("Le contrôleur de la page des fournisseurs2 agit ! ");

		Iterable<Fournisseur> fournisseurs = fournisseurService.findAll();

		// Creation de l'objet modele
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ma-page-fournisseurs");
		mav.addObject("listefournisseurs", fournisseurs);
		return mav;
	}

	@RequestMapping("/pageDetailFournisseurs")
	public ModelAndView affichDetailFournisseurs(@RequestParam("id") Integer id) {
		System.out.println(
				"Le contrôleur de la page de détail des fournisseurs agit et affiche le fournisseur avec l'id : {}"
						+ id);

		Fournisseur fournisseur = fournisseurService.findById(id);

		// Creation de l'objet modele
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ma-page-detail-fournisseurs");
		mav.addObject("fournisseur", fournisseur);
		return mav;
	}

	@PostMapping("/pageSauvegardeFournisseurs")
	public ModelAndView submitForm(@Validated @ModelAttribute("fournisseur") Fournisseur fournisseur,
			BindingResult result) throws FournisseurException {
		if (result.hasErrors()) {
			// return new ModelAndView("fournisseur", "fournisseur", fournisseur);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("ma-page-detail-fournisseurs");
			mav.addObject("fournisseur", fournisseur);
			return mav;
		}
		Fournisseur fournisseurSauvegarde = fournisseurService.sauvegarde(fournisseur);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/pageDetailFournisseurs?id="+fournisseurSauvegarde.getId());
		return mav;
	}

	/**
	 * @RequestMapping("/fournisseur1") public String maPageFournisseur1() {
	 * System.out.println("Le contrôleur de la page de fournisseur1 agit ! ");
	 * return "fournisseur1"; }
	 * 
	 * @RequestMapping("/fournisseur2") public String maPageFournisseur2() {
	 * System.out.println("Le contrôleur de la page de fournisseur2 agit ! ");
	 * return "fournisseur2"; }
	 * 
	 * @ModelAttribute("toto") public Boolean monBoolean() { Boolean toto = true;
	 * return toto; }
	 */
//	@ModelAttribute("listeFournisseurs")
//
//	public Iterable<Fournisseur> mesFournisseurs() {
//
//		return fournisseurService.findAll();
//	}

}