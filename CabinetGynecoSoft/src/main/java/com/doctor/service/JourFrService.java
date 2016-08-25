package com.doctor.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.JourFrHome;
import com.doctor.persistance.JourFr;

public class JourFrService {
	private JourFrHome dao;
	
	public JourFrService(){
		dao = new JourFrHome();
	}
	
	public void ajoutJourFr(JourFr obj){
		//Ouverture d�uJourFrion et d�claration d�une transaction 
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			//Ouverture d�une transaction
			tx=session.beginTransaction();
			//Appel � la m�thode � partir de la classe DOA ������.
			
			dao.persist(obj);
						
			//Commit de la transaction qui provoque la fermeture de la session
			tx.commit() ;
			}catch(RuntimeException ex){ 
				//Rollback de la transaction en cas d�erreurs
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
	}
	
	public void modifierJourFr(JourFr obj){
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			tx=session.beginTransaction();
			dao.merge(obj);
			tx.commit() ;
		}catch(RuntimeException ex){ 	
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	}

	public JourFr rechercheJourFrParId(Integer id){
		JourFr obj = new JourFr();
			Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx= null ; 
			try{
				tx=session.beginTransaction();
				obj = dao.findById(id);
				tx.commit() ;
			}catch(RuntimeException ex){ 
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(obj) ;
	}
	
	public void  supprimerJourFr(Integer id){
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			tx=session.beginTransaction();
			JourFr obj=new JourFr();
			obj.setIdjourFr(id);
			dao.delete(obj);
			tx.commit() ;
		}catch(RuntimeException ex){ 
			if(tx!= null) tx.rollback();
			ex.printStackTrace() ; 
		}
	}
	
	@SuppressWarnings("deprecation")
	private boolean existe(List<JourFr> list, Date D){
		boolean EQU = false;
		for(int i=0;i<list.size();i++){
			Date D1 = list.get(i).getDate();
			Date D2 = D;
			if(D1==null||D2==null);
			else
				if(D1.getMonth()==D2.getMonth()&&D1.getDate()==D2.getDate())
					EQU = true;
		}
		return EQU;
	}
	
	public List<JourFr> rechercheTousJourFrSansAnnee(){
		List<JourFr> liste =  null;
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		List<JourFr> listeFinal = new ArrayList<JourFr>();
		try{
			tx=session.beginTransaction();
			liste = dao.findAll();
			for(int i=0;i<liste.size();i++){
				Date D = liste.get(i).getDate();
				if(existe(listeFinal, D));
				else
					listeFinal.add(liste.get(i));
			}
			tx.commit() ;
		}catch(RuntimeException ex){ 
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
		return(listeFinal);	
	}
	
	public List<JourFr> rechercheTousJourFr(){
		List<JourFr> liste =  null;
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			tx=session.beginTransaction();
			liste = dao.findAll();
			tx.commit() ;
		}catch(RuntimeException ex){ 
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
		return(liste);	
	}
	

	public List<JourFr> rechercheTousContientDate(Date selectedDate)
			throws ParseException {
		List<JourFr> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<JourFr> listeFinal = new ArrayList<JourFr>();
		try {
			tx = session.beginTransaction();
			liste = dao.findAll();
			Date D1 = selectedDate;
			for (int i = 0; i < liste.size(); i++) {
				
				Date D2 = liste.get(i).getDate();
				Date D3=liste.get(i).getDateFin();
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
	public List<JourFr> rechercheTousParDate(Date selectedDate) throws ParseException {
		List<JourFr> liste =  null;
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ;
		List<JourFr> listeFinal = new ArrayList<JourFr>();
		try{
			tx=session.beginTransaction();
			liste = dao.findAll();
			for(int i=0;i<liste.size();i++){
				Date D1 = selectedDate;
				Date D2 = liste.get(i).getDate();
				boolean EQU = false;
				if(D1==null||D2==null);
				else
					if(D1.getMonth()==D2.getMonth()&&D1.getDate()==D2.getDate())
						EQU = true;
				if(EQU){
					listeFinal.add(liste.get(i));
				}
			}
			tx.commit() ;
			}catch(RuntimeException ex){ 
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return listeFinal;
	}
}