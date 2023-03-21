package com.bigcorp.booking.tentative;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivresSpringDao extends CrudRepository<Livre, Integer> {
    
    Livre findByTitreContainingIgnoreCase(String titre);
    
}
