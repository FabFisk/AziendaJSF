package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DipendenteDAO implements IDipendenteDAO {

	//1- Create
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IDipendenteDAO#createUser(it.alfasoft.fabrizio.bean.Dipendente)
		 */
		@Override
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
		
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IDipendenteDAO#getAll()
		 */
		@Override
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
		
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IDipendenteDAO#getOnline()
		 */
		@Override
		@SuppressWarnings("unchecked")
		public List<Dipendente> getOnline() {
			List<Dipendente> dipendenti = new ArrayList<Dipendente>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from Dipendente where loggato=:statusInserito");
				query.setBoolean("statusInserito", true);
				dipendenti = query.list();
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return dipendenti;
		}
		
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IDipendenteDAO#readUser(long)
		 */
		@Override
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
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IDipendenteDAO#updateUser(it.alfasoft.fabrizio.bean.Dipendente)
		 */
		@Override
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
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IDipendenteDAO#deleteUser(it.alfasoft.fabrizio.bean.Dipendente)
		 */
		@Override
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
}
