package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Lettre;

public class LettreHome {

	private static Logger log = Logger.getLogger(LettreHome.class);

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

	public void persist(Lettre transientInstance) {
		log.debug("persisting Lettre instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Lettre> findAllWithFilter(String valeurRecherche) {

		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Lettre.class)
				.add(Restrictions.like("nomLettre", valeurRecherche,
						MatchMode.ANYWHERE));

		return crit.list();
	}

	public void attachDirty(Lettre instance) {
		log.debug("attaching dirty Lettre instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Lettre instance) {
		log.debug("attaching clean Lettre instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Lettre persistentInstance) {
		log.debug("deleting Lettre instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Lettre merge(Lettre detachedInstance) {
		log.debug("merging Lettre instance");
		try {
			Lettre result = (Lettre) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Lettre findById(java.lang.Integer id) {
		log.debug("getting Lettre instance with id: " + id);
		try {
			Lettre instance = (Lettre) sessionFactory.getCurrentSession().get(
					Lettre.class, id);
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

	public Lettre findByLettre(String Lettre) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Lettre.class)
				.add(Restrictions.eq("nomLettre", Lettre));
		Lettre anal = (Lettre) criteria.uniqueResult();

		return (anal);
	}

	@SuppressWarnings("unchecked")
	public List<Lettre> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Lettre.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Lettre> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Lettre.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Lettre> findByExample(Lettre instance) {
		log.debug("finding Lettre instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Lettre> results = (List<Lettre>) sessionFactory
					.getCurrentSession().createCriteria(Lettre.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public Lettre findByMotif(String motifLettre) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Lettre.class)
				.add(Restrictions.eq("nomLettre", motifLettre));

		return (Lettre) crit.uniqueResult();
	}

}
