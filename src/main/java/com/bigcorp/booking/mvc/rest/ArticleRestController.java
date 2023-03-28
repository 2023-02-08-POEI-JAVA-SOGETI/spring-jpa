package com.bigcorp.booking.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.mvc.rest.dto.ArticleRestDto;
import com.bigcorp.booking.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {
	
	@Autowired
	private ArticleService articleService;
	
	@PostMapping
	public ArticleRestDto save(@RequestBody ArticleRestDto articleRestDto) {
		Article article = new Article();
		articleRestDto.remplisArticle(article);
		
		article = articleService.save(article);
		articleService.attache(article.getId(), articleRestDto.getFournisseurId());
		
		return new ArticleRestDto(this.articleService.findById(article.getId()));
	}
	
	public ArticleRestDto get(@PathVariable("id") Integer id) {
		return new ArticleRestDto(this.articleService.findById(id));
	}

}
