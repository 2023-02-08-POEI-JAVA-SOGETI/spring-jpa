package com.bigcorp.booking.tentative;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSpringLivresDao {

    @Autowired
    private LivresSpringDao livresSpringDao;

    public List<Livre> getAllLivres() {		/*Pourquoi List est souligné*/
        return livresSpringDao.findAll();
    }

    public Livre getLivreById(int id) {
        return livresSpringDao.findById(id);
    }

    public Livre findLivresByTitre(String titre) {
        return livresSpringDao.findByTitleContainingIgnoreCase(titre);
    }
    
    public Livre addLivre(Livre livre) {
        return livresSpringDao.save(livre);
    }

    public Livre updateLivre(Long id, Livre livre) {
        Livre existingLivre = livresSpringDao.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));
        existingLivre.setTitre(livre.getTitre());
        existingLivre.setAuteur(livre.getAuteur());
        return livresSpringDao.save(existingLivre);
    }

    public void deleteLivre(Long id) {
        livresSpringDao.deleteById(id);
    }
}
