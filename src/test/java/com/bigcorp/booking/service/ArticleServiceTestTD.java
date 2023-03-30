package com.bigcorp.booking.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleServiceTestTD {
	
	@Autowired
	private ArticleServiceTD articleServiceTP;

		@Test
			public void testArticleService() {
				articleServiceTP.findById(2);
		}

}
