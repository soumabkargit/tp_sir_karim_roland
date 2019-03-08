package dao;

import java.util.Collection;

import entity.PreferenceAlimentaire;


public interface PreferenceAlimentaireDao {
	
	public abstract PreferenceAlimentaire getPreferenceAlimentaireDaoId(int idPreferenceAlimentaire);

	public abstract void addPreferenceAlimentaireDao(PreferenceAlimentaire preferenceAlimentaire);

	public abstract void removePreferenceAlimentaireDao(PreferenceAlimentaire preferenceAlimentaire);

	public abstract void updatePreferenceAlimentaireDao(PreferenceAlimentaire preferenceAlimentaire);
	
	public abstract Collection<PreferenceAlimentaire> findAllPreferenceAlimentaires();


}
