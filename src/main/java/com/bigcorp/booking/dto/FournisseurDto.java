package com.bigcorp.booking.dto;



import com.bigcorp.booking.model.Fournisseur;



public class FournisseurDto {
	
	private Integer id;
	private Integer numero_fournisseur;
	private String nom;
	private String email;
	private String adresse;
	
	private FournisseurDto() {
		
	}
	public FournisseurDto(Fournisseur fournisseur) {
		this.id = fournisseur.getId();
		this.numero_fournisseur = fournisseur.getNumero_fournisseur();
		this.nom = fournisseur.getNom();
		this.adresse = fournisseur.getAdresse();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero_fournisseur() {
		return numero_fournisseur;
	}

	public void setNumero_fournisseur(Integer numero_fournisseur) {
		this.numero_fournisseur = numero_fournisseur;
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
}
