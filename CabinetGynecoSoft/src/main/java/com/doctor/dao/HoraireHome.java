package com.doctor.dao;

// Generated 18 ao�t 2014 14:11:58 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.doctor.persistance.Horaire;

/**
 * Home object for domain model class Doctor.
 * 
 * @see com.HoraireDocteur.dao.Doctor
 * @author Hibernate Tools
 */
public class HoraireHome {

	private static Logger log = Logger.getLogger(HoraireHome.class);

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

	public void persist(Horaire transientInstance) {
		log.debug("persisting  instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Horaire instance) {
		log.debug("attaching dirty Horaire instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Horaire instance) {
		log.debug("attaching clean Doctor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Horaire persistentInstance) {
		log.debug("deleting Doctor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Horaire merge(Horaire detachedInstance) {
		log.debug("merging Doctor instance");
		try {
			Horaire result = (Horaire) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Horaire findById(java.lang.Integer id) {
		log.debug("getting Doctor instance with id: " + id);
		try {
			Horaire instance = (Horaire) sessionFactory.getCurrentSession()
					.get(Horaire.class, id);
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
	public List<Horaire> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Horaire.class)
				.addOrder(Property.forName("debut").asc());
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Horaire> findAllbyOrdre(String ordre) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Horaire.class);
		if(ordre.equals("croissante"))
		{crit = sessionFactory.getCurrentSession()
				.createCriteria(Horaire.class)
				.addOrder(Property.forName("debut").asc());
		
		
		}
		if(ordre.equals("décroissante"))
		{crit = sessionFactory.getCurrentSession()
				.createCriteria(Horaire.class)
				.addOrder(Property.forName("fin").desc());
		
		
		}
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Horaire> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Horaire.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Horaire> findByExample(Horaire instance) {
		log.debug("finding Doctor instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Horaire> results = (List<Horaire>) sessionFactory
					.getCurrentSession().createCriteria(Horaire.class)
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
