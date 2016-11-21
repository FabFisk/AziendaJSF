package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.Fattura;
import it.alfasoft.fabrizio.bean.FiltroFattura;
import it.alfasoft.fabrizio.client.InvocazioneFattura;
import it.alfasoft.fabrizio.utility.DataUtility;

import java.util.ArrayList;
import java.util.List;

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
		listaFatture = new ArrayList<Fattura>();
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
	
	public String addFattura(Fattura f){
		String risp = null;
		Response status = invFatt.addFattura(f).invoke();
		if(status.getStatus()==201){
			risp = "RegistraFattura?faces-redirect=true";
		}
		return risp;
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
	
	public List<Fattura> getFattureFiltrate(FiltroFattura ff){
		Response risp;
		String inizio = DataUtility.dateToString(ff.getInizio());
		String fine = DataUtility.dateToString(ff.getFine());
		ff.setStart(inizio);
		ff.setEnd(fine);
		risp = invFatt.getFattureFiltrate(inizio, fine).invoke();
		this.setListaFatture(risp.readEntity(new GenericType<List<Fattura>>(){}));
		return listaFatture;
	}

}
