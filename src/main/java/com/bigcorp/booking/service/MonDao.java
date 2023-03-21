package com.bigcorp.booking.service;


import org.springframework.stereotype.Component;

@Component
public class MonDao {

		public void save(MonDao monDao) {
		System.out.println("Je viens de la classe MonDao");
	}

		@Override
		public String toString() {
			return "MonDao [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}

		public void affiche(Object object) {
			// TODO Auto-generated method stub
			System.out.println("Je viens de la classe MonDao");
		}
	
}
