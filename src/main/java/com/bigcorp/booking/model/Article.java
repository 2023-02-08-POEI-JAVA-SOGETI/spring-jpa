package com.bigcorp.booking.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE")
public class Article implements Serializable {
	public enum EtatArticle {
		NEUF("Neuf"), OCCASION("Occasion"), INUTILISABLE("Inutilisable");

		private String etat;

		EtatArticle(String etat) {
			this.etat = etat;
		}

		@Override
		public String toString() {
			return etat;
		}
	}

	private static final long serialVersionUID = -1912226135224432621L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer numero;
	private String fc;
	private String nom;
	private String description;

	@Enumerated(EnumType.STRING)
	private EtatArticle etat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fournisseurId")
	private Fournisseur fournisseur;

	public Article() {
		this.numero = 0;
		this.fc = "";
		this.nom = "NOM";
		this.description = "DESCRIPTION";
		this.etat = EtatArticle.NEUF;
		this.fournisseur = new Fournisseur();
	}

	public Article(Integer numero, String fc, String nom, String description, EtatArticle etatArticle,
			Fournisseur fournisseur) {
		this.numero = numero;
		this.fc = fc;
		this.nom = nom;
		this.description = description;
		this.etat = etatArticle;
		this.fournisseur = fournisseur;
	}

	public Article(Integer id, Integer numero, String fc, String nom, String description, EtatArticle etatArticle,
			Fournisseur fournisseur) {
		this.id = id;
		this.numero = numero;
		this.fc = fc;
		this.nom = nom;
		this.description = description;
		this.etat = etatArticle;
		this.fournisseur = fournisseur;
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getFC() {
		return fc;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setFC(String fc) {
		this.fc = fc;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	public void associateWith(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
		fournisseur.getArticles().add(this);
	}
}
