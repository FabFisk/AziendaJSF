package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.LoginBean;
import it.alfasoft.fabrizio.service.GestioneUtenti;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

	public String login(LoginBean lb){
		String risp = "Login?faces-redirect=true";
		if(gU.readUser(lb.getUsername(), lb.getPassword())){
			this.username = lb.getUsername();
			this.password = lb.getPassword();
			this.loggato = true;
			risp = "Home?faces-redirect=true";	
		}
		return risp;	
	}

}
