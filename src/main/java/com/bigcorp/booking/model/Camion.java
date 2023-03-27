package com.bigcorp.booking.model;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Table;



public class Camion {
    private String nom;
    private int id;
    
    public Camion(String nom) {
        this.nom = nom;
    }
    
    //getters et setters nom
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
     
    
  //getters et setters id
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}