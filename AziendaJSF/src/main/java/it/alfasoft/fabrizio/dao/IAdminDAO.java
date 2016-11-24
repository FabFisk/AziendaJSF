package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Admin;

public interface IAdminDAO {

	//1- Create
	public abstract boolean createUser(Admin a);

	//2- Read
	public abstract Admin readUser(long id_a);

	//3- Update
	public abstract boolean updateUser(Admin a);

	//4- Delete
	public abstract boolean deleteUser(Admin a);
}