package com.doctor.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.dao.HibernateUtil;
import com.doctor.dao.HistoriqueMsgHome;
import com.doctor.persistance.HistoriqueMsg;

public class HistoriqueMsgService {
	private HistoriqueMsgHome dao;

	public HistoriqueMsgService() {
		dao = new HistoriqueMsgHome();
	}

	public void ajoutHistoriqueMsg(HistoriqueMsg historiqueMsg)

	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			dao.persist(historiqueMsg);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public HistoriqueMsg rechercheHistoriqueMsg(Integer cl) {
		HistoriqueMsg historiqueMsg = new HistoriqueMsg();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			historiqueMsg = dao.findById(cl);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (historiqueMsg);

	}

	public void supprimerHistoriqueMsg(Integer code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			HistoriqueMsg cl = new HistoriqueMsg();
			cl.setIdMsg(code);

			dao.delete(cl);

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}

	}

	public List<HistoriqueMsg> rechercheTousHistoriqueMsg() {
		List<HistoriqueMsg> liste = null;
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

	public HistoriqueMsg rechercheParHistoriqueMsg(String historiqueMsg) {
		HistoriqueMsg p = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			p = dao.findByHistoriqueMsg(historiqueMsg);
			tx.commit();
		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return p;
	}

}
