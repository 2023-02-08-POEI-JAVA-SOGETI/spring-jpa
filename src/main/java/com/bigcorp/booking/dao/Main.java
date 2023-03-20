package com.bigcorp.booking.dao;

import com.bigcorp.booking.model.Fournisseur;

import org.springframework.util.Assert;

import com.bigcorp.booking.dao.FournisseurDao;
public class Main {

	public static void main(String[] args) {
		Fournisseur fournisseur = new Fournisseur();
		FournisseurDao fournisseurDao = new FournisseurDao();

		fournisseurDao.merge(fournisseur);
	}

}
