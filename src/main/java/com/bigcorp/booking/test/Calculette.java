package com.bigcorp.booking.test;

/**
 * Classe de calculette
 */
public class Calculette {

	/**
	 * Additionne a et b
	 * @param a
	 * @param b
	 * @return
	 */
	public int additionne(int a, int b) {
		return a + b;
	}

	/**
	 * Multiplie a et b
	 * @param a
	 * @param b
	 * @return
	 */
	public int multiplie(int a, int b) {
		return a * b;
	}

	/**
	 * Divise a par b. b doit être différent de 0.
	 * @param a
	 * @param b
	 * @return
	 */
	public double divise(double a, double b) {
		if(b == 0 ) {
			throw new IllegalArgumentException("Can not divide by zero");
		}
		return a / b;
	}

}
