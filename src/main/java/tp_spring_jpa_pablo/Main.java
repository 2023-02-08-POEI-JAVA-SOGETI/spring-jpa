package tp_spring_jpa_pablo;

import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.ClientDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.dao.UtilisateurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Client;
import tp_spring_jpa_pablo.model.Fournisseur;
import tp_spring_jpa_pablo.model.Utilisateur;

public class Main {

	public static void main(String[] args) {
		// Instantiating the Fournisseur class
        Fournisseur fournisseur = new Fournisseur();
        FournisseurDao fournisseurDao = new FournisseurDao();
        Article article = new Article();
        ArticleDao articleDao = new ArticleDao();
        Client client = new Client();
        ClientDao clientDao = new ClientDao();
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurDao utilisateurDao = new UtilisateurDao();  
        
        fournisseurDao.merge(fournisseur);
        articleDao.merge(article);
        clientDao.merge(client);
        utilisateurDao.merge(utilisateur);

	}

}
