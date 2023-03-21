package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticlesSpringDao;
import com.bigcorp.booking.dao.spring.FournisseursSpringDao;
import com.bigcorp.booking.model.Articles;
import com.bigcorp.booking.model.Fournisseurs;

@Service
@Transactional
public class ArticlesFournisseursService {
	
	@Autowired
	ArticlesSpringDao articleSpringDao;
	
	@Autowired
	FournisseursSpringDao fournisseurSpringDao;

	// Méthode pour persister le lien entre un article et un fournisseur
    public Articles associateWith(Integer articleId, Integer fournisseurId) {
        // Vérifier si l'identifiant d'article est null
        if (articleId == null) {
        	System.out.println("L'identifiant de l'article ne peut pas être null");
        }

        // Si l'identifiant du fournisseur est null, je supprime le lien entre l'article et le fournisseur
        if (fournisseurId == null) {
            article.setFournisseur(null);
        } 

        return articleSpringDao.save(article);
    }
}