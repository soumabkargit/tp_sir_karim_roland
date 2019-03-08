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
import daoImpl.SondageLieuDaoImpl;
import entity.SondageLieu;

@Path("/sondageLieu")
public class SondageLieuController {
	
private SondageLieuDaoImpl serviceSondageLieuDaoImpl = new SondageLieuDaoImpl();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<SondageLieu> list() {
        return serviceSondageLieuDaoImpl.findAllSondageLieux();
    }
	
	
	@GET @Path("search/{idSondage}")
    @Produces({ MediaType.APPLICATION_JSON })
    public SondageLieu findById(@PathParam("idSondage") String idSondage) {
        return serviceSondageLieuDaoImpl.getSondageLieuById(Integer.parseInt(idSondage));             
    }
	
	
	 @DELETE @Path("delete/{idSondage}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("idSondage") String idSondage) {
		 SondageLieu sondageLieuCurrent = new SondageLieu();
		 if (serviceSondageLieuDaoImpl.existSondageLieu(Integer.parseInt(idSondage))) {
			
			 serviceSondageLieuDaoImpl.beginTransaction();
			 sondageLieuCurrent = serviceSondageLieuDaoImpl.getSondageLieuById(Integer.parseInt(idSondage));
			 serviceSondageLieuDaoImpl.removeSondageLieu(sondageLieuCurrent);
			 serviceSondageLieuDaoImpl.commitTransaction();
		}
		 
	    }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createSondageLieu(SondageLieu sondageLieu) {
	  // create notification
		 serviceSondageLieuDaoImpl.beginTransaction();
		 serviceSondageLieuDaoImpl.addSondageLieu(sondageLieu);
		 serviceSondageLieuDaoImpl.commitTransaction();
	 }
	 
	 @PUT
	 @Path("update/{idSondage}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void updateReunion(@PathParam("idSondage") String idSondageLieu, SondageLieu sondageLieu) {
		 if (serviceSondageLieuDaoImpl.existSondageLieu(Integer.parseInt(idSondageLieu))) {
			 serviceSondageLieuDaoImpl.beginTransaction();
			 serviceSondageLieuDaoImpl.updateSondageLieu(sondageLieu);
			 serviceSondageLieuDaoImpl.commitTransaction();
		 }
		
	 }

}
