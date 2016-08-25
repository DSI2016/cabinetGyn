package com.doctor.dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.doctor.persistance.JourFr;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class JourFr.
 * @see com.proddoctor.dao.JourFr
 * @author Hibernate Tools
 */
public class JourFrHome {

	private static Logger log = Logger.getLogger(JourFrHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}	public void persist(JourFr transientInstance) {
		log.debug("persisting JourFr instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(JourFr instance) {
		log.debug("attaching dirty JourFr instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(JourFr instance) {
		log.debug("attaching clean JourFr instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(JourFr persistentInstance) {
		log.debug("deleting JourFr instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JourFr merge(JourFr detachedInstance) {
		log.debug("merging JourFr instance");
		try {
			JourFr result = (JourFr) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public JourFr findById(java.lang.Integer id) {
		log.debug("getting JourFr instance with id: " + id);
		try {
			JourFr instance = (JourFr) sessionFactory.getCurrentSession().get(
					JourFr.class, id);
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
	public List<JourFr> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JourFr.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<JourFr> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JourFr.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<JourFr> findByExample(JourFr instance) {
		log.debug("finding JourFr instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<JourFr> results = (List<JourFr>) sessionFactory
					.getCurrentSession()
					.createCriteria(JourFr.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
}
