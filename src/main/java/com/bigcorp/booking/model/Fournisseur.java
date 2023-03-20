package com.bigcorp.booking.model;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Décrit une entité persistable
@Table(name = "fournisseur") // Optionnel : explicite la Table en BDD
public class Fournisseur  {

	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	// décrit la méthode de génération de l’identifiant
	
	private Integer id;
    private String nom;
    private Integer num;
    private String email;
    private String adresse;
    
    @OneToMany(mappedBy="fournisseur")
    private List<Article> articles = new ArrayList<>();
//    private Set<Article> articles = new HashSet<>();

    public Fournisseur() {
        super();
    }

    public Fournisseur(String nom, Integer num, String email, String adresse) {
        super();
        this.nom = nom;
        this.num = num;
        this.email = email;
        this.adresse = adresse;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public List<Article> getArticles(){
    	return articles;
    }
    public void setArticles(List<Article> articles) {
    	this.articles = articles;
    }
    
    public void associateWith(Article article) {
    	this.articles.add(article);
    	article.setFournisseur(this);
    }
}
