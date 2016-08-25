package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Modelutl;

/**
 * Home object for domain model class Modeutl.
 * 
 * @see com.proddoctor.dao.Utilisateur
 * @author Hibernate Tools
 */
public class ModelutlHome {

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

	public void persist(Modelutl transientInstance) {
		log.debug("persisting Modelutl instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Modelutl instance) {
		log.debug("attaching dirty Modelutl instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Modelutl instance) {
		log.debug("attaching clean Modelutl instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Modelutl persistentInstance) {
		log.debug("deleting Modelutl instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Modelutl findById(java.lang.Integer id) {
		log.debug("getting Modelutl instance with id: " + id);
		try {
			Modelutl instance = (Modelutl) sessionFactory.getCurrentSession()
					.get(Modelutl.class, id);
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
	public List<Modelutl> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Modelutl.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Modelutl> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Modelutl.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public Modelutl findByNomModelutl(String nomModelutl) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Modelutl.class)
				.add(Restrictions.eq("nomModelUtl", nomModelutl));
		Modelutl m = (Modelutl) criteria.uniqueResult();

		return m;
	}

}
