package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.FormeMedicamentHome;
import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.FormeMedicament;


public class FormeMedicamentService {
private FormeMedicamentHome dao;

	
	public FormeMedicamentService() {
		dao=new FormeMedicamentHome();
				}

	
	public void ajoutFormeMedicament(FormeMedicament formeMedicament)
	
	{
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			tx=session.beginTransaction();
			dao.persist(formeMedicament);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
public void modifierFormeMedicament(FormeMedicament formeMedicament)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(formeMedicament);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}

public FormeMedicament rechercheFormeMedicamentParLibelleFormeMedicament(String formeMedicament) {
	FormeMedicament p =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		p= dao.findByFormeMedicament(formeMedicament);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return p;
}

public FormeMedicament rechercheFormeMedicament(Integer cl)
{
	FormeMedicament formeMedicament=new FormeMedicament();
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			formeMedicament=dao.findById(cl);
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(formeMedicament) ;
			

}
public void  supprimerFormeMedicament(Integer code)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		FormeMedicament cl=new FormeMedicament();
		cl.setIdFormeMedicament(code);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
	
	
}
		
		
public List<FormeMedicament> affichageAvecJointureFormeMedicament(String param)
{
	List<FormeMedicament> liste =  null;
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			liste=dao.findAllWithJoin(param);		
					
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(liste) ;
			

}

public List<FormeMedicament> rechercheTousFormeMedicament()
{
	List<FormeMedicament> liste =  null;
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




public List<FormeMedicament> rechercheFiltre(String valeurRecherche) {
	List<FormeMedicament> liste =  null;
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




	

}
