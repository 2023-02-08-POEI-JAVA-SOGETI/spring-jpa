package com.bigcorp.booking.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleServiceTP;

@RestController
public class ArticleControllerTD {

	@GetMapping("/rest/articles/{articleId}")
	public ArticleControllerTD getById(@PathVariable("articleId") Integer articleId) {
		
		// J'ai tenté d'écrire "Article article1 = ArticleServiceTP.findById(articleId);" mais Eclipse me le refusait en 
		// considérant articleService en statique et findById en nn statique, donc j'ai changé artcileService car changer
		// findById me déclenchait d'autres problèmes. 
		
		ArticleServiceTP articleService = new ArticleServiceTP();
		Article article1 = articleService.findById(articleId); 
		
		if (article1 == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : "
					+ articleId);
			}
		return this;
		//return new ArticleControllerTD (article1);
	}
}