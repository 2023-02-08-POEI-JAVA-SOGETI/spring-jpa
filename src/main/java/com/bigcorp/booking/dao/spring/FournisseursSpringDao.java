package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;

import com.bigcorp.booking.model.Fournisseurs;

public interface FournisseursSpringDao extends CrudRepository<Fournisseurs, Integer>{

//	@Query("SELECT fournisseur1 FROM Fournisseurs a")
//    List<Fournisseurs> findAllFournisseurs();
}
