package com.bigcorp.booking.model;

import com.bigcorp.booking.dao.FournisseurDao;

public class TpAvanceFournisseur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nom = "camille";
    	Integer num = 789;
    	String email = "camille@camille.com";
    	String adresse = "1 rue de la Gare 75000 Paris";
		Fournisseur tpFournisseur = new Fournisseur();
		FournisseurDao tpFournisseurDao = new FournisseurDao();
		
		tpFournisseur.setNom(nom);
		tpFournisseur.setNum(num);
		tpFournisseur.setEmail(email);
		tpFournisseur.setAdresse(adresse);
		
		Fournisseur savedTpFournisseur = tpFournisseurDao.merge(tpFournisseur);
		tpFournisseurDao.findById(savedTpFournisseur.getId()); 
	}

}
