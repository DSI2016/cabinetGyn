package com.doctor.dao;

// Generated 18 ao�t 2014 14:11:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Docteur;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Doctor.
 * 
 * @see com.Docteur.dao.Doctor
 * @author Hibernate Tools
 */
public class DocteurHome {

	private static Logger log = Logger.getLogger(DocteurHome.class);

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

	public void persist(Docteur transientInstance) {
		log.debug("persisting Doctor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Docteur instance) {
		log.debug("attaching dirty Doctor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Docteur instance) {
		log.debug("attaching clean Doctor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Docteur persistentInstance) {
		log.debug("deleting Doctor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Docteur merge(Docteur detachedInstance) {
		log.debug("merging Doctor instance");
		try {
			Docteur result = (Docteur) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Docteur findById(java.lang.Integer id) {
		log.debug("getting Doctor instance with id: " + id);
		try {
			Docteur instance = (Docteur) sessionFactory.getCurrentSession()
					.get(Docteur.class, id);
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
	public List<Docteur> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Docteur.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Docteur> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Docteur.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Docteur> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Docteur.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<Docteur>) crit.list();
	}

	public List<Docteur> findByExample(Docteur instance) {
		log.debug("finding Doctor instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Docteur> results = (List<Docteur>) sessionFactory
					.getCurrentSession().createCriteria(Docteur.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public Docteur findByDocteur(String docteur) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Docteur.class)
				.add(Restrictions.eq("libdoctor", docteur));
		Docteur d=(Docteur) criteria.uniqueResult();
		
		return d;
	}

	@SuppressWarnings("unchecked")
	public List<Docteur> findAllWithFilter(String valeurRecherche) {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Docteur.class).add(Restrictions.like("libdoctor", valeurRecherche, MatchMode.ANYWHERE));
		
		return crit.list();
	}

	
}
