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

import com.doctor.persistance.Jour;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Doctor.
 * 
 * @see com.JourDocteur.dao.Doctor
 * @author Hibernate Tools
 */
public class JourHome {

	private static Logger log = Logger.getLogger(JourHome.class);

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

	public void persist(Jour transientInstance) {
		log.debug("persisting  instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Jour instance) {
		log.debug("attaching dirty Jour instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Jour instance) {
		log.debug("attaching clean Doctor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Jour persistentInstance) {
		log.debug("deleting Doctor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jour merge(Jour detachedInstance) {
		log.debug("merging Doctor instance");
		try {
			Jour result = (Jour) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Jour findById(java.lang.Integer id) {
		log.debug("getting Doctor instance with id: " + id);
		try {
			Jour instance = (Jour) sessionFactory.getCurrentSession()
					.get(Jour.class, id);
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
	public List<Jour> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Jour.class);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jour> findAllWithJoin() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Jour.class)
				.setFetchMode("horaire", FetchMode.JOIN)
				.setFetchMode("horaire2", FetchMode.JOIN);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Jour> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Jour.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Jour> findByExample(Jour instance) {
		log.debug("finding Doctor instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Jour> results = (List<Jour>) sessionFactory
					.getCurrentSession().createCriteria(Jour.class)
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
	public List<Jour> findByIdHoraire(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Jour.class)
				.setFetchMode("horaire", FetchMode.JOIN).createCriteria("horaire").add(Restrictions.eq("idHoraire", id));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jour> findByIdHoraire2(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Jour.class)
				.setFetchMode("horaire2", FetchMode.JOIN).createCriteria("horaire2").add(Restrictions.eq("idHoraire", id));
		return crit.list();
	}
	
}
