package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.JourHome;
import com.doctor.persistance.Jour;

public class JourService {
	private JourHome dao;

	public JourService() {
		dao = new JourHome();
	}

	public void ajoutJour(Jour docteur) {
		// Ouverture d�une session et d�claration d�une transaction
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			// Ouverture d�une transaction
			tx = session.beginTransaction();
			// Appel � la m�thode � partir de la classe DOA ������.
			dao.persist(docteur);
			// Commit de la transaction qui provoque la fermeture de la session
			tx.commit();
		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d�erreurs
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierJour(Jour docteur) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.merge(docteur);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Jour rechercheJourParId(Integer cl) {
		Jour docteur = new Jour();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			docteur = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (docteur);
	}

	public void supprimerJour(Integer code) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Jour cl = new Jour();
			cl.setIdjour(code);
			dao.delete(cl);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public List<Jour> rechercheTousJour() {
		List<Jour> liste = null;
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
	
	public List<Jour> rechercheTousJourAvecJointure() {
		List<Jour> liste = null;
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
	
	public List<Jour> rechercheParIdHoraire(Integer id) {
		List<Jour> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findByIdHoraire(id);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	public List<Jour> rechercheParIdHoraire2(Integer id) {
		List<Jour> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findByIdHoraire2(id);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
}
