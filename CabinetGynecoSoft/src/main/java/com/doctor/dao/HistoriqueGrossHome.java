package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.HistoriqueGross;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class HistoriqueGross.
 * @see com.proddoctor.dao.HistoriqueGross
 * @author Hibernate Tools
 */
public class HistoriqueGrossHome {

	private static Logger log = Logger.getLogger(HistoriqueGrossHome.class);

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
	public void persist(HistoriqueGross transientInstance) {
		log.debug("persisting HistoriqueGross instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HistoriqueGross instance) {
		log.debug("attaching dirty HistoriqueGross instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(HistoriqueGross instance) {
		log.debug("attaching clean HistoriqueGross instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HistoriqueGross persistentInstance) {
		log.debug("deleting HistoriqueGross instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HistoriqueGross merge(HistoriqueGross detachedInstance) {
		log.debug("merging HistoriqueGross instance");
		try {
			HistoriqueGross result = (HistoriqueGross) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HistoriqueGross findById(java.lang.Integer id) {
		log.debug("getting HistoriqueGross instance with id: " + id);
		try {
			HistoriqueGross instance = (HistoriqueGross) sessionFactory.getCurrentSession().get(
					HistoriqueGross.class, id);
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
	public List<HistoriqueGross> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueGross.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<HistoriqueGross>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<HistoriqueGross> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(HistoriqueGross.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<HistoriqueGross> findAll () {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueGross.class);
		
		return (List<HistoriqueGross>)crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<HistoriqueGross>findHistoriquePatient(Integer code){
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueGross.class)
				.setFetchMode("etatBebe", FetchMode.JOIN)
				.setFetchMode("etatFinGross", FetchMode.JOIN)
				.setFetchMode("cfclient",FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", code));
		
		return (List<HistoriqueGross>)crit.list();
	}
	
	
	
	public List<HistoriqueGross> findByExample(HistoriqueGross instance) {
		log.debug("finding HistoriqueGross instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<HistoriqueGross> results = (List<HistoriqueGross>) sessionFactory
					.getCurrentSession()
					.createCriteria(HistoriqueGross.class)
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
	public List<HistoriqueGross> findHistoriqueByEtatBebe(Integer idEtat) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueGross.class)
				.setFetchMode("etatBebe", FetchMode.JOIN)
				.createCriteria("etatBebe")
				.add(Restrictions.eq("idetatBebe", idEtat));
		
		return (List<HistoriqueGross>)crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<HistoriqueGross> findHistoriqueByIdCons(Integer idcons) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueGross.class)
				.add(Restrictions.eq("idcons", idcons));
		
		return (List<HistoriqueGross>)crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<HistoriqueGross> findHistoriqueByEtatGross(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueGross.class)
					.setFetchMode("etatFinGross", FetchMode.JOIN)
				.createCriteria("etatFinGross")
				.add(Restrictions.eq("idEtatFinGross", id));
		
		return (List<HistoriqueGross>)crit.list();
	}


}
