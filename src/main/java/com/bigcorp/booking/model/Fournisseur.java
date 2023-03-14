package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOURNISSEUR")
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Integer numero;
    private String nom;
    private String email;
    private String adresse;
    

    public Fournisseur() {
        this.numero = 0;
        this.nom = "NOM";
        this.email = "EMAIL";
        this.adresse = "ADRESSE";
    }


    public Fournisseur(Integer numero, String nom, String email, String adresse) {
        this.numero = numero;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }
    

    public Fournisseur(Integer id, Integer numero, String nom, String email, String adresse) {
        this.id = id;
        this.numero = numero;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }
    // Getters

    /**
     * Getter Id
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * getter Numero
     * @return Numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * getter Nom
     * @return Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter Email
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter Adresse
     * @return Adresse
     */
    public String getAdresse() {
        return adresse;
    }

    // Setters

    /**
     * Setter id
     * @param id : numéro de l'enregistrement dans la table
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Setter numero
     * @param numero : numero du fournisseur
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    /**
     * Setter nom
     * @param nom : nom du fournisseur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setter email
     * @param email : email du fournisseur
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter adresse
     * @param adresse : adresse du fournisseur
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}