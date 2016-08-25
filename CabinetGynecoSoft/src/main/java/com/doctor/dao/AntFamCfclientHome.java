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

import com.doctor.persistance.AntFamCfclient;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AntFamCfclient.
 * @see com.proddoctor.dao.AntFamCfclient
 * @author Hibernate Tools
 */
public class AntFamCfclientHome {

	private static Logger log = Logger.getLogger(AntFamCfclientHome.class);

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

	public void persist(AntFamCfclient transientInstance) {
		log.debug("persisting AntFamCfclient instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AntFamCfclient instance) {
		log.debug("attaching dirty AntFamCfclient instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AntFamCfclient instance) {
		log.debug("attaching clean AntFamCfclient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AntFamCfclient persistentInstance) {
		log.debug("deleting AntFamCfclient instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AntFamCfclient merge(AntFamCfclient detachedInstance) {
		log.debug("merging AntFamCfclient instance");
		try {
			AntFamCfclient result = (AntFamCfclient) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<AntFamCfclient> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntFamCfclient.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<AntFamCfclient> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntFamCfclient.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<AntFamCfclient>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<AntFamCfclient> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntFamCfclient.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public AntFamCfclient findById(java.lang.Integer id) {
		log.debug("getting AntFamCfclient instance with id: " + id);
		try {
			AntFamCfclient instance = (AntFamCfclient) sessionFactory.getCurrentSession()
					.get(AntFamCfclient.class, id);
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

	public List<AntFamCfclient> findByExample(AntFamCfclient instance) {
		log.debug("finding AntFamCfclient instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AntFamCfclient> results = (List<AntFamCfclient>) sessionFactory
					.getCurrentSession()
					.createCriteria(AntFamCfclient.class)
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
	public List<AntFamCfclient> findByCfclient(Integer idPatient) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntFamCfclient.class)
				.setFetchMode("cfclient",FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", idPatient));
		return crit.list();
	}

	
}
