package daoImpl;

import java.util.Collection;
import javax.persistence.EntityManager;

import dao.PreferenceAlimentaireDao;
import entity.PreferenceAlimentaire;
import jpa.EntityManagerHelper;

public class PreferenceAlimentaireDaoImpl implements PreferenceAlimentaireDao {
	
private EntityManager entityManager;
	
	public PreferenceAlimentaireDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public PreferenceAlimentaire getPreferenceAlimentaireById(int idPreferenceAlimentaire) {
		PreferenceAlimentaire preferenceAlimentaire = entityManager.find(PreferenceAlimentaire.class, idPreferenceAlimentaire);
		return preferenceAlimentaire;
	}

	public void addPreferenceAlimentaire(PreferenceAlimentaire preferenceAlimentaire) {
		entityManager.persist(preferenceAlimentaire);
	}

	
	public void removePreferenceAlimentaire(PreferenceAlimentaire preferenceAlimentaire) {
		entityManager.remove(preferenceAlimentaire);
	}

	
	public void updatePreferenceAlimentaire(PreferenceAlimentaire preferenceAlimentaire) {
		entityManager.merge(preferenceAlimentaire);
	}
	

	public  Collection<PreferenceAlimentaire> findAllPreferenceAlimentaires(){
		return (Collection<PreferenceAlimentaire>)  entityManager.createNamedQuery("findAllPreferenceAlimentaires", PreferenceAlimentaire.class).getResultList();
		
	}

	
	public boolean existPreferenceAlimentaire(int idPreferenceAlimentaire) {
		PreferenceAlimentaire preferenceAlimentaire = entityManager.find(PreferenceAlimentaire.class, idPreferenceAlimentaire);
		boolean test;
		if (preferenceAlimentaire == null) {
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
