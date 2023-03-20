package com.bigcorp.booking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iD;
	private Integer numeroUnique;
	private String nom;
	private String prenom;
	private String mail;
	private String adresse;

	@OneToMany(mappedBy = "client")
	private Set<Utilisateur> utilisateurs = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOURNISSEUR_ID")
	private Fournisseurs fournisseur;
	
	public Integer getId() {
		return iD;
	}

	public void setId(Integer id) {
		this.iD = id;
	}

	public Integer getNumero() {
		return numeroUnique;
	}

	public void setNumero(Integer numeroUnique) {
		this.numeroUnique = numeroUnique;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return mail;
	}

	public void setEmail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	
	public Fournisseurs getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseurs fournisseur) {
		this.fournisseur = fournisseur;
	}

	/**
	 * Associe this à fournisseur.
	 * Modifie fournisseur.client pour rendre les deux
	 * relations cohérentes
	 * @param fournisseur not null
	 */
	public void associe(Fournisseurs fournisseur) {
		this.fournisseur = fournisseur;
		this.fournisseur.getClients().add(this);
	}

}