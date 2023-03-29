package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Animal;

public class AnimalDao {

	public Animal merge(Animal animal) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Animal merged = em.merge(animal);
		transaction.commit();
		em.close();
		return merged;
	}

	public Animal findById(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		Animal animal = em.find(Animal.class, id);
		em.close();
		return animal;
	}
	
	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Animal e where e.id = :id", Animal.class).setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
	
	public static void main(String[] args) {
		String nom = "Jean-Jacques";
    	AnimalDao animalDao = new AnimalDao();
    	Animal animal = new Animal();
		animal.setSurnom(nom);
    	
		Animal savedAnimal = animalDao.merge(animal);
	}

}
