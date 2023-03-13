package com.bigcorp.booking.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Simple classe de test pour la calculette
 */
public class CalculetteTest {
	
	@AfterEach
	public void init() {
		System.out.println("coucou");
	}

	@Test
	public void testAdditionne() {
		//Arrange : Arrangement
		Calculette calculette = new Calculette();
		int a = 3;
		int b = 7;
		
		//Act : Agissement
		int resultat1 = calculette.additionne(a,b);
		
		//Assert : Assertion
		Assertions.assertEquals(10, resultat1);
	}

	@Test
	public void testAdditionne2() {
		Calculette calculette = new Calculette();
		int a = 3;
		int b = 8;
		
		int resultat1 = calculette.additionne(a,b);
		
		Assertions.assertEquals(11, resultat1);
	}

	@Test
	public void testAdditionne3() {
		Calculette calculette = new Calculette();
		int a = 22;
		int b = 38;
		
		int resultat1 = calculette.additionne(a,b);
		
		Assertions.assertEquals(60, resultat1);
	}

	@Test
	public void testMultiplie() {
		Calculette calculette = new Calculette();
		int a = 3;
		int b = 7;
		int resultat1 = calculette.multiplie(a,b);
		Assertions.assertEquals(21, resultat1);
	}

	@Test
	public void testDivise() {
		Calculette calculette = new Calculette();
		double a = 3;
		double b = 7;
		double resultat1 = calculette.divise(a,b);
		Assertions.assertEquals(0.428, resultat1, 0.01);
	}

	@Test
	public void testDiviseParZero() {
		Calculette calculette = new Calculette();
		double a = 3;
		double b = 0;
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculette.divise(a,b));
	}
	 

	  

}
