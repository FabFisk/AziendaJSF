package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Admin;
import it.alfasoft.fabrizio.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAO {
	
	//1- Create
		public boolean createUser(Admin a){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.persist(a);
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
		public Admin readUser(long id_a){
			Admin a = null;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				a = session.get(Admin.class, id_a);
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return a;
		}	
		//3- Update
		public boolean updateUser(Admin a){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.update(a);
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
		public boolean deleteUser(Admin a){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.delete(a);
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return res;
		}
		
		public void fillDatiAdmin(Admin a) {
			Admin aTemp = this.readUser(a.getId_utente());
			a.setNome(aTemp.getNome());
			a.setCognome(aTemp.getCognome());
			a.setRuolo(aTemp.getRuolo());
			a.setUsername(aTemp.getUsername());
			a.setPassword(aTemp.getPassword());
			a.setLivello(aTemp.getLivello());
		}
}
