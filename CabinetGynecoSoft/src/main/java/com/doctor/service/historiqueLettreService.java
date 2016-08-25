package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.historiqueLettreHome;
import com.doctor.persistance.Lettre;
import com.doctor.persistance.historiqueLettre;

public class historiqueLettreService {
	private historiqueLettreHome dao;

	public historiqueLettreService() {
		dao = new historiqueLettreHome();
	}

	public void ajoutHistoriqueLettre(historiqueLettre historiqueLettre)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(historiqueLettre);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierHistoriqueLettre(historiqueLettre historiqueLettre)

	{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			dao.merge(historiqueLettre);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	public List<historiqueLettre> rechercheTousHistoriqueLettre() {
		List<historiqueLettre> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAllSanscondition();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	
	public historiqueLettre rechercheHistoriqueLettre(Integer cl) {
		historiqueLettre historiqueLettre = new historiqueLettre();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			historiqueLettre = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (historiqueLettre);

	}

	public void supprimerHistoriqueLettre(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			historiqueLettre cl = new historiqueLettre();
			cl.setIdHistoriquelettre(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<historiqueLettre> rechercheTousHistoriqueLettre(Integer id) {
		List<historiqueLettre> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAll(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}

	public Lettre rechercheCertifParMotif(String motifLettre) {

		Lettre lettre = new Lettre();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			lettre = dao.findByMotif(motifLettre);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (lettre);
	}

}
