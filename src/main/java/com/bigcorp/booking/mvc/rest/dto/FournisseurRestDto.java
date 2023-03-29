package com.bigcorp.booking.mvc.rest.dto;

import jakarta.validation.constraints.Size;
import tp_spring_jpa_pablo.model.Fournisseur;

public class FournisseurRestDto {
	
	private Integer id;
	@Size(min=4)
	private String nom;
	private String email;
	private String adresse;
	
	public FournisseurRestDto(Fournisseur fournisseur) {
		this.id = fournisseur.getId();		
		this.nom = fournisseur.getNom();
		this.email = fournisseur.getAdresse();
		this.adresse = fournisseur.getAdresse();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		fournisseurLu.setNom(this.nom);
		fournisseurLu.setAdresse(this.adresse);
		fournisseurLu.setEmail(this.email);
		return fournisseurLu;
	}
	
	public FournisseurRestDto() {		
	}

}
