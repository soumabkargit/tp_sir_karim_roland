package dao;

import java.util.Collection;
import entity.SondageDate;

public interface SondageDateDao {


	public abstract SondageDate getSondageDateById(int idSondage);

	public abstract void addSondageDate(SondageDate sondageDate);

	public abstract void removeSondageDate(SondageDate sondageDate);

	public abstract void updateSondageDate(SondageDate sondageDate);
	
	public abstract Collection<SondageDate> findAllSondageDates();
	
	public abstract boolean existSondageDate(int idSondage);
	
	
	
}
