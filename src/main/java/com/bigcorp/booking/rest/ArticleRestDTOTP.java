package com.bigcorp.booking.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;

@RestController
public class ArticleRestDTOTP {

	/*
	@GetMapping("/articles/{articleId}")
	public ArticleRestDTOTP getById(@PathVariable("articleId") Integer articleId) {
		Article article1 = ArticleService.findById(articleId);
		if (article1 == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : "
					+ articleId);
			}
		return new ArticleRestDTOTP (article1);
	}
}*/