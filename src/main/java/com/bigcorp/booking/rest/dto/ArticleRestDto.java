package com.bigcorp.booking.rest.dto;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.TypeArticle;

public class ArticleRestDto {

	private Integer id;
	private Integer numArticle;
	private String nom;
	private String description;
	private TypeArticle type;
	
	public TypeArticle getType() {
		return type;
	}

	public void setType(TypeArticle type) {
		this.type = type;
	}

	public ArticleRestDto() {
		
	}
	
	public ArticleRestDto(Article article) {
		this.id = article.getId();
		this.numArticle = article.getNumArticle();
		this.nom = article.getNom();
		this.description = article.getDescription();
		this.type = article.getType();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumArticle() {
		return numArticle;
	}

	public void setNumArticle(Integer numArticle) {
		this.numArticle = numArticle;
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

	public Article remplisArticle(Article articleLu) {
		articleLu.setId(this.id);
		articleLu.setNumArticle(this.numArticle);
		articleLu.setNom(this.nom);
		articleLu.setDescription(this.description);
		articleLu.setType(this.type);
		return articleLu;
	}

}
