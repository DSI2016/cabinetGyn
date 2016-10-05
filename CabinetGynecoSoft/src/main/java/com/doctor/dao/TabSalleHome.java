package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import com.doctor.persistance.TabSalle;

public class TabSalleHome {
	private static Logger log = Logger.getLogger(TabSalleHome.class);
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

	public void persist(TabSalle transientInstance) {
		log.debug("persisting tab instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public TabSalle merge(TabSalle tabInstance) {
		log.debug("merging tab instance");
		try {
			TabSalle result = (TabSalle) sessionFactory.getCurrentSession()
					.merge(tabInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TabSalle instance) {
		log.debug("attaching dirty TabSalle instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(TabSalle instance) {
		log.debug("attaching clean TabSalle instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TabSalle> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.addOrder(Property.forName("active").desc())
				.addOrder(Property.forName("ordre").asc());
		return (List<TabSalle>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TabSalle> findbyActive() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.add(Restrictions.eq("active", true))
				.addOrder(Property.forName("ordre").asc());
		return (List<TabSalle>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TabSalle> findbyOrdDiff(boolean ordDiff) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.add(Restrictions.eq("ordreDifferent", ordDiff));
		return (List<TabSalle>) crit.list();
	}

	public TabSalle findById(java.lang.Integer id) {

		try {
			TabSalle instance = (TabSalle) sessionFactory.getCurrentSession()
					.get(TabSalle.class, id);
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
	public List<TabSalle> findbyOrd(Integer ord) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.add(Restrictions.eq("ordre", ord));
		return (List<TabSalle>) crit.list();
	}

	public TabSalle findByNomTab(String nomTab) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.add(Restrictions.eq("nomTab", nomTab));
		TabSalle v = (TabSalle) criteria.uniqueResult();

		return v;
	}

}
