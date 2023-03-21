package com.bigcorp.booking.dao.spring;

import org.springframework.data.repository.CrudRepository;

import com.bigcorp.booking.model.Articles;

public interface ArticlesSpringDao extends CrudRepository<Articles, Integer>{



}
