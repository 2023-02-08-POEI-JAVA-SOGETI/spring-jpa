package com.bigcorp.booking.exercice.model.many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity	
@Table(name = "musicien")
public class Musicien {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String nom;
	
	@ManyToMany(mappedBy = "musiciens")
	private List<Instrument> instruments = new ArrayList<>();

	
	
	@Override
	public String toString() {
		return "Musiciens [id=" + id + ", nom=" + nom + ", instruments=" + instruments + "]";
	}
	
	
	
	
	
	// CONSTRUCTORS
	
	

	public Musicien(String nom, List<Instrument> instruments) {
		super();
		this.nom = nom;
		this.instruments = instruments;
	}

	public Musicien() {
		super();
	}

	
	
	// GETTER / SETTER
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	

	
}
