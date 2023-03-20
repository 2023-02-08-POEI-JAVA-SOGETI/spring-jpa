package com.bigcorp.booking.tentative;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJunitLivres {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private LivresSpringDao livresSpringDao;

    @BeforeEach
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test-unit");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        livresSpringDao = new LivresSpringDaoImpl (entityManager); /*Ligne obligatoire pour l'implémentation de LivresSpringDao*/
    }

    @AfterEach
    public void cleanup() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testAddLivres() {
        // Arrange 
        Livre livre = new Livre();
        livre.setTitre("The Great Gatsby");
        livre.setAuteur("F. Scott Fitzgerald");

        // Act  
        transaction.begin();
        LivresSpringDao.addLivre(livre);
        transaction.commit();

        // Assert
        Livre savedLivre = entityManager.find(Livre.class, livre.getId());
        assertEquals(livre, savedLivre);
    }

	
}
