package it.alfasoft.fabrizio.service;

import it.alfasoft.fabrizio.bean.BustaPaga;
import it.alfasoft.fabrizio.dao.BustaDAO;
import it.alfasoft.fabrizio.dao.IBustaPagaDAO;

import java.util.List;

public class GestioneBustePaga {
	
	IBustaPagaDAO bDAO = new BustaDAO();
	
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

}
