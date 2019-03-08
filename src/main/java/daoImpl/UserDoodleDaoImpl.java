package daoImpl;

import javax.persistence.EntityManager;

import entity.UserDoodle;
import jpa.EntityManagerHelper;

public class UserDoodleDaoImpl {
	
	private EntityManager entityManager;
	
	public UserDoodleDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public UserDoodle getUserDoodleById(String emailUtilisateur) {
		UserDoodle userDoodle = entityManager.find(UserDoodle.class, emailUtilisateur);
		return userDoodle;
	}

	public void addUserDoodle(UserDoodle userDoodle) {
		entityManager.persist(userDoodle);
	}

	
	public void removeUserDoodle(UserDoodle userDoodle) {
		entityManager.remove(userDoodle);
	}

	
	public void updateStudent(UserDoodle userDoodle) {
		entityManager.merge(userDoodle);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
}
