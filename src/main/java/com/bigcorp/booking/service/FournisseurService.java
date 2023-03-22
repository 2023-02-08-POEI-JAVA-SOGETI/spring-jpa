package com.bigcorp.booking.service;

import com.bigcorp.booking.dao.spring.FournisseurDao;
import com.bigcorp.booking.model.Fournisseur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;


@Service
public class FournisseurService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurService.class);

    @Autowired
    private FournisseurDao fournisseurDao;

    @Transactional
    public void save(Fournisseur fournisseur) {
        if (fournisseur.getNom() != "NOM") {
        	
            this.fournisseurDao.save(fournisseur);
            
            LOGGER.info("Retailer successfully saved!");
        } else LOGGER.info("Retailer couldn't be saved.");

    }

    @Transactional
    public void delete(int id) {
        if (id != 0) {
            this.fournisseurDao.deleteById(id);
            LOGGER.info("Retailer successfully removed!");
        } else LOGGER.info("Retailer couldn't be removed.");
    }

    @Transactional
    public Fournisseur getById(int id) {
        if(id==0) return null;

        return this.fournisseurDao.findById(id).orElse(null);
    }

    @Transactional
    public List<Fournisseur> getByName(String name) {
        if(name=="") return null;

        List<Fournisseur> fournisseurs = this.fournisseurDao.findByName(name);

        return fournisseurs.isEmpty() ? null : fournisseurs;
    }
    
    @Transactional
    public List<Fournisseur> getAllFournisseurs() {
    	Iterable<Fournisseur> fournisseursIterable = this.fournisseurDao.findAll();
    	
    	List<Fournisseur> fournisseurs = new ArrayList<>();
    	
    	for(Fournisseur fournisseur: fournisseursIterable) {
    		fournisseurs.add(fournisseur);
    	}
    	
    	return fournisseurs;
    }
}
