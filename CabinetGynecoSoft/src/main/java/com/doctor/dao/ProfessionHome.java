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

import com.doctor.persistance.Profession;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Profession.
 * @see com.proddoctor.dao.Profession
 * @author Hibernate Tools
 */
public class ProfessionHome {

	private static Logger log = Logger.getLogger(Profession.class);
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

	public void persist(Profession transientInstance) {
		log.debug("persisting Profession instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Profession instance) {
		log.debug("attaching dirty Profession instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Profession instance) {
		log.debug("attaching clean Profession instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Profession persistentInstance) {
		log.debug("deleting Profession instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Profession merge(Profession detachedInstance) {
		log.debug("merging Profession instance");
		try {
			Profession result = (Profession) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Profession findById(java.lang.Integer id) {
		log.debug("getting Profession instance with id: " + id);
		try {
			Profession instance = (Profession) sessionFactory
					.getCurrentSession().get(Profession.class,
							id);
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
	public List<Profession> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Profession.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Profession>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Profession> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Profession.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Profession> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Profession.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}

	public List<Profession> findByExample(Profession instance) {
		log.debug("finding Profession instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Profession> results = (List<Profession>) sessionFactory
					.getCurrentSession()
					.createCriteria(Profession.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public Profession findByProfession(String profession) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Profession.class)
				.add(Restrictions.eq("libprofession", profession));
		Profession p=(Profession) criteria.uniqueResult();
		
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Profession> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Profession.class)
				.add(Restrictions.like("libprofession", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list() ;
	}
}
