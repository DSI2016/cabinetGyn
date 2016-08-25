package com.doctor.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.OrdonnanceHome;
import com.doctor.persistance.Ordonnance;

public class OrdonnanceService {
	private OrdonnanceHome dao;

	public OrdonnanceService() {
		dao = new OrdonnanceHome();
	}

	public void ajoutOrdonnance(Ordonnance ordonnance)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(ordonnance);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierOrdonnance(Ordonnance ordonnance)

	{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			dao.merge(ordonnance);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Ordonnance rechercheOrdonnance(Integer cl) {
		Ordonnance ordonnance = new Ordonnance();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ordonnance = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (ordonnance);

	}

	public void supprimerOrdonnance(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			Ordonnance cl = new Ordonnance();
			cl.setIdOrdonnance(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<Ordonnance> rechercheOrdonnanceParPatient(Integer cl, Date dd,
			Date df, Integer med) {
		List<Ordonnance> ordonnance = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ordonnance = dao.findByPatient(cl, dd, df, med);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (ordonnance);

	}

	public List<Ordonnance> affichageAvecJointureOrdonnance(String param) {
		List<Ordonnance> liste = null;

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

	public List<Ordonnance> rechercheTousOrdonnance() {
		List<Ordonnance> liste = null;
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

	public Ordonnance rechercheParIdOrd(Integer idOrdonnance) {
		Ordonnance ordonnance = new Ordonnance();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ordonnance = dao.findByIdOrd(idOrdonnance);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (ordonnance);

	}

	public List<Ordonnance> rechercheOrdonnanceParConsultation(Integer cl) {
		List<Ordonnance> ordonnance = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ordonnance = dao.findByConsultation(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (ordonnance);

	}

	public List<Ordonnance> rechercheOrdonnanceParPatient(Integer id) {
		List<Ordonnance> ordonnance = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ordonnance = dao.findByPatient(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (ordonnance);

	}

	public List<Ordonnance> rechercheOrdonnanceLibreParPtient(
			Integer idPatient, String type) {
		List<Ordonnance> ordonnance = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ordonnance = dao.findLibreByPatient( idPatient,type);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (ordonnance);
	}

}
