package it.alfasoft.fabrizio.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.QueryParam;

@ManagedBean(name="ff")
public class FiltroFattura {
	
	private @QueryParam("inizio")Date inizio;
	private @QueryParam("fine")Date fine;
	
	public FiltroFattura(){}

	public Date getInizio() {
		return inizio;
	}

	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}

	public Date getFine() {
		return fine;
	}

	public void setFine(Date fine) {
		this.fine = fine;
	}

}
