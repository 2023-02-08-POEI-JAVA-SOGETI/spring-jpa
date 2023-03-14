package com.bigcorp.booking.dao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bigcorp.booking.model.Fournisseur;

public class SampleLauncher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private static Integer id;
	
	public static void main(String[] args) {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur(id, 667, "Foxconn Technology", "who@foxconn.com", "Mainland China");
		
		fournisseurDao.merge(fournisseur);
		
		Fournisseur fournisseurDeux = new Fournisseur(id, 668, "Initex", "who@initex.com", "Taiwan");

		fournisseurDao.merge(fournisseurDeux);
	}
}
