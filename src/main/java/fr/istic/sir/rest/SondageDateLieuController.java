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
import daoImpl.SondageDateLieuDaoImpl;
import entity.SondageDateLieu;


@Path("/sondageDateLieu")
public class SondageDateLieuController {
	
	
private SondageDateLieuDaoImpl serviceSondageDateLieuDaoImpl = new SondageDateLieuDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<SondageDateLieu> list() {
        return serviceSondageDateLieuDaoImpl.findAllSondageDateLieux();
    }
	
	
	@GET @Path("search/{idSondage}")
    @Produces({ MediaType.APPLICATION_JSON })
    public SondageDateLieu findById(@PathParam("idSondage") String idSondage) {
        return serviceSondageDateLieuDaoImpl.getSondageDateLieuById(Integer.parseInt(idSondage));      
    }
	
	
	 @DELETE @Path("delete/{idSondage}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("idSondage") String idSondage) {
		 SondageDateLieu sondageDateLieuCurrent = new SondageDateLieu();
		 if (serviceSondageDateLieuDaoImpl.existSondageDateLieu(Integer.parseInt(idSondage))) {
			
			 serviceSondageDateLieuDaoImpl.beginTransaction();
			 sondageDateLieuCurrent = serviceSondageDateLieuDaoImpl.getSondageDateLieuById(Integer.parseInt(idSondage));
			 serviceSondageDateLieuDaoImpl.removeSondageDateLieu(sondageDateLieuCurrent);
			 serviceSondageDateLieuDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createSondageDateLieu(SondageDateLieu sondageDateLieu) {
	  // create notification
		 serviceSondageDateLieuDaoImpl.beginTransaction();
		 serviceSondageDateLieuDaoImpl.addSondageDateLieu(sondageDateLieu);
		 serviceSondageDateLieuDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{idSondage}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateSondageDateLieu(@PathParam("idSondage") String idSondage, SondageDateLieu sondageDateLieu) {
		 if (serviceSondageDateLieuDaoImpl.existSondageDateLieu(Integer.parseInt(idSondage))) {
			 serviceSondageDateLieuDaoImpl.beginTransaction();
			 serviceSondageDateLieuDaoImpl.updateSondageDateLieu(sondageDateLieu);
			 serviceSondageDateLieuDaoImpl.commitTransaction();
		 }
		
	 }


}
