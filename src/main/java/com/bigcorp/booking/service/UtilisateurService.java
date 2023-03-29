package com.bigcorp.booking.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSpringDao;

import tp_spring_jpa_pablo.model.Utilisateur;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurSpringDao utilisateurSpringDao;
	
	public Iterable<Utilisateur> findAll(){
		return this.utilisateurSpringDao.findAll();
	}
	
	@Transactional
	public Utilisateur save(Utilisateur User) {
		return this.utilisateurSpringDao.save(User);
	}
	
	public Utilisateur findById(Integer id) {
		return this.utilisateurSpringDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		this.utilisateurSpringDao.deleteById(id);
	}	
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Transactional
	public void deleteById2(Integer id) {
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    try {
	        entityManager.getTransaction().begin();
	        Query query = entityManager.
	        		createQuery("DELETE FROM Utilisateur u WHERE u.id = :id");
	        query.setParameter("id", id);
	        query.executeUpdate();
	        entityManager.getTransaction().commit();
	    } catch (Exception e) {
	        entityManager.getTransaction().rollback();
	        throw e;
	    } finally {
	        entityManager.close();
	    }
	}


}
