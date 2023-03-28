package com.bigcorp.booking.dao.spring;

import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Article;
<<<<<<< HEAD
import com.bigcorp.booking.model.EtatArticle;

@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer>  {
	
	public List<Article> findByEtatArticleOrderByNom(EtatArticle etatArticle);

}
=======


@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer> {
	 
	List<Article>findByNom(String name);
}
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
