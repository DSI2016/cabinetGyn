package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.RendezVous;

/**
 * Home object for domain model class RendezVous.
 * 
 * @see com.proddoctor.dao.RendezVous
 * @author Hibernate Tools
 */
public class RendezVousHome {

	private static Logger log = Logger.getLogger(RendezVousHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			// return (SessionFactory) new
			// InitialContext().lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RendezVous transientInstance) {
		log.debug("persisting RendezVous instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RendezVous instance) {
		log.debug("attaching dirty RendezVous instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(RendezVous instance) {
		log.debug("attaching clean RendezVous instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RendezVous persistentInstance) {
		log.debug("deleting RendezVous instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RendezVous merge(RendezVous detachedInstance) {
		log.debug("merging RendezVous instance");
		try {
			RendezVous result = (RendezVous) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RendezVous findById(java.lang.Integer id) {
		log.debug("getting RendezVous instance with id: " + id);
		try {
			RendezVous instance = (RendezVous) sessionFactory
					.getCurrentSession().get(RendezVous.class, id);
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
	public List<RendezVous> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(RendezVous.class)
				.setFetchMode(param, FetchMode.JOIN)
				.addOrder(Property.forName("date").asc());
		return (List<RendezVous>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<RendezVous> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				RendezVous.class);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<RendezVous> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				RendezVous.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<RendezVous> findByExample(RendezVous instance) {
		log.debug("finding RendezVous instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<RendezVous> results = (List<RendezVous>) sessionFactory
					.getCurrentSession().createCriteria(RendezVous.class)
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
	public List<RendezVous> findAllByPatient(Cfclient obj) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(RendezVous.class)
				.add(Restrictions.eq("codeclient", obj.getCode()));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<RendezVous> findByPatient(Integer id) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(RendezVous.class)
				.setFetchMode("codeclient", FetchMode.JOIN)
				.createCriteria("codeclient").add(Restrictions.eq("code", id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<RendezVous> findAllWithPatient(Integer codeclient, Date date) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(RendezVous.class)
				.add(Restrictions.gt("date", date))
				.setFetchMode("codeclient", FetchMode.JOIN)
				.createCriteria("codeclient")
				.add(Restrictions.eq("code", codeclient));
		return criteria.list();
	}

}
