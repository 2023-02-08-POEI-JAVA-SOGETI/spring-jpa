package com.restaurant.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.model.Prix;
import com.restaurant.model.Restaurant;
import com.restaurant.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class RestaurantDaoTest {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Test
	public void testSaveSimple() {
		//RestaurantDao restaurantDao = new RestaurantDao();
		Restaurant r = new Restaurant("Chez Marecelo", Prix.TRES_CHER, "italie plaza dela popolo");
		
		restaurantDao.save(r);
	}
	
	
}
