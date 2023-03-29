package tp_spring_jpa_pablo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Fournisseur;

public class FournisseurDaoTest {
	@Test
    public void testSave() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Assertions.assertNotNull(savedFournisseur.getId());
    }
	
	@Test
	public void testGetParNom() {
		FournisseurDao FournisseurDao = new FournisseurDao();
		Fournisseur fournisseur1 = new Fournisseur();		
		fournisseur1.setNom("EDF");
		FournisseurDao.merge(fournisseur1);
		
		Fournisseur Fournisseur2 = new Fournisseur();
		Fournisseur2.setNom("Tropical");
		FournisseurDao.merge(Fournisseur2);
		
		List<Fournisseur> fournisseurs = FournisseurDao.getParNom(Fournisseur2.getNom());
		Assertions.assertEquals(1, fournisseurs.size());
	}	
	
	@Test
    public void testRelationBidirectionnelle() {
		//Sauvegarde du Fournisseur
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		String nomFournisseur = "Fournisseur Test Bidi";
		fournisseur.setNom(nomFournisseur);		
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);

    	//Sauvegarde des Articles
		ArticleDao articleDao = new ArticleDao();
		Article newArticle = new Article();    	
		newArticle.setNom("Article Test Bidi");
		
		// Rattachement
		newArticle.setFournisseur(savedFournisseur);
		savedFournisseur.getArticles().add(newArticle);
		
		// Sauvegarde
		articleDao.merge(newArticle);
		
		List<Fournisseur> fournisseurs = fournisseurDao.getArticlesFournisseur(nomFournisseur);
		for (Fournisseur fournisseurLu : fournisseurs) {
			Assertions.assertEquals(1, fournisseurLu.getArticles().size());
		}		

    }
	
}
