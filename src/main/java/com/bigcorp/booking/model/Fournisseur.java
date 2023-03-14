package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Fournisseur() {
        super();
    }

    public Fournisseur(Integer id, String nom, Integer num, String email, String adresse) {
        super();
        this.id = id;
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
}
