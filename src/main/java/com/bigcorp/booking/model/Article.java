package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer id;
    private Integer numArticle;
    private String nom;
    private String description;

    //Correspond à la consigne TP modification attribut etat
    @Enumerated(EnumType.STRING)
    private TypeArticle type;
    
    @ManyToOne  
    @JoinColumn(name="fournisseur_id")
    private Fournisseur fournisseur;
    
    // Constructeur vide
    public Article() {}
    
    public Integer getId() {
        return this.id;
    }
    public Integer getNumArticle() {
        return this.numArticle;
    }
    public TypeArticle getType() {
        return this.type;
    }
    public String getNom() {
        return this.nom;
    }
    public String getDescription() {
        return this.description;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNumArticle(Integer numArticle) {
        this.numArticle = numArticle;
    }
    public void setType(TypeArticle type) {
        this.type = type;
    }
    public void setNom(String nom) {
        this.nom = nom;
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
}