package com.bigcorp.booking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optionnel
	private Integer id;
	private String name;
	@ManyToMany 
	private List<Formation> formations;
	
	public Etudiant() {
		this.name = "default etudiant";
		formations = new ArrayList<>();
	}
	
	public Etudiant(String string) {
		this.name = string;
		formations = new ArrayList<>();
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
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	public void addFormation(Formation f) {
		this.formations.add(f);
	}
}
