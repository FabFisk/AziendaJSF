package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DipendenteDAO {

	//1- Create
		public boolean createUser(Dipendente d){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.persist(d);
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return res;
		}	
		//2- Read
		
		@SuppressWarnings("unchecked")
		public List<Dipendente> getAll() {
			List<Dipendente> dipendenti = new ArrayList<Dipendente>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from Dipendente");
				dipendenti = query.list();
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return dipendenti;
		}
		
		@SuppressWarnings("unchecked")
		public List<Dipendente> getOnline() {
			List<Dipendente> dipendenti = new ArrayList<Dipendente>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from Dipendente where online=:statusInserito");
				query.setInteger("statusInserito", 1);
				dipendenti = query.list();
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return dipendenti;
		}
		
		public Dipendente readUser(long id_d){
			Dipendente a = null;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				a = session.get(Dipendente.class, id_d);
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return a;
		}	
		//3- Update
		public boolean updateUser(Dipendente d){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.update(d);
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return res;
		}	
		
		//4- Delete
		public boolean deleteUser(Dipendente d){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.delete(d);
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return res;
		}
		
		public void fillDatiDipendente(Dipendente d) {			
			Dipendente dTemp = this.readUser(d.getId_utente());
			d.setNome(dTemp.getNome());
			d.setCognome(dTemp.getCognome());
			d.setRuolo(dTemp.getRuolo());
			d.setUsername(dTemp.getUsername());
			d.setPassword(dTemp.getPassword());
			d.setStipendio(dTemp.getStipendio());
			d.setRubrica(dTemp.getRubrica());
		}

}
