package com.bigcorp.booking.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class MonService {

		@Autowired
		private MonDao monDao;
		



		public MonDao getMonDao() {
			return monDao;
		}

		public void setMonDao(MonDao monDao) {
			this.monDao = monDao;
		}
		public void saved() {
			System.out.print("Je viens de la classe MonService");
		}
		

}
