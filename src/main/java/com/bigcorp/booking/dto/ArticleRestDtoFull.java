package com.bigcorp.booking.dto;

import com.bigcorp.booking.model.Article;
/*
 * Classe qui hérite de ArticleRestDto pour renvoyer un objet complet
 *{
 *   "id": 33,
 *   "numero": 301,
 *   "nom": "console PS5",
 *   "etat": "NEUF",
 *   "description": "encore plus puissante mais difficile à attraper",
 *   "fournisseurId": 30,
 *   "fournisseur": {
 *       "id": 30,
 *       "numero": 27,
 *       "nom": "Sony",
 *       "email": "sony@fournisseur.com",
 *       "adresse": "adresse de sony",
 *       "articlesDto": null
 *   }
 *}
 */
public class ArticleRestDtoFull extends ArticleRestDto {

	 private FournisseurRestDto fournisseur;
	 
	 public ArticleRestDtoFull(Article a) {
		 super(a);
		 if (a.getFournisseur() != null) {
			 this.fournisseur = new FournisseurRestDto(a.getFournisseur());
		 }
	 }

	public FournisseurRestDto getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(FournisseurRestDto fournisseur) {
		this.fournisseur = fournisseur;
	}
}
