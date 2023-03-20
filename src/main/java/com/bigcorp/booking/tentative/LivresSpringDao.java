package com.bigcorp.booking.tentative;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface LivresSpringDao extends CrudRepository<Livre, Long> {
	
	/*Create*/
	Livre save(Livre entity);
	
	/*Read*/
	Livre findById(int id);
	Livre getById(String titre);
	
	/*Update - Pas de commandes équivalentes pour Update*/
	
	/*Delete*/
	void delete(Livre entity);

	Livre findByTitleContainingIgnoreCase(String titre);

	static void addLivre(Livre livre) {
		// TODO Auto-generated method stub
		
	}

}


/*	@Modifying 
	@Query("DELETE Livre WHERE id = :id")
	List<Livre> removeById(Integer id);
*/

