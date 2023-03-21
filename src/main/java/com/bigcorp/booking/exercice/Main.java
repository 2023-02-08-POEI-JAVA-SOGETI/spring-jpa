package com.bigcorp.booking.exercice;

import com.bigcorp.booking.exercice.entityManager_jpql.many_to_one.ArticleDao;
import com.bigcorp.booking.exercice.entityManager_jpql.many_to_one.FournisseurDao;
import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.exercice.model.many_to_one.Type;

public class Main {

	public static void main(String[] args) {
		
		
		FournisseurDao fourDao = new FournisseurDao();
		ArticleDao artDao = new ArticleDao();
		
		Fournisseur fournisseur = new Fournisseur("Silvio", 
													05060304, 
													"Mon Email", 
													"Mon Adresse");
		
		Article article = new Article(0505, Type.ACHAT, "Article Test", "Description Test" );
		
		
	/*
	 * Ici on peut appeler les méthodes de AbstractDaoClass car elle est étendu par les classes de DAO.
	 */
		
		
//		// PERSISTER DES DONNEES
//		
//		fourDao.merge(fournisseur);
//		artDao.merge(article);
		
		
		// LIRE DES DONNEES
		
//		Fournisseur findbyId = fourDao.findById(Fournisseur.class, 1);
//		System.out.println(findbyId);
//		
//		
//		List<Article> findByName = artDao.findByNameStartWith("t");
//		findByName.forEach(System.out::println);
		
		
	
		
		
		// METTRE DES ENTITE EN RELATION
		
		
		
		/*
		 *  SI LES ENTITE SONT DEJA EN BDD : 
		 *  	- Je les récupère avant
		 *  	- Je les associe
		 *  	- Je les Merge. Pas besoin de merge à nouveau le @One car on va juste prendre son ID
		 */

		
		Fournisseur four2 = fourDao.findById(Fournisseur.class, 3);
		Article article1 = artDao.findById(Article.class, 4);
		Article article2 = artDao.findById(Article.class, 5);

		article1.associateWith(four2);
		article2.associateWith(four2);
		
		artDao.merge(article1);
		artDao.merge(article2);
		

		
		/*
		 *  Si les entités ne sont pas encore en BDD : 
		 *  	- Je les instancie
		 *  	- Je merge d'abord la partie @One car je vais avoir besoin de son ID pour la colonne de jointure
		 *  	- Je les Associe
		 *  	- Je merge la partie @Many
		 */
		
		Fournisseur fournisseurAModifier = new Fournisseur("Silvio", 
												05060304, 
												"Mon Email", 
												"Mon Adresse");
		
		Article article3 = new Article(01, Type.ACHAT, "Test", "Description Test" );
		Article article4 = new Article(02, Type.ACHAT, "Test2", "Description Test2" );
		
		
		Fournisseur four3 = fourDao.merge(fournisseurAModifier);
		
		article3.associateWith(four3);
		article4.associateWith(four3);
		
		artDao.merge(article3);
		artDao.merge(article4);
		

	}

}
