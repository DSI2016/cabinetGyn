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
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.HistoriqueCertif;

/**
 * Home object for domain model class HistoriqueCertif.
 * 
 * @see com.proddoctor.dao.HistoriqueCertif
 * @author Hibernate Tools
 */
public class HistoriqueCertifHome {

	private static Logger log = Logger.getLogger(HistoriqueCertifHome.class);

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

	public void persist(HistoriqueCertif transientInstance) {
		log.debug("persisting HistoriqueCertif instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<HistoriqueCertif> findAllWithFilter(String valeurRecherche) {

		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(HistoriqueCertif.class)
				.add(Restrictions.like("libHistoriqueCertif", valeurRecherche,
						MatchMode.ANYWHERE));

		return crit.list();
	}

	public void attachDirty(HistoriqueCertif instance) {
		log.debug("attaching dirty HistoriqueCertif instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(HistoriqueCertif instance) {
		log.debug("attaching clean HistoriqueCertif instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HistoriqueCertif persistentInstance) {
		log.debug("deleting HistoriqueCertif instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HistoriqueCertif merge(HistoriqueCertif detachedInstance) {
		log.debug("merging HistoriqueCertif instance");
		try {
			HistoriqueCertif result = (HistoriqueCertif) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HistoriqueCertif findById(java.lang.Integer id) {
		log.debug("getting HistoriqueCertif instance with id: " + id);
		try {
			HistoriqueCertif instance = (HistoriqueCertif) sessionFactory
					.getCurrentSession().get(HistoriqueCertif.class, id);
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
	public List<HistoriqueCertif> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueCertif.class)
				.setFetchMode("certificat", FetchMode.JOIN)
				.setFetchMode("cfclient", FetchMode.JOIN);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<HistoriqueCertif> findAllByPatient(Integer idPatient) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueCertif.class)
				.addOrder(Property.forName("idHistoriqueCertif").desc())
				.setFetchMode("certificat", FetchMode.JOIN)
				.setFetchMode("cfclient", FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.eq("code", idPatient));
		List<HistoriqueCertif> l = crit.list();

		return l;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<HistoriqueCertif> findAllByPatientBypressenceacomp() {
		
		
//		Criteria crit = sessionFactory.getCurrentSession()
//				.createCriteria(HistoriqueCertif.class)
//				.setFetchMode("certificat", FetchMode.JOIN)
//				.createCriteria("certificat")
//				.add(Restrictions.eq("idcertificat", 10))
//				.setFetchMode("cfclient", FetchMode.JOIN);
//		List<HistoriqueCertif> l = crit.list();
		
		
		
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(HistoriqueCertif.class, "apl")
				.createAlias("apl.cfclient","clt")
				.createAlias("apl.certificat","certif")
			   
			    .add(Restrictions.eq("certif.idcertificat",10));
		return crit.list();
		
	}

	@SuppressWarnings("unchecked")
	public List<HistoriqueCertif> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				HistoriqueCertif.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<HistoriqueCertif> findByExample(HistoriqueCertif instance) {
		log.debug("finding HistoriqueCertif instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<HistoriqueCertif> results = (List<HistoriqueCertif>) sessionFactory
					.getCurrentSession().createCriteria(HistoriqueCertif.class)
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
