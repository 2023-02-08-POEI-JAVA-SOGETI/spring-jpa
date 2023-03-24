package com.bigcorp.booking.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bigcorp.booking.dao.spring.LivresSpringDao;
import com.bigcorp.booking.model.Livre;

/*@Service*/
public class ServiceSpringLivres {

    @Autowired
    private LivresSpringDao livresSpringDao;

    public Iterable<Livre> getAllLivres() {		
        return livresSpringDao.findAll();
    }

    public Livre getLivreById(int id) {
        return livresSpringDao.findById(id).orElse(null);
    }

    public Livre findLivresByTitre(String titre) {
        return livresSpringDao.findByTitreContainingIgnoreCase(titre);
    }
    
    public Livre addLivre(Livre livre) {
        return livresSpringDao.save(livre);
    }

    public Livre updateLivre(Integer id, Livre livre) {
        Livre existingLivre = livresSpringDao.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));
        existingLivre.setTitre(livre.getTitre());
        existingLivre.setAuteur(livre.getAuteur());
        return livresSpringDao.save(existingLivre);
    }

    public void deleteLivre(Integer id) {
        livresSpringDao.deleteById(id);
    }

    @Transactional
	public Livre save(Livre livre) {
    	return this.livresSpringDao.save(livre);
	}

}
