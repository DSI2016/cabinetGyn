package com.doctor.dao;

import static org.hibernate.criterion.Example.create;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.Uterus;

/**
 * Home object for domain model class ConsultationDetail.
 * 
 * @see com.proddoctor.dao.ConsultationDetail
 * @author Hibernate Tools
 */
public class ConsultationDetailHome {

	private static Logger log = Logger.getLogger(ConsultationDetailHome.class);

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

	public void persist(ConsultationDetail transientInstance) {
		log.debug("persisting ConsultationDetail instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ConsultationDetail instance) {
		log.debug("attaching dirty ConsultationDetail instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ConsultationDetail instance) {
		log.debug("attaching clean ConsultationDetail instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ConsultationDetail persistentInstance) {
		log.debug("deleting ConsultationDetail instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConsultationDetail merge(ConsultationDetail detachedInstance) {
		log.debug("merging ConsultationDetail instance");
		try {
			ConsultationDetail result = (ConsultationDetail) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ConsultationDetail findById(java.lang.Integer id) {
		log.debug("getting ConsultationDetail instance with id: " + id);
		try {
			ConsultationDetail instance = (ConsultationDetail) sessionFactory
					.getCurrentSession().get(ConsultationDetail.class, id);
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
	public List<ConsultationDetail> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<ConsultationDetail>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				ConsultationDetail.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	public ConsultationDetail findByConsMotiff(Integer idC) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class)
				.add(Restrictions.eq("idConsultationDetail", idC))
				.setFetchMode("consultation", FetchMode.JOIN);
		return (ConsultationDetail) (crit.uniqueResult());

	}

	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				ConsultationDetail.class);

		return (List<ConsultationDetail>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findAllByUterus(Uterus u) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class)
				.add(Restrictions.eq("uterus", u));
		List<ConsultationDetail> l = crit.list();
		return l;
	}

	public List<ConsultationDetail> findByExample(ConsultationDetail instance) {
		log.debug("finding ConsultationDetail instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<ConsultationDetail> results = (List<ConsultationDetail>) sessionFactory
					.getCurrentSession()
					.createCriteria(ConsultationDetail.class)
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
	public List<ConsultationDetail> findAll(Integer idPatient,
			String nomConsultation, Uterus uterus) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class, "CD")
				.createAlias("CD.consultation", "cons")
				.createAlias("CD.cfclient", "cf");
		if (nomConsultation.equals("E. Gyneco"))
			if (uterus != null) {
				//System.out.println("ut   "+uterus);
				crit.createAlias("CD.uterus", "ut");
			}
		if (uterus == null) {
		//	System.out.println("ut   "+uterus);
			
		}

		crit.add(Restrictions.eq("cons.nomConsultation", nomConsultation))
				.addOrder(Property.forName("CD.idConsultationDetail").desc())
				.add(Restrictions.eq("cf.code", idPatient));
		return (List<ConsultationDetail>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findAll(Integer idPatient) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class, "CD")
				.createAlias("CD.consultation", "cons")
				.createAlias("CD.cfclient", "cf")
//				.createAlias("CD. sterilite", "ster")
				.addOrder(Property.forName("CD.dateConsultation").desc())
				.add(Restrictions.eq("cf.code", idPatient));

		return (List<ConsultationDetail>) crit.list();
	}

	
	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findByType(Integer idPatient,Integer idcons) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class, "CD")
				.createAlias("CD.consultation", "cons")
				.add(Restrictions.eq("cons.idconsultation",idcons))
				.createAlias("CD.cfclient", "cf")
//				.createAlias("CD. sterilite", "ster")
				.addOrder(Property.forName("CD.dateConsultation").desc())
				.add(Restrictions.eq("cf.code", idPatient));
	

		return (List<ConsultationDetail>) crit.list();
	}

	
	
	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findByDate(Date d) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class, "CD")
				.createAlias("CD.consultation", "cons")
				.createAlias("CD.cfclient", "cf")
				.add(Restrictions.eq("CD.dateConsultation", d));
	

		return (List<ConsultationDetail>) crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findByIdCons(Integer idcons, Date d) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class, "CD")
				.createAlias("CD.consultation", "cons")
				.add(Restrictions.eq("cons.idconsultation",idcons))
				.createAlias("CD.cfclient", "cf")
				.add(Restrictions.eq("CD.dateConsultation", d))
				.addOrder(Property.forName("CD.dateConsultation").desc());
				
	

		return (List<ConsultationDetail>) crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsultationDetail> findByIdCons(Integer idcons) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class, "CD")
				.createAlias("CD.consultation", "cons")
				.add(Restrictions.eq("cons.idconsultation",idcons))
				.createAlias("CD.cfclient", "cf")
				.addOrder(Property.forName("CD.dateConsultation").desc());

		return (List<ConsultationDetail>) crit.list();
	}
	
	
	public ConsultationDetail findWithJoinById(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(ConsultationDetail.class)
				.add(Restrictions.eq("idConsultationDetail", id))
				.setFetchMode("consultation", FetchMode.JOIN);
		return (ConsultationDetail) crit.uniqueResult();
	}

	
	
}
