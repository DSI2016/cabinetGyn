package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.AnalyseDemandeeHome;
import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.AnalyseDemandee;

public class AnalyseDemandeeService {
	private AnalyseDemandeeHome dao;

	public AnalyseDemandeeService() {
		dao = new AnalyseDemandeeHome();
	}

	public void ajoutAnalyseDemandee(AnalyseDemandee analyseDemandee)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(analyseDemandee);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierAnalyseDemandee(AnalyseDemandee analyseDemandee)

	{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			dao.merge(analyseDemandee);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public List<AnalyseDemandee> rechercheAnalyseDemandeeParPatient(Integer cl) {
		List<AnalyseDemandee> analyseDemandee = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			analyseDemandee = dao.findByPatient(cl);
		//	System.out.println("ana= " + analyseDemandee.size());
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (analyseDemandee);

	}

	public void supprimerAnalyseDemandee(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			AnalyseDemandee cl = new AnalyseDemandee();
			cl.setIdanalyseDemandee(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<AnalyseDemandee> affichageAvecJointureAnalyseDemandee(
			String param) {
		List<AnalyseDemandee> liste = null;

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

	public List<AnalyseDemandee> rechercheTousAnalyseDemandee() {
		List<AnalyseDemandee> liste = null;
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

	public List<AnalyseDemandee> rechercheAnalyseParConsultation(
			Integer idConsultationDetail) {
		List<AnalyseDemandee> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByConsultation(idConsultationDetail);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}

	public AnalyseDemandee rechercheAnalyseAvecJoin(Integer idanalyseDemandee) {
		AnalyseDemandee an = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			an = dao.findByIdWithJoin(idanalyseDemandee);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (an);
	}

}
