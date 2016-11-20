package it.alfasoft.fabrizio.server;

import java.util.ArrayList;
import java.util.List;

import it.alfasoft.fabrizio.bean.BustaPaga;
import it.alfasoft.fabrizio.service.GestioneUtenti;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("bustepaga")
public class RisorseBustePaga {
	
	GestioneUtenti gU = new GestioneUtenti();
	
	@Path("/lista")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BustaPaga> getAllBuste() {
		return new ArrayList<BustaPaga>(gU.getListBuste());
	}	
}
