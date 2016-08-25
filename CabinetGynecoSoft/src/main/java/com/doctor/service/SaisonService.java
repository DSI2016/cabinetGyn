package com.doctor.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.SaisonHome;
import com.doctor.persistance.Saison;

public class SaisonService {
	private SaisonHome dao;

	public SaisonService() {
		dao = new SaisonHome();
	}

	public void ajoutSaison(Saison docteur) {
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

	public void modifierSaison(Saison s) {
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

	public Saison rechercheSaisonParId(Integer cl) {
		Saison docteur = new Saison();
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

	public void supprimerSaison(Integer code) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Saison cl = new Saison();
			cl.setIdSaison(code);
			dao.delete(cl);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public List<Saison> rechercheTousSaison() {
		List<Saison> liste = null;
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

	public List<Saison> rechercheTousSaisonAvecJointure() {
		List<Saison> liste = null;
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

	public List<Saison> rechercheSaisonParDate(Date selected, String jour) {

		List<Saison> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithDate(selected, jour);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}

}
