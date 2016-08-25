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

import com.doctor.persistance.AntMedCfclient;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AntMedCfclient.
 * @see com.proddoctor.dao.AntMedCfclient
 * @author Hibernate Tools
 */
public class AntMedCfclientHome {

	private static Logger log = Logger.getLogger(AntMedCfclientHome.class);

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

	public void persist(AntMedCfclient transientInstance) {
		log.debug("persisting AntMedCfclient instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AntMedCfclient instance) {
		log.debug("attaching dirty AntMedCfclient instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AntMedCfclient instance) {
		log.debug("attaching clean AntMedCfclient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AntMedCfclient persistentInstance) {
		log.debug("deleting AntMedCfclient instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AntMedCfclient merge(AntMedCfclient detachedInstance) {
		log.debug("merging AntMedCfclient instance");
		try {
			AntMedCfclient result = (AntMedCfclient) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<AntMedCfclient> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntMedCfclient.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<AntMedCfclient> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntMedCfclient.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<AntMedCfclient>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<AntMedCfclient> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntMedCfclient.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public AntMedCfclient findById(java.lang.Integer id) {
		log.debug("getting AntMedCfclient instance with id: " + id);
		try {
			AntMedCfclient instance = (AntMedCfclient) sessionFactory.getCurrentSession()
					.get(AntMedCfclient.class, id);
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

	public List<AntMedCfclient> findByExample(AntMedCfclient instance) {
		log.debug("finding AntMedCfclient instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AntMedCfclient> results = (List<AntMedCfclient>) sessionFactory
					.getCurrentSession()
					.createCriteria(AntMedCfclient.class)
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
	public List<AntMedCfclient> findByCfclient(Integer idPatient) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntMedCfclient.class)
				.setFetchMode("cfclient",FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", idPatient));
		return crit.list();
	}

	
}
