package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Fournisseur;
import jakarta.validation.constraints.Size;

//La class FournisseurrestDto
public class FournisseurRestDto {

	// definition des propriétés de la class
	private Integer id;

	private Integer numero;

	@Size(min = 4)
	private String nom;

	private String email;

	private String adresse;

	private String titre;

	public FournisseurRestDto() {

	}

	// Methode constructeur permettant d'initialiser les propriétés de la class
	// a partir du modele Fournisseur.
	public FournisseurRestDto(Fournisseur fournisseur) {
		this.id = fournisseur.getId();
		this.numero = fournisseur.getNumero();
		this.nom = fournisseur.getNom();
		this.email = fournisseur.getEmail();
		this.adresse = fournisseur.getAdresse();
		this.titre = fournisseur.getTitre();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	// Les getters et setters
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

	// Methode permettant de remplir les propriétés de la table à persister
	// A partir des proprietes chargées du DTO
	public Fournisseur remplisFournisseur(Fournisseur fournisseurLu) {
		fournisseurLu.setId(this.id);
		fournisseurLu.setNumero(this.numero);
		fournisseurLu.setNom(this.nom);
		fournisseurLu.setAdresse(this.adresse);
		fournisseurLu.setEmail(this.email);
		fournisseurLu.setTitre(this.titre);
		return fournisseurLu;
	}
	
	@Override
	public String toString() {
		return "FournisseurRestDto [id=" + id + ", nom=" + nom + "]";
	}

}