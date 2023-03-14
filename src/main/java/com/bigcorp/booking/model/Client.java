package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer id;
    private String nom;
    private String prenom;
    private Integer num;
    private String email;
    private String adresse;

    public Client() {
        super();
    }

    public Client(String nom, String prenom, Integer num, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.email = email;
        this.adresse = adresse;
    }

    public Integer getId() {
        return id;
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

    public String getPrenom() {
        return this.prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
