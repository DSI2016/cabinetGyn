package com.doctor.dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Cabinet;




import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Cabinet.
 * @see com.proddoctor.dao.Cabinet
 * @author Hibernate Tools
 */
public class CabinetHome {

	private static Logger log = Logger.getLogger(CabinetHome.class);

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
	}	public void persist(Cabinet transientInstance) {
		log.debug("persisting Cabinet instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Cabinet> findAllWithFilter(String valeurRecherche) {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Cabinet.class).add(Restrictions.like("libCabinet", valeurRecherche, MatchMode.ANYWHERE));
		
		return crit.list();
	}

	public void attachDirty(Cabinet instance) {
		log.debug("attaching dirty Cabinet instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Cabinet instance) {
		log.debug("attaching clean Cabinet instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cabinet persistentInstance) {
		log.debug("deleting Cabinet instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cabinet merge(Cabinet detachedInstance) {
		log.debug("merging Cabinet instance");
		try {
			Cabinet result = (Cabinet) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cabinet findById(java.lang.Integer id) {
		log.debug("getting Cabinet instance with id: " + id);
		try {
			Cabinet instance = (Cabinet) sessionFactory.getCurrentSession().get(
					Cabinet.class, id);
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
	
	public Cabinet findByCabinet(String cabinet) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Cabinet.class)
				.add(Restrictions.eq("libCabinet", cabinet));
		Cabinet anal =(Cabinet) criteria.uniqueResult();
		
		return(anal);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cabinet> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Cabinet.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<Cabinet> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Cabinet.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<Cabinet> findByExample(Cabinet instance) {
		log.debug("finding Cabinet instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Cabinet> results = (List<Cabinet>) sessionFactory
					.getCurrentSession()
					.createCriteria(Cabinet.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		
	}
	
	
}
