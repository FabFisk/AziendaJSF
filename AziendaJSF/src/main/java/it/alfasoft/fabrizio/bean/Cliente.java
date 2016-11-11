package it.alfasoft.fabrizio.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_utente")
@ManagedBean(name="c")
public class Cliente extends Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ragSociale;
	
	public Cliente(){
		super();
	}
	public Cliente(String ragSociale){
		super();
		this.ragSociale = ragSociale;
	}
	public String getRagSociale() {
		return ragSociale;
	}	
	public void setRagSociale(String ragSociale){
		this.ragSociale = ragSociale;
	}
	
}
