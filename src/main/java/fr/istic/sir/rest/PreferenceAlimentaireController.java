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
import daoImpl.PreferenceAlimentaireDaoImpl;
import entity.PreferenceAlimentaire;


@Path("/preferenceAlimentaire")
public class PreferenceAlimentaireController {
	

	private PreferenceAlimentaireDaoImpl servicePreferenceAlimentaireDaoImpl = new PreferenceAlimentaireDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<PreferenceAlimentaire> list() {
        return servicePreferenceAlimentaireDaoImpl.findAllPreferenceAlimentaires();
    }
	
	
	@GET @Path("search/{idReunion}")
    @Produces({ MediaType.APPLICATION_JSON })
    public PreferenceAlimentaire findById(@PathParam("idPreferenceAlimentaire") String idPreferenceAlimentaire) {
        return servicePreferenceAlimentaireDaoImpl.getPreferenceAlimentaireById(Integer.parseInt(idPreferenceAlimentaire));             
    }
	
	
	 @DELETE @Path("delete/{idPreferenceAlimentaire}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("idPreferenceAlimentaire") String idPreferenceAlimentaire) {
		 PreferenceAlimentaire preferenceAlimentaireCurrent = new PreferenceAlimentaire();
		 if (servicePreferenceAlimentaireDaoImpl.existPreferenceAlimentaire(Integer.parseInt(idPreferenceAlimentaire))) {
			
			 servicePreferenceAlimentaireDaoImpl.beginTransaction();
			 preferenceAlimentaireCurrent = servicePreferenceAlimentaireDaoImpl.getPreferenceAlimentaireById(Integer.parseInt(idPreferenceAlimentaire));
			 servicePreferenceAlimentaireDaoImpl.removePreferenceAlimentaire(preferenceAlimentaireCurrent);
			 servicePreferenceAlimentaireDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createReunion(PreferenceAlimentaire preferenceAlimentaire) {
	  // create notification
		 servicePreferenceAlimentaireDaoImpl.beginTransaction();
		 servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire);
		 servicePreferenceAlimentaireDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{idReunion}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateReunion(@PathParam("idReunion") String idPreferenceAlimentaire, PreferenceAlimentaire preferenceAlimentaire) {
		 if (servicePreferenceAlimentaireDaoImpl.existPreferenceAlimentaire(Integer.parseInt(idPreferenceAlimentaire))) {
			 servicePreferenceAlimentaireDaoImpl.beginTransaction();
			 servicePreferenceAlimentaireDaoImpl.updatePreferenceAlimentaire(preferenceAlimentaire);
			 servicePreferenceAlimentaireDaoImpl.commitTransaction();
		 }
		
	 }


}
