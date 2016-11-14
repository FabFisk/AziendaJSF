package it.alfasoft.fabrizio.service;

import java.util.List;

import it.alfasoft.fabrizio.rubrica.Rubrica;
import it.alfasoft.fabrizio.rubrica.RubricaDao;
import it.alfasoft.fabrizio.rubrica.Voce;
import it.alfasoft.fabrizio.rubrica.VoceDao;

public class ServizioRubrica {	

	private VoceDao vDao = new VoceDao();
	private RubricaDao rDao = new RubricaDao();

	public Rubrica registraRubrica(String nome, String cognome) {
		Rubrica r = new Rubrica(nome, cognome);
		rDao.creaRubrica(r);
		return r;
	}

	public boolean readVoce(Rubrica r, Voce v) {
		boolean token = false;
		if(vDao.readVoce(r, v.getNome(), v.getCognome())!=null){
			token = true;
		}
		return token;
	}

	public void createVoce(Rubrica r, Voce v) {
		vDao.creaVoce(v);
		v.setRubrica(r);
		r.aggiungiVoce(v);
		vDao.updateVoce(v);
		rDao.aggiornaRubrica(r);
	}

	public List<Voce> getAll(Rubrica r) {
		return vDao.readAll(r);
	}

	public Voce readVoceNomeCognome(Rubrica r, String nome, String cognome) {
		return vDao.readVoce(r, nome, cognome);
	}

	public boolean eliminaVoce(long id) {
		Voce v = vDao.readVoce(id);
		return vDao.deleteVoce(v);
	}
	
}
