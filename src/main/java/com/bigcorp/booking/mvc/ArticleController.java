package com.bigcorp.booking.mvc;


import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;


@Controller
public class ArticleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

	
    @GetMapping("/articles")
    public String index(Model model) {
    	LOGGER.info("Affichage de l'index des articles");
        model.addAttribute("articles", articleService.findAll());
        return "index-article";
    }

    @GetMapping("article/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) {
    	LOGGER.info("Affichage de l'article avec l'ID : {}", id);
        Article article = articleService.findById(id);
       	LOGGER.debug("Article trouvé : {}", article);
        ModelAndView show = new ModelAndView("show-article");
        show.addObject("article", article);
        return show;
    }

    @GetMapping("article/new")
    public String newArticle(Model model) {
    	LOGGER.info("Affichage du formulaire de création d'un nouvel article");
        model.addAttribute("article", new Article());
        return "new-article";
    }

    @PostMapping("article/save")
    public String createArticle(@ModelAttribute("article") Article article, BindingResult result) {
    	article.setNumero_article(new Random().nextInt());
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la création de l'article {}", article);
            return "new-article";
        }
        LOGGER.info("Création de l'article {}", article);
        articleService.save(article);
        LOGGER.info("Article créée avec succès {}", article);
        return "redirect:/article/" + article.getId();
    }

    @GetMapping("article/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
    	LOGGER.info("Affichage du formulaire de modification de l'article {}", id);
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        return "edit-article";
    }

    @PutMapping("article/{id}/update")
    public String updateArticle(@PathVariable("id") Integer id, @ModelAttribute("article") Article article,
                                BindingResult result) {
        if (result.hasErrors()) {
        	LOGGER.warn("Erreur de validation lors de la modification de l'article {}", article);
            return "article/edit";
        }
        LOGGER.info("Modification de l'article {}", article);
        articleService.save(article);
        return "redirect:/articles/" + article.getId();
    }

    @PostMapping("article/{id}/delete")
    public String deleteArticle(@PathVariable("id") Integer id) {
    	LOGGER.info("Suppression de l'article {}", id);
        articleService.delete(id);
        return "redirect:/articles";
    }

    @ModelAttribute("listArticles")
    public Iterable<Article> listArticles() {
        return articleService.findAll();
    }

    @ModelAttribute("isArticlesListEmpty")
    public Boolean isEmpty() {
        boolean isEmpty = !listArticles().iterator().hasNext();
        LOGGER.info("Vérification si la liste des articles est vide : {}", isEmpty);
        return isEmpty;
    }
}