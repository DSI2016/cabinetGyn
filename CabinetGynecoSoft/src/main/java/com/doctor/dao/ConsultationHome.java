package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Consultation;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Consultation.
 * @see com.proddoctor.dao.Consultation
 * @author Hibernate Tools
 */
public class ConsultationHome {

	private static Logger log = Logger.getLogger(ConsultationHome.class);

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
	public void persist(Consultation transientInstance) {
		log.debug("persisting Consultation instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Consultation instance) {
		log.debug("attaching dirty Consultation instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Consultation instance) {
		log.debug("attaching clean Consultation instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Consultation persistentInstance) {
		log.debug("deleting Consultation instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Consultation merge(Consultation detachedInstance) {
		log.debug("merging Consultation instance");
		try {
			Consultation result = (Consultation) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Consultation findById(java.lang.Integer id) {
		log.debug("getting Consultation instance with id: " + id);
		try {
			Consultation instance = (Consultation) sessionFactory.getCurrentSession().get(
					Consultation.class, id);
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
	public List<Consultation> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Consultation.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Consultation>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Consultation> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Consultation.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Consultation> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Consultation.class);
		
		return (List<Consultation>)crit.list();
		}
	
	public List<Consultation> findByExample(Consultation instance) {
		log.debug("finding Consultation instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Consultation> results = (List<Consultation>) sessionFactory
					.getCurrentSession()
					.createCriteria(Consultation.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public Consultation findByConsult(String motifCons) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Consultation.class)
				.add(Restrictions.eq("nomConsultation", motifCons));
		return (Consultation) crit.uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Consultation> findByActive(boolean a) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Consultation.class)
				.add(Restrictions.eq("active", a));
		return crit.list();
	}
	
	
}