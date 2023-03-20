package com.bigcorp.booking.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.dao.spring.FournisseurSpringDao;

import com.bigcorp.booking.model.Fournisseurs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FournisseurSpringService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurSpringService.class);
	@Autowired
	private FournisseurSpringDao fournisseurSpringDao;

	@Transactional
	public void save(Fournisseurs fournisseur) {
		LOGGER.info("Saving");
		this.fournisseurSpringDao.save(fournisseur);
		LOGGER.info("Saved");
	}

	public Fournisseurs findById(Integer id) {
		LOGGER.info("Searching");
		return this.fournisseurSpringDao.findById(id).orElse(null);
	}

	public List<Fournisseurs> findContainingName(String name) {
		LOGGER.info("Searching");
		return this.fournisseurSpringDao.findByNomContaining(name);
	}

	@Transactional
	public void delete(Integer id) {
		LOGGER.info("Deleting");
		this.fournisseurSpringDao.deleteById(id);
		LOGGER.info("Deleted");
	}
}
