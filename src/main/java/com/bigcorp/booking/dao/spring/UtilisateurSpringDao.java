package com.bigcorp.booking.dao.spring;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Utilisateur;

@Repository
<<<<<<< HEAD
public interface UtilisateurSpringDao extends CrudRepository<Utilisateur, Integer>  {
	
	
}
=======
public interface UtilisateurSpringDao extends CrudRepository<Utilisateur, Integer>{
		List<Utilisateur> findByNom(String nom);
}
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
