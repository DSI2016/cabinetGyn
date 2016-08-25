package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.HistoriquePatient;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class HistoriquePatient.
 * 
 * @see com.proddoctor.dao.HistoriquePatient
 * @author Hibernate Tools
 */
public class HistoriquePatientHome {

	private static Logger log = Logger.getLogger(HistoriquePatientHome.class);

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

	public void persist(HistoriquePatient transientInstance) {
		log.debug("persisting HistoriquePatient instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HistoriquePatient instance) {
		log.debug("attaching dirty HistoriquePatient instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(HistoriquePatient instance) {
		log.debug("attaching clean HistoriquePatient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HistoriquePatient persistentInstance) {
		log.debug("deleting HistoriquePatient instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HistoriquePatient merge(HistoriquePatient detachedInstance) {
		log.debug("merging HistoriquePatient instance");
		try {
			HistoriquePatient result = (HistoriquePatient) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HistoriquePatient findById(java.lang.Integer id) {
		log.debug("getting HistoriquePatient instance with id: " + id);
		try {
			HistoriquePatient instance = (HistoriquePatient) sessionFactory
					.getCurrentSession().get(HistoriquePatient.class, id);
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
	public List<HistoriquePatient> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriquePatient.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<HistoriquePatient>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<HistoriquePatient> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				HistoriquePatient.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<HistoriquePatient> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriquePatient.class);

		return (List<HistoriquePatient>) crit.list();
	}

	public List<HistoriquePatient> findByExample(HistoriquePatient instance) {
		log.debug("finding HistoriquePatient instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<HistoriquePatient> results = (List<HistoriquePatient>) sessionFactory
					.getCurrentSession()
					.createCriteria(HistoriquePatient.class)
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
	public List<HistoriquePatient> findHistoriquePatient(Integer code) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriquePatient.class)
				.setFetchMode("cfclient", FetchMode.JOIN)
				.addOrder(Property.forName("idhistoriquePatient").desc())
				.createCriteria("cfclient").add(Restrictions.eq("code", code))
				;

		return (List<HistoriquePatient>) crit.list();
	}
}