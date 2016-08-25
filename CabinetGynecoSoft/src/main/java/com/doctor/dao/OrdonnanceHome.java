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

import com.doctor.persistance.Ordonnance;

/**
 * Home object for domain model class Ordonnance.
 * 
 * @see com.proddoctor.dao.Ordonnance
 * @author Hibernate Tools
 */
public class OrdonnanceHome {

	private static Logger log = Logger.getLogger(OrdonnanceHome.class);

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

	public void persist(Ordonnance transientInstance) {
		log.debug("persisting Ordonnance instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ordonnance instance) {
		log.debug("attaching dirty Ordonnance instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Ordonnance instance) {
		log.debug("attaching clean Ordonnance instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ordonnance persistentInstance) {
		log.debug("deleting Ordonnance instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ordonnance merge(Ordonnance detachedInstance) {
		log.debug("merging Ordonnance instance");
		try {
			Ordonnance result = (Ordonnance) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ordonnance findById(java.lang.Integer id) {
		log.debug("getting Ordonnance instance with id: " + id);
		try {
			Ordonnance instance = (Ordonnance) sessionFactory
					.getCurrentSession().get(Ordonnance.class, id);
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
	public List<Ordonnance> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ordonnance.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<Ordonnance>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Ordonnance> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Ordonnance.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Ordonnance> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Ordonnance.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Ordonnance> findByExample(Ordonnance instance) {
		log.debug("finding Ordonnance instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Ordonnance> results = (List<Ordonnance>) sessionFactory
					.getCurrentSession().createCriteria(Ordonnance.class)
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
	public List<Ordonnance> findByPatient(Integer cl, Date dd, Date df,
			Integer med) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ordonnance.class, "ord")
				.addOrder(Property.forName("dateOrd").desc());
		if (dd != null)
			crit.add(Restrictions.ge("dateOrd", dd));

		if (df != null)
			crit.add(Restrictions.le("dateOrd", df));

		if (med != null) {
			crit.createAlias("ord.medOrds", "medOrd")
					.createAlias("medOrd.medicament", "medic")
					.add(Restrictions.eq("medic.idMedicament", med));
		}

		if (cl != null) {
			crit.createAlias("ord.patient", "cfc").add(
					Restrictions.eq("cfc.code", cl));

		} else
			crit.createAlias("ord.consult", "cons")
					.createAlias("cons.cfclient", "pat")
					.add(Restrictions.eq("pat.code", cl));

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Ordonnance> findByConsultation(Integer cl) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ordonnance.class)
				//.setFetchMode("medOrds", FetchMode.JOIN)
				.setFetchMode("consult", FetchMode.JOIN)
				.createCriteria("consult")
				.add(Restrictions.eq("idConsultationDetail", cl));

		return crit.list();
	}

	public Ordonnance findByIdOrd(Integer idOrdonnance) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ordonnance.class)
				.add(Restrictions.eq("idOrdonnance", idOrdonnance))
				.setFetchMode("medOrds", FetchMode.JOIN)
				.setFetchMode("consult", FetchMode.JOIN);

		return (Ordonnance) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Ordonnance> findByPatient(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ordonnance.class)
				.setFetchMode("patient", FetchMode.JOIN)
				.createCriteria("patient").add(Restrictions.eq("code", id));

		return crit.list();

	}

	@SuppressWarnings("unchecked")
	public List<Ordonnance> findLibreByPatient(Integer idPatient, String type) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ordonnance.class)
				.add(Restrictions.eq("type", type))
				.setFetchMode("patient", FetchMode.JOIN)
				.createCriteria("patient")
				.add(Restrictions.eq("code", idPatient));

		return crit.list();

	}

}
