package it.alfasoft.fabrizio.bean;

import it.alfasoft.fabrizio.utility.DataUtility;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.QueryParam;

@ManagedBean(name="ff")
public class FiltroFattura {
	
	private @QueryParam("inizio")Date inizio;
	private @QueryParam("fine")Date fine;
	private String start;
	private String end;
	
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
	
	public void setStart(Date data){
		this.setInizio(data);
		this.setStart(this.parseDate(data));		
	}
	
	public void setEnd(Date data){
		this.setFine(data);
		this.setEnd(this.parseDate(data));			
	}
	
	public String parseDate(Date data){
		return DataUtility.dateToString(data);
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
