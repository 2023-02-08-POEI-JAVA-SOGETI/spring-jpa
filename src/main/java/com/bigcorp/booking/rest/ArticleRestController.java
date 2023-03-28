package com.bigcorp.booking.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.dto.ArticleDto;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;




@RestController
public class ArticleRestController {
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/restArticle/{articleId}")
	public ArticleDto getById(@PathVariable("articleId") Integer articleId) {
	    Article article = articleService.findById(articleId);
	    if (article == null) {
	        throw new ResponseStatusException(
	            HttpStatus.NOT_FOUND, "Client not found with ID: " + articleId);
	    }
	    ArticleDto articleDto = new ArticleDto(article);
	    return articleDto;
	}
	@GetMapping("/restArticles")
	public List<ArticleDto> getAllClient() {
		List<Article> articles =  (List<Article>) articleService.findAll();
		List<ArticleDto> articlesDto = new ArrayList<>();
		for (Article article : articles) {
			articlesDto.add(new ArticleDto(article));
		}
		return articlesDto;
	}
	
	@DeleteMapping("/restArticle/{articleId}/delete")
	public void deleteById(@PathVariable("articleId") Integer articleId) {
	    articleService.delete(articleId);
	}
	
	@PostMapping("/restArticle/{articleId}")
	public ArticleDto save(@RequestBody ArticleDto articleDto) {
	    Article article = new Article(articleDto);		
	    article = articleService.save(article);
	    return new ArticleDto(article);
	}
}
