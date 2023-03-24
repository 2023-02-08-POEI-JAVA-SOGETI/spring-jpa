package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.mvc.rest.dto.ArticleRestDto;
import com.bigcorp.booking.service.spring.ArticleSpringService;

@RestController
public class ArticleRestController {

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
		Article article = articleService.findById(articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}
		return new ArticleRestDto(article);
	}

	@GetMapping("/articles")
	public Article getByIdParamsEdition(@RequestParam("id") Integer articleId) {
		Article article = new Article();
		article.setiD(articleId);
		article.setNom("Ceci est un test");
		return article;
	}
	
	@DeleteMapping("/articles/{articleId}")
	public void deleteById(@PathVariable("articleId") Integer articleId) {
		Article article = articleService.findById(articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId + ", pas de suppression effectuée");
		}
		articleService.delete(articleId);
		System.out.println("J'ai supprimé l'article " + articleId);
	}
	
	/*@PostMapping("/articles}")
	public ArticleRestDto getById(@PathVariable("articleId") Integer articleId) {
		Article article = articleService.findById(articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}
		return new ArticleRestDto(article);
	}*/

}
