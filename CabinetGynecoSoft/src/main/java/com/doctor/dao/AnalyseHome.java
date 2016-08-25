package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Analyse;

/**
 * Home object for domain model class Analyse.
 * 
 * @see com.proddoctor.dao.Analyse
 * @author Hibernate Tools
 */
public class AnalyseHome {

	private static Logger log = Logger.getLogger(AnalyseHome.class);

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

	public void persist(Analyse transientInstance) {
		log.debug("persisting Analyse instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Analyse> findAllWithFilter(String valeurRecherche) {

		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Analyse.class)
				.add(Restrictions.like("libAnalyse", valeurRecherche,
						MatchMode.ANYWHERE));

		return crit.list();
	}

	public void attachDirty(Analyse instance) {
		log.debug("attaching dirty Analyse instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Analyse instance) {
		log.debug("attaching clean Analyse instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Analyse persistentInstance) {
		log.debug("deleting Analyse instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Analyse merge(Analyse detachedInstance) {
		log.debug("merging Analyse instance");
		try {
			Analyse result = (Analyse) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Analyse findById(java.lang.Integer id) {
		log.debug("getting Analyse instance with id: " + id);
		try {
			Analyse instance = (Analyse) sessionFactory.getCurrentSession()
					.get(Analyse.class, id);
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

	public Analyse findByAnalyse(String analyse) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Analyse.class)
				.add(Restrictions.eq("libAnalyse", analyse));
		Analyse anal = (Analyse) criteria.uniqueResult();

		return (anal);
	}

	@SuppressWarnings("unchecked")
	public List<Analyse> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Analyse.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<Analyse>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Analyse> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Analyse.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Analyse> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Analyse.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Analyse> findByExample(Analyse instance) {
		log.debug("finding Analyse instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Analyse> results = (List<Analyse>) sessionFactory
					.getCurrentSession().createCriteria(Analyse.class)
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
