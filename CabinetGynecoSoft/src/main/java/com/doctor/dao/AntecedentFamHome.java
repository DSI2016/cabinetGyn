package com.doctor.dao;

// Generated 18 ao�t 2014 14:11:58 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.doctor.persistance.AntecedentFam;

/**
 * Home object for domain model class AntecedentFam.
 * 
 * @see com.proddoctor.dao.AntecedentFam
 * @author Hibernate Tools
 */
public class AntecedentFamHome {

	private static Logger log = Logger.getLogger(AntecedentFamHome.class);

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

	public void persist(AntecedentFam transientInstance) {
		log.debug("persisting AntecedentFam instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AntecedentFam instance) {
		log.debug("attaching dirty AntecedentFam instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AntecedentFam instance) {
		log.debug("attaching clean AntecedentFam instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AntecedentFam persistentInstance) {
		log.debug("deleting AntecedentFam instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AntecedentFam merge(AntecedentFam detachedInstance) {
		log.debug("merging AntecedentFam instance");
		try {
			AntecedentFam result = (AntecedentFam) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentFam> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				AntecedentFam.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentFam> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentFam.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<AntecedentFam>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentFam> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				AntecedentFam.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public AntecedentFam findById(java.lang.Integer id) {
		log.debug("getting AntecedentFam instance with id: " + id);
		try {
			AntecedentFam instance = (AntecedentFam) sessionFactory
					.getCurrentSession().get(AntecedentFam.class, id);
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

	public List<AntecedentFam> findByExample(AntecedentFam instance) {
		log.debug("finding AntecedentFam instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AntecedentFam> results = (List<AntecedentFam>) sessionFactory
					.getCurrentSession().createCriteria(AntecedentFam.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public AntecedentFam findByAntecedentFam(String libantecedentFam) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentFam.class)
				.add(Restrictions.eq("antFamilial", libantecedentFam));
		AntecedentFam c = (AntecedentFam) criteria.uniqueResult();

		return c;
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentFam> findWithFilter(String valeurRecherche) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentFam.class)
				.add(Restrictions.eq("antFamilial", valeurRecherche));

		return criteria.list();
	}
}
