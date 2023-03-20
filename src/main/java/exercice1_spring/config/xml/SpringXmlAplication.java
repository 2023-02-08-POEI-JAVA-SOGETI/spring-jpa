package exercice1_spring.config.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import exercice1_spring.service.MonControleurWeb;

public class SpringXmlAplication {
	
	

	public static void main(String[] args) throws InterruptedException {
		try(ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("SpringConfiguration.xml")){
			
			MonControleurWeb monControleurWeb = new MonControleurWeb();
			
			System.out.println(monControleurWeb.getMonService().getMonDao());
		}
		
	}

}
