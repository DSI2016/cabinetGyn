package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.ConnecteHome;
import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Connecte;

public class ConnecteService {
	private ConnecteHome dao;

	public ConnecteService() {
		dao = new ConnecteHome();
	}

	public void ajoutConnecte(Connecte connecte)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			dao.persist(connecte);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Connecte rechercheConnecte(Integer cl) {
		Connecte connecte = new Connecte();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			connecte = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (connecte);

	}

	public void supprimerConnecte(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			Connecte cl = new Connecte();
			cl.setIdConnecte(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<Connecte> rechercheTousConnecte() {
		List<Connecte> liste = null;
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

	public Connecte rechercheParConnecte(String connecte) {
		Connecte p = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			p = dao.findByConnecte(connecte);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return p;
	}

}
