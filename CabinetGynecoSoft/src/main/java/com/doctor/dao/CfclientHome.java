package com.doctor.dao;

// Generated 18 ao�t 2014 14:11:58 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.doctor.persistance.Cfclient;

/**
 * Home object for domain model class Cfclient.
 * 
 * @see com.proddoctor.dao.Cfclient
 * @author Hibernate Tools
 */
public class CfclientHome {

	/**
	 * Logger
	 */
	private static Logger log = Logger.getLogger(CfclientHome.class);

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

	public void persist(Cfclient transientInstance) {
		log.debug("persisting Cfclient instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllWithFilter(String attribut,
			String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("clinique", FetchMode.JOIN)
				.setFetchMode("doctor", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
				.setFetchMode("histoirs", FetchMode.JOIN)
				.setFetchMode("steriles", FetchMode.JOIN)
				.setFetchMode("historiqueGrosss", FetchMode.JOIN);
		crit = crit.add(Restrictions.eq("archive", false));
			
		if (attribut.equals("Nom"))
			crit = crit.add(Restrictions.like("nom", valeurRecherche,
					MatchMode.START));

		if (attribut.equals("Prenom"))
			crit = crit.add(Restrictions.like("prenom", valeurRecherche,
					MatchMode.START));

		// if (attribut.equals("Patiente"))
		// crit = crit.add(Restrictions.eq("code",
		// Integer.parseInt(valeurRecherche)));

		if (attribut.equals("Patiente"))
			crit = crit.add(Restrictions.or(Restrictions.like("nomprenom",
					valeurRecherche, MatchMode.ANYWHERE), Restrictions.like(
					"prenomnom", valeurRecherche, MatchMode.ANYWHERE),
					(Restrictions.like("prenomNomConjoint", valeurRecherche,
							MatchMode.ANYWHERE))));

		if (attribut.equals("Conjoint"))
			crit = crit.add(Restrictions.or(Restrictions.like("nomC",
					valeurRecherche, MatchMode.ANYWHERE), Restrictions.like(
					"prenomC", valeurRecherche, MatchMode.ANYWHERE)));

		if (attribut.equals("Tel"))

		{
			String temp = valeurRecherche;
			String valeurRecherche1 = temp.substring(0, 2) + "."
					+ temp.substring(2, 5) + "." + temp.substring(5, 8);
			String valeurRecherche2 = temp.substring(0, 2) + " "
					+ temp.substring(2, 5) + " " + temp.substring(5, 8);
			String valeurRecherche3 = temp.substring(0, 2) + ""
					+ temp.substring(2, 5) + "" + temp.substring(5, 8);
			crit = crit.add(Restrictions.or(Restrictions.like("telephone",
					valeurRecherche1, MatchMode.ANYWHERE), Restrictions.like(
					"telephone2", valeurRecherche1, MatchMode.ANYWHERE),
					Restrictions.like("telC", valeurRecherche1,
							MatchMode.ANYWHERE), Restrictions.like("gsm1",
							valeurRecherche1, MatchMode.ANYWHERE), Restrictions
							.like("gsm2", valeurRecherche1, MatchMode.ANYWHERE),
					Restrictions.like("gsmC", valeurRecherche1,
							MatchMode.ANYWHERE), Restrictions.like("telephone",
							valeurRecherche2, MatchMode.ANYWHERE), Restrictions
							.like("telephone2", valeurRecherche2,
									MatchMode.ANYWHERE), Restrictions.like(
							"telC", valeurRecherche2, MatchMode.ANYWHERE),
					Restrictions.like("gsm1", valeurRecherche2,
							MatchMode.ANYWHERE), Restrictions.like("gsm2",
							valeurRecherche2, MatchMode.ANYWHERE), Restrictions
							.like("gsmC", valeurRecherche2, MatchMode.ANYWHERE),
					Restrictions.like("telephone", valeurRecherche3,
							MatchMode.ANYWHERE), Restrictions.like(
							"telephone2", valeurRecherche3, MatchMode.ANYWHERE),
					Restrictions.like("telC", valeurRecherche3,
							MatchMode.ANYWHERE), Restrictions.like("gsm1",
							valeurRecherche3, MatchMode.ANYWHERE), Restrictions
							.like("gsm2", valeurRecherche3, MatchMode.ANYWHERE),
					Restrictions.like("gsmC", valeurRecherche3,
							MatchMode.ANYWHERE)));
		}

		crit.addOrder(Property.forName("code").desc());
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllWithTri(String attribut,
			String ordre) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("clinique", FetchMode.JOIN)
				.setFetchMode("doctor", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
				.setFetchMode("histoirs", FetchMode.JOIN)
				.setFetchMode("steriles", FetchMode.JOIN)
				.setFetchMode("historiqueGrosss", FetchMode.JOIN);
		crit = crit.add(Restrictions.eq("archive", false));
			
		if (attribut.equals("Nom")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("nom").asc());
		if (attribut.equals("Nom")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("nom").desc());
		if (attribut.equals("Prenom")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("prenom").asc());
		if (attribut.equals("Prenom")&&(ordre.equals("décroissante")))
			
			crit = crit.addOrder(Property.forName("prenom").desc());
		if (attribut.equals("Patiente")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("nomprenom").asc());
		if (attribut.equals("Patiente")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("nomprenom").desc());
		if (attribut.equals("Nbr Consultation")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("nbCons").asc());
		if (attribut.equals("Nbr Consultation")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("nbCons").desc());
		
		if (attribut.equals("Dernier Consultation")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("dernierVisite").asc());
		if (attribut.equals("Dernier Consultation")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("dernierVisite").desc());
		
		return crit.list();
	}
	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllWithTriArchive(String attribut,
			String ordre) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("clinique", FetchMode.JOIN)
				.setFetchMode("doctor", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
				.setFetchMode("histoirs", FetchMode.JOIN)
				.setFetchMode("steriles", FetchMode.JOIN)
				.setFetchMode("historiqueGrosss", FetchMode.JOIN);
		crit = crit.add(Restrictions.eq("archive", true));
			
		if (attribut.equals("Nom")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("nom").asc());
		if (attribut.equals("Nom")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("nom").desc());
		if (attribut.equals("Prenom")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("prenom").asc());
		if (attribut.equals("Prenom")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("Prenom").desc());
		if (attribut.equals("Patiente")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("nomprenom").asc());
		if (attribut.equals("Patiente")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("nomprenom").desc());
		if (attribut.equals("Nbr Consultation")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("nbCons").asc());
		if (attribut.equals("Nbr Consultation")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("nbCons").desc());
		
		if (attribut.equals("Dernier Consultation")&&(ordre.equals("croissante")))
			crit = crit.addOrder(Property.forName("dernierVisite").asc());
		if (attribut.equals("Dernier Consultation")&&(ordre.equals("décroissante")))
			crit = crit.addOrder(Property.forName("dernierVisite").desc());
		
		
		

		return crit.list();
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllWithFilterArchive(String attribut,
			String valeurRecherche) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("clinique", FetchMode.JOIN)
				.setFetchMode("doctor", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
				.setFetchMode("histoirs", FetchMode.JOIN)
				.setFetchMode("steriles", FetchMode.JOIN)
				.setFetchMode("historiqueGrosss", FetchMode.JOIN);
		crit = crit.add(Restrictions.eq("archive", true));
			
		if (attribut.equals("Nom"))
			crit = crit.add(Restrictions.like("nom", valeurRecherche,
					MatchMode.START));

		if (attribut.equals("Prenom"))
			crit = crit.add(Restrictions.like("prenom", valeurRecherche,
					MatchMode.START));

		// if (attribut.equals("Patiente"))
		// crit = crit.add(Restrictions.eq("code",
		// Integer.parseInt(valeurRecherche)));

		if (attribut.equals("Patiente"))
			crit = crit.add(Restrictions.or(Restrictions.like("nomprenom",
					valeurRecherche, MatchMode.ANYWHERE), Restrictions.like(
					"prenomnom", valeurRecherche, MatchMode.ANYWHERE),
					(Restrictions.like("prenomNomConjoint", valeurRecherche,
							MatchMode.ANYWHERE))));

		if (attribut.equals("Conjoint"))
			crit = crit.add(Restrictions.or(Restrictions.like("nomC",
					valeurRecherche, MatchMode.ANYWHERE), Restrictions.like(
					"prenomC", valeurRecherche, MatchMode.ANYWHERE)));

		if (attribut.equals("Tel"))

		{
			String temp = valeurRecherche;
			String valeurRecherche1 = temp.substring(0, 2) + "."
					+ temp.substring(2, 5) + "." + temp.substring(5, 8);
			String valeurRecherche2 = temp.substring(0, 2) + " "
					+ temp.substring(2, 5) + " " + temp.substring(5, 8);
			String valeurRecherche3 = temp.substring(0, 2) + ""
					+ temp.substring(2, 5) + "" + temp.substring(5, 8);
			crit = crit.add(Restrictions.or(Restrictions.like("telephone",
					valeurRecherche1, MatchMode.ANYWHERE), Restrictions.like(
					"telephone2", valeurRecherche1, MatchMode.ANYWHERE),
					Restrictions.like("telC", valeurRecherche1,
							MatchMode.ANYWHERE), Restrictions.like("gsm1",
							valeurRecherche1, MatchMode.ANYWHERE), Restrictions
							.like("gsm2", valeurRecherche1, MatchMode.ANYWHERE),
					Restrictions.like("gsmC", valeurRecherche1,
							MatchMode.ANYWHERE), Restrictions.like("telephone",
							valeurRecherche2, MatchMode.ANYWHERE), Restrictions
							.like("telephone2", valeurRecherche2,
									MatchMode.ANYWHERE), Restrictions.like(
							"telC", valeurRecherche2, MatchMode.ANYWHERE),
					Restrictions.like("gsm1", valeurRecherche2,
							MatchMode.ANYWHERE), Restrictions.like("gsm2",
							valeurRecherche2, MatchMode.ANYWHERE), Restrictions
							.like("gsmC", valeurRecherche2, MatchMode.ANYWHERE),
					Restrictions.like("telephone", valeurRecherche3,
							MatchMode.ANYWHERE), Restrictions.like(
							"telephone2", valeurRecherche3, MatchMode.ANYWHERE),
					Restrictions.like("telC", valeurRecherche3,
							MatchMode.ANYWHERE), Restrictions.like("gsm1",
							valeurRecherche3, MatchMode.ANYWHERE), Restrictions
							.like("gsm2", valeurRecherche3, MatchMode.ANYWHERE),
					Restrictions.like("gsmC", valeurRecherche3,
							MatchMode.ANYWHERE)));
		}

		crit.addOrder(Property.forName("code").desc());
		return crit.list();
	}


	
	
	

	public void attachDirty(Cfclient instance) {
		log.debug("attaching dirty Cfclient instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Cfclient instance) {
		log.debug("attaching clean Cfclient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cfclient persistentInstance) {
		log.debug("deleting Cfclient instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cfclient merge(Cfclient detachedInstance) {
		log.debug("merging Cfclient instance");
		try {
			Cfclient result = (Cfclient) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cfclient findById(java.lang.Integer id) {
		log.debug("getting Cfclient instance with id: " + id);
		try {
			Cfclient instance = (Cfclient) sessionFactory.getCurrentSession()
					.get(Cfclient.class, id);
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

	public Cfclient findByIdWIthJoin(java.lang.Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.add(Restrictions.eq("code", id))
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("antMed", FetchMode.JOIN);

		return (Cfclient) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Cfclient.class);
		List<Cfclient> l = crit.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllWithOneJoin(String param) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode(param, FetchMode.JOIN);

		return (List<Cfclient>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAll(Order defaultOrder) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Cfclient.class);
		if (null != defaultOrder)
			crit.addOrder(defaultOrder);

		return (List<Cfclient>) crit.list();
	}

	public List<Cfclient> findByExample(Cfclient instance) {
		log.debug("finding Cfclient instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Cfclient> results = (List<Cfclient>) sessionFactory
					.getCurrentSession().createCriteria(Cfclient.class)
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
	public List<Cfclient> findAllWithJoin() {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("clinique", FetchMode.JOIN)
				.setFetchMode("doctor", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
				.setFetchMode("steriles", FetchMode.JOIN)
				.setFetchMode("historiqueGrosss", FetchMode.JOIN)
				.setFetchMode("histoirs", FetchMode.JOIN)
				.setFetchMode("contraMedsceptions", FetchMode.JOIN)
				.setFetchMode("ant", FetchMode.JOIN)
				.addOrder(Property.forName("code").desc());

		return (List<Cfclient>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findByArchiveWithJoin(boolean archive) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("clinique", FetchMode.JOIN)
				.setFetchMode("doctor", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
				.setFetchMode("steriles", FetchMode.JOIN)
				.setFetchMode("historiqueGrosss", FetchMode.JOIN)
				.setFetchMode("histoirs", FetchMode.JOIN)
				.setFetchMode("contraceptions", FetchMode.JOIN)
				.setFetchMode("antMeds", FetchMode.JOIN)
				.add(Restrictions.eq("archive", archive))
				.addOrder(Property.forName("code").desc());

		return (List<Cfclient>) crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllByDocteur(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("doctor", FetchMode.JOIN)
				.createCriteria("doctor")
				.add(Restrictions.eq("iddoctor", id));
		List<Cfclient> l = crit.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllByClinique(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("clinique", FetchMode.JOIN)
				.createCriteria("clinique")
				.add(Restrictions.eq("idclinique", id));
		List<Cfclient> l = crit.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllByProfession(Integer id) {
		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Cfclient.class)
				.createAlias("professionByProfessp", "prof")
				.createAlias("professionByProfesscp", "profc")
				.add(Restrictions.or(Restrictions.eq("prof.idprofession", id),
						(Restrictions.eq("profc.idprofession", id))));
		List<Cfclient> l = crit.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findAllByVille(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN).createCriteria("ville")
				.add(Restrictions.eq("idville", id));
		List<Cfclient> l = crit.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<Cfclient> findPatient(String nom, String prenom, String date) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.add(Restrictions.eq("nom", nom))
				.add(Restrictions.eq("prenom", prenom))
				.add(Restrictions.eq("dateNaiss", date));
		List<Cfclient> l = crit.list();
		return l;
	}

	
	
	public Cfclient findByIdPatWithJoin(Integer id) {

		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Cfclient.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("clinique", FetchMode.JOIN)
				.setFetchMode("doctor", FetchMode.JOIN)
				.setFetchMode("professionByProfesscp", FetchMode.JOIN)
				.setFetchMode("professionByProfessp", FetchMode.JOIN)
			      .add(Restrictions.eq("code", id));
				

		 return (Cfclient) crit.uniqueResult();
	}
	
	
	
}
