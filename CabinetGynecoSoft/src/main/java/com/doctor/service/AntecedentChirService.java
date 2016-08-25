
package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.AntecedentChirHome;
import com.doctor.persistance.AntecedentChir;


public class AntecedentChirService {
private AntecedentChirHome dao;

	
	public AntecedentChirService() {
		dao=new AntecedentChirHome();
				}

	
	
	public void ajoutAntecedentChir(AntecedentChir antecedentChir)
	
	{
		//Ouverture d�une session et d�claration d�une transaction 
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			//Ouverture d�une transaction
			tx=session.beginTransaction();
			//Appel � la m�thode � partir de la classe DOA ������.
			
			dao.persist(antecedentChir);
						
			//Commit de la transaction qui provoque la fermeture de la session
			tx.commit() ;
			}catch(RuntimeException ex){ 
				//Rollback de la transaction en cas d�erreurs
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
		}
public void modifierAntecedentChir(AntecedentChir antecedentChir)
	
	{
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			dao.merge(antecedentChir);
			tx.commit() ;
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		}


public AntecedentChir rechercheAntecedentChir(Integer cl)
{
	AntecedentChir antecedentChir=new AntecedentChir();
	
		
		Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ; 
		try{
			
			tx=session.beginTransaction();
			
			antecedentChir=dao.findById(cl);
			tx.commit() ;
			
			
			}catch(RuntimeException ex){ 
				
				if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
			}
		return(antecedentChir) ;
			

}
public void  supprimerAntecedentChir(Integer code)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		AntecedentChir cl=new AntecedentChir();
		cl.setIdantecedentChir(code);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
	
	
}
		
		
public List<AntecedentChir> affichageAvecJointureAntecedentChir(String param)
{
	List<AntecedentChir> liste =  null;
	
		
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

public List<AntecedentChir> rechercheTousAntecedentChir()
{
	List<AntecedentChir> liste =  null;
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



public AntecedentChir rechercheParAntecedentChir(String libantecedentChir) {
	AntecedentChir p =  null;
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		p= dao.findByAntecedentChir(libantecedentChir);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	return p;
}



public List<AntecedentChir> rechercheParFilterAntecedentChir(
		String valeurRecherche) {
	List<AntecedentChir> liste =  null;
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



