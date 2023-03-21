package com.bigcorp.booking.dao.spring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Fournisseur;

import java.util.List;
import java.util.Locale;

@Repository
public interface FournisseurDao extends CrudRepository<Fournisseur, Integer> {

    @Query("from Fournisseur where lower(nom) like lower(:nomFournisseur)")
    List<Fournisseur> findByName(@Param("nomFournisseur") String name);
}
