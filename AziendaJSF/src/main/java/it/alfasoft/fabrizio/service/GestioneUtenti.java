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

	public void creteBusta(BustaPaga b) {
		bDAO.createBusta(b);
	}
	
	public List<BustaPaga> getListBuste() {
		return bDAO.getAll();
	}

	public void updateBusta(BustaPaga b) {
		bDAO.updateBusta(b);
		
	}

	public void deleteBusta(BustaPaga b) {
		bDAO.deleteBusta(b);		
	}


	
	

	
//	public boolean existUserBoolean(String username, String password) {
//		
//		boolean res = false;
//		Utente u = uDAO.readUserUser(username);
//		if(u != null && u.getPassword().equals(password)){
//			res=true;
//		}
//		return res;
//
//	}
//	
//	public void setBeanUtente(Utente u){
//		uDAO.fillDatiUtente(u);
//	}
//	
//	public void setBeanAdmin(Admin a){
//		aDAO.fillDatiAdmin(a);
//	}
//	
//	public void setBeanCliente(Cliente c){
//		cDAO.fillDatiCliente(c);
//	}
//	
//	public void setBeanDipendente(Dipendente d){
//		dDAO.fillDatiDipendente(d);
//	}
//	
//	public boolean readClienteId(long id){
//		return cDAO.readUser(id) != null;		
//	}
//	
//	public boolean readDipendenteId(long id){
//		return dDAO.readUser(id) != null;		
//	}
//	
//	public Utente readUserUserPsw(String username, String password){
//		return uDAO.readUserUserPsw(username, password);
//	}
//	
//	public Utente readUserNomeCog(String nome, String cognome){
//		return uDAO.readUserNomeCog(nome, cognome);
//	}
//
//	
//	public Utente readUserUser(String username){
//		return uDAO.readUserUser(username);
//	}
//	
//	public List<Voce> getAllVoci(Rubrica r){
//		return s.getAll(r);
//	}
//	
//	public boolean readVoce(Rubrica r, Voce v){
//		return s.readVoce(r, v);
//	}
//	
//	public Voce readVoceNomeCognome(Rubrica r, String nome, String cognome){
//		return s.readVoceNomeCognome(r, nome, cognome);
//	}
//	
//	public void createVoce(Rubrica r, Voce v){
//		s.createVoce(r, v);
//	}
//	
//	public boolean eliminaVoceById(long id){
//		return s.eliminaVoce(id);
//	}
//	
//	public Rubrica trovaRubrica(Utente u){
//		Utente user = uDAO.readUserUserPsw(u.getUsername(), u.getPassword());
//		return user.getRubrica();
//	}
//	
//	public Ruolo checkRuolo(long id){
//		Utente u = uDAO.readUser(id);
//		return u.getRuolo();
//	}
//	
//	public void createBusta(BustaPaga b){
//		bDAO.createBusta(b);
//	}
//	
//	public BustaPaga readBusta(String mese, int anno, Dipendente d){
//		return bDAO.readBusta(mese, anno, d);		
//	}
//	
//	public List<BustaPaga> getListBuste(){
//		return bDAO.getAll();
//	}
//	
//	public List<BustaPaga> getAllBuste(Dipendente d){
//		return bDAO.getAll(d);
//	}
}
