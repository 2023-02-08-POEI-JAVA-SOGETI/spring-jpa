package com.bigcorp.booking.restcontrolers;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.TypeArticle;

public class ArticleRestDto {

	private Integer id;
	private Integer numero;
	private String nom;
	private String description;

	private TypeArticle typeArticle;

	private Fournisseur fournisseur;

	public ArticleRestDto(Integer numero,String nom, String description, TypeArticle typeArticle) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.description = description;
		this.typeArticle = typeArticle;
	}

	public ArticleRestDto(Article article) {
		this.id=article.getId();
		this.numero = article.getNumero();
		this.nom = article.getNom();
		this.description = article.getDescription();
		this.typeArticle = article.getTypeArticle();
	
	}
	
	public ArticleRestDto() {
	}

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
	
	public Article remplieArticle(Article articleLu) {
		articleLu.setId(this.id);
		articleLu.setNumero(this.numero);
		articleLu.setNom(this.nom);
		articleLu.setDescription(this.description);
		articleLu.setTypeArticle(this.typeArticle);
		return articleLu;
		
	}
	
	
	
	}