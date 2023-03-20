package com.bigcorp.booking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	private Integer id;
	private String name;
	@ManyToMany (mappedBy = "formations")
	private List<Etudiant> etudiants;
	
	public Formation() {
		this.name ="default formation";
		etudiants = new ArrayList<>();
	}
	
	public Formation(String string) {
		this.name = string;
		etudiants = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public void addEtudiant(Etudiant e) {
		this.etudiants.add(e);
	}
	
}
