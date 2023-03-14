package tp_spring_jpa_pablo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tp_spring_jpa_pablo.dao.FournisseurDao;
import tp_spring_jpa_pablo.model.Fournisseur;

public class FournisseurDaoTest {
	@Test
    public void testSave() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Assertions.assertNotNull(savedFournisseur.getId());
    }
}
