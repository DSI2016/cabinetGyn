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

import com.doctor.persistance.Symptome;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Symptome.
 * @see com.proddoctor.dao.Symptome
 * @author Hibernate Tools
 */
public class SymptomeHome {

	private static Logger log = Logger.getLogger(SymptomeHome.class);

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
	
	
	public void persist(Symptome transientInstance) {
		log.debug("persisting Symptome instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	
	public void attachDirty(Symptome instance) {
		log.debug("attaching dirty Symptome instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Symptome instance) {
		log.debug("attaching clean Symptome instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Symptome persistentInstance) {
		log.debug("deleting Symptome instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Symptome merge(Symptome detachedInstance) {
		log.debug("merging Symptome instance");
		try {
			Symptome result = (Symptome) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Symptome findById(java.lang.Integer id) {
		log.debug("getting Symptome instance with id: " + id);
		try {
			Symptome instance = (Symptome) sessionFactory.getCurrentSession().get(
					Symptome.class, id);
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
	public List<Symptome> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Symptome.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Symptome>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Symptome> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Symptome.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Symptome> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Symptome.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<Symptome> findByExample(Symptome instance) {
		log.debug("finding Symptome instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Symptome> results = (List<Symptome>) sessionFactory
					.getCurrentSession()
					.createCriteria(Symptome.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		
	}
	
	public Symptome findBySymptome(String symptome) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Symptome.class)
				.add(Restrictions.eq("symptome", symptome));
		Symptome v=(Symptome) criteria.uniqueResult();
		
		return v;
	}


	@SuppressWarnings("unchecked")
	public List<Symptome> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Symptome.class)
				.add(Restrictions.like("symptome", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list() ;
	}
}
