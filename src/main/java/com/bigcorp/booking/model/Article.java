package com.bigcorp.booking.model;

import javax.persistence.Column;
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
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "num_article")
	private Integer numero;
	private String nom;
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TypeArticle typeArticle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOURNISSEUR_ID")
	private Fournisseur fournisseur;

	public Article(Integer numero, String nom, String description, TypeArticle typeArticle) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.description = description;
		this.typeArticle = typeArticle;
	}
	
	public Article() {}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeArticle getTypeArticle() {
		return typeArticle;
	}

	public void setTypeArticle(TypeArticle typeArticle) {
		this.typeArticle = typeArticle;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	/**
	 * Associe this à fournisseur.
	 * Modifie fournisseur.articles pour rendre les deux
	 * relations cohérentes
	 * @param fournisseur not null
	 */
	public void associe(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
		this.fournisseur.getArticles().add(this);
	}

}