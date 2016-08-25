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

import com.doctor.persistance.MoyenContraception;




import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MoyenContraception.
 * @see com.proddoctor.dao.MoyenContraception
 * @author Hibernate Tools
 */
public class MoyenContraceptionHome {

	private static Logger log = Logger.getLogger(MoyenContraceptionHome.class);

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
	}	public void persist(MoyenContraception transientInstance) {
		log.debug("persisting MoyenContraception instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<MoyenContraception> findAllWithFilter(String valeurRecherche) {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				MoyenContraception.class).add(Restrictions.like("libMoyenContraception", valeurRecherche, MatchMode.ANYWHERE));
		
		return crit.list();
	}

	public void attachDirty(MoyenContraception instance) {
		log.debug("attaching dirty MoyenContraception instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(MoyenContraception instance) {
		log.debug("attaching clean MoyenContraception instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MoyenContraception persistentInstance) {
		log.debug("deleting MoyenContraception instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MoyenContraception merge(MoyenContraception detachedInstance) {
		log.debug("merging MoyenContraception instance");
		try {
			MoyenContraception result = (MoyenContraception) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MoyenContraception findById(java.lang.Integer id) {
		log.debug("getting MoyenContraception instance with id: " + id);
		try {
			MoyenContraception instance = (MoyenContraception) sessionFactory.getCurrentSession().get(
					MoyenContraception.class, id);
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
	
	public MoyenContraception findByMoyenContraception(String moyenContraception) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(MoyenContraception.class)
				.add(Restrictions.eq("libMoyenContraception", moyenContraception));
		MoyenContraception anal =(MoyenContraception) criteria.uniqueResult();
		
		return(anal);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MoyenContraception> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(MoyenContraception.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<MoyenContraception>) crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<MoyenContraception> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(MoyenContraception.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<MoyenContraception> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(MoyenContraception.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public List<MoyenContraception> findByExample(MoyenContraception instance) {
		log.debug("finding MoyenContraception instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<MoyenContraception> results = (List<MoyenContraception>) sessionFactory
					.getCurrentSession()
					.createCriteria(MoyenContraception.class)
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
