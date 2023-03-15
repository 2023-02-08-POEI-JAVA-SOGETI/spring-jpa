package com.bigcorp.booking.dao;

/*Ajoutez la classe FournisseurDao , inspirée de ExampleDao, 
*qui contient une méthode merge(Fournisseurs) et une methode findById(Integer)*/

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseurs;


public class FournisseursDao {
	
		public Fournisseurs merge(Fournisseurs fournisseur) {
			EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			Fournisseurs merged = em.merge(fournisseur);
			transaction.commit();
			em.close();
			return merged;
		}
		public Fournisseurs findById(Integer id) {
			EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			return em.find(Fournisseurs.class, id);
		}
		 public Fournisseurs insert(String nom) {			 
			 EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			 Fournisseurs fournisseur = new Fournisseurs(); //nouvelle instance de l'entité fournisseur
			 fournisseur.setNom("khadidja");
			 EntityTransaction transaction = em.getTransaction(); // Obtenir une instance de la transaction
			 transaction.begin(); // Commencer la transaction
			 em.persist(fournisseur); // Enregistrer l'entité fournisseur dans la base de données
			 transaction.commit(); // Valider la transaction
			 em.close(); // Fermer l'EntityManager
			 return fournisseur; // Retourner l'entité fournisseur insérée				
		 }
		 
		 public void remove(Long id) {
				EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				em.createQuery("delete from Fournisseurs e where e.id = :id", Fournisseurs.class).setParameter("id", id)
						.executeUpdate();
				transaction.commit();
				em.close();
			}
		 
		public static void main(String[] args) {
			String numero = "5487";
			String nom = "Khadi";
			String email = "khadi@yahoo.fr";
			String adresse = "Orléans";
			
		    FournisseursDao fournisseurDao = new FournisseursDao();   
		    Fournisseurs fournisseur = new Fournisseurs();
			fournisseur.setNom(nom);
		    	
			Fournisseurs savedFournisseur = fournisseurDao.merge(fournisseur);
	}
}
