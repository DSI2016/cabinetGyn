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

import com.doctor.persistance.Modele;
import com.doctor.persistance.Uterus;

public class ModeleHome {
	private static Logger log = Logger.getLogger(ModeleHome.class);

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

	public void persist(Modele transientInstance) {
		log.debug("persisting Modele instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Modele instance) {
		log.debug("attaching dirty Modele instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Modele instance) {
		log.debug("attaching clean Modele instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Modele persistentInstance) {
		log.debug("deleting Modele instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Modele merge(Modele detachedInstance) {
		log.debug("merging Modele instance");
		try {
			Modele result = (Modele) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Modele findById(java.lang.Integer id) {
		log.debug("getting Modele instance with id: " + id);
		try {
			Modele instance = (Modele) sessionFactory.getCurrentSession().get(
					Modele.class, id);
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

	public Modele findByIdWithJoin(java.lang.Integer id) {
		Modele m;
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Modele.class)
				.setFetchMode("uterus", FetchMode.JOIN)
				.add(Restrictions.eq("idmodele", id));
		m = (Modele) crit.uniqueResult();

		return m;
	}

	@SuppressWarnings("unchecked")
	public List<Modele> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Modele.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<Modele>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Modele> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Modele.class)
				.setFetchMode("uterus", FetchMode.JOIN);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Modele> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Modele.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<Modele> findByExample(Modele instance) {
		log.debug("finding Modele instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Modele> results = (List<Modele>) sessionFactory
					.getCurrentSession().createCriteria(Modele.class)
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
	public List<Modele> findAllByUterus(Uterus u) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Modele.class).add(Restrictions.eq("uterus", u));
		List<Modele> l = crit.list();
		return l;
	}

	public Modele findByModele(String modele) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Modele.class)
				.add(Restrictions.eq("nommodele", modele));
		Modele v = (Modele) criteria.uniqueResult();

		return v;
	}

	@SuppressWarnings("unchecked")
	public List<Modele> findAllWithFilter(String valeurRecherche) {
		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Modele.class)
				.add(Restrictions.like("modele", valeurRecherche,
						MatchMode.ANYWHERE));
		return crit.list();
	}

}
