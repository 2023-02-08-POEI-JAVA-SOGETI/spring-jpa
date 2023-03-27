package com.bigcorp.booking.rest;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.rest.dto.ArticleRestDto;
import com.bigcorp.booking.service.ArticleService;

import jakarta.validation.Valid;

@RequestMapping("/rest/article")
@RestController
public class ArticleRestControleur {

	@Autowired
	private ArticleService articleService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleRestControleur.class);
	
	@GetMapping("/{id}")
	public ArticleRestDto getArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.findById(id);
		if (article == null) {
			LOGGER.info("getARticleById : Article non trouvé - renvoi 404");	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun article trouvé avec l'id " + id);			
		}
		LOGGER.info("getARticleById : Article " + article.getId() + " récupéré de la BDD");
		return new ArticleRestDto(article);
	}
	
	//variante de la méthode getArticleById avec un request param
//	@RequestMapping("/restparam/article")
//	public Article displayParamArticle(@RequestParam("id") Integer id) {
//		return articleService.findById(id);
//	}
	
	@DeleteMapping("/{id}")
	public void deleteArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.findById(id);
		if (article == null) {
			LOGGER.info("deleteArticleById : Article non trouvé - renvoi 404");	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun article à supprimer avec l'id " + id);			
		}
		LOGGER.info("deleteArticleById : Article " + article.getId() + " identifié et supprimé");
		articleService.deleteById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<ArticleRestDto> createArticle(@Valid @RequestBody ArticleRestDto articleFromBody, BindingResult result) {
		if (result.hasErrors()) {
			//concaténation des erreurs liées aux champs non valides
			String reason = "Erreur : " + result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" "));
			LOGGER.info("createArticle : " + reason);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, reason);
			//return new ResponseEntity<>(articleFromBody, HttpStatus.BAD_REQUEST);
		}
		
		Article article = new Article();
		articleFromBody.updateArticleWith(article);

		Article savedArticle = articleService.save(article);
		LOGGER.info("createArticle : Article " + article.getId() + " persisté");
		
		savedArticle = articleService.saveArticleAndFournisseur(savedArticle.getId(), articleFromBody.getFournisseurId());
		LOGGER.info("createArticle : Article " + article.getId() + " associé au fournisseur " + articleFromBody.getFournisseurId());
		
		return new ResponseEntity<>(new ArticleRestDto(savedArticle), HttpStatus.CREATED);
	}
}
