package dao;

import java.util.Collection;

import entity.Reunion;

public interface ReunionDao {
	
	public abstract Reunion getReunionId(int idReunion);

	public abstract void addReunion(Reunion reunion);

	public abstract void removeReunion(Reunion reunion);

	public abstract void updateReunion(Reunion reunion);
	
	public abstract Collection<Reunion> findAllReunions();

}
