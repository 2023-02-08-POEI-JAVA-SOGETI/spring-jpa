package com.bigcorp.booking.mvc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.mvc.ControleurFournisseurs;
import com.bigcorp.booking.mvc.rest.dto.ArticleRestDto;
import com.bigcorp.booking.service.spring.ArticleSpringService;

@RestController
public class ArticleRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControleurFournisseurs.class);
	@Autowired
	private ArticleSpringService articleService;

	/*
	 * @GetMapping("/articles/{articleId}") public Article
	 * getById(@PathVariable("articleId") Integer articleId) { Article article = new
	 * Article(); article.setiD(articleId); article.setNom("Ceci est un test");
	 * return article; }
	 */
	@GetMapping("/articles/{articleId}")
	public ArticleRestDto getById(@PathVariable("articleId") Integer articleId) {
		LOGGER.info("Recherche de l'article avec l'id : {}", articleId);
		Article article = articleService.findById(articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}
		return new ArticleRestDto(article);
	}

	@GetMapping("/articles")
	public ArticleRestDto getByIdParamsEdition(@RequestParam("id") Integer articleId) {
		Article article = articleService.findById(articleId);
		LOGGER.info("Recherche de l'article avec l'id : {}", articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}

		return new ArticleRestDto(article);
	}

	@DeleteMapping("/articles/{articleId}")
	public void deleteById(@PathVariable("articleId") Integer articleId) {
		Article article = articleService.findById(articleId);
		LOGGER.info("Suppression de l'article avec l'id : {}", articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucun article trouvé avec l'id : " + articleId + ", pas de suppression effectuée");
		}
		articleService.delete(articleId);
		LOGGER.info("Article avec l'id : {} a été supprimé avec succès", articleId);
	}

	@PostMapping("/articles")
	public ArticleRestDto post(@RequestBody ArticleRestDto articleRestDto) {
		LOGGER.info("Création ou modification d'un article");
		Article article = new Article();
		articleRestDto.remplisArticle(article);
		article = articleService.save(article);
		LOGGER.info("Article créé ou modifié avec succès : {}", article.getNom());
		return new ArticleRestDto(article);
	}

}
