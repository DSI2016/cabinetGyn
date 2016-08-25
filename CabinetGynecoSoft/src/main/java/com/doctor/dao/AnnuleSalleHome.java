package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import com.doctor.persistance.AnnuleSalle;


/**
 * Home object for domain model class AnnuleSalle.
 * 
 * @see com.proddoctor.dao.AnnuleSalle
 * @author Hibernate Tools
 */
public class AnnuleSalleHome {

	private static Logger log = Logger.getLogger(AnnuleSalleHome.class);

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

	public void persist(AnnuleSalle transientInstance) {
		log.debug("persisting AnnuleSalle instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(AnnuleSalle persistentInstance) {
		log.debug("deleting AnnuleSalle instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnnuleSalle findById(java.lang.Integer id) {
		log.debug("getting AnnuleSalle instance with id: " + id);
		try {
			AnnuleSalle instance = (AnnuleSalle) sessionFactory
					.getCurrentSession().get(AnnuleSalle.class, id);
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
	public List<AnnuleSalle> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				AnnuleSalle.class);

		return (List<AnnuleSalle>) crit.list();
	}

	
	@SuppressWarnings("unchecked")
	public List<AnnuleSalle> findAllWithJoin() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AnnuleSalle.class)
				.setFetchMode("cfclient", FetchMode.JOIN);
			

		return (List<AnnuleSalle>) crit.list();
	}
	
}
