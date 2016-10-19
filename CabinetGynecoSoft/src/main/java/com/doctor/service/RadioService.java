package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.RadioHome;
import com.doctor.persistance.Radio;

public class RadioService {
	private RadioHome dao;

	public RadioService() {
		dao = new RadioHome();
	}

	public void ajoutRadio(Radio radio)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(radio);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierRadio(Radio radio)

	{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			dao.merge(radio);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Radio rechercheRadio(Integer cl) {
		Radio radio = new Radio();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			radio = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (radio);

	}

	public void supprimerRadio(Integer code) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Radio cl = new Radio();
			cl.setIdradio(code);
			dao.delete(cl);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public List<Radio> affichageAvecJointureRadio(String param) {
		List<Radio> liste = null;
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

	public List<Radio> rechercheTousRadio() {
		List<Radio> liste = null;
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

	public List<Radio> rechercheRadioParConsultation(
			Integer idconsultationDetail) {
		List<Radio> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findByConsultation(idconsultationDetail);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}

	public List<Radio> rechercheRadioParPatient(Integer idPatient) {
		List<Radio> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findByPatient(idPatient);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	public List<Radio> rechercheRadioParIdPatient(Integer idPatient) {
		List<Radio> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findByIdPatient(idPatient);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}

	public Radio rechercheRadioAvecJoin(Integer idradio) {
		Radio radio = new Radio();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			radio = dao.findByIdWithJoin(idradio);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (radio);
	}
}
