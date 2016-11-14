package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.Admin;
import it.alfasoft.fabrizio.service.GestioneUtenti;
import it.alfasoft.fabrizio.service.PSWCodifer;

import java.io.Serializable;

public class AdminController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GestioneUtenti gU;
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	
	public AdminController(){
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
			
	public String updateProfile(Admin a){
		long id = a.getId_utente();
		if(this.oldPassword.equals(PSWCodifer.codificaPsw(gU.readAdmin(id).getPassword()))
				&& this.newPassword.equals(repeatPassword)){
			a.setPassword(PSWCodifer.codificaPsw(newPassword));
			gU.updateAdmin(a);
			return "AggiornaProfilo?faces-redirect=true";			
		}		
		return null;	
	}
}
