package com.bigcorp.booking.exercice.entityManager_jpql;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.dao.PersistenceSingleton;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;



public class FournisseurDao extends AbstractDaoClass<Fournisseur>{
	
	
	/*
	 *  METHODE REQUETE JPQL avec la méthode .createQuery
	 *  
	 *  Va s'ajouter à la liste des méthode de la classe AbstractDaoClass
	 */
	
	public List<Fournisseur> findByName(String nomFournisseur)
	{
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> listFourByName = 
				em.createQuery("from Fournisseur WHERE nom= :nomFournisseur", Fournisseur.class )
				.setParameter("nomFournisseur", nomFournisseur).getResultList();
		
		em.close();
		
		return listFourByName;
		
	}
	
	
	public List<Fournisseur> findByNameWithListOfArticles (String nomFournisseur)
	{
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		
		List<Fournisseur> listFourByName = 
				em.createQuery("from Fournisseur f "
						+ " left outer join fetch f.articles"
						+ " WHERE f.nom= :nomFournisseur", Fournisseur.class )
				.setParameter("nomFournisseur", nomFournisseur)
				.getResultList();
		
		em.close();
		
		return listFourByName;
		
	}
	

}
