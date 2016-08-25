package com.doctor.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.RendezVousHome;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.RendezVous;

public class RendezVousService {
	private RendezVousHome dao;

	public RendezVousService() {
		dao = new RendezVousHome();
	}

	public void ajoutRendezVous(RendezVous obj) {
		// Ouverture d�uRendezVousion et d�claration d�une transaction
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			// Ouverture d�une transaction
			tx = session.beginTransaction();
			// Appel � la m�thode � partir de la classe DOA ������.

			dao.persist(obj);

			// Commit de la transaction qui provoque la fermeture de la session
			tx.commit();
		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d�erreurs
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void modifierRendezVous(RendezVous obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.merge(obj);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public RendezVous rechercheRendezVousParId(Integer id) {
		RendezVous obj = new RendezVous();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			obj = dao.findById(id);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (obj);
	}

	public void supprimerRendezVous(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			RendezVous obj = new RendezVous();
			obj.setIdrendezVous(id);
			dao.delete(obj);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public List<RendezVous> rechercheTousRendezVous() {
		List<RendezVous> liste = null;
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

	public List<RendezVous> rechercheTousRendezVousAvecJointure(String param) {
		List<RendezVous> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithJoin(param);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}

	public List<RendezVous> rechercheTousParClient(Cfclient obj) {
		List<RendezVous> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllByPatient(obj);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return liste;
	}

	@SuppressWarnings("deprecation")
	public List<RendezVous> rechercheTousParDate(Date selectedDate)
			throws ParseException {
		List<RendezVous> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<RendezVous> listeFinal = new ArrayList<RendezVous>();
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithJoin("codeclient");
			for (int i = 0; i < liste.size(); i++) {
				Date D1 = selectedDate;
				Date D2 = liste.get(i).getDate();
				boolean EQU = false;
				if (D1 == null || D2 == null)
					;
				else if (D1.getYear() == D2.getYear()
						&& D1.getMonth() == D2.getMonth()
						&& D1.getDate() == D2.getDate())
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

	public List<RendezVous> rechercheParPatient(Integer id) {
		List<RendezVous> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findByPatient(id);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return liste;
	}

	/**
	 * 
	 */
	public List<RendezVous> rechercheRDVParPatient(Integer codeclient, Date date) {
		List<RendezVous> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithPatient(codeclient, date);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
}