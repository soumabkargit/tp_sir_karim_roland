package dao;

import java.util.Collection;

import entity.Utilisateur;


public interface UtilisateurDao {


	public abstract Utilisateur getUtilisateurById(String emailUtilisateur);

	public abstract void addUtilisateur(Utilisateur utilisateur);

	public abstract void removeUtilisateur(Utilisateur utilisateur);

	public abstract void updateUtilisateur(Utilisateur utilisateur);
	
	public abstract Collection<Utilisateur> findAllUtilisateurs();

	
}
