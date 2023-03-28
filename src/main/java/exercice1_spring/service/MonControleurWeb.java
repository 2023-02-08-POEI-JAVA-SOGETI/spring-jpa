package exercice1_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//permet de préciser que le bean est un composant
//Définit une classe dont une instance sera
//instanciée, et auto détectée (car scannée dans le classpath)
public class MonControleurWeb {

	@Autowired
	private MonService monService;

	public MonService getMonService() {
		return monService;
	}

	public void setMonService(MonService monService) {
		this.monService = monService;
	}
}