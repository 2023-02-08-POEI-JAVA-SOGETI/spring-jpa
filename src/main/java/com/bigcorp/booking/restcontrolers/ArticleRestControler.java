package com.bigcorp.booking.restcontrolers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;

@RestController
public class ArticleRestControler {

	@Autowired
	private ArticleService articleService;

	// Répondra par ex. à l'URL /articles/33
	@GetMapping("/articles/{articleId}")
	public Article getByIdPathVariable(@PathVariable("articleId") Integer articleId) {
		Article article = new Article();
		article.setId(articleId);
		article.setNom("Salut !!!");
		return article;
	}

	// Répondra par ex. à l'URL /articles?articleId=33
	@GetMapping("/articles")
	public Article getByIdRequestParam(@RequestParam("articleId") Integer articleId) {
		Article article = new Article();
		article.setId(articleId);
		article.setNom("Salut !!!");
		return article;
	}

	@GetMapping("/articles-avec-dto/{articleId}")
	public ArticleRestDto getByIdPathVariableDto(@PathVariable("articleId") Integer articleId) {
		Article article = articleService.findById(articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}
		return new ArticleRestDto(article);
	}

	@PostMapping("/articles")
	public ArticleRestDto createOrUpdateArticle(@RequestBody ArticleRestDto articleRestDto) {
		
		// On instancie un Article à partir du Dto Article passé en parampètre
		Article article = new Article();
		articleRestDto.remplieArticle(article);
		
		// sauvegarde l'entité
		article = articleService.save(article);
		return new ArticleRestDto(article);
		
	}
}