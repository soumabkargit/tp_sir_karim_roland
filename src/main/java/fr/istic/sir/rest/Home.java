package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/home")
public class Home {
	
	private String name;
	private List<Heater> heaters = new ArrayList<Heater>();
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public void addDevice(Heater h) {
		heaters.add(h);
	}


	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Home getHome() {
		Home h = new Home();
		h.setName("toto");
		Heater h1 = new Heater();
		h1.setPower("500w");
		Heater h2 = new Heater();
		h2.setPower("600w");
		h.addDevice(h1);
		h.addDevice(h2);
		return h;
	}


}
