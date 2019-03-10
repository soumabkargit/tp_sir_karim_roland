package daoImpl;

import java.util.Collection;
import javax.persistence.EntityManager;
import entity.SondageDate;
import jpa.EntityManagerHelper;

public class SondageDateDaoImpl {
	

	private EntityManager entityManager;
	
	public SondageDateDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public SondageDate getSondageDateById(int idSondage) {
		SondageDate sondageDate = entityManager.find(SondageDate.class, idSondage);
		return sondageDate;
	}

	public void addSondageDate(SondageDate sondageDate) {
		entityManager.persist(sondageDate);
	}

	
	public void removeSondageDate(SondageDate sondageDate) {
		entityManager.remove(sondageDate);
	}

	
	public void updateSondageDate(SondageDate sondageDate) {
		entityManager.merge(sondageDate);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	

	public  Collection<SondageDate> findAllSondageDates(){
		return (Collection<SondageDate>)  entityManager.createNamedQuery("findAllSondageDates", SondageDate.class).getResultList();
		
	}

	public boolean existSondageDate(int idSondage) {
		SondageDate sondageDate = entityManager.find(SondageDate.class, idSondage);
		boolean test;
		if (sondageDate == null) {
			test = false;
		}else {
			test = true;
		}
		return test;
	}	
	

}
