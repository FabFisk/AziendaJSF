package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Utente;

public interface IUtenteDAO {

	//1- Create
	public abstract boolean createUser(Utente u);

	//2- Read
	public abstract Utente readUser(long id_u);

	public abstract Utente readUserUserPsw(String user, String psw);

	public abstract Utente readUserNomeCog(String nome, String cognome);

	public abstract Utente readUserUser(String username);

	//3- Update
	public abstract boolean updateUser(Utente u);

	//4- Delete
	public abstract boolean deleteUser(Utente u);

}