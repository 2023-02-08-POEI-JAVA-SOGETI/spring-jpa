package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Example;

public class ExamplePersistenceTest {
	  
    @Test
    public void test() {
    	//Crée l'entityManagerFactory
        EntityManagerFactory entityManagerFactory 
        	= Persistence.createEntityManagerFactory("persistence-unit");
        //Crée l'entityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //Crée une transaction
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //Crée une instance
        Example example = new  Example();
        //Sauvegarde l'instance
        em.persist(example);
        //Valide la transaction
        transaction.commit();
        //Ferme l'entityManager
        em.close();
    }
}