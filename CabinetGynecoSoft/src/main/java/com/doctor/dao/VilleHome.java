package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Ville;

/**
 * Home object for domain model class Ville.
 * 
 * @see com.proddoctor.dao.Ville
 * @author Hibernate Tools
 */
public class VilleHome {

	private static Logger log = Logger.getLogger(VilleHome.class);

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

	public void persist(Ville transientInstance) {
		log.debug("persisting Ville instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ville instance) {
		log.debug("attaching dirty Ville instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Ville instance) {
		log.debug("attaching clean Ville instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ville persistentInstance) {
		log.debug("deleting Ville instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ville merge(Ville detachedInstance) {
		log.debug("merging Ville instance");
		try {
			Ville result = (Ville) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ville findById(java.lang.Integer id) {
		log.debug("getting Ville instance with id: " + id);
		try {
			Ville instance = (Ville) sessionFactory.getCurrentSession().get(
					Ville.class, id);
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
	public List<Ville> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ville.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<Ville>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Ville> findAll() {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Ville.class);
		
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Ville> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Ville.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Ville> findByExample(Ville instance) {
		log.debug("finding Ville instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Ville> results = (List<Ville>) sessionFactory
					.getCurrentSession().createCriteria(Ville.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public Ville findByVille(String ville) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Ville.class)
				.add(Restrictions.eq("ville", ville));
		Ville v = (Ville) criteria.uniqueResult();

		return v;
	}

	@SuppressWarnings("unchecked")
	public List<Ville> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Ville.class)
				.add(Restrictions.like("ville", valeurRecherche,
						MatchMode.ANYWHERE));
		return crit.list();
	}
}
