package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Cliente;

import java.util.List;

public interface IClienteDAO {

	//1- Create
	public abstract boolean createUser(Cliente c);

	//2- Read
	public abstract List<Cliente> getAll();

	public abstract Cliente readUser(long id_c);

	//3- Update
	public abstract boolean updateUser(Cliente c);

	//4- Delete
	public abstract boolean deleteUser(Cliente c);

}