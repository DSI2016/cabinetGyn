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

import com.doctor.persistance.Medicament;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Medicament.
 * 
 * @see com.proddoctor.dao.Medicament
 * @author Hibernate Tools
 */
public class MedicamentHome {

	private static Logger log = Logger.getLogger(MedicamentHome.class);

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

	public void persist(Medicament transientInstance) {
		log.debug("persisting Medicament instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Medicament instance) {
		log.debug("attaching dirty Medicament instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Medicament instance) {
		log.debug("attaching clean Medicament instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Medicament persistentInstance) {
		log.debug("deleting Medicament instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Medicament merge(Medicament detachedInstance) {
		log.debug("merging Medicament instance");
		try {
			Medicament result = (Medicament) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Medicament findByMedicament(String a, String forme) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Medicament.class)
				.add(Restrictions.eq("designation", a))
				.setFetchMode("formeMed", FetchMode.JOIN)
				.createCriteria("formeMed")
				.add(Restrictions.eq("forme", forme));
		Medicament anal = (Medicament) criteria.uniqueResult();

		return (anal);
	}

	public Medicament findById(java.lang.Integer id) {
		log.debug("getting Medicament instance with id: " + id);
		try {
			Medicament instance = (Medicament) sessionFactory
					.getCurrentSession().get(Medicament.class, id);
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
	public List<Medicament> findAllWithJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Medicament.class);

		return (List<Medicament>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Medicament> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Medicament.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Medicament> findAllWithFilter(String valeurRecherche) {

		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Medicament.class)
				.setFetchMode("formeMed", FetchMode.JOIN)
				.add(Restrictions.like("designation", valeurRecherche));

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Medicament> findAll() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Medicament.class)
				.setFetchMode("formeMed", FetchMode.JOIN);

		return (List<Medicament>) crit.list();
	}

	public List<Medicament> findByExample(Medicament instance) {
		log.debug("finding Medicament instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Medicament> results = (List<Medicament>) sessionFactory
					.getCurrentSession().createCriteria(Medicament.class)
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
	public List<Medicament> findAllWithFilter(String attribut,
			String valeurRecherche) {

		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Medicament.class);

		if (attribut.equals("Medicament"))
			crit = crit.add(
					Restrictions.like("designation", valeurRecherche,
							MatchMode.ANYWHERE)).setFetchMode("formeMed",
					FetchMode.JOIN);

		if (attribut.equals("Forme"))
			crit = crit
					.setFetchMode("formeMed", FetchMode.JOIN)
					.createCriteria("formeMed")
					.add(Restrictions.like("forme", valeurRecherche,
							MatchMode.ANYWHERE));

		return (List<Medicament>) crit.list();
	}

	public Medicament findWithForme(Integer id) {

		Medicament m;
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Medicament.class)
				.setFetchMode("formeMed", FetchMode.JOIN)
				.createCriteria("formeMed")
				.add(Restrictions.eq("idFormeMedicament", id));

		m = (Medicament) crit.uniqueResult();
		return m;
	}

	public Medicament findWithoutForme(String designation) {
		Medicament m = null;
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Medicament.class)
				.add(Restrictions.like("designation", designation))
				.setFetchMode("formeMed", FetchMode.JOIN)
				.add(Restrictions.isNull("formeMed"));
		m = (Medicament) crit.uniqueResult();
		return m;
	}

	@SuppressWarnings("unchecked")
	public List<Medicament> findAllWithForme(String attribut) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Medicament.class);

		crit = crit.setFetchMode("formeMed", FetchMode.JOIN)
				.createCriteria("formeMed")
				.add(Restrictions.like("forme", attribut));

		return (List<Medicament>) crit.list();
	}

}
