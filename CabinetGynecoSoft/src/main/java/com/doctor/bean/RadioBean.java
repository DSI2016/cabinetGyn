package com.doctor.bean;

import java.sql.SQLException;
import java.text.DateFormat;
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
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.ExamenComplementaire;
import com.doctor.persistance.Radio;
import com.doctor.service.CfclientService;
import com.doctor.service.ConsultationDetailService;
import com.doctor.service.ExamenComplementaireService;
import com.doctor.service.RadioService;

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
	// private String dateRadio;
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
		setDateRadios(dateRadios);
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

		// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		// dateRadio = formatter.format(dateRadios);

		proprietaire = r.getPossesseur();
		nomProprietaire = r.getProprietaire();

	}

	public void ajoutRad() {
		selectedRAdio = null;
		viewImprim = true;
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
			// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// try {
			//
			// dateRadio = sdf.format(dateRadios);
			// dateRadios = sdf.parse(dateRadio);
			//
			// } catch (ParseException e) {
			//
			// e.printStackTrace();
			// }

		} else {
			dateRadios = new Date();
			// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// try {
			// dateRadio = sdf.format(dateRadios);
			// dateRadios = sdf.parse(sdf.format(dateRadios));
			// } catch (ParseException e) {
			//
			// e.printStackTrace();
			// }

		}
		proprietaire = "Patiente";
	}

	// public String getDateRadio() {
	//
	// return dateRadio;
	// }
	//
	// public void setDateRadio(String dateRadio) {
	//
	// this.dateRadio = dateRadio;
	// }

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

	// public void verifierDateRadio() {
	// setDateRadio(dateRadio);
	// FacesContext face = FacesContext.getCurrentInstance();
	//
	// if ((dateRadio == null) || (dateRadio.equals(""))) {
	// blocage = true;
	// face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	// "Veuillez saisi le date de radio", ""));
	//
	// }
	//
	// if ((dateRadio != null) && (dateRadio.length() != 0)) {
	//
	// if (Module.corigerDate(dateRadio) != null) {
	// this.setDateRadio(Module.corigerDate(dateRadio));
	// }
	// if (!(Module.verifierDate(dateRadio).equals("")))
	//
	// {
	// blocage = true;
	// face.addMessage(
	// null,
	// new FacesMessage(FacesMessage.SEVERITY_ERROR, Module
	// .verifierDate(dateRadio), ""));
	//
	// } else {
	//
	// try {
	// dateRadios = formatter.parse(dateRadio);
	// } catch (ParseException e) {
	//
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// }

	public void setIdradio(Integer idradio) {
		this.idradio = idradio;
	}

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

	@PostConstruct
	public void init() {
		action = null;
		examenComplementaire = null;
		renseignementClinique = null;
		resultat = null;
		desibledImpr = false;
		consultRadio = null;
		dateRadios = null;
		// dateRadio = null;
		proprietaire = null;
		nomProprietaire = null;
		consultation = true;
		viewImprim = true;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		idconsultationDetail = (Integer) session.getAttribute("idConsultD");
		impress = true;
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
	}

	public void valider() {
		FacesContext face = FacesContext.getCurrentInstance();
		Radio r = new Radio();
		String dateRadioS = formatter.format(dateRadios);
		if (Module.dateDepassee(dateRadioS))
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La date saisie a dépassé la date de jour", ""));
		if (Module.dateTresAncien(dateRadioS))
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La date saisie est très ancienne", ""));
		
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

			}
			exam = null;
			examenComplementaire = null;
			resultat = null;
			renseignementClinique = null;
			dateRadios = null;
			// dateRadio = null;
			proprietaire = null;
			nomProprietaire = null;
			action = null;
			viewImprim = false;
		} else
			blocage = true;

	}

	public void validerHisto() {
		Radio r = new Radio();
		r.setDateRadios(datRadios);
		r.setExamenComplementaire(examenComplementaire);
		r.setPossesseur(proprietaire);
		r.setProprietaire(nomProprietaire);
		r.setRenseignementClinique(renseignementClinique);
		r.setResultat(resultat);

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

	// public void verifierDate() {
	// FacesContext face = FacesContext.getCurrentInstance();
	// if (Module.corigerDate(dateRadio) != null) {
	// this.setDateRadio(Module.corigerDate(dateRadio));
	// }
	// if (!(Module.verifierDate(dateRadio).equals("")))
	//
	// {
	// // blocage = true;
	// face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	// "", Module.verifierDate(dateRadio)));
	// HttpSession session = (HttpSession) FacesContext
	// .getCurrentInstance().getExternalContext()
	// .getSession(false);
	// idPatient = (Integer) session.getAttribute("idu");
	//
	// idconsultationDetail = (Integer) session.getAttribute("idConsultD");
	// ConsultationDetailService sr = new ConsultationDetailService();
	//
	// if (idconsultationDetail != null) {
	// consultationDetail = sr
	// .rechercheConsultationDetail(idconsultationDetail);
	// dateRadio = formatter.format(consultationDetail
	// .getDateConsultation());
	// }
	//
	// }
	//
	// }

	// public void verifierDate1() {
	// FacesContext face = FacesContext.getCurrentInstance();
	// if (Module.corigerDate(dateRadio) != null) {
	// this.setDateRadio(Module.corigerDate(dateRadio));
	// }
	// if (!(Module.verifierDate(dateRadio).equals("")))
	//
	// {
	// face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	// "", Module.verifierDate(dateRadio)));
	//
	// this.dateRadio = ancienValeur;
	//
	// } else
	// this.dateRadio = ancienValeur;
	// }

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
			dateRadios = consultationDetail.getDateConsultation();
			// dateRadio = formatter.format(consultationDetail
			// .getDateConsultation());
		}
	}

	public void onchangExamenComplementaire() {
		setExamenComplementaire(examenComplementaire);
	}

	public void onchangeRenseignementClinique() {
		setRenseignementClinique(renseignementClinique);
	}

	// public void onchangedateRadio() {
	// setRenseignementClinique(dateRadio);
	// }

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
			consultationDetail = sr
					.rechercheConsultationDetail(idconsultationDetail);
			dateRadios = consultationDetail.getDateConsultation();
			// dateRadio = formatter.format(consultationDetail
			// .getDateConsultation());
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
			datRadios = radi.getDateRadios();
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
				consultationDetail
						.setNbRadio(consultationDetail.getNbRadio() - 1);
				se.modifierConsultationDetail(consultationDetail);
			}
			FacesContext face = FacesContext.getCurrentInstance();
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
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		String age1;
		String age;
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

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idrad", selectedRAdio.getIdradio());
		param.put("age", age);

		Module.imprimer(nomReport, param);
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
		selectedRAdio = r;
		impress = false;
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

	public Date datRadios;

	public Date getDatRadios() {
		return datRadios;
	}

	public void setDatRadios(Date datRadios) {
		this.datRadios = datRadios;
	}

	private boolean impress;

	public boolean isImpress() {
		return impress;
	}

	public void setImpress(boolean impress) {
		this.impress = impress;
	}

	public void dateChange(SelectEvent event) {

		setDateRadios((Date) event.getObject());
		setDateRadios(dateRadios);
	}

	public void dateChange2() {

		setDateRadios(dateRadios);
	}
}
