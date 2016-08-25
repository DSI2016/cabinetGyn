package com.doctor.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Certificat;
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
	
	@SuppressWarnings("unchecked")
	public List<TabSalle> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.addOrder(Property.forName("index").asc());
		return (List<TabSalle>) crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TabSalle> findbyActive() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.add(Restrictions.eq("active",true))
				.addOrder(Property.forName("index").asc());
		return (List<TabSalle>) crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<TabSalle> findbyOrdDiff(boolean ordDiff) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(TabSalle.class)
				.add(Restrictions.eq("ordreDifferent",ordDiff));
		return (List<TabSalle>) crit.list();
	}
	
	public TabSalle findById(java.lang.Integer id) {
		
		try {
			TabSalle instance = (TabSalle) sessionFactory
					.getCurrentSession().get(TabSalle.class, id);
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


	
}
