package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOURNISSEUR")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	private Integer numero_fournisseur;
	private String nom;
	private String email;
	private String adresse;
	
	public Fournisseur(Integer numero_fournisseur, String nom, String email, String adresse) {
		this.numero_fournisseur = numero_fournisseur;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
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
