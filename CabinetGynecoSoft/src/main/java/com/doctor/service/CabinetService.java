package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.CabinetHome;
import com.doctor.persistance.Cabinet;

public class CabinetService {
	private CabinetHome dao;

	public CabinetService() {
		dao = new CabinetHome();
	}

	public void ajoutCabinet(Cabinet cabinet)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(cabinet);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierCabinet(Cabinet cabinet)

	{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			dao.merge(cabinet);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Cabinet rechercheCabinetParLibelleCabinet(String cabinet) {
		Cabinet p = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			p = dao.findByCabinet(cabinet);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return p;
	}

	public Cabinet rechercheCabinet(Integer cl) {
		Cabinet cabinet = new Cabinet();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			cabinet = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (cabinet);

	}

	public void supprimerCabinet(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			Cabinet cl = new Cabinet();
			cl.setIdcabinet(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<Cabinet> rechercheFiltre(String valeurRecherche) {
		List<Cabinet> liste = null;
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

	public List<Cabinet> rechercheTousCabinet() {
		List<Cabinet> liste = null;
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

}
