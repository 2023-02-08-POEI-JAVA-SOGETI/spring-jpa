package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurDao extends AbstractDao<Utilisateur>{
	
	public List<Utilisateur> getParNomAvecTout(String nomUtilisateur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Utilisateur> utilisateurs 
			= em.createQuery("select distinct u from Utilisateur u "
					+ " left outer join fetch u.client c "
					+ " left outer join fetch c.fournisseur f "
					+ " left outer join fetch f.articles a "
					+ " where u.nom = :nomUtilisateur", Utilisateur.class)
			.setParameter("nomUtilisateur", nomUtilisateur).getResultList();
		em.close();
		return utilisateurs;
	}

}