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

import com.doctor.persistance.EtatBebe;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class EtatBebe.
 * @see com.proddoctor.dao.EtatBebe
 * @author Hibernate Tools
 */
public class EtatBebeHome {

	private static Logger log = Logger.getLogger(EtatBebeHome.class);

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
	
	
	public void persist(EtatBebe transientInstance) {
		log.debug("persisting EtatBebe instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	
	public void attachDirty(EtatBebe instance) {
		log.debug("attaching dirty EtatBebe instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(EtatBebe instance) {
		log.debug("attaching clean EtatBebe instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EtatBebe persistentInstance) {
		log.debug("deleting EtatBebe instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EtatBebe merge(EtatBebe detachedInstance) {
		log.debug("merging EtatBebe instance");
		try {
			EtatBebe result = (EtatBebe) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EtatBebe findById(java.lang.Integer id) {
		log.debug("getting EtatBebe instance with id: " + id);
		try {
			EtatBebe instance = (EtatBebe) sessionFactory.getCurrentSession().get(
					EtatBebe.class, id);
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
	public List<EtatBebe> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(EtatBebe.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<EtatBebe>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<EtatBebe> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(EtatBebe.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<EtatBebe> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(EtatBebe.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<EtatBebe> findByExample(EtatBebe instance) {
		log.debug("finding EtatBebe instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<EtatBebe> results = (List<EtatBebe>) sessionFactory
					.getCurrentSession()
					.createCriteria(EtatBebe.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		
	}
	
	public EtatBebe findByEtatBebe(String etatBebe) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(EtatBebe.class)
				.add(Restrictions.eq("etatBebe", etatBebe));
		EtatBebe v=(EtatBebe) criteria.uniqueResult();
	
		return v;
	}


	@SuppressWarnings("unchecked")
	public List<EtatBebe> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(EtatBebe.class)
				.add(Restrictions.like("etatBebe", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list() ;
	}
}
