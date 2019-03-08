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
import daoImpl.ParticipantDaoImpl;
import entity.Participant;

@Path("/participant")
public class ParticipantController {
	

	private ParticipantDaoImpl serviceParticipantDaoImpl = new ParticipantDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Participant> list() {
        return serviceParticipantDaoImpl.findAllParticipants();
    }
	
	
	@GET @Path("search/{emailUtilisateur}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Participant findById(@PathParam("emailUtilisateur") String emailUtilisateur) {
        return serviceParticipantDaoImpl.getParticipantById(emailUtilisateur) ;       
    }
	
	
	 @DELETE @Path("delete/{emailUtilisateur}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("emailUtilisateur") String emailUtilisateur) {
		 Participant participantCurrent = new Participant();
		 if (serviceParticipantDaoImpl.existParticipant(emailUtilisateur)) {
			
			 serviceParticipantDaoImpl.beginTransaction();
			 participantCurrent = serviceParticipantDaoImpl.getParticipantById(emailUtilisateur);
			 serviceParticipantDaoImpl.removeParticipant(participantCurrent);
			 serviceParticipantDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createParticipant(Participant participant) {
	  // create notification
		 serviceParticipantDaoImpl.beginTransaction();
		 serviceParticipantDaoImpl.addParticipant(participant);
		 serviceParticipantDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{emailUtilisateur}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateReunion(@PathParam("emailUtilisateur") String emailUtilisateur, Participant participant) {
		 if (serviceParticipantDaoImpl.existParticipant(emailUtilisateur)) {
			 serviceParticipantDaoImpl.beginTransaction();
			 serviceParticipantDaoImpl.updateParticipant(participant);
			 serviceParticipantDaoImpl.commitTransaction();
		 }
		
	 }
	 
	

}
