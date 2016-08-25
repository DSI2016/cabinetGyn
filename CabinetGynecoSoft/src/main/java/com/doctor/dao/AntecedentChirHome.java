package com.doctor.dao;

// Generated 18 ao�t 2014 14:11:58 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.AntecedentChir;

/**
 * Home object for domain model class AntecedentChir.
 * 
 * @see com.proddoctor.dao.AntecedentChir
 * @author Hibernate Tools
 */
public class AntecedentChirHome {

	private static Logger log = Logger.getLogger(AntecedentChirHome.class);

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

	public void persist(AntecedentChir transientInstance) {
		log.debug("persisting AntecedentChir instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AntecedentChir instance) {
		log.debug("attaching dirty AntecedentChir instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AntecedentChir instance) {
		log.debug("attaching clean AntecedentChir instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AntecedentChir persistentInstance) {
		log.debug("deleting AntecedentChir instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AntecedentChir merge(AntecedentChir detachedInstance) {
		log.debug("merging AntecedentChir instance");
		try {
			AntecedentChir result = (AntecedentChir) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentChir> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				AntecedentChir.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentChir> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentChir.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<AntecedentChir>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentChir> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				AntecedentChir.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public AntecedentChir findById(java.lang.Integer id) {
		log.debug("getting AntecedentChir instance with id: " + id);
		try {
			AntecedentChir instance = (AntecedentChir) sessionFactory
					.getCurrentSession().get(AntecedentChir.class, id);
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

	public List<AntecedentChir> findByExample(AntecedentChir instance) {
		log.debug("finding AntecedentChir instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AntecedentChir> results = (List<AntecedentChir>) sessionFactory
					.getCurrentSession().createCriteria(AntecedentChir.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public AntecedentChir findByAntecedentChir(String libantecedentChir) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentChir.class)
				.add(Restrictions.eq("antChirugical", libantecedentChir));
		AntecedentChir c = (AntecedentChir) criteria.uniqueResult();

		return c;
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentChir> findWithFilter(String valeurRecherche) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentChir.class)
				.add(Restrictions.eq("antChirugical", valeurRecherche));

		return criteria.list();
	}
}
