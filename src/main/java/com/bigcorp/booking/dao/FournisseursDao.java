package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseurs;

public class FournisseursDao extends AbstractDao<Fournisseurs> {

	public List<Fournisseurs> getParNom(String nomFournisseurs){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseurs> laListeDesFournisseurssAvecLeBonNom 
			= em.createQuery("from Fournisseurs where nom = :nomFournisseurs", Fournisseurs.class)
			.setParameter("nomFournisseurs", nomFournisseurs).getResultList();
		em.close();
		return laListeDesFournisseurssAvecLeBonNom;
	}
	
	
	public static void main(String[] args) {
		String nom = "Jean-Jacques";
		
    	FournisseursDao fournisseursDao = new FournisseursDao();
    	Fournisseurs fournisseurs = new Fournisseurs();
		fournisseurs.setNom(nom);
		fournisseurs.setNumeroUnique(45);
    	
		Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);
	}
}
