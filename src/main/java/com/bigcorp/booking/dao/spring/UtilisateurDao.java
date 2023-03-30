package com.bigcorp.booking.dao.spring;

import com.bigcorp.booking.model.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurDao extends CrudRepository<Utilisateur, Integer> {

    @Query("from Utilisateur where lower(nom) like lower(:nomUtilisateur)")
    List<Utilisateur> findByName(@Param("nomUtilisateur") String name);
}
