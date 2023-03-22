package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.model.Camion;

@Controller
public class CoucouController {
	 
	@RequestMapping("/coucou")
	public String showSayHello() {
	    	System.out.println("Le contrôleur de coucou agit ! ");
	        return "vue-coucou";
	    }
	@ModelAttribute("helloFrom")
	public String helloFrom() {
		 return "From Coucou controller at :" +" "+ java.time.LocalDate.now();
	}
	
	@ModelAttribute("chauffeMarcel")
	public Camion chauffeMarcel() {
		Camion marcel = new Camion();
		marcel.setNom("Chauffe Marcel !!!");
		 return marcel;
	}
	
	@ModelAttribute("listCamion")
	public List<Camion> getCamionList() {
		Camion man = new Camion();
		Camion renault = new Camion();
		renault.setNom("renault 300 ");
		man.setNom("man");
		List<Camion> camions = new ArrayList<>();
		camions.add(renault);
		camions.add(man);
		return camions;
		}
	
	@ModelAttribute("displayDiv")
	public Boolean displayDiv() {
		Camion man = new Camion();
		Camion renault = new Camion();
		renault.setNom("renault 300 ");
		man.setNom("man");
		List<Camion> camions = new ArrayList<>();
		camions.add(renault);
		camions.add(man);
		
		return camions.isEmpty() ? false : true;
	}
}

