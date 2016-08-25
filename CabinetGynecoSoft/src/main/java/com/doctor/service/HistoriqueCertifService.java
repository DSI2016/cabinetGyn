package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.HistoriqueCertifHome;
import com.doctor.persistance.HistoriqueCertif;

public class HistoriqueCertifService {
	private HistoriqueCertifHome dao;

	public HistoriqueCertifService() {
		dao = new HistoriqueCertifHome();
	}

	public void ajoutHistoriqueCertif(HistoriqueCertif historiqueCertif)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(historiqueCertif);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierHistoriqueCertif(HistoriqueCertif historiqueCertif)

	{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			dao.merge(historiqueCertif);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}



	public HistoriqueCertif rechercheHistoriqueCertif(Integer cl) {
		HistoriqueCertif historiqueCertif = new HistoriqueCertif();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			historiqueCertif = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (historiqueCertif);

	}

	public void supprimerHistoriqueCertif(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			HistoriqueCertif cl = new HistoriqueCertif();
			cl.setIdHistoriqueCertif(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<HistoriqueCertif> rechercheFiltre(String valeurRecherche) {
		List<HistoriqueCertif> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAllWithFilter(valeurRecherche);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}

	public List<HistoriqueCertif> rechercheTousHistoriqueCertif() {
		List<HistoriqueCertif> liste = null;
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
	
	
	public List<HistoriqueCertif> rechercheTousHistoriqueCertifByPatient(Integer idPatient) {
		List<HistoriqueCertif> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAllByPatient(idPatient);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	
	
	public List<HistoriqueCertif> rechercheTousHistoriqueCertifByPatientBycertifpresaccom() {
		List<HistoriqueCertif> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAllByPatientBypressenceacomp();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	

	

}
