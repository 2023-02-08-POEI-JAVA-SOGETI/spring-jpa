package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao {

	public Fournisseur merge(Fournisseur f) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Fournisseur merged = em.merge(f);
		transaction.commit();
		em.close();
		return merged;
	}
	
	public static void main(String[] args) {
		String nom = "Mon Fournisseur Prefere";
		
    	FournisseurDao fd = new FournisseurDao();
    	Fournisseur f = new Fournisseur(77, nom, "Fournisseur test", "mon adresse test");

		Fournisseur savedFournisseur = fd.merge(f);
	}

	public Fournisseur findById(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Fournisseur.class, id);
	}
	
	public List<Fournisseur> getParNom(String nomFournisseur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> list 
			= em.createQuery("from Fournisseur where nom = :nomFournisseur", Fournisseur.class)
			.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return list;
	}
	
	public List<Fournisseur> getParSousChaineNom(String sousChaineNom){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> list 
			= em.createQuery("from Fournisseur where lower(nom) LIKE :nomF", Fournisseur.class)
			.setParameter("nomF", "%" + sousChaineNom.toLowerCase() + "%").getResultList();
		em.close();
		return list;
	}	
	
	public List<Fournisseur> getArticlesByFournisseur(String fournisseur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> list 
			= em.createQuery("from Fournisseur f left join fetch f.articles "
					+ " where f.nom = :nomFournisseur", Fournisseur.class)
			.setParameter("nomFournisseur", fournisseur).getResultList();
		em.close();
		return list;
	}
}
