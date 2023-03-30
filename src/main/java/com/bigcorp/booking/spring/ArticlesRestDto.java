package com.bigcorp.booking.spring;

import com.bigcorp.booking.model.Articles;
import com.bigcorp.booking.model.EtatArticles;

public class ArticlesRestDto {  	
	private Integer id;
	private Integer numero;
//	private String fc;
	private String nom;
	private String description;

	private EtatArticles etatArticle;

	public ArticlesRestDto() {
		
	}
	
	public ArticlesRestDto(Articles article) {
		this.description = article.getDescription();
		this.etatArticle = article.getEtatArticle();
//		this.fc = article.getFc();
		this.nom = article.getNom();
		this.id = article.getId();
		this.numero = article.getNumero();
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

	public Articles remplisArticle(Articles articleLu) {
			articleLu.setId(this.id);
			articleLu.setNumero(this.numero);
			articleLu.setNom(this.nom);
			articleLu.setDescription(this.description);
			articleLu.setEtatArticle(this.etatArticle);
			return articleLu;
		}		
	}