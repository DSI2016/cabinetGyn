package com.doctor.bean;

import java.io.File;
import java.sql.DriverManager;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

import net.sf.jasperreports.engine.JasperRunManager;

import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Analyse;
import com.doctor.persistance.AnalyseDemandee;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.service.AnalyseDemandeeService;
import com.doctor.service.AnalyseService;
import com.doctor.service.CfclientService;
import com.doctor.service.ConsultationDetailService;
import com.mysql.jdbc.Connection;

@ManagedBean(name = "analyseDemandeeBean")
@SessionScoped
public class AnalyseDemandeeBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idanalyseDemandee;
	private List<Analyse> analyses = new ArrayList<Analyse>();
	private String dateAnalyse;
	private String toxo;
	private String tpha;
	private String rubeole;
	private String agHbs;
	private String glycemie;
	private String frottis;
	private String ancienValeur = "";
	private Boolean desibledImpr = false;
	private AnalyseDemandee selectedAnalyse;
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private String analyseDemandee;// pour l'analyse selectionné
	private String analyseDemandees;// tous les analyses demandées
	private Cfclient cfclient;
	private Integer idPatient;
	private ConsultationDetail consultationDetail;
	private Integer idConsultationDetail;
	private String action;
	private List<AnalyseDemandee> analysesParPatient = new ArrayList<AnalyseDemandee>();
	private List<AnalyseDemandee> histAnaCons = new ArrayList<AnalyseDemandee>();
	private String nomProprietaire;
	private String proprietaire;
	private Date dateAna;
	
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

	public Date getDateAna() {
		return dateAna;
	}

	public void setDateAna(Date dateAna) {
		this.dateAna = dateAna;
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

	public List<AnalyseDemandee> getHistAnaCons() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Integer cons = (Integer) session.getAttribute("idConsultD");
		histAnaCons = new AnalyseDemandeeService()
				.rechercheAnalyseParConsultation(cons);

		return histAnaCons;
	}

	public void setHistAnaCons(List<AnalyseDemandee> histAnaCons) {
		this.histAnaCons = histAnaCons;
	}

	public List<AnalyseDemandee> getAnalysesParPatient() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		AnalyseDemandeeService ser = new AnalyseDemandeeService();
		analysesParPatient = ser.rechercheAnalyseDemandeeParPatient(idPatient);

		return analysesParPatient;
	}

	public void setAnalysesParPatient(List<AnalyseDemandee> analysesParPatient) {
		this.analysesParPatient = analysesParPatient;
	}

	public Integer getIdanalyseDemandee() {
		return idanalyseDemandee;
	}

	public void setIdanalyseDemandee(Integer idanalyseDemandee) {
		this.idanalyseDemandee = idanalyseDemandee;
	}

	public String getAction() {
		if (action == null) {
			toxo = null;
			tpha = null;
			rubeole = null;
			idanalyseDemandee = null;
			analyseDemandees = null;
			desibledImpr = false;

			agHbs = null;

			glycemie = null;
			frottis = null;
		}

		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@PostConstruct
	public void initialisationAnalysea() {
		action = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		idConsultationDetail = (Integer) session.getAttribute("idConsultD");
		toxo = null;
		tpha = null;
		rubeole = null;
		idanalyseDemandee = null;
		analyseDemandees = null;
		analyseDemandee=null;
		desibledImpr = false;
		consultation=false;
		agHbs = null;
		glycemie = null;
		frottis = null;
		proprietaire=null;
		nomProprietaire=null;
		dateAna=null;
		desibledImpr=false;
		impress=true;
		viewImprim = true;
		
	}
	
	public void initApresValidation(){
		desibledImpr=false;
		initialisationAnalysea();
		viewImprim = false;
		redirect();
		
	}
	

	public ConsultationDetail getConsultationDetail() {
	
		return consultationDetail;
	}

	public void setConsultationDetail(ConsultationDetail consultationDetail) {
		this.consultationDetail = consultationDetail;
	}

	public Integer getIdConsultationDetail() {
		return idConsultationDetail;
	}

	public void setIdConsultationDetail(Integer idConsultationDetail) {
		this.idConsultationDetail = idConsultationDetail;
	}

	public String getDateAnalyse() {
		

		return dateAnalyse;
	}

	public void setDateAnalyse(String dateAnalyse) {

		this.dateAnalyse = dateAnalyse;
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

	public Cfclient getCfclient() {
		CfclientService ser = new CfclientService();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		cfclient = ser.RechercheCfclient(idPatient);
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public List<Analyse> getAnalyses() {
		AnalyseService ser = new AnalyseService();
		analyses = ser.rechercheTousAnalyse();

		return analyses;
	}

	public void setAnalyses(List<Analyse> analyses) {
		this.analyses = analyses;
	}

	public String getToxo() {
		return toxo;
	}

	public void setToxo(String toxo) {
		this.toxo = toxo;
	}

	public String getTpha() {
		return tpha;
	}

	public void setTpha(String tpha) {
		this.tpha = tpha;
	}

	public String getRubeole() {
		return rubeole;
	}

	public void setRubeole(String rubeole) {
		this.rubeole = rubeole;
	}

	public String getAgHbs() {
		return agHbs;
	}

	public void setAgHbs(String agHbs) {
		this.agHbs = agHbs;
	}

	public String getGlycemie() {
		return glycemie;
	}

	public void setGlycemie(String glycemie) {
		this.glycemie = glycemie;
	}

	public String getFrottis() {
		return frottis;
	}

	public void setFrottis(String frottis) {
		this.frottis = frottis;
	}

	public String getAnalyseDemandee() {
		return analyseDemandee;
	}

	public void setAnalyseDemandee(String analyseDemandee) {
		this.analyseDemandee = analyseDemandee;
	}

	public String getAnalyseDemandees() {
		return analyseDemandees;
	}

	public void setAnalyseDemandees(String analyseDemandees) {
		this.analyseDemandees = analyseDemandees;
	}

	public void onAnalyseChange() {
		if (analyseDemandees == null)
			analyseDemandees = analyseDemandee;
		else
			analyseDemandees += "\n" + analyseDemandee;
	}

	public void ajoutAna() {
		action = "ajout";
		initialisationAnalyse();
		viewImprim = true;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		idConsultationDetail = (Integer) session.getAttribute("idConsultD");
		consultationDetail = new ConsultationDetailService()
				.rechercheConsultationDetail(idConsultationDetail);
		if (consultationDetail != null)
			dateAna = consultationDetail.getDateConsultation();
		else
			dateAna = new Date();
		proprietaire = "Patiente";

	}
	
	public void  changerDate(){
		setDateAna(dateAna);
		
	}

	public void valider(ActionEvent actionEvent) throws SQLException, Exception {
		
		//changerDate();
		FacesContext face = FacesContext.getCurrentInstance();
		AnalyseDemandeeService ser = new AnalyseDemandeeService();
		AnalyseDemandee ana = new AnalyseDemandee();
		
		if (analyseDemandees != null) {
			    ana.setAnalyses(analyseDemandees);
		    }

		ana.setPatiente(cfclient);
		ana.setToxo(toxo);
		ana.setTpha(tpha);
		ana.setAgHbs(agHbs);
		ana.setRubeole(rubeole);
		ana.setGlycemie(glycemie);
		ana.setFrottis(frottis);
		ana.setProprietaire(nomProprietaire);
		ana.setPossesseur(proprietaire);
		
		String dateAnaS = formatter.format(dateAna);
		if (Module.dateDepassee(dateAnaS))
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La date saisie a dépassé la date de jour", ""));
		if (Module.dateTresAncien(dateAnaS))
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La date saisie est très ancienne", ""));
		
		
		ana.setDateAnalyse(dateAna);
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Cfclient clt = new CfclientService().RechercheCfclient(idPatient);
		ana.setPatiente(clt);
		idConsultationDetail = (Integer) session.getAttribute("idConsultD");

		consultationDetail = new ConsultationDetailService()
				.rechercheConsultationDetail(idConsultationDetail);
		if (consultationDetail != null)
			ana.setConsultationDetail(consultationDetail);
		
		if(face.getMessageList().size()==0){
		if (action != null && action.equals("ajout")) {
			
			ser.ajoutAnalyseDemandee(ana);
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Demande analyse ajoutée avec succés", ""));
			
			
			
			consultationDetail
					.setNbAnalyse(consultationDetail.getNbAnalyse() + 1);
			new ConsultationDetailService()
					.modifierConsultationDetail(consultationDetail);
			clt.setToxo(toxo);
			clt.setTpha(tpha);
			clt.setRubeole(rubeole);
			new CfclientService().modifierPatient(clt);
			
			viewImprim = false;
			desibledImpr = true;
			selectedAnalyse = ana;
			initApresValidation();
		}
		if (action != null && action.equals("Modif")) {
			ana.setIdanalyseDemandee(idanalyseDemandee);
			ser.modifierAnalyseDemandee(ana);
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Demande analyse modifiée avec succés", ""));
			
			clt.setToxo(toxo);
			clt.setTpha(tpha);
			clt.setRubeole(rubeole);
			new CfclientService().modifierPatient(clt);
			viewImprim = false;
			initApresValidation();
		}
		}
	}
	
	public void redirect(){
		
		try {
			 FacesContext.getCurrentInstance().getExternalContext()
			 .redirect("DemandeAnalyse");
			 } catch (Exception e) {
			}
	}

	public void validerListeAnalyse() {

		FacesContext face = FacesContext.getCurrentInstance();
		AnalyseDemandeeService ser = new AnalyseDemandeeService();
		AnalyseDemandee ana = new AnalyseDemandee();
		if (analyseDemandees != null) {
			ana.setAnalyses(analyseDemandees);
		}
		ana.setToxo(toxo);
		ana.setTpha(tpha);
		ana.setAgHbs(agHbs);
		ana.setRubeole(rubeole);
		ana.setGlycemie(glycemie);
		ana.setFrottis(frottis);
		ana.setPossesseur(proprietaire);
		ana.setProprietaire(nomProprietaire);
		ana.setDateAnalyse(dateAna);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idConsultationDetail = (Integer) session.getAttribute("idConsultD");
		consultationDetail = new ConsultationDetailService()
				.rechercheConsultationDetail(idConsultationDetail);
		ana.setConsultationDetail(consultationDetail);

		Cfclient clt = null;

		idPatient = (Integer) session.getAttribute("idu");
		if (idPatient != null) {
			clt = new CfclientService().RechercheCfclient(idPatient);
			ana.setPatiente(clt);
		}

		if (action.equals("modification")) {
			ana.setIdanalyseDemandee(idanalyseDemandee);
			ser.modifierAnalyseDemandee(ana);
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Demande analyse modifiée avec succès"));

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			if (clt != null) {
				clt.setToxo(toxo);
				clt.setTpha(tpha);
				clt.setRubeole(rubeole);
				new CfclientService().modifierPatient(clt);
			}
		}
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("HistoriqueAnalyses");
		} catch (Exception e) {
		}
		initialisationAnalyse();
	}

	public void modifAnalyse(Integer idana) {

		AnalyseDemandee analy = new AnalyseDemandeeService()
				.rechercheAnalyseAvecJoin(idana);
		if (analy != null) {
			idanalyseDemandee = analy.getIdanalyseDemandee();
			dateAna = analy.getDateAnalyse();
			
			dateAnalyse=formatter.format(dateAna);
			analyseDemandees = analy.getAnalyses();
			toxo = analy.getToxo();
			tpha = analy.getTpha();
			agHbs = analy.getAgHbs();
			rubeole = analy.getRubeole();
			glycemie = analy.getGlycemie();
			frottis = analy.getFrottis();
			nomProprietaire = analy.getProprietaire();
			proprietaire = analy.getPossesseur();
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			if (analy.getConsultationDetail() != null) {
				idConsultationDetail = analy.getConsultationDetail()
						.getIdConsultationDetail();
				session.setAttribute("idConsultD", idConsultationDetail);
			}

			if (analy.getPatiente() != null) {
				idPatient = analy.getPatiente().getCode();
				session.setAttribute("idu", idPatient);
			}
			action = "modification";
		}

	}

	public void modifierAnalyse(AnalyseDemandee ana) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		idConsultationDetail = (Integer) session.getAttribute("idConsultD");
		dateAna = ana.getDateAnalyse();
		idanalyseDemandee = ana.getIdanalyseDemandee();
		proprietaire = ana.getPossesseur();
		nomProprietaire = ana.getProprietaire();
		analyseDemandees = ana.getAnalyses();
		toxo = ana.getToxo();
		tpha = ana.getTpha();
		rubeole = ana.getRubeole();
		agHbs = ana.getAgHbs();
		glycemie = ana.getGlycemie();
		frottis = ana.getFrottis();
		action = "Modif";
		viewImprim = true;

	}

	public void onanalyseChange() {
		if (analyseDemandees == null)
			analyseDemandees = analyseDemandee;
		else
			analyseDemandees += "\n" + analyseDemandee;

	}

	public void initialisationAnalyse() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		idanalyseDemandee = null;
		analyseDemandees = null;
		analyseDemandee=null;
		dateAna = null;
		toxo = null;
		tpha = null;
		rubeole = null;
		agHbs = null;
		glycemie = null;
		frottis = null;
		proprietaire = null;
		nomProprietaire = null;
		consultation=true;
		
	}

	public void retour() {

		toxo = null;
		tpha = null;
		rubeole = null;
		idanalyseDemandee = null;
		analyseDemandees = null;
		desibledImpr = false;

		agHbs = null;

		glycemie = null;
		frottis = null;
		dateAna = null;
		action = null;
		proprietaire = null;
		nomProprietaire = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		Integer idconsultationDetail = (Integer) session
				.getAttribute("idConsultD");
		if (idconsultationDetail != null) {
			ConsultationDetailService sr = new ConsultationDetailService();
			ConsultationDetail cons = sr
					.rechercheConsultationDetailByConsultationMotiff(idconsultationDetail);
			String consultationmotif = cons.getConsultation()
					.getNomConsultation();

			if (consultationmotif.equals("C. Gyneco")) {
				try {

					initialisationAnalysea();
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Consultation-Gynecologique");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			else if (consultationmotif.equals("C. Obst")) {
				try {

					initialisationAnalysea();
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Consultation_Obstetrique");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}

	}
	
	public void annulation() {
		initialisationAnalysea();
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {

			context.getExternalContext().redirect("DemandeAnalyse");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void verifierDate() {
		FacesContext face = FacesContext.getCurrentInstance();
		
		if (Module.corigerDate(dateAnalyse) != null) {
			this.setDateAnalyse(Module.corigerDate(dateAnalyse));
		}
		
		
		if (!(Module.verifierDate(dateAnalyse).equals("")))

		{
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateAnalyse)));
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			idPatient = (Integer) session.getAttribute("idu");
			idConsultationDetail = (Integer) session.getAttribute("idConsultD");

			ConsultationDetailService sr = new ConsultationDetailService();

			if (idConsultationDetail != null) {
				consultationDetail = sr
						.rechercheConsultationDetail(idConsultationDetail);
				dateAnalyse = formatter.format(consultationDetail
						.getDateConsultation());

			}
		}

	}

	public String getAncienValeur() {
		return ancienValeur;
	}

	public void setAncienValeur(String ancienValeur) {
		this.ancienValeur = ancienValeur;
	}

	public void ontextanalyseChange() {
		setAnalyseDemandees(analyseDemandees);
	}

	public void suppressionAnalyse(Integer idAna) {
		AnalyseDemandee a = new AnalyseDemandeeService()
				.rechercheAnalyseAvecJoin(idAna);
		consultationDetail = a.getConsultationDetail();
		consultationDetail.setNbAnalyse(consultationDetail.getNbAnalyse() - 1);

		new ConsultationDetailService()
				.modifierConsultationDetail(consultationDetail);

		new AnalyseDemandeeService().supprimerAnalyseDemandee(idAna);
		FacesContext face = FacesContext.getCurrentInstance();
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Demande d'analyse supprimée avec succés"));
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("DemandeAnalyse");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void SupprimerAnalyse(Integer idanalyseDemandee) {

		// rechercher consultation par radios
		AnalyseDemandeeService ser = new AnalyseDemandeeService();
		AnalyseDemandee a = new AnalyseDemandeeService()
				.rechercheAnalyseAvecJoin(idanalyseDemandee);
		if (a != null) {
			Integer idcons = a.getConsultationDetail()
					.getIdConsultationDetail();
			ser.supprimerAnalyseDemandee(idanalyseDemandee);
			consultationDetail = new ConsultationDetailService()
					.rechercheConsultationDetail(idcons);
			if (consultationDetail != null) {
				ConsultationDetailService se = new ConsultationDetailService();
				consultationDetail.setAnalyse(" ");
				se.modifierConsultationDetail(consultationDetail);
				
			}
			FacesContext face = FacesContext.getCurrentInstance();
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Demande d'analyse supprimée avec succés"));
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			try {
				context.getExternalContext().redirect("HistoriqueAnalyses");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void retourliste() {
		desibledImpr = true;
		selectedAnalyse = null;
		idanalyseDemandee = null;
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToAcceuil() {
		desibledImpr = true;
		selectedAnalyse = null;
		idanalyseDemandee = null;
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectAnalyse(ActionEvent actionEvent) throws SQLException,
			Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		String age1;
		String age;
		if (selectedAnalyse != null) {
			String nomReport = "demandeAnalyse";
					if(proprietaire.equals("Patiente")){
						 if(clt.getDateNaiss()!=null)
					      age1 = Module.age(clt.getDateNaiss()).substring(0, 2);
						 else
							 age1="";
					}else{
						if(clt.getDateNaissC()!=null)
						 age1 = Module.age(clt.getDateNaissC()).substring(0, 2);
						else
							age1="";	
					}
			
				if(age1.equals("")){
					age=age1;
				}else{
					age="( "+age1+" )"+" Ans";
				}
			
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("idAnalyse", selectedAnalyse.getIdanalyseDemandee());
			param.put("age", age);
			Module.imprimer(nomReport, param);
			

		}
	}

	public void viewAnalyse(ActionEvent actionEvent) throws SQLException,
			Exception {
		FacesContext face = FacesContext.getCurrentInstance();
		AnalyseDemandeeService ser = new AnalyseDemandeeService();
		AnalyseDemandee ana = new AnalyseDemandee();
		if (analyseDemandees != null) {
			ana.setAnalyses(analyseDemandees);
		}
		ana.setToxo(toxo);
		ana.setTpha(tpha);
		ana.setAgHbs(agHbs);
		ana.setRubeole(rubeole);
		ana.setGlycemie(glycemie);
		ana.setFrottis(frottis);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);

		ConsultationDetailService se = new ConsultationDetailService();
		consultationDetail = se
				.rechercheConsultationDetail(idConsultationDetail);
		consultationDetail.setAnalyse("analyse");
		se.modifierConsultationDetail(consultationDetail);

		ana.setConsultationDetail(consultationDetail);
		if (action.equals("ajout")) {
			ser.ajoutAnalyseDemandee(ana);
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Démande analyse ajoutée avec succés"));
			initialisationAnalyse();

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			// ecrire analyse dans la ligne de consultationDetail
			consultationDetail.setAnalyse("Analyse");
			clt.setToxo(toxo);
			clt.setTpha(tpha);
			clt.setRubeole(rubeole);
			serclt.modifierPatient(clt);

		} else if (action.equals("modification")) {
			ana.setIdanalyseDemandee(idanalyseDemandee);
			ser.modifierAnalyseDemandee(ana);
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Démande analyse modifiée avec succés"));

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			clt.setToxo(toxo);
			clt.setTpha(tpha);
			clt.setRubeole(rubeole);
			serclt.modifierPatient(clt);
		}

		String nomReport = "demandeAnalyse";
		String age1 = Module.age(clt.getDateNaiss()).substring(0, 2);
		String age = "(" + age1 + ")";
		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idAnalyse", idanalyseDemandee);
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

	public AnalyseDemandee getSelectedAnalyse() {
		return selectedAnalyse;
	}

	public void setSelectedAnalyse(AnalyseDemandee selectedAnalyse) {
		this.selectedAnalyse = selectedAnalyse;
	}

	public void onRowSelectAnalyse(SelectEvent event) {
		desibledImpr = true;
		impress=false;
		idanalyseDemandee = null;

		AnalyseDemandee analysee = (AnalyseDemandee) event.getObject();
		idanalyseDemandee = analysee.getIdanalyseDemandee();
		selectedAnalyse = analysee;
	}

	public void consulerAnalyse(SelectEvent event) {
		action = "consulter";
		AnalyseDemandee analysee = (AnalyseDemandee) event.getObject();
		
		idanalyseDemandee = analysee.getIdanalyseDemandee();
		proprietaire = analysee.getPossesseur();
		nomProprietaire = analysee.getProprietaire();
		analyseDemandees = analysee.getAnalyses();
		toxo = analysee.getToxo();
		tpha = analysee.getTpha();
		rubeole = analysee.getRubeole();
		agHbs = analysee.getAgHbs();
		glycemie = analysee.getGlycemie();
		frottis = analysee.getFrottis();
		dateAna = analysee.getDateAnalyse();
		desibledImpr = true;
		viewImprim = false;

	}

	public void viewHistoriqueAnalyse() throws SQLException, Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);

		String nomReport = "demandeAnalyse";
		String age1 = Module.age(clt.getDateNaiss()).substring(0, 2);
		String age = "(" + age1 + ")";
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("idAnalyse", selectedAnalyse.getIdanalyseDemandee());
		param.put("age", age);

	
		Module.imprimer(nomReport, param);
	}

	public Boolean getDesibledImpr() {
		return desibledImpr;
	}

	public void setDesibledImpr(Boolean desibledImpr) {
		this.desibledImpr = desibledImpr;
	}

	public void frottiChange() {
		setFrottis(frottis);
	}

	public void toxoChange() {
		setToxo(toxo);
	}

	public void tphaChange() {
		setTpha(tpha);
	}

	public void rubeoleChange() {
		setRubeole(rubeole);
	}

	public void aghbsChange() {
		setAgHbs(agHbs);
	}

	public void glycemieChange() {
		setGlycemie(glycemie);
	}
	
	private boolean impress;
	
	public boolean isImpress() {
		return impress;
	}

	public void setImpress(boolean impress) {
		this.impress = impress;
	}

	public void closedialog(){
		try {
			 FacesContext.getCurrentInstance().getExternalContext()
			 .redirect("HistoriqueAnalyses");
			 } catch (Exception e) {
			}
	}
	
	public void dateChange(SelectEvent event) {

		setDateAna((Date) event.getObject());
		setDateAna(dateAna);
	}

	public void dateChange2() {

		setDateAna(dateAna);
	}
}
