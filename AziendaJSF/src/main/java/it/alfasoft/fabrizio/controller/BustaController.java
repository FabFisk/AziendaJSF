package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.BustaPaga;
import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.service.GestioneBustePaga;
import it.alfasoft.fabrizio.service.GestioneUtenti;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean(name="bControl")
@ViewScoped
public class BustaController implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GestioneBustePaga gB;
	private GestioneUtenti gU;
	private long scelta;
	private Map<String, Long> dipendenti;
	
	public BustaController(){
		gB = new GestioneBustePaga();
		gU = new GestioneUtenti();
		dipendenti = new HashMap<String, Long>();
		for(Dipendente d : gU.getListDipendenti()){
			dipendenti.put(d.getCognome()+" "+d.getNome(), d.getId_utente());
		}
	}

	public GestioneUtenti getgU() {
		return gU;
	}

	public void setgU(GestioneUtenti gU) {
		this.gU = gU;
	}
	
	public GestioneBustePaga getgB() {
		return gB;
	}

	public void setgB(GestioneBustePaga gB) {
		this.gB = gB;
	}

	public Map<String, Long> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(Map<String, Long> dipendenti) {
		this.dipendenti = dipendenti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getScelta() {
		return scelta;
	}

	public void setScelta(long scelta) {
		this.scelta = scelta;
	}
	
	public String createBusta(BustaPaga b){
		b.setDipendente(gU.readDipendente(scelta));
		gB.creteBusta(b);
		return "RegistraBusta?faces-redirect=true";
	}	
	
}