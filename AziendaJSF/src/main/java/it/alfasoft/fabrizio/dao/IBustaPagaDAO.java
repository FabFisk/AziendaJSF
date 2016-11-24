package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.BustaPaga;
import it.alfasoft.fabrizio.bean.Dipendente;

import java.util.List;

public interface IBustaPagaDAO {

	//1- Create
	public abstract boolean createBusta(BustaPaga b);

	//2- Read

	public abstract BustaPaga readBusta(String mese, int anno, Dipendente d);

	public abstract List<BustaPaga> getAll(Dipendente d);

	public abstract List<BustaPaga> getAll();

	public abstract BustaPaga readBusta(long id_b);

	//3- Update
	public abstract boolean updateBusta(BustaPaga b);

	//4- Delete
	public abstract boolean deleteBusta(BustaPaga b);

}