package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.SalleHome;
import com.doctor.persistance.Salle;
import com.doctor.persistance.TabSalle;

public class SalleService {
	private SalleHome dao;

	public SalleService() {
		dao = new SalleHome();
	}

	/**
	 * C'est une méthode pour l'ajout
	 */
	public void ajouterSalle(Salle s, String motif, List<TabSalle> ts,
			boolean ordDiff) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int i = 0;
		try {
			tx = session.beginTransaction();
			if (motif.equals("Telephone"))
				i = dao.findSalleWithMotif(motif).size();
			else if (ordDiff)
				i = dao.findSalleWithMotif(motif).size();
			else {
				List<Salle> sal = dao.findAllWithJoin("cfclient");
				for (int j = 0; j < sal.size(); j++) {
					for (int k = 0; k < ts.size(); k++) {

						if ((sal.get(j).getMotif()).equals(ts.get(k)
								.getNomTab()))
							i++;
					}
				}

			}

			if (i == 0)
				s.setOrdre(1);
			else
				s.setOrdre(i + 1);
			dao.persist(s);

			tx.commit();
		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d'erreurs
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierSalle(Salle s) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			dao.merge(s);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void supprimerSalle(Salle s) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.delete(s);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public List<Salle> rechercheAvecJointureSalle(String param) {
		List<Salle> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithJoin(param);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}

	public List<Salle> rechercheToutSalle() {
		List<Salle> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAll();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}

	public List<Salle> rechercheSalleAvecMotif(String motifSalle) {
		List<Salle> listeSalle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			listeSalle = dao.findSalleWithMotif(motifSalle);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (listeSalle);

	}

	public Salle rechercheParOrdre(int ordre) {
		Salle s = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			s = dao.findByOrdre(ordre);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return s;
	}

	public Salle rechercheParOrdre(int ordre, List<String> l) {
		Salle s = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			s = dao.findByOrdre(ordre, l);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return s;
	}

	public Salle rechercheSalleParPatient(Integer code) {
		Salle s = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			s = dao.findByPatient(code);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return s;
	}

	public Salle rechercheParId(Integer code) {
		Salle s = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			s = dao.findById(code);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return s;
	}

	public List<Salle> rechercheTouSalleAvecJoin(String param) {
		List<Salle> listeSalle = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			listeSalle = dao.findAllSalleWithJoin(param);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (listeSalle);

	}

}
