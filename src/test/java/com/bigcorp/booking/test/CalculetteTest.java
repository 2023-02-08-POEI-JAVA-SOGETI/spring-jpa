package com.bigcorp.booking.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Simple classe de test pour la calculette
 */
public class CalculetteTest {
	
	static Calculette calculette;
	
	@BeforeAll
	public static void initCalculette() {
		calculette = new Calculette();
	}

	@Test
	public void testAdditionne() {
		int a = 3;
		int b = 7;
		int resultat1 = calculette.additionne(a,b);
		Assertions.assertEquals(10, resultat1);
	}

	@Test
	public void testMultiplie() {
		int a = 3;
		int b = 7;
		int resultat1 = calculette.multiplie(a,b);
		Assertions.assertEquals(21, resultat1);
	}

	@Test
	public void testDivise() {
		double a = 3;
		double b = 7;
		double resultat1 = calculette.divise(a,b);
		Assertions.assertEquals(0.428, resultat1, 0.01);
	}

	@Test
	public void testDiviseParZero() {
		double a = 3;
		double b = 0;
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculette.divise(a,b));
	}
	
	@Test
	public void testRacineCarre() {
	    int a = 16;
	    double resultat1 = calculette.racineCarre(a);
	    Assertions.assertEquals(4.0, resultat1);
	}
}
