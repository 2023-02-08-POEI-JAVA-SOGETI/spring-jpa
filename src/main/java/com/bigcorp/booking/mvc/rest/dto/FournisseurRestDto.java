package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurRestDto {
	
	private Integer id;

	private Integer numero;

	private String nom;

	private String email;

	private String adresse;
	
	public FournisseurRestDto(Fournisseur fournisseur) {
		this.id = fournisseur.getId();
		this.numero = fournisseur.getNumero();
		this.nom = fournisseur.getNom();
		this.email = fournisseur.getEmail();
		this.adresse = fournisseur.getAdresse();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Fournisseur remplisFournisseur(Fournisseur fournisseurLu) {
		fournisseurLu.setId(this.id);
		fournisseurLu.setNumero(this.numero);
		fournisseurLu.setNom(this.nom);
		fournisseurLu.setAdresse(this.adresse);
		fournisseurLu.setEmail(this.email);
		return fournisseurLu;
	}

}
