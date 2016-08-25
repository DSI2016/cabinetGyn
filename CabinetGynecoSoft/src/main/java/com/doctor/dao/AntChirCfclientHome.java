package com.doctor.dao;

// Generated 18 ao�t 2014 14:11:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.AntChirCfclient;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AntChirCfclient.
 * @see com.proddoctor.dao.AntChirCfclient
 * @author Hibernate Tools
 */
public class AntChirCfclientHome {

	private static Logger log = Logger.getLogger(AntChirCfclientHome.class);

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
	}

	public void persist(AntChirCfclient transientInstance) {
		log.debug("persisting AntChirCfclient instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AntChirCfclient instance) {
		log.debug("attaching dirty AntChirCfclient instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AntChirCfclient instance) {
		log.debug("attaching clean AntChirCfclient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AntChirCfclient persistentInstance) {
		log.debug("deleting AntChirCfclient instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AntChirCfclient merge(AntChirCfclient detachedInstance) {
		log.debug("merging AntChirCfclient instance");
		try {
			AntChirCfclient result = (AntChirCfclient) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<AntChirCfclient> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntChirCfclient.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<AntChirCfclient> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntChirCfclient.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<AntChirCfclient>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<AntChirCfclient> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntChirCfclient.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public AntChirCfclient findById(java.lang.Integer id) {
		log.debug("getting AntChirCfclient instance with id: " + id);
		try {
			AntChirCfclient instance = (AntChirCfclient) sessionFactory.getCurrentSession()
					.get(AntChirCfclient.class, id);
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

	public List<AntChirCfclient> findByExample(AntChirCfclient instance) {
		log.debug("finding AntChirCfclient instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AntChirCfclient> results = (List<AntChirCfclient>) sessionFactory
					.getCurrentSession()
					.createCriteria(AntChirCfclient.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AntChirCfclient> findByCfclient(Integer idPatient) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntChirCfclient.class)
				.setFetchMode("cfclient",FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", idPatient));
		return crit.list();
	}

	
}
