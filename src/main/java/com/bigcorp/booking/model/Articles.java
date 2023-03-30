package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity   
@Table(name = "Articles")

public class Articles {  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private Integer numero;
//	private String fc;
	private String nom;
	private String description;	
	
	@Enumerated(EnumType.STRING)
	private EtatArticles etatArticle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOURNISSEUR_ID")
	private Fournisseurs fournisseur;	
	
	public Articles() {
		
	}

//	public Articles(Integer id, Integer numero, String nom, String description, EtatArticles etatArticle,
//			Fournisseurs fournisseur) {
//		this.id = id;
//		this.numero = numero;
//		this.nom = nom;
//		this.description = description;
//		this.etatArticle = etatArticle;
//		this.fournisseur = fournisseur;
//	}

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

//	public String getFc() {
//		return fc;
//	}
//
//	public void setFc(String fc) {
//		this.fc = fc;
//	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EtatArticles getEtatArticle() {
		return etatArticle;
	}

	public void setEtatArticle(EtatArticles etatArticle) {
		this.etatArticle = etatArticle;
	}

	public Fournisseurs getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseurs fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	/**
	 * Associe this à fournisseur.
	 * Modifie fournisseur.articles pour rendre les deux
	 * relations cohérentes
	 * @param fournisseur not null
	 */
	public void associe(Fournisseurs fournisseur) {
		this.fournisseur = fournisseur;
		this.fournisseur.getArticles().add(this);
	}

	public Articles(Integer id, Integer numero, String nom, String description, EtatArticles etatArticle) {		
		this.id = id;
		this.numero = numero;
		this.nom = nom;
		this.description = description;
		this.etatArticle = etatArticle;
	}
	
}