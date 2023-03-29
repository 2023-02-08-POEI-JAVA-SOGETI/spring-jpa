package com.bigcorp.booking.mvc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.spring.service.ArticleService;

@RestController
@RequestMapping("/rest-article")
public class ArticleRestController {
	
	@Autowired
	ArticleService service;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleRestController.class);
	
	
	@GetMapping("/{id}")
	 public ArticleDto showArticle(@PathVariable("id") Integer id)
	    {
		
		LOGGER.info("Récupération de l'article n° " + id);
		
			if(id == null || id<=0)
			 	{
			 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id incorrect");
			 	}
				
			ArticleDto dto = service.getArticleByIdWithDTO(id);
			
			if(dto == null )
		 	{
		 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé");
		 	}
			
	    	return dto;
	    }
	
		
		@PostMapping("/create")
		public ArticleDto createArticle(@RequestBody ArticleDto articleDto)
		{
			LOGGER.info("Création d'un nouvel article en BDD");
			
			if(articleDto == null )
		 	{
		 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article crée");
		 	}
			
			return service.createArticleWithDto(articleDto);

		}
		
		
		@PostMapping("/update")
		public ArticleDto updateArticle(@Validated @RequestBody ArticleDto articleDto,
												BindingResult result)
		{
			if(result.hasErrors())
			{
				ObjectError error = result.getAllErrors().get(0);
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getDefaultMessage());
			}
			
			if(articleDto == null )
		 	{
		 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article mis à jour");
		 	}
			
			LOGGER.info("M.A.J de l'article n° " + articleDto.getId());
			
			return service.updateArticleWithDTO(articleDto);
		}
		

		
		@DeleteMapping("/delete/{id}")
		public String supprimeArticle(@PathVariable("id") Integer id)
		{
			LOGGER.info("Suppression de l'Article n° " + id);
			
			if(id == null || id <=0)
		 	{
		 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé");
		 	}
			
			service.deleteArticleById(id);
			
			return "Article n° " + id + " supprimé";
		}

}
