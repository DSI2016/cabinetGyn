package com.doctor.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.JourFrSpHome;
import com.doctor.persistance.JourFrSp;

public class JourFrSpService {
	private JourFrSpHome dao;

	public JourFrSpService() {
		dao = new JourFrSpHome();
	}

	public void ajoutJourFrSp(JourFrSp obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			dao.persist(obj);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierJourFrSp(JourFrSp obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.merge(obj);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public JourFrSp rechercheJourFrSpParId(Integer id) {
		JourFrSp obj = new JourFrSp();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			obj = dao.findById(id);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (obj);
	}

	public void supprimerJourFrSp(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			JourFrSp obj = new JourFrSp();
			obj.setIdjourFrSp(id);
			dao.delete(obj);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	/*
	 * @SuppressWarnings("deprecation") private boolean existe(List<JourFrSp>
	 * list, Date D){ boolean EQU = false; for(int i=0;i<list.size();i++){ Date
	 * D1 = list.get(i).getDate(); Date D2 = D; if(D1==null||D2==null); else
	 * if(D1.getMonth()==D2.getMonth()&&D1.getDate()==D2.getDate()) EQU = true;
	 * } return EQU; }
	 */

	/*
	 * public List<JourFrSp> rechercheTousJourFrSpSansAnnee(){ List<JourFrSp>
	 * liste = null; Session
	 * session=HibernateUtil.getSessionFactory().getCurrentSession();
	 * Transaction tx= null ; List<JourFrSp> listeFinal = new
	 * ArrayList<JourFrSp>(); try{ tx=session.beginTransaction(); liste =
	 * dao.findAll(); for(int i=0;i<liste.size();i++){ Date D =
	 * liste.get(i).getDate(); if(existe(listeFinal, D)); else
	 * listeFinal.add(liste.get(i)); } tx.commit() ; }catch(RuntimeException
	 * ex){ if(tx!= null) tx.rollback(); ex.printStackTrace() ; }
	 * return(listeFinal); }
	 */

	public List<JourFrSp> rechercheTousJourFrSp() {
		List<JourFrSp> liste = null;
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

	
	
	public List<JourFrSp> rechercheTousContientDate(Date selectedDate)
			throws ParseException {
		List<JourFrSp> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<JourFrSp> listeFinal = new ArrayList<JourFrSp>();
		try {
			tx = session.beginTransaction();
			liste = dao.findAll();
			Date D1 = selectedDate;
			for (int i = 0; i < liste.size(); i++) {
				
				Date D2 = liste.get(i).getDebut();
				Date D3=liste.get(i).getFin();
				Calendar cal = Calendar.getInstance();
				cal.setTime(D3);
				cal.add(Calendar.DATE, 1);
				D3=cal.getTime();
				
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(D2);
				cal2.add(Calendar.DATE, -1);
				D2=cal2.getTime();
				boolean EQU = false;
					if(D1.after(D2)&&D1.before(D3))			
					EQU = true;
				if (EQU) {
					listeFinal.add(liste.get(i));
				}
			}
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return listeFinal;
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public List<JourFrSp> rechercheTousParDate(Date selectedDate)
			throws ParseException {
		List<JourFrSp> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<JourFrSp> listeFinal = new ArrayList<JourFrSp>();
		try {
			tx = session.beginTransaction();
			liste = dao.findAll();
			for (int i = 0; i < liste.size(); i++) {
				Date D1 = selectedDate;
				Date D2 = liste.get(i).getDebut();
				boolean EQU = false;
				
				if (D1 == null || D2 == null)
					;
				else if (D1.getMonth() == D2.getMonth()
						&& D1.getDate() == D2.getDate())
					EQU = true;
				if (EQU) {
					listeFinal.add(liste.get(i));
				}
			}
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return listeFinal;
	}
}