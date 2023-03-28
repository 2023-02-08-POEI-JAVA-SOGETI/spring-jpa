package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Article;

//La class ArticlerestDto
public class ArticleRestDto {

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	// definition des propriétés de la class
	private Integer id;
	private String nom;
	private Integer numero;
	private String fc;
	private String description;

	// Methode constructeur permettant d'initialiser les propriétés de la class
	// a partir du modele Article.
	public ArticleRestDto(Article article) {
		this.id = article.getId();
		this.nom = article.getNom();
		this.numero = article.getNumero();
		this.fc = article.getFC();
		this.description = article.getDescription();
	}

	public ArticleRestDto() {
		super();
	}

	// Les getters et setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setType(Integer numero) {
		this.numero = numero;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//Methode permettant de remplir les propriétés de la table à persister
	// A partir des proprietes chargées du DTO
	public Article remplisArticle(Article articleLu) {
		articleLu.setId(this.id);
		articleLu.setNom(this.nom);
		articleLu.setNumero(this.numero);
		articleLu.setFC(this.fc);
		articleLu.setDescription(this.description);

		return articleLu;
	}

}