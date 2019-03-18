package daoImpl;

import java.util.Collection;
import javax.persistence.EntityManager;

import dao.AllergieDao;
import entity.Allergie;
import jpa.EntityManagerHelper;

public class AllergieDaoImpl implements AllergieDao {
	
private EntityManager entityManager;
	 
	public AllergieDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public Allergie getAllergieById(int idAllergie) {
		Allergie allergie = entityManager.find(Allergie.class, idAllergie);
		return allergie;
	}

	public void addAllergie(Allergie allergie) {
		if (!this.existAllergie(allergie.getIdAllergie())) {
			entityManager.persist(allergie);
		}
	}

	
	public void removeAllergie(Allergie allergie) {
		entityManager.remove(allergie);
	}

	
	public void updateAllergie(Allergie allergie) {
		entityManager.merge(allergie);
	}

	public  Collection<Allergie> findAllAllergies(){
		return (Collection<Allergie>)  entityManager.createNamedQuery("findAllParticipants", Allergie.class).getResultList();
		
	}

	public boolean existAllergie( int idAllergie ) {
		Allergie allergie = entityManager.find(Allergie.class, idAllergie);
		boolean test;
		if (allergie == null) {
			test = false;
		}else {
			test = true;
		}
		return test;
	}
	
	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}


}
