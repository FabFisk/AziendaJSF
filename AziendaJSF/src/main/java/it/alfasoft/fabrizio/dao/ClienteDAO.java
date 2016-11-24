package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Cliente;
import it.alfasoft.fabrizio.utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDAO implements IClienteDAO {

	//1- Create
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IClienteDAO#createUser(it.alfasoft.fabrizio.bean.Cliente)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IClienteDAO#getAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getAll() {
		List<Cliente> clienti = new ArrayList<Cliente>();
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
	
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IClienteDAO#readUser(long)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IClienteDAO#updateUser(it.alfasoft.fabrizio.bean.Cliente)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see it.alfasoft.fabrizio.dao.IClienteDAO#deleteUser(it.alfasoft.fabrizio.bean.Cliente)
	 */
	@Override
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
}
