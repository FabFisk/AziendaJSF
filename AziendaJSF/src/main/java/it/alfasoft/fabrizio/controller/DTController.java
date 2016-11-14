package it.alfasoft.fabrizio.controller;
 
import it.alfasoft.fabrizio.bean.Cliente;
import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.bean.Utente;
import it.alfasoft.fabrizio.service.Gestione;
import it.alfasoft.fabrizio.utility.Ruolo;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
 
@ManagedBean(name="DTC")
@ViewScoped
public class DTController implements Serializable {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestione g;
	private List<Cliente> clienti;
	private List<Dipendente> dipendenti;
	
	public DTController(){
		g = new Gestione();
		this.clienti = g.getListClienti();
		this.dipendenti = g.getListDipendenti();
		System.out.println(dipendenti.get(0).getCognome());
		System.out.println(clienti.get(0).getCognome());
	}

	public Gestione getG() {
		return g;
	}

	public void setG(Gestione g) {
		this.g = g;
	}

	public List<Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String updateUtente(Utente u){
		if(u.getRuolo()==Ruolo.CLIENTE){
			g.updateCliente((Cliente) u);		
		}else if(u.getRuolo()==Ruolo.DIPENDENTE){
			g.updateDipendente((Dipendente) u);
		}
		return "table?faces-redirect=true";	
	}
	
	public String deleteUtente(Utente u){
		g.eliminaUtenteById(u.getId_utente());		
		return "table?faces-redirect=true";	
	}
	
 	public void onRowEdit(RowEditEvent event) {
 		this.updateUtente((Utente) event.getObject());
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modifica Annullata", ((Utente) event.getObject()).getNome()+" "+((Utente) event.getObject()).getCognome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}