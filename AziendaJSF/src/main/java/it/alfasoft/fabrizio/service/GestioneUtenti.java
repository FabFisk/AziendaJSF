package it.alfasoft.fabrizio.service;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.fabrizio.bean.*;
import it.alfasoft.fabrizio.dao.*;
import it.alfasoft.fabrizio.rubrica.*;
import it.alfasoft.fabrizio.utility.Ruolo;

public class GestioneUtenti implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UtenteDAO uDAO = new UtenteDAO();
	AdminDAO aDAO = new AdminDAO();
	ClienteDAO cDAO = new ClienteDAO();
	DipendenteDAO dDAO = new DipendenteDAO();
	RubricaDao rDAO = new RubricaDao();
	VoceDao vDAO = new VoceDao();	
	BustaDAO bDAO = new BustaDAO();
	ServizioRubrica s = new ServizioRubrica();
	
	public boolean createCliente(Cliente c) {
		String psw = c.getPassword();
		c.setPassword(PSWCodifer.codificaPsw(psw));
		c.setRuolo(Ruolo.CLIENTE);
		cDAO.createUser(c);
		Rubrica r = s.registraRubrica(c.getNome(), c.getCognome());
		c.setRubrica(r);
		return cDAO.updateUser(c);
	}

	public boolean createDipendente(Dipendente d) {
		String psw = d.getPassword();
		d.setPassword(PSWCodifer.codificaPsw(psw));
		d.setRuolo(Ruolo.DIPENDENTE);
		dDAO.createUser(d);
		Rubrica r = s.registraRubrica(d.getNome(), d.getCognome());
		d.setRubrica(r);
		return dDAO.updateUser(d);
	}

	public boolean createAdmin(Admin a) {
		String psw = a.getPassword();
		a.setPassword(PSWCodifer.codificaPsw(psw));
		a.setRuolo(Ruolo.ADMIN);
		return aDAO.createUser(a);
	}
	
	public void updateCliente(Cliente c){
		cDAO.updateUser(c);
	}
	
	public void updateDipendente(Dipendente d){
		dDAO.updateUser(d);
	}
	
	public void updateAdmin(Admin a) {
		aDAO.updateUser(a);
	}

	public void deleteCliente(Cliente c) {
		cDAO.deleteUser(c);	
	}

	public void deleteDipendente(Dipendente d) {
		dDAO.deleteUser(d);		
	}
	
	public List<Cliente> getListClienti(){
		return cDAO.getAll();
	}
	
	public List<Dipendente> getListDipendenti(){
		return dDAO.getAll();
	}
	
	public List<Dipendente> getOnline() {
		return dDAO.getOnline();
	}

	public Cliente readCliente(long id) {
		return cDAO.readUser(id);
	}
	
	public Dipendente readDipendente(long id) {
		return dDAO.readUser(id);
	}

	public Admin readAdmin(long id) {
		return aDAO.readUser(id);
	}
}
