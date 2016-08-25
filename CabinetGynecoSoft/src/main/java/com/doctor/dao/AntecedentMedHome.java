package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.AntecedentMed;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AntecedentMed.
 * @see com.proddoctor.dao.AntecedentMed
 * @author Hibernate Tools
 */
public class AntecedentMedHome {

	private static Logger log = Logger.getLogger(AntecedentMedHome.class);

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

	public void persist(AntecedentMed transientInstance) {
		log.debug("persisting AntecedentMed instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AntecedentMed instance) {
		log.debug("attaching dirty AntecedentMed instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AntecedentMed instance) {
		log.debug("attaching clean AntecedentMed instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AntecedentMed persistentInstance) {
		log.debug("deleting AntecedentMed instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AntecedentMed merge(AntecedentMed detachedInstance) {
		log.debug("merging AntecedentMed instance");
		try {
			AntecedentMed result = (AntecedentMed) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<AntecedentMed> findAll () {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntecedentMed.class);
		
		return crit.list();
		}
	@SuppressWarnings("unchecked")
	public List<AntecedentMed> findAllWithJoin (String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentMed.class)
				.setFetchMode(param,FetchMode.JOIN);
		
		return (List<AntecedentMed>) crit.list();
		}
	
	@SuppressWarnings("unchecked")
	public List<AntecedentMed> findAll (Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AntecedentMed.class);
		if (null != defaultOrder) crit.addOrder(defaultOrder);
		return crit.list();
		}
	

	public AntecedentMed findById(java.lang.Integer id) {
		log.debug("getting AntecedentMed instance with id: " + id);
		try {
			AntecedentMed instance = (AntecedentMed) sessionFactory.getCurrentSession()
					.get(AntecedentMed.class, id);
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

	public List<AntecedentMed> findByExample(AntecedentMed instance) {
		log.debug("finding AntecedentMed instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AntecedentMed> results = (List<AntecedentMed>) sessionFactory
					.getCurrentSession()
					.createCriteria(AntecedentMed.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public AntecedentMed findByAntecedentMed(String libantecedentMed) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(AntecedentMed.class)
				.add(Restrictions.eq("antMedical", libantecedentMed));
		AntecedentMed c=(AntecedentMed) criteria.uniqueResult();
		
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<AntecedentMed> findWithFilter(String valeurRecherche) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(AntecedentMed.class)
				.add(Restrictions.eq("antMedical", valeurRecherche));

		return criteria.list();
	}
}
