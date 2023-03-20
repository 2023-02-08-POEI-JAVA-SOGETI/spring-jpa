package com.bigcorp.booking.service;

import org.springframework.stereotype.Component;

@Component

public class MonSpringDao {
	// Method pour tester la liaison entre le Controleur, le Servie et le Dao
	public String getText() {        
        return "MonControleurWeb, MonService and MonDao are linked together using Spring annotations";
    }
	
}
