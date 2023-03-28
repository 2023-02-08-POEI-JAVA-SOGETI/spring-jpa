package com.bigcorp.booking.exercice.model.many_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.exercice.model.many_to_one.Type;


// PLUSIEURS Article pour 1 Fournisseur

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fournisseur_id")
	private Fournisseur fournisseur;
	
	
	
	
	// Possible Méthode d'association.
	
	public void associateWith(Fournisseur fournisseur)
	{
		this.fournisseur = fournisseur;
		fournisseur.getArticles().add(this);
	}
	
	
	
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
	
	
	
///// CONSTRUCTEUR utilisé uniquement dans la méthode fillFournisseurWithDto de FournisseurDTO
	
	public Article(Integer id, Integer numArticle, Type type, String nom, String description) {
		super();
		this.id = id;
		this.numArticle = numArticle;
		this.type = type;
		this.nom = nom;
		this.description = description;

	}

///////////////////////////////////

	
	
	



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
	

	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}




	@Override
	public String toString() {
		return "Article [id=" + id + ", numArticle=" + numArticle + ", type=" + type + ", nom=" + nom + ", description="
				+ description + "]";
	}
	
	
	
	

}
