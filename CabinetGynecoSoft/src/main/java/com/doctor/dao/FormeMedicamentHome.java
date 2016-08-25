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

import com.doctor.persistance.FormeMedicament;


public class FormeMedicamentHome {
	private static Logger log = Logger.getLogger(FormeMedicamentHome.class);

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
	}	public void persist(FormeMedicament transientInstance) {
		log.debug("persisting FormeMedicament instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FormeMedicament instance) {
		log.debug("attaching dirty FormeMedicament instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(FormeMedicament instance) {
		log.debug("attaching clean FormeMedicament instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FormeMedicament persistentInstance) {
		log.debug("deleting FormeMedicament instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FormeMedicament merge(FormeMedicament detachedInstance) {
		log.debug("merging FormeMedicament instance");
		try {
			FormeMedicament result = (FormeMedicament) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FormeMedicament findById(java.lang.Integer id) {
		log.debug("getting FormeMedicament instance with id: " + id);
		try {
			FormeMedicament instance = (FormeMedicament) sessionFactory.getCurrentSession().get(
					FormeMedicament.class, id);
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
	
	public FormeMedicament findByFormeMedicament(String forme) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(FormeMedicament.class)
				.add(Restrictions.eq("forme", forme));
		FormeMedicament anal =(FormeMedicament) criteria.uniqueResult();
		
		return(anal);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<FormeMedicament> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(FormeMedicament.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<FormeMedicament>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<FormeMedicament> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(FormeMedicament.class);
		
		return crit.list();
		}
	
	
	@SuppressWarnings("unchecked")
	public List<FormeMedicament> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(FormeMedicament.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<FormeMedicament> findByExample(FormeMedicament instance) {
		log.debug("finding FormeMedicament instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<FormeMedicament> results = (List<FormeMedicament>) sessionFactory
					.getCurrentSession()
					.createCriteria(FormeMedicament.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		
		
	}
	@SuppressWarnings("unchecked")
	public List<FormeMedicament> findAllWithFilter(String valeurRecherche) {
	
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(FormeMedicament.class)
				.add(Restrictions.like("forme", valeurRecherche, MatchMode.ANYWHERE));
		return crit.list();
	}
	
	


}
