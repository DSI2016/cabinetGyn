package com.doctor.dao;

// Generated 18 ao�t 2014 14:11:58 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Saison;

/**
 * Home object for domain model class Doctor.
 * 
 * @see com.SaisonDocteur.dao.Doctor
 * @author Hibernate Tools
 */
public class SaisonHome {

	private static Logger log = Logger.getLogger(SaisonHome.class);

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

	public void persist(Saison transientInstance) {
		log.debug("persisting  instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Saison instance) {
		log.debug("attaching dirty Saison instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Saison instance) {
		log.debug("attaching clean Doctor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Saison persistentInstance) {
		log.debug("deleting Doctor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Saison merge(Saison detachedInstance) {
		log.debug("merging Doctor instance");
		try {
			Saison result = (Saison) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Saison findById(java.lang.Integer id) {
		log.debug("getting Doctor instance with id: " + id);
		try {
			Saison instance = (Saison) sessionFactory.getCurrentSession().get(
					Saison.class, id);
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
	public List<Saison> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Saison.class);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Saison> findAllWithJoin() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Saison.class)
				.setFetchMode("lun", FetchMode.JOIN)
				.setFetchMode("mar", FetchMode.JOIN)
				.setFetchMode("mer", FetchMode.JOIN)
				.setFetchMode("jeu", FetchMode.JOIN)
				.setFetchMode("ven", FetchMode.JOIN)
				.setFetchMode("sam", FetchMode.JOIN)
				.setFetchMode("dim", FetchMode.JOIN);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Saison> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Saison.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Saison> findByExample(Saison instance) {
		log.debug("finding Doctor instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Saison> results = (List<Saison>) sessionFactory
					.getCurrentSession().createCriteria(Saison.class)
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
	public List<Saison> findAllWithDate(Date selected, String jour) {
		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Saison.class)
				.add(Restrictions.and(Restrictions.le("debut", selected),
						Restrictions.ge("fin", selected)))
				.setFetchMode(jour, FetchMode.JOIN)
				.createCriteria(jour)
				.setFetchMode("horaire", FetchMode.JOIN);

		return crit.list();
	}

}
