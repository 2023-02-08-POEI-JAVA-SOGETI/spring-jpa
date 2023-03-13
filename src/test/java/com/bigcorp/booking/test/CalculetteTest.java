package com.bigcorp.booking.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Simple classe de test pour la calculette
 */
public class CalculetteTest {

	@Test
	public void testAdditionne() {
		Calculette calculette = new Calculette();
		int a = 3;
		int b = 7;
		int resultat1 = calculette.additionne(a,b);
		Assertions.assertEquals(10, resultat1);
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
	public void testMultiplieZero() {
		Calculette calculette = new Calculette();
		int a = 3;
		int b = 0;
		double resultat1 = calculette.multiplie(a,b);
		Assertions.assertEquals(0, resultat1);
	}

	@Test
	public void testDiviseParZero() {
		Calculette calculette = new Calculette();
		double a = 3;
		double b = 0;
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculette.divise(a,b));
	}
	 

	  

}
