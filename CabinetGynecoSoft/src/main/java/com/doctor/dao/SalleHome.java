package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Salle;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Salle.
 * 
 * @see com.proddoctor.dao.Salle
 * @author Hibernate Tools
 */
public class SalleHome {

	private static Logger log = Logger.getLogger(SalleHome.class);

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

	public void persist(Salle transientInstance) {
		log.debug("persisting Salle instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Salle instance) {
		log.debug("attaching dirty Salle instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Salle instance) {
		log.debug("attaching clean Salle instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Salle persistentInstance) {
		log.debug("deleting Salle instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salle merge(Salle detachedInstance) {
		log.debug("merging Salle instance");
		try {
			Salle result = (Salle) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Salle findById(java.lang.Integer id) {
		log.debug("getting Salle instance with id: " + id);
		try {
			Salle instance = (Salle) sessionFactory.getCurrentSession().get(
					Salle.class, id);
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
	public List<Salle> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Salle.class)
				.setFetchMode(param, FetchMode.JOIN)
				.add(Restrictions.not(Restrictions.eq("motif","Telephone")))
				.addOrder(Property.forName("ordre").asc());

		return (List<Salle>) crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Salle> findAllSalleWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Salle.class)
				.setFetchMode(param, FetchMode.JOIN)
				.addOrder(Property.forName("ordre").asc());

		return (List<Salle>) crit.list();
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Salle> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Salle.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Salle> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Salle.class)
				.addOrder(Property.forName("ordre").asc());

		return (List<Salle>) crit.list();
	}

	public List<Salle> findByExample(Salle instance) {
		log.debug("finding Salle instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Salle> results = (List<Salle>) sessionFactory
					.getCurrentSession().createCriteria(Salle.class)
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
	public List<Salle> findSalleWithMotif(String motifSalle) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Salle.class)
				.setFetchMode("cfclient", FetchMode.JOIN)
				.add(Restrictions.like("motif", motifSalle))
				.addOrder(Property.forName("ordre").asc());
		return crit.list();
	}

	public Salle findByOrdre(int ordre) {
		log.debug("getting Salle instance with ordre: " + ordre);
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Salle.class)
					.add(Restrictions.eq("ordre", ordre))
					.add(Restrictions.ne("motif", "Telephone"));
			Salle s = (Salle) criteria.uniqueResult();
			return s;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}
	
	public Salle findByOrdre(int ordre,List<String> l) {
		log.debug("getting Salle instance with ordre: " + ordre);
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Salle.class)
					.add(Restrictions.eq("ordre", ordre))
					.add(Restrictions.ne("motif", "Telephone"));
			for(int i=0 ; i<l.size();i++){
				criteria=criteria.add(Restrictions.ne("motif",l.get(i)));
			}
			Salle s = (Salle) criteria.uniqueResult();
			return s;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}

	public Salle findByPatient(Integer code) {
		
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Salle.class)
				.setFetchMode("cfclient", FetchMode.JOIN)
				.createCriteria("cfclient")
				.add(Restrictions.like("code", code));
		
		return (Salle) crit.uniqueResult();
	}

}
