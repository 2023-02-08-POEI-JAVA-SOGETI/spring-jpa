package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Example;

public class ExampleDaoTest {
	  
    @Test
    public void testSave() {
    	ExampleDao exampleDao = new ExampleDao();
    	Example example = new Example();
		Example savedExample = exampleDao.merge(example);
		Assertions.assertNotNull(savedExample.getId());
    }
}