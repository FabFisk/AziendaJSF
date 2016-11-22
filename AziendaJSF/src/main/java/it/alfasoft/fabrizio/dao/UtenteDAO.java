package it.alfasoft.fabrizio.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.fabrizio.bean.Utente;
import it.alfasoft.fabrizio.utility.HibernateUtil;

public class UtenteDAO {
	
	//1- Create
	public boolean createUser(Utente u){
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(u);
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
	public Utente readUser(long id_u){
		Utente u = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			u = session.get(Utente.class, id_u);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return u;
	}	
	
	public boolean readUserUserPsw(String user, String psw){
		boolean bool = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Utente where username=:userInserito and password=:pswInserito ");
			query.setString("userInserito", user);
			query.setString("pswInserito", psw);
			Utente u = (Utente) query.uniqueResult();
			if(u!=null){
				bool = true;
			}
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return bool;
	}
	
	public Utente readUserNomeCog(String nome, String cognome){
		Utente u = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Utente where nome=:nomeInserito and cognome=:cognomeInserito ");
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			u = (Utente) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return u;
	}
	
	public Utente readUserUser (String username){
		Utente u = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Utente where username=:usernameInserito");
			query.setString("usernameInserito", username);
			u = (Utente) query.uniqueResult();
			tx.commit();
		}catch (Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return u;
	}
	//3- Update
	public boolean updateUser(Utente u){
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(u);
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
	public boolean deleteUser(Utente u){
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(u);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}	
	
	public void fillDatiUtente(Utente u){		
		Utente uTemp = this.readUserUser(u.getUsername());
		u.setNome(uTemp.getNome());
		u.setCognome(uTemp.getCognome());
		u.setRuolo(uTemp.getRuolo());
		u.setId_utente(uTemp.getId_utente());
		u.setRubrica(uTemp.getRubrica());
	}
}
