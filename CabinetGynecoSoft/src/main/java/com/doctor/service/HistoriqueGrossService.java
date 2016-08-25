package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.HistoriqueGrossHome;
import com.doctor.persistance.HistoriqueGross;

public class HistoriqueGrossService {
	private HistoriqueGrossHome dao;

	public HistoriqueGrossService() {
		dao = new HistoriqueGrossHome();
	}
	
	
	public List<HistoriqueGross> rechercheToutHistoriqueGross(Integer code) {
		List<HistoriqueGross> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findHistoriquePatient(code);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	public  HistoriqueGross rechercheHistoriqueGrossParId(Integer code) {
		HistoriqueGross h=null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			h = dao.findById(code);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (h);

	}




	public void ajouterHistoriqueGross(HistoriqueGross hg) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			 dao.persist(hg);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	public void ModifierHistoriqueGross(HistoriqueGross hg) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			 dao.merge(hg);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}


	public void supprimerHistoriqueGross(Integer code) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		HistoriqueGross hg=new HistoriqueGross();
		hg.setIdhistoriqueGross(code);
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
	
	public List<HistoriqueGross> rechercheHistoriqueParEtatBebe(Integer idEtat){
		List<HistoriqueGross> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findHistoriqueByEtatBebe(idEtat);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
	
	public List<HistoriqueGross> rechercheHistoriqueParidcons(Integer idcons){
		List<HistoriqueGross> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findHistoriqueByIdCons(idcons);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}


	public List<HistoriqueGross> rechercheHistoriqueParEtatGross(Integer id) {
		List<HistoriqueGross> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findHistoriqueByEtatGross(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	
}
