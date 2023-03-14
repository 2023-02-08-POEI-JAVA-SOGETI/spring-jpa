package com.bigcorp.booking.dao;

import com.bigcorp.booking.model.Fournisseurs;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nom = "Classe Main";

		FournisseursDao fournisseursDao = new FournisseursDao();
		Fournisseurs fournisseurs = new Fournisseurs();
		fournisseurs.setNom(nom);
		fournisseurs.setNumeroUnique(50);

		Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);
	}

}
