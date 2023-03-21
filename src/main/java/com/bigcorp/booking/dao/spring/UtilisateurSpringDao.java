package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Utilisateur;

@Repository
public interface UtilisateurSpringDao extends CrudRepository<Utilisateur, Long>{
		List<Utilisateur> findByNom(String nom);
}
