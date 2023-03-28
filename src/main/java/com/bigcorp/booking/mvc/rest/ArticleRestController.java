package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.mvc.rest.dto.ArticleRestDto;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;

@RestController
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;

	// Requête n'allant pas sur la base (juste à partir du model)
//	@GetMapping("/articles/{articleId}")
//	public Article getById(@PathVariable("articleId") Integer articleId) {
//		Article article = new Article();
//		article.setId(articleId);
//		article.setNom("Salut !!!");
//		return article;
//	}

	// Requêtes CRUD sur la base
	// Get
	@GetMapping("/articles/{articleId}")
	public ArticleRestDto getById(@PathVariable("articleId") Integer articleId) {

		// Trouve l'article par son id et le stock dans la variable article
		Article article = articleService.findById(articleId);

		// Pour générer une erreur 404 lors que l'id de l'article n'existe pas
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}
		// Retourne le DTO préalablement chargé avec l'article trouvé et stocké dans la
		// variable article
		return new ArticleRestDto(article);
	}

	// DELETE
	@DeleteMapping("/articles/{articleId}")
	public void supprimer(@PathVariable("articleId") Integer articleId) {
		// Pour générer une erreur 404 lors que l'id de l'article n'existe pas
		Article article = articleService.findById(articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
			// Si non effectuer la suppression
		}
		articleService.supprimer(articleId);
	}
	
	//POST
	@PostMapping("/articles")
	public ArticleRestDto save(@RequestBody ArticleRestDto articleRestDto) {
		
		// Transformer le DTO en entité
		Article article = new Article();
		articleRestDto.remplisArticle(article);
		
		// sauvegarder l'entité
		article = articleService.sauvegarde(article);
		
		// transmetttre en réponse le DTO
		return new ArticleRestDto(article);
		
		}
		
}