package it.alfasoft.fabrizio.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.alfasoft.fabrizio.bean.Rubrica;
import it.alfasoft.fabrizio.bean.Utente;
import it.alfasoft.fabrizio.service.GestioneUtenti;
import it.alfasoft.fabrizio.utility.PSWCodifer;
import it.alfasoft.fabrizio.utility.Ruolo;

@ManagedBean(name="lc")
@SessionScoped
public class LoginController {
	
	private GestioneUtenti gU;
	private long id_utente;
	private String username;
	private String password;
	private boolean loggato;
	private Ruolo ruolo;
	private Rubrica rubrica;
	
	public LoginController(){
		loggato = false;
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
	
	public long getId_utente() {
		return id_utente;
	}

	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}
	
	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public String login(){
		Utente u = gU.readUser(this.username, PSWCodifer.codificaPsw(this.password));
		if(u!=null){
			this.id_utente = u.getId_utente();
			this.ruolo = u.getRuolo();
			this.loggato = true;			
			switch (u.getRuolo()) {
			case ADMIN:
				return "portals/admin/Home?faces-redirect=true";	
			case CLIENTE:
				this.rubrica = u.getRubrica();
				return "portals/cliente/Home?faces-redirect=true";
			case DIPENDENTE:
				this.rubrica = u.getRubrica();
				return "portals/dipendente/Home?faces-redirect=true";
			default:
				return "Login?faces-redirect=true";	
			}
		}
		return "Login?faces-redirect=true";	
	}
	
	public String logout(){
		this.id_utente = 0;
		this.password = "";
		this.username = "";
		this.loggato = false;
		return "Login?faces-redirect=true";	
	}
}
