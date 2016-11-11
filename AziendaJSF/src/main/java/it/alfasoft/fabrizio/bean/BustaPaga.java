package it.alfasoft.fabrizio.bean;

import java.io.Serializable;

import javax.persistence.*;

import it.alfasoft.fabrizio.utility.Validate;

@Entity
public class BustaPaga implements Serializable, Validate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_busta;
	private String mese;
	private int anno;
	@ManyToOne(fetch = FetchType.EAGER)
	private Dipendente dipendente;
	private double totale;
	
	public BustaPaga() {
		this.mese = "";
		this.anno = 0;
		this.totale = 0.0;
	}
	
	public BustaPaga(String mese, int anno, Dipendente d, double tot){
		this.mese = mese;
		this.anno = anno;
		this.dipendente = d;
		this.totale = tot;
	}

	public long getId_busta() {
		return id_busta;
	}

	public void setId_busta(long id_busta) {
		this.id_busta = id_busta;
	}

	public String getMese() {
		return mese;
	}

	public void setMese(String mese) {
		this.mese = mese;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
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

	public boolean isValid() {
		boolean token = false;
		if(!this.mese.isEmpty() && this.anno!=0
				&& this.totale!=0){
			token = true;
		}
		return token;
	}
	
	
	
	

}
