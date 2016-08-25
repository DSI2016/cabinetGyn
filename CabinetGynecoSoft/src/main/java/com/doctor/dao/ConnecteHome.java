package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Connecte;

/**
 * Home object for domain model class Connecte.
 * 
 * @see com.proddoctor.dao.Connecte
 * @author Hibernate Tools
 */
public class ConnecteHome {

	private static Logger log = Logger.getLogger(ConnecteHome.class);

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

	public void persist(Connecte transientInstance) {
		log.debug("persisting Connecte instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Connecte persistentInstance) {
		log.debug("deleting Connecte instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Connecte findById(java.lang.Integer id) {
		log.debug("getting Connecte instance with id: " + id);
		try {
			Connecte instance = (Connecte) sessionFactory.getCurrentSession()
					.get(Connecte.class, id);
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
	public List<Connecte> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Connecte.class);

		return crit.list();
	}

	public Connecte findByConnecte(String connecte) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Connecte.class)
				.add(Restrictions.eq("login", connecte));
		Connecte v = (Connecte) criteria.uniqueResult();

		return v;
	}

}
