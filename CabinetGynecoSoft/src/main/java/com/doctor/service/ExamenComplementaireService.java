
package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.ExamenComplementaireHome;
import com.doctor.persistance.ExamenComplementaire;




public class ExamenComplementaireService {
private ExamenComplementaireHome dao;

	
	public ExamenComplementaireService() {
		dao=new ExamenComplementaireHome();
				}

	
	public void ajoutExamenComplementaire(ExamenComplementaire examenComplementaire)
	
	{
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			tx=session.beginTransaction();
			dao.persist(examenComplementaire);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
public void modifierExamenComplementaire(ExamenComplementaire examenComplementaire)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(examenComplementaire);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}

public ExamenComplementaire rechercheExamenComplementaireParLibelleExamenComplementaire(String examenComplementaire) {
	ExamenComplementaire p =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		p= dao.findByExamenComplementaire(examenComplementaire);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return p;
}

public ExamenComplementaire rechercheExamenComplementaire(Integer cl)
{
	ExamenComplementaire examenComplementaire=new ExamenComplementaire();
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			examenComplementaire=dao.findById(cl);
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(examenComplementaire) ;
			

}
public void  supprimerExamenComplementaire(Integer code)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		ExamenComplementaire cl=new ExamenComplementaire();
		cl.setIdexamenComplementaire(code);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
	
	
}
		
		
public List<ExamenComplementaire> affichageAvecJointureExamenComplementaire(String param)
{
	List<ExamenComplementaire> liste =  null;
	
		
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
public List<ExamenComplementaire> rechercheFiltre(String valeurRecherche) {
	List<ExamenComplementaire> liste =  null;
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


public List<ExamenComplementaire> rechercheTousExamenComplementaire()
{
	List<ExamenComplementaire> liste =  null;
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




}



