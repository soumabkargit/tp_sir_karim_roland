package dao;

import java.util.Collection;

import entity.Participant;

public interface ParticipantDao {
	
	public abstract Participant getParticipantById(int idParticipant);

	public abstract void addParticipant(Participant participant);

	public abstract void removeParticipant(Participant participant);

	public abstract void updateParticipant(Participant participant);
	
	public abstract Collection<Participant> findAllParticipants();

}
