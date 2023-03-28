package com.bigcorp.booking.dao.spring;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.model.Client;

@Repository
<<<<<<< HEAD
public interface ClientSpringDao extends CrudRepository<Client, Integer>  {
	
	
}
=======
public interface ClientSpringDao  extends CrudRepository<Client, Integer>{
	List<Client> findByNom(String nom);
}
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
