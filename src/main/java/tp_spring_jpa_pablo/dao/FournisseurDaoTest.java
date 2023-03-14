package tp_spring_jpa_pablo.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FournisseurDaoTest {

	@Test
    public void testSave() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Assertions.assertNotNull(savedFournisseur.getId());
    }
}
