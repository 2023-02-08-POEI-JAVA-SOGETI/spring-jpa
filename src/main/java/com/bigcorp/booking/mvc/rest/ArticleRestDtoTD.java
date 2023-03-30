package com.bigcorp.booking.mvc.rest;

import com.bigcorp.booking.model.Article;

public class ArticleRestDtoTD {
	
	private Integer id;
	private Integer numero;
	private String fc;
	private String nom;
	private String description;
		
	public ArticleRestDtoTD(Article article) {
		this.id = article.getId();
		this.numero = article.getNumero();
		this.nom = article.getNom();
		this.fc = article.getFc();
		this.description = article.getDescription();
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

	public String getFc() {
		return fc;
	}
	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Article remplisArticles(Article articleLu) {
		articleLu.setId(this.id);
		articleLu.setNumero(this.numero);
		articleLu.setNom(this.nom);
		articleLu.setDescription(this.description);
		articleLu.setFc(this.fc);
		return articleLu;
	}
}






