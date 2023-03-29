package tp_spring_jpa_pablo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tp_spring_jpa_pablo.dao.UtilisateurDao;
import tp_spring_jpa_pablo.model.Utilisateur;

public class UtilisateurDaoTest {
	@Test
    public void testSave() {
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		Utilisateur utilisateur = new Utilisateur();
		String nomUtilisateur = "Test Save method";
		utilisateur.setNom(nomUtilisateur);
		Utilisateur savedUtilisateur = utilisateurDao.merge(utilisateur);
		Assertions.assertNotNull(savedUtilisateur.getId());
    }

}
