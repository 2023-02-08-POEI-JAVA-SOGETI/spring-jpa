package com.bigcorp.booking.dao.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

@Repository
public interface FournisseurSpringDao  extends CrudRepository<Fournisseur, Integer>{
	List<Fournisseur> findByNom(String name);

	Fournisseur findById(Integer id);
}
