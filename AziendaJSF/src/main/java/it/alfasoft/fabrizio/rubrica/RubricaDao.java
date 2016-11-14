package it.alfasoft.fabrizio.rubrica;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.fabrizio.utility.HibernateUtil;

public class RubricaDao {

	// 1- Create

	public boolean creaRubrica(Rubrica r) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(r);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	// 2- Read 
	public Rubrica readRubrica(long r_id) {
		Rubrica r = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			r = session.get(Rubrica.class, r_id);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return r;
	}
	

	public Rubrica readRubrica(String nome, String cognome) {
		Rubrica r = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Rubrica where nome=:nomeInserito and cognome=:cognomeInserito ");
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			r = (Rubrica) query.uniqueResult();			
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return r;
	}
	
	// 3- Update
	public boolean aggiornaRubrica(Rubrica r) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(r);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	public boolean deleteRubrica(Rubrica r) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(r);
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
