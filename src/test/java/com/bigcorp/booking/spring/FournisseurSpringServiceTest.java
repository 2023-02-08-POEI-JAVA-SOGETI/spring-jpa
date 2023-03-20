package com.bigcorp.booking.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.service.spring.FournisseurSpringService;


@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurSpringServiceTest {
	
	@Autowired
	private FournisseurSpringService fournisseurService;

	@Test
	public void test() {
		Fournisseurs fourn1 = new Fournisseurs();
		Fournisseurs fourn2 = new Fournisseurs();
		fourn1.setNom("Test");
		fourn1.setNumeroUnique(123);
		fourn2.setNom("Test");
		fourn2.setNumeroUnique(456);
		fournisseurService.save(fourn2);
		fournisseurService.save(fourn1);
		List<Fournisseurs> resultTest = fournisseurService.findContainingName("Test");
		Assertions.assertEquals(2, resultTest.size());
	}

}
