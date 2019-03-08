package service;

import javax.persistence.EntityManager;

import daoImpl.UserDoodleDaoImpl;
import entity.UserDoodle;
import entity.Utilisateur;
import jpa.EntityManagerHelper;

public class UtilisateurService {
	
	private UserDoodleDaoImpl userDoodleDaoImpl = new UserDoodleDaoImpl() ;
	private Utilisateur utilisateur;
//	
//	public public void addUserDoodle(UserDoodle userDoodle) {
//
//		userDoodleDaoImpl.beginTransaction();
//		userDoodleDaoImpl.persist(employee);
//		entityManager.getTransaction().commit();
//		
//	}
	
	/*
	@Override
	public public void addUserDoodle(String name, String surname, int salary) {
		Employee employee = new Employee(name, surname, salary);
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
	}
	
	
	 * 
	 * 
	private EntityManager entityManager;

	public EmployeeDAOImpl() {
		EntityManagerFactory entityManagerFactory = EntityManagerUtility.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Employee createEmployee(String name, String surname, int salary) {
		Employee employee = new Employee(name, surname, salary);
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		return employee;
	}

	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("Select e from Employee e", Employee.class);
		return query.getResultList();

	}

	@Override
	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(employee);
			entityManager.getTransaction().commit();
		}
	}
	 * 
	 * 
	 */
	
}
