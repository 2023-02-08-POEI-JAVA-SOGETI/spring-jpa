package com.restaurant.dto;

import com.restaurant.model.TypeRestaurant;

public class TypeRestaurantDto {

    private Integer id;
    private String nom;

    public TypeRestaurantDto() {
    }

    public TypeRestaurantDto(TypeRestaurant typeRestaurant) {
        this.id = typeRestaurant.getId();
        this.nom = typeRestaurant.getNom();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}