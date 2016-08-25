package com.doctor.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.service.CfclientService;
import com.doctor.service.ConsultationDetailService;

@ManagedBean(name = "fichePatientBean")
@SessionScoped
public class FichePatientBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idPatient;
	private Cfclient cfclient;
	private String profession;
	private String professionC;
	private String vil;
	private int age;
	private String agePat;
	private String consult = "";
	private String notes2;
	private int parite;
	private int nbrConsEchoObs;
	private int nbrConsEchoGyn;
	private int nbrConsObs;
	private int nbrConsGyn;
	private List<ConsultationDetail> toutConsultationsConObs = new ArrayList<ConsultationDetail>();
	private List<ConsultationDetail> toutConsultationsConsGyn = new ArrayList<ConsultationDetail>();
	private List<ConsultationDetail> toutConsultationsConsEchoGyn = new ArrayList<ConsultationDetail>();
	private List<ConsultationDetail> toutConsultationsConsEchoObs = new ArrayList<ConsultationDetail>();

	public String getAgePat() {
		return agePat;
	}

	public void setAgePat(String agePat) {
		this.agePat = agePat;
	}

	public void goToListePatients() {
		// Module.recherchePatient = "";

		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public int getParite() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		// idPatient = Module.idpatient;
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		parite = c.getPartie();

		return parite;
	}

	public void setParite(int parite) {
		this.parite = parite;
	}

	public String getNotes2() {
		notes2 = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		// idPatient = Module.idpatient;
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		notes2 = c.getNotes2();

		return notes2;
	}

	public void setNotes2(String notes2) {
		this.notes2 = notes2;
	}

	public String getConsult() {
		return consult;
	}

	public void setConsult(String consult) {
		this.consult = consult;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVil() {
		return vil;
	}

	public void setVil(String vil) {
		this.vil = vil;
	}

	public String getProfessionC() {
		return professionC;
	}

	public void setProfessionC(String professionC) {
		this.professionC = professionC;
	}

	public Cfclient getCfclient() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		// idPatient = Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		age = 0;
		agePat = "0";
		if (cfclient != null && cfclient.getDateNaiss() != null) {
			agePat = calculAgeS(cfclient.getDateNaiss());
		} else
			agePat = "0";

		if (cfclient.getProfessionByProfessp() != null) {
			profession = cfclient.getProfessionByProfessp().getLibprofession();
		} else
			profession = "";

		if (cfclient.getProfessionByProfesscp() != null) {
			professionC = cfclient.getProfessionByProfesscp()
					.getLibprofession();
		} else
			professionC = "";

		if (cfclient.getVille() != null) {
			vil = cfclient.getVille().getVille();
		} else
			vil = "";
		parite = cfclient.getPartie();
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@SuppressWarnings("unused")
	private int calculAge(String dateNaiss) {

		int i = dateNaiss.lastIndexOf("/");
		int j = Integer.parseInt(dateNaiss.substring(i + 1));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		return (year - j);
	}

	public String nouvelleConsult() {
		String result = null;
		if (consult.equals("consGross"))
			result = "/pages/NouvelleConsultation.xhtml";
		if (consult.equals("echoobs"))
			result = "echoobs";
		Module.consultation = consult;
		return result;
	}

	public void modifAlergie() {
		CfclientService ser = new CfclientService();
		ser.modifierPatient(cfclient);
	}

	public void allergieChange() {
		CfclientService ser = new CfclientService();
		ser.modifierPatient(cfclient);
	}

	private String notes;

	public String getNotes() {
		notes = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		// idPatient = Module.idpatient;
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		notes = c.getNotes();
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void majNote() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		// idPatient = Module.idpatient;
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		c.setNotes(notes);
		ser.modifierPatient(c);
	}

	public int nbrConslt(Integer idPatient) {

		if (idPatient != null) {
			ConsultationDetailService ser = new ConsultationDetailService();
			List<ConsultationDetail> l = ser
					.rechercheToutConsultation(idPatient);
			int i = 0;
			if (l != null)

				i = l.size();
			return i;
		}
		return 0;

	}

	public void majNote2() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		// idPatient = Module.idpatient;
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		c.setNotes2(notes2);
		ser.modifierPatient(c);
	}

	public void goToAntecedent() {

		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("idu", idPatient);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void pariteChange() {
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		c.setPartie(parite);
		ser.modifierPatient(c);
	}

	public void goToCertificats() {
		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idu", idPatient);

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Certificats");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void goToLettre() {

		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idu", idPatient);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Lettres");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void gotoFiche() {
		RequestContext.getCurrentInstance().update("f1");
		RequestContext.getCurrentInstance().update("f1");
		RequestContext.getCurrentInstance().update("f1");
	}

	public void goToAnalyses() {
		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idu", idPatient);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("HistoriqueAnalyses");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToRadios() {
		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idu", idPatient);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("HistoriqueRadios");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToOrdonnanceLibre() {

		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idu", idPatient);
			session.setAttribute("act", "ajoutOrdLibre");
			session.setAttribute("source", "FichePatiente");
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToOrdonnances() {
		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idu", idPatient);

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("HistoriqueOrdonnances");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToAccueil() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String calculAgeS(String date) {
		if (date != null) {
			return Module.age(date);

		} else {
			Date toDay = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			String DateDuJour = sf.format(toDay);

			return Module.age(DateDuJour);
		}
	}

	private int fille;
	private int garcon;

	public int getFille() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		fille = c.getNbrFille();
		return fille;
	}

	public void setFille(int fille) {
		this.fille = fille;
	}

	public int getGarcon() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		garcon = c.getNbrFille();
		return garcon;
	}

	public void setGarcon(int garcon) {
		this.garcon = garcon;
	}

	public void filleChange() {
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		c.setNbrFille(fille);
		ser.modifierPatient(c);
	}

	public void garconChange() {
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(idPatient);
		c.setNbrGarcon(garcon);
		ser.modifierPatient(c);
	}

	public void retour() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		String retouraction = (String) session.getAttribute("retouraction");

		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(retouraction);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public List<ConsultationDetail> getToutConsultationsConObs() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		ConsultationDetailService ser = new ConsultationDetailService();

		toutConsultationsConsGyn = ser
				.rechercheConsultationBytype(idPatient, 1);
		return toutConsultationsConObs;
	}

	public int getNbrConsEchoObs() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		ConsultationDetailService ser = new ConsultationDetailService();
		toutConsultationsConsEchoObs = ser.rechercheConsultationBytype(
				idPatient, 3);
		nbrConsEchoObs = toutConsultationsConsEchoObs.size();

		return nbrConsEchoObs;
	}

	public void setNbrConsEchoObs(int nbrConsEchoObs) {
		this.nbrConsEchoObs = nbrConsEchoObs;
	}

	public int getNbrConsEchoGyn() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		ConsultationDetailService ser = new ConsultationDetailService();
		toutConsultationsConsEchoGyn = ser.rechercheConsultationBytype(
				idPatient, 2);
		nbrConsEchoGyn = toutConsultationsConsEchoGyn.size();
		return nbrConsEchoGyn;
	}

	public void setNbrConsEchoGyn(int nbrConsEchoGyn) {
		this.nbrConsEchoGyn = nbrConsEchoGyn;
	}

	public int getNbrConsObs() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		ConsultationDetailService ser = new ConsultationDetailService();
		toutConsultationsConObs = ser.rechercheConsultationBytype(idPatient, 1);
		if (toutConsultationsConObs.size() != 0) {
			nbrConsObs = toutConsultationsConObs.size();
		} else
			nbrConsObs = 0;
		return nbrConsObs;
	}

	public void setNbrConsObs(int nbrConsObs) {
		this.nbrConsObs = nbrConsObs;
	}

	public int getNbrConsGyn() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		ConsultationDetailService ser = new ConsultationDetailService();
		toutConsultationsConsGyn = ser
				.rechercheConsultationBytype(idPatient, 4);

		nbrConsGyn = toutConsultationsConsGyn.size();

		return nbrConsGyn;
	}

	public void setNbrConsGyn(int nbrConsGyn) {
		this.nbrConsGyn = nbrConsGyn;
	}

	public void setToutConsultationsConObs(
			List<ConsultationDetail> toutConsultationsConObs) {
		this.toutConsultationsConObs = toutConsultationsConObs;
	}

	public List<ConsultationDetail> getToutConsultationsConsGyn() {
		return toutConsultationsConsGyn;
	}

	public void setToutConsultationsConsGyn(
			List<ConsultationDetail> toutConsultationsConsGyn) {
		this.toutConsultationsConsGyn = toutConsultationsConsGyn;
	}

	public List<ConsultationDetail> getToutConsultationsConsEchoGyn() {

		return toutConsultationsConsEchoGyn;
	}

	public void setToutConsultationsConsEchoGyn(
			List<ConsultationDetail> toutConsultationsConsEchoGyn) {
		this.toutConsultationsConsEchoGyn = toutConsultationsConsEchoGyn;
	}

	public List<ConsultationDetail> getToutConsultationsConsEchoObs() {
		return toutConsultationsConsEchoObs;
	}

	public void setToutConsultationsConsEchoObs(
			List<ConsultationDetail> toutConsultationsConsEchoObs) {
		this.toutConsultationsConsEchoObs = toutConsultationsConsEchoObs;
	}

	public boolean changerRendredNegative1() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);
		if (cl != null) {
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileNegative1"))
				return (true);
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileNegative2")) {
				return (true);
			}
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileNegative3")) {
				return (true);
			}

		}
		return (false);
	}

	public boolean changerRendredNegative2() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);
		if (cl != null) {
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileNegative2")) {
				return (true);
			}
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileNegative3")) {
				return (true);
			}

		}
		return (false);
	}

	public boolean changerRendredNegative3() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);
		if (cl != null) {

			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileNegative3")) {
				return (true);
			}
		}
		return (false);
	}

	public boolean changerRendredMoyen() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);
		if (cl != null) {

			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileMoyen")) {
				return (true);
			}
		}
		return (false);

	}

	public boolean changerRendredPositive1() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);

		if (cl != null) {
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoilePositive1"))
				return (true);
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoilePositive2")) {
				return (true);
			}
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoilePositive3")) {
				return (true);
			}
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}

		}
		return (false);
	}

	public boolean changerRendredPositive2() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);
		if (cl != null) {
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoilePositive2")) {
				return (true);
			}
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoilePositive3")) {
				return (true);
			}
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}
		}
		return (false);
	}

	public boolean changerRendredPositive3() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);
		if (cl != null) {
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoilePositive3")) {
				return (true);
			}
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}
		}
		return (false);
	}

	public boolean changerRendredExtra() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient cl = new CfclientService().RechercheCfclient(idPatient);
		if (cl != null) {
			if (cl.getCategoriEtoile() != null
					&& cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}
		}
		return (false);
	}

}
