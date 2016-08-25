package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.HistoriqueMsg;

/**
 * Home object for domain model class HistoriqueMsg.
 * 
 * @see com.proddoctor.dao.HistoriqueMsg
 * @author Hibernate Tools
 */
public class HistoriqueMsgHome {

	private static Logger log = Logger.getLogger(HistoriqueMsgHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			// return (SessionFactory) new
			// InitialContext().lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(HistoriqueMsg transientInstance) {
		log.debug("persisting HistoriqueMsg instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(HistoriqueMsg persistentInstance) {
		log.debug("deleting HistoriqueMsg instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HistoriqueMsg findById(java.lang.Integer id) {
		log.debug("getting HistoriqueMsg instance with id: " + id);
		try {
			HistoriqueMsg instance = (HistoriqueMsg) sessionFactory
					.getCurrentSession().get(HistoriqueMsg.class, id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<HistoriqueMsg> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueMsg.class)
				.addOrder(Property.forName("idMsg").desc());

		return crit.list();
	}

	public HistoriqueMsg findByHistoriqueMsg(String connecte) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueMsg.class)
				.add(Restrictions.eq("login", connecte));
		HistoriqueMsg v = (HistoriqueMsg) criteria.uniqueResult();

		return v;
	}

}
