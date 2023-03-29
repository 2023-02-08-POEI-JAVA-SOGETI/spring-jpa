package com.bigcorp.booking.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurDao;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.mvc.rest.FournisseurDto;

@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurDao dao;
	

	
	// SANS DTO : 
	
	
	public List<Fournisseur> getAllFournisseur()
	{
		return dao.findAll();
	}
	
	public Fournisseur getFournisseurWithArticles(Integer id)
	{
		return dao.findFournisseurWithArticles(id);
	}
	
	
	@Transactional
	public Fournisseur createFournisseur(Fournisseur newFournisseur)
	{
		return dao.save(newFournisseur);
	}
	
	
	@Transactional
	public Fournisseur updateFournisseur(Fournisseur newFournisseur)
	{
		Fournisseur fournisseur = dao.findById(newFournisseur.getId()).orElseThrow();
		
		fournisseur.setNom(newFournisseur.getNom());
		fournisseur.setNum(newFournisseur.getNum());
		fournisseur.setEmail(newFournisseur.getEmail());
		fournisseur.setAdresse(newFournisseur.getAdresse());
		
		Fournisseur updateFournisseur = dao.save(fournisseur);
		
		return updateFournisseur;
	}
	
	
	@Transactional
	public void deleteFournisseurById (Integer id)
	{
		
		dao.deleteById(id);
		
	}
	
	
	public Fournisseur getFournisseurById(Integer id)
	{
		return dao.findById(id).orElseThrow();
		
	}
	
	
	
	
	// AVEC DTO
	
	
	
	@Transactional
	public FournisseurDto createFournisseurWithDto(FournisseurDto fournisseurDto)
	{
		Fournisseur fournisseur = new Fournisseur();
		fournisseurDto.fillFournisseurWithDto(fournisseur);
		dao.save(fournisseur);
		FournisseurDto newFournisseurDto = new FournisseurDto(fournisseur);
		return newFournisseurDto;
	}
	
	
	public FournisseurDto getFournisseurByIdWithDTO(Integer id)
	{
		Fournisseur four = dao.findFournisseurWithArticles(id);
		FournisseurDto dto = new FournisseurDto(four);
		return dto;
	}
	
	
	@Transactional
	public FournisseurDto updateFournisseurWithDTO(FournisseurDto fournisseurDto)
	{
		 if (fournisseurDto == null || fournisseurDto.getId() == null) 
		 {
	        throw new IllegalArgumentException("FournisseurDto ou l'ID du FournisseurDto ne peut pas être null.");
		 }
		 
		 Fournisseur fournisseur = dao.findById(fournisseurDto.getId()).get();
		 fournisseurDto.fillFournisseurWithDto(fournisseur);
		 Fournisseur fournisseurUpdated = dao.save(fournisseur);
		 FournisseurDto update = new FournisseurDto(fournisseurUpdated);
		 
		 return update;
	}
	
	
	
}