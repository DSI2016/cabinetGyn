package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.Cfclient_viewHome;
import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Cfclient_view;
import com.doctor.persistance.Ville;


public class Cfclient_viewService {
	
	
private Cfclient_viewHome dao;

	
	public Cfclient_viewService() {
		dao=new Cfclient_viewHome();
				}
	
	
	public List<Cfclient_view> rechercheTousCfclient_view(boolean archive)
	{
		List<Cfclient_view> liste =  null;
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			liste = dao.findAll(archive);
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(liste);
		
	}

	public List<Cfclient_view> rechercherTriePatient(boolean archive,String attributTri,String ordreTri) {
		List<Cfclient_view> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithTri(archive,attributTri, ordreTri);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	
	
	public List<Cfclient_view> rechercheFiltre(boolean archive,String attribut,
			String valeurRecherche) {
		List<Cfclient_view> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithFilter(archive,attribut, valeurRecherche);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	

	public Integer  total() {
		Integer nbtotal = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			nbtotal = dao.Nbrtotal();
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return nbtotal;

	}
	
	public Integer  totalArchive() {
		Integer nbtotal = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			nbtotal = dao.NbrArchive();
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return nbtotal;

	}
	
	public Integer  totalActive() {
		Integer nbtotal = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			nbtotal = dao.NbrActive();
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return nbtotal;

	}
	
	
	
	
}
