package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.mvc.bean.Invite;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller
public class MonPremierControleur {

	/**
	 * Intercepte les requêtes /salut , effectue des instructions (ici un simple
	 * System.out) puis renvoie vers la vue salut.
	 * 
	 * @return
	 */
	@RequestMapping("/salut")
	public String saveSayHello() {
		System.out.println("Le contrôleur de salut agit ! ");
		return "vue-salut";
	}

	@ModelAttribute("vraiTexte")
	public String getVraiTexte() {
		return "Ceci est le vrai texte !";
	}

	@ModelAttribute("invites")
	public List<Invite> getInvites() {
		List<Invite> invites = new ArrayList<>();
		invites.add(new Invite(1,"Pablo"));
		invites.add(new Invite(2,"ElHadji"));
		invites.add(new Invite(3,"Lucile"));
		invites.add(new Invite(4,"Khadidja"));
		invites.add(new Invite(5,"Silvio"));
		return invites;
	}

}