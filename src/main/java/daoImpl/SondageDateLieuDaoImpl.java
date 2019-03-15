package daoImpl;

import java.util.Collection;

import javax.persistence.EntityManager;

import dao.SondageDateLieuDao;
import entity.SondageDateLieu;
import jpa.EntityManagerHelper;

public class SondageDateLieuDaoImpl implements SondageDateLieuDao {


	private EntityManager entityManager;
	
	public SondageDateLieuDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public SondageDateLieu getSondageDateLieuById(int idSondage) {
		SondageDateLieu sondageDateLieu = entityManager.find(SondageDateLieu.class, idSondage);
		return sondageDateLieu;
	}

	public void addSondageDateLieu(SondageDateLieu sondageDateLieu) {
		
		if (!this.existSondageDateLieu(sondageDateLieu.getIdSondage())) {
			entityManager.persist(sondageDateLieu);
		}

	}

	
	public void removeSondageDateLieu(SondageDateLieu sondageDateLieu) {
		entityManager.remove(sondageDateLieu);
	}

	
	public void updateSondageDateLieu(SondageDateLieu sondageDateLieu) {
		entityManager.merge(sondageDateLieu);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	

	public  Collection<SondageDateLieu> findAllSondageDateLieux(){
		return (Collection<SondageDateLieu>)  entityManager.createNamedQuery("findAllSondageDateLieux", SondageDateLieu.class).getResultList();
		
	}

	public boolean existSondageDateLieu(int idSondage) {
		SondageDateLieu sondageDateLieu = entityManager.find(SondageDateLieu.class, idSondage);
		boolean test;
		if (sondageDateLieu == null) {
			test = false;
		}else {
			test = true;
		}
		return test;
	}
	
}
