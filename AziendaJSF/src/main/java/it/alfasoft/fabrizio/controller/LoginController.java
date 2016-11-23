package it.alfasoft.fabrizio.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.alfasoft.fabrizio.service.GestioneUtenti;
import it.alfasoft.fabrizio.service.PSWCodifer;

@ManagedBean(name="lc")
@SessionScoped
public class LoginController {
	
	private GestioneUtenti gU;
	private String username;
	private String password;
	private boolean loggato = false;
	
	public LoginController(){
		gU = new GestioneUtenti();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggato() {
		return loggato;
	}

	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}
		
	public GestioneUtenti getgU() {
		return gU;
	}

	public void setgU(GestioneUtenti gU) {
		this.gU = gU;
	}

	public String login(){
		this.loggato = false;
		if(gU.readUser(this.username, PSWCodifer.codificaPsw(this.password))){
			this.loggato = true;
			return "portals/admin/Home?faces-redirect=true";	
		}
		return "Login?faces-redirect=true";	
	}

}
