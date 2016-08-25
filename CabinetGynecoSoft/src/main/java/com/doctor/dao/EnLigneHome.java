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

import com.doctor.persistance.EnLigne;

/**
 * Home object for domain model class EnLigne.
 * 
 * @see com.EnLigneBean.dao.EnLigne
 * @author Hibernate Tools
 */
public class EnLigneHome {

	private static Logger log = Logger.getLogger(EnLigneHome.class);

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

	public void persist(EnLigne transientInstance) {
		log.debug("persisting EnLigne instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EnLigne instance) {
		log.debug("attaching dirty EnLigne instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(EnLigne instance) {
		log.debug("attaching clean EnLigne instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EnLigne persistentInstance) {
		log.debug("deleting EnLigne instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EnLigne merge(EnLigne detachedInstance) {
		log.debug("merging EnLigne instance");
		try {
			EnLigne result = (EnLigne) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EnLigne findById(java.lang.Integer id) {
		log.debug("getting EnLigne instance with id: " + id);
		try {
			EnLigne instance = (EnLigne) sessionFactory.getCurrentSession().get(
					EnLigne.class, id);
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
	public List<EnLigne> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(EnLigne.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<EnLigne>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<EnLigne> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				EnLigne.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<EnLigne> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				EnLigne.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<EnLigne> findByExample(EnLigne instance) {
		log.debug("finding EnLigne instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<EnLigne> results = (List<EnLigne>) sessionFactory
					.getCurrentSession().createCriteria(EnLigne.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public EnLigne findByEnLigne(String enLigne) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(EnLigne.class)
				.add(Restrictions.eq("idSession", enLigne));
		EnLigne v = (EnLigne) criteria.uniqueResult();

		return v;
	}

	@SuppressWarnings("unchecked")
	public List<EnLigne> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(EnLigne.class)
				.add(Restrictions.like("idSession", valeurRecherche,
						MatchMode.ANYWHERE));
		return crit.list();
	}
}
