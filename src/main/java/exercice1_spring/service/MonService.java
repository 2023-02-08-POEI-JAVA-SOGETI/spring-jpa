package exercice1_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.model.Example;

@Service //permet de préciser que le bean est un service sans état,
//demander à Spring de gérer son cycle de vie.
public class MonService {
	
	@Autowired //Permet de demander une injection automatique par type
	//s'utilise sur une propriété, une methode, un setter ou un constructeur.
	//
	private MonDao monDao;

	public MonDao getMonDao() {
		return monDao;
	}

	public void setMonDao(MonDao monDao) {
		this.monDao = monDao;
	}

	

	/**
	 * Sauvegarde example
	 * 
	 * @param example
	 */
	//@Transactional
//	public void save(Example example) {
//		this.monDao.save(example);
//	}
}


