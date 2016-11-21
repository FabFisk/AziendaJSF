package it.alfasoft.fabrizio.bean;

import it.alfasoft.fabrizio.utility.DataUtility;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.QueryParam;

@ManagedBean(name="ff")
public class FiltroFattura {
	
	private @QueryParam("inizio")Date inizio;
	private @QueryParam("fine")Date fine;
	private String query;
	
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
