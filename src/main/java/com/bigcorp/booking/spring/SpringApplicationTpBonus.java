package com.bigcorp.booking.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigcorp.booking.tpSpring.MonControlerWebTp;


public class SpringApplicationTpBonus {

	public static void main(String[] args) throws InterruptedException {
		try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("configTpBonus.xml")) {
			MonControlerWebTp monControlerWebTp = appContext.getBean("monControlerWebTp", MonControlerWebTp.class);
			monControlerWebTp.getMonServiceTp().getMonDaoTp().sayHello();
		}
	}

}