package common;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	static {
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session currentSession() throws HibernateException {
		Session s = session.get();
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
	
	public static void save(Object o) {	
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(o);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	
	public static void delete(Object o) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(o);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	
	public static void deleteById(Class c, Integer id) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Object o = session.get(c, id);
		session.delete(o);
		transaction.commit();
		HibernateUtil.closeSession();		
	}
	public static Object get(Class c, Integer id) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Object o = session.get(c, id);
		transaction.commit();
		HibernateUtil.closeSession();
		return o;
	}
	
	public static void update(Object o) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.update(o);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	//hql≤È—Ø
	public static List find(String hql) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		List list = session.createQuery(hql).list();
		transaction.commit();
		HibernateUtil.closeSession();
		return list;
	}
	//hql≤È—Ø
	public static List find(String hql, Object o) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		List list = session.createQuery(hql).setParameter(0, o).list();
		transaction.commit();
		HibernateUtil.closeSession();
		return list;
	}
	//∑÷“≥
	public static List findByPage(String hql, int offset, int size, Integer[] total) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		List list = session.createQuery(hql).setFirstResult(offset).setMaxResults(size).list();
		Query query = session.createQuery("select count(*) "+hql);
		total[0] = ((Long) query.uniqueResult()).intValue();
		transaction.commit();
		HibernateUtil.closeSession();
		return list;
	}

	
}
