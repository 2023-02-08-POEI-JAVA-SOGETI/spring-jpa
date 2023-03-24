package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Livre;

@Repository
public interface LivresSpringDao extends CrudRepository<Livre, Integer> {
    
    Livre findByTitreContainingIgnoreCase(String titre);
    
}
