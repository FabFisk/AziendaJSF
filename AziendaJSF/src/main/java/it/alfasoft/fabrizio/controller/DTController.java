package it.alfasoft.fabrizio.controller;
 
import it.alfasoft.fabrizio.bean.BustaPaga;
import it.alfasoft.fabrizio.bean.Cliente;
import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.bean.Utente;
import it.alfasoft.fabrizio.service.GestioneBustePaga;
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
	private GestioneBustePaga gB;
	private List<Cliente> clienti;
	private List<Dipendente> dipendenti;
	private List<BustaPaga> bustePaga;
	
	public DTController(){
		gU = new GestioneUtenti();
		gB = new GestioneBustePaga();
		this.clienti = gU.getListClienti();
		this.dipendenti = gU.getListDipendenti();
		this.bustePaga = gB.getListBuste();
	}

	public GestioneUtenti getGU() {
		return gU;
	}

	public void setGU(GestioneUtenti gU) {
		this.gU = gU;
	}
	
	public GestioneBustePaga getGB() {
		return gB;
	}

	public void setGB(GestioneBustePaga g) {
		this.gB = g;
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
	
	public List<BustaPaga> getBustePaga() {
		return bustePaga;
	}

	public void setBustePaga(List<BustaPaga> bustePaga) {
		this.bustePaga = bustePaga;
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
	
 	public void onRowEditUser(RowEditEvent event) {
 		this.updateUtente((Utente) event.getObject());
        FacesMessage msg = new FacesMessage("Modificato", ((Utente) event.getObject()).getNome()+" "+((Utente) event.getObject()).getCognome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancelUser(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modifica Annullata", ((Utente) event.getObject()).getNome()+" "+((Utente) event.getObject()).getCognome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
	public String updateBusta(BustaPaga b){
		gB.updateBusta(b);
		return "ElencoBuste?faces-redirect=true";	
	}
	
	public String deleteBusta(BustaPaga b){
		gB.deleteBusta(b);		
		return "ElencoBuste?faces-redirect=true";
	}
	
 	public void onRowEditBusta(RowEditEvent event) {
 		this.updateBusta((BustaPaga) event.getObject());
        FacesMessage msg = new FacesMessage("Modificato", ((BustaPaga) event.getObject()).getDipendente().getCognome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancelBusta(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modifica Annullata", ((BustaPaga)  event.getObject()).getDipendente().getCognome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


}