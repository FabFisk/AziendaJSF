package it.alfasoft.fabrizio.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@PrimaryKeyJoinColumn(name="id_utente")
@ManagedBean(name="d")
@RequestScoped
public class Dipendente extends Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double stipendio;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dipendente", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<BustaPaga> buste = new HashSet<BustaPaga>();
	
	public Dipendente(){
		super();
	}
	public Dipendente(double stipendio){
		super();
		this.stipendio = stipendio;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
}
