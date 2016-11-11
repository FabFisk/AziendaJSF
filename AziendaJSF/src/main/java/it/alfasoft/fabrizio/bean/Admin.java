package it.alfasoft.fabrizio.bean;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_utente")
public class Admin extends Utente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private char livello;
	
	public Admin (){}
	public Admin (char livello){
		super();
		this.livello = livello;
	}
	public char getLivello() {
		return livello;
	}
	public void setLivello(char livello) {
		this.livello = livello;
	}

}
