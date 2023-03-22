package com.bigcorp.booking.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;

@Controller
public class ArticlesControleur {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/articles")
	public String showArticles() {
		return "articles";
	}
	
    @ModelAttribute("listArticles")
    public List<Article> populateArticles() {
    	return articleService.findAll();
    }
}
