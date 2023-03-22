package com.bigcorp.booking.service;

import org.springframework.stereotype.Service;

@Service

public class Animaux {
	 private int id;
	    private String nom;
	    
		public int getId() {
			return id;
		}
		public void setId(int i) {
			this.id = i;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		
		public Animaux(int id, String nom) {
			super();
			this.id = id;
			this.nom = nom;
		}
		
		
		public Animaux() {
			super();
		}
		@Override
		public String toString() {
			return "Animaux [id=" + id + ", nom=" + nom + "]";
		}
	    
	    
	    
	    
	    
}
