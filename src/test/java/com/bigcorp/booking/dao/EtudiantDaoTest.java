package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Etudiant;
import com.bigcorp.booking.model.Formation;

public class EtudiantDaoTest {
    @Test
    public void testSave() {

    	Etudiant e1 = new Etudiant("Maxime");
    	Etudiant e2 = new Etudiant("Jennifer");
    	Etudiant e3 = new Etudiant("Johanna");
    	 
    	EtudiantDao etudiantDao = new EtudiantDao();   	

    	Formation f1 = new Formation("POE JAVA");
    	Formation f2 = new Formation("Recrutement");
    	Formation f3 = new Formation("Dessin avance");
		
		FormationDao formationDao = new FormationDao();
		
		Formation savedFormation1 = formationDao.merge(f1);
    	Assertions.assertNotNull(savedFormation1.getId());
		Formation savedFormation2 = formationDao.merge(f2);
    	Assertions.assertNotNull(savedFormation2.getId());
		Formation savedFormation3 = formationDao.merge(f3);
    	Assertions.assertNotNull(savedFormation3.getId());
		
    	e1.addFormation(savedFormation1);
    	e1.addFormation(savedFormation3);
    	
    	e2.addFormation(savedFormation1);
    	e2.addFormation(savedFormation2);
    	
    	e3.addFormation(savedFormation2);
    	e3.addFormation(savedFormation3);

    	// Sauvegarde à partir de EtudiantDao => Maitre ?
    	etudiantDao.merge(e1);
    	etudiantDao.merge(e2);
    	etudiantDao.merge(e3);
    	

    	Etudiant newbie = etudiantDao.findById(Etudiant.class, 1);
    	Assertions.assertEquals("Maxime", e1.getName());
    	for(Formation f : newbie.getFormations())
    		System.out.println("Formation : " + f.getName());
    }
}
