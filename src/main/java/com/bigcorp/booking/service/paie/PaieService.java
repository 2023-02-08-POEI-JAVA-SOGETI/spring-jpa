package com.bigcorp.booking.service.paie;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.PaieDao;
import com.bigcorp.booking.model.Paie;

@Service
public class PaieService {
	
	private static final String VALIDE = "VALIDE";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaieService.class);
	
	@Autowired
	private PaieDao paieDao;

	/**
	 * Valide toutes les fiche de paie dont l'id est passé en paramètre.
	 * Logge nomPersonne.
	 * @param idsPaie
	 * @param nomPersonne
	 * @return 
	 */
	@Transactional
	public Integer validateAll(List<Integer> idsPaie, String nomPersonne) {
		LOGGER.info("Je valide toutes mes fiches à la demande de : {}",  nomPersonne);
		Integer nbFichePaieValidees = 0;
		for(Integer idPaie : idsPaie) {
			Paie paie = paieDao.findById(idPaie).get();
			if(paie == null) {
				throw new RuntimeException("Tentative de validation d'une fiche qui n'existe pas en base");
			}
			paie.setStatut(VALIDE);
			paieDao.save(paie);
			nbFichePaieValidees++;
		}
		return nbFichePaieValidees;
	}
	
}
