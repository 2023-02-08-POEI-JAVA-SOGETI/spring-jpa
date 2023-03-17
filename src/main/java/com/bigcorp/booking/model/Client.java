package com.bigcorp.booking.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
	private static final long serialVersionUID = -1912226135224432621L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilisateur;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fournisseurId")
	private Fournisseur fournisseur;

	public Client() {
		this.numero = 0;
		this.nom = "NOM";
		this.prenom = "PRENOM";
		this.email = "EMAIL";
		this.adresse = "ADRESSE";
	}

	public Client(Integer numero, String nom, String prenom, String email, String adresse) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	public Client(Integer id, Integer numero, String nom, String prenom, String email, String adresse) {
		this.id = id;
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getAdresse() {
		return adresse;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public void associateWithUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
		utilisateur.getClients().add(this);
	}
	
	public void associateWithFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
		fournisseur.getClients().add(this);
	}
}
