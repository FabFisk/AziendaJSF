package it.alfasoft.fabrizio.client;

import it.alfasoft.fabrizio.bean.Fattura;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class InvocazioneFattura extends Invoczione {
	
	private WebTarget fatTarget = baseTarget.path("/fatture");
	
	public InvocazioneFattura(){}
	
	public Invocation addFattura(Fattura f){
		return fatTarget.request().buildPost(Entity.json(f));
	}
	
	public Invocation gettAllFatture(){
		return null;
	}
	
	public Invocation getFatturaCode(String code){
		return fatTarget.path(code).request().buildGet();
	}

}
