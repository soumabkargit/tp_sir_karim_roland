package daoImpl;

import java.util.Collection;

import javax.persistence.EntityManager;
import entity.SondageLieu;
import jpa.EntityManagerHelper;

public class SondageLieuDaoImpl {


	private EntityManager entityManager;
	
	public SondageLieuDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public SondageLieu getSondageLieuById(int idSondage) {
		SondageLieu SondageLieu = entityManager.find(SondageLieu.class, idSondage);
		return SondageLieu;
	}

	public void addSondageLieu(SondageLieu sondageLieu) {
		entityManager.persist(sondageLieu);
	}

	
	public void removeSondageLieu(SondageLieu sondageLieu) {
		entityManager.remove(sondageLieu);
	}

	
	public void updateSondageLieu(SondageLieu sondageLieu) {
		entityManager.merge(sondageLieu);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public  Collection<SondageLieu> findAllSondageLieux(){
		return (Collection<SondageLieu>)  entityManager.createNamedQuery("findAllSondageLieux", SondageLieu.class).getResultList();
		
	}

	public boolean existSondageLieu(int idSondage) {
		SondageLieu sondageLieu = entityManager.find(SondageLieu.class, idSondage);
		boolean test;
		if (sondageLieu == null) {
			test = false;
		}else {
			test = true;
		}
		return test;
	}	
}
