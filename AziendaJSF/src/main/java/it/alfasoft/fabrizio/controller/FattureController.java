package it.alfasoft.fabrizio.controller;

import java.util.List;

import it.alfasoft.fabrizio.bean.Fattura;
import it.alfasoft.fabrizio.client.InvocazioneFattura;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@ManagedBean(name="FCon")
@ViewScoped
public class FattureController {
	
	private InvocazioneFattura invFatt;
	private Fattura f;
	private List<Fattura> listaFatture;
	
	public FattureController(){
		setInvFatt(new InvocazioneFattura());
	}

	public InvocazioneFattura getInvFatt() {
		return invFatt;
	}

	public void setInvFatt(InvocazioneFattura invFatt) {
		this.invFatt = invFatt;
	}

	public Fattura getF() {
		return f;
	}

	public void setF(Fattura f) {
		this.f = f;
	}

	public List<Fattura> getListaFatture() {
		return listaFatture;
	}

	public void setListaFatture(List<Fattura> listaFatture) {
		this.listaFatture = listaFatture;
	}
	
	public void addFattura(Fattura f){
		invFatt.addFattura(f).invoke();
	}
	
	public Fattura getFattura(String code){
		Response risp;
		risp = invFatt.getFatturaCode(code).invoke();
		this.setF(risp.readEntity(Fattura.class));
		return f;		
	}
	
	public List<Fattura> getAllFatture(){
		Response risp;		
		risp = invFatt.gettAllFatture().invoke();		
		this.setListaFatture(risp.readEntity(new GenericType<List<Fattura>>(){}));
		return listaFatture;
	}
	
	public List<Fattura> getFattureFiltrate(){
		
		return listaFatture;
	}

}
