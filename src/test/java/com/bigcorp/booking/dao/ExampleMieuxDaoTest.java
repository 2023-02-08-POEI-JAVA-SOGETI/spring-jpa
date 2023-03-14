package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Example;

public class ExampleMieuxDaoTest {
	  
    @Test
    public void testSave() {
    	
		ExampleMieuxDao dao = new ExampleMieuxDao();
		Example example = new Example();
		example.setNom("coucou");
		Example exampleSauvegarde = dao.merge(example);
		
		Assertions.assertNotNull(exampleSauvegarde.getId());
		
		dao.findById(Example.class, 3l);
		
    }
	  
   
}