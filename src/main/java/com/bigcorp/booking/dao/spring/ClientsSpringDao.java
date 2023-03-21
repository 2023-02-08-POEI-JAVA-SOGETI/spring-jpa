package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Clients;

@Repository

public interface ClientsSpringDao extends CrudRepository<Clients, Long>  {
	
//	@Transactional
//	public Fournisseur save(Fournisseur fournisseur) {
// return this.fournisseurSpringDao.save(fournisseur);
//	}
}
