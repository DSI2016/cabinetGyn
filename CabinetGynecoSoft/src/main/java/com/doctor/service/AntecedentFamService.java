
package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.AntecedentFamHome;
import com.doctor.persistance.AntecedentFam;


public class AntecedentFamService {
private AntecedentFamHome dao;

	
	public AntecedentFamService() {
		dao=new AntecedentFamHome();
				}

	
	
	public void ajoutAntecedentFam(AntecedentFam antecedentFam)
	
	{
		//Ouverture d�une session et d�claration d�une transaction 
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			//Ouverture d�une transaction
			tx=session.beginTransaction();
			//Appel � la m�thode � partir de la classe DOA ������.
			
			dao.persist(antecedentFam);
						
			//Commit de la transaction qui provoque la fermeture de la session
			tx.commit() ;
			}catch(RuntimeException ex){ 
				//Rollback de la transaction en cas d�erreurs
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
public void modifierAntecedentFam(AntecedentFam antecedentFam)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(antecedentFam);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}


public AntecedentFam rechercheAntecedentFam(Integer cl)
{
	AntecedentFam antecedentFam=new AntecedentFam();
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			antecedentFam=dao.findById(cl);
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(antecedentFam) ;
			

}
public void  supprimerAntecedentFam(Integer code)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		AntecedentFam cl=new AntecedentFam();
		cl.setIdantecedentFam(code);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
	
	
}
		
		
public List<AntecedentFam> affichageAvecJointureAntecedentFam(String param)
{
	List<AntecedentFam> liste =  null;
	
		
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

public List<AntecedentFam> rechercheTousAntecedentFam()
{
	List<AntecedentFam> liste =  null;
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



public AntecedentFam rechercheParAntecedentFam(String libantecedentFam) {
	AntecedentFam p =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		p= dao.findByAntecedentFam(libantecedentFam);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return p;
}



public List<AntecedentFam> rechercheTousAntecedentFam(String valeurRecherche) {
	List<AntecedentFam> liste =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		
		liste = dao.findWithFilter(valeurRecherche);
		tx.commit() ;
		
		
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return(liste);
}

}



