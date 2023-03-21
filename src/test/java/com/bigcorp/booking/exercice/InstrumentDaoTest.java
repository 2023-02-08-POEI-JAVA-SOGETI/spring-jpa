package com.bigcorp.booking.exercice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.exercice.entityManager_jpql.many_to_many.InstrumentDao;
import com.bigcorp.booking.exercice.model.many_to_many.Instrument;

public class InstrumentDaoTest {
	
	
	static InstrumentDao instruDao;
	
	
	@BeforeAll
	public static void initDao()
	{
		instruDao = new InstrumentDao();
	}
	

	
	@Test
	public void mergeTest()
	{
		Instrument newInstrument = new Instrument();
		newInstrument.setNom("Piano");
		
		Instrument testInstrument = instruDao.merge(newInstrument);
		
		Assertions.assertEquals(testInstrument.getNom(), "Piano");
		
	}

}
