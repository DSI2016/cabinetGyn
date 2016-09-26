package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Radio;

/**
 * Home object for domain model class Radio.
 * 
 * @see com.proddoctor.dao.Radio
 * @author Hibernate Tools
 */
public class RadioHome {

	private static Logger log = Logger.getLogger(RadioHome.class);

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

	public void persist(Radio transientInstance) {
		log.debug("persisting Radio instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Radio instance) {
		log.debug("attaching dirty Radio instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Radio instance) {
		log.debug("attaching clean Radio instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Radio persistentInstance) {
		log.debug("deleting Radio instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Radio merge(Radio detachedInstance) {
		log.debug("merging Radio instance");
		try {
			Radio result = (Radio) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Radio findById(java.lang.Integer id) {
		log.debug("getting Radio instance with id: " + id);
		try {
			Radio instance = (Radio) sessionFactory.getCurrentSession().get(
					Radio.class, id);
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
	public List<Radio> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Radio.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<Radio>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Radio> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Radio.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Radio> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Radio.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Radio> findByExample(Radio instance) {
		log.debug("finding Radio instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Radio> results = (List<Radio>) sessionFactory
					.getCurrentSession().createCriteria(Radio.class)
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
	public List<Radio> findByConsultation(Integer idconsultationDetail) {
		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Radio.class)
				.addOrder(Property.forName("idradio").desc())
				.setFetchMode("consultationDetail", FetchMode.JOIN)
				.createCriteria("consultationDetail")
				.add(Restrictions.eq("idConsultationDetail",
						idconsultationDetail));		
		

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Radio> findByPatient(Integer idPatient) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Radio.class)
				.addOrder(Property.forName("dateRadios").desc())
				.setFetchMode("consultationDetail", FetchMode.JOIN)
				.createCriteria("consultationDetail")
				.setFetchMode("cfclient", FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", idPatient));

		return crit.list();
	}

	public Radio findByIdWithJoin(Integer idradio) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Radio.class)
				.add(Restrictions.eq("idradio", idradio))
				.setFetchMode("consultationDetail", FetchMode.JOIN)
				.setFetchMode("patient", FetchMode.JOIN);
		return (Radio) crit.uniqueResult();
	}

}
