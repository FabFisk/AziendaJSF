package it.alfasoft.fabrizio.server;

import it.alfasoft.fabrizio.bean.BustaPaga;
import it.alfasoft.fabrizio.service.GestioneBustePaga;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("bustepaga")
public class RisorseBustePaga {
	
	GestioneBustePaga gB = new GestioneBustePaga();
	
	@Path("/lista")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BustaPaga> getAllBuste() {
		return new ArrayList<BustaPaga>(gB.getListBuste());
	}	
}
