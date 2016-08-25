package com.doctor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.HoraireHome;
import com.doctor.persistance.Horaire;

public class HoraireService {
	private HoraireHome dao;

	public HoraireService() {
		dao = new HoraireHome();
	}

	public void ajoutHoraire(Horaire docteur) {
		// Ouverture d�une session et d�claration d�une transaction
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			// Ouverture d�une transaction
			tx = session.beginTransaction();
			// Appel � la m�thode � partir de la classe DOA ������.
			dao.persist(docteur);
			// Commit de la transaction qui provoque la fermeture de la session
			tx.commit();
		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d�erreurs
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierHoraire(Horaire docteur) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.merge(docteur);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Horaire rechercheHoraireParId(Integer cl) {
		Horaire docteur = new Horaire();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			docteur = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (docteur);
	}

	public void supprimerHoraire(Integer code) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Horaire cl = new Horaire();
			cl.setIdHoraire(code);
			dao.delete(cl);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	public List<Horaire> rechercheTousHoraireAvecOrdre(String Ordre) {
		List<Horaire> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllbyOrdre(Ordre);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
	public List<Horaire> rechercheTousHoraire() {
		List<Horaire> liste = null;
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
	
	@SuppressWarnings("deprecation")
	public List<Horaire> rechercheParDates(Date deb,Date fin) {
		List<Horaire> liste = null;
		List<Horaire> listeFinal = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		if(deb==null||fin==null)return null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAll();
			listeFinal = new ArrayList<Horaire>();
			int hd = deb.getHours();
			int md = deb.getMinutes();
			int hf = fin.getHours();
			int mf = fin.getMinutes();
			for(int i=0;i<liste.size();i++){
				if(liste.get(i).getDebut().getHours()==hd&&liste.get(i).getDebut().getMinutes()==md && liste.get(i).getFin().getHours()==hf&&liste.get(i).getFin().getMinutes()==mf)
					listeFinal.add(liste.get(i));
			}
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (listeFinal);
	}

}
