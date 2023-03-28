package com.bigcorp.booking.mvc.rest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.exercice.model.many_to_one.Type;

public class ArticleDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer numArticle;
	private Type type;
	private String nom;
	private String description;

	

	
	public Article fillArticleWithDto(Article article)
	{
		article.setId(this.id);
		article.setNumArticle(this.numArticle);
		article.setType(this.type);
		article.setNom(this.nom);
		article.setDescription(this.description);

		
		return article;
	}
	
	
	
	public ArticleDto() {
		super();
	}
	
	
	public ArticleDto( Article article) {
		this.id = article.getId();
		this.numArticle = article.getNumArticle();
		this.type = article.getType();
		this.nom = article.getNom();
		this.description = article.getDescription();
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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

	
	
	

}
