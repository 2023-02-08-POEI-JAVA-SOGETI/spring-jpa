package com.bigcorp.booking.exercice;

public class Main {

	public static void main(String[] args) {
		
		
		
		FournisseurDao entity = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur("Silvio", 
													"Mon Tel", 
													"Mon Email", 
													"Mon Adresse");
		
		entity.merge(fournisseur);

	}

}
