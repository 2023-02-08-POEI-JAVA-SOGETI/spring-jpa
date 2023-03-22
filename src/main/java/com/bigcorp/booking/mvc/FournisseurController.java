package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigcorp.booking.spring.service.FournisseurService;

@Controller
public class FournisseurController {
	
	@Autowired
	private FournisseurService service;
	
	@RequestMapping(path = "/coucou", method = RequestMethod.GET)
    public String showSayHello() {
    	System.out.println("Le contrôleur de salut agit ! ");
        return "coucou";
	
	}
	
	
	
	
	
}
