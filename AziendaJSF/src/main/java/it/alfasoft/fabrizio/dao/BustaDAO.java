package it.alfasoft.fabrizio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.fabrizio.bean.BustaPaga;
import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.utility.HibernateUtil;

public class BustaDAO implements IBustaPagaDAO {
	
	//1- Create
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IBustaPagaDAO#createBusta(it.alfasoft.fabrizio.bean.BustaPaga)
		 */
		@Override
		public boolean createBusta(BustaPaga b){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.persist(b);
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
		 * @see it.alfasoft.fabrizio.dao.IBustaPagaDAO#readBusta(java.lang.String, int, it.alfasoft.fabrizio.bean.Dipendente)
		 */
		@Override
		public BustaPaga readBusta(String mese, int anno, Dipendente d) {
			BustaPaga b = null;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createQuery("from BustaPaga where mese=:meseInserito and anno=:annoInserito and dipendente=:dipendenteInserito");
				query.setString("meseInserito", mese);
				query.setInteger("annoInserito", anno);
				query.setLong("dipendenteInserito", d.getId_utente());
				b = (BustaPaga) query.uniqueResult();
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return b;
		}
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IBustaPagaDAO#getAll(it.alfasoft.fabrizio.bean.Dipendente)
		 */
		@Override
		@SuppressWarnings("unchecked")
		public List<BustaPaga> getAll(Dipendente d) {
			List<BustaPaga> buste = new ArrayList<BustaPaga>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from BustaPaga where dipendente=:dipInserito");
				query.setLong("dipInserito", d.getId_utente());
				buste = query.list();
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return buste;
		}
		
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IBustaPagaDAO#getAll()
		 */
		@Override
		@SuppressWarnings("unchecked")
		public List<BustaPaga> getAll() {
			List<BustaPaga> buste = new ArrayList<BustaPaga>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from BustaPaga");
				buste = query.list();
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return buste;
		}
		
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IBustaPagaDAO#readBusta(long)
		 */
		@Override
		public BustaPaga readBusta(long id_b){
			BustaPaga b = null;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				b = session.get(BustaPaga.class, id_b);
				tx.commit();
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return b;
		}	
		//3- Update
		/* (non-Javadoc)
		 * @see it.alfasoft.fabrizio.dao.IBustaPagaDAO#updateBusta(it.alfasoft.fabrizio.bean.BustaPaga)
		 */
		@Override
		public boolean updateBusta(BustaPaga b){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.update(b);
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
		 * @see it.alfasoft.fabrizio.dao.IBustaPagaDAO#deleteBusta(it.alfasoft.fabrizio.bean.BustaPaga)
		 */
		@Override
		public boolean deleteBusta(BustaPaga b){
			boolean res = false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				session.delete(b);
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
