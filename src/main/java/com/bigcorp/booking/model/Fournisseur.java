package com.bigcorp.booking.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bigcorp.booking.dao.FournisseurDao;

@Entity
@Table(name = "FOURNISSEURS")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero_fournisseur;
	private String nom;
	private String email;
	private String adresse;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero_fournisseur() {
		return numero_fournisseur;
	}
	public void setNumero_fournisseur(Integer numero_fournisseur) {
		this.numero_fournisseur = numero_fournisseur;
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
	
	
	public static void main(String[] args){
		
		FournisseurDao daoFournisseur = new FournisseurDao();
		Random random = new Random();
		Fournisseur evergreen = new Fournisseur();
		evergreen.setNom("Evergreen");
		evergreen.setNumero_fournisseur(random.nextInt(100));
		evergreen.setAdresse("Honk Kong");
		evergreen.setEmail("contact@evergreen-shipping.com");
		
		Fournisseur cma = new Fournisseur();
		cma.setNom("Cma Cgm");
		cma.setNumero_fournisseur(random.nextInt(100));
		cma.setAdresse("Marseille");
		cma.setEmail("contact@cmacgm-shipping.com");
		
		Fournisseur evergreenBase = daoFournisseur.merge(evergreen);
		Fournisseur cmaBase = daoFournisseur.merge(cma);
	
		daoFournisseur.findById(evergreenBase.getId());
		daoFournisseur.findById(cmaBase.getId());
	}
}

