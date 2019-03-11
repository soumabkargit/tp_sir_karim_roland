package dao;

import java.util.Collection;

import entity.Allergie;

public interface AllergieDao {
	
	public abstract Allergie getAllergieById(int idAllergie);

	public abstract void addAllergie(Allergie allergie);

	public abstract void removeAllergie(Allergie allergie);

	public abstract void updateAllergie(Allergie allergie);
	
	public abstract  Collection<Allergie> findAllAllergies();
	
	public abstract boolean existAllergie( int idAllergie );

}
