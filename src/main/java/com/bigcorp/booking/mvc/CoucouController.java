package com.bigcorp.booking.mvc;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.model.Stand;

@Controller
public class CoucouController {

	Stand stand = new Stand(1, "Star Platinum");
	Stand stand2 = new Stand(2, "The World");
	Stand stand3 = new Stand(3, "Hermit Purple");
	Stand stand4 = new Stand(4, "Silver Chariot");
	Stand stand5 = new Stand(5, "November Rain");

	@RequestMapping("/coucou")
	public String showCoucou() {
		System.out.println("Coucou controller is coocooking!");

		return "coucou";
	}

	@ModelAttribute("notSoBad")
	public String putNotSoBadInContext() {
		return "Not so bad for a first";
	}

	@ModelAttribute("standName")
	public String putStandNameInContext() {

		return "Here's " + stand.getName();
	}

	@ModelAttribute("displayHeader")
	public Boolean getDisplayHeader() {
		return false;
	}

	@ModelAttribute("stands")
	public List<Stand> getStands() {
		List<Stand> stands = new ArrayList<>();

		stands.add(stand);
		stands.add(stand4);
		stands.add(stand2);
		stands.add(stand3);
		stands.add(stand5);

		return stands;
	}

	@RequestMapping("/stands")
	public ModelAndView getStandsDetail(@RequestParam("id") Long id) {
		System.out.println("Details du Stand: " + id);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("coucou");
		mav.addObject("stand", new Stand(1, "Silver Chariot"));

		return mav;
	}

	@RequestMapping("/stands/{id}")
	public ModelAndView getStandDetailsWithPath(@PathVariable("id") Long id) {
		System.out.println("Details du Stand via chemin: " + id);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("coucou");
		mav.addObject("stand", new Stand(1, "Silver Chariot"));

		return mav;
	}
}
