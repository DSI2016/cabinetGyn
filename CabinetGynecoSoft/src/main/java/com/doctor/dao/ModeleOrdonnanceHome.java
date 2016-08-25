package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.ModeleOrdonnance;

public class ModeleOrdonnanceHome {
	private static Logger log = Logger.getLogger(ModeleOrdonnanceHome.class);

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

	public void persist(ModeleOrdonnance transientInstance) {
		log.debug("persisting ModeleOrdonnance instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ModeleOrdonnance instance) {
		log.debug("attaching dirty ModeleOrdonnance instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ModeleOrdonnance instance) {
		log.debug("attaching clean ModeleOrdonnance instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ModeleOrdonnance persistentInstance) {
		log.debug("deleting ModeleOrdonnance instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ModeleOrdonnance merge(ModeleOrdonnance detachedInstance) {
		log.debug("merging ModeleOrdonnance instance");
		try {
			ModeleOrdonnance result = (ModeleOrdonnance) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ModeleOrdonnance findById(java.lang.Integer id) {
		log.debug("getting ModeleOrdonnance instance with id: " + id);
		try {
			ModeleOrdonnance instance = (ModeleOrdonnance) sessionFactory
					.getCurrentSession().get(ModeleOrdonnance.class, id);
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
	public List<ModeleOrdonnance> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ModeleOrdonnance.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<ModeleOrdonnance>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<ModeleOrdonnance> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				ModeleOrdonnance.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<ModeleOrdonnance> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				ModeleOrdonnance.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<ModeleOrdonnance> findByExample(ModeleOrdonnance instance) {
		log.debug("finding ModeleOrdonnance instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<ModeleOrdonnance> results = (List<ModeleOrdonnance>) sessionFactory
					.getCurrentSession().createCriteria(ModeleOrdonnance.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public ModeleOrdonnance findByModeleOrdonnance(String modeleOrdonnance) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(ModeleOrdonnance.class)
				.add(Restrictions.eq("nomModele", modeleOrdonnance));
		ModeleOrdonnance v = (ModeleOrdonnance) criteria.uniqueResult();

		return v;
	}

	public ModeleOrdonnance findByIdModeleOrdonnanceWithJoin(Integer idMO) {

		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(ModeleOrdonnance.class)
				.add(Restrictions.eq("idModeleOrdonnance", idMO))
				.setFetchMode("medOrds", FetchMode.JOIN)
				;

		return (ModeleOrdonnance) criteria.uniqueResult();
	}

}
