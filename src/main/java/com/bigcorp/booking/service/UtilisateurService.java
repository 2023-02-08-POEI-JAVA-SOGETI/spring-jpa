package com.bigcorp.booking.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.UtilisateurSDao;

import tp_spring_jpa_pablo.model.Utilisateur;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurSDao utilisateurSDao;
	
	public Iterable<Utilisateur> findAll(){
		return this.utilisateurSDao.findAll();
	}
	
	@Transactional
	public Utilisateur save(Utilisateur User) {
		return this.utilisateurSDao.save(User);
	}
	
	public Utilisateur findById(Integer id) {
		return this.utilisateurSDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		this.utilisateurSDao.deleteById(id);
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
	
	
//	@Transactional
//	@Modifying
//	@Query("DELETE FROM Utilisateur u WHERE u.id = :id")
//	public void deleteById3(@Param("id") Integer id) {
//		
//	}



}
