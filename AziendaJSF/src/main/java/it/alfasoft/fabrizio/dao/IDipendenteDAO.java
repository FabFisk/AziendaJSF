package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Dipendente;

import java.util.List;

public interface IDipendenteDAO {

	//1- Create
	public abstract boolean createUser(Dipendente d);

	//2- Read

	public abstract List<Dipendente> getAll();

	public abstract List<Dipendente> getOnline();

	public abstract Dipendente readUser(long id_d);

	//3- Update
	public abstract boolean updateUser(Dipendente d);

	//4- Delete
	public abstract boolean deleteUser(Dipendente d);

}