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

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.mvc.rest.dto.ArticleRestDto;
import com.bigcorp.booking.mvc.rest.dto.FournisseurRestDto;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.exception.ArticleException;
import com.bigcorp.booking.service.exception.ArticleInvalideException;
import com.bigcorp.booking.service.exception.FournisseurException;
import com.bigcorp.booking.service.exception.FournisseurInvalideException;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleRestController.class);

	// Requête n'allant pas sur la base (juste à partir du model)
//	@GetMapping("/articles/{articleId}")
//	public Article getById(@PathVariable("articleId") Integer articleId) {
//		Article article = new Article();
//		article.setId(articleId);
//		article.setNom("Salut !!!");
//		return article;
//	}

	// Requêtes allant surCRUD sur la base
	// Get
	@GetMapping("/{articleId}")
	public ArticleRestDto getById(@PathVariable("articleId") Integer articleId) {

		// Trouve l'article par son id et le stock dans la variable article
		Article article = articleService.findById(articleId);

		// Pour générer une erreur 404 lors que l'id de l'article n'existe pas
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
		}
		// Retourne le DTO préalablement chargé avec l'article trouvé et stocké dans la
		// variable article
		return new ArticleRestDto(article);
	}

	// DELETE
	@DeleteMapping("/{articleId}")
	public void supprimer(@PathVariable("articleId") Integer articleId) {
		// Pour générer une erreur 404 lors que l'id de l'article n'existe pas
		Article article = articleService.findById(articleId);
		if (article == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id : " + articleId);
			// Si non effectuer la suppression
		}
		articleService.supprimer(articleId);
	}

	// POST
	@PostMapping
	public ArticleRestDto save(@Validated @RequestBody ArticleRestDto articleRestDto, BindingResult bindingResult) {

		LOGGER.info("Appel de la méthode save pour le article : {}", articleRestDto);

		// Validation du ArticleRestDto
		if (bindingResult.hasErrors()) {
			StringBuilder stBuild = new StringBuilder();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				stBuild.append(objectError.getObjectName()).append("-").append(objectError.getDefaultMessage());
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, stBuild.toString());
		}

		// Ici, le ArticleRestDto est bon,
		// On prépare le Article que l'on va créer ou que l'on va mettre à jou

		Article article = new Article();
		if (articleRestDto.getId() != null) {
			article = articleService.findById(articleRestDto.getId());
			if (article == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun article trouvé avec l'id : " + articleRestDto.getId());
			}
		}
		articleRestDto.remplisArticle(article);

		try {
			article = articleService.sauvegarde(article);
		} catch (ArticleException e) {
			LOGGER.error("Erreur lors de la sauvegarde du article", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le article de la requête est incorrect");
		}

		// La sauvegarde s'est bien déroulée, le fournisseur est retransformé en
		// DTO pour être renvoyé dans le corps de la réponse HTTP
		return new ArticleRestDto(article);

	}

}