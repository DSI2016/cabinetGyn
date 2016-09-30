package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.TabSalleHome;
import com.doctor.persistance.TabSalle;

public class TabSalleService {
	private TabSalleHome dao;

	public TabSalleService() {
		dao = new TabSalleHome();
	}
	
	
    public void modifierTabSalle(TabSalle tab)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(tab);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}
	
	
	public List<TabSalle> rechercheToutTabSalle() {
		List<TabSalle> liste = null;
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
	
	public List<TabSalle> rechercheParActive() {
		List<TabSalle> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findbyActive();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	
public void ajoutTabSalle(TabSalle tab)
	
	{
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			tx=session.beginTransaction();
			    dao.persist(tab);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
	
	public List<TabSalle> rechercheParOrdDiff(boolean odrdiff) {
		List<TabSalle> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findbyOrdDiff(odrdiff);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	
	public TabSalle rechercheParId(int id) {
		TabSalle ts = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ts = dao.findById(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return ts ;

	}
	
	
	public TabSalle rechercheParNomTab(String nomTab) {
		TabSalle p =  null;
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			p= dao.findByNomTab(nomTab);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return p;
	}

	
	public List<TabSalle> rechercheParOrd(Integer ord) {
		List<TabSalle> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findbyOrd(ord);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
	
	
}
