package com.doctor.service;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.MedOrdHome;
import com.doctor.persistance.MedOrd;

public class MedOrdService {
	private MedOrdHome dao;

	public MedOrdService() {
		dao = new MedOrdHome();
	}

	public void ajouterMedOrd(MedOrd s) {
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

	
	


	public void modifierMedOrd(MedOrd s)
	{
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

	public void supprimerMedOrd(MedOrd s)
	{
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

	public List<MedOrd> rechercheAvecJointureMedOrd(String param) {
		List<MedOrd> liste = null;
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
	


	public List<MedOrd> rechercheToutMedOrd() {
		List<MedOrd> liste = null;
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



	public void supprimerMedOrd(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		MedOrd hg=new MedOrd();
		hg.setIdMedOrd(id);
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

	
	

	public MedOrd rechercheMedOrd(Integer idmedOrd) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		MedOrd m=null;
		try {

			tx = session.beginTransaction();

			m= dao.findById(idmedOrd);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		
		
		return m;
	}

	public List<MedOrd> rechercheParIdOrd(Integer idOrdonnance) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<MedOrd>  m=null;
		try {

			tx = session.beginTransaction();

			m= dao.findByOrd(idOrdonnance);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		
		
		return  m;
		
	}


	public List<MedOrd> rechercheParIdModele(Integer idModele) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<MedOrd>  m=null;
		try {

			tx = session.beginTransaction();

			m= dao.findByModele(idModele);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		
		
		return  m;
	}

	public List<MedOrd> rechercheParMedicament(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<MedOrd>  m=null;
		try {

			tx = session.beginTransaction();

			m= dao.findByMedicament(code);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		
		
		return  m;
	}

	public List<MedOrd> rechercheModeleOrdonnanceAvecJoin(Integer idModeleOrd) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<MedOrd>  m=null;
		try {

			tx = session.beginTransaction();

			m= dao.findByModel(idModeleOrd);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		
		
		return  m;
	}

	
	
}
