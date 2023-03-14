package com.bigcorp.booking.dao;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.dao.FournisseurDao;
public class Main {

	public static void main(String[] args) {
		Fournisseur fournisseur = new Fournisseur();
		FournisseurDao fournisseurDao = new FournisseurDao();
		
		fournisseur.setId(2);
		fournisseur.setNom("NGOM");
		fournisseur.setAdresse("51 Chemin des rouliers");
		fournisseur.setEmail("test@test.com");
		fournisseur.setNumero(07);
		
		fournisseurDao.merge(fournisseur);
		
		

	}

}
