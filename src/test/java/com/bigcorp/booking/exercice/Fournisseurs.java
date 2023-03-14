package com.bigcorp.booking.exercice;

// Creation d'un JavaBean
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Décrit une entité persistable
@Table(name = "Fournisseurs") // Optionnel : explicite la Table en BDD
public class Fournisseurs implements Serializable {

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	// Proprietes
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    private Integer iD;
    private Integer numeroUnique;
    private String nom;
    private String mail;
    private String adresse;
 
    // Constructeur sans parametres
    public Fournisseurs() {
        this.iD = 0;
        this.numeroUnique = 0;
        this.nom = "";
        this.mail = "";
        this.adresse = "";
    }

    public Fournisseurs(Integer numeroUnique, String nom, String mail, String adresse) {
        this.numeroUnique = numeroUnique;
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
    }

    // Getters
    public Integer getiD() {
        return this.iD;
    }

    public Integer getNumeroUnique() {
        return this.numeroUnique;
    }

    public String getNom() {
        return this.nom;
    }

    public String getMail() {
        return this.mail;
    }

    public String getAdresse() {
        return this.adresse;
    }

    // Setters

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public void setNumeroUnique(Integer numeroUnique) {
        this.numeroUnique = numeroUnique;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

	public void setTaille(float f) {
		// TODO Auto-generated method stub
		
	}

    

    
}
