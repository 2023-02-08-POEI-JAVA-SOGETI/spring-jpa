package com.bigcorp.booking.mvc;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;

@Controller
public class ClientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/clients")
	public String index() {
	    LOGGER.info("Affichage de l'index client");
	    return "index-client";
	}
	
	@RequestMapping("/client/{id}")
	public ModelAndView show(@PathVariable("id") Integer id) {
	    LOGGER.info("Affichage du client avec l'ID : {}", id);
	    Client client = clientService.findById(id);
	    LOGGER.debug("Client trouvé : {}", client);
	    ModelAndView show = new ModelAndView();
	    show.setViewName("show-client");
	    show.addObject("client", client);
	    return show;
	}
	
	@GetMapping("/client/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
	    LOGGER.info("Affichage de la page de modification pour le client avec l'ID : {}", id);
	    Client client = clientService.findById(id);
	    LOGGER.debug("Client trouvé : {}", client);
	    model.addAttribute("client", client);
	    return "edit-client";
	}
	
	@GetMapping("client/new")
	public String newClient(Model model) {
	    LOGGER.info("Affichage de la page de création d'un nouveau client");
	    model.addAttribute("client", new Client());
	    return "new-client";
	}
	
	@PostMapping("client/create")
	public String createClient(@ModelAttribute("client") Client client, BindingResult result) {
	    client.setNumero(new Random().nextInt());
	    LOGGER.info("Création d'un nouveau client : {}", client);
	    if (result.hasErrors()) {
	        return "new-client";
	    }
	    clientService.save(client);
	    LOGGER.debug("Client créé avec succès : {}", client);
	    return "redirect:/client/" + client.getId();
	}
	
	@PostMapping("/client/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {
	    LOGGER.info("Suppression du client avec l'ID : {}", id);
	    clientService.delete(id);
	    return "redirect:/clients";
	}

	@PostMapping("/client/update")
	public String updateClient(@ModelAttribute("client") Client client, BindingResult bindingResult) {
		LOGGER.info("Sauvegarde des modifications pour le client : {}", client);
		if (bindingResult.hasErrors()) {
			return "edit-client";
		} else {
			clientService.save(client);
			LOGGER.debug("Modifications sauvegardées avec succès : {}", client);
			return "redirect:/client/" + client.getId();			
		}
	}
	
	@ModelAttribute("listClients")
	public Iterable<Client> listClients() {
	    LOGGER.debug("Récupération de la liste des clients");
	    return clientService.findAll();
	}

	@ModelAttribute("isClientsListEmpty")
	public Boolean isEmpty() {
		Boolean isEmpty = !listClients().iterator().hasNext();
		LOGGER.info("Vérification si la liste des Clients est vide : {}", isEmpty);
	    return !listClients().iterator().hasNext();
	}
}