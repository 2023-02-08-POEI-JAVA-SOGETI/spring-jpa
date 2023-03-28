package com.bigcorp.booking.dto;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;

public class ArticleDto {
	
	private Integer id;
	private Integer numero_article;
	private String nom;
	private Etat etat;
	private String description;
	private Fournisseur fournisseur;
	
	public ArticleDto() {
		
	}
	
	public ArticleDto(Article article) {
		this.id = article.getId();
		this.numero_article = article.getNumero_article();
		this.nom = article.getNom();
		this.description = article.getDescription();
		this.etat = article.getEtat();
		this.fournisseur = article.getFournisseur();
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
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	
}
