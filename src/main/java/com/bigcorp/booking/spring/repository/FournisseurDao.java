package com.bigcorp.booking.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;

@Repository
public interface FournisseurDao extends JpaRepository<Fournisseur, Integer>{

}
