package dao;

import java.util.Collection;

import entity.SondageDateLieu;


public interface SondageDateLieuDao {
	

	public abstract SondageDateLieu getSondageDateLieuById(int idSondage);

	public abstract void addSondageDateLieu(SondageDateLieu sondageDateLieu);

	public abstract void removeSondageDateLieu(SondageDateLieu sondageDateLieu);

	public abstract void updateSondageDateLieu(SondageDateLieu sondageDateLieu);
	
	public abstract Collection<SondageDateLieu> findAllSondageDateLieux();
	
	public abstract boolean existSondageDateLieu(int idSondage);
	
	

}
