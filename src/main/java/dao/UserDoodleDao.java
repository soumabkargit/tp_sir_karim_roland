package dao;

import java.util.Collection;

import entity.UserDoodle;

public interface UserDoodleDao {
	

	public abstract UserDoodle getUserDoodleById(String emailUtilisateur);

	public abstract void addUserDoodle(UserDoodle userDoodle);

	public abstract void removeUserDoodle(UserDoodle userDoodle);

	public abstract void updateUserDoodle(UserDoodle userDoodle);
	
	public abstract Collection<UserDoodle> findAllUserDoodles();

}
