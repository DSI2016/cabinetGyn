package com.doctor.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.ConsultationDetailHome;
import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.Uterus;

public class ConsultationDetailService {
	private ConsultationDetailHome dao;

	public ConsultationDetailService() {
		dao = new ConsultationDetailHome();
	}

	public void ajouterConsultationDetail(ConsultationDetail s) {
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

	public void modifierConsultationDetail(ConsultationDetail s) {
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

	public void supprimerConsultationDetail(ConsultationDetail s) {
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

	public List<ConsultationDetail> rechercheAvecJointureConsultationDetail(
			String param) {
		List<ConsultationDetail> liste = null;
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

	public List<ConsultationDetail> rechercheToutConsultationDetail() {
		List<ConsultationDetail> liste = null;
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

	public List<ConsultationDetail> RechercheParUterus(Uterus u) {
		List<ConsultationDetail> l = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			l = dao.findAllByUterus(u);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (l);
	}

	public List<ConsultationDetail> rechercheToutConsultationDetail(
			Integer idPatient, String nomConsultation, Uterus uterus) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAll(idPatient, nomConsultation, uterus);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}

	public void supprimerConsultationDetail(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		ConsultationDetail hg = new ConsultationDetail();
		hg.setIdConsultationDetail(id);
		try {

			tx = session.beginTransaction();

			dao.delete(hg);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public List<ConsultationDetail> rechercheToutConsultation(Integer idPatient) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAll(idPatient);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	public List<ConsultationDetail> rechercheConsultationBytype(Integer idPatient,Integer idcons) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByType(idPatient,idcons);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	

	public ConsultationDetail rechercheConsultationDetail(
			Integer idConsultationDetail) {
		ConsultationDetail c = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			c = dao.findById(idConsultationDetail);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (c);

	}

	public ConsultationDetail rechercheConsultationDetailAvecJoint(
			Integer idConsultationDetail) {
		ConsultationDetail c = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			c = dao.findWithJoinById(idConsultationDetail);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (c);

	}

	
	public ConsultationDetail rechercheConsultationDetailByConsultationMotiff(
			Integer idConsultationDetail) {
		ConsultationDetail c = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			c = dao.findByConsMotiff(idConsultationDetail);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (c);

	}
	
	
	public List<ConsultationDetail> rechercheConsultationByDate(Date d) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByDate(d);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	public List<ConsultationDetail> rechercheConsultationDeuxDate(Date d1,Date d2) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByTwoDate(d1, d2);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	
	
	public List<ConsultationDetail> rechercheConsultationByIdCons(Integer idcons, Date d) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByIdCons(idcons,d);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	public List<ConsultationDetail> rechercheConsultationByIdConsEntreDeuxDate(Integer idcons, Date d1,Date d2) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByIdConsBetweenDate(idcons,d1,d2);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	
	
	public List<ConsultationDetail> rechercheConsultationByIdCons(Integer idcons) {
		List<ConsultationDetail> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByIdCons(idcons);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}


}
