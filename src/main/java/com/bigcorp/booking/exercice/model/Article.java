package com.bigcorp.booking.exercice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numArticle")
	private Integer numArticle;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	private String nom;
	private String description;
	
	
	
	
	public Article(Integer numArticle, Type type, String nom, String description) {
		super();
		this.numArticle = numArticle;
		this.type = type;
		this.nom = nom;
		this.description = description;
	}
	
	
	
	
	public Article() {
		super();
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
	@Override
	public String toString() {
		return "Article [id=" + id + ", numArticle=" + numArticle + ", type=" + type + ", nom=" + nom + ", description="
				+ description + "]";
	}
	
	
	
	

}
