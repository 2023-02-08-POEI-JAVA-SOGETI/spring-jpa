package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Article;

public class ArticleRestDto {
	private Integer iD;
	private Integer numeroUnique;
	private String fournOuClient;
	private String nom;
	private String description;

	public ArticleRestDto(Article article) {
		this.iD = article.getiD();
		this.numeroUnique = article.getNumeroUnique();
		this.fournOuClient = article.getFournOuClient();
		this.nom = article.getNom();
		this.description = article.getDescription();
	}

	public Integer getiD() {
		return iD;
	}

	public void setiD(Integer iD) {
		this.iD = iD;
	}

	public Integer getNumeroUnique() {
		return this.numeroUnique;
	}

	public void setNumeroUnique(Integer numeroUnique) {
		this.numeroUnique = numeroUnique;
	}

	public String getFournOuClient() {
		return this.fournOuClient;
	}

	public void setFournOuClient(String fournOuClient) {
		this.fournOuClient = fournOuClient;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
