package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.mvc.rest.dto.ArticleRestDto;
import com.bigcorp.booking.service.ArticleService;

/**
 * Ici, on place "/articles" sur
 * la classe. Ceci servira de préfixe à toutes 
 * les URLs que les méthodes traitent. Du coup, il sera inutile
 * de répéter /articles dans tous les RequestMapping, PostMapping, GetMapping ...
 * des méthodes annotées. Le contrôleur fonctionne à peu près correctement
 * en conditions nominales, mais il lui manque du code pour envoyer des 400 et 404 
 * en cas de requêtes invalides. cf.  {@link FournisseurRestController} pour un contrôleur
 * plus 'REST'
 */
@RestController
@RequestMapping("/articles")
public class ArticleRestController {
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * Cette méthode ré utilise la méthode attache. Par contre, 
	 * elle ne fait aucune validation, ce qui n'est pas terrible...
	 * @param articleRestDto
	 * @return
	 */
	@PostMapping
	public ArticleRestDto save(@RequestBody ArticleRestDto articleRestDto) {
		Article article = new Article();
		articleRestDto.remplisArticle(article);
		
		article = articleService.save(article);
		articleService.attache(article.getId(), articleRestDto.getFournisseurId());
		
		return new ArticleRestDto(this.articleService.findById(article.getId()));
	}
	
	/**
	 * Cette méthode fonctionne aussi, mais ne renverra pas une 404 en cas de problème.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ArticleRestDto get(@PathVariable("id") Integer id) {
		return new ArticleRestDto(this.articleService.findById(id));
	}

}
