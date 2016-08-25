package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Certificat;

/**
 * Home object for domain model class Certificat.
 * 
 * @see com.proddoctor.dao.Certificat
 * @author Hibernate Tools
 */
public class CertificatHome {

	private static Logger log = Logger.getLogger(CertificatHome.class);

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

	public void persist(Certificat transientInstance) {
		log.debug("persisting Certificat instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Certificat> findAllWithFilter(String valeurRecherche) {

		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Certificat.class)
				.add(Restrictions.like("nomCertificat", valeurRecherche,
						MatchMode.ANYWHERE));

		return crit.list();
	}

	public void attachDirty(Certificat instance) {
		log.debug("attaching dirty Certificat instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Certificat instance) {
		log.debug("attaching clean Certificat instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Certificat persistentInstance) {
		log.debug("deleting Certificat instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Certificat merge(Certificat detachedInstance) {
		log.debug("merging Certificat instance");
		try {
			Certificat result = (Certificat) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Certificat findById(java.lang.Integer id) {
		log.debug("getting Certificat instance with id: " + id);
		try {
			Certificat instance = (Certificat) sessionFactory
					.getCurrentSession().get(Certificat.class, id);
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

	public Certificat findByCertificat(String certificat) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Certificat.class)
				.add(Restrictions.eq("nomCertificat", certificat));
		Certificat anal = (Certificat) criteria.uniqueResult();

		return (anal);
	}

	@SuppressWarnings("unchecked")
	public List<Certificat> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Certificat.class)
				.setFetchMode("cfclient", FetchMode.JOIN);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Certificat> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Certificat.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Certificat> findByExample(Certificat instance) {
		log.debug("finding Certificat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Certificat> results = (List<Certificat>) sessionFactory
					.getCurrentSession().createCriteria(Certificat.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public Certificat findByMotif(String motifCertificat) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Certificat.class)
				.add(Restrictions.eq("nomCertificat", motifCertificat));

		return (Certificat) crit.uniqueResult();
	}

}
