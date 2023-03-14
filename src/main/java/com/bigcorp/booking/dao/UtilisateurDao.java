package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
