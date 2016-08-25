package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Clinique;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Clinique.
 * @see com.proddoctor.dao.Clinique
 * @author Hibernate Tools
 */
public class CliniqueHome {

	private static Logger log = Logger.getLogger(CliniqueHome.class);

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
	public void persist(Clinique transientInstance) {
		log.debug("persisting Clinique instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Clinique instance) {
		log.debug("attaching dirty Clinique instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Clinique instance) {
		log.debug("attaching clean Clinique instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Clinique persistentInstance) {
		log.debug("deleting Clinique instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clinique merge(Clinique detachedInstance) {
		log.debug("merging Clinique instance");
		try {
			Clinique result = (Clinique) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Clinique findById(java.lang.Integer id) {
		log.debug("getting Clinique instance with id: " + id);
		try {
			Clinique instance = (Clinique) sessionFactory.getCurrentSession().get(
					Clinique.class, id);
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
	public List<Clinique> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Clinique.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Clinique>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Clinique> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Clinique.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Clinique> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Clinique.class);
		
		return (List<Clinique>)crit.list();
		}
	
	public List<Clinique> findByExample(Clinique instance) {
		log.debug("finding Clinique instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Clinique> results = (List<Clinique>) sessionFactory
					.getCurrentSession()
					.createCriteria(Clinique.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	
	public Clinique findByClinique(String libclinique) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Clinique.class)
				.add(Restrictions.eq("libclinique", libclinique));
		Clinique c=(Clinique) criteria.uniqueResult();
		
		return c;
	}
	@SuppressWarnings("unchecked")
	public List<Clinique> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Clinique.class)
				.add(Restrictions.like("libclinique", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list();
	}
}