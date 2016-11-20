package it.alfasoft.fabrizio.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public abstract class Invoczione {
	
	protected Client cliente = ClientBuilder.newClient();
	protected WebTarget baseTarget = cliente.target("http://localhost:8085/AziendaWebService/alfasoft");

}
