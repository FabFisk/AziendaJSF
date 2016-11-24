package it.alfasoft.fabrizio.dao;

import it.alfasoft.fabrizio.bean.Admin;
import it.alfasoft.fabrizio.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAO implements IAdminDAO {
	
	//1- Create
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IAdminDAO#createUser(it.alfasoft.fabrizio.bean.Admin)
		 */
		@Override
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
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IAdminDAO#readUser(long)
		 */
		@Override
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
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IAdminDAO#updateUser(it.alfasoft.fabrizio.bean.Admin)
		 */
		@Override
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
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IAdminDAO#deleteUser(it.alfasoft.fabrizio.bean.Admin)
		 */
		@Override
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
}
