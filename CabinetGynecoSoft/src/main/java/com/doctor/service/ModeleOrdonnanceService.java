package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.ModeleOrdonnanceHome;
import com.doctor.persistance.ModeleOrdonnance;

public class ModeleOrdonnanceService {
	
private ModeleOrdonnanceHome dao;

	
	public ModeleOrdonnanceService() {
		dao=new ModeleOrdonnanceHome();
				}
	
	public void ajoutModeleOrdonnance(ModeleOrdonnance modeleOrdonnance)
	
	{
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			tx=session.beginTransaction();
			
			dao.persist(modeleOrdonnance);
						
			tx.commit() ;
			}catch(RuntimeException ex){ 
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
public void modifierModeleOrdonnance(ModeleOrdonnance modeleOrdonnance)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(modeleOrdonnance);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}


public ModeleOrdonnance rechercheModeleOrdonnance(Integer cl)
{
	ModeleOrdonnance modeleOrdonnance=new ModeleOrdonnance();
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			modeleOrdonnance=dao.findById(cl);
			tx.commit() ;
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(modeleOrdonnance) ;
			

}
public void  supprimerModeleOrdonnance(Integer code)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		ModeleOrdonnance cl=new ModeleOrdonnance();
		cl.setIdModeleOrdonnance(code);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
	
	
}
		
		
public List<ModeleOrdonnance> affichageAvecJointureModeleOrdonnance(String param)
{
	List<ModeleOrdonnance> liste =  null;
	
		
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

public List<ModeleOrdonnance> rechercheTousModeleOrdonnance()
{
	List<ModeleOrdonnance> liste =  null;
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



public ModeleOrdonnance rechercheParModeleOrdonnance(String modeleOrdonnance) {
	ModeleOrdonnance p =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		p= dao.findByModeleOrdonnance(modeleOrdonnance);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return p;
}



public ModeleOrdonnance rechercheModeleOrdonnanceAvecJoin(Integer idMO) {

	
	ModeleOrdonnance o =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		o= dao.findByIdModeleOrdonnanceWithJoin(idMO);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return o;
}


}
