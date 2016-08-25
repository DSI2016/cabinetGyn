package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Utilisateur;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Utilisateur.
 * 
 * @see com.proddoctor.dao.Utilisateur
 * @author Hibernate Tools
 */
public class UtilisateurHome {

	private static Logger log = Logger.getLogger(UtilisateurHome.class);

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

	public void persist(Utilisateur transientInstance) {
		log.debug("persisting Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Utilisateur instance) {
		log.debug("attaching dirty Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Utilisateur instance) {
		log.debug("attaching clean Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Utilisateur persistentInstance) {
		log.debug("deleting Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Utilisateur merge(Utilisateur detachedInstance) {
		log.debug("merging Utilisateur instance");
		try {
			Utilisateur result = (Utilisateur) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Utilisateur findById(java.lang.Integer id) {
		log.debug("getting Utilisateur instance with id: " + id);
		try {
			Utilisateur instance = (Utilisateur) sessionFactory
					.getCurrentSession().get(Utilisateur.class, id);
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
	public List<Utilisateur> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Utilisateur.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Utilisateur.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Utilisateur> findByExample(Utilisateur instance) {
		log.debug("finding Utilisateur instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Utilisateur> results = (List<Utilisateur>) sessionFactory
					.getCurrentSession().createCriteria(Utilisateur.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public Utilisateur findByLogMotPass(String l, String m) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Utilisateur.class)
				.add(Restrictions.and(Restrictions.eq("login", l),Restrictions.eq("motPasse",m)));
		
		return (Utilisateur)crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findByLogin(String l) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Utilisateur.class)
				.add(Restrictions.eq("login", l));
		
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> findByMotPass(String m) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Utilisateur.class)
				.add(Restrictions.eq("motPasse",m));
		
		return crit.list();
	}

	
}
