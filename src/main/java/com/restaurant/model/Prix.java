package com.restaurant.model;

public enum Prix{
	TRES_BON_MARCHE,
	BON_MARCHE,
	CHER, 
	TRES_CHER;
	
	// Transformer le string en Prix
	public static Prix getPrixFromString(String s) {
		for(Prix p : Prix.values()) {
			if (p.name().equals(s))
				return p;
		}
		return null;
	}
}
