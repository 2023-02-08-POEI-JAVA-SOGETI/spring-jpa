package com.restaurant.daoTest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.dao.TypeRestaurantDao;
import com.restaurant.model.Prix;
import com.restaurant.model.Restaurant;
import com.restaurant.model.TypeRestaurant;
import com.restaurant.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class RestaurantDaoTest {

	@Autowired
	private RestaurantDao restaurantDao;
	@Autowired
	private TypeRestaurantDao typeRestaurantDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantDaoTest.class);
 
	@Test
	public void testSaveSimple() {
		LOGGER.info("testSaveSimple : Test simple de la sauvegarde du Restaurant");
		Restaurant r = new Restaurant("Chez Marecelo", Prix.TRES_CHER, "italie plaza dela popolo");
		restaurantDao.save(r);
	}
	
	@Test
	public void testSaveType() {
		LOGGER.info("testSaveType : Test de la sauvegarde du TypeRestaurant et du Restaurant");
		TypeRestaurant type = new TypeRestaurant("italien");
		TypeRestaurant savedType = typeRestaurantDao.save(type);
		
		Restaurant r = new Restaurant("Chez Marcelo", Prix.TRES_CHER, "italie plaza dela popolo", savedType);
		restaurantDao.save(r);
	}
}
