
package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.CliniqueHome;
import com.doctor.persistance.Clinique;


public class CliniqueService {
private CliniqueHome dao;

	
	public CliniqueService() {
		dao=new CliniqueHome();
				}

	
	
	public void ajoutClinique(Clinique clinique)
	
	{
		//Ouverture d�une session et d�claration d�une transaction 
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			//Ouverture d�une transaction
			tx=session.beginTransaction();
			//Appel � la m�thode � partir de la classe DOA ������.
			
			dao.persist(clinique);
						
			//Commit de la transaction qui provoque la fermeture de la session
			tx.commit() ;
			}catch(RuntimeException ex){ 
				//Rollback de la transaction en cas d�erreurs
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
public void modifierClinique(Clinique clinique)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(clinique);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}


public Clinique rechercheClinique(Integer cl)
{
	Clinique clinique=new Clinique();
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			clinique=dao.findById(cl);
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(clinique) ;
			

}
public void  supprimerClinique(Integer code)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		Clinique cl=new Clinique();
		cl.setIdclinique(code);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
	
	
}
		
		
public List<Clinique> affichageAvecJointureClinique(String param)
{
	List<Clinique> liste =  null;
	
		
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

public List<Clinique> rechercheTousClinique()
{
	List<Clinique> liste =  null;
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



public Clinique rechercheParClinique(String libclinique) {
	Clinique p =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		p= dao.findByClinique(libclinique);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return p;
}



public List<Clinique> rechercheFiltre(String valeurRecherche) {
	
	List<Clinique> liste =  null;
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



