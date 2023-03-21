package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigcorp.booking.model.Disney;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class MonTroisiemeControleur {
    
    /**
     * Intercepte les requêtes /salut , effectue
     * des instructions (ici un simple System.out) puis
     * renvoie vers la vue salut.
     * @return
     */
    @RequestMapping("/disney")
    public String afficherDisney(Model model) {
        Disney laBelleAuBoisDormant = new Disney();
        laBelleAuBoisDormant.setNom("Aurore");
        model.addAttribute("laBelleAuBoisDormant", laBelleAuBoisDormant);
        return "vue-disney";
    }

    
    
}