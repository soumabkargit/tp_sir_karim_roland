package dao;

import java.util.Collection;

import entity.SondageLieu;

public interface SondageLieuDao {
	


	public abstract SondageLieu getSondageLieuById(int idSondage);

	public abstract void addSondageLieu(SondageLieu sondageLieu);

	public abstract void removeSondageLieu(SondageLieu sondageLieu);

	public abstract void updateSondageLieu(SondageLieu sondageLieu);
	
	public abstract Collection<SondageLieu> findAllSondageLieux();
	
	public abstract boolean existSondageLieu(int idSondage);
	
	

}
