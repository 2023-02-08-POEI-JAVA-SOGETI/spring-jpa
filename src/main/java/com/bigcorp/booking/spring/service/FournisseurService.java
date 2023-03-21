package com.bigcorp.booking.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurDao;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;

@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurDao dao;
	
	
	public Fournisseur getFournisseurById(Integer id)
	{
		return dao.findById(id).orElseThrow();
		
	}
	
	@Transactional
	public Fournisseur createFournisseur(Fournisseur newFournisseur)
	{
		return dao.save(newFournisseur);
	}
	
	@Transactional
	public void deleteFournisseurById (Integer id)
	{
	
		dao.deleteById(id);
		
	}


}
