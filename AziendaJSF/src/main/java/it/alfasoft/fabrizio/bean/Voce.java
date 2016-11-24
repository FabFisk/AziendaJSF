package it.alfasoft.fabrizio.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@ManagedBean(name="v")
public class Voce implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_voce;
	private String nome;
	private String cognome;
	private String tel;
	@ManyToOne
	private Rubrica rubrica;

	public Voce() {
		this.nome = "";
		this.cognome = "";
		this.tel = "";
	}
	public Voce(String nome, String cognome, String tel) {
		this.nome = nome;
		this.cognome = cognome;
		this.tel = tel;
	}

	public long getId_voce() {
		return id_voce;
	}
	public void setId_voce(long id_voce) {
		this.id_voce = id_voce;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Rubrica getRubrica() {
		return rubrica;
	}
	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

}
