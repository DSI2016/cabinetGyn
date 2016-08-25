package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.HistoriquePatientHome;
import com.doctor.persistance.HistoriquePatient;

public class HistoriquePatientService {
	private HistoriquePatientHome dao;

	public HistoriquePatientService() {
		dao = new HistoriquePatientHome();
	}

	public void ajouterHistoriquePatient(HistoriquePatient s) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			dao.persist(s);
			tx.commit();
		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d'erreurs
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierHistoriquePatient(HistoriquePatient s)
	{
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

	public void supprimerHistoriquePatient(HistoriquePatient s)
	{
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

	public List<HistoriquePatient> rechercheAvecJointureHistoriquePatient(String param) {
		List<HistoriquePatient> liste = null;
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

	public List<HistoriquePatient> rechercheToutHistoriquePatient() {
		List<HistoriquePatient> liste = null;
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

	public List<HistoriquePatient> rechercheToutHistoriquePatient(Integer idPatient) {

		List<HistoriquePatient> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findHistoriquePatient(idPatient);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}

	public void supprimerHistoriquePatient(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		HistoriquePatient hg=new HistoriquePatient();
		hg.setIdhistoriquePatient(id);
		try {

			tx = session.beginTransaction();

			 dao.delete(hg);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	

}
