package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Décrit une entité persistable, obligatoire si on veut persister
@Table(name = "fournisseur") // Optionnel : explicite la Table en BDD, par défaut correspond au nom de la classe si on ne spécifie pas, attention à la casse (f minuscule ici).

public class Fournisseur {
	
	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	// décrit la méthode de génération de l’identifiant
    private int id;
    private String nom;
    private int num;
    private String email;
    private String adresse;

    public Fournisseur() {
    }

    public Fournisseur(String nom, int num, String email, String adresse) {
        this.nom = nom;
        this.num = num;
        this.email = email;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "id=" + id + ", nom=" + nom + ", num=" + num + ", email=" + email + ", adresse=" + adresse + '}';
    }
    

}
