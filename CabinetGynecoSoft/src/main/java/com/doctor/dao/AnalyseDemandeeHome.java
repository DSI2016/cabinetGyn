package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.AnalyseDemandee;

/**
 * Home object for domain model class AnalyseDemandee.
 * 
 * @see com.proddoctor.dao.AnalyseDemandee
 * @author Hibernate Tools
 */
public class AnalyseDemandeeHome {

	private static Logger log = Logger.getLogger(AnalyseDemandeeHome.class);

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

	public void persist(AnalyseDemandee transientInstance) {
		log.debug("persisting AnalyseDemandee instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnalyseDemandee instance) {
		log.debug("attaching dirty AnalyseDemandee instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AnalyseDemandee instance) {
		log.debug("attaching clean AnalyseDemandee instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnalyseDemandee persistentInstance) {
		log.debug("deleting AnalyseDemandee instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnalyseDemandee merge(AnalyseDemandee detachedInstance) {
		log.debug("merging AnalyseDemandee instance");
		try {
			AnalyseDemandee result = (AnalyseDemandee) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnalyseDemandee findById(java.lang.Integer id) {
		log.debug("getting AnalyseDemandee instance with id: " + id);
		try {
			AnalyseDemandee instance = (AnalyseDemandee) sessionFactory
					.getCurrentSession().get(AnalyseDemandee.class, id);
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
	public List<AnalyseDemandee> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AnalyseDemandee.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<AnalyseDemandee>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<AnalyseDemandee> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				AnalyseDemandee.class);

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<AnalyseDemandee> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				AnalyseDemandee.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public List<AnalyseDemandee> findByExample(AnalyseDemandee instance) {
		log.debug("finding AnalyseDemandee instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AnalyseDemandee> results = (List<AnalyseDemandee>) sessionFactory
					.getCurrentSession().createCriteria(AnalyseDemandee.class)
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
	public List<AnalyseDemandee> findByConsultation(Integer idConsultationDetail) {

		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(AnalyseDemandee.class)
				.addOrder(Property.forName("idanalyseDemandee").desc())
				.setFetchMode("consultationDetail", FetchMode.JOIN)
				.createCriteria("consultationDetail")
				.add(Restrictions.eq("idConsultationDetail",
						idConsultationDetail));

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<AnalyseDemandee> findByPatient(Integer cl) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AnalyseDemandee.class)
				.addOrder(Property.forName("dateAnalyse").desc())
				.addOrder(Property.forName("idanalyseDemandee").desc())
				.setFetchMode("consultationDetail", FetchMode.JOIN)
				.setFetchMode("patiente", FetchMode.JOIN)
				.createCriteria("patiente").add(Restrictions.eq("code", cl));

		return crit.list();
	}

	public AnalyseDemandee findByIdWithJoin(Integer idanalyseDemandee) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(AnalyseDemandee.class)
				.add(Restrictions.eq("idanalyseDemandee", idanalyseDemandee))
				.setFetchMode("consultationDetail", FetchMode.JOIN)
				.setFetchMode("patiente", FetchMode.JOIN);
		return (AnalyseDemandee) crit.uniqueResult();
	}
}
