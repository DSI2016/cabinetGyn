package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.ExamenHome;
import com.doctor.persistance.Diagnostique;
import com.doctor.persistance.Examen;


public class ExamenService {
	private ExamenHome dao;

	public ExamenService() {
		dao = new ExamenHome();
	}

	public void ajouterExamen(Examen s) {
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

	public void modifierExamen(Examen s)
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

	public void supprimerExamen(Examen s)
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

	public List<Examen> rechercheAvecJointureExamen(String param) {
		List<Examen> liste = null;
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

	public List<Examen> rechercheToutExamen() {
		List<Examen> liste = null;
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

	public List<Examen> rechercheFiltre(String valeurRecherche) {
		List<Examen> liste =  null;
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			liste = dao.findAllWithFilter(valeurRecherche);
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(liste);
	}


	public void supprimerExamen(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Examen hg=new Examen();
		hg.setIdexamen(id);
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

	
	
	
	
	public Examen rechercheExamenParLibelExamen(String e) {
		Examen p =  null;
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			p= dao.findByExamen(e);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return p;
	}
	
	
	public Examen rechercheExamen(Integer idexamen) {
		return null;
	}

	public Diagnostique rechercheDiagnostique(Integer idexamen) {
		return null;
	}

	

}
