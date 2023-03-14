package com.bigcorp.booking.model;

// Import de Serializable pour creer un JavaBean
//import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JavaBean d'un Fournisseur
 * @author Twixy
 */

@Entity // Décrit une entité persistable
@Table(name = "FOURNISSEUR") // Optionnel : explicite la Table en BDD
public class Fournisseur {

	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.TABLE) // optionnel
	// décrit la méthode de génération de l’identifiant
	private Integer id;
    private Integer numero;
    private String nom;
    private String email;
    private String adresse;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	
    

}

