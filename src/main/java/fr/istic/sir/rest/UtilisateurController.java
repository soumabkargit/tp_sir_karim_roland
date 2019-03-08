package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daoImpl.UtilisateurDaoImpl;
import entity.Utilisateur;

@Path("/utilisateur")
public class UtilisateurController {
	

	private UtilisateurDaoImpl serviceUtilisateurDaoImpl = new UtilisateurDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Utilisateur> list() {
        return serviceUtilisateurDaoImpl.findAllUtilisateurs();
    }
	
	
	@GET @Path("search/{emailUtilisateur}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Utilisateur findById(@PathParam("emailUtilisateur") String emailUtilisateur) {
        return serviceUtilisateurDaoImpl.getUtilisateurById(emailUtilisateur) ;       
    }
	
	
	 @DELETE @Path("delete/{emailUtilisateur}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("emailUtilisateur") String emailUtilisateur) {
		 Utilisateur utilisateurCurrent = new Utilisateur();
		 if (serviceUtilisateurDaoImpl.existUtilisateur(emailUtilisateur)) {
			
			 serviceUtilisateurDaoImpl.beginTransaction();
			 utilisateurCurrent = serviceUtilisateurDaoImpl.getUtilisateurById(emailUtilisateur);
			 serviceUtilisateurDaoImpl.removeUtilisateur(utilisateurCurrent);
			 serviceUtilisateurDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createutilisateur(Utilisateur utilisateur) {
	  // create notification
		 serviceUtilisateurDaoImpl.beginTransaction();
		 serviceUtilisateurDaoImpl.addUtilisateur(utilisateur);
		 serviceUtilisateurDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{emailUtilisateur}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateReunion(@PathParam("emailUtilisateur") String emailUtilisateur, Utilisateur utilisateur) {
		 if (serviceUtilisateurDaoImpl.existUtilisateur(emailUtilisateur)) {
			 serviceUtilisateurDaoImpl.beginTransaction();
			 serviceUtilisateurDaoImpl.updateUtilisateur(utilisateur);
			 serviceUtilisateurDaoImpl.commitTransaction();
		 }
		
	 }
	 
	

}
