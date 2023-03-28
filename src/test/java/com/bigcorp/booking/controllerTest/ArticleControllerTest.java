package com.bigcorp.booking.controllerTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.mvc.ArticleController;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleControllerTest {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
    private ArticleController articleController;
	 

	

}
