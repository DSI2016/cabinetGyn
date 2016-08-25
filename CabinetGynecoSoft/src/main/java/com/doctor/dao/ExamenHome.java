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
import com.doctor.persistance.Examen;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Examen.
 * @see com.proddoctor.dao.Examen
 * @author Hibernate Tools
 */
public class ExamenHome {

	private static Logger log = Logger.getLogger(ExamenHome.class);

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
	}
	public void persist(Examen transientInstance) {
		log.debug("persisting Examen instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Examen instance) {
		log.debug("attaching dirty Examen instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Examen instance) {
		log.debug("attaching clean Examen instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	
	
	
	/*public Analyse findByAnalyse(String analyse) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Analyse.class)
				.add(Restrictions.eq("libAnalyse", analyse));
		Analyse anal =(Analyse) criteria.uniqueResult();
		
		return(anal);
	}
	
	*/
	public void delete(Examen persistentInstance) {
		log.debug("deleting Examen instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Examen merge(Examen detachedInstance) {
		log.debug("merging Examen instance");
		try {
			Examen result = (Examen) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public Examen findByExamen(String exam) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Examen.class)
				.add(Restrictions.eq("examen", exam));
		Examen d=(Examen) criteria.uniqueResult();
		return d;
	}

	public Examen findById(java.lang.Integer id) {
		log.debug("getting Examen instance with id: " + id);
		try {
			Examen instance = (Examen) sessionFactory.getCurrentSession().get(
					Examen.class, id);
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
	public List<Examen> findAllWithFilter(String valeurRecherche) {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Examen.class).add(Restrictions.like("examen", valeurRecherche, MatchMode.ANYWHERE));
		
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Examen> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Examen.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<Examen>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Examen> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Examen.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<Examen> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Examen.class);
		
		return (List<Examen>)crit.list();
		}
	
	public List<Examen> findByExample(Examen instance) {
		log.debug("finding Examen instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Examen> results = (List<Examen>) sessionFactory
					.getCurrentSession()
					.createCriteria(Examen.class)
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