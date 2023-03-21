package com.bigcorp.booking.tentative;

public class TestJunitLivres {
/*
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private LivresSpringDao livresSpringDao;

    @BeforeEach
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test-unit");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        livresSpringDao = new LivresSpringDaoImpl (entityManager); 
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
        Assertions.assertEquals(livre, savedLivre);
    }
*/
	
}
