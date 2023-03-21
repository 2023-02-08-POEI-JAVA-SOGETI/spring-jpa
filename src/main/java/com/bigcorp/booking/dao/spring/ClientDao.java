package com.bigcorp.booking.dao.spring;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends CrudRepository<Client, Integer> {

    @Query("from Client where lower(nom) like lower(:nomClient)")
    List<Client> findByName(@Param("nomClient") String name);
}
