package daoImpl;

import javax.persistence.EntityManager;

import entity.Sondage;
import jpa.EntityManagerHelper;

public class SondageDaoImpl {

	private EntityManager entityManager;
	
	public SondageDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public Sondage getSondageById(int idSondage) {
		Sondage sondage = entityManager.find(Sondage.class, idSondage);
		return sondage;
	}

	public void addSondage(Sondage sondage) {
		entityManager.persist(sondage);
	}

	
	public void removeSondage(Sondage sondage) {
		entityManager.remove(sondage);
	}

	
	public void updateSondage(Sondage sondage) {
		entityManager.merge(sondage);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
}
