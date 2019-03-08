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
import daoImpl.SondageDateDaoImpl;
import entity.SondageDate;


@Path("/sondageDate")
public class SondageDateController {
	
private SondageDateDaoImpl serviceSondageDateDaoImpl = new SondageDateDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<SondageDate> list() {
        return serviceSondageDateDaoImpl.findAllSondageDates();
    }
	
	
	@GET @Path("search/{idSondage}")
    @Produces({ MediaType.APPLICATION_JSON })
    public SondageDate findById(@PathParam("idSondage") String idSondage) {
        return serviceSondageDateDaoImpl.getSondageDateById(Integer.parseInt(idSondage));      
    }
	
	
	 @DELETE @Path("delete/{idSondage}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("idSondage") String idSondage) {
		 SondageDate sondageDateCurrent = new SondageDate();
		 if (serviceSondageDateDaoImpl.existSondageDate(Integer.parseInt(idSondage))) {
			
			 serviceSondageDateDaoImpl.beginTransaction();
			 sondageDateCurrent = serviceSondageDateDaoImpl.getSondageDateById(Integer.parseInt(idSondage));
			 serviceSondageDateDaoImpl.removeSondageDate(sondageDateCurrent);
			 serviceSondageDateDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createSondageDate(SondageDate sondageDate) {
	  // create notification
		 serviceSondageDateDaoImpl.beginTransaction();
		 serviceSondageDateDaoImpl.addSondageDate(sondageDate);
		 serviceSondageDateDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{idSondage}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateSondageDateLieu(@PathParam("idSondage") String idSondage, SondageDate sondageDate) {
		 if (serviceSondageDateDaoImpl.existSondageDate(Integer.parseInt(idSondage))) {
			 serviceSondageDateDaoImpl.beginTransaction();
			 serviceSondageDateDaoImpl.updateSondageDate(sondageDate);
			 serviceSondageDateDaoImpl.commitTransaction();
		 }
		
	 }



}
