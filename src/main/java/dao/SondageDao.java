package dao;

import java.util.Collection;

import entity.Sondage;

public interface SondageDao {
	
	public abstract Sondage getSondageId(int idSondage);

	public abstract void addSondage(Sondage sondage);

	public abstract void removeSondage(Sondage sondage);

	public abstract void updateSondage(Sondage sondage);
	
	public abstract Collection<Sondage> findAllSondages();

}
