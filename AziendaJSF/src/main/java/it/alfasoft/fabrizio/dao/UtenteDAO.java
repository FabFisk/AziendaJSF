package it.alfasoft.fabrizio.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.fabrizio.bean.Utente;
import it.alfasoft.fabrizio.utility.HibernateUtil;

public class UtenteDAO implements IUtenteDAO {
	
	//1- Create
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IUtenteDAO#createUser(it.alfasoft.fabrizio.bean.Utente)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IUtenteDAO#readUser(long)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IUtenteDAO#readUserUserPsw(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente readUserUserPsw(String user, String psw){
		Utente u = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Utente where username=:userInserito and password=:pswInserito ");
			query.setString("userInserito", user);
			query.setString("pswInserito", psw);
			u = (Utente) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return u;
	}
	
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IUtenteDAO#readUserNomeCog(java.lang.String, java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IUtenteDAO#readUserUser(java.lang.String)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IUtenteDAO#updateUser(it.alfasoft.fabrizio.bean.Utente)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IUtenteDAO#deleteUser(it.alfasoft.fabrizio.bean.Utente)
	 */
	@Override
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
}
