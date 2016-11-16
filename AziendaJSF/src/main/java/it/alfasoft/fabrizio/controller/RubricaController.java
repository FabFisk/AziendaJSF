package it.alfasoft.fabrizio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import it.alfasoft.fabrizio.rubrica.Rubrica;
import it.alfasoft.fabrizio.rubrica.Voce;
import it.alfasoft.fabrizio.service.ServizioRubrica;

@ManagedBean(name="RControl")
@ViewScoped
public class RubricaController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServizioRubrica sR;
	private List<Voce> voci;
	
	public RubricaController(){
		sR = new ServizioRubrica();
		voci = new ArrayList<Voce>();
	}

	public ServizioRubrica getsR() {
		return sR;
	}

	public void setsR(ServizioRubrica sR) {
		this.sR = sR;
	}

	public List<Voce> getVoci() {
		return voci;
	}

	public void setVoci(List<Voce> voci) {
		this.voci = voci;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Voce> selectRubrica(Rubrica r){
		this.setVoci(sR.getAll(r));
		return voci;		
	}

}
