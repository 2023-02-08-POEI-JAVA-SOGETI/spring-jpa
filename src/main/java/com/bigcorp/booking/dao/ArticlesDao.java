package com.bigcorp.booking.dao;



import com.bigcorp.booking.model.Articles;

/*La classe ArticlesDao étend la classe abstraite AbstractDao en utilisant le type générique Articles. 
 * càd ArticlesDao hérite des méthodes de AbstractDao et peut les utiliser pour accéder à la BDD pour le type Articles.
 */

public class ArticlesDao extends AbstractDao<Articles> {
	
	public void insert(Articles article) {
		persist(article);
	}
	
	public void update(Articles article) {
		merge(article);
	}
	
	
	 public static void main(String[] args) {
//		insert article
		ArticlesDao articleDao = new ArticlesDao();
		Articles article = new Articles();
		article.setNumero("458");
		article.setNom("abcd");
		article.setEtat("bon");
		article.setDescription("ksjdkqn");
		articleDao.persist(article);
//		
		update article
		ArticlesDao articleDao = new ArticlesDao();
		Articles article = articleDao.findById(Articles.class, 1L); // Récupérer l'article avec l'ID 1
		article.setEtat("Mauvais état"); // Modifier l'état de l'article
		articleDao.merge(article); // Enregistrer les modifications dans la base de données
	
	 }
	
	
	
		
}
