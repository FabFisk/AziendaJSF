package it.alfasoft.fabrizio.service;

import java.io.Serializable;

public class Messaggio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messaggio;
	
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	
	public void notValid(){
		this.messaggio ="Tutti i campi devono essere compilati!";
	}
	
	public void notRegister(){
		this.messaggio ="Username e/o Password non validi!";
	}
	
	public void notAvailable(){
		this.messaggio ="Questo username non è disponibile!";
	}
	
	public void alreadyE(){
		this.messaggio ="Questa persona ha già un account!";
	}
	
	public void alreadyR(){
		this.messaggio ="Questa persona è già in rubrica!";
	}
	
	public void successfull(){
		this.messaggio = "Registrato con successo!";
	}
	
	public void doLogout(){
		this.messaggio = "Sei stato disconnesso con successo!";
	}
}
