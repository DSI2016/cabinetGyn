package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.LettreHome;
import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Lettre;

public class LettreService {
	
		private LettreHome dao;

		public LettreService() {
			dao = new LettreHome();
		}

		public void ajoutLettre(Lettre lettre)

		{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				dao.persist(lettre);
				tx.commit();
			} catch (RuntimeException ex) {
				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}
		public Lettre rechercheParlettre(String lettre) {
			Lettre p =  null;
			Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx= null ; 
			try{
				
				tx=session.beginTransaction();
				p= dao.findByLettre(lettre);
				tx.commit() ;
				}catch(RuntimeException ex){ 
					
					if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
				}
			return p;
		}
		public void modifierlettre(Lettre lettre)

		{

			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();
				dao.merge(lettre);
				tx.commit();
			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}

		public Lettre recherchelettreParLibellelettre(String nomlettre) {
			Lettre p = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();
				p = dao.findByLettre(nomlettre);
				tx.commit();
			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return p;
		}

		
		public void supprimerlettre(Integer code) {

			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();
				Lettre cl = new Lettre();
				cl.setIdlettre(code);

				dao.delete(cl);

				tx.commit();
			} catch (RuntimeException ex) {
				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}

		}

		public List<Lettre> rechercheFiltre(String valeurRecherche) {
			List<Lettre> liste = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				liste = dao.findAllWithFilter(valeurRecherche);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return (liste);
		}

		public List<Lettre> rechercheTouslettre() {
			List<Lettre> liste = null;
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

		
}
