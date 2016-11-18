package it.alfasoft.fabrizio.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="f")
public class Fattura {
	
	private Date emissione;
	private String codice;
	private double totale;
	
	public Fattura(){}

	public Date getEmissione() {
		return emissione;
	}

	public void setEmissione(Date emissione) {
		this.emissione = emissione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	

}
