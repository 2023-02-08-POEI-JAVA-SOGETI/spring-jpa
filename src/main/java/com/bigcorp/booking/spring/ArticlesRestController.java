package com.bigcorp.booking.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.model.Articles;
import com.bigcorp.booking.service.ArticlesService;

@RestController  
@RequestMapping("/Articles")
public class ArticlesRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticlesRestController.class);
	
	@Autowired
	ArticlesService articleService;

	@GetMapping("/{articleId}")
	public ArticlesRestDto getById(@PathVariable("articleId") Integer articleId) {
		LOGGER.info("Selection d'article par id : ", articleId);
		
		Articles article = articleService.findById(articleId);
		if(article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);		
		}
		return new ArticlesRestDto(article);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		LOGGER.info("Supression d'article par id : ", id);
		
		Articles article = articleService.findById(id);
		if(article == null) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + id);
	}
		articleService.delete(id);		
	}
	
	@PostMapping("")
	public ArticlesRestDto save(@RequestBody ArticlesRestDto articleRestDto) {
		LOGGER.info("Ajout/modification d'un article à la BDD : ", articleRestDto);
		
		Articles article = new Articles();
		
		articleRestDto.remplisArticle(article);		
		article = articleService.save(article);
		
		return new ArticlesRestDto(article); 
	}
}
