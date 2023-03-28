package com.bigcorp.booking.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Logger logger = LoggerFactory.getLogger(ArticleRestController.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping("/restArticle/{articleId}")
    public ResponseEntity<ArticleDto> getById(@PathVariable("articleId") Integer articleId) {
        logger.info("Récupération de l'article par ID: {}", articleId);
        Article article = articleService.findById(articleId);
        if (article == null) {
            logger.warn("Article non trouvé avec l'ID: {}", articleId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article non trouvé avec l'ID: " + articleId);
        }
        ArticleDto articleDto = new ArticleDto(article);
        return ResponseEntity.ok(articleDto);
    }

    @GetMapping("/restArticles")
    public ResponseEntity<List<ArticleDto>> getAllArticle() {
        logger.info("Récupération de tous les articles");
        List<Article> articles = (List<Article>) articleService.findAll();
        List<ArticleDto> articlesDto = new ArrayList<>();
        for (Article article : articles) {
            articlesDto.add(new ArticleDto(article));
        }
        return ResponseEntity.ok(articlesDto);
    }

    @DeleteMapping("/restArticle/{articleId}/delete")
    public void deleteById(@PathVariable("articleId") Integer articleId) {
        logger.info("Suppression de l'article par ID: {}", articleId);
        Article article = articleService.findById(articleId);
        if (article == null) {
            logger.warn("Article non trouvé avec l'ID: {}", articleId);
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Article non trouvé avec l'ID: " + articleId);
        }
        articleService.delete(articleId);
    }

    @PostMapping("/restArticle")
    public ResponseEntity<ArticleDto> save(@RequestBody ArticleDto articleDto) {
        logger.info("Enregistrement d'un nouvel article");
        if (articleDto.getId() != null) {
            logger.warn("Un nouvel article ne peut pas déjà avoir un ID");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Un nouvel article ne peut pas déjà avoir un ID");
        }
        Article article = new Article(articleDto);
        article = articleService.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ArticleDto(article));
    }
}
