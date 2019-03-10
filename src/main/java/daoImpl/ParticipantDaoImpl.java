package daoImpl;

import java.util.Collection;
import javax.persistence.EntityManager;
import entity.Participant;
import jpa.EntityManagerHelper;

public class ParticipantDaoImpl {

private EntityManager entityManager;
	
	public ParticipantDaoImpl() {
		entityManager = EntityManagerHelper.getEntityManager();
	}

	public Participant getParticipantById(String emailUtilisateur) {
		Participant participant = entityManager.find(Participant.class, emailUtilisateur);
		return participant;
	}

	public void addParticipant(Participant participant) {
		entityManager.persist(participant);
	}

	
	public void removeParticipant(Participant participant) {
		entityManager.remove(participant);
	}

	
	public void updateParticipant(Participant participant) {
		entityManager.merge(participant);
	}

	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}


	public  Collection<Participant> findAllParticipants(){
		return (Collection<Participant>)  entityManager.createNamedQuery("findAllParticipants", Participant.class).getResultList();
		
	}

	public boolean existParticipant( String emailUtilisateur ) {
		Participant participant = entityManager.find(Participant.class, emailUtilisateur);
		boolean test;
		if (participant == null) {
			test = false;
		}else {
			test = true;
		}
		return test;
	}
	
}
