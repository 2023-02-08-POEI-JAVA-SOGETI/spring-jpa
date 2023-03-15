package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Décrit une entité persistable, obligatoire si on veut persister
@Table(name = "article") // Optionnel : explicite la Table en BDD, par défaut correspond au nom de la classe si on ne spécifie pas, attention à la casse (f minuscule ici).

public class Article {
	
	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	// décrit la méthode de génération de l’identifiant
    private int id;
    private int numArticle;
    @Enumerated(EnumType.STRING) // On explicite la gestion du tyoe Enum en base de données
    private TypeArticle type;
    private String nom;
    private String description;

    public Article(int numArticle, TypeArticle type, String nom, String description) {
        this.numArticle = numArticle;
        this.type = type;
        this.nom = nom;
        this.description = description;
    }
    
    // Constructeur vide
     public Article() {}

    public int getId() {
        return id;
    }

    public int getNumArticle() {
        return numArticle;
    }

    public TypeArticle getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumArticle(int numArticle) {
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

	@Override
	public String toString() {
		return "Article [id=" + id + ", numArticle=" + numArticle + ", type=" + type + ", nom=" + nom + ", description="
				+ description + "]";
	}
    
    
    
}
