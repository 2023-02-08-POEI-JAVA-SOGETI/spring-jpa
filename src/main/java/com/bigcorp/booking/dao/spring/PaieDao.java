package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Paie;

@Repository
public interface PaieDao extends CrudRepository<Paie, Integer>  {

	public List<Paie> findByStatut(String statut);
	
}
