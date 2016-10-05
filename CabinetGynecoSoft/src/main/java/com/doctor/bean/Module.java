package com.doctor.bean;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import com.doctor.dao.HibernateUtil;
import com.mysql.jdbc.Connection;

public class Module {

	static String patientEnConsultation;
	static String connecte = "";
	static String consultation = "";
	static String rechercheProf = "";
	static String rechercheClinique = "";
	static String rechercheVille = "";
	static String rechercheDocteur = "";
	static String rechercheEtatGross = "";
	static String rechercheEtatBebe = "";
	static String rechercheAnalyse = "";
	static String rechercheExamen = "";
	static String rechercheContracept = "";
	static String recherchediagnos = "";
	static String recherchesympt = "";
	static String rechercheExamenComp = "";
	static String rechercheFormMed = "";
	static String recherchePatient = "";
	static String rechercheUterus = "";
	static String rechercheMedicament = "";
	static String rechercheAntecedent = "";
	public static int[] nbJourMois = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };

	static boolean dateDepassee(String date) { // pour verifier que le date ne
												// depasse pas le date system
		boolean success = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar today = new GregorianCalendar();// contient le date system
		Calendar userDate = new GregorianCalendar();

		try {
			userDate.setTime(dateFormat.parse(date));// pour converser la chaine
														// en date
			if (userDate.after(today))// le fonction after pour tester le date
										// depassee date system

				success = true;
		} catch (ParseException e) {
			userDate = null;
		}
		// succes =true ==> date est dépassé
		return (success);
	}

	static boolean dateTresAncien(String date) { // pour verifier que le date ne

		boolean success = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar userDate = new GregorianCalendar();
		Calendar hier = new GregorianCalendar();
		hier.set(GregorianCalendar.YEAR, 1900);
		hier.set(GregorianCalendar.MONTH, 1);
		hier.set(GregorianCalendar.DATE, 1);

		try {
			userDate.setTime(dateFormat.parse(date));// pour converser la chaine
			// en date
			if (userDate.before(hier))// le fonction after pour tester le date
				// depassee date system
				success = true;
		} catch (ParseException e) {
			userDate = null;
		}
		return (success);
	}

	// retourner les deucx premier entier de la chaine
	public static Integer NumericTermeGrossese(String terme) {
		if (isNumeric(terme.substring(0, 2)) == true)
			return (Integer.parseInt(terme.substring(0, 2)));
		else if (isNumeric(terme.substring(0, 1)) == true) {
			return (Integer.parseInt(terme.substring(0, 1)));
		} else

			return null;

	}

	// verifier le chaine numeric ou non

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	static int nbRepetition(String stringA, String stringB) {
		int count = 0;
		for (int i = 0; i < (stringA.length() - stringB.length()); i++) {
			String subString = stringA.substring(i, stringB.length());
			if (subString.equals(stringB)) {
				count++;
			}
		}
		return count;
	}

	static int printType(String x) {
		return (0);
	}

	static int printType(byte x) {
		return (1);
	}

	static int printType(int x) {
		return (2);
	}

	static int printType(float x) {
		return (3);
	}

	static int printType(double x) {
		return (4);
	}

	static int printType(char x) {
		return (5);
	}

	static String corigerFormatDate(String date) {
		String date1 = date;
		String jour = "";
		String mois = "";
		String annee = "";

		if ((date.length() == 8) && (date.indexOf("/") == -1)) {
			if (date.indexOf("/") == -1) {
				jour = date.substring(0, 2);
				mois = date.substring(2, 4);
				annee = date.substring(4, 8);
				date1 = jour + "/" + mois + "/" + annee;
			}

		} else if (date.length() == 9) {
			if (nbRepetition("/", date) == 1)
				if (date.indexOf("/") == 2) {
					jour = date.substring(0, 2);
					mois = date.substring(3, 5);
					annee = date.substring(5, 9);
					date1 = jour + "/" + mois + "/" + annee;
				}
			if (date.indexOf("/") == 4) {
				jour = date.substring(0, 2);
				mois = date.substring(2, 4);
				annee = date.substring(5, 9);
				date1 = jour + "/" + mois + "/" + annee;
			}

		} else if ((date.length() == 10) && (date.indexOf("/") == 2)
				&& (date.indexOf("/") == 5))

		{
			date1 = date;
		}

		// travail Meriem
		// if ((date.length() == 6) && (date.indexOf("/") == -1)) {
		// jour = "0" + date.substring(0, 1);
		//
		// mois = "0" + date.substring(1, 2);
		// annee = date.substring(2, 6);
		// date1 = jour + "/" + mois + "/" + annee;
		// System.out.println("année   " + annee);
		//
		// }

		// travail amani
		if ((date.length() == 6) && (date.indexOf("/") == -1)) {
			jour = date.substring(0, 2);
			mois = date.substring(2, 4);
			annee = date.substring(4, 6);
			int a = Integer.parseInt(annee);
			if (a > 1 && a < 50)
				a += 2000;
			else
				a += 1900;
			date1 = jour + "/" + mois + "/" + a;
			// System.out.println("année   " + annee);

		}

		if ((date.length() == 7) && (date.indexOf("/") == 1)) {
			jour = date.substring(0, 1);

			mois = "0" + date.substring(2, 3);
			annee = date.substring(3, 7);
			date1 = jour + "/" + mois + "/" + annee;

		}
		// System.out.println(date1);
		return (date1);

	}

	static boolean testBissextile(int annee) {
		boolean res;
		if (annee % 400 == 0) {
			res = true;
		} else {
			if (annee % 100 == 0) {
				res = false;
			} else {
				if (annee % 4 == 0) {
					res = true;
				} else {
					res = false;
				}
			}
		}
		return res;
	}

	/* Calcul du nombre de jours d'un mois */

	static int nombreJoursMois(int mois, int annee) {
		int res;
		switch (mois) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			res = 31;
		}
			break;
		case 4:
		case 6:
		case 9:
		case 11: {
			res = 30;
		}
			break;
		case 2: {
			if (testBissextile(annee) == true) {
				res = 29;
			} else {
				res = 28;
			}
		}
			break;
		default: {
			res = -1;
		}
			break;
		}
		return res;
	}

	static String corigerDate(String date1) { // pour coriger le format de date
												// si possible
		try {
			String date3;
			String date = corigerFormatDate(date1);

			String[] tNaiss = date.split("/");
			Integer jour2 = Integer.parseInt(tNaiss[0]);
			Integer mois2 = Integer.parseInt(tNaiss[1]);
			Integer annee2 = Integer.parseInt(tNaiss[2]);

			String jours = jour2.toString();
			String moiss = mois2.toString();
			String annees = annee2.toString();

			if ((jours.length() < 2) && (jours.length() > 0)) {
				jours = "0" + jour2;
			}
			if ((moiss.length() < 2) && (moiss.length() > 0)) {
				moiss = "0" + mois2;
			}

			date3 = jours + "/" + moiss + "/" + annees;

			return (date3);

		} catch (java.lang.ArrayIndexOutOfBoundsException e1) {
			return (null);
		} catch (java.lang.NumberFormatException e) {

			return (null);
		}

	}

	static boolean estUnEntier(String chaine) { // pour verifier le chaine est
												// numerique ou non
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	static boolean isValid(String strdate, String format) { // pour verifier le
															// format de date
															// est de la forme
															// dd/mm/yyyy
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			df.parse(strdate);
			return true;
		} catch (ParseException ex) {

			return false;
		}
	}

	static String verifierDate(String date) {
		// retourner un msg d ereur si le date n est pas valide et ""
		// si nn

		String msg = "";
		String format = "dd/MM/yyyy";

		if (isValid(date, format) == false)

			msg = "Format Date Invalide";

		else {
			try {
				String[] tNaiss = date.split("/");
				String annees = tNaiss[2].toString();
				try {
					Integer jour = Integer.parseInt(tNaiss[0]);
					Integer mois = Integer.parseInt(tNaiss[1]);
					Integer annee = Integer.parseInt(tNaiss[2]);

					if ((jour > 30)
							&& ((mois == 1) || (mois == 5) || (mois == 6)

							|| (mois == 10) || (mois == 12) || (mois == 2))) {

						msg = "Date Invalide.";
					}
					if (dateTresAncien(date) == true) {

						msg = msg + "Date Invalide !tres ancien!";

					}

					if (jour > 31 || jour < 1)
						msg = "Date Invalide.";
					if (mois > 12 || mois < 1)
						msg = "Date Invalide.";

					if (annees.length() > 4 || annees.length() < 4)
						msg = "Date Invalide.";

					if (mois == 2) {
						if (((annee % 4 == 0) && (annee % 100 != 0))
								|| ((annee % 400 == 0) && (annee % 100 == 0))) {

							if (jour > 29)
								msg = "Date Invalide !Verifier fevrier!.";
						}

						else {
							if (jour > 28) {
								msg = "Date Invalide!Verifier fevrier!.";
							}
						}
					}
					if (annee > 3000)
						msg = msg + "!Date Invalide!";
					else if (dateDepassee(date) == true) {

						msg = msg + "!Date Dépassé!";

					}
				} catch (NumberFormatException e) {
					msg = "Date Invalide";
				}

			} catch (java.lang.ArrayIndexOutOfBoundsException e1) {
				msg = "Date Invalide";
			}
		}

		return (msg);
	}

	public static int calculAgeEnAns(String dateNaiss) {

		if (dateNaiss != null && dateNaiss.length() > 0) {
			int i = dateNaiss.lastIndexOf("/");
			int j = Integer.parseInt(dateNaiss.substring(i + 1));
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);

			return (year - j);
		}

		return 0;
	}

	public static int calculAgeEnAnsParRapportDateRapport(String dateNaiss,
			String DateRapport) {
if((verifierDate(dateNaiss).equals(""))&&(verifierDate(dateNaiss).equals("")))
{	
		if (dateNaiss != null && dateNaiss.length() > 0) {
			int i = dateNaiss.lastIndexOf("/");
			int j = Integer.parseInt(dateNaiss.substring(i + 1));
			if (DateRapport != null && DateRapport.length() > 0) {
			int year = Integer.parseInt(DateRapport.substring(i + 1));
			return (year - j);
				
		
		}
		}
}
		return 0;
	}

	public static String age(String dateNaiss) {
		Date toDay = new Date();
		int jnaiss;
		int j;

		int mnaiss;
		int m;

		int anaiss;
		int a;

		int ans;
		int mois;
		int jours;

		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String DateDuJour = sf.format(toDay);

		String[] tNaiss = dateNaiss.split("/");
		if (tNaiss.length == 3) {
			jnaiss = Integer.parseInt(tNaiss[0]);
			mnaiss = Integer.parseInt(tNaiss[1]);
			anaiss = Integer.parseInt(tNaiss[2]);

			String[] t = DateDuJour.split("/");
			j = Integer.parseInt(t[0]);
			m = Integer.parseInt(t[1]);
			a = Integer.parseInt(t[2]);

			ans = a - anaiss;

			if (m < mnaiss) {
				ans--;
				mois = 12 - (mnaiss - m);
			} else
				mois = m - mnaiss;

			if (j < jnaiss) {
				if (mois == 0) {
					ans--;
					mois = 11;
					jours = nbJourMois[m - 1] - (jnaiss - j);
				} else {
					mois--;
					jours = j + (nbJourMois[m - 1] - jnaiss);
				}

			} else
				jours = j - jnaiss;

			String resultat = "";
			if (ans != 0)
				resultat += ans + "a ";

			if (mois != 0)
				resultat += mois + "m ";

			if (jours != 0)
				resultat += jours + "j";

			return resultat;
		} else
			return "0";
	}

	static void imprimer(String nomReport, Map<String, Object> param)
			throws SQLException, Exception {

		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));

		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), param,
				connection);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();

	}

	static String menuSal;
	static String menuGestPat;
	static String menuParametre;
	static String menuRapport;
	static String menuGestUtl;
	static String ajoutPatient;
	static String nouvPatSal;
	static String verConsult;
	static String verSal;
	static String modPatient;
	static String chargPatient;
	static String detPatient;
	static String supPatient;
	static String tabInfGenAjoutPat;
	static String tabAddAjoutPat;
	static String tabCntctAjoutPat;
	static String tabInfoConjAjoutPat;
	static String tabAutreInfAjoutPat;
	static String gestDoc;
	static String gestProf;
	static String gestVil;
	static String gestClin;
	static String rappCertif;
	static String rappOrdnce;
	static String rappLettre;
	static String monterPatSal;
	static String desdrePatSal;
	static String permutPatSal;
	static String premierPatSal;
	static String dernierPatSal;
	static String supPatSal;
	static String chargPatSal;
	static String ajoutDoc;
	static String modifDoc;
	static String supDoc;
	static String ajoutProf;
	static String modifProf;
	static String supProf;
	static String ajoutVil;
	static String modifVil;
	static String supVil;
	static String ajoutClin;
	static String modifClin;
	static String supClin;
	static String antecedent;
	static String echoGyn;
	static String echoObs;
	static String gynecologie;
	static String consultGros;
	static String sterilite;
	static String tabAntecedent;
	static String tabGynecoObs;
	static String tabHistGross;
	static String tabContraception;
	static String supHistGross;
	static String modifHistGross;
	static String supConctraeption;
	static String modifContraception;
	static String nouvGross;
	static String nouvContraception;
	static String nouvConsGross;
	static String nouvConsGyn;
	static String consultGrossOrd;
	static String consultGrossAnal;
	static String consultGrossRadio;
	static String gynOrd;
	static String gynAnal;
	static String gynRadio;
	static String menuConfig;
	static String certifFiche;
	static String lettreFiche;
	static String analyseFiche;
	static String radioFiche;
	static String rapportFiche;
	static String ordnanceFiche;
	static boolean actif;
	static boolean passif;
	static String action;

}