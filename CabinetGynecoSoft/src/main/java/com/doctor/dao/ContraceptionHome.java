package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Contraception;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Contraception.
 * @see com.proddoctor.dao.Contraception
 * @author Hibernate Tools
 */
public class ContraceptionHome {

	private static Logger log = Logger.getLogger(ContraceptionHome.class);

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
	public void persist(Contraception transientInstance) {
		log.debug("persisting Contraception instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Contraception instance) {
		log.debug("attaching dirty Contraception instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Contraception instance) {
		log.debug("attaching clean Contraception instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Contraception persistentInstance) {
		log.debug("deleting Contraception instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contraception merge(Contraception detachedInstance) {
		log.debug("merging Contraception instance");
		try {
			Contraception result = (Contraception) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Contraception findById(java.lang.Integer id) {
		log.debug("getting Contraception instance with id: " + id);
		try {
			Contraception instance = (Contraception) sessionFactory.getCurrentSession().get(
					Contraception.class, id);
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
	public List<Contraception> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Contraception.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Contraception>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Contraception> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Contraception.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Contraception> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Contraception.class);
		
		return (List<Contraception>)crit.list();
		}
	
	public List<Contraception> findByExample(Contraception instance) {
		log.debug("finding Contraception instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Contraception> results = (List<Contraception>) sessionFactory
					.getCurrentSession()
					.createCriteria(Contraception.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public Contraception findSterilPatient(Integer code) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Contraception.class)
				.setFetchMode("cfclient",FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", code));
		
		return (Contraception) crit.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Contraception> findContraceptionPatient(Integer code) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Contraception.class)
				.setFetchMode("cfclient",FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", code));
		
		return (List<Contraception>)crit.list();
	}
}