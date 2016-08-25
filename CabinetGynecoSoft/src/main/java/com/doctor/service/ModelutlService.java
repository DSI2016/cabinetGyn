package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.ModelutlHome;
import com.doctor.persistance.Modelutl;

public class ModelutlService {

	private ModelutlHome dao;

	public ModelutlService() {
		dao = new ModelutlHome();
	}

	public void ajoutModelutl(Modelutl modelutl) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(modelutl);

			// Commit de la transaction qui provoque la fermeture de la session
			tx.commit();
		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d�erreurs
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Modelutl rechercheModelutlbyId(Integer idmdlU) {

		Modelutl modelutl = new Modelutl();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			modelutl = dao.findById(idmdlU);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (modelutl);

	}

	public void supprimerModelutl(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			Modelutl modulUtl = new Modelutl();
			modulUtl.setIdmodelUtl(code);
			dao.delete(modulUtl);
			tx.commit();

		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<Modelutl> rechercheTousModelutl() {
		List<Modelutl> liste = null;
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

	public Modelutl rechercheParNomModelutl(String nomModelutl) {
		Modelutl m = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			m = dao.findByNomModelutl(nomModelutl);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return m;
	}

}
