package com.bigcorp.booking.dao.spring;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.dao.PersistenceSingleton;
import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;


@Repository
public interface ExampleSpringDao extends CrudRepository<Example, Long>  {
	
	
	//On veut ré
	
	public List<Example> findByNom(String nom);
	
	@Query("from Example where nom = :nom")
	List<Example> MaMethodeDeRechercheAvecUneQueryExplicite(@Param("nom") String nom);
	
	
	
	
//	{
//		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
//		List<Fournisseur> laListeDesFournisseurAvecLeBonNom = em
//				.createQuery("from Fournisseur where nom = :noFournisseur", Fournisseur.class)
//				.setParameter("nomFournisseur", nomFournisseur).getResultList();
//		em.close();
//		return laListeDesFournisseurAvecLeBonNom;
//	}

	
	
	
}
