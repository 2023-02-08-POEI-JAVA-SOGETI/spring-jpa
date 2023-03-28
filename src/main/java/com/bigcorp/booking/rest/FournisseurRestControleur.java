package com.bigcorp.booking.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.ArticleRestDto;
import com.bigcorp.booking.dto.FournisseurRestDto;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;

@RequestMapping("/rest/fournisseur")
@RestController
public class FournisseurRestControleur {

	@Autowired
	private FournisseurService fournisseurService;
	@Autowired
	private ArticleService articleService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurRestControleur.class);
	
	@GetMapping("/{id}")
	public FournisseurRestDto getFournisseurById(@PathVariable("id") Integer id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		if (fournisseur == null) {
			LOGGER.info("getFournisseurById : Fournisseur non trouvé - renvoi 404");	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun fournisseur trouvé avec l'id " + id);			
		}
		LOGGER.info("getFournisseurById : Fournisseur " + fournisseur.getId() + " récupéré de la BDD");
		return new FournisseurRestDto(fournisseur);
	}
	
	@GetMapping("/{id}/articles")
	public FournisseurRestDto getFournisseurByIdWithArticles(@PathVariable("id") Integer id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		if (fournisseur == null) {
			LOGGER.info("getFournisseurByIdWithArticles : Fournisseur non trouvé - renvoi 404");	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun fournisseur trouvé avec l'id " + id);			
		}
		LOGGER.info("getFournisseurByIdWithArticles : Fournisseur " + fournisseur.getId() + " récupéré de la BDD");
		
		List<Article> listArticles = articleService.findByFournisseurId(id);

		LOGGER.info("getFournisseurByIdWithArticles : Liste d'articles liés au fournisseur récupérés");
		List<ArticleRestDto> listArticlesDto = new ArrayList<>();
		
		if (listArticles != null) {
			// transformation en liste d'ArticleRestDto
			listArticlesDto = listArticles.stream().map(a -> new ArticleRestDto(a)).toList();			
		}
		
		FournisseurRestDto fournisseurRestDto = new FournisseurRestDto(fournisseur);
		fournisseurRestDto.setArticlesDto(listArticlesDto);
		return fournisseurRestDto;
	}
	
	@PostMapping("")
	public FournisseurRestDto createFournisseur(@Validated @RequestBody FournisseurRestDto fournisseur, BindingResult result) {
		if (result.hasErrors()) {
			LOGGER.info("createFournisseur : Erreur de format de données");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur de format de données");
		}
		Fournisseur f = new Fournisseur();
		fournisseur.remplisFournisseur(f);
		
		Fournisseur savedFournisseur = fournisseurService.save(f); 
		LOGGER.info("createFournisseur : Fournisseur " + savedFournisseur.getId() + " persisté");
		
		return new FournisseurRestDto(savedFournisseur);
	}	
	
	@DeleteMapping("/{id}")
	public void deleteFournisseur(@PathVariable("id") Integer id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		if (fournisseur == null) {
			LOGGER.info("deleteFournisseur : Fournisseur non trouvé - renvoi 404");	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun fournisseur à supprimer avec l'id " + id);			
		}
		LOGGER.info("deleteFournisseur : Fournisseur " + fournisseur.getId() + " identifié et supprimé");
		fournisseurService.deleteById(id);
	}
}
