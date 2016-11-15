package it.alfasoft.fabrizio.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@ManagedBean(name="b")
@Entity
public class BustaPaga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_busta;
	private Date dataEmissione;
	@ManyToOne(fetch = FetchType.EAGER)
	private Dipendente dipendente;
	private double totale;
	
	public BustaPaga() {
	}
	
	public BustaPaga(Date emissione, Dipendente d, double tot){
		this.dataEmissione = emissione;
		this.dipendente = d;
		this.totale = tot;
	}

	public long getId_busta() {
		return id_busta;
	}

	public void setId_busta(long id_busta) {
		this.id_busta = id_busta;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
