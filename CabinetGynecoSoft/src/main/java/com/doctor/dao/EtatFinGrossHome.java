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

import com.doctor.persistance.EtatFinGross;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class EtatFinGross.
 * @see com.proddoctor.dao.EtatFinGross
 * @author Hibernate Tools
 */
public class EtatFinGrossHome {

	private static Logger log = Logger.getLogger(EtatFinGrossHome.class);

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
	
	
	public void persist(EtatFinGross transientInstance) {
		log.debug("persisting EtatFinGross instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	
	public void attachDirty(EtatFinGross instance) {
		log.debug("attaching dirty EtatFinGross instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(EtatFinGross instance) {
		log.debug("attaching clean EtatFinGross instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EtatFinGross persistentInstance) {
		log.debug("deleting EtatFinGross instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EtatFinGross merge(EtatFinGross detachedInstance) {
		log.debug("merging EtatFinGross instance");
		try {
			EtatFinGross result = (EtatFinGross) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EtatFinGross findById(java.lang.Integer id) {
		log.debug("getting EtatFinGross instance with id: " + id);
		try {
			EtatFinGross instance = (EtatFinGross) sessionFactory.getCurrentSession().get(
					EtatFinGross.class, id);
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
	public List<EtatFinGross> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(EtatFinGross.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<EtatFinGross>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<EtatFinGross> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(EtatFinGross.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<EtatFinGross> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(EtatFinGross.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<EtatFinGross> findByExample(EtatFinGross instance) {
		log.debug("finding EtatFinGross instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<EtatFinGross> results = (List<EtatFinGross>) sessionFactory
					.getCurrentSession()
					.createCriteria(EtatFinGross.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		
	}
	
	public EtatFinGross findByEtatFinGross(String etatFinG) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(EtatFinGross.class)
				.add(Restrictions.eq("etatFinG", etatFinG));
		EtatFinGross v=(EtatFinGross) criteria.uniqueResult();
		
		return v;
	}


	@SuppressWarnings("unchecked")
	public List<EtatFinGross> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(EtatFinGross.class)
				.add(Restrictions.like("etatFinG", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list() ;
	}
}
