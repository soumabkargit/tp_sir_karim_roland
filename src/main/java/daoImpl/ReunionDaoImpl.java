package daoImpl;

import java.util.Collection;
import javax.persistence.EntityManager;
import entity.Reunion;
import jpa.EntityManagerHelper;

public class ReunionDaoImpl {


	private EntityManager entityManager;
	
	public ReunionDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public Reunion getReunionById(int idReunion) {
		Reunion reunion = entityManager.find(Reunion.class, idReunion);
		return reunion;
	}

	public void addReunion(Reunion reunion) {
		entityManager.persist(reunion);
	}

	
	public void removeReunion(Reunion reunion) {
		entityManager.remove(reunion);
	}

	
	public void updateReunion(Reunion reunion) {
		entityManager.merge(reunion);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public  Collection<Reunion> findAllReunions(){
		return (Collection<Reunion>)  entityManager.createNamedQuery("findAllReunions", Reunion.class).getResultList();
		
	}

	public boolean existReunion(int idReunion) {
		Reunion reunion = entityManager.find(Reunion.class, idReunion);
		boolean test;
		if (reunion == null) {
			test = false;
		}else {
			test = true;
		}
		return test;
	}
}