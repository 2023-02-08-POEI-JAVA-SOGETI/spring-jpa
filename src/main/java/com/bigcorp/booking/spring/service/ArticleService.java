package com.bigcorp.booking.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.ArticleDao;
import com.bigcorp.booking.dao.spring.FournisseurDao;
import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.mvc.rest.ArticleDto;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao dao;
	
	@Autowired
	private FournisseurDao fourDao;
	
	
	
	// WITHOUT DTO
	
	
	public Article getArticleById(Integer id)
	{
		return dao.findById(id).orElseThrow();
		
	}
	
	@Transactional
	public Article createArticle(Article newArticle)
	{
		return dao.save(newArticle);
	}
	
	@Transactional
	public Article associatedArticleWithFournisseur (Integer idArticle, Integer idFournisseur) throws Exception
	{
		Fournisseur associatedFournisseur = fourDao.findById(idFournisseur).orElseThrow();
		Article associatedArticle = dao.findById(idArticle).orElseThrow();
		
		if (associatedArticle == null)
		{
			throw new Exception("L'id de l'article est null");
		}
		
		associatedArticle.setFournisseur(associatedFournisseur);
		
		Article updateArticle = dao.save(associatedArticle);
		return updateArticle;
		
	}
	
	
	@Transactional
	public void deleteArticleById (Integer id)
	{
	
		dao.deleteById(id);
		
	}
	


	
	
	// WITH DTO
	
	
	
	public ArticleDto getArticleByIdWithDTO(Integer id) {
		Article article = dao.findById(id).get();
		ArticleDto dto = new ArticleDto(article);
		return dto;
	}

	
	
	@Transactional
	public ArticleDto createArticleWithDto(ArticleDto articleDto) {
		Article article = new Article();
		articleDto.fillArticleWithDto(article);
		dao.save(article);
		ArticleDto newArticleDto = new ArticleDto(article);
		return newArticleDto;
	}
	
	
	@Transactional
	public ArticleDto updateArticleWithDTO(ArticleDto articleDto)
	{
		 if (articleDto == null || articleDto.getId() == null) 
		 {
	        throw new IllegalArgumentException("ArticleDto ou l'ID ne peuvent pas être null.");
		 }
		 
		 Article article = dao.findById(articleDto.getId()).get();
		 articleDto.fillArticleWithDto(article);
		 Article articleUpdated = dao.save(article);
		 ArticleDto update = new ArticleDto(articleUpdated);
		 
		 return update;
	}

}
