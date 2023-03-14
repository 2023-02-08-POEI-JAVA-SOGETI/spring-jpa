package com.bigcorp.booking.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bigcorp.booking.dao.ArticleDao;

@Entity
@Table(name = "ARTICLES")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero_article;
	private String nom;
	@Enumerated(EnumType.ORDINAL)
	private Etat etat;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero_article() {
		return numero_article;
	}
	public void setNumero_article(Integer numero_article) {
		this.numero_article = numero_article;
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
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public static void main(String[] args){
		
		Random random = new Random();
		ArticleDao articleDao = new ArticleDao();
		
		Article conteneur40 = new Article();
		conteneur40.setNom("conteneur 40 pieds");
		conteneur40.setNumero_article(random.nextInt(10000));
		conteneur40.setDescription("un grand conteneur");
		conteneur40.setEtat(Etat.NEUF);
		
		Article conteneur20 = new Article();
		conteneur20.setNom("conteneur 20 pieds");
		conteneur20.setNumero_article(random.nextInt(10000));
		conteneur20.setDescription("un petit conteneur");
		conteneur20.setEtat(Etat.OCCASION);
		
		Article savedConteneur40 = articleDao.merge(conteneur40);
		Article savedConteneur20 = articleDao.merge(conteneur20);
		
		articleDao.findById(Article.class, savedConteneur40.getId());
		articleDao.findById(Article.class, savedConteneur20.getId());
	}
}
