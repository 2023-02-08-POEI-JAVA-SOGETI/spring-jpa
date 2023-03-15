package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Severite;

public class ExampleDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jean-Jacques";
    	ExampleDao exampleDao = new ExampleDao();
    	Example example = new Example();
		example.setNom(nom);
		example.setSeverite(Severite.PAS_GRAVE);
    	
		Example savedExample = exampleDao.merge(example);
		
		Assertions.assertNotNull(savedExample.getId());
		
		Example exampleDeLaBaseDeDonnees = exampleDao.findById(savedExample.getId());
		
		Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Jean-Paul";
    	ExampleDao exampleDao = new ExampleDao();
    	Example example = new Example();
		example.setNom(nom);
		example.setTaille(3.14f);
    	
		Example savedExample = exampleDao.merge(example);
		
		Assertions.assertNotNull(savedExample.getId());
		
    }
    
    @Test
    public void testFindByName() {
    	ExampleDao exampleDao = new ExampleDao();

    	Example example1 = new Example();
		example1.setNom("Michel");
		exampleDao.merge(example1);

    	Example example2 = new Example();
		example2.setNom("Michel");
		exampleDao.merge(example2);
    	
    	
    }
}