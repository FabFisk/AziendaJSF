package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.Cliente;
import it.alfasoft.fabrizio.service.GestioneUtenti;
import it.alfasoft.fabrizio.utility.PSWCodifer;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="cControl")
@ViewScoped
public class ClienteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GestioneUtenti gU;
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	
	
	public ClienteController(){
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

	public String create(Cliente c){
		if(gU.createCliente(c)){
			return "RegistraCliente?faces-redirect=true";
		}
		return null;		
	}
	
	public String updateProfile(Cliente c){
		long id = c.getId_utente();
		if(this.oldPassword.equals(PSWCodifer.codificaPsw(gU.readCliente(id).getPassword()))
				&& this.newPassword.equals(repeatPassword)){
			c.setPassword(PSWCodifer.codificaPsw(newPassword));
			gU.updateCliente(c);
			return "AggiornaProfilo?faces-redirect=true";			
		}		
		return null;
	}

}
