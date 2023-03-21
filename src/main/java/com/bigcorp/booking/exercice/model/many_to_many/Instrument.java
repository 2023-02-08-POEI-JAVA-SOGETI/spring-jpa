package com.bigcorp.booking.exercice.model.many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "instrument")
public class Instrument {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String nom;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "INSTRUMENT_MUSICIEN",
			joinColumns = @JoinColumn(name="instrument_id"),
			inverseJoinColumns = @JoinColumn(name="musicien_id"))
	private List<Musicien> musiciens = new ArrayList<>();


	
	
	@Override
	public String toString() {
		return "Instrument [id=" + id + ", nom=" + nom + ", musiciens=" + musiciens + "]";
	}
	
	
	
	
	// CONSTRUCTORS
	
	


	public Instrument(String nom, List<Musicien> musiciens) {
		super();
		this.nom = nom;
		this.musiciens = musiciens;
	}


	public Instrument() {
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


	public List<Musicien> getMusiciens() {
		return musiciens;
	}



}
