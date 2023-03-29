package com.bigcorp.booking.mvc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.spring.service.FournisseurService;


@RestController
@RequestMapping("/rest-fournisseur")
public class FournisseurRestController {
	
	@Autowired
	private FournisseurService service;

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurRestController.class);
	
	
	@GetMapping("/{id}")
	 public FournisseurDto showFournisseur(@PathVariable("id") Integer id)
	    {
		
		LOGGER.info("Récupération du fournisseur n° " + id);
		
			if(id == null || id<=0)
			 	{
			 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id incorrect");
			 	}
				
			FournisseurDto dto = service.getFournisseurByIdWithDTO(id);
			
			if(dto == null )
		 	{
		 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun frounisseur trouvé");
		 	}
			
	    	return dto;
	    }
	
	
	
	@PostMapping("/create")
	public FournisseurDto createFournisseur(@RequestBody FournisseurDto fournisseurDto)
	{
		LOGGER.info("Création d'un nouveau Fournisseur en BDD");
		
		if(fournisseurDto == null )
	 	{
	 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun frounisseur crée");
	 	}
		
		return service.createFournisseurWithDto(fournisseurDto);
	}
	
	
	@PostMapping("/update")
	public FournisseurDto updateFournisseur(@Validated @RequestBody FournisseurDto fournisseurDto,
											BindingResult result)
	{
		if(result.hasErrors())
		{
			ObjectError error = result.getAllErrors().get(0);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getDefaultMessage());
		}
		
		if(fournisseurDto == null )
	 	{
	 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun frounisseur mis à jour");
	 	}
		
		LOGGER.info("M.A.J du fournisseur n° " + fournisseurDto.getId());
		
		return service.updateFournisseurWithDTO(fournisseurDto);
	}
	

	
	@DeleteMapping("/delete/{id}")
	public String supprimeFournisseur(@PathVariable("id") Integer id)
	{
		LOGGER.info("Suppression du fournisseur n° " + id);
		
		if(id == null || id <=0)
	 	{
	 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun frounisseur trouvé");
	 	}
		
		service.deleteFournisseurById(id);
		
		return "Fournisseur n° " + id + " supprimé";
	}

}
