package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.AnnuleSalleHome;
import com.doctor.persistance.AnnuleSalle;

public class AnnuleSalleService {
	private AnnuleSalleHome dao;

	public AnnuleSalleService() {
		dao = new AnnuleSalleHome();
	}

	
	/**
	 * C'est une méthode pour l'ajout 
	 */
	public void ajouterAnnuleSalle(AnnuleSalle s) {
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

	
	public void supprimerAnnuleSalle(AnnuleSalle s) {
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

	

	public List<AnnuleSalle> rechercheToutAnnuleSalle() {
		List<AnnuleSalle> liste = null;
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
	
	public List<AnnuleSalle> rechercheToutAnnuleSalleAvecJoin() {
		List<AnnuleSalle> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAllWithJoin();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}

	

	public AnnuleSalle rechercheParId(Integer code) {
		AnnuleSalle s = null;
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
}
