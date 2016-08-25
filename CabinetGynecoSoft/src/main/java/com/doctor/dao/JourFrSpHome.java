package com.doctor.dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.doctor.persistance.JourFrSp;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class JourFr.
 * @see com.proddoctor.dao.JourFrSp
 * @author Hibernate Tools
 */
public class JourFrSpHome {

	private static Logger log = Logger.getLogger(JourFrSpHome.class);

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
	}	public void persist(JourFrSp transientInstance) {
		log.debug("persisting JourFrSp instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(JourFrSp instance) {
		log.debug("attaching dirty JourFrSp instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(JourFrSp instance) {
		log.debug("attaching clean JourFrSp instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(JourFrSp persistentInstance) {
		log.debug("deleting JourFrSp instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JourFrSp merge(JourFrSp detachedInstance) {
		log.debug("merging JourFrSp instance");
		try {
			JourFrSp result = (JourFrSp) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public JourFrSp findById(java.lang.Integer id) {
		log.debug("getting JourFrSp instance with id: " + id);
		try {
			JourFrSp instance = (JourFrSp) sessionFactory.getCurrentSession().get(
					JourFrSp.class, id);
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
	public List<JourFrSp> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JourFrSp.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<JourFrSp> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JourFrSp.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<JourFrSp> findByExample(JourFrSp instance) {
		log.debug("finding JourFrSp instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<JourFrSp> results = (List<JourFrSp>) sessionFactory
					.getCurrentSession()
					.createCriteria(JourFrSp.class)
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
