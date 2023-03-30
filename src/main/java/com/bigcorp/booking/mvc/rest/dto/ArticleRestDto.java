package com.bigcorp.booking.mvc.rest.dto;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;

import jakarta.validation.constraints.NotEmpty;

public class ArticleRestDto {

	private Integer id;
	private Integer numero;
	private String fc;
	private String nom;
	private String description;
	
	@NotEmpty
	private EtatArticle etatArticle;
	private Integer fournisseurId;
	
	public ArticleRestDto() {
		
	}

	public ArticleRestDto(Article article) {
		this.id = article.getId();
		this.nom = article.getNom();
		this.numero = article.getNumero();
		if(article.getFournisseur() != null) {
			this.fournisseurId = article.getFournisseur().getId();
		}
		this.fc = article.getFc();
		this.description = article.getDescription();
		this.etatArticle = article.getEtatArticle();
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

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
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

	public EtatArticle getEtatArticle() {
		return etatArticle;
	}

	public void setEtatArticle(EtatArticle etatArticle) {
		this.etatArticle = etatArticle;
	}

	public Integer getFournisseurId() {
		return fournisseurId;
	}

	public void setFournisseurId(Integer fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	public void remplisArticle(Article article) {
		article.setId(this.id);
		article.setNom(this.nom);
		article.setNumero(this.numero);
		article.setFc(this.fc);
		article.setDescription(this.description);
		article.setEtatArticle(this.etatArticle);
	}

}

