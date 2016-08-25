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

import com.doctor.persistance.Diagnostique;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Diagnostique.
 * @see com.proddoctor.dao.Diagnostique
 * @author Hibernate Tools
 */
public class DiagnostiqueHome {

	private static Logger log = Logger.getLogger(DiagnostiqueHome.class);

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
	
	
	public void persist(Diagnostique transientInstance) {
		log.debug("persisting Diagnostique instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	
	public void attachDirty(Diagnostique instance) {
		log.debug("attaching dirty Diagnostique instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Diagnostique instance) {
		log.debug("attaching clean Diagnostique instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Diagnostique persistentInstance) {
		log.debug("deleting Diagnostique instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Diagnostique merge(Diagnostique detachedInstance) {
		log.debug("merging Diagnostique instance");
		try {
			Diagnostique result = (Diagnostique) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Diagnostique findById(java.lang.Integer id) {
		log.debug("getting Diagnostique instance with id: " + id);
		try {
			Diagnostique instance = (Diagnostique) sessionFactory.getCurrentSession().get(
					Diagnostique.class, id);
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
	public List<Diagnostique> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Diagnostique.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Diagnostique>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Diagnostique> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Diagnostique.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Diagnostique> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Diagnostique.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<Diagnostique> findByExample(Diagnostique instance) {
		log.debug("finding Diagnostique instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Diagnostique> results = (List<Diagnostique>) sessionFactory
					.getCurrentSession()
					.createCriteria(Diagnostique.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		
	}
	
	public Diagnostique findByDiagnostique(String diagnostique) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Diagnostique.class)
				.add(Restrictions.eq("diagnostique", diagnostique));
		Diagnostique v=(Diagnostique) criteria.uniqueResult();
		
		return v;
	}


	@SuppressWarnings("unchecked")
	public List<Diagnostique> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Diagnostique.class)
				.add(Restrictions.like("diagnostique", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list() ;
	}
}
