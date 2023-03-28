package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.mvc.bean.Invite;


@Controller
public class InviteController {
	
	@RequestMapping("/invites")
    public ModelAndView afficheDetailInviteRequestParam(@RequestParam("id") Integer id) {
    	ModelAndView modelAndView = new ModelAndView("invite");
    	modelAndView.addObject("invite", new Invite(id, "gépaslenom-url"));
		return modelAndView;
    }
	
	@RequestMapping("/invites/{inviteId}")
    public ModelAndView afficheDetailInvitePathVariable(@PathVariable("inviteId") Integer id) {
    	ModelAndView modelAndView = new ModelAndView("invite");
    	modelAndView.addObject("invite", new Invite(id, "gépaslenom-path"));
		return modelAndView;
    }

}