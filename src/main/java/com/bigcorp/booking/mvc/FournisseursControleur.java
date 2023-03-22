package com.bigcorp.booking.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;

@Controller
public class FournisseursControleur {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@RequestMapping("/fournisseurs")
	public String showFournisseurs() {
		return "fournisseurs";
	}
	
    @ModelAttribute("listFournisseurs")
    public List<Fournisseur> populateFournisseurs() {
    	return fournisseurService.findAll();
    }
}
