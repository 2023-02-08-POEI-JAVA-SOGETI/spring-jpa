package com.bigcorp.booking.spring.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurDao;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;

@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurDao dao;
	
	
	public List<Fournisseur> getAllFournisseur()
	{
		return dao.findAll();
		
	}
	
	
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
	public Fournisseur updateFournisseur(Integer id, Fournisseur newFournisseur)
	{
		Fournisseur oldFournisseur = dao.findById(id).orElseThrow();
		
		oldFournisseur.setNom(newFournisseur.getNom());
		oldFournisseur.setNum(newFournisseur.getNum());
		oldFournisseur.setEmail(newFournisseur.getEmail());
		oldFournisseur.setAdresse(newFournisseur.getAdresse());
		
		Fournisseur updateFournisseur = dao.save(oldFournisseur);
		
		return updateFournisseur;
	}
	
	
	@Transactional
	public void deleteFournisseurById (Integer id)
	{
	
		dao.deleteById(id);
		
	}


}
