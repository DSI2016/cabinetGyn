package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Sterile;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Sterile.
 * @see com.proddoctor.dao.Sterile
 * @author Hibernate Tools
 */
public class SterileHome {

	private static Logger log = Logger.getLogger(SterileHome.class);

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
	public void persist(Sterile transientInstance) {
		log.debug("persisting Sterile instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Sterile instance) {
		log.debug("attaching dirty Sterile instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Sterile instance) {
		log.debug("attaching clean Sterile instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Sterile persistentInstance) {
		log.debug("deleting Sterile instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sterile merge(Sterile detachedInstance) {
		log.debug("merging Sterile instance");
		try {
			Sterile result = (Sterile) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Sterile findById(java.lang.Integer id) {
		log.debug("getting Sterile instance with id: " + id);
		try {
			Sterile instance = (Sterile) sessionFactory.getCurrentSession().get(
					Sterile.class, id);
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
	public List<Sterile> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Sterile.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Sterile>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Sterile> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Sterile.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Sterile> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Sterile.class);
		
		return (List<Sterile>)crit.list();
		}
	
	public List<Sterile> findByExample(Sterile instance) {
		log.debug("finding Sterile instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Sterile> results = (List<Sterile>) sessionFactory
					.getCurrentSession()
					.createCriteria(Sterile.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public Sterile findSterilPatient(Integer code) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Sterile.class)
				.setFetchMode("cfclient",FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", code));
		
		return (Sterile) crit.uniqueResult();
	}
}