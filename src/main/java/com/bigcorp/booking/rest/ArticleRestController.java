package com.bigcorp.booking.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/articles")
public class ArticleRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleRestController.class);
	
	@Autowired
	private ArticleService articleService;
	
	//exercice 1 du 24.03.23
//	@GetMapping("/articles/{articleId}")
//	public Article getById(@PathVariable("articleId") Integer articleId) {
//		Article article = new Article();
//		article.setId(articleId);
//		article.setNom("monArticleREST");
//		article.setDescription("la description de mon article REST");
//		return article;
//	}
//	@GetMapping("/articles")
//	public Article getByIdParam(@RequestParam("articleId") Integer articleId) {
//		Article article = new Article();
//		article.setId(articleId);
//		article.setNom("monArticleREST ac requestParam");
//		article.setDescription("la description de mon article REST via requestParam");
//		return article;
//	}
	
	//exercice 2 du 24.03.23 
	@GetMapping("/{articleId}")
	public ArticleRestDto getById(@PathVariable("articleId") Integer articleId) {
		LOGGER.info("Appel méthode getById() de ArticleRestController.java <=> request HTTP GET");
		Article article = articleService.findById(articleId);
		if(article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}	
		return new ArticleRestDto(article);
	}
	
	@DeleteMapping("/{articleId}")
	public void deleteById(@PathVariable("articleId") Integer articleId) {
		LOGGER.info("Appel méthode deleteById() de ArticleRestController.java <=> request HTTP DELETE");
		Article article = articleService.findById(articleId);
		if(article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article n'est présent en BDD avec l'id : " + articleId);
		}
		articleService.delete(articleId);
	}
	
	@PostMapping
	public ArticleRestDto save(@RequestBody ArticleRestDto articleRestDto) {		
		LOGGER.info("Appel méthode save() de ArticleRestController.java <=> request HTTP POST");
		//Transformer le DTO en entité
		Article article = new Article();
		articleRestDto.remplisArticle(article);
		//Sauvegarder l'entité
		article = articleService.save(article);
		
		//Transmettre en réponse le DTO
		return new ArticleRestDto(article);
	}
	
//	@GetMapping
//	public List<ArticleRestDto> findAll() {
//		LOGGER.info("Appel méthode findAll() de ArticleRestController.java <=> request HTTP GET sur tous les articles");
//		List<Article> articles = articleService.findAll();
//		if(articles == null) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
//		}
//		MANQUE BOUCLE SUR ARTICLES TROUVES POUR 
//		return new ArticleRestDto(article);
//	}
}
