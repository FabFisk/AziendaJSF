package it.alfasoft.fabrizio.controller;
 
import it.alfasoft.fabrizio.bean.Cliente;
import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.bean.Utente;
import it.alfasoft.fabrizio.service.GestioneUtenti;
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
	
	private GestioneUtenti gU;
	private List<Cliente> clienti;
	private List<Dipendente> dipendenti;
	
	public DTController(){
		gU = new GestioneUtenti();
		this.clienti = gU.getListClienti();
		this.dipendenti = gU.getListDipendenti();
	}

	public GestioneUtenti getG() {
		return gU;
	}

	public void setG(GestioneUtenti g) {
		this.gU = g;
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
			gU.updateCliente((Cliente) u);
			return "ElencoClienti?faces-redirect=true";	
		}else if(u.getRuolo()==Ruolo.DIPENDENTE){
			gU.updateDipendente((Dipendente) u);
			return "ElencoDipendenti?faces-redirect=true";	
		}
		return null;
	}
	
	public String deleteUtente(Utente u){
		if(u.getRuolo()==Ruolo.CLIENTE){
			gU.deleteCliente((Cliente) u);
			return "ElencoClienti?faces-redirect=true";	
		}else if(u.getRuolo()==Ruolo.DIPENDENTE){
			gU.deleteDipendente((Dipendente) u);
			return "ElencoDipendenti?faces-redirect=true";	
		}
		return null;
	}
	
 	public void onRowEdit(RowEditEvent event) {
 		this.updateUtente((Utente) event.getObject());
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modifica Annullata", ((Utente) event.getObject()).getNome()+" "+((Utente) event.getObject()).getCognome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}