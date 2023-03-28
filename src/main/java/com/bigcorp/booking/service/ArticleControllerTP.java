package com.bigcorp.booking.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.rest.ArticleRestDtoTP;
import com.bigcorp.booking.service.ArticleServiceTP;

@RestController
public class ArticleControllerTP {

	@GetMapping("/articles/{articleId}")
	public ArticleControllerTP getById(@PathVariable("articleId") Integer articleId) {
		Article article1 = ArticleServiceTP.findById(articleId);
		if (article1 == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : "
					+ articleId);
			}
		return this;
	}
}