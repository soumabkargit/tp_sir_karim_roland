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

import daoImpl.ReunionDaoImpl;
import entity.Reunion;

@Path("/reunion")
public class ReunionController {

	private ReunionDaoImpl serviceReunionDaoImpl = new ReunionDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Reunion> list() {
        return serviceReunionDaoImpl.findAllReunions();
    }
	
	
	@GET @Path("search/{idReunion}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Reunion findById(@PathParam("idReunion") String idReunion) {
        return serviceReunionDaoImpl.getReunionById(Integer.parseInt(idReunion));             
    }
	
	
	 @DELETE @Path("delete/{idReunion}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("idReunion") String idReunion) {
		 Reunion reunionCurrent = new Reunion();
		 if (serviceReunionDaoImpl.existReunion(Integer.parseInt(idReunion))) {
			
			 serviceReunionDaoImpl.beginTransaction();
			 reunionCurrent = serviceReunionDaoImpl.getReunionById(Integer.parseInt(idReunion));
	           serviceReunionDaoImpl.removeReunion(reunionCurrent);
	           serviceReunionDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createReunion(Reunion reunion) {
	  // create notification
		 serviceReunionDaoImpl.beginTransaction();
		 serviceReunionDaoImpl.addReunion(reunion);
		 serviceReunionDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{idReunion}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateReunion(@PathParam("idReunion") String idReunion, Reunion reunion) {
		 if (serviceReunionDaoImpl.existReunion(Integer.parseInt(idReunion))) {
			 serviceReunionDaoImpl.beginTransaction();
			 serviceReunionDaoImpl.updateReunion(reunion);
			 serviceReunionDaoImpl.commitTransaction();
		 }
		
	 }
	 
	
}
