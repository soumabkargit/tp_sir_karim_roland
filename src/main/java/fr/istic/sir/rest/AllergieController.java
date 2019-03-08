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

import daoImpl.AllergieDaoImpl;
import daoImpl.ParticipantDaoImpl;
import entity.Allergie;
import entity.Participant;

@Path("/allergie")
public class AllergieController {
	


	private AllergieDaoImpl serviceAllergieDaoImpl = new AllergieDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Allergie> list() {
        return serviceAllergieDaoImpl.findAllAllergies();
    }
	
	
	@GET @Path("search/{idAllergie}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Allergie findById(@PathParam("idAllergie") String idAllergie) {
        return serviceAllergieDaoImpl.getAllergieById(Integer.parseInt(idAllergie) );       
    }
	
	
	 @DELETE @Path("delete/{idAllergie}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("idAllergie") String idAllergie) {
		 Allergie AllergieCurrent = new Allergie();
		 if (serviceAllergieDaoImpl.existAllergie(Integer.parseInt(idAllergie))) {
			
			 serviceAllergieDaoImpl.beginTransaction();
			 AllergieCurrent = serviceAllergieDaoImpl.getAllergieById(Integer.parseInt(idAllergie));
			 serviceAllergieDaoImpl.removeAllergie(AllergieCurrent);
			 serviceAllergieDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createParticipant(Allergie allergie) {
	  // create notification
		 serviceAllergieDaoImpl.beginTransaction();
		 serviceAllergieDaoImpl.addAllergie(allergie);
		 serviceAllergieDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{idAllergie}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateAllergie(@PathParam("idAllergie") String idAllergie, Allergie allergie) {
		 if (serviceAllergieDaoImpl.existAllergie(Integer.parseInt(idAllergie))) {
			 serviceAllergieDaoImpl.beginTransaction();
			 serviceAllergieDaoImpl.updateAllergie(allergie);
			 serviceAllergieDaoImpl.commitTransaction();
		 }
		
	 }
	 


}
