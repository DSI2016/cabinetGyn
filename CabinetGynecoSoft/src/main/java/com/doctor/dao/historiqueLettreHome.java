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

import com.doctor.persistance.Lettre;
import com.doctor.persistance.historiqueLettre;
import com.doctor.service.historiqueLettreService;

public class historiqueLettreHome {
	private static Logger log = Logger.getLogger(historiqueLettreService.class);

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

	public void persist(historiqueLettre transientInstance) {
		log.debug("persisting historiqueLettre instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(historiqueLettre instance) {
		log.debug("attaching dirty historiqueLettre instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(historiqueLettre instance) {
		log.debug("attaching clean historiqueLettre instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(historiqueLettre persistentInstance) {
		log.debug("deleting historiqueLettre instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public historiqueLettre merge(historiqueLettre detachedInstance) {
		log.debug("merging historiqueLettre instance");
		try {
			historiqueLettre result = (historiqueLettre) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public historiqueLettre findById(java.lang.Integer id) {
		log.debug("getting historiqueLettre instance with id: " + id);
		try {
			historiqueLettre instance = (historiqueLettre) sessionFactory
					.getCurrentSession().get(historiqueLettre.class, id);
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
	public List<historiqueLettre> findAllSanscondition() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(historiqueLettre.class)
				.setFetchMode("lettre", FetchMode.JOIN)
				.setFetchMode("cfclient", FetchMode.JOIN);

		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<historiqueLettre> findAll(Integer idP) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(historiqueLettre.class)
				.addOrder(Property.forName("idHistoriquelettre").desc())
				.setFetchMode("lettre", FetchMode.JOIN)
				.setFetchMode("cfclient", FetchMode.JOIN)
				.createCriteria("cfclient").add(Restrictions.eq("code", idP));

		return crit.list();
	}

	public Lettre findByMotif(String motifLettre) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Lettre.class)
				.add(Restrictions.eq("nomLettre", motifLettre));

		return (Lettre) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<historiqueLettre> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				historiqueLettre.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<historiqueLettre> findByExample(historiqueLettre instance) {
		log.debug("finding historiqueLettre instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<historiqueLettre> results = (List<historiqueLettre>) sessionFactory
					.getCurrentSession().createCriteria(historiqueLettre.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

}
