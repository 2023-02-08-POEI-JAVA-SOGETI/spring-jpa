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



import com.bigcorp.booking.dto.ArticleDto;


@Entity
@Table(name = "ARTICLES")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero_article;
	private String nom;
	@Enumerated(EnumType.ORDINAL)
	private Etat etat;
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FOURNISSEUR_ID")
	private Fournisseur fournisseur;
	
	public Article() {
		
	}
	
	public Article(ArticleDto articleDto) {
		this.id = articleDto.getId();
		this.numero_article = articleDto.getNumero_article();
		this.etat = articleDto.getEtat();
		this.description = articleDto.getDescription();
		this.fournisseur = articleDto.getFournisseur();
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero_article() {
		return numero_article;
	}
	public void setNumero_article(Integer numero_article) {
		this.numero_article = numero_article;
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


	public Etat getEtatArticle() {
	    return etat;
	}


	public void setEtatArticle(Etat etat) {
	    this.etat = etat;
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


	public void setDescription(String description) {
		this.description = description;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public static void main(String[] args){
		
	}



}
