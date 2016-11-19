package it.alfasoft.fabrizio.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="ff")
public class FiltroFattura {
	
	private Date inizio;
	private Date fine;
	
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
