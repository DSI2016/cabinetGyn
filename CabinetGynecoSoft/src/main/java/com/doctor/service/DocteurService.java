package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.DocteurHome;
import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Docteur;

public class DocteurService {
	private DocteurHome dao;

	public DocteurService() {
		dao = new DocteurHome();
	}

	public void ajoutDocteur(Docteur docteur)

	{
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

	public void modifierDocteur(Docteur docteur)

	{

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

	public Docteur rechercheDocteurParId(Integer cl) {
		Docteur docteur = new Docteur();
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

	public void supprimerDocteur(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			Docteur cl = new Docteur();
			cl.setIddoctor(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<Docteur> rechercheAvecJointureDocteur(String param) {
		List<Docteur> liste = null;

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

	public List<Docteur> rechercheTousDocteur() {
		List<Docteur> liste = null;
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

	public Docteur rechercheParDocteur(String libdocteur) {
		Docteur p = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			p = dao.findByDocteur(libdocteur);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return p;
	}

	public List<Docteur> rechercheFiltre(String valeurRecherche) {
		List<Docteur> liste = null;
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

}
