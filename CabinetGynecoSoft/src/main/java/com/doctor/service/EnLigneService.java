
package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.EnLigneHome;
import com.doctor.persistance.EnLigne;


public class EnLigneService {
private EnLigneHome dao;

	
	public EnLigneService() {
		dao=new EnLigneHome();
				}

	
	
	public void ajoutEnLigne(EnLigne enLigne)
	
	{
		//Ouverture d�une session et d�claration d�une transaction 
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			//Ouverture d�une transaction
			tx=session.beginTransaction();
			//Appel � la m�thode � partir de la classe DOA ������.
			
			dao.persist(enLigne);
						
			//Commit de la transaction qui provoque la fermeture de la session
			tx.commit() ;
			}catch(RuntimeException ex){ 
				//Rollback de la transaction en cas d�erreurs
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
public void modifierEnLigne(EnLigne enLigne)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(enLigne);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}


public EnLigne rechercheEnLigne(Integer cl)
{
	EnLigne enLigne=new EnLigne();
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			enLigne=dao.findById(cl);
			tx.commit() ;
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(enLigne) ;
			

}
public void supprimerEnLigne(EnLigne s)
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
		
		
public List<EnLigne> affichageAvecJointureEnLigne(String param)
{
	List<EnLigne> liste =  null;
	
		
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

public List<EnLigne> rechercheTousEnLigne()
{
	List<EnLigne> liste =  null;
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



public EnLigne rechercheParEnLigne(String enLigne) {
	EnLigne p =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		p= dao.findByEnLigne(enLigne);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return p;
}


public List<EnLigne> rechercheFiltre(String valeurRecherche) {
	List<EnLigne> liste =  null;
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



