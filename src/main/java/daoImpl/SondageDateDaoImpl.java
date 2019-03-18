package daoImpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import dao.SondageDateDao;
import entity.SondageDate;
import jpa.EntityManagerHelper;

public class SondageDateDaoImpl implements SondageDateDao {
	

	private EntityManager entityManager; 
	
	public SondageDateDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public SondageDate getSondageDateById(int idSondage) {
		SondageDate sondageDate = entityManager.find(SondageDate.class, idSondage);
		return sondageDate;
	}

	public void addSondageDate(SondageDate sondageDate) {
		if (!this.existSondageDate(sondageDate.getIdSondage())) {
			entityManager.persist(sondageDate);
		}
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
	

	public  List<SondageDate> findAllSondageDates(){
		return (List<SondageDate>)  entityManager.createNamedQuery("findAllSondageDates", SondageDate.class).getResultList();
		
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
