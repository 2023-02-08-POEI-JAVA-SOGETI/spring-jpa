//package com.bigcorp.booking.mvc;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//import org.springframework.stereotype.Controller;
//
//import org.springframework.validation.BindingResult;
//
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.bigcorp.booking.model.Articles;
//
//import com.bigcorp.booking.service.ArticlesService;
//
//
//@Controller
//public class ArtcilesControleur {
//	
//	@Autowired
//	private ArticlesService articleService;
//	
//	@RequestMapping("/liste-artciles")
//    public String showListArticles() {
//    	System.out.println("La page 'liste des articles' s'affiche mais elle est encore vide ! ");
//        return "vue-article";
//    }	
//	
//	//liste articles avec lien hypertexte (page1)
//	@ModelAttribute("article")
//	public Iterable<Articles> metDansLeContexteConnexion() {
//		return articleService.findAll();
//	}
//	
////	// Affiche la page de formulaire pour un fournisseur donné (page2)
////	 @RequestMapping("/formulaire-fournisseur/{id}")
////	   
////	 public ModelAndView afficheFournisseur(@PathVariable("id") Integer id) {
////		 Fournisseurs fournisseur = fournisseurService.findById(id);
////		 System.out.println("J'affiche le détail du fournisseur : " + id);
////		 ModelAndView mav = new ModelAndView();
////		 mav.setViewName("vue-formulaire-fournisseur");
////		 mav.addObject("fournisseur", fournisseur);
////		 return mav;
////		 }
////       	
////	// formulaire de modification pour un fournisseur donné
////    @PostMapping("/formulaire-fournisseur/{id}")
////    public String modificationFournisseur(@PathVariable("id") Integer id,
////                                         @ModelAttribute("fournisseur") Fournisseurs fournisseur,
////                                         BindingResult result) {
////        if (result.hasErrors()) {
////            return "formulaire-fournisseur";
////        }
////        fournisseur.setId(id);
////        fournisseurService.save(fournisseur);
////        return "redirect:/formulaire-fournisseur/{id}";
////    }
//}
//
