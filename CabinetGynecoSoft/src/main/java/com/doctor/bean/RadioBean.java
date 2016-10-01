package com.doctor.bean;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import net.sf.jasperreports.engine.JasperRunManager;

import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.ExamenComplementaire;
import com.doctor.persistance.Radio;
import com.doctor.service.CfclientService;
import com.doctor.service.ConsultationDetailService;
import com.doctor.service.ExamenComplementaireService;
import com.doctor.service.RadioService;
import com.mysql.jdbc.Connection;

@ManagedBean(name = "radioBean")
@SessionScoped
public class RadioBean implements java.io.Serializable {
	/**
	 * 
	 */
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private static final long serialVersionUID = 1L;
	private Integer idradio;
	private String examenComplementaire;
	private String renseignementClinique;
	private String resultat;
	private ConsultationDetail consultationDetail;
	private Integer idconsultationDetail;
	private String exam;
	private String dateRadio;
	private Radio consultRadio;
	private String action = "";
	private Cfclient cfclient;
	private Integer idPatient;
	private Radio selectedRAdio;
	private String ancienValeur = "";
	private Boolean desibledImpr = false;
	private List<ExamenComplementaire> examenComplementaires = new ArrayList<ExamenComplementaire>();
	private List<Radio> histoRadios = new ArrayList<Radio>();
	private List<Radio> radiosParPatient = new ArrayList<Radio>();

	private String nomProprietaire;
	private String proprietaire;
	private Date dateRadios;
	private boolean consultation;
	private boolean viewImprim = false;

	public boolean isViewImprim() {

		return viewImprim;
	}

	public void setViewImprim(boolean viewImprim) {
		this.viewImprim = viewImprim;
	}

	public boolean isConsultation() {
		if (action == null)
			consultation = true;
		else if (action != null && action.equals("consulter"))
			consultation = true;
		else
			consultation = false;

		return consultation;
	}

	public void setConsultation(boolean consultation) {
		this.consultation = consultation;
	}

	public List<Radio> getHistoRadios() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Integer cons = (Integer) session.getAttribute("idConsultD");
		histoRadios = new RadioService().rechercheRadioParConsultation(cons);
		return histoRadios;
	}

	public void setHistoRadios(List<Radio> histoRadios) {
		this.histoRadios = histoRadios;
	}

	public Date getDateRadios() {
		return dateRadios;
	}

	public void setDateRadios(Date dateRadios) {

		this.dateRadios = dateRadios;
	}

	public void changerDate() {

		System.out.println("get in methode changerDate");

		// setDateRadios(dateRadios);
		setDateRadios(dateRadios);
		System.out.println("dateRadios dans changer date= "+dateRadios);
		
	}
	
	

	public String getNomProprietaire() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService ser = new CfclientService();
		cfclient = ser.RechercheCfclient(idPatient);
		if (proprietaire != null && cfclient != null) {

			if (proprietaire.equals("Patiente")) {
				nomProprietaire = cfclient.getPrefix() + " "
						+ cfclient.getNom() + " " + cfclient.getPrenom();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire += " Ep. " + cfclient.getNomC().trim();

			}

			if (proprietaire.equals("Conjoint")) {
				nomProprietaire = "M.";
				if (cfclient.getPrenomC() != null
						&& cfclient.getPrenomC().trim().length() > 0)
					nomProprietaire += cfclient.getPrenomC().trim();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire = nomProprietaire + " "
							+ cfclient.getNomC().trim();
			}
		}

		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public void changeProp() {
		setProprietaire(proprietaire);
		setNomProprietaire(nomProprietaire);
	}

	public List<Radio> getRadiosParPatient() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		// idPatient=Module.idpatient;
		RadioService ser = new RadioService();
		radiosParPatient = ser.rechercheRadioParPatient(idPatient);

		return radiosParPatient;
	}

	public void setRadiosParPatient(List<Radio> radiosParPatient) {
		this.radiosParPatient = radiosParPatient;
	}

	public void consulterRadio(SelectEvent event) {
		action = "consulter";
		viewImprim = false;
		Radio r = (Radio) event.getObject();

		consultRadio = selectedRAdio;
		desibledImpr = true;
		examenComplementaire = r.getExamenComplementaire();
		resultat = r.getResultat();
		renseignementClinique = r.getRenseignementClinique();
		dateRadios = r.getDateRadios();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		dateRadio = formatter.format(dateRadios);

		proprietaire = r.getPossesseur();
		nomProprietaire = r.getProprietaire();

	}

	public void ajoutRad() {
		selectedRAdio = null;
		viewImprim=true;
		desibledImpr = false;
		action = "ajout";
		exam = null;
		examenComplementaire = null;
		resultat = null;
		renseignementClinique = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		idconsultationDetail = (Integer) session.getAttribute("idConsultD");

		consultationDetail = new ConsultationDetailService()
				.rechercheConsultationDetail(idconsultationDetail);
		if (consultationDetail != null) {
			dateRadios = consultationDetail.getDateConsultation();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {

				dateRadio = sdf.format(dateRadios);
				dateRadios = sdf.parse(dateRadio);

			} catch (ParseException e) {

				e.printStackTrace();
			}

		} else {
			dateRadios = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dateRadio = sdf.format(dateRadios);
				dateRadios = sdf.parse(sdf.format(dateRadios));
			} catch (ParseException e) {

				e.printStackTrace();
			}

		}
		proprietaire = "Patiente";
	}

	public String getDateRadio() {
		System.out.println("get in getdateradio le val de dateradio est=  "+dateRadio);
		return dateRadio;
	}

	public void setDateRadio(String dateRadio) {
		System.out.println("get in setdateradio le val de dateradio est=  "+dateRadio);
		this.dateRadio = dateRadio;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Cfclient getCfclient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService ser = new CfclientService();
		cfclient = ser.RechercheCfclient(idPatient);
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public Integer getIdPatient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public String getResultat() {
		// HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
		// .getExternalContext().getSession(false);
		//
		// idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		// if (idconsultationDetail != null) {
		// RadioService ser = new RadioService();
		// Radio r = new Radio();
		//
		// List<Radio> a = ser
		// .rechercheRadioParConsultation(idconsultationDetail);
		// if (a.size() > 0) {
		// r = a.get(0);
		// resultat = r.getResultat();
		//
		// action = "modification";
		// } else {
		// action = "ajout";
		// }
		// }
		return resultat;
	}

	public void modifierRad(Radio r) {
		action = "modification";
		idradio = r.getIdradio();
		examenComplementaire = r.getExamenComplementaire();
		resultat = r.getResultat();
		renseignementClinique = r.getRenseignementClinique();
		dateRadios = r.getDateRadios();
		proprietaire = r.getPossesseur();
		nomProprietaire = r.getProprietaire();
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public List<ExamenComplementaire> getExamenComplementaires() {

		ExamenComplementaireService ser = new ExamenComplementaireService();
		examenComplementaires = ser.rechercheTousExamenComplementaire();

		return examenComplementaires;
	}

	public void setExamenComplementaires(
			List<ExamenComplementaire> examenComplementaires) {
		this.examenComplementaires = examenComplementaires;
	}

	public Integer getIdradio() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		if (idconsultationDetail != null) {
			// ConsultationDetailService sr = new ConsultationDetailService();
			RadioService ser = new RadioService();
			Radio r = new Radio();

			List<Radio> a = ser
					.rechercheRadioParConsultation(idconsultationDetail);
			if (a.size() > 0) {
				r = a.get(0);
				idradio = r.getIdradio();

				action = "modification";
			} else {
				action = "ajout";
			}
		}

		return idradio;
	}

	private boolean blocage;

	public boolean isBlocage() {
		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}

	/*
	 * public void dateChange() { //dateRadios=(Date) event.getObject();
	 * System.out.println("dddd: "+dateRadios); String dateString=""; //conertir
	 * en string if(dateRadios!= null){ DateFormat df = new
	 * SimpleDateFormat("dd/MM/yyyy"); dateString = df.format(dateRadios);
	 * System.out.println("date après conv  "+dateString); }
	 * 
	 * FacesContext faces = FacesContext.getCurrentInstance(); //Format format =
	 * new SimpleDateFormat("dd/MM/yyyy"); //String dateString =
	 * format.format(dateRadios); //String dateString = dateRadios+""; if
	 * (Module.corigerDate(dateString) != null) { dateString=Module
	 * .corigerDate(dateString);
	 * System.out.println("date après correction= "+dateString); } if
	 * (!(Module.verifierDate(dateString).equals("")))
	 * 
	 * {System.out.println("dddd"+Module.verifierDate(dateString));
	 * faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
	 * Module.verifierDate(dateString))); blocage=true; dateRadios=new Date(); }
	 * else { SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); try {
	 * dateRadios=sdf.parse(dateString); } catch (ParseException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * setDateRadios(dateRadios); }
	 */

	public void verifierDateRadio(){ 
		System.out.println("get in datechange");
		setDateRadio(dateRadio);
		System.out.println("val de dateRadio in verifdate=="+dateRadio);
		FacesContext face = FacesContext.getCurrentInstance();
		// Format format = new SimpleDateFormat("dd/MM/yyyy");

		if ((dateRadio == null) || (dateRadio.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez saisi le date de radio", ""));

		}

		if ((dateRadio != null) && (dateRadio.length() != 0)) {
			
			if (Module.corigerDate(dateRadio) != null) {
				this.setDateRadio(Module.corigerDate(dateRadio));
			}
			if (!(Module.verifierDate(dateRadio).equals("")))

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, Module
								.verifierDate(dateRadio), ""));

			} else {

				try {
					dateRadios = formatter.parse(dateRadio);
				} catch (ParseException e) {

					e.printStackTrace();
				}
			}
		}

	}

	public void setIdradio(Integer idradio) {
		this.idradio = idradio;
	}

	// @PostConstruct
	// public void intr(){
	// HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	// .getExternalContext().getSession(false);
	//
	// idconsultationDetail = (Integer) session.getAttribute("idConsultD");
	// if (idconsultationDetail != null) {
	// // ConsultationDetailService sr = new ConsultationDetailService();
	// RadioService ser = new RadioService();
	// Radio r = new Radio();
	//
	// List<Radio> a = ser
	// .rechercheRadioParConsultation(idconsultationDetail);
	// if (a.size() > 0) {
	// r = a.get(0);
	// examenComplementaire = r.getExamenComplementaire();
	//
	// action = "modification";
	// } else {
	// action = "ajout";
	// }
	// if(action.equals("modification"))
	// {
	// modifRadio(idconsultationDetail);
	// }
	//
	//
	// }
	// System.out.println("_______examen get  "+examenComplementaire+"__________");
	//
	// }

	public String getExamenComplementaire() {
		return examenComplementaire;
	}

	public void setExamenComplementaire(String examenComplementaire) {
		this.examenComplementaire = examenComplementaire;
	}

	public String getRenseignementClinique() {
		return renseignementClinique;
	}

	public void setRenseignementClinique(String renseignementClinique) {
		this.renseignementClinique = renseignementClinique;
	}

	public ConsultationDetail getConsultationDetail() {
		return consultationDetail;
	}

	public void setConsultationDetail(ConsultationDetail consultationDetail) {
		this.consultationDetail = consultationDetail;
	}

	public Integer getIdconsultationDetail() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		return idconsultationDetail;
	}

	public void setIdconsultationDetail(Integer idconsultationDetail) {
		this.idconsultationDetail = idconsultationDetail;
	}

	// @PostConstruct
	// public void init() {
	// HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	// .getExternalContext().getSession(false);
	// idPatient = (Integer) session.getAttribute("idu");
	// // idPatient = Module.idpatient;
	// idconsultationDetail = (Integer) session.getAttribute("idConsultD");
	//
	// ConsultationDetailService sr = new ConsultationDetailService();
	//
	// if (idconsultationDetail != null) {
	// consultationDetail = sr
	// .rechercheConsultationDetail(idconsultationDetail);
	// dateRadio = consultationDetail.getDateConsultation();
	//
	// // this.dateAnalyse = ancienValeur;
	// }
	// initialeRadio();
	// }

	//
	@PostConstruct
	public void init() {
		action = null;
		examenComplementaire = null;
		renseignementClinique = null;
		resultat = null;
		desibledImpr = false;
		consultRadio = null;
		dateRadios = null;
		dateRadio = null;
		proprietaire = null;
		nomProprietaire = null;
		consultation = true;
		viewImprim = true;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		idconsultationDetail = (Integer) session.getAttribute("idConsultD");

	}

	public void annulation() {
		init();
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {

			context.getExternalContext().redirect("DemandeRadio");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void onRadioChange() {
		String test;
		if (action != null && action.equals("ajout")) {
			if (examenComplementaire == null)
				examenComplementaire = "" + exam;
			else
				examenComplementaire = examenComplementaire + "\n" + exam;
		} else {
			if (examenComplementaire == null)
				examenComplementaire = "" + examenComplementaire;
			else
				examenComplementaire = examenComplementaire + "" + "\n" + exam;
			test = examenComplementaire;
			setExamenComplementaire(test);

		}
		// RequestContext.getCurrentInstance().update("f1");
		// setExamenComplementaire(examenComplementaire);
	}

	public void verifDate() {

		FacesContext faces = FacesContext.getCurrentInstance();

		if (Module.corigerDate(dateRadio) != null) {
			dateRadio = Module.corigerDate(dateRadio);
		}
		if (!(Module.verifierDate(dateRadio).equals("")))

		{
			faces.addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", Module
							.verifierDate(dateRadio)));
			blocage = true;
			dateRadios = new Date();
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dateRadios = sdf.parse(dateRadio);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		setDateRadios(dateRadios);
	}

	public void valider() {
		// dateChange();
		// changerDate();
		//RequestContext.getCurrentInstance().update(":f1");
		FacesContext faces = FacesContext.getCurrentInstance();
		// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		// dateRadio=formatter.format(dateRadios);

		
        verifierDateRadio();
        System.out.println("dateRadio après click valider== "+dateRadios);
		ontextexamenChange();
		onchangeRenseignementClinique();
		onchangeresultat();
		Radio r = new Radio();
		r.setDateRadios(dateRadios);
		r.setExamenComplementaire(examenComplementaire);
		r.setPossesseur(proprietaire);
		r.setProprietaire(nomProprietaire);
		r.setRenseignementClinique(renseignementClinique);
		r.setResultat(resultat);

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		idPatient = (Integer) session.getAttribute("idu");
		if (idconsultationDetail != null) {
			consultationDetail = new ConsultationDetailService()
					.rechercheConsultationDetail(idconsultationDetail);
		}

		if (idPatient != null) {
			cfclient = new CfclientService().RechercheCfclient(idPatient);
			if (cfclient != null)
				r.setPatient(cfclient);
		}

		FacesContext face = FacesContext.getCurrentInstance();
		r.setConsultationDetail(consultationDetail);

		if (face.getMessageList().size() == 0) {
			if (action != null && action.equals("ajout")) {

				new RadioService().ajoutRadio(r);
				if (consultationDetail != null)
					consultationDetail.setNbRadio(consultationDetail
							.getNbRadio() + 1);
				new ConsultationDetailService()
						.modifierConsultationDetail(consultationDetail);
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Demande radio ajoutée avec succés", ""));

				FacesContext context = FacesContext.getCurrentInstance();
				try {

					context.getExternalContext().redirect("DemandeRadio");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				selectedRAdio = r;
				consultRadio = r;
				desibledImpr = true;

			}
			if (action != null && action.equals("modification")) {
				r.setIdradio(idradio);
				new RadioService().modifierRadio(r);
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Demande radio modifiée avec succès"));
				CfclientService serclt = new CfclientService();
				Cfclient clt = serclt.RechercheCfclient(idPatient);

			}

		}
		exam = null;
		examenComplementaire = null;
		resultat = null;
		renseignementClinique = null;
		dateRadios = null;
		dateRadio = null;
		proprietaire = null;
		nomProprietaire = null;
		action = null;
		viewImprim = false;

		// try {
		//
		// context.getExternalContext().redirect("DemandeRadio");
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// }
	}

	public void validerHisto() {
		Radio r = new Radio();
		r.setDateRadios(dateRadios);
		r.setExamenComplementaire(examenComplementaire);
		r.setPossesseur(proprietaire);
		r.setProprietaire(nomProprietaire);
		r.setRenseignementClinique(renseignementClinique);
		r.setResultat(resultat);
		onRadioChange();
		ontextexamenChange();
		onchangeRenseignementClinique();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient clt = new CfclientService().RechercheCfclient(idPatient);
		r.setPatient(clt);
		idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		consultationDetail = new ConsultationDetailService()
				.rechercheConsultationDetail(idconsultationDetail);
		r.setConsultationDetail(consultationDetail);
		FacesContext face = FacesContext.getCurrentInstance();

		r.setIdradio(idradio);
		new RadioService().modifierRadio(r);
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Demande radio modifiée avec succès"));

		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		exam = null;
		examenComplementaire = null;
		resultat = null;
		renseignementClinique = null;
		dateRadios = null;
		proprietaire = null;
		nomProprietaire = null;

		try {

			context.getExternalContext().redirect("HistoriqueRadios");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ontextexamenComplementaireChange() {
		setExamenComplementaire(examenComplementaire);
	}

	public void verifierDate() {
		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(dateRadio) != null) {
			this.setDateRadio(Module.corigerDate(dateRadio));
		}
		if (!(Module.verifierDate(dateRadio).equals("")))

		{
			// blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateRadio)));
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			idPatient = (Integer) session.getAttribute("idu");

			idconsultationDetail = (Integer) session.getAttribute("idConsultD");
			ConsultationDetailService sr = new ConsultationDetailService();

			if (idconsultationDetail != null) {
				consultationDetail = sr
						.rechercheConsultationDetail(idconsultationDetail);
				dateRadio = formatter.format(consultationDetail
						.getDateConsultation());
			}

		}

	}

	public void verifierDate1() {
		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(dateRadio) != null) {
			this.setDateRadio(Module.corigerDate(dateRadio));
		}
		if (!(Module.verifierDate(dateRadio).equals("")))

		{
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateRadio)));

			this.dateRadio = ancienValeur;

		} else
			this.dateRadio = ancienValeur;
	}

	public String getAncienValeur() {
		return ancienValeur;
	}

	public void setAncienValeur(String ancienValeur) {
		this.ancienValeur = ancienValeur;
	}

	public void initialeRadio() {
		init();
		examenComplementaire = null;
		renseignementClinique = null;
		resultat = null;
		if (idconsultationDetail != null) {
			ConsultationDetailService sr = new ConsultationDetailService();
			consultationDetail = sr
					.rechercheConsultationDetail(idconsultationDetail);
			dateRadio = formatter.format(consultationDetail
					.getDateConsultation());
		}
	}

	public void onchangExamenComplementaire() {
		setExamenComplementaire(examenComplementaire);
	}

	public void onchangeRenseignementClinique() {
		setRenseignementClinique(renseignementClinique);
	}

	public void onchangedateRadio() {
		setRenseignementClinique(dateRadio);
	}

	public void onchangeresultat() {
		setResultat(resultat);
	}

	public void retour() {
		init();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		if (idconsultationDetail != null) {
			ConsultationDetailService sr = new ConsultationDetailService();
			ConsultationDetail cons = sr
					.rechercheConsultationDetailByConsultationMotiff(idconsultationDetail);
			String consultationmotif = cons.getConsultation()
					.getNomConsultation();

			if (consultationmotif.equals("C. Gyneco")) {
				try {
					initialeRadio();
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Consultation-Gynecologique");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			else if (consultationmotif.equals("C. Obst")) {
				try {

					initialeRadio();
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Consultation_Obstetrique");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

	public void ontextexamenChange() {
		setExamenComplementaire(examenComplementaire);

	}

	public void goToAcceuil() {
		desibledImpr = false;
		selectedRAdio = null;
		idradio = null;
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validerHistoriqueRadio() {
		init();
		@SuppressWarnings("unused")
		String consultationM = "";
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		idconsultationDetail = (Integer) session.getAttribute("idConsultD");

		// recherche radio lié à cette consultation si existe si non c'est
		// un nouveau radio
		RadioService ser = new RadioService();
		List<Radio> a = ser.rechercheRadioParConsultation(idconsultationDetail);
		if (a.size() > 0) {
			Radio r = a.get(0);
			idradio = r.getIdradio();

		}
		if (idconsultationDetail != null) {
			ConsultationDetailService sr = new ConsultationDetailService();
			ConsultationDetail cons = sr
					.rechercheConsultationDetailByConsultationMotiff(idconsultationDetail);
			String consultationmotif = cons.getConsultation()
					.getNomConsultation();

			if (consultationmotif.equals("C. Gyneco")) {
				consultationM = "ConsultationGyneco.xhtml";
			}

			else if (consultationmotif.equals("C. Obst")) {
				consultationM = "ConsultationGrossesse.xhtml";
			}
		}
		FacesContext face = FacesContext.getCurrentInstance();
		Radio r = new Radio();

		idPatient = (Integer) session.getAttribute("idu");
		r.setExamenComplementaire(examenComplementaire);
		r.setRenseignementClinique(renseignementClinique);
		r.setResultat(resultat);
		idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		ConsultationDetailService se = new ConsultationDetailService();
		consultationDetail = se
				.rechercheConsultationDetail(idconsultationDetail);
		consultationDetail.setRadio("radio");
		se.modifierConsultationDetail(consultationDetail);

		r.setConsultationDetail(consultationDetail);
		consultationDetail.setRadio("radio");
		if (action != null && action.equals("modification")) {
			r.setIdradio(idradio);
			ser.modifierRadio(r);
			initialeRadio();
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Démande radio modifiée avec succés"));

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			try {

				context.getExternalContext().redirect("HistoriqueRadios");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	public void retourliste() {
		desibledImpr = false;
		selectedRAdio = null;
		idradio = null;
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void modifRadioselect(Integer idConsult) {
		init();
		action = "modification";
		FacesContext context = FacesContext.getCurrentInstance();

		// HttpSession session= new Session();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		session.setAttribute("idConsultD", idConsult);

		ConsultationDetailService sr = new ConsultationDetailService();
		try {

			context.getExternalContext().redirect("DemandeRadio");
		} catch (Exception e) {
			;
		}

		if (idconsultationDetail != null) {
			// Integer idConsultationDetail = idConsult;
			consultationDetail = sr
					.rechercheConsultationDetail(idconsultationDetail);
			dateRadio = formatter.format(consultationDetail
					.getDateConsultation());
			// recherche analyse lié à cette consultation si existe si non c'est
			// une nouvelle analyse
			RadioService ser = new RadioService();
			List<Radio> a = ser.rechercheRadioParConsultation(idConsult);

			if (a.size() > 0) {
				Radio radi = a.get(0);
				idradio = radi.getIdradio();
				examenComplementaire = radi.getExamenComplementaire();
				renseignementClinique = radi.getRenseignementClinique();
				resultat = radi.getResultat();
				action = "modification";
			}
		}
	}

	public void modifRadio(Integer idrad) {
		Radio radi = new RadioService().rechercheRadioAvecJoin(idrad);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (radi != null) {
			if (radi.getConsultationDetail() != null) {
				idconsultationDetail = radi.getConsultationDetail()
						.getIdConsultationDetail();
				session.setAttribute("idConsultD", idconsultationDetail);
			}
			if (radi.getPatient() != null) {
				idPatient = radi.getPatient().getCode();
				session.setAttribute("idu", idPatient);
			}
			idradio = radi.getIdradio();
			dateRadios = radi.getDateRadios();
			examenComplementaire = radi.getExamenComplementaire();
			renseignementClinique = radi.getRenseignementClinique();
			resultat = radi.getResultat();
			nomProprietaire = radi.getProprietaire();
			proprietaire = radi.getPossesseur();
			action = "modification";

		}

	}

	public void suppressionRadio(Integer idradio) {

		Radio r = new RadioService().rechercheRadioAvecJoin(idradio);
		consultationDetail = r.getConsultationDetail();
		consultationDetail.setNbRadio(consultationDetail.getNbRadio() - 1);

		new ConsultationDetailService()
				.modifierConsultationDetail(consultationDetail);

		new RadioService().supprimerRadio(idradio);

		FacesContext face = FacesContext.getCurrentInstance();
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Demande de radio supprimée avec succés", ""));
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("DemandeRadio");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void SupprimerRadio(Integer idradio) {

		// rechercher consultation par radios
		RadioService ser = new RadioService();
		Radio r = new RadioService().rechercheRadioAvecJoin(idradio);
		if (r != null) {
			Integer idcons = r.getConsultationDetail()
					.getIdConsultationDetail();
			ser.supprimerRadio(idradio);
			consultationDetail = new ConsultationDetailService()
					.rechercheConsultationDetail(idcons);
			if (consultationDetail != null) {
				ConsultationDetailService se = new ConsultationDetailService();
				System.out.println("supp rad");
				consultationDetail
						.setNbRadio(consultationDetail.getNbRadio() - 1);
				se.modifierConsultationDetail(consultationDetail);
			}
			FacesContext face = FacesContext.getCurrentInstance();
			// RadioService ser = new RadioService();
			// ser.supprimerRadio(idradio);
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Radio supprimée avec succés", ""));

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			try {

				context.getExternalContext().redirect("HistoriqueRadios");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void corection() {
		FacesContext face = FacesContext.getCurrentInstance();
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Radio supprimée avec succés", ""));
	}

	public void viewRadio(ActionEvent actionEvent) throws SQLException,
			Exception {
		System.out.println("consultRadio==" + consultRadio);
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		String age1;
		String age;

		System.out.println("proprietaire== " + proprietaire);
		if (consultRadio != null) {

			if (proprietaire.equals("Patiente")) {
				if (clt.getDateNaiss() != null)
					age1 = Module.age(clt.getDateNaiss()).substring(0, 2);
				else
					age1 = "";

			} else {
				if (clt.getDateNaissC() != null)
					age1 = Module.age(clt.getDateNaissC()).substring(0, 2);
				else
					age1 = "";
			}

			if (age1.equals("")) {
				age = age1;
			} else {
				age = "( " + age1 + " )" + " Ans";
			}

			String nomReport = "demandeRadio";

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("idrad", consultRadio.getIdradio());
			param.put("age", age);
			Module.imprimer(nomReport, param);
		}
	}

	public void viewHistoriqueRadio(ActionEvent actionEvent)
			throws SQLException, Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);

		String nomReport = "demandeRadio";
		String age1 = Module.age(clt.getDateNaiss()).substring(0, 2);
		String age = "(" + age1 + ")";
		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idrad", selectedRAdio.getIdradio());
		param.put("age", age);

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

	public Radio getSelectedRAdio() {
		return selectedRAdio;
	}

	public void setSelectedRAdio(Radio selectedRAdio) {
		this.selectedRAdio = selectedRAdio;
	}

	public void onRowSelectRadio(SelectEvent event)

	{
		Radio r = (Radio) event.getObject();
		idradio = r.getIdradio();

		desibledImpr = true;
	}

	public Boolean getDesibledImpr() {
		return desibledImpr;
	}

	public void setDesibledImpr(Boolean desibledImpr) {
		this.desibledImpr = desibledImpr;
	}

	public Radio getConsultRadio() {
		return consultRadio;
	}

	public void setConsultRadio(Radio consultRadio) {
		this.consultRadio = consultRadio;
	}

	public void proprietaireChange() {
		setNomProprietaire(nomProprietaire);
	}
}
