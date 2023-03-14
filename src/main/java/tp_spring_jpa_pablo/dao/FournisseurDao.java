package tp_spring_jpa_pablo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.dao.PersistenceSingleton;

public class FournisseurDao {
	public Fournisseur merge(Fournisseur object) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Fournisseur merged = em.merge(object);
		transaction.commit();
		em.close();
		return merged;
	}

	public Fournisseur findById(int id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Fournisseur.class, id);
	}

	public void remove(Long id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createQuery("delete from Fournisseur e where e.id = :id", Fournisseur.class).setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		em.close();
	}
}
