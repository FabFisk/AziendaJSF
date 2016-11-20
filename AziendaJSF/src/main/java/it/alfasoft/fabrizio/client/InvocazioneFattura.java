package it.alfasoft.fabrizio.client;

import it.alfasoft.fabrizio.bean.Fattura;
import it.alfasoft.fabrizio.bean.FiltroFattura;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class InvocazioneFattura extends Invoczione {
	
	private WebTarget fatTarget = baseTarget.path("/fattura");
	
	public InvocazioneFattura(){}
	
	public Invocation addFattura(Fattura f){
		return fatTarget.request().buildPost(Entity.json(f));
	}
	
	public Invocation gettAllFatture(){
		return fatTarget.path("/lista").request().buildGet();
	}
	
	public Invocation getFatturaCode(String code){
		return fatTarget.path(code).request().buildGet();
	}
	
	public Invocation getFattureFiltrate(FiltroFattura ff){
//		System.out.println(ff.getInizio()+" "+ff.getFine());
		return fatTarget.queryParam("/fatturaProva", ff).request().buildGet();
	}
	
	public Invocation deleteFattura(String code){
		return fatTarget.path(code).request().buildDelete();
	}
	
	public Invocation updateFattura(Fattura f){
		return fatTarget.request().buildPut(Entity.json(f));
	}

}
