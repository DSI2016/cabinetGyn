package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.MedOrd;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MedOrd.
 * 
 * @see com.proddoctor.dao.MedOrd
 * @author Hibernate Tools
 */
public class MedOrdHome {

	private static Logger log = Logger.getLogger(MedOrdHome.class);

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

	public void persist(MedOrd transientInstance) {
		log.debug("persisting MedOrd instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MedOrd instance) {
		log.debug("attaching dirty MedOrd instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(MedOrd instance) {
		log.debug("attaching clean MedOrd instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MedOrd persistentInstance) {
		log.debug("deleting MedOrd instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MedOrd merge(MedOrd detachedInstance) {
		log.debug("merging MedOrd instance");
		try {
			MedOrd result = (MedOrd) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MedOrd findByMedOrd(String a) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(MedOrd.class)
				.add(Restrictions.eq("designation", a));
		MedOrd anal = (MedOrd) criteria.uniqueResult();

		return (anal);
	}

	public MedOrd findById(java.lang.Integer id) {
		log.debug("getting MedOrd instance with id: " + id);
		try {
			MedOrd instance = (MedOrd) sessionFactory.getCurrentSession().get(
					MedOrd.class, id);
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
	public List<MedOrd> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(MedOrd.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<MedOrd>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<MedOrd> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				MedOrd.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<MedOrd> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				MedOrd.class);

		return (List<MedOrd>) crit.list();
	}

	public List<MedOrd> findByExample(MedOrd instance) {
		log.debug("finding MedOrd instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<MedOrd> results = (List<MedOrd>) sessionFactory
					.getCurrentSession().createCriteria(MedOrd.class)
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
	public List<MedOrd> findByOrd(Integer idOrdonnance) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(MedOrd.class)
				.setFetchMode("medicament", FetchMode.JOIN)
				.setFetchMode("ordonnance", FetchMode.JOIN)
				.createCriteria("ordonnance")
				.add(Restrictions.eq("idOrdonnance", idOrdonnance));

		return (List<MedOrd>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<MedOrd> findByModele(Integer idModele) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(MedOrd.class)
				.setFetchMode("medicament", FetchMode.JOIN)
				.setFetchMode("modeleOrdonnance", FetchMode.JOIN)
				.createCriteria("modeleOrdonnance")
				.add(Restrictions.eq("idModeleOrdonnance", idModele));

		return (List<MedOrd>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<MedOrd> findByMedicament(Integer code) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(MedOrd.class)
				.setFetchMode("medicament", FetchMode.JOIN)
				.createCriteria("medicament")
				.add(Restrictions.eq("idMedicament", code));
		return (List<MedOrd>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<MedOrd> findByModel(Integer idModeleOrd) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(MedOrd.class)
				.setFetchMode("modeleOrdonnance", FetchMode.JOIN)
				.createCriteria("modeleOrdonnance")
				.add(Restrictions.eq("idModeleOrdonnance", idModeleOrd))
				;
		return (List<MedOrd>) crit.list();
	}
}