package dao;

import java.util.Collection;

import entity.PreferenceAlimentaire;


public interface PreferenceAlimentaireDao {
	
	public abstract PreferenceAlimentaire getPreferenceAlimentaireById(int idPreferenceAlimentaire);

	public abstract void addPreferenceAlimentaire(PreferenceAlimentaire preferenceAlimentaire);

	public abstract void removePreferenceAlimentaire(PreferenceAlimentaire preferenceAlimentaire);

	public abstract void updatePreferenceAlimentaire(PreferenceAlimentaire preferenceAlimentaire);
	
	public abstract Collection<PreferenceAlimentaire> findAllPreferenceAlimentaires();
	
	public abstract boolean existPreferenceAlimentaire(int idPreferenceAlimentaire) ;


}
