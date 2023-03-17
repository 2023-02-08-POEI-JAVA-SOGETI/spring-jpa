package com.bigcorp.booking.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bigcorp.booking.dao.ArticleDao;
import com.bigcorp.booking.dao.FournisseurDao;

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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FOURNISSEUR_ID")
	private Fournisseur fournisseur;
	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
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
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur evergreen = new Fournisseur();
		evergreen.setNom("Evergreen");
		evergreen.setNumero_fournisseur(new Random().nextInt());
		evergreen.setEmail("contact@evergreen-shipping.com");
		evergreen.setAdresse("Hong Kong");

	    ArticleDao articleDao = new ArticleDao();
	    Article article = new Article();
	    article.setNom("conteneur 20'");
	    article.setNumero_article(new Random().nextInt());
	    article.setDescription("petit conteneur");
	    article.setEtat(Etat.NEUF);

	    
	    
	    Fournisseur savedFournisseur = fournisseurDao.merge(evergreen);
	    article.setFournisseur(savedFournisseur);
	    articleDao.merge(article); 
		
	}
}
