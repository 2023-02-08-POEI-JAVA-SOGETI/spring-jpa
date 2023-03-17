package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurDao extends AbstractDao<Utilisateur> {

		@Override
		public Utilisateur merge(Utilisateur utlisateur) {
			EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			EntityTransaction transaction = em.getTransaction();

			transaction.begin();

			Utilisateur merged = em.merge(utlisateur);
			
			transaction.commit();
			em.close();

			return merged;
		}
		
		public Utilisateur findById(Integer id) {
			EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			
			return em.find(Utilisateur.class, id);
		}
		
		public List<Utilisateur> fetchByNameWithClients(String name) {

			if (name == null || name == "")
				return null;

			EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			List<Utilisateur> utilisateurs = em
					.createQuery("FROM Utilisateur utilisateur" + " LEFT OUTER JOIN FETCH utilisateur.clients"
							+ " WHERE utilisateur.nom = :nomUtilisateur ", Utilisateur.class)
					.setParameter("nomUtilisateur", name).getResultList();
			
			em.close();

			return utilisateurs;
		}
		
		public void remove(Integer id) {
			EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			transaction.begin();
			em.createQuery("DELETE FROM Utilisateur p WHERE p.id = :id", Utilisateur.class)
					.executeUpdate();
			transaction.commit();
			em.close();
		}
	}
