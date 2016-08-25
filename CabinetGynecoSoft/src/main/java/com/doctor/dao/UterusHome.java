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

import com.doctor.persistance.Uterus;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Uterus.
 * @see com.proddoctor.dao.Uterus
 * @author Hibernate Tools
 */
public class UterusHome {

	private static Logger log = Logger.getLogger(UterusHome.class);

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
	
	
	public void persist(Uterus transientInstance) {
		log.debug("persisting Uterus instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	
	public void attachDirty(Uterus instance) {
		log.debug("attaching dirty Uterus instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Uterus instance) {
		log.debug("attaching clean Uterus instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Uterus persistentInstance) {
		log.debug("deleting Uterus instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Uterus merge(Uterus detachedInstance) {
		log.debug("merging Uterus instance");
		try {
			Uterus result = (Uterus) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Uterus findById(java.lang.Integer id) {
		log.debug("getting Uterus instance with id: " + id);
		try {
			Uterus instance = (Uterus) sessionFactory.getCurrentSession().get(
					Uterus.class, id);
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
	public List<Uterus> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Uterus.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Uterus>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Uterus> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Uterus.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Uterus> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Uterus.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<Uterus> findByExample(Uterus instance) {
		log.debug("finding Uterus instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Uterus> results = (List<Uterus>) sessionFactory
					.getCurrentSession()
					.createCriteria(Uterus.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		
	}
	
	public Uterus findByUterus(String uterus) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Uterus.class)
				.add(Restrictions.eq("uterus", uterus));
		Uterus v=(Uterus) criteria.uniqueResult();
		
		return v;
	}


	@SuppressWarnings("unchecked")
	public List<Uterus> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Uterus.class)
				.add(Restrictions.like("uterus", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list() ;
	}
}
