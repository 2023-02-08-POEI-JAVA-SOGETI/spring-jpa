package com.bigcorp.booking;

import com.bigcorp.booking.dao.FournisseurDao;
import com.bigcorp.booking.model.Fournisseur;

public class Main {
	public static void main(String[] args) {
		System.out.println("hey");
		
		String nom = "Jack";
    	int num = 1000;
    	String email = "jack@mail.com";
    	String adresse = "3 rue du moulin";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom(nom);
		fournisseur.setNum(num);
		fournisseur.setEmail(email);
		fournisseur.setAdresse(adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
	}
}