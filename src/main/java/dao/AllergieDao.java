package dao;

import entity.Allergie;

public interface AllergieDao {
	
	public abstract Allergie getAllergieById(int idAllergie);

	public abstract void addAllergie(Allergie allergie);

	public abstract void removeAllergie(Allergie allergie);

	public abstract void updateAllergie(Allergie allergie);

}
