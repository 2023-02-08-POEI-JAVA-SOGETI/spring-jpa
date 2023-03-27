package com.bigcorp.booking.mvc.rest;

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

import com.bigcorp.booking.mvc.rest.dto.ArticleRestDto;
import com.bigcorp.booking.service.ArticleService;

import tp_spring_jpa_pablo.model.Article;

@RestController
public class ArticleRestControleur {   
    
	@Autowired
    private ArticleService articleService;
	
	@GetMapping("/article/get/{articleid}")
	public ArticleRestDto getByIdPath(@PathVariable("articleid") Integer articleid) {
		Article article = articleService.findById(articleid);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : "
					+ articleid);
		}
		return new ArticleRestDto(article);
	}
	
	@GetMapping("/article/get")
	public ArticleRestDto getByIdParameter(@RequestParam("id") Integer id) {
		Article article = articleService.findById(id);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : "
					+ id);
		}
		return new ArticleRestDto(article);
	}
	
	@PostMapping("/article/save")
	public ArticleRestDto saveArticle(@RequestBody ArticleRestDto articleRestDto) {
	    Article article = new Article();
	    article = articleRestDto.remplisArticle(article);
	    article = articleService.save(article);
	    return new ArticleRestDto(article);
	}

	@DeleteMapping("/article/delete/{articleid}")
	public void deleteArticle(@PathVariable("articleid") Integer articleid) {
		Article article = articleService.findById(articleid);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : "
					+ articleid);
		}
		articleService.deleteById(articleid);
	}
    
    
}