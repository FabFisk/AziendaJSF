package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Cliente;
import it.alfasoft.fabrizio.bean.Utente;
import it.alfasoft.fabrizio.utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDAO {

	//1- Create
	public boolean createUser(Cliente c){
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(c);
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
	public List<Utente> getAll() {
		List<Utente> clienti = new ArrayList<Utente>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Cliente");
			clienti = query.list();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return clienti;
	}
	
	public Cliente readUser(long id_c){
		Cliente a = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			a = session.get(Cliente.class, id_c);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return a;
	}	
	//3- Update
	public boolean updateUser(Cliente c){
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(c);
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
	public boolean deleteUser(Cliente c){
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(c);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	public void fillDatiCliente(Cliente c) {		
		Cliente cTemp = this.readUser(c.getId_utente());
		c.setNome(cTemp.getNome());
		c.setCognome(cTemp.getCognome());
		c.setRuolo(cTemp.getRuolo());
		c.setUsername(cTemp.getUsername());
		c.setPassword(cTemp.getPassword());
		c.setRagSociale(cTemp.getRagSociale());
		c.setRubrica(cTemp.getRubrica());
	}
	
}
