package com.doctor.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	public static String login ="";
	public static String pass = "";
	public static String url = "";

	private static SessionFactory sessionFactory;

	static {

		 BufferedReader br;
		 try {
		 br = new BufferedReader(new FileReader(
		 "c:/temp/CabinetGynecoSoft.txt"));
		 try {
		 String driver = "";
		 String adresse = "";
		 String bd = "";
		
		 String line = "";
		
		 if ((line = br.readLine()) != null) {
		 login = line.substring(line.lastIndexOf(" ") + 1);
		 }
		 if ((line = br.readLine()) != null) {
		 pass = line.substring(line.lastIndexOf(" ") + 1);
		 }
		 if ((line = br.readLine()) != null) {
		 driver = line.substring(line.lastIndexOf(" ") + 1);
		 }
		 if ((line = br.readLine()) != null) {
		 adresse = line.substring(line.lastIndexOf(" ") + 1);
		 }
		 if ((line = br.readLine()) != null) {
		 bd = line.substring(line.lastIndexOf(" ") + 1);
		 }
		
		 url = "" + driver + "://" + adresse + "/" + bd + "";
		 } catch (IOException e) {
		 e.printStackTrace();
		
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 }

		try {
			Configuration cfg = new Configuration();
			cfg.setProperty("hibernate.dialect",
					"org.hibernate.dialect.MySQLDialect");
			cfg.setProperty("hibernate.connection.url", url);
			cfg.setProperty("hibernate.connection.username", login);
			cfg.setProperty("hibernate.connection.password", pass);
			cfg.setProperty("hibernate.connection.driver_class",
					"com.mysql.jdbc.Driver");
			cfg.setProperty("hibernate.show_sql", "false");
			cfg.setProperty("hibernate.transaction.factory_class",
					"org.hibernate.transaction.JDBCTransactionFactory");
			cfg.setProperty("hibernate.current_session_context_class", "thread");
			cfg.setProperty("hbm2ddl.auto", "update");

			cfg.addClass(com.doctor.persistance.Cfclient.class);
			cfg.addClass(com.doctor.persistance.Clinique.class);
			cfg.addClass(com.doctor.persistance.Docteur.class);
			cfg.addClass(com.doctor.persistance.Profession.class);
			cfg.addClass(com.doctor.persistance.Salle.class);
			cfg.addClass(com.doctor.persistance.Ville.class);
			cfg.addClass(com.doctor.persistance.Sterile.class);
			cfg.addClass(com.doctor.persistance.HistoriqueGross.class);
			cfg.addClass(com.doctor.persistance.Utilisateur.class);
			cfg.addClass(com.doctor.persistance.Contraception.class);
			cfg.addClass(com.doctor.persistance.HistoriquePatient.class);
			cfg.addClass(com.doctor.persistance.Consultation.class);
			cfg.addClass(com.doctor.persistance.MoyenContraception.class);
			cfg.addClass(com.doctor.persistance.EtatBebe.class);
			cfg.addClass(com.doctor.persistance.AntecedentMed.class);
			cfg.addClass(com.doctor.persistance.AntecedentChir.class);
			cfg.addClass(com.doctor.persistance.AntecedentFam.class);
			cfg.addClass(com.doctor.persistance.AntMedCfclient.class);
			cfg.addClass(com.doctor.persistance.AntChirCfclient.class);
			cfg.addClass(com.doctor.persistance.AntFamCfclient.class);
			cfg.addClass(com.doctor.persistance.ConsultationDetail.class);
			cfg.addClass(com.doctor.persistance.Examen.class);
			cfg.addClass(com.doctor.persistance.Diagnostique.class);
			cfg.addClass(com.doctor.persistance.Symptome.class);
			cfg.addClass(com.doctor.persistance.Radio.class);
			cfg.addClass(com.doctor.persistance.Analyse.class);
			cfg.addClass(com.doctor.persistance.AnalyseDemandee.class);
			cfg.addClass(com.doctor.persistance.ExamenComplementaire.class);
			cfg.addClass(com.doctor.persistance.Medicament.class);
			cfg.addClass(com.doctor.persistance.Ordonnance.class);
			cfg.addClass(com.doctor.persistance.FormeMedicament.class);
			cfg.addClass(com.doctor.persistance.Uterus.class);
			cfg.addClass(com.doctor.persistance.Modele.class);
			cfg.addClass(com.doctor.persistance.EtatFinGross.class);
			cfg.addClass(com.doctor.persistance.MedOrd.class);
			cfg.addClass(com.doctor.persistance.ModeleOrdonnance.class);
			cfg.addClass(com.doctor.persistance.RendezVous.class);
			cfg.addClass(com.doctor.persistance.JourFr.class);
			cfg.addClass(com.doctor.persistance.JourFrSp.class);
			cfg.addClass(com.doctor.persistance.Horaire.class);
			cfg.addClass(com.doctor.persistance.Jour.class);
			cfg.addClass(com.doctor.persistance.Saison.class);
			cfg.addClass(com.doctor.persistance.Cabinet.class);
			cfg.addClass(com.doctor.persistance.Certificat.class);
			cfg.addClass(com.doctor.persistance.HistoriqueCertif.class);
			cfg.addClass(com.doctor.persistance.Lettre.class);
			cfg.addClass(com.doctor.persistance.historiqueLettre.class);
			cfg.addClass(com.doctor.persistance.Connecte.class);
			cfg.addClass(com.doctor.persistance.HistoriqueMsg.class);
			cfg.addClass(com.doctor.persistance.Modelutl.class);
			cfg.addClass(com.doctor.persistance.EnLigne.class);
			cfg.addClass(com.doctor.persistance.AnnuleSalle.class);
			cfg.addClass(com.doctor.persistance.TabSalle.class);
			sessionFactory = cfg.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
