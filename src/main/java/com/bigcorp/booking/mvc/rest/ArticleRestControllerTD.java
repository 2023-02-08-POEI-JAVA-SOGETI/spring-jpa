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
import com.bigcorp.booking.service.ArticleServiceTD;

@RestController
public class ArticleRestControllerTD {
	
	@Autowired 
	private ArticleServiceTD articleServiceTP;

	@GetMapping("/rest/get_articles/{articleId}")
	public ArticleRestDtoTD getById(@PathVariable("articleId") Integer articleId) {
		
// J'ai tenté d'écrire "Article article1 = ArticleServiceTP.findById(articleId);" mais Eclipse me le refusait en 
// considérant articleService en statique et findById en nn statique, donc j'ai changé artcileService car changer
// findById me déclenchait d'autres problèmes. 
		
		ArticleServiceTD articleService = new ArticleServiceTD();
		Article article1 = articleService.findById(articleId); 
		
		if (article1 == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : "
					+ articleId);
			}
		return new ArticleRestDtoTD (article1);
	}
	

	@DeleteMapping("/rest/delete_articles/{articleId}")
     public void deleteById(@PathVariable("id") Integer id) {
		ArticleServiceTD articleService = new ArticleServiceTD();
		Article article1 = articleService.findById(id);
		if (article1 == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'article trouvé avec l'id : "
				+ id);
		}
		articleService.delete(id);
	
	}
	

	@PostMapping("/rest/save_articles")
	public ArticleRestDtoTD save(@RequestBody ArticleRestDtoTD articleRestDto) {
		
		// Transformer le DTO en entité
		Article article1 = new Article();
		articleRestDto.remplisArticles(article1);
		
		// Sauvegarder l'entité - Même problématique que dans Get
		ArticleServiceTD articleService = new ArticleServiceTD();
		article1 = articleService.save(article1);

		// transmetttre en réponse le DTO
		return new ArticleRestDtoTD(article1);
	}


}