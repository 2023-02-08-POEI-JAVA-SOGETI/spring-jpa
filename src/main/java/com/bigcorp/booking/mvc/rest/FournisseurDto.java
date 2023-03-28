package com.bigcorp.booking.mvc.rest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.OneToMany;

import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class FournisseurDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Integer id;
	@NotEmpty
	private String nom;
	@Min(0)
	private Integer num;
	@Email
	private String email;
	@NotEmpty
	private String adresse;
	
//	private Set<ArticleDto> articles = new HashSet<>();

	

	
	public Fournisseur fillFournisseurWithDto(Fournisseur fournisseur)
	{
		fournisseur.setAdresse(this.adresse);
		fournisseur.setEmail(this.email);
		fournisseur.setId(this.id);
		fournisseur.setNom(this.nom);
		fournisseur.setNum(this.num);
		
//		
//		Function<ArticleDto, Article> mapDtoToArticle = articleDto -> new Article(articleDto.getId(),
//				articleDto.getNumArticle(),
//				articleDto.getType(),
//				articleDto.getNom(),
//				articleDto.getDescription());
//		
//		fournisseur.getArticles().addAll(this.articles.stream().map(mapDtoToArticle).collect(Collectors.toSet()));
		return fournisseur;
	}

	
	
	
	
	public FournisseurDto() {
		super();
	}


	public FournisseurDto( Fournisseur fournisseur) {
		this.id = fournisseur.getId();
		this.nom = fournisseur.getNom();
		this.num = fournisseur.getNum();
		this.email = fournisseur.getEmail();
		this.adresse= fournisseur.getAdresse();
		
//		Function<Article, ArticleDto> mapArticleToDto = article -> new ArticleDto(article.getId(),
//																					article.getNumArticle(),
//																					article.getType(),
//																					article.getNom(),
//																					article.getDescription());
//		
//		this.articles = fournisseur.getArticles().stream().map(mapArticleToDto).collect(Collectors.toSet());
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


}
