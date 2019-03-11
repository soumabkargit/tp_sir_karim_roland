package daoImpl;

import java.util.Collection;

import javax.persistence.EntityManager;

import dao.UtilisateurDao;
import entity.Utilisateur;
import jpa.EntityManagerHelper;

public class UtilisateurDaoImpl implements UtilisateurDao {

private EntityManager entityManager;
	
	public UtilisateurDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public Utilisateur getUtilisateurById(String emailUtilisateur) {
		Utilisateur Utilisateur = entityManager.find(Utilisateur.class, emailUtilisateur);
		return Utilisateur;
	}

	public void addUtilisateur(Utilisateur utilisateur) {
		entityManager.persist(utilisateur);
	}

	
	public void removeUtilisateur(Utilisateur utilisateur) {
		entityManager.remove(utilisateur);
	}

	
	public void updateUtilisateur(Utilisateur utilisateur) {
		entityManager.merge(utilisateur);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}


	public  Collection<Utilisateur> findAllUtilisateurs(){
		return (Collection<Utilisateur>)  entityManager.createNamedQuery("findAllUtilisateurs", Utilisateur.class).getResultList();
		
	}

	public boolean existUtilisateur( String emailUtilisateur ) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, emailUtilisateur);
		boolean test;
		if (utilisateur == null) {
			test = false;
		}else {
			test = true;
		}
		return test;
	}
	
}
