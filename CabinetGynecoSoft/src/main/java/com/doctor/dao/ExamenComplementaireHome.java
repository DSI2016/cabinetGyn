package com.doctor.dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.ExamenComplementaire;




import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ExamenComplementaire.
 * @see com.proddoctor.dao.ExamenComplementaire
 * @author Hibernate Tools
 */
public class ExamenComplementaireHome {

	private static Logger log = Logger.getLogger(ExamenComplementaireHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}	public void persist(ExamenComplementaire transientInstance) {
		log.debug("persisting ExamenComplementaire instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<ExamenComplementaire> findAllWithFilter(String valeurRecherche) {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				ExamenComplementaire.class).add(Restrictions.like("libExamenComplementaire", valeurRecherche, MatchMode.ANYWHERE));
		
		return crit.list();
	}

	public void attachDirty(ExamenComplementaire instance) {
		log.debug("attaching dirty ExamenComplementaire instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ExamenComplementaire instance) {
		log.debug("attaching clean ExamenComplementaire instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExamenComplementaire persistentInstance) {
		log.debug("deleting ExamenComplementaire instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExamenComplementaire merge(ExamenComplementaire detachedInstance) {
		log.debug("merging ExamenComplementaire instance");
		try {
			ExamenComplementaire result = (ExamenComplementaire) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExamenComplementaire findById(java.lang.Integer id) {
		log.debug("getting ExamenComplementaire instance with id: " + id);
		try {
			ExamenComplementaire instance = (ExamenComplementaire) sessionFactory.getCurrentSession().get(
					ExamenComplementaire.class, id);
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
	
	public ExamenComplementaire findByExamenComplementaire(String examenComplementaire) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ExamenComplementaire.class)
				.add(Restrictions.eq("libExamenComplementaire", examenComplementaire));
		ExamenComplementaire anal =(ExamenComplementaire) criteria.uniqueResult();
		
		return(anal);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ExamenComplementaire> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ExamenComplementaire.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<ExamenComplementaire>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<ExamenComplementaire> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ExamenComplementaire.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<ExamenComplementaire> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ExamenComplementaire.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<ExamenComplementaire> findByExample(ExamenComplementaire instance) {
		log.debug("finding ExamenComplementaire instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<ExamenComplementaire> results = (List<ExamenComplementaire>) sessionFactory
					.getCurrentSession()
					.createCriteria(ExamenComplementaire.class)
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
