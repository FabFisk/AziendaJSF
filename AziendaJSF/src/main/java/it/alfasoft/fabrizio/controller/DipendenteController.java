package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.service.GestioneUtenti;
import it.alfasoft.fabrizio.service.PSWCodifer;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dControl")
@ViewScoped
public class DipendenteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GestioneUtenti gU;
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	
	public DipendenteController(){
		gU = new GestioneUtenti();
	}
	
	public GestioneUtenti getgU() {
		return gU;
	}

	public void setgU(GestioneUtenti gU) {
		this.gU = gU;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	public String create(Dipendente d){
		if(gU.createDipendente(d)){
			return "RegistraDipendente?faces-redirect=true";
		}
		return null;		
	}
	
	public String updateProfile(Dipendente d){
		long id = d.getId_utente();
		if(this.oldPassword.equals(PSWCodifer.codificaPsw(gU.readDipendente(id).getPassword()))
				&& this.newPassword.equals(repeatPassword)){
			d.setPassword(PSWCodifer.codificaPsw(newPassword));
			gU.updateDipendente(d);
			return "AggiornaProfilo?faces-redirect=true";			
		}		
		return null;	
	}

}
