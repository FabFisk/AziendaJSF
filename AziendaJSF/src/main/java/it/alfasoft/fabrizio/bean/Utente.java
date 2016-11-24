package it.alfasoft.fabrizio.bean;

import it.alfasoft.fabrizio.utility.Ruolo;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@ManagedBean(name="u")
public class Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id_utente;
	protected String nome = "";
	protected String cognome = "";
	protected String username = "";
	protected String password = "";
	protected Ruolo ruolo;
	protected boolean loggato = false;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	protected Rubrica rubrica;
	
	public Utente (){
	}
	public Utente(String nome, String cognome, String username, String password, Ruolo ruolo) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password =  password;
		this.ruolo = ruolo;
	}
	public long getId_utente() {
		return id_utente;
	}
	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isLoggato() {
		return loggato;
	}
	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}	
}
