package dao;

import java.util.Collection;

import entity.Reunion;

public interface ReunionDao {
	
	public abstract Reunion getReunionById(int idReunion);

	public abstract void addReunion(Reunion reunion);

	public abstract void removeReunion(Reunion reunion);

	public abstract void updateReunion(Reunion reunion);
	
	public abstract Collection<Reunion> findAllReunions();
	
	public abstract boolean existReunion(int idReunion);

}
