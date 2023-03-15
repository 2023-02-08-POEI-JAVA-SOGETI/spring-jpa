package tp_spring_jpa_pablo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Fournisseur;
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
		
		List<Fournisseur> Fournisseurs = FournisseurDao.getParNom("EDF");
		Assert.assertEquals(1, Fournisseurs.size());
	}	
	
}
