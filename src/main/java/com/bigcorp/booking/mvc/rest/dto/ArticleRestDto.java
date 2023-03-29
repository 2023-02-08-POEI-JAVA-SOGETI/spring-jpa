package com.bigcorp.booking.mvc.rest.dto;

import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Fournisseur;

public class ArticleRestDto {
	
	private Integer id;
	private String nom;
	private String type;
	private String description;		
	
	public ArticleRestDto(Article article) {
		this.id = article.getId();		
		this.nom = article.getNom();
		this.type = article.getType();
		this.description = article.getDescription();		
	}
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

	public Article remplisArticle(Article articleLu) {
		articleLu.setId(this.id);		
		articleLu.setNom(this.nom);
		articleLu.setType(this.type);
		articleLu.setDescription(this.description);		
		return articleLu;
	}
	
	public ArticleRestDto() {
	}

}
