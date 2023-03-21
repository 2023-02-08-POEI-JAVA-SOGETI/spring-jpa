package com.bigcorp.booking.dao.spring;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends CrudRepository<Article, Integer> {

    @Query("from Article where lower(nom) like lower(:nomArticle)")
    List<Article> findByName(@Param("nomArticle") String name);
}
