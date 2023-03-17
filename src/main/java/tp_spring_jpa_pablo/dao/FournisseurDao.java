package tp_spring_jpa_pablo.dao;

import java.util.List;
import javax.persistence.EntityManager;

import com.bigcorp.booking.dao.PersistenceSingleton;

import tp_spring_jpa_pablo.model.Fournisseur;

public class FournisseurDao extends AbstractDao<Fournisseur> {
	
	// JPQL requetes SQL en JPA
	public List<Fournisseur> getParNom(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> laListeDesFournisseursAvecLeBonNom = 
			em.createQuery("from Fournisseur where nom = :nomFournisseur", Fournisseur.class)
			.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return laListeDesFournisseursAvecLeBonNom;
	}
	
	// JPQL requetes recuperer la liste des articles du fournisseur
	public List<Fournisseur> getArticlesFournisseur(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> articlesDuFournisseur = 
	        em.createQuery("select f from Fournisseur f left outer join fetch f.articles a "
	        		+ " where f.nom = :nomFournisseur", Fournisseur.class)
	        .setParameter("nomFournisseur", nomFournisseur).getResultList();
	    em.close();
	    return articlesDuFournisseur;
	}
	
}
