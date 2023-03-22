package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;

@Controller
public class ArticleControleur {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/article/{id}")
	public ModelAndView displayArticle(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("article");
		
		Article a = articleService.findById(id);
		mav.addObject("article", a);
		return mav;
	}
}
