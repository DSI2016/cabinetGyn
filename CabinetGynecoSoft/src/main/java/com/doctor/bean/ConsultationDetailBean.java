package com.doctor.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

import com.doctor.persistance.Analyse;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Consultation;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.Diagnostique;
import com.doctor.persistance.Examen;
import com.doctor.persistance.ExamenComplementaire;
import com.doctor.persistance.HistoriqueGross;
import com.doctor.persistance.Modele;
import com.doctor.persistance.Ordonnance;
import com.doctor.persistance.Symptome;
import com.doctor.persistance.Uterus;
import com.doctor.service.AnalyseService;
import com.doctor.service.CfclientService;
import com.doctor.service.ConsultaionService;
import com.doctor.service.ConsultationDetailService;
import com.doctor.service.DiagnostiqueService;
import com.doctor.service.ExamenService;
import com.doctor.service.HistoriqueGrossService;
import com.doctor.service.ModeleService;
import com.doctor.service.OrdonnanceService;
import com.doctor.service.SymptomeService;
import com.doctor.service.UterusService;

@ManagedBean(name = "consultationDetailBean")
@SessionScoped
public class ConsultationDetailBean implements Serializable {
	/**
	 * 
	 */
	private String ancianTypeCons;
	private static final long serialVersionUID = 1L;
	public int tempsgrowlconsechogyn = 1000;
	public boolean blocage = false;
	public Integer idConsultationDetail;
	private String dateConsultation;
	private boolean existe;
	private String ancienValeurDDG;
	private boolean ddgCorigee = false;
	private double honoraire;
	private String honoraireStringobs1;
	private String honoraireStringobs2;
	private String honoraireStringobs3;
	private String toxo;
	private String tpha;
	private String rubeole;
	private String poids;
	private String tas;
	private String tad;
	private String hu;
	private String sInf;
	private String honorairestring;
	private String leuorhee;
	private String col;
	private String symptome;
	private String examen;
	private String diagnostique;
	private String seins;
	private String tv;
	private String speculum;
	private String dateFrotti;
	private String ancienvaleurddg;
	private String resultatFrotti;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(false);
	private Integer idPatient = (Integer) session.getAttribute("idu");

	private Integer idConsultation;
	private Consultation consultation;
	private String analyse;
	private String radio;

	private String termePrevu;
	private String termeActuel;

	private String ddr;
	private int test;
	private String ddg;
	// les attributs des consultation echo gynecologie
	private String indications;
	private String contours;
	private String echostructure;
	private String ligne;
	private String annexes;
	private String conclusion;
	private Integer longueur;
	private Integer larg;
	private Integer diam;
	private Integer idUterus;
	private Uterus uterus;
	private String nomUterus;
	private String action;
	private String read = "noeditable";
	private int tempsface = 3000;
	private String ancienValeur = "";
	private String ancienValeur1 = "";
	private String ancienValeur2 = "";
	private String ancienValeur3 = "";
	// les attribut de modele

	private String nommodele;
	private Integer idmodele;
	private String annexesModele;
	private String contoursModele;
	private String echostructureModele;
	private Uterus uterusModele;
	private List<Modele> modeles = new ArrayList<Modele>();

	// le vaiable de consultation echo obs
	private String ancienvaleurddr;
	private int trim = 1;
	private double bip;
	private double bip2;
	private double bip3;
	private double femur2;
	private double femur3;
	private double dat2;
	private double ca2;
	private double dat3;
	private double ca3;
	private double lcc;
	private double sac;
	private String tonique;
	private String echomoyen;
	private String morphologie2;
	private String morphologie3;
	private String conclusionobs;
	private String conclusionobs2;
	private String conclusionobs3;
	private String annexesobs;
	private String presentation2;
	private String presentation3;
	private String vesicule;
	private String ac;
	private String ac2;
	private String ac3;
	private String mf2;
	private String mf3;
	private String ef;
	private String placenta2;
	private String liq2;
	private String placenta3;
	private String liq3;
	private String trophoblaste;
	private double honorairesobs;
	private double honorairesobs2;
	private double honorairesobs3;
	private String titreTrim;
	private String dateconsultation1;
	private String dateconsultation2;
	private String dateconsultation3;
	private int indexTbView;
	private Boolean erreur = false;
	private boolean desibledOrd;
	private boolean desibledRadio;
	private boolean desibledAnalyse;
	private List<String> toniques = new ArrayList<String>();
	// les liste des consultation echo gynecologie
	private List<Uterus> uteruss = new ArrayList<Uterus>();
	private List<String> contourss = new ArrayList<String>();
	private List<String> echostructures = new ArrayList<String>();

	// c'est le resultat de la sélection qui contient le type de la consultation
	private String consultationmotif;
	private List<Symptome> symptomes = new ArrayList<Symptome>();
	private List<Examen> examens = new ArrayList<Examen>();
	private List<Diagnostique> diagnostiques = new ArrayList<Diagnostique>();
	private List<ConsultationDetail> consultationDetails = new ArrayList<ConsultationDetail>();
	private String libsymptome;
	private String libexamen;
	private String libdiagnostique;
	private ConsultationDetail selectedCons;
	private List<ConsultationDetail> toutConsultations = new ArrayList<ConsultationDetail>();

	private List<Analyse> analyses = new ArrayList<Analyse>();
	private List<ExamenComplementaire> examenComplementaires = new ArrayList<ExamenComplementaire>();
	private ConsultationDetail selectedConsult;

	private String notes;
	private boolean app;
	private String typeConsultation;
	private String cat;
	private boolean testr;
	private boolean afficheValid = true;
	private boolean afficheImpr = true;
	private boolean afficheValidEchoObs = true;
	private boolean afficheImprEchoObs = true;

	public boolean isAfficheValidEchoObs() {
		return afficheValidEchoObs;
	}

	public void setAfficheValidEchoObs(boolean afficheValidEchoObs) {
		this.afficheValidEchoObs = afficheValidEchoObs;
	}

	public boolean isAfficheImprEchoObs() {
		return afficheImprEchoObs;
	}

	public void setAfficheImprEchoObs(boolean afficheImprEchoObs) {
		this.afficheImprEchoObs = afficheImprEchoObs;
	}

	public boolean isAfficheImpr() {
		return afficheImpr;
	}

	public void setAfficheImpr(boolean afficheImpr) {
		this.afficheImpr = afficheImpr;
	}

	public boolean isAfficheValid() {
		return afficheValid;
	}

	public void setAfficheValid(boolean afficheValid) {
		this.afficheValid = afficheValid;
	}

	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public boolean isTestr() {
		return testr;
	}

	public void setTestr(boolean testr) {
		this.testr = testr;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getTypeConsultation() {
		return typeConsultation;
	}

	public void setTypeConsultation(String typeConsultation) {
		this.typeConsultation = typeConsultation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ConsultationDetail getSelectedConsult() {
		return selectedConsult;
	}

	public void setSelectedConsult(ConsultationDetail selectedConsult) {
		this.selectedConsult = selectedConsult;
	}

	public String getAnalyse() {
		return analyse;
	}

	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public List<Analyse> getAnalyses() {

		AnalyseService ser = new AnalyseService();
		analyses = ser.rechercheTousAnalyse();

		return analyses;
	}

	public void setAnalyses(List<Analyse> analyses) {
		this.analyses = analyses;
	}

	public List<ExamenComplementaire> getExamenComplementaires() {
		return examenComplementaires;
	}

	public void setExamenComplementaires(
			List<ExamenComplementaire> examenComplementaires) {
		this.examenComplementaires = examenComplementaires;
	}

	public List<ConsultationDetail> getToutConsultations() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		// idPatient = Module.idpatient;
		ConsultationDetailService ser = new ConsultationDetailService();
		toutConsultations = ser.rechercheToutConsultation(idPatient);

		return toutConsultations;
	}

	public void setToutConsultations(List<ConsultationDetail> toutConsultations) {
		this.toutConsultations = toutConsultations;
	}

	public String getLibsymptome() {
		return libsymptome;
	}

	public void setLibsymptome(String libsymptome) {
		this.libsymptome = libsymptome;
	}

	public String getLibexamen() {
		return libexamen;
	}

	public void setLibexamen(String libexamen) {
		this.libexamen = libexamen;
	}

	public String getLibdiagnostique() {
		return libdiagnostique;
	}

	public void setLibdiagnostique(String libdiagnostique) {
		this.libdiagnostique = libdiagnostique;
	}

	public ConsultationDetail getSelectedCons() {
		return selectedCons;
	}

	public Integer getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(Integer idConsultation) {
		this.idConsultation = idConsultation;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public void setSelectedCons(ConsultationDetail selectedCons) {
		if (selectedCons != null)
			this.selectedCons = selectedCons;
	}

	public List<ConsultationDetail> getConsultationDetails() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		// idPatient = Module.idpatient;

		ConsultationDetailService ser = new ConsultationDetailService();
		if ((idPatient != null)
				&& ((consultationmotif != null) || (consultationmotif
						.equals("")) && uterus != null)) {
			consultationDetails = ser.rechercheToutConsultationDetail(
					idPatient, consultationmotif, uterus);
		}

		return consultationDetails;
	}

	public void setConsultationDetails(
			List<ConsultationDetail> consultationDetails) {
		this.consultationDetails = consultationDetails;
	}

	public List<Examen> getExamens() {
		ExamenService ser = new ExamenService();
		examens = ser.rechercheToutExamen();
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public List<Diagnostique> getDiagnostiques() {
		DiagnostiqueService ser = new DiagnostiqueService();
		diagnostiques = ser.rechercheTousDiagnostique();

		return diagnostiques;
	}

	public void setDiagnostiques(List<Diagnostique> diagnostiques) {
		this.diagnostiques = diagnostiques;
	}

	public List<Symptome> getSymptomes() {
		SymptomeService ser = new SymptomeService();
		symptomes = ser.rechercheTousSymptome();
		return symptomes;
	}

	public void setSymptomes(List<Symptome> symptomes) {
		this.symptomes = symptomes;
	}

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public String getConsultationmotif() {
		return consultationmotif;
	}

	public void setConsultationmotif(String consultationmotif) {
		this.consultationmotif = consultationmotif;
	}

	public Integer getIdConsultationDetail() {
		return idConsultationDetail;
	}

	public void setIdConsultationDetail(Integer idConsultationDetail) {
		this.idConsultationDetail = idConsultationDetail;
	}

	public String getDateConsultation() {
		return dateConsultation;

	}

	public void setDateConsultation(String dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getDdr() {

		/*
		 * CfclientService serclt = new CfclientService(); Cfclient clt = new
		 * Cfclient(); clt = serclt.RechercheCfclient(idPatient); ddr =
		 * clt.getDdr();
		 */
		return ddr;
	}

	public void setDdr(String ddr) {
		this.ddr = ddr;
	}

	public String getDdg() {
		/*
		 * CfclientService serclt = new CfclientService(); Cfclient clt = new
		 * Cfclient(); clt = serclt.RechercheCfclient(idPatient); ddg =
		 * clt.getDdg();
		 */
		// System.out.println("ddg"+ddg);
		return ddg;
	}

	public void setDdg(String ddg) {

		this.ddg = ddg;
	}

	public String getTermePrevu() {
		/*
		 * CfclientService serclt = new CfclientService(); Cfclient clt = new
		 * Cfclient(); clt = serclt.RechercheCfclient(idPatient); termePrevu =
		 * clt.gettPrevu();
		 */
		return termePrevu;
	}

	public void setTermePrevu(String termePrevu) {
		this.termePrevu = termePrevu;
	}

	public String getTermeActuel() {
		/*
		 * CfclientService serclt = new CfclientService(); Cfclient clt = new
		 * Cfclient(); clt = serclt.RechercheCfclient(idPatient); termeActuel =
		 * clt.gettActuel();
		 */
		return termeActuel;
	}

	public void setTermeActuel(String termeActuel) {
		this.termeActuel = termeActuel;
	}

	public double getHonoraire() {

		return honoraire;

	}

	public void setHonoraire(double honoraire) {

		this.honoraire = honoraire;
		honorairestring = Double.toString(honoraire);

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

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getTas() {
		return tas;
	}

	public void setTas(String tas) {
		this.tas = tas;
	}

	public String getTad() {
		return tad;
	}

	public void setTad(String tad) {
		this.tad = tad;
	}

	public String getHu() {
		return hu;
	}

	public String getsInf() {
		return sInf;
	}

	public void setHu(String hu) {
		this.hu = hu;
	}

	public void setsInf(String sInf) {
		this.sInf = sInf;
	}

	public String getLeuorhee() {
		return leuorhee;
	}

	public void setLeuorhee(String leuorhee) {
		this.leuorhee = leuorhee;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getSymptome() {
		return symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

	public String getExamen() {

		return examen;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public String getDiagnostique() {

		return diagnostique;
	}

	public void setDiagnostique(String diagnostique) {

		this.diagnostique = diagnostique;

	}

	public String getSeins() {
		return seins;
	}

	public void setSeins(String seins) {
		this.seins = seins;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getSpeculum() {
		return speculum;
	}

	public void setSpeculum(String speculum) {
		this.speculum = speculum;
	}

	public String getDateFrotti() {

		return dateFrotti;
	}

	public void setDateFrotti(String dateFrotti) {

		this.dateFrotti = dateFrotti;

	}

	public String getResultatFrotti() {
		return resultatFrotti;
	}

	public void setResultatFrotti(String resultatFrotti) {
		this.resultatFrotti = resultatFrotti;
	}

	// les attributs de consultation echo gynecologie

	public String getIndications() {
		return indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}

	public String getContours() {
		return contours;
	}

	public void setContours(String contours) {
		this.contours = contours;
	}

	public String getEchostructure() {
		return echostructure;
	}

	public void setEchostructure(String echostructure) {
		this.echostructure = echostructure;
	}

	public String getLigne() {

		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public String getAnnexes() {
		return annexes;
	}

	public void setAnnexes(String annexes) {
		this.annexes = annexes;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public Integer getLongueur() {

		return longueur;
	}

	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}

	public Integer getLarg() {
		return larg;
	}

	public void setLarg(Integer larg) {
		this.larg = larg;
	}

	public Integer getDiam() {
		return diam;
	}

	public void setDiam(Integer diam) {
		this.diam = diam;
	}

	public Uterus getUterus() {
		return uterus;
	}

	public void setUterus(Uterus uterus) {
		this.uterus = uterus;
	}

	public Integer getIdUterus() {
		return idUterus;
	}

	public void setIdUterus(Integer idUterus) {
		this.idUterus = idUterus;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	// methode de echo gyneco
	public void ajoutConsEchoGyneco() {

		afficheValid = false;
		afficheImpr = true;
		indications = null;
		contours = "--selectionner--";
		echostructure = "--selectionner--";
		ligne = null;
		annexes = null;

		conclusion = null;
		longueur = null;
		larg = null;
		diam = null;
		idUterus = null;
		nomUterus = null;
		read = "editable";
		idmodele = null;
		nommodele = null;
		diam = null;
		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);
		honoraire = cons.getHonoraire();
		honorairestring = Double.toString(honoraire);
		Date actuelle = new Date();
		// * Definition du format utilise pour les dates
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateConsultation = dateFormat.format(actuelle);
		ancienValeur = dateFormat.format(actuelle);
		action = "ajouter";

	}

	// fin attribut

	// methode de echo gyneco
	public void ajoutConsEchoObs() {

		afficheImprEchoObs = true;
		afficheValidEchoObs = false;
		read = "editable";
		bip = 0.0;
		bip2 = 0.0;
		bip3 = 0.0;
		femur2 = 0.0;
		femur3 = 0.0;
		dat2 = 0.0;
		ca2 = 0.0;
		dat3 = 0.0;
		ca3 = 0.0;
		lcc = 0.0;
		sac = 0.0;
		tonique = null;
		echomoyen = null;
		CfclientService serclt = new CfclientService();
		Cfclient clt = new Cfclient();
		idPatient = (Integer) session.getAttribute("idu");
		clt = serclt.RechercheCfclient(idPatient);
		ddr = clt.getDdr();
		ddg = clt.getDdg();
		ddgCorigee = clt.isDdgCorigee();
		termeActuel = clt.gettActuel();
		termePrevu = clt.gettPrevu();
		Date actuelle = new Date();
		// * Definition du format utilise pour les dates
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateconsultation1 = dateFormat.format(actuelle);
		dateconsultation2 = dateFormat.format(actuelle);
		dateconsultation3 = dateFormat.format(actuelle);
		morphologie2 = null;
		morphologie3 = null;
		conclusionobs = null;
		conclusionobs2 = null;
		conclusionobs3 = null;
		annexesobs = null;
		presentation2 = null;
		presentation3 = null;
		vesicule = null;
		ac = null;
		ac2 = null;
		ac3 = null;
		mf2 = null;
		mf3 = null;
		ef = null;
		placenta2 = null;
		liq2 = null;
		placenta3 = null;
		liq3 = null;
		trophoblaste = null;
		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);

		honorairesobs = cons.getHonoraire();
		honorairesobs2 = cons.getHonoraire();
		honorairesobs3 = cons.getHonoraire();
		honoraireStringobs1 = Double.toString(honorairesobs);
		honoraireStringobs2 = Double.toString(honorairesobs2);
		honoraireStringobs3 = Double.toString(honorairesobs3);
		titreTrim = null;
		ancienValeur1 = dateFormat.format(actuelle);
		ancienValeur2 = dateFormat.format(actuelle);
		ancienValeur3 = dateFormat.format(actuelle);
		dateconsultation1 = dateFormat.format(actuelle);
		dateconsultation2 = dateFormat.format(actuelle);

		dateconsultation3 = dateFormat.format(actuelle);

		action = "ajouter";

	}

	public void initialisationechogyneco() {

		afficheValid = true;
		afficheImpr = true;
		indications = null;
		contours = "--selectionner--";
		echostructure = "--selectionner--";
		typeConsultation = "--selectionner--";
		ligne = null;
		annexes = null;
		conclusion = null;
		longueur = 0;
		larg = 0;
		diam = 0;
		idUterus = null;
		nomUterus = null;
		uterus = null;
		dateConsultation = null;

		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);
		honoraire = cons.getHonoraire();
		honorairesobs = cons.getHonoraire();
		honorairesobs2 = cons.getHonoraire();
		honorairesobs3 = cons.getHonoraire();
		honoraireStringobs1 = "";
		honoraireStringobs2 = "";
		honoraireStringobs3 = "";
		honorairestring = "";
		idmodele = null;
		nommodele = null;
		selectedCons = null;
		action = null;
		read = "noeditable";

	}

	public List<Uterus> getUteruss() {
		UterusService ser = new UterusService();
		uteruss = ser.rechercheTousUterus();
		return uteruss;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getNomUterus() {
		return nomUterus;
	}

	public void setNomUterus(String nomUterus) {
		this.nomUterus = nomUterus;
	}

	public void setUteruss(List<Uterus> uteruss) {
		this.uteruss = uteruss;
	}

	public List<String> getContourss() {

		contourss.clear();
		contourss.add(new String("Réguliers"));
		contourss.add(new String("Iréguliers"));

		return contourss;
	}

	public List<String> getEchostructures() {

		echostructures.clear();
		echostructures.add(new String("Homogéne"));
		echostructures.add(new String("Hétérogène"));

		return echostructures;
	}

	public void setEchostructures(List<String> echostructures) {

		this.echostructures = echostructures;
	}

	public void setContourss(List<String> contourss) {

		this.contourss = contourss;
	}

	public boolean lireReadOnly() {
		if (read.equals("editable"))
			return (false);
		else
			return (true);
	}

	public void apliquerModele(Integer idmod) {
		selectedCons = null;
		selectedConsult = null;
		FacesContext face = FacesContext.getCurrentInstance();
		if (idmod != null) {
			ModeleService ser = new ModeleService();
			Modele mod = ser.rechercheModeleParIdAvecJointure(idmod);
			annexes = mod.getAnnexes();
			indications = mod.getIndications();
			contours = mod.getContours();
			echostructure = mod.getEchostructure();
			conclusion = mod.getConclusion();
			ligne = mod.getLigne();
			larg = mod.getLarg();
			longueur = mod.getLongueur();
			diam = mod.getDiam();

			if (mod.getUterus() != null) {
				uterus = mod.getUterus();
				idUterus = mod.getUterus().getIduterus();
				nomUterus = mod.getUterus().getUterus();
			}
		} else

		{
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur", "Veuillez sélectionner un modèle"));
		}
	}

	public void ajouterModele() {
		FacesContext face = FacesContext.getCurrentInstance();
		Modele mod = new Modele();
		ModeleService ser = new ModeleService();

		mod.setNommodele(nommodele);
		mod.setAnnexes(annexes);
		mod.setIndications(indications);
		mod.setEchostructure(echostructure);
		if (idUterus != null) {
			Uterus ut = new UterusService().rechercheUterus(idUterus);
			// ut.setIduterus(idUterus);

			mod.setUterus(ut);
		}

		mod.setConclusion(conclusion);
		mod.setDiam(diam);
		mod.setLarg(larg);
		mod.setLigne(ligne);
		mod.setLongueur(longueur);

		mod.setContours(contours);

		Modele mod2 = new Modele();
		mod2 = ser.rechercheParModele(mod.getNommodele());

		if (mod2 != null) {
			this.blocage = true;
			face.addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
							"existe un Modéle sous le nom "
									+ mod.getNommodele()));
		}
		int i;
		existe = false;
		for (i = 0; i < modeles.size(); i++) {
			if (mod.getAnnexes() != null && modeles.get(i).getAnnexes() != null) {
				if (!(mod.getAnnexes().equals(modeles.get(i).getAnnexes()))) {
					continue;
				}
			} else if (mod.getAnnexes() != null
					|| modeles.get(i).getAnnexes() != null) {
				continue;
			}

			if (mod.getUterus() != null && modeles.get(i).getUterus() != null) {
				if (!(mod.getUterus().equals(modeles.get(i).getUterus()))) {
					continue;
				}
			} else if (mod.getUterus() != null
					|| modeles.get(i).getUterus() != null) {
				continue;
			}

			if (mod.getContours() != null
					&& modeles.get(i).getContours() != null) {
				if (!(mod.getContours().equals(modeles.get(i).getContours()))) {
					continue;
				}
			} else if (mod.getContours() != null
					|| modeles.get(i).getContours() != null) {
				continue;
			}

			if (mod.getEchostructure() != null
					&& modeles.get(i).getEchostructure() != null) {
				if (!(mod.getEchostructure().equals(modeles.get(i)
						.getEchostructure()))) {
					continue;
				}
			} else if (mod.getEchostructure() != null
					|| modeles.get(i).getEchostructure() != null) {
				continue;
			}

			if (mod.getDiam() != null && modeles.get(i).getDiam() != null) {
				if (!(mod.getDiam().equals(modeles.get(i).getDiam()))) {
					continue;
				}
			} else if (mod.getDiam() != null
					|| modeles.get(i).getDiam() != null) {
				continue;
			}

			if (mod.getLarg() != null && modeles.get(i).getLarg() != null) {
				if (!(mod.getLarg().equals(modeles.get(i).getLarg()))) {
					continue;
				}
			} else if (mod.getLarg() != null
					|| modeles.get(i).getLarg() != null) {
				continue;
			}

			if (mod.getLigne() != null && modeles.get(i).getLigne() != null) {
				if (!(mod.getLigne().equals(modeles.get(i).getLigne()))) {
					continue;
				}
			} else if (mod.getLigne() != null
					|| modeles.get(i).getLigne() != null) {
				continue;
			}

			if (mod.getConclusion() != null
					&& modeles.get(i).getConclusion() != null) {
				if (!(mod.getConclusion()
						.equals(modeles.get(i).getConclusion()))) {
					continue;
				}
			} else if (mod.getConclusion() != null
					|| modeles.get(i).getConclusion() != null) {
				continue;
			}

			if (mod.getIndications() != null
					&& modeles.get(i).getIndications() != null) {
				if (!(mod.getIndications().equals(modeles.get(i)
						.getIndications()))) {
					continue;
				}
			} else if (mod.getIndications() != null
					|| modeles.get(i).getIndications() != null) {
				continue;
			}

			if (mod.getLongueur() != null
					&& modeles.get(i).getLongueur() != null) {
				if (!(mod.getLongueur().equals(modeles.get(i).getLongueur()))) {
					continue;
				} else if ((mod.getLongueur().equals(modeles.get(i)
						.getLongueur()))) {

					existe = true;
					break;
				}

			} else if (mod.getLongueur() != null
					|| modeles.get(i).getLongueur() != null)

			{
				continue;
			} else if (mod.getLongueur() == null
					&& modeles.get(i).getLongueur() == null) {
				existe = true;
				break;
			}

		}
		if (existe == true) {
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "le contenue de cet modéle existe deja sous le nom "
							+ modeles.get(i).getNommodele()));
			nommodele = null;
		}

		if (face.getMessageList().size() == 0) {
			ser.ajoutModele(mod);
			this.blocage = false;
			tempsface = 3500;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Modélé Ajoutée Avec Succés"));
			nommodele = null;
		}

	}

	public void modiefierConsEchoGyneco(ConsultationDetail cons) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", cons.getIdConsultationDetail());
		
		selectedCons=cons;
		idConsultationDetail = cons.getIdConsultationDetail();

		ancienValeur = formatter.format(cons.getDateConsultation());
		dateConsultation = formatter.format(cons.getDateConsultation());
		if (cons != null) {
			cfclient = cons.getCfclient();
			idConsultationDetail = cons.getIdConsultationDetail();
			indications = cons.getIndications();
			longueur = cons.getLongueur();
			larg = cons.getLarg();
			diam = cons.getDiam();
			ligne = cons.getLigne();
			dateConsultation = formatter.format(cons.getDateConsultation());

			annexes = cons.getAnnexes();
			conclusion = cons.getConclusion();
			honoraire = cons.getHonoraire();
			honorairestring = Double.toString(honoraire);
			if (cons.getUterus() != null) {
				uterus = cons.getUterus();
				idUterus = cons.getUterus().getIduterus();
				nomUterus = cons.getUterus().getUterus();
			}
			contours = cons.getContours();
			echostructure = cons.getEchostructure();
		}

		read = "editable";
		action = "modifier";
		afficheValid = false;
		afficheImpr = true;
	}

	public void supprimerModeleConsEchoGyn(Integer idModelee) {

		FacesContext face = FacesContext.getCurrentInstance();
		if (idModelee == null)

		{

			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur", "Veuillez selectionner un Modéle"));

		}

		else if (face.getMessageList().size() == 0) {
			ModeleService ser = new ModeleService();
			ser.supprimerModele(idModelee);
			this.blocage = false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Modèle Supprimé avec Succès"));

		}

	}

	public void modiefierConsEchoObs(ConsultationDetail c) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", c.getIdConsultationDetail());
		idConsultationDetail = c.getIdConsultationDetail();
		dateConsultation = formatter.format(c.getDateConsultation());
		
		action = "selection";
		if (c != null) {
			selectedCons=c;
			if (c.getTrim() == 1) {
				this.indexTbView = 0;
				cfclient = c.getCfclient();
				idConsultationDetail = c.getIdConsultationDetail();
				dateconsultation1 = formatter.format(c.getDateConsultation());
				ancienValeur1 = formatter.format(c.getDateConsultation());
				trim = c.getTrim();
				bip = c.getBip();
				echomoyen = c.getEchomoyen();
				// CfclientService serclt = new CfclientService();
				// Cfclient clt = new Cfclient();
				// clt = serclt.RechercheCfclient(idPatient);
				// ddr = clt.getDdr();
				// ddg = clt.getDdg();
				// termeActuel = clt.gettActuel();
				// termePrevu = clt.gettPrevu();
				ddr = c.getDdr();
				ddg = c.getDdg();
				ddgCorigee = c.isDdgCorigee();
				termeActuel = c.getTermeActuel();
				termePrevu = c.getTermePrevu();
				/*
				 * femur = c.getFemur(); dat = c.getDat(); ca = c.getCa();
				 */
				lcc = c.getLcc();
				sac = c.getSac();
				tonique = c.getTonique();
				// echomoyen = c.getEchomoyen();
				// morphologie = c.getMorphologie();
				conclusionobs = c.getConclusionobs();
				annexesobs = c.getAnnexesobs();
				// presentation = c.getPresentation();
				vesicule = c.getVesicule();
				ac = c.getAc();
				// mf = c.getMf();
				ef = c.getEf();
				// placenta = c.getPlacenta();
				// liq = c.getLiq();
				honorairesobs = c.getHonoraire();
				trophoblaste = c.getTrophoblaste();

			}
			if (c.getTrim() == 2) {
				this.indexTbView = 1;
				cfclient = c.getCfclient();
				idConsultationDetail = c.getIdConsultationDetail();
				ancienValeur2 = formatter.format(c.getDateConsultation());
				dateconsultation2 = formatter.format(c.getDateConsultation());
				trim = c.getTrim();
				bip2 = c.getBip();
				femur2 = c.getFemur();
				dat2 = c.getDat();
				ca2 = c.getCa();
				echomoyen = c.getEchomoyen();
				// lcc = c.getLcc();
				// sac = c.getSac();
				// tonique = c.getTonique();
				// echomoyen = c.getEchomoyen();
				morphologie2 = c.getMorphologie();
				conclusionobs2 = c.getConclusionobs();
				// annexesobs = c.getAnnexesobs();
				presentation2 = c.getPresentation();
				// vesicule = c.getVesicule();
				ac2 = c.getAc();
				mf2 = c.getMf();

				placenta2 = c.getPlacenta();
				liq2 = c.getLiq();
				honorairesobs2 = c.getHonoraire();

			}
			if (c.getTrim() == 3) {
				this.indexTbView = 2;
				cfclient = c.getCfclient();
				idConsultationDetail = c.getIdConsultationDetail();
				dateconsultation3 = formatter.format(c.getDateConsultation());
				ancienValeur3 = formatter.format(c.getDateConsultation());
				trim = c.getTrim();
				bip3 = c.getBip();
				femur3 = c.getFemur();
				dat3 = c.getDat();
				ca3 = c.getCa();
				echomoyen = c.getEchomoyen();
				conclusionobs3 = c.getConclusionobs();
				presentation3 = c.getPresentation();
				ac3 = c.getAc();
				mf3 = c.getMf();
				morphologie3 = c.getMorphologie();
				placenta3 = c.getPlacenta();
				liq3 = c.getLiq();
				honorairesobs3 = c.getHonoraire();
				// trophoblaste = c.getTrophoblaste();

			}

		}
		read = "editable";
		action = "modifier";
		afficheValidEchoObs = false;
		afficheImprEchoObs = true;

	}

	public void validerConsEchoGyneco() {
		// boolean testValid = true;
		ConsultationDetail cons = new ConsultationDetail();
		String msg = "";
		FacesContext face = FacesContext.getCurrentInstance();
		ConsultationDetailService ser = new ConsultationDetailService();
		CfclientService serclt = new CfclientService();
		if (action != null) {
			if (Module.corigerDate(dateConsultation) != null) {
				this.setDateConsultation(Module.corigerDate(dateConsultation));
			}
			if (!(Module.verifierDate(dateConsultation).equals(""))) {
				blocage = true;
				msg = Module.verifierDate(dateConsultation) + "";
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur", msg));
			}
			try {

				honoraire = Float.parseFloat(honorairestring);

			} catch (Exception e) {
				// honoraire = (float) 0;
				// testValid = false;
				msg = msg + "L'honoraire ne contient que des chiffres";
				blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur", msg));

			}

			try {
				cons.setDateConsultation(formatter.parse(dateConsultation));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (msg.equals("") || msg == null) {

				if (action != null && action.equals("ajouter")) {

					if (consultationmotif != null) {
						ConsultaionService s = new ConsultaionService();
						consultation = s
								.rechercheParConsultation(consultationmotif);
						cons.setConsultation(consultation);
					}
					HttpSession session = (HttpSession) FacesContext
							.getCurrentInstance().getExternalContext()
							.getSession(false);
					idPatient = (Integer) session.getAttribute("idu");
					// idPatient = Module.idpatient;
					if (idPatient != null) {

						Cfclient c = serclt.RechercheCfclient(idPatient);
						c.setTypCons(consultationmotif);
						c.setDernierVisite(dateConsultation);
						c.setNbCons(c.getNbCons() + 1);
						serclt.modifierPatient(c);

						cons.setCfclient(c);
					}
					if (idUterus != null) {
						UterusService seruterus = new UterusService();
						uterus = seruterus.rechercheUterus(idUterus);
						cons.setUterus(uterus);
					}
					if (idUterus == null) {
						cons.setUterus(null);
					}

					cons.setAnnexes(annexes);
					cons.setContours(contours);
					cons.setConclusion(conclusion);
					cons.setEchostructure(echostructure);
					cons.setIndications(indications);
					cons.setDiam(diam);
					cons.setLigne(ligne);
					cons.setLarg(larg);
					cons.setLongueur(longueur);
					cons.setConsultation(consultation);
					cons.setHonoraire(honoraire);
					ser.ajouterConsultationDetail(cons);

					blocage = false;
					tempsface = 3500;
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Consultation Ajoutée Avec Succés"));
					action = null;
					initialisationechogyneco();
                    afficheImpr=false;
                    afficheValid=true;
                    selectedCons=cons;
				}

				if (action != null && action.equals("modifier")) {

					ConsultationDetailService se = new ConsultationDetailService();
					cons = se.rechercheConsultationDetail(idConsultationDetail);
					ConsultaionService s = new ConsultaionService();
					consultation = s
							.rechercheParConsultation(consultationmotif);

					HttpSession session = (HttpSession) FacesContext
							.getCurrentInstance().getExternalContext()
							.getSession(false);
					idPatient = (Integer) session.getAttribute("idu");
					// idPatient = Module.idpatient;
					Cfclient c = serclt.RechercheCfclient(idPatient);
					UterusService seruterus = new UterusService();
					if (idUterus != null) {
						uterus = seruterus.rechercheUterus(idUterus);
					}

					cons.setAnnexes(annexes);
					cons.setContours(contours);
					cons.setHonoraire(Double.parseDouble(honorairestring));
					cons.setCfclient(c);
					cons.setConclusion(conclusion);
					cons.setEchostructure(echostructure);
					cons.setIndications(indications);
					cons.setDiam(diam);
					cons.setUterus(uterus);
					cons.setLarg(larg);
					cons.setLongueur(longueur);
					cons.setConsultation(consultation);
					cons.setLigne(ligne);
					se.modifierConsultationDetail(cons);
					
					blocage = false;
					tempsface = 3500;
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, " ",
							"Consultation Modifiée Avec Succés"));
					initialisationechogyneco();
					//selectedCons = null;
					afficheImpr=false;
                    afficheValid=true;
                    selectedCons=cons;

				}

			}
		}

		else {
			if (action == null) {
				blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_FATAL, "",
						"Aucune action n'est détectée"));
			}
		}
	}

	public List<Modele> getModeles() {
		ModeleService ser = new ModeleService();
		modeles = ser.rechercheTousModele();
		return modeles;
	}

	public void setModeles(List<Modele> modeles) {
		this.modeles = modeles;
	}
	
	public void  supSelect(ConsultationDetail cons){
		System.out.println("rrr*********rrr");
		selectedCons =cons;
		System.out.println("selectedCons== "+selectedCons);
		RequestContext.getCurrentInstance().update(":f1:p2,:f1:p3,:f1:p4,:f1,:f1:eventsDT"); 
		
		
	}

	public void supprimerConsultationEchoGyneco(ConsultationDetail cons) {
		
		
		FacesContext face = FacesContext.getCurrentInstance();
		ConsultationDetailService ser = new ConsultationDetailService();
		ser.supprimerConsultationDetail(cons.getIdConsultationDetail());
		selectedCons = null;
		initialisationechogyneco();
		this.blocage = false;
		tempsface = 3000;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Consultation Supprimée Avec Succés"));
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("Echographie-Gynecologique");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		CfclientService serclt = new CfclientService();
		// idPatient = Module.idpatient;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		if (idPatient != null) {

			Cfclient c = serclt.RechercheCfclient(idPatient);
			// idPatient = Module.idpatient;
			ConsultationDetailService ser1 = new ConsultationDetailService();
			toutConsultations = ser1.rechercheToutConsultation(idPatient);

			if (toutConsultations.size() != 0) {
				if (toutConsultations.size() != 0) {
					c.setDernierVisite(formatter.format(toutConsultations
							.get(0).getDateConsultation()));
					c.setNbCons(c.getNbCons() - 1);
					c.setTypCons(toutConsultations.get(0).getMotifCons());
				}
			} else
				c.setDernierVisite("Nouveau");
			serclt.modifierPatient(c);

		}

	}

	public void supprimerConsultationEchoObs(ConsultationDetail cons) {

		FacesContext face = FacesContext.getCurrentInstance();
		ConsultationDetailService ser = new ConsultationDetailService();
		ser.supprimerConsultationDetail(cons.getIdConsultationDetail());
		selectedCons = null;
		initialisationechogyneco();
		this.blocage = false;
		tempsface = 3000;

		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Consultation Supprimée Avec Succés"));
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("Echographie_Obstetricale");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		CfclientService serclt = new CfclientService();
		// idPatient = Module.idpatient;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		if (idPatient != null) {

			Cfclient c = serclt.RechercheCfclient(idPatient);
			// idPatient = Module.idpatient;
			ConsultationDetailService ser1 = new ConsultationDetailService();
			toutConsultations = ser1.rechercheToutConsultation(idPatient);

			if (toutConsultations.size() != 0) {
				if (toutConsultations.size() != 0) {
					c.setDernierVisite(formatter.format(toutConsultations
							.get(0).getDateConsultation()));
					c.setNbCons(c.getNbCons() - 1);
					c.setTypCons(toutConsultations.get(0).getMotifCons());
				}
			} else
				c.setDernierVisite("Nouveau");
			serclt.modifierPatient(c);

		}

	}

	private Cfclient cfclient;

	public Cfclient getCfclient() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		// idPatient = Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public void onSymChange() {

		if (symptome == null)
			symptome = libsymptome;
		else
			symptome += "\n" + libsymptome;

	}

	public void onExamChange() {

		if (examen == null)
			examen = libexamen;
		else
			examen += "\n" + libexamen;
	}

	public void onDiagChange() {

		if (diagnostique == null)
			diagnostique = libdiagnostique;
		else
			diagnostique += "\n" + libdiagnostique;
	}

	public void onRowSelectEchiGyneco(SelectEvent event) {

		ConsultationDetail c = (ConsultationDetail) event.getObject();
		// initialisationechogyneco();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", c.getIdConsultationDetail());
		
		read = "noeditable";

		selectedCons = c;
		action = null;
		if (c != null) {
			cfclient = c.getCfclient();
			idConsultationDetail = c.getIdConsultationDetail();
			indications = c.getIndications();
			longueur = c.getLongueur();
			larg = c.getLarg();
			diam = c.getDiam();
			ligne = c.getLigne();
			dateConsultation = formatter.format(c.getDateConsultation());

			annexes = c.getAnnexes();
			conclusion = c.getConclusion();
			honoraire = c.getHonoraire();
			honorairestring = Double.toString(honoraire);
			if (c.getUterus() != null) {
				uterus = c.getUterus();
				idUterus = c.getUterus().getIduterus();
				nomUterus = c.getUterus().getUterus();
			}
			contours = c.getContours();
			echostructure = c.getEchostructure();
			read = "noeditable";

		}
		
		afficheImpr = false;
		afficheValid = true;
	}

	public void onRowSelectEchoObs(SelectEvent event) {
		initialisationEchoObs();
		ConsultationDetail c = (ConsultationDetail) event.getObject();
		selectedCons = c;
		action = null;
		afficheImprEchoObs = false;

		if (c != null) {
			if (c.getTrim() == 1) {
				this.indexTbView = 0;
				cfclient = c.getCfclient();
				idConsultationDetail = c.getIdConsultationDetail();
				dateconsultation1 = formatter.format(c.getDateConsultation());
				trim = c.getTrim();
				bip = c.getBip();
				echomoyen = c.getEchomoyen();
				// CfclientService serclt = new CfclientService();
				// Cfclient clt = new Cfclient();
				// clt = serclt.RechercheCfclient(idPatient);
				// ddr = clt.getDdr();
				// ddg = clt.getDdg();
				// termeActuel = clt.gettActuel();
				// termePrevu = clt.gettPrevu();
				ddr = c.getDdr();
				ddg = c.getDdg();
				ddgCorigee = c.isDdgCorigee();
				termeActuel = c.getTermeActuel();
				termePrevu = c.getTermePrevu();
				// vesicule = c.getVesicule();
				/*
				 * femur = c.getFemur(); dat = c.getDat(); ca = c.getCa();
				 */
				lcc = c.getLcc();
				sac = c.getSac();
				tonique = c.getTonique();
				// echomoyen = c.getEchomoyen();
				// morphologie = c.getMorphologie();
				conclusionobs = c.getConclusionobs();
				annexesobs = c.getAnnexesobs();
				// presentation = c.getPresentation();
				vesicule = c.getVesicule();
				ac = c.getAc();
				// mf = c.getMf();
				ef = c.getEf();
				// placenta = c.getPlacenta();
				// liq = c.getLiq();
				honorairesobs = c.getHonoraire();
				honoraireStringobs1 = Double.toString(honorairesobs);
				trophoblaste = c.getTrophoblaste();

				read = "noeditable";

				// clt = serclt.RechercheCfclient(idPatient);
				// if (clt != null) {
				// ddr = clt.getDdr();
				// ddg = clt.getDdg();
				// termeActuel = clt.gettActuel();
				// termePrevu = clt.gettPrevu();
				// }

			}
			if (c.getTrim() == 2) {
				this.indexTbView = 1;
				cfclient = c.getCfclient();
				idConsultationDetail = c.getIdConsultationDetail();
				dateconsultation2 = formatter.format(c.getDateConsultation());
				trim = c.getTrim();
				bip2 = c.getBip();
				femur2 = c.getFemur();
				dat2 = c.getDat();
				ca2 = c.getCa();
				echomoyen = c.getEchomoyen();
				// lcc = c.getLcc();
				// sac = c.getSac();
				// tonique = c.getTonique();
				// echomoyen = c.getEchomoyen();
				morphologie2 = c.getMorphologie();
				conclusionobs2 = c.getConclusionobs();
				// annexesobs = c.getAnnexesobs();
				presentation2 = c.getPresentation();
				// vesicule = c.getVesicule();
				ac2 = c.getAc();
				mf2 = c.getMf();
				ddr = c.getDdr();
				ddg = c.getDdg();
				ddgCorigee = c.isDdgCorigee();
				termeActuel = c.getTermeActuel();
				termePrevu = c.getTermePrevu();
				placenta2 = c.getPlacenta();
				liq2 = c.getLiq();
				honorairesobs2 = c.getHonoraire();
				honoraireStringobs2 = Double.toString(honorairesobs2);

				read = "noeditable";
			}
			if (c.getTrim() == 3) {
				this.indexTbView = 2;
				cfclient = c.getCfclient();
				idConsultationDetail = c.getIdConsultationDetail();
				dateconsultation3 = formatter.format(c.getDateConsultation());
				trim = c.getTrim();
				bip3 = c.getBip();
				femur3 = c.getFemur();
				dat3 = c.getDat();
				ddr = c.getDdr();
				ddg = c.getDdg();
				ddgCorigee = c.isDdgCorigee();
				termeActuel = c.getTermeActuel();
				termePrevu = c.getTermePrevu();
				ca3 = c.getCa();
				echomoyen = c.getEchomoyen();
				conclusionobs3 = c.getConclusionobs();
				presentation3 = c.getPresentation();
				ac3 = c.getAc();
				mf3 = c.getMf();
				morphologie3 = c.getMorphologie();
				placenta3 = c.getPlacenta();
				liq3 = c.getLiq();
				honorairesobs3 = c.getHonoraire();
				honoraireStringobs3 = Double.toString(honorairesobs3);
				// trophoblaste = c.getTrophoblaste();

			}

		}
	}

	@SuppressWarnings("unused")
	public void onRowSelect(SelectEvent event) {

		ConsultationDetail c = (ConsultationDetail) event.getObject();

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", c.getIdConsultationDetail());
		initialisation();
		read = "noeditable";
		action = null;
		selectedCons = c;
		if (c != null) {
			desibledOrd = false;
			desibledAnalyse = false;
			desibledRadio = false;
			cfclient = c.getCfclient();
			idConsultationDetail = c.getIdConsultationDetail();
			dateConsultation = formatter.format(c.getDateConsultation());
			ddr = c.getDdr();
			ancienvaleurddr = ddr;
			ancienvaleurddg = ddg;
			ddg = c.getDdg();
			ddgCorigee = c.isDdgCorigee();
			dateConsultation = formatter.format(c.getDateConsultation());
			termePrevu = c.getTermePrevu();
			termeActuel = c.getTermeActuel();
			honorairestring = Double.toString(c.getHonoraire());
			toxo = c.getToxo();
			tpha = c.getTpha();
			rubeole = c.getRubeole();
			poids = c.getPoids();
			tas = c.getTas();
			tad = c.getTad();
			hu = c.getHu();
			sInf = c.getsInf();
			leuorhee = c.getLeuorhee();
			col = c.getCol();
			symptome = c.getSymptome();
			examen = c.getExamen();
			diagnostique = c.getDiagnostique();
			cat = c.getCat();
			notes = c.getNotes();
			speculum = c.getSpeculum();
			tv = c.getTv();
			seins = c.getSeins();
			dateFrotti = c.getDateFrotti();
			resultatFrotti = c.getResultatFrotti();
			if (c.isConsGrossType())
				typeConsultation = "Nouvelle";
			else
				typeConsultation = "Suivi";
		} else {
			desibledAnalyse = true;
			desibledOrd = true;
			desibledRadio = true;

		}
		
		afficheImpr=false;
        afficheValid=true;
        
	}

	public void demandeRadio() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", idConsultationDetail);
		session.setAttribute("idu", idPatient);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("DemandeRadio");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		selectedCons = null;
		selectedConsult = null;
		desibledAnalyse = true;
		desibledOrd = true;
		desibledRadio = true;
	}

	public void demandeOrdonnanceGyn() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", idConsultationDetail);

		idPatient = (Integer) session.getAttribute("idu");
		session.setAttribute("idu", idPatient);
		session.setAttribute("source", "Consultation-Gynecologique");
		//session.setAttribute("act", "ajoutCons");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		selectedCons = null;
		selectedConsult = null;
		desibledAnalyse = true;
		desibledOrd = true;
		desibledRadio = true;
	}

	public void demandeOrdonnanceObs() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", idConsultationDetail);

		idPatient = (Integer) session.getAttribute("idu");
		session.setAttribute("idu", idPatient);
		session.setAttribute("source", "Consultation_Obstetrique");
		// session.setAttribute("act", "ajoutCons");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		selectedCons = null;
		selectedConsult = null;
		desibledAnalyse = true;
		desibledOrd = true;
		desibledRadio = true;
	}

	public void demandeAnalyse() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", idConsultationDetail);
		session.setAttribute("idu", idPatient);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("DemandeAnalyse");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		selectedCons = null;
		selectedConsult = null;
		desibledAnalyse = true;
		desibledOrd = true;
		desibledRadio = true;
	}

	public void nouvelleConsGross() {
		initialisation();
		// apporter les données de la dernière consultation si elle existe
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		// idPatient = Module.idpatient;
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		poids = c.getPoids();
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateConsultation = dateFormat.format(actuelle);
		consGrossType = true;
		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);
		honoraire = cons.getHonoraire();

		action = "ajout";
		read = "editable";

	}

	public void validationConsultationGross() {

		String msg = "";
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		FacesContext face = FacesContext.getCurrentInstance();
		ConsultationDetail cd = new ConsultationDetail();
		if (action != null) {
			try {

				honoraire = Float.parseFloat(honorairestring);
				setHonoraire(honoraire);

			} catch (Exception e) {
				// honoraire = (float) 0;
				// testValid = false;
				this.blocage = true;
				msg = "L'honoraire ne contient que des chiffres";
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "", msg));
				ConsultaionService serf = new ConsultaionService();
				Consultation consf = serf
						.rechercheParConsultation(consultationmotif);
				honoraire = consf.getHonoraire();
				honorairestring = Double.toString(honoraire);
			}

			if (poids != null && poids.trim().length() > 0)
				try {
					poids.replaceAll(",", ".");
					Float.parseFloat(poids);
				} catch (Exception e) {
					blocage = true;
					face.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Veuillez vérifier le format du poids. Il ne peux pas contenir que des chiffres.",
									""));
					this.blocage = true;
					// poids = ancientPoids;
				}

			if (tas != null && tas.trim().length() > 0)
				try {
					tas.replaceAll(",", ".");
					Float.parseFloat(tas);
				} catch (Exception e) {
					blocage = true;
					face.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Veuillez vérifier le format du tas. Il ne peux pas contenir que des chiffres.",
									""));
					this.blocage = true;
					// tas = ancientTas;
				}
			if (tad != null && tad.trim().length() > 0)
				try {
					tad.replaceAll(",", ".");
					Float.parseFloat(tad);
				} catch (Exception e) {
					face.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Veuillez vérifier le format du tad. Il ne peux pas contenir que des chiffres.",
									""));
					this.blocage = true;
					// tad = ancientTad;
				}
			if (msg.equals("") && face.getMessageList().size() == 0) {

				cd.setTas(tas);
				cd.setDdgCorigee(ddgCorigee);
				cd.setCfclient(clt);
				cd.setDdr(ddr);
				cd.setDdg(ddg);
				cd.setTermePrevu(termePrevu);
				cd.setTermeActuel(termeActuel);
				cd.setHonoraire(honoraire);
				cd.setToxo(toxo);
				cd.setTpha(tpha);
				cd.setRubeole(rubeole);
				cd.setPoids(poids);
				cd.setTad(tad);
				cd.setHu(hu);
				cd.setsInf(sInf);
				cd.setLeuorhee(leuorhee);
				cd.setCol(col);
				cd.setSymptome(symptome);
				if (typeConsultation.equals("Nouvelle"))
					cd.setConsGrossType(true);
				else
					cd.setConsGrossType(false);

				cd.setExamen(examen);
				cd.setDiagnostique(diagnostique);
				try {
					cd.setDateConsultation(formatter.parse(dateConsultation));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cd.setCat(cat);
				cd.setNotes(notes);
				ConsultaionService s = new ConsultaionService();
				consultation = s.rechercheParConsultation(consultationmotif);

				cd.setConsultation(consultation);
				ConsultationDetailService ser = new ConsultationDetailService();
				cd.setConsGrossType(consGrossType);

				if (action != null && action.equals("ajout")) {

					if (msg.equals("")) {

						ser.ajouterConsultationDetail(cd);
						blocage = false;
						face.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "",
								"Consultation Ajoutée Avec Succés"));
						action = null;
						if (consGrossType)
						// ajouter 1 à la Gest
						{
							clt.setGestite(clt.getGestite() + 1);
							HistoriqueGrossService serhisto = new HistoriqueGrossService();
							HistoriqueGross histo = new HistoriqueGross();
							try {
								histo.setDateFinGross(formatter
										.parse(dateConsultation));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							histo.setIdcons(cd.getIdConsultationDetail());
							histo.setCfclient(clt);
							serhisto.ajouterHistoriqueGross(histo);

						}
						clt.setPoids(poids);
						clt.setDateCons(dateConsultation);
						clt.setDdg(ddg);
						clt.setDdgCorigee(ddgCorigee);
						clt.setDdr(ddr);
						clt.settPrevu(termePrevu);
						clt.settActuel(termeActuel);
						clt.setToxo(toxo);
						clt.setTpha(tpha);
						clt.setRubeole(rubeole);
						clt.setDernierVisite(dateConsultation);
						clt.setTypCons(consultationmotif);
						clt.setNbCons(clt.getNbCons() + 1);
						serclt.modifierPatient(clt);
						initialisation();
						typeConsultation = "--selectionner--";
					}
				}

				if (action != null && action.equals("modif")) {
					cd.setIdConsultationDetail(idConsultationDetail);
					ser.modifierConsultationDetail(cd);
					if (msg.equals("")) {
						blocage = false;
						face.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "",
								"Consultation Modifiée Avec Succés"));

						clt.setPoids(poids);
						clt.setDateCons(dateConsultation);
						clt.setDdg(ddg);
						clt.setDdgCorigee(ddgCorigee);
						clt.setDdr(ddr);
						clt.settPrevu(termePrevu);
						clt.settActuel(termeActuel);
						clt.setToxo(toxo);
						clt.setTpha(tpha);
						clt.setRubeole(rubeole);
						clt.setDernierVisite(dateConsultation);

						serclt.modifierPatient(clt);
						initialisation();
						typeConsultation = "--selectionner--";

					}
				}
			}
		} else {
			if (action == null) {
				blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_FATAL, "",
						"Aucune action n'est détectée"));
			}
		}

	}

	public void validerConsultationGyneco() {

		// boolean testValid = true;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		String msg = "";
		FacesContext face = FacesContext.getCurrentInstance();

		if (poids != null && poids.trim().length() > 0)
			try {
				poids.replaceAll(",", ".");
				setPoids(poids.replaceAll(",", "."));
				Float.parseFloat(poids);
			} catch (Exception e) {
				face.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Veuillez vérifier le format du poids. Il ne peux pas contenir que des chiffres.",
								""));
				this.blocage = true;
				// poids = ancientPoids;
			}

		if (tas != null && tas.trim().length() > 0)
			try {
				tas.replaceAll(",", ".");
				Float.parseFloat(tas);
			} catch (Exception e) {
				face.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Veuillez vérifier le format du tas. Il ne peux pas contenir que des chiffres.",
								""));
				this.blocage = true;
				// tas = ancientTas;
			}
		if (tad != null && tad.trim().length() > 0)
			try {
				tad.replaceAll(",", ".");
				Float.parseFloat(tad);
			} catch (Exception e) {
				face.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Veuillez vérifier le format du tad. Il ne peux pas contenir que des chiffres.",
								""));
				this.blocage = true;
				// tad = ancientTad;
			}

		if (action != null) {
			if (action.equals("ajouter")) {
				ConsultationDetail cd = new ConsultationDetail();
				cd.setCfclient(clt);
				cd.setDdr(ddr);
				cd.setDdg(ddg);
				cd.setDdgCorigee(ddgCorigee);
				// poids = clt.getPoids();
				try {

					honoraire = Float.parseFloat(honorairestring);

				} catch (Exception e) {
					// testValid = false;
					msg = "L'honoraire ne contient que des chiffres";
					this.blocage = true;
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "", msg));

					ConsultaionService serf = new ConsultaionService();
					Consultation consf = serf
							.rechercheParConsultation(consultationmotif);
					honoraire = consf.getHonoraire();
					honorairestring = Double.toString(honoraire);
				}

				if (msg.equals("") && face.getMessageList().size() == 0) {
					cd.setTas(tas);
					cd.setHonoraire(honoraire);
					cd.setTad(tad);
					cd.setSeins(seins);
					cd.setPoids(poids);
					cd.setSpeculum(speculum);
					cd.setTv(tv);
					cd.setSymptome(symptome);
					cd.setExamen(examen);
					cd.setDiagnostique(diagnostique);
					try {
						cd.setDateConsultation(formatter
								.parse(dateConsultation));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					cd.setDateFrotti(dateFrotti);
					cd.setResultatFrotti(resultatFrotti);
					cd.setNotes(notes);
					cd.setCat(cat);
					ConsultaionService s = new ConsultaionService();
					consultation = s
							.rechercheParConsultation(consultationmotif);
					cd.setConsultation(consultation);
					ConsultationDetailService ser = new ConsultationDetailService();
					ser.ajouterConsultationDetail(cd);
					blocage = false;
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Consultation Ajoutée Avec Succés"));
					read = "noeditable";
					// mettre à jour les données du patient
					clt.setPoids(poids);
					clt.setDateCons(dateConsultation);
					clt.setDernierVisite(dateConsultation);
					clt.setResultatFrotti(resultatFrotti);
					clt.setDateFrotti(dateFrotti);
					clt.setTypCons(consultationmotif);
					clt.setNbCons(clt.getNbCons() + 1);
					serclt.modifierPatient(clt);
					action = null;
					selectedConsult = null;
					selectedCons = null;
					initialisation();
				}
			}

			if (action != null && action.equals("modifier")) {
				if (Module.corigerDate(dateConsultation) != null) {
					this.setDateConsultation(Module
							.corigerDate(dateConsultation));
				}
				if (!(Module.verifierDate(dateConsultation).equals("")))

				{
					blocage = true;
					face.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
									Module.verifierDate(dateconsultation1)));
				}
				if (face.getMessageList().size() == 0) {
					ConsultationDetailService se = new ConsultationDetailService();

					ConsultationDetail cd = se
							.rechercheConsultationDetail(idConsultationDetail);
					try {

						honoraire = Float.parseFloat(honorairestring);
						setHonoraire(honoraire);

					} catch (Exception e) {
						// testValid = false;
						this.blocage = true;
						msg = "L'honoraire ne contient que des chiffres";
						face.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR, "", msg));
						ConsultaionService serf = new ConsultaionService();
						Consultation consf = serf
								.rechercheParConsultation(consultationmotif);
						honoraire = consf.getHonoraire();
						honorairestring = Double.toString(honoraire);
					}

					cd.setHonoraire(honoraire);
					cd.setCfclient(clt);
					cd.setDdr(ddr);
					cd.setDdg(ddg);
					cd.setDdgCorigee(ddgCorigee);
					cd.setHonoraire(honoraire);
					cd.setPoids(poids);
					cd.setTas(tas);
					cd.setTad(tad);
					cd.setSeins(seins);
					cd.setSpeculum(speculum);
					cd.setTv(tv);
					cd.setSymptome(symptome);
					cd.setExamen(examen);
					cd.setDiagnostique(diagnostique);
					try {
						cd.setDateConsultation(formatter
								.parse(dateConsultation));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					cd.setDateFrotti(dateFrotti);
					cd.setResultatFrotti(resultatFrotti);
					try {
						cd.setDateConsultation(formatter
								.parse(dateConsultation));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					cd.setNotes(notes);
					cd.setCat(cat);
					ConsultaionService s = new ConsultaionService();
					consultation = s
							.rechercheParConsultation(consultationmotif);

					cd.setConsultation(consultation);

					se.modifierConsultationDetail(cd);
					this.blocage = false;
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Consultation Modifiée Avec Succés"));
					read = "noeditable";
					// mettre à jour les données du patient
					clt.setPoids(poids);
					clt.setDateCons(dateConsultation);
					clt.setDernierVisite(dateConsultation);
					serclt.modifierPatient(clt);
					action = null;
					initialisation();
					selectedConsult = null;
					selectedCons = null;

				}
			}

		} else if (action == null) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"", "Aucune action n'est détectée"));

		}
	}

	public void radioDetail(Integer idConsultationDetail) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", idConsultationDetail);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("DemandeRadio");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void analyseDetail(Integer idConsultationDetail) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", idConsultationDetail);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("DemandeAnalyse");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void selectedHisto(ConsultationDetail c) {
		if (c != null) {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("idConsultD", c.getIdConsultationDetail());

			// initialisation();

			this.setRead("noeditable");

			selectedCons = c;
			if (selectedCons != null) {
				desibledOrd = false;
				desibledAnalyse = false;
				desibledRadio = false;

			}

			// initialise(c);
			if (c.getConsultation().getNomConsultation().equals("C. Obst")) {
				consultationmotif = "C. Obst";
				initialiseCObs(c);
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Consultation_Obstetrique");
					selectedCons = c;
					if (selectedCons != null) {
						desibledOrd = false;
						desibledAnalyse = false;
						desibledRadio = false;

					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
			if (c.getConsultation().getNomConsultation().equals("C. Gyneco")) {
				consultationmotif = "C. Gyneco";
				initialiseCGyneco(c);
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Consultation-Gynecologique");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			if (c.getConsultation().getNomConsultation().equals("E. Obst")) {
				consultationmotif = "E. Obst";
				initialiseEObs(c);
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Echographie_Obstetricale");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			if (c.getConsultation().getNomConsultation().equals("E. Gyneco")) {
				consultationmotif = "E. Gyneco";

				initialiseEGyneco(c);
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Echographie-Gynecologique");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			initialiserConObs();
			initialisationEchoObs();
			initialisationechogyneco();
			initialisationConGyneco();
			selectedCons = c;
			if (selectedCons != null) {
				desibledOrd = false;
				desibledAnalyse = false;
				desibledRadio = false;

			}

			initialiseEGyneco(selectedCons);
			initialiseEObs(selectedCons);
			initialiseCGyneco(selectedCons);
			initialiseCObs(selectedCons);

		}
	}

	public void initialiseEGyneco(ConsultationDetail c) {
		indications = c.getIndications();
		contours = c.getContours();
		echostructure = c.getEchostructure();
		ligne = c.getLigne();
		annexes = c.getAnnexes();
		conclusion = c.getConclusion();
		longueur = c.getLongueur();
		larg = c.getLarg();
		diam = c.getDiam();
		if (idUterus != null) {
			idUterus = c.getUterus().getIduterus();
			nomUterus = c.getUterus().getUterus();
		}
		dateConsultation = formatter.format(c.getDateConsultation());
		honoraire = 8;
		idmodele = null;
		nommodele = null;
		selectedCons = c;
		read = "noeditable";

	}

	public void initialisationConGyneco() {
		ddr = null;
		ddg = null;
		ddgCorigee = false;
		honoraire = 0.0;
		honorairestring = "0.0";
		poids = null;
		tas = null;
		tad = null;

		seins = null;
		speculum = null;
		tv = null;
		symptome = null;
		examen = null;
		diagnostique = null;
		dateConsultation = null;
		dateFrotti = null;
		resultatFrotti = null;

		notes = null;
		cat = null;
		selectedCons = null;
		read = "noeditable";

	}

	public void initialiseEObs(ConsultationDetail c) {
		if (c != null) {
			ddr = c.getDdr();
			ddg = c.getDdg();
			ddgCorigee = c.isDdgCorigee();
			termeActuel = c.getCfclient().gettActuel();
			termePrevu = c.getCfclient().gettPrevu();
			echomoyen = c.getEchomoyen();
			trim = c.getTrim();
			if (trim == 1) {
				dateconsultation1 = formatter.format(c.getDateConsultation());
				sac = c.getSac();
				tonique = c.getTonique();
				conclusionobs = c.getConclusionobs();
				lcc = c.getLcc();
				bip = c.getBip();
				ac = c.getAc();
				ef = c.getEf();
				trophoblaste = c.getTrophoblaste();
				vesicule = c.getVesicule();
				annexesobs = c.getAnnexesobs();
				honorairesobs = c.getHonoraire();
				honoraireStringobs1 = Double.toString(honorairesobs);
				titreTrim = "Trim 1";

			}
			if (trim == 2) {
				dateconsultation2 = formatter.format(c.getDateConsultation());
				morphologie2 = c.getMorphologie();
				liq2 = c.getLiq();
				placenta2 = c.getPlacenta();
				conclusionobs2 = c.getConclusionobs();
				dat2 = c.getDat();
				ca2 = c.getCa();
				bip2 = c.getBip();
				femur2 = c.getFemur();
				ac2 = c.getAc();
				honorairesobs2 = c.getHonorairesobs();
				honoraireStringobs2 = Double.toString(honorairesobs2);
				mf2 = c.getMf();
				presentation2 = c.getPresentation();
				titreTrim = "Trim 2";
			}
			if (trim == 3) {
				dateconsultation3 = formatter.format(c.getDateConsultation());
				morphologie3 = c.getMorphologie();
				liq3 = c.getLiq();
				placenta3 = c.getPlacenta();
				conclusionobs3 = c.getConclusionobs();
				dat3 = c.getDat();
				ca3 = c.getCa();
				bip3 = c.getBip();
				femur3 = c.getFemur();
				ac3 = c.getAc();
				honorairesobs3 = c.getHonorairesobs();
				honoraireStringobs3 = Double.toString(honorairesobs3);
				mf3 = c.getMf();
				presentation3 = c.getPresentation();
				titreTrim = "Trim 3";
			}

		}
		selectedCons = c;
		read = "noeditable";
	}

	public void initialiseCGyneco(ConsultationDetail c) {
		ddr = c.getCfclient().getDdr();
		ddg = c.getCfclient().getDdg();
		honoraire = c.getHonoraire();
		honorairestring = Double.toString(honoraire);
		poids = c.getPoids();
		tas = c.getTas();
		tad = c.getTad();

		seins = c.getSeins();
		speculum = c.getSpeculum();
		tv = c.getTv();
		symptome = c.getSymptome();
		examen = c.getExamen();
		diagnostique = c.getDiagnostique();
		dateConsultation = formatter.format(c.getDateConsultation());
		dateFrotti = c.getDateFrotti();
		resultatFrotti = c.getResultatFrotti();

		notes = c.getNotes();
		cat = c.getCat();
		selectedCons = c;
		read = "noeditable";

	}

	public void initialiseCObs(ConsultationDetail c) {
		cfclient = c.getCfclient();
		idConsultationDetail = c.getIdConsultationDetail();
		dateConsultation = formatter.format(c.getDateConsultation());
		ddr = c.getDdr();
		ddg = c.getDdg();
		ddgCorigee = c.isDdgCorigee();
		dateConsultation = formatter.format(c.getDateConsultation());
		termePrevu = c.getTermePrevu();
		termeActuel = c.getTermeActuel();
		honoraire = c.getHonoraire();
		honorairestring = Double.toString(honoraire);
		toxo = c.getToxo();
		tpha = c.getTpha();
		rubeole = c.getRubeole();
		poids = c.getPoids();
		tas = c.getTas();
		tad = c.getTad();
		hu = c.getHu();
		sInf = c.getsInf();
		leuorhee = c.getLeuorhee();
		col = c.getCol();
		symptome = c.getSymptome();
		examen = c.getExamen();
		diagnostique = c.getDiagnostique();
		cat = c.getCat();
		notes = c.getNotes();
		speculum = c.getSpeculum();
		tv = c.getTv();
		seins = c.getSeins();
		dateFrotti = c.getDateFrotti();
		resultatFrotti = c.getResultatFrotti();

		selectedCons = c;
		if (c.isConsGrossType())
			typeConsultation = "Nouvelle";
		else
			typeConsultation = "Suivi";

	}

	public void initialise(ConsultationDetail c) {
		cfclient = c.getCfclient();
		idConsultationDetail = c.getIdConsultationDetail();
		dateConsultation = formatter.format(c.getDateConsultation());
		ddr = c.getDdr();
		ddg = c.getDdg();
		ddgCorigee = c.isDdgCorigee();
		dateConsultation = formatter.format(c.getDateConsultation());
		termePrevu = c.getTermePrevu();
		termeActuel = c.getTermeActuel();
		honoraire = c.getHonoraire();
		toxo = c.getToxo();
		tpha = c.getTpha();
		rubeole = c.getRubeole();
		poids = c.getPoids();
		tas = c.getTas();
		tad = c.getTad();
		hu = c.getHu();
		sInf = c.getsInf();
		leuorhee = c.getLeuorhee();
		col = c.getCol();
		symptome = c.getSymptome();
		examen = c.getExamen();
		diagnostique = c.getDiagnostique();
		cat = c.getCat();
		notes = c.getNotes();
		speculum = c.getSpeculum();
		tv = c.getTv();
		seins = c.getSeins();
		dateFrotti = c.getDateFrotti();
		resultatFrotti = c.getResultatFrotti();

	}

	public void initialisation() {
		desibledRadio = true;
		desibledAnalyse = true;
		desibledOrd = true;

		selectedCons = null;
		selectedConsult = null;
		ddr = null;
		action = null;
		ddg = null;
		ddgCorigee = false;
		termePrevu = null;
		termeActuel = null;
		// modif 10-06-2016
		// HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
		// .getExternalContext().getSession(false);
		// idPatient = (Integer) session.getAttribute("idu");
		// CfclientService serclt = new CfclientService();
		// Cfclient clt = serclt.RechercheCfclient(idPatient);
		//
		// Date actuelle = new Date();
		// // * Definition du format utilise pour les dates
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// dateConsultation = dateFormat.format(actuelle);
		// modif 10-06-2016
		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);
		// modif 10-06-2016
		honoraire = cons.getHonoraire();
		// modif 10-06-2016
		honorairestring = "0.0";
		action = null;
		// honorairestring = Double.toString(honoraire);
		toxo = null;
		tpha = null;
		rubeole = null;
		poids = "0.0";
		ancientPoids = poids;
		tas = null;
		ancientTas = tas;
		tad = null;
		ancientTad = tad;
		dateConsultation = null;
		hu = null;
		sInf = null;
		leuorhee = null;
		col = null;
		symptome = null;
		examen = null;
		// diagnostique = null;
		cat = null;
		notes = null;
		tv = null;
		speculum = null;
		seins = null;
		dateFrotti = null;
		resultatFrotti = null;
		selectedCons = null;
		ddgCorigee = false;
		consGrossType = false;
		read = "noeditable";
		ancienvaleurddr = null;
		ancienvaleurddg = null;
		diagnostique = null;
	}

	public void initialisationAnnuler() {
		desibledRadio = true;
		desibledAnalyse = true;
		desibledOrd = true;

		selectedCons = null;
		selectedConsult = null;
		ddr = null;
		ddg = null;
		ddgCorigee = false;
		termePrevu = null;
		termeActuel = null;
		honoraire = 0;
		toxo = null;
		tpha = null;
		action = null;
		rubeole = null;
		poids = null;
		ancientPoids = poids;
		tas = null;
		ancientTas = tas;
		tad = null;
		ancientTad = tad;
		hu = null;
		sInf = null;
		leuorhee = null;
		col = null;
		symptome = null;
		examen = null;
		diagnostique = null;
		cat = null;
		notes = null;
		tv = null;
		speculum = null;
		seins = null;
		dateFrotti = null;
		resultatFrotti = null;
		typeConsultation = "--selectionner--";
		dateConsultation = null;
		// Date actuelle = new Date();
		// // * Definition du format utilise pour les dates
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// dateConsultation = dateFormat.format(actuelle);

		consGrossType = false;
		read = "noeditable";
	}

	private boolean enModif = true;
	private boolean validModif;

	public boolean isValidModif() {
		return validModif;
	}

	public void setValidModif(boolean validModif) {
		this.validModif = validModif;
	}

	public boolean isEnModif() {
		return enModif;
	}

	public void setEnModif(boolean enModif) {
		this.enModif = enModif;
	}

	public void modif(ConsultationDetail cons) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", cons.getIdConsultationDetail());

		idConsultationDetail = cons.getIdConsultationDetail();
		dateConsultation = formatter.format(cons.getDateConsultation());
		dateFrotti = cons.getDateFrotti();
		resultatFrotti = cons.getResultatFrotti();
		ancienValeur = dateConsultation;
		ddr = cons.getDdr();
		ddg = cons.getDdg();
		termePrevu = cons.getTermePrevu();
		termeActuel = cons.getTermeActuel();
		honorairestring = Double.toString(cons.getHonoraire());
		toxo = cons.getToxo();
		tpha = cons.getTpha();
		rubeole = cons.getRubeole();
		poids = cons.getPoids();
		ancientPoids = poids;

		tas = cons.getTas();
		tad = cons.getTad();
		ancientTas = tas;
		ancientTad = tad;
		hu = cons.getHu();
		sInf = cons.getsInf();
		leuorhee = cons.getLeuorhee();
		col = cons.getCol();
		symptome = cons.getSymptome();
		examen = cons.getExamen();
		diagnostique = cons.getDiagnostique();
		seins = cons.getSeins();
		tv = cons.getTv();
		speculum = cons.getSpeculum();
		notes = cons.getNotes();
		cat = cons.getCat();
		read = "editable";
		action = "modifier";

	}

	public String validation() {

		ConsultationDetailService se = new ConsultationDetailService();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idConsultationDetail = (Integer) session.getAttribute("idConsultD");
		if (idConsultationDetail != null) {

			enModif = true;

			idConsultationDetail = (Integer) session.getAttribute("idConsultD");

			ConsultationDetail cd = se
					.rechercheConsultationDetail(idConsultationDetail);

			cd.setDdr(ddr);
			cd.setDdg(ddg);
			cd.setDdgCorigee(ddgCorigee);
			cd.setTermePrevu(termePrevu);
			cd.setTermeActuel(termeActuel);
			cd.setHonoraire(honoraire);
			cd.setToxo(toxo);
			cd.setTpha(tpha);
			cd.setRubeole(rubeole);

			cd.setPoids(poids);
			cd.setTas(tas);
			cd.setTad(tad);
			cd.setHu(hu);
			cd.setsInf(sInf);
			cd.setLeuorhee(leuorhee);
			cd.setCol(col);

			cd.setSymptome(symptome);
			cd.setExamen(examen);
			cd.setDiagnostique(diagnostique);

			se.modifierConsultationDetail(cd);
			validModif = true;
		}
		return null;
	}

	public int getTrim() {
		return trim;
	}

	public void setTrim(int trim) {
		this.trim = trim;
	}

	public double getBip() {
		return bip;
	}

	public void setBip(double bip) {
		this.bip = bip;
	}

	public double getLcc() {
		return lcc;
	}

	public void setLcc(double lcc) {
		this.lcc = lcc;
	}

	public double getSac() {
		return sac;
	}

	public void setSac(double sac) {
		this.sac = sac;
	}

	public String getTonique() {
		return tonique;
	}

	public void setTonique(String tonique) {
		this.tonique = tonique;
	}

	public String getEchomoyen() {
		return echomoyen;
	}

	public void setEchomoyen(String echomoyen) {
		this.echomoyen = echomoyen;
	}

	public String getConclusionobs() {
		return conclusionobs;
	}

	public void setConclusionobs(String conclusionobs) {
		this.conclusionobs = conclusionobs;
	}

	public String getAnnexesobs() {
		return annexesobs;
	}

	public void setAnnexesobs(String annexesobs) {
		this.annexesobs = annexesobs;
	}

	public String getVesicule() {
		return vesicule;
	}

	public void setVesicule(String vesicule) {
		this.vesicule = vesicule;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getMf2() {
		return mf2;
	}

	public void setMf2(String mf2) {
		this.mf2 = mf2;
	}

	public String getEf() {
		return ef;
	}

	public void setEf(String ef) {
		this.ef = ef;
	}

	public String getTrophoblaste() {
		return trophoblaste;
	}

	public void setTrophoblaste(String trophoblaste) {
		this.trophoblaste = trophoblaste;
	}

	public double getHonorairesobs() {
		return honorairesobs;
	}

	public void setHonorairesobs(double honorairesobs) {
		this.honorairesobs = honorairesobs;
	}

	/*
	 * public void setDiagnostiqueModif(boolean diagnostiqueModif) {
	 * this.diagnostiqueModif = diagnostiqueModif;
	 */

	public List<String> getToniques() {

		toniques.clear();
		toniques.add(new String("Bien tonique"));
		toniques.add(new String("Hypotonique"));

		return toniques;
	}

	public void setToniques(List<String> toniques) {
		this.toniques = toniques;
	}

	public String getTitreTrim() {
		// if(trim==1)
		titreTrim = "Trim 1";
		return titreTrim;
	}

	public void setTitreTrim(String titreTrim) {
		this.titreTrim = titreTrim;
	}

	public int getIndexTbView() {

		return indexTbView;
	}

	public void setIndexTbView(int indexTbView) {
		this.indexTbView = indexTbView;
	}

	// methode echo obs

	public double getBip2() {
		return bip2;
	}

	public void setBip2(double bip2) {
		this.bip2 = bip2;
	}

	public double getBip3() {
		return bip3;
	}

	public void setBip3(double bip3) {
		this.bip3 = bip3;
	}

	public double getFemur3() {
		return femur3;
	}

	public void setFemur3(double femur3) {
		this.femur3 = femur3;
	}

	public double getDat3() {
		return dat3;
	}

	public void setDat3(double dat3) {
		this.dat3 = dat3;
	}

	public double getCa3() {
		return ca3;
	}

	public void setCa3(double ca3) {
		this.ca3 = ca3;
	}

	public double getFemur2() {
		return femur2;
	}

	public void setFemur2(double femur2) {
		this.femur2 = femur2;
	}

	public double getDat2() {
		return dat2;
	}

	public void setDat2(double dat2) {
		this.dat2 = dat2;
	}

	public double getCa2() {
		return ca2;
	}

	public void setCa2(double ca2) {
		this.ca2 = ca2;
	}

	public String getMorphologie2() {
		return morphologie2;
	}

	public void setMorphologie2(String morphologie2) {
		this.morphologie2 = morphologie2;
	}

	public String getPresentation2() {
		return presentation2;
	}

	public void setPresentation2(String presentation2) {
		this.presentation2 = presentation2;
	}

	public String getPlacenta2() {
		return placenta2;
	}

	public void setPlacenta2(String placenta2) {
		this.placenta2 = placenta2;
	}

	public String getLiq2() {
		return liq2;
	}

	public void setLiq2(String liq2) {
		this.liq2 = liq2;
	}

	public String getDateconsultation1() {

		return dateconsultation1;
	}

	public void setDateconsultation1(String dateconsultation1) {

		this.dateconsultation1 = dateconsultation1;
	}

	public String getDateconsultation2() {

		return dateconsultation2;
	}

	public void setDateconsultation2(String dateconsultation2) {

		this.dateconsultation2 = dateconsultation2;
	}

	public String getDateconsultation3() {

		return dateconsultation3;
	}

	public void setDateconsultation3(String dateconsultation3) {

		this.dateconsultation3 = dateconsultation3;
	}

	public String getMorphologie3() {
		return morphologie3;
	}

	public void setMorphologie3(String morphologie3) {
		this.morphologie3 = morphologie3;
	}

	public String getConclusionobs2() {
		return conclusionobs2;
	}

	public void setConclusionobs2(String conclusionobs2) {
		this.conclusionobs2 = conclusionobs2;
	}

	public String getConclusionobs3() {
		return conclusionobs3;
	}

	public void setConclusionobs3(String conclusionobs3) {
		this.conclusionobs3 = conclusionobs3;
	}

	public String getPresentation3() {
		return presentation3;
	}

	public void setPresentation3(String presentation3) {
		this.presentation3 = presentation3;
	}

	public String getAc2() {
		return ac2;
	}

	public void setAc2(String ac2) {
		this.ac2 = ac2;
	}

	public String getAc3() {
		return ac3;
	}

	public void setAc3(String ac3) {
		this.ac3 = ac3;
	}

	public String getMf3() {
		return mf3;
	}

	public void setMf3(String mf3) {
		this.mf3 = mf3;
	}

	public String getPlacenta3() {
		return placenta3;
	}

	public void setPlacenta3(String placenta3) {
		this.placenta3 = placenta3;
	}

	public String getLiq3() {
		return liq3;
	}

	public void setLiq3(String liq3) {
		this.liq3 = liq3;
	}

	public double getHonorairesobs2() {
		honorairestring = Double.toString(honorairesobs2);
		return honorairesobs2;
	}

	public void setHonorairesobs2(double honorairesobs2) {
		honoraireStringobs2 = Double.toString(honorairesobs2);
		this.honorairesobs2 = honorairesobs2;
	}

	public double getHonorairesobs3() {
		return honorairesobs3;
	}

	public void setHonorairesobs3(double honorairesobs3) {
		honoraireStringobs3 = Double.toString(honorairesobs3);
		this.honorairesobs3 = honorairesobs3;
	}

	public void onTabChange(TabChangeEvent event) {

		if ((event.getTab().getTitle().equals("Trim 1"))) {
			this.trim = 1;

		} else if ((event.getTab().getTitle().equals("Trim 2"))) {
			this.trim = 2;
		} else if ((event.getTab().getTitle().equals("Trim 3"))) {
			this.trim = 3;
		}

	}

	public void initialisationEchoObs() {
		
		afficheImprEchoObs = true;
		afficheValidEchoObs = true;
		ddr = null;
		ddg = null;
		termeActuel = null;
		termePrevu = null;
		bip = 0.0;
		bip2 = 0.0;
		bip3 = 0.0;
		femur2 = 0.0;
		femur3 = 0.0;
		dat2 = 0.0;
		ca2 = 0.0;
		dat3 = 0.0;
		ca3 = 0.0;
		lcc = 0.0;
		sac = 0.0;
		action = null;
		tonique = null;
		echomoyen = null;
		morphologie2 = null;
		morphologie3 = null;
		conclusionobs = null;
		conclusionobs2 = null;
		conclusionobs3 = null;
		annexesobs = null;
		presentation2 = null;
		presentation3 = null;
		vesicule = null;
		action = null;
		ac = null;
		ac2 = null;
		ac3 = null;
		mf2 = null;
		mf3 = null;
		ef = null;
		placenta2 = null;
		liq2 = null;
		placenta3 = null;
		liq3 = null;
		trophoblaste = null;
		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);
		if (cons != null) {
			honorairesobs = 0.0;
			honorairesobs2 = 0.0;
			honorairesobs3 = 0.0;

			honoraireStringobs1 = "0.0";
			honoraireStringobs2 = "0.0";
			honoraireStringobs3 = "0.0";
		}
		titreTrim = null;
		dateconsultation1 = null;
		dateconsultation2 = null;
		dateconsultation3 = null;
		read = "noeditable";
	}

	public void validerConsEchoObs() {

		String msg = "";
		FacesContext face = FacesContext.getCurrentInstance();
		ConsultationDetailService ser = new ConsultationDetailService();
		CfclientService serclt = new CfclientService();
		ConsultationDetail cons = null;
		if (action != null) {
			if (trim == 1) {
				if (action != null) {
					if (action.equals("ajouter")) {
						if (echomoyen == null
								|| (echomoyen.trim().length() == 0)) {
							blocage = true;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Erreur",
									"Veuillez saisir l'echo moyen"));

						}
						if (Module.corigerDate(dateconsultation1) != null) {
							this.setDateconsultation1(Module
									.corigerDate(dateconsultation1));
						}
						if (!(Module.verifierDate(dateconsultation1).equals("")))

						{
							this.blocage = true;
							face.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_ERROR,
											"",
											Module.verifierDate(dateconsultation1)));

							dateconsultation1 = ancienValeur1;
						}

						else if (face.getMessageList().size() == 0)

						{
							cons = new ConsultationDetail();
							if (consultationmotif != null) {
								ConsultaionService s = new ConsultaionService();
								consultation = s
										.rechercheParConsultation(consultationmotif);
								cons.setConsultation(consultation);
							}
							HttpSession session = (HttpSession) FacesContext
									.getCurrentInstance().getExternalContext()
									.getSession(false);
							idPatient = (Integer) session.getAttribute("idu");

							// idPatient = Module.idpatient;
							if (idPatient != null) {
								Cfclient c = serclt
										.RechercheCfclient(idPatient);
								c.setDernierVisite(dateconsultation1);
								c.setTypCons(consultationmotif);
								c.setNbCons(c.getNbCons() + 1);
								serclt.modifierPatient(c);
								cons.setCfclient(c);
							}
							try {
								cons.setDateConsultation(formatter
										.parse(dateconsultation1));
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							cons.setTrim(trim);
							cons.setEchomoyen(echomoyen);
							cons.setSac(sac);
							cons.setTonique(tonique);
							cons.setConclusionobs(conclusionobs);
							cons.setLcc(lcc);
							cons.setBip(bip);
							cons.setAc(ac);
							cons.setEf(ef);
							cons.setTrophoblaste(trophoblaste);
							cons.setVesicule(vesicule);
							cons.setAnnexesobs(annexesobs);
							try {

								honorairesobs = Float
										.parseFloat(honoraireStringobs1);
								setHonoraire(honorairesobs);

							} catch (Exception e) {
								honorairesobs = (float) 0;
								msg = msg
										+ "L'honoraire ne contient que des chiffres";
								ConsultaionService serf = new ConsultaionService();
								Consultation consf = serf
										.rechercheParConsultation(consultationmotif);
								honoraire = consf.getHonoraire();
								honoraireStringobs1 = Double
										.toString(honorairesobs);
							}
							cons.setHonoraire(honorairesobs);

							cons.setConsultation(consultation);
							cons.setDdr(ddr);
							cons.setDdg(ddg);
							cons.setDdgCorigee(ddgCorigee);
							cons.setTermePrevu(termePrevu);
							cons.setTermeActuel(termeActuel);
							ser.ajouterConsultationDetail(cons);
							this.blocage = false;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO, "",
									"Consultation Ajoutée Avec Succés"));
							tempsface = 3500;
							action = null;
							initialisationEchoObs();
							afficheImprEchoObs = false;
							afficheValidEchoObs = true;
							selectedCons = cons;

						}
					}

					else if (action.equals("modifier")) {
						if (echomoyen == null
								|| (echomoyen.trim().length() == 0)) {
							blocage = true;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Erreur",
									"Veuillez saisir l'echo moyen"));

						}
						if (Module.corigerDate(dateconsultation1) != null) {
							this.setDateconsultation1(Module
									.corigerDate(dateconsultation1));
						}
						if (!(Module.verifierDate(dateconsultation1).equals("")))

						{
							blocage = true;
							face.addMessage(
									null,
									new FacesMessage(Module
											.verifierDate(dateconsultation1)));
							dateconsultation1 = ancienValeur1;
						}

						else if (face.getMessageList().size() == 0)

						{
							ConsultationDetailService se = new ConsultationDetailService();

							cons = se
									.rechercheConsultationDetail(idConsultationDetail);

							ConsultaionService s = new ConsultaionService();
							consultation = s
									.rechercheParConsultation(consultationmotif);
							HttpSession session = (HttpSession) FacesContext
									.getCurrentInstance().getExternalContext()
									.getSession(false);
							idPatient = (Integer) session.getAttribute("idu");
							// idPatient = Module.idpatient;
							Cfclient c = serclt.RechercheCfclient(idPatient);
							try {
								cons.setDateConsultation(formatter
										.parse(dateconsultation1));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							cons.setCfclient(c);
							cons.setSac(sac);
							cons.setTonique(tonique);
							cons.setConclusionobs(conclusionobs);
							cons.setLcc(lcc);
							cons.setBip(bip);
							cons.setAc(ac);
							cons.setEchomoyen(echomoyen);
							cons.setEf(ef);
							cons.setTrophoblaste(trophoblaste);
							cons.setVesicule(vesicule);
							cons.setAnnexesobs(annexesobs);
							cons.setDdr(ddr);
							cons.setDdg(ddg);
							cons.setDdgCorigee(ddgCorigee);
							cons.setTermePrevu(termePrevu);
							cons.setTermeActuel(termeActuel);

							cons.setHonoraire(honorairesobs);
							cons.setConsultation(consultation);
							se.modifierConsultationDetail(cons);
							this.blocage = false;
							tempsface = 3500;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO, "",
									"Consultation Modifiée  Avec Succés"));

							initialisationEchoObs();
							afficheImprEchoObs = false;
							afficheValidEchoObs = true;
							selectedCons = cons;
						}
					}
				}

			}
			if (trim == 3) {
				if (action != null) {
					if (action.equals("ajouter")) {
						if (echomoyen == null
								|| (echomoyen.trim().length() == 0)) {
							blocage = true;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Erreur",
									"Veuillez saisir l'echo moyen"));

						}
						if (Module.corigerDate(dateconsultation3) != null) {
							this.setDateconsultation3(Module
									.corigerDate(dateconsultation3));
						}
						if (!(Module.verifierDate(dateconsultation3).equals("")))

						{
							tempsface = 3500;
							face.addMessage(null, new FacesMessage("Erreur",
									Module.verifierDate(dateconsultation3)));
							dateconsultation3 = ancienValeur3;
						}

						else if (face.getMessageList().size() == 0)

						{
							cons = new ConsultationDetail();
							if (consultationmotif != null) {
								ConsultaionService s = new ConsultaionService();
								consultation = s
										.rechercheParConsultation(consultationmotif);
								cons.setConsultation(consultation);
							}
							HttpSession session = (HttpSession) FacesContext
									.getCurrentInstance().getExternalContext()
									.getSession(false);
							idPatient = (Integer) session.getAttribute("idu");
							// idPatient = Module.idpatient;
							if (idPatient != null) {
								Cfclient c = serclt
										.RechercheCfclient(idPatient);
								c.setDernierVisite(dateconsultation3);
								c.setTypCons(consultationmotif);
								c.setNbCons(c.getNbCons() + 1);
								serclt.modifierPatient(c);
								cons.setCfclient(c);
							}
							try {
								cons.setDateConsultation(formatter
										.parse(dateconsultation3));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							cons.setTrim(trim);
							cons.setMorphologie(morphologie3);
							cons.setLiq(liq3);
							cons.setPlacenta(placenta3);
							cons.setConclusionobs(conclusionobs3);
							cons.setDat(dat3);
							cons.setCa(ca3);
							cons.setBip(bip3);
							cons.setFemur(femur3);
							cons.setHonoraire(honorairesobs3);
							cons.setAc(ac3);
							cons.setMf(mf3);
							cons.setEchomoyen(echomoyen);
							cons.setPresentation(presentation3);
							cons.setConclusionobs(conclusionobs3);
							cons.setDdr(ddr);
							cons.setDdg(ddg);
							cons.setDdgCorigee(ddgCorigee);
							cons.setTermePrevu(termePrevu);
							cons.setTermeActuel(termeActuel);

							cons.setConsultation(consultation);
							ser.ajouterConsultationDetail(cons);
							this.blocage = false;
							tempsface = 3500;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO, "",
									"Consultation Ajoutée Avec Succés"));
							initialisationEchoObs();
							afficheImprEchoObs = false;
							afficheValidEchoObs = true;
							selectedCons = cons;
							action = null;

						}
					}

					else if (action.equals("modifier")) {
						if (echomoyen == null
								|| (echomoyen.trim().length() == 0)) {
							blocage = true;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Erreur",
									"Veuillez saisir l'echo moyen "));

						}
						if (Module.corigerDate(dateconsultation3) != null) {
							this.setDateconsultation3(Module
									.corigerDate(dateconsultation3));
						}
						if (!(Module.verifierDate(dateconsultation3).equals(""))) {
							blocage = true;
							face.addMessage(
									null,
									new FacesMessage(Module
											.verifierDate(dateconsultation3)));
							dateconsultation3 = ancienValeur3;
						}

						else if (face.getMessageList().size() == 0)

						{
							ConsultationDetailService se = new ConsultationDetailService();

							cons = se
									.rechercheConsultationDetail(idConsultationDetail);

							ConsultaionService s = new ConsultaionService();
							consultation = s
									.rechercheParConsultation(consultationmotif);

							HttpSession session = (HttpSession) FacesContext
									.getCurrentInstance().getExternalContext()
									.getSession(false);
							idPatient = (Integer) session.getAttribute("idu");
							// idPatient = Module.idpatient;
							Cfclient c = serclt.RechercheCfclient(idPatient);
							cons.setCfclient(c);
							try {
								cons.setDateConsultation(formatter
										.parse(dateconsultation3));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							cons.setTrim(trim);
							cons.setMorphologie(morphologie3);
							cons.setLiq(liq3);
							cons.setPlacenta(placenta3);
							cons.setConclusionobs(conclusionobs3);
							cons.setDdr(ddr);
							cons.setDdg(ddg);
							cons.setDdgCorigee(ddgCorigee);
							cons.setTermePrevu(termePrevu);
							cons.setTermeActuel(termeActuel);

							cons.setDat(dat3);
							cons.setCa(ca3);
							cons.setEchomoyen(echomoyen);
							cons.setBip(bip3);
							cons.setHonoraire(honorairesobs3);
							cons.setFemur(femur3);
							cons.setAc(ac3);
							cons.setMf(mf3);
							cons.setPresentation(presentation3);
							cons.setConclusionobs(conclusionobs3);
							cons.setConsultation(consultation);
							se.modifierConsultationDetail(cons);
							this.blocage = false;
							tempsface = 3500;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO, "",
									"Consultation modifiée avec Succès"));
							afficheImprEchoObs = false;
							afficheValidEchoObs = true;
							selectedCons = cons;
							initialisationEchoObs();
						}
					}
				}

			}

			if (trim == 2) {
				if (action != null) {
					if (action.equals("ajouter")) {
						if (echomoyen == null
								|| (echomoyen.trim().length() == 0)) {
							blocage = true;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Erreur",
									"Veuillez remplir l'echo vide"));

						}
						if (Module.corigerDate(dateconsultation2) != null) {
							this.setDateconsultation2(Module
									.corigerDate(dateconsultation2));
						}
						if (!(Module.verifierDate(dateconsultation2).equals("")))

						{
							this.blocage = true;
							face.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_ERROR,
											"",
											Module.verifierDate(dateconsultation2)));
							tempsface = 3500;
							dateconsultation2 = ancienValeur2;
						}

						else if (face.getMessageList().size() == 0)

						{
							cons = new ConsultationDetail();
							if (consultationmotif != null) {
								ConsultaionService s = new ConsultaionService();
								consultation = s
										.rechercheParConsultation(consultationmotif);
								cons.setConsultation(consultation);
							}
							HttpSession session = (HttpSession) FacesContext
									.getCurrentInstance().getExternalContext()
									.getSession(false);
							idPatient = (Integer) session.getAttribute("idu");

							// idPatient = Module.idpatient;
							if (idPatient != null) {
								Cfclient c = serclt
										.RechercheCfclient(idPatient);
								c.setDernierVisite(dateConsultation);
								c.setTypCons(consultationmotif);
								c.setNbCons(c.getNbCons() + 1);
								serclt.modifierPatient(c);
								cons.setCfclient(c);
							}
							try {
								cons.setDateConsultation(formatter
										.parse(dateconsultation2));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							cons.setTrim(trim);
							cons.setMorphologie(morphologie2);
							cons.setHonoraire(honorairesobs2);
							cons.setLiq(liq2);
							cons.setPlacenta(placenta2);
							cons.setEchomoyen(echomoyen);
							cons.setConclusionobs(conclusionobs2);
							cons.setDat(dat2);
							cons.setCa(ca2);
							cons.setBip(bip2);
							cons.setFemur(femur2);
							cons.setAc(ac2);
							cons.setMf(mf2);
							cons.setPresentation(presentation2);
							cons.setDdr(ddr);
							cons.setDdg(ddg);
							cons.setDdgCorigee(ddgCorigee);
							cons.setTermePrevu(termePrevu);
							cons.setTermeActuel(termeActuel);

							cons.setConclusionobs(conclusionobs2);
							cons.setConsultation(consultation);
							ser.ajouterConsultationDetail(cons);
							this.blocage = false;
							tempsface = 3500;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO, "",
									"Consultation ajoutée avec succés"));
							action = null;
							initialisationEchoObs();
							afficheImprEchoObs = false;
							afficheValidEchoObs = true;
							selectedCons = cons;

						}
					}

					else if (action.equals("modifier")) {
						if (echomoyen == null
								|| (echomoyen.trim().length() == 0)) {
							blocage = true;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Erreur",
									"Veuillez remplir l' echo moyen "));

						}
						if (Module.corigerDate(dateconsultation2) != null) {
							this.setDateconsultation2(Module
									.corigerDate(dateconsultation2));
						}
						if (!(Module.verifierDate(dateconsultation2).equals("")))

						{
							this.blocage = true;
							face.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_ERROR,
											"",
											Module.verifierDate(dateconsultation2)));
							tempsface = 3500;
							dateconsultation2 = ancienValeur2;
						} else if (face.getMessageList().size() == 0)

						{
							ConsultationDetailService se = new ConsultationDetailService();

							cons = se
									.rechercheConsultationDetail(idConsultationDetail);

							ConsultaionService s = new ConsultaionService();
							consultation = s
									.rechercheParConsultation(consultationmotif);

							HttpSession session = (HttpSession) FacesContext
									.getCurrentInstance().getExternalContext()
									.getSession(false);
							idPatient = (Integer) session.getAttribute("idu");
							// idPatient = Module.idpatient;
							Cfclient c = serclt.RechercheCfclient(idPatient);
							cons.setCfclient(c);
							try {
								cons.setDateConsultation(formatter
										.parse(dateconsultation2));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							cons.setTrim(trim);
							cons.setMorphologie(morphologie2);
							cons.setLiq(liq2);
							cons.setPlacenta(placenta2);
							cons.setConclusionobs(conclusionobs2);
							cons.setDat(dat2);
							cons.setEchomoyen(echomoyen);
							cons.setCa(ca2);
							cons.setBip(bip2);
							cons.setFemur(femur2);
							cons.setDdr(ddr);
							cons.setDdg(ddg);
							cons.setDdgCorigee(ddgCorigee);
							cons.setTermePrevu(termePrevu);
							cons.setTermeActuel(termeActuel);

							cons.setAc(ac2);
							cons.setMf(mf2);
							cons.setHonoraire(honorairesobs2);
							cons.setPresentation(presentation2);
							cons.setConclusionobs(conclusionobs2);
							cons.setConsultation(consultation);
							se.modifierConsultationDetail(cons);
							this.blocage = false;
							tempsface = 3500;
							face.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO, "",
									"Consultation modifiée avec Succès"));
							initialisationEchoObs();
							afficheImprEchoObs = false;
							afficheValidEchoObs = true;
							selectedCons = cons;
							CfclientService serclt1 = new CfclientService();
							Cfclient clt = new Cfclient();
							clt = serclt1.RechercheCfclient(idPatient);
							ddr = clt.getDdr();
							ddg = clt.getDdg();
							termeActuel = clt.gettActuel();
							termePrevu = clt.gettPrevu();

						}
					}
				}
			}
		} else if (action == null) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"", "Aucune action n'est détectée"));
		}

	}

	public int getTempsgrowlconsechogyn() {
		return tempsgrowlconsechogyn;
	}

	public void setTempsgrowlconsechogyn(int tempsgrowlconsechogyn) {
		this.tempsgrowlconsechogyn = tempsgrowlconsechogyn;
	}

	public boolean isBlocage() {

		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}

	public String getNommodele() {
		return nommodele;
	}

	public void setNommodele(String nommodele) {
		this.nommodele = nommodele;
	}

	public Integer getIdmodele() {
		return idmodele;
	}

	public void setIdmodele(Integer idmodele) {
		this.idmodele = idmodele;
	}

	public String getAnnexesModele() {
		return annexesModele;
	}

	public void setAnnexesModele(String annexesModele) {
		this.annexesModele = annexesModele;
	}

	public String getContoursModele() {
		return contoursModele;
	}

	public void setContoursModele(String contoursModele) {
		this.contoursModele = contoursModele;
	}

	public String getEchostructureModele() {
		return echostructureModele;
	}

	public void setEchostructureModele(String echostructureModele) {
		this.echostructureModele = echostructureModele;
	}

	public Uterus getUterusModele() {
		return uterusModele;
	}

	public void setUterusModele(Uterus uterusModele) {
		this.uterusModele = uterusModele;
	}

	public Date StringToDate(String datestr) {

		Date date = null;
		try {

			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (Date) formatter.parse(datestr);
		} catch (Exception e) {
		}
		return (date);
	}

	public static Calendar DateToCalendar(Date date) {
		Calendar cal = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (Date) formatter.parse(date.toString());

			// cal.setTime(date);
		} catch (ParseException e) {
		}
		return cal;
	}

	public void calculDateInverse() {
		// System.out.println("entree methode calculdate inverse");
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		FacesContext face = FacesContext.getCurrentInstance();
		ancienValeurDDG = clt.getDdg();
		if (ddg.equals(ancienValeurDDG) == false) {

			if (Module.corigerDate(ddg) != null) {
				this.setDdg(Module.corigerDate(ddg));
			}
			if (!(Module.verifierDate(ddg).equals("")))

			{
				this.blocage = true;
				face.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								Module.verifierDate(ddg)));
				ddg = ancienvaleurddg;

			}

			else if (face.getMessageList().size() == 0)
				try {

					ancienvaleurddg = ddg;
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dateddg = sdf.parse(ddg);

					Calendar cale = Calendar.getInstance();
					cale.setTime(dateddg);
					cale.add(Calendar.DATE, -14);
					ddr = sdf.format(cale.getTime());

					Date dateddr1 = sdf.parse(ddr);
					Date dateddr = dateddr1;
					Calendar cale1 = Calendar.getInstance();
					cale1.setTime(dateddr1);
					cale1.add(Calendar.DATE, 280);

					termePrevu = sdf.format(cale1.getTime());

					Date dateJour = sdf.parse(dateConsultation);
					String terme = sdf.format(dateJour);
					long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;

					Date date4 = sdf.parse(terme);

					long diff = Math.abs(dateddr.getTime() - date4.getTime());
					long numberOfDay = (long) diff / CONST_DURATION_OF_DAY;

					int semaine = (int) (numberOfDay / 7);
					int jourr = (int) (numberOfDay % 7);

					termeActuel = semaine + "s" + jourr + "j";
					ddgCorigee = true;
				} catch (Exception e) {
					e.getMessage();
					blocage = true;
					face.addMessage(null, new FacesMessage("erreur",
							"Date Invalide"));
				}

		}

	}

	public void calculDate() {
		// System.out.println("entree la methode calcul date ddr");
		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(ddr) != null) {
			this.setDdr(Module.corigerDate(ddr));
		}
		if (!(Module.verifierDate(ddr).equals("")))

		{
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(ddr)));
			ddr = ancienvaleurddr;

		}

		else if (face.getMessageList().size() == 0)
			try {

				ancienvaleurddr = ddr;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dateddr = sdf.parse(ddr);

				Calendar cale = Calendar.getInstance();
				cale.setTime(dateddr);
				cale.add(Calendar.DATE, 14);
				ddg = sdf.format(cale.getTime());
				ancienValeurDDG = ddg;
				Date dateddr1 = sdf.parse(ddr);
				Calendar cale1 = Calendar.getInstance();
				cale1.setTime(dateddr1);
				cale1.add(Calendar.DATE, 280);

				termePrevu = sdf.format(cale1.getTime());

				Date dateJour = sdf.parse(dateConsultation);
				String terme = sdf.format(dateJour);
				long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;

				Date date4 = sdf.parse(terme);

				long diff = Math.abs(dateddr.getTime() - date4.getTime());
				long numberOfDay = (long) diff / CONST_DURATION_OF_DAY;

				int semaine = (int) (numberOfDay / 7);
				int jourr = (int) (numberOfDay % 7);

				termeActuel = semaine + "s" + jourr + "j";
			} catch (Exception e) {
				e.getMessage();
				blocage = true;
				face.addMessage(null, new FacesMessage("erreur",
						"Date Invalide"));
			}
	}

	public void verifierDate() {

		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(dateConsultation) != null) {
			this.setDateConsultation(Module.corigerDate(dateConsultation));
		}
		if (!(Module.verifierDate(dateConsultation).equals("")))

		{
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateConsultation)));
			dateConsultation = ancienValeur;
		} else {
			ancienValeur = dateConsultation;
		}

		if (ddr != null && ddr.length() > 0)

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dateJour = sdf.parse(dateConsultation);
				String terme = sdf.format(dateJour);
				long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;

				Date date4;

				date4 = sdf.parse(terme);

				Date dateddr = sdf.parse(ddr);
				long diff = Math.abs(dateddr.getTime() - date4.getTime());
				long numberOfDay = (long) diff / CONST_DURATION_OF_DAY;

				int semaine = (int) (numberOfDay / 7);
				int jourr = (int) (numberOfDay % 7);

				termeActuel = semaine + "s" + jourr + "j";
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}

	public void verifierDate1() {
		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(dateconsultation1) != null) {
			this.setDateconsultation1(Module.corigerDate(dateconsultation1));
		}
		if (!(Module.verifierDate(dateconsultation1).equals("")))

		{
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateconsultation1)));
			dateconsultation1 = ancienValeur1;
		} else {
			ancienValeur1 = dateconsultation1;
		}

	}

	public void verifierDate2() {
		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(dateconsultation2) != null) {
			this.setDateconsultation1(Module.corigerDate(dateconsultation2));
		}
		if (!(Module.verifierDate(dateconsultation2).equals("")))

		{
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateconsultation2)));
			dateconsultation2 = ancienValeur2;
		} else {
			ancienValeur2 = dateconsultation2;
		}

	}

	public void verifierDate3() {
		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(dateconsultation3) != null) {
			this.setDateconsultation3(Module.corigerDate(dateconsultation3));
		}
		if (!(Module.verifierDate(dateconsultation3).equals("")))

		{
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateconsultation3)));
			dateconsultation3 = ancienValeur3;
		} else {
			ancienValeur3 = dateconsultation3;
		}

	}

	public int getTempsface() {
		return tempsface;
	}

	public void setTempsface(int tempsface) {
		this.tempsface = tempsface;
	}

	public String getAncienValeur() {

		return ancienValeur;
	}

	public void setAncienValeur(String ancienValeur) {
		this.ancienValeur = ancienValeur;
	}

	public String getAncienValeur1() {
		return ancienValeur1;
	}

	public void setAncienValeur1(String ancienValeur1) {
		this.ancienValeur1 = ancienValeur1;
	}

	public String getAncienValeur2() {
		return ancienValeur2;
	}

	public void setAncienValeur2(String ancienValeur2) {
		this.ancienValeur2 = ancienValeur2;
	}

	public String getAncienValeur3() {
		return ancienValeur3;
	}

	public void setAncienValeur3(String ancienValeur3) {
		this.ancienValeur3 = ancienValeur3;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	/*
	 * public void verifierLongeur() { int numMembre=0; FacesContext face =
	 * FacesContext.getCurrentInstance();
	 * 
	 * try { int tmp = Integer.parseInt(longueur.toString());
	 * 
	 * 
	 * numMembre = tmp; //strNumMembre = tmp.toString; } catch
	 * (NumberFormatException e) { blocage=true; face.addMessage(null, new
	 * FacesMessage("Erreur","Longeur Invalide" )); } }
	 */
	public void changeRead() {
		FacesContext face = FacesContext.getCurrentInstance();
		if (action == null) {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			idPatient = (Integer) session.getAttribute("idu");
			// idPatient = Module.idpatient;
			initialisationEchoObs();
			initialisationechogyneco();
			initialiserConObs();
			initialisation();
			consultationDetails.clear();
			dateConsultation = null;
			dateconsultation1 = null;
			dateconsultation2 = null;
			dateconsultation3 = null;
			selectedConsult = null;
			selectedCons = null;
			contours = "--selectionner--";
			echostructure = "--selectionner--";
			typeConsultation = "--selectionner--";
			this.setRead("noeditable");
			if (consultationmotif.equals("Générale"))
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Patients");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			else
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("FichePatiente");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			selectedCons = null;
			selectedConsult = null;

			typeConsultation = "--selectionner--";
			consultationmotif = null;
			// action = null;
			// return "../pages/FichePatient.xhtml";
		} else {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"",
					"Veuillez enrégistrer les modifications du consultation"));

		}
	}

	public void ajoutConsGynecologie() {
		poids = null;
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		poids = clt.getPoids();
		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);
		honoraire = cons.getHonoraire();
		honorairestring = Double.toString(honoraire);
		tas = null;
		tad = null;
		tv = null;
		dateFrotti = null;
		resultatFrotti = null;
		speculum = null;
		notes = null;

		cat = null;
		seins = null;
		symptome = null;
		examen = null;
		diagnostique = null;
		Date actuelle = new Date();
		// * Definition du format utilise pour les dates
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.dateConsultation = dateFormat.format(actuelle);
		ancienValeur = dateFormat.format(actuelle);
		action = "ajouter";

		read = "editable";

	}

	public void supprimerConsultationGyneco(ConsultationDetail cons) {

		FacesContext face = FacesContext.getCurrentInstance();
		String chAnalyse = "";
		String chRadio = "";
		String chOrdonnace = "";
		if (cons != null) {

			// recherche si nous avons analyse pour cette consultation
			ConsultationDetailService ser = new ConsultationDetailService();
			if (cons.getAnalyse() != null) {
				chAnalyse = "" + "Elle contient une Analyse lieé ";
				this.erreur = true;

			}

			// recherche si nous avons radio pour cette consultation
			if (cons.getRadio() != null) {
				chRadio = "" + " Elle contient un Radio lieé ";
				this.erreur = true;

			}

			// recherche si nous avons ordonnance pour cette consultation
			OrdonnanceService serord = new OrdonnanceService();
			List<Ordonnance> listeord = null;
			listeord = serord
					.rechercheOrdonnanceParConsultation(idConsultationDetail);

			if ((listeord.size() != 0)) {
				chOrdonnace = "" + "Elle contient une Ordannace lieé ";
				this.erreur = true;
			}

			if (this.erreur == true) {
				this.blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Impossible de supprimer cette consultation", chAnalyse
								+ chRadio + chOrdonnace));
				this.erreur = false;
			}

			if ((face.getMessageList().size() == 0) && (this.erreur == false)) {
				String motif = "";
				if (cons.isConsGrossType()) {// c'est une nouvelle grossesse -->
												// Gest-1
					motif = "nvGross";

				}
				ser.supprimerConsultationDetail(cons.getIdConsultationDetail());
				this.erreur = false;
				this.blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Consultation supprimée avec succés"));
				// FacesContext context = FacesContext.getCurrentInstance();
				// context.getExternalContext().getFlash().setKeepMessages(true);
				// try {
				// context.getExternalContext().redirect("Consultation-Gynecologue");
				//
				// } catch (Exception e) {
				// System.out.println(e.getMessage());
				//
				// }

				CfclientService serclt = new CfclientService();
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);
				idPatient = (Integer) session.getAttribute("idu");
				// idPatient = Module.idpatient;

				if (idPatient != null) {

					Cfclient c = serclt.RechercheCfclient(idPatient);
					ConsultationDetailService ser1 = new ConsultationDetailService();
					toutConsultations = ser1
							.rechercheToutConsultation(idPatient);

					if (toutConsultations.size() != 0) {
						c.setDernierVisite(formatter.format(toutConsultations
								.get(0).getDateConsultation()));
						c.setNbCons(c.getNbCons() - 1);
						c.setTypCons(toutConsultations.get(0).getMotifCons());
					} else {
						c.setDernierVisite("Nouveau");
						c.setNbCons(0);
						c.setTypCons("");
					}

					if (motif.equals("nvGross")) {
						List<HistoriqueGross> gr = null;
						HistoriqueGrossService serhisto = new HistoriqueGrossService();
						gr = serhisto.rechercheHistoriqueParidcons(cons
								.getIdConsultationDetail());

						if (gr != null) {
							c.setGestite(c.getGestite() - 1);
							if (gr.size() != 0)
								serhisto.supprimerHistoriqueGross(gr.get(0)
										.getIdhistoriqueGross());

						}

					}

					// ajout id dans la nouvelle grosses

					serclt.modifierPatient(c);

				}
			}
		}

	}

	public void supprimerConsultationGrosses(ConsultationDetail cons) {

		FacesContext face = FacesContext.getCurrentInstance();
		String chAnalyse = "";
		String chRadio = "";
		String chOrdonnace = "";
		if (cons != null) {

			// recherche si nous avons analyse pour cette consultation
			ConsultationDetailService ser = new ConsultationDetailService();
			if (cons.getAnalyse() != null) {
				chAnalyse = "" + "Elle contient une Analyse lieé ";
				this.erreur = true;

			}

			// recherche si nous avons radio pour cette consultation
			if (cons.getRadio() != null) {
				chRadio = "" + " Elle contient un Radio lieé ";
				this.erreur = true;

			}

			// recherche si nous avons ordonnance pour cette consultation
			OrdonnanceService serord = new OrdonnanceService();
			List<Ordonnance> listeord = null;
			listeord = serord
					.rechercheOrdonnanceParConsultation(idConsultationDetail);

			if ((listeord.size() != 0)) {
				chOrdonnace = "" + "Elle contient une Ordannace lieé ";
				this.erreur = true;
			}

			if (this.erreur == true) {
				this.blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Impossible de supprimer cette consultation", chAnalyse
								+ chRadio + chOrdonnace));
				this.erreur = false;
			}

			if ((face.getMessageList().size() == 0) && (this.erreur == false)) {
				String motif = "";
				if (cons.isConsGrossType()) {// c'est une nouvelle grossesse -->
												// Gest-1
					motif = "nvGross";

				}
				ser.supprimerConsultationDetail(cons.getIdConsultationDetail());
				this.erreur = false;
				this.blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Consultation supprimée avec succés"));
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
				try {
					context.getExternalContext().redirect(
							"Consultation_Obstetrique");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				CfclientService serclt = new CfclientService();
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);
				idPatient = (Integer) session.getAttribute("idu");
				// idPatient = Module.idpatient;

				if (idPatient != null) {

					Cfclient c = serclt.RechercheCfclient(idPatient);
					ConsultationDetailService ser1 = new ConsultationDetailService();
					toutConsultations = ser1
							.rechercheToutConsultation(idPatient);

					idPatient = (Integer) session.getAttribute("idu");
					List<ConsultationDetail> consultationDetailsObs = ser
							.rechercheConsultationBytype(idPatient, 1);

					// System.out.println("entree boucle + size "+consultationDetailsObs.size());
					if (consultationDetailsObs.size() >= 1) {
						// System.out.println("entree boucle + size "+consultationDetailsObs.size());
						c.setDdg(toutConsultations.get(
								toutConsultations.size() - 1).getDdg());
						c.setDdr(toutConsultations.get(
								toutConsultations.size() - 1).getDdr());
						c.settPrevu(toutConsultations.get(
								toutConsultations.size() - 1).getTermePrevu());
						c.settActuel(toutConsultations.get(
								toutConsultations.size() - 1).getTermeActuel());
					} else {
						c.setDdg("");
						c.setDdr("");
						c.settPrevu("");
						c.settActuel("");
					}

					if (toutConsultations.size() != 0) {
						c.setTypCons(toutConsultations.get(0).getMotifCons());
						c.setDernierVisite(formatter.format(toutConsultations
								.get(0).getDateConsultation()));
						c.setNbCons(c.getNbCons() - 1);

					} else {
						c.setDernierVisite("Nouveau");
						c.setNbCons(0);
						c.setTypCons("");

					}

					if (motif.equals("nvGross")) {
						List<HistoriqueGross> gr = null;
						HistoriqueGrossService serhisto = new HistoriqueGrossService();
						gr = serhisto.rechercheHistoriqueParidcons(cons
								.getIdConsultationDetail());

						if (gr != null) {
							c.setGestite(c.getGestite() - 1);
							if (gr.size() != 0)
								serhisto.supprimerHistoriqueGross(gr.get(0)
										.getIdhistoriqueGross());

						}

					}

					// ajout id dans la nouvelle grosses

					serclt.modifierPatient(c);

				}
			}
		}

	}

	public void suiviGrossesse() {
		// initialisation des champs et les rendre editables
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		initialiserConObs();
		// date consultation aujourd'hui
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateConsultation = dateFormat.format(actuelle);

		ConsultaionService ser = new ConsultaionService();
		Consultation cons = ser.rechercheParConsultation(consultationmotif);
		honoraire = cons.getHonoraire();

		if (c != null) {
			ddr = c.getDdr();
			ddg = c.getDdg();
			ddgCorigee = c.isDdgCorigee();
			termePrevu = c.gettPrevu();
			// terme actuel est tjrs calculé
			termeActuel = c.gettActuel();
			toxo = c.getToxo();
			tpha = c.getTpha();
			rubeole = c.getRubeole();
			poids = c.getPoids();
		}
		consGrossType = false;
		action = "ajout";
		read = "editable";

	}

	private void initialiserConObs() {

		ddr = null;
		ddg = null;
		ddgCorigee = false;
		termePrevu = null;
		termeActuel = null;
		toxo = null;
		tpha = null;
		rubeole = null;
		poids = null;
		honoraire = 0.0;
		honorairestring = "0.0";
		tas = null;
		tad = null;
		action = null;
		hu = null;
		sInf = null;
		leuorhee = null;
		col = null;
		symptome = null;
		examen = null;
		cat = null;
		diagnostique = null;
		notes = null;

	}

	public void majSymp() {
		setSymptome(symptome);
	}

	public void testerDatefroti() {
		if ((dateFrotti != null) && (dateFrotti.length() > 0))
			setTestr(true);
		else if ((dateFrotti == null) || (dateFrotti.length() == 0))
			setTestr(false);

	}

	public void majExam() {
		setExamen(examen);
	}

	public void majDiag() {
		setDiagnostique(diagnostique);
	}

	private boolean consGrossType;

	public boolean isConsGrossType() {
		return consGrossType;
	}

	public void setConsGrossType(boolean consGrossType) {
		this.consGrossType = consGrossType;
	}

	private String ancientPoids;
	private String ancientTas;
	private String ancientTad;

	public String getAncientTas() {
		return ancientTas;
	}

	public void setAncientTas(String ancientTas) {
		this.ancientTas = ancientTas;
	}

	public String getAncientTad() {
		return ancientTad;
	}

	public void setAncientTad(String ancientTad) {
		this.ancientTad = ancientTad;
	}

	public String getAncientPoids() {
		return ancientPoids;
	}

	public void setAncientPoids(String ancientPoids) {
		this.ancientPoids = ancientPoids;
	}

	public void modifConsGross(ConsultationDetail cd) {
		// System.out.println("entree modif grossese");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", cd.getIdConsultationDetail());

		idConsultationDetail = cd.getIdConsultationDetail();

		ddr = cd.getDdr();
		ancienvaleurddr = cd.getDdr();
		ddg = cd.getDdg();
		termePrevu = cd.getTermePrevu();
		termeActuel = cd.getTermeActuel();

		honoraire = cd.getHonoraire();

		honorairestring = Double.toString(honoraire);

		dateConsultation = formatter.format(cd.getDateConsultation());

		toxo = cd.getToxo();
		tpha = cd.getTpha();
		rubeole = cd.getRubeole();

		poids = cd.getPoids();
		ancientPoids = cd.getPoids();
		tas = cd.getTas();
		ancientTas = cd.getTas();
		tad = cd.getTad();
		ancientTad = cd.getTad();
		hu = cd.getHu();
		sInf = cd.getsInf();
		leuorhee = cd.getLeuorhee();
		col = cd.getCol();

		symptome = cd.getSymptome();
		examen = cd.getExamen();
		diagnostique = cd.getDiagnostique();

		consGrossType = cd.isConsGrossType();
		if (cd.isConsGrossType())
			typeConsultation = "Nouvelle";
		else
			typeConsultation = "Suivi";

		ancianTypeCons = typeConsultation;

		action = "modif";

		read = "editable";
	}

	public void modeleSelectionChanged(final AjaxBehaviorEvent event) {
		if (idmodele != null)
			app = false;
		else
			app = true;
	}

	public boolean isApp() {
		if (idmodele != null)
			app = false;
		else
			app = true;
		return app;
	}

	public void setApp(boolean app) {

		this.app = app;
	}

	public Boolean getErreur() {
		return erreur;
	}

	public void setErreur(Boolean erreur) {
		this.erreur = erreur;
	}

	public boolean notLireReadOnly() {
		return read.equals("editable");
	}

	public void viewEchoObsTrim2(ActionEvent actionEvent) throws SQLException,
			Exception {
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		String age1;
		String age = "";
		String nomReport = "";

		if (clt.getDateNaiss() != null)
			age1 = Module.age(clt.getDateNaiss()).substring(0, 2);
		else
			age1 = "";

		if (age1.equals("")) {
			age = age1;
		} else {
			age = "( " + age1 + " )" + " Ans";
		}

		if (trim == 1)
			nomReport = "echoObsTrim1";
		if (trim == 2)
			nomReport = "echoObstetriqueTrim2";
		if (trim == 3)
			nomReport = "echoObstetriqueTrim2";

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idConsultation", idConsultationDetail);
		param.put("age", age);
		Module.imprimer(nomReport, param);

	}

	public void viewEchogyneco(ActionEvent actionEvent) throws SQLException,
			Exception {
		String age1;
		String age;
		Cfclient clt = null;
		String nomReport = null;

		if (selectedCons != null) {
			if (idUterus != null) {
				UterusService seruterus = new UterusService();
				uterus = seruterus.rechercheUterus(idUterus);

			}

			CfclientService serclt = new CfclientService();
			clt = serclt.RechercheCfclient(idPatient);
			nomReport = "echoGynecologie";

			if (clt.getDateNaiss() != null)
				age1 = Module.age(clt.getDateNaiss()).substring(0, 2);
			else
				age1 = "";

			if (age1.equals("")) {
				age = age1;
			} else {
				age = "( " + age1 + " )" + " Ans";
			}

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("idConsultation", idConsultationDetail);
			param.put("age", age);
			if (uterus == null) {
				param.put("position", "");
			} else
				param.put("position", uterus.getUterus());

			Module.imprimer(nomReport, param);
		}

	}

	public void onTypeConsultChange() {

		if ((ancianTypeCons == null)
				|| (ancianTypeCons.equals(typeConsultation))) {
			if (typeConsultation.equals("Suivi")) {
				// initialisation des champs et les rendre editables
				CfclientService serc = new CfclientService();
				Cfclient c = serc.RechercheCfclient(idPatient);
				initialiserConObs();
				// date consultation aujourd'hui
				Date actuelle = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				dateConsultation = dateFormat.format(actuelle);

				ConsultaionService ser = new ConsultaionService();
				Consultation cons = ser
						.rechercheParConsultation(consultationmotif);
				honoraire = cons.getHonoraire();
				honorairestring = Double.toString(honoraire);

				if (c != null) {
					ddr = c.getDdr();
					ancienvaleurddr = c.getDdr();
					ddg = c.getDdg();
					ddgCorigee = c.isDdgCorigee();
					termePrevu = c.gettPrevu();
					// terme actuel est tjrs calculé
					if ((ddr != null)
							&& (ddr.equals("") == false)
							&& ((ddg != null) && (ddg.equals("") == false))
							&& ((termePrevu != null) && (termePrevu.equals("") == false))) {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"dd/MM/yyyy");
						Date dateJour = new Date();

						String terme = sdf.format(dateJour);
						long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
						Date dateddr = new Date();
						if (ddr != null) {
							try {

								dateddr = sdf.parse(ddr);
							} catch (Exception e) {
								e.printStackTrace();
							}

							Date date4 = new Date();
							if (dateJour != null) {
								try {
									date4 = sdf.parse(sdf.format(dateJour));
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
							}
							if (terme != null) {
								try {
									date4 = sdf.parse(terme);
								} catch (ParseException e) {
									e.printStackTrace();
								}

								long diff = Math.abs(dateddr.getTime()
										- date4.getTime());
								long numberOfDay = (long) diff
										/ CONST_DURATION_OF_DAY;

								int semaine = (int) (numberOfDay / 7);
								int jourr = (int) (numberOfDay % 7);
								if ((ddr.equals("") == false)
										|| (ddr != null)
										&& ((ddg.equals("") == false) || (ddg != null))
										&& ((termePrevu.equals("") == false) || (termePrevu != null))) {
									termeActuel = semaine + "s" + jourr + "j";
								}
							}
						} else
							termeActuel = "";
					}
					toxo = c.getToxo();
					tpha = c.getTpha();
					rubeole = c.getRubeole();
					poids = c.getPoids();
				}
				consGrossType = false;
				action = "ajout";
				read = "editable";
			} else if (typeConsultation.equals("Nouvelle")) {
				initialisation();
				// apporter les données de la dernière consultation si elle
				// existe
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);
				idPatient = (Integer) session.getAttribute("idu");
				CfclientService serc = new CfclientService();
				Cfclient c = serc.RechercheCfclient(idPatient);
				poids = c.getPoids();
				ancientPoids = poids;
				Date actuelle = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				dateConsultation = dateFormat.format(actuelle);
				consGrossType = true;
				ConsultaionService ser = new ConsultaionService();
				Consultation cons = ser
						.rechercheParConsultation(consultationmotif);
				honoraire = cons.getHonoraire();
				honorairestring = Double.toString(honoraire);
				action = "ajout";
				read = "editable";
				
			}
		} else {
			if (ancianTypeCons.equals(typeConsultation) == false) {


				if ((ancianTypeCons.equals("Nouvelle"))
						&& (typeConsultation.equals("Suivi")))

				{
					ConsultationDetailService serd = new ConsultationDetailService();
					HttpSession session = (HttpSession) FacesContext
							.getCurrentInstance().getExternalContext()
							.getSession(false);
					idPatient = (Integer) session.getAttribute("idu");
					List<ConsultationDetail> consultationDetails = serd
							.rechercheConsultationBytype(idPatient, 1);
					if (consultationDetails.size() > 1) {
						ConsultationDetail cons = consultationDetails
								.get(consultationDetails.size() - 2);
						setDdg(cons.getDdg());
						setDdr(cons.getDdr());
						setTermeActuel(cons.getTermeActuel());
						setTermePrevu(cons.getTermePrevu());
					}
				}
			}
		}
	}

	public void majCat() {
		setCat(cat);
	}

	public void retour() {

		if (consultationmotif.equals("C. Gyneco")) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("Consultation-Gynecologique");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		else if (consultationmotif.equals("C. Obst")) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("Consultation_Obstetrique");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		selectedCons = null;
		selectedConsult = null;
		desibledAnalyse = true;
		desibledRadio = true;
		desibledOrd = true;

	}

	public void ajoutConGenerale() {
		notes = null;
		cat = null;
		symptome = null;
		examen = null;
		diagnostique = null;
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.dateConsultation = dateFormat.format(actuelle);
		action = "ajouter";
		read = "editable";
	}

	public void validationConsGenerale() {
		FacesContext face = FacesContext.getCurrentInstance();
		CfclientService serclt = new CfclientService();
		Cfclient clt = serclt.RechercheCfclient(idPatient);
		CfclientService ser = new CfclientService();
		clt.setNbCons(clt.getNbCons() + 1);
		clt.setTypCons(consultationmotif);
		ser.modifierPatient(clt);
		if (action != null && action.equals("ajouter")) {
			ConsultationDetail cd = new ConsultationDetail();
			cd.setCfclient(clt);
			cd.setHonoraire(honoraire);
			cd.setPoids(poids);
			cd.setTas(tas);
			cd.setTad(tad);
			cd.setSymptome(symptome);
			cd.setExamen(examen);
			cd.setDiagnostique(diagnostique);
			try {
				cd.setDateConsultation(formatter.parse(dateConsultation));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			cd.setNotes(notes);
			cd.setCat(cat);
			ConsultaionService s = new ConsultaionService();

			consultation = s.rechercheParConsultation(consultationmotif);

			cd.setConsultation(consultation);
			ConsultationDetailService ser4 = new ConsultationDetailService();

			ser4.ajouterConsultationDetail(cd);
			this.blocage = false;
			tempsface = 3500;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Consultation ajoutée avec succés"));
			action = null;
			read = "noeditable";
			// mettre à jour les données du patient
			clt.setPoids(poids);
			clt.setDateCons(dateConsultation);
			clt.setDernierVisite(dateConsultation);
			clt.setTypCons(consultationmotif);
			clt.setNbCons(clt.getNbCons() + 1);
			serclt.modifierPatient(clt);
			initialisation();
		}

	}

	public void goToEchoGynecologique() {
		consultationmotif = "E. Gyneco";
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Echographie-Gynecologique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		initialisationechogyneco();
	}

	public void goToEchoObstetricale() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("consult", "E. Obst");

		consultationmotif = "E. Obst";

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Echographie_Obstetricale");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		initialisationEchoObs();

	}

	public void goToConsultationGyneco() {
		consultationmotif = "C. Gyneco";
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Consultation-Gynecologique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		initialisationConGyneco();
		selectedCons = null;
		selectedConsult = null;
		if (selectedCons == null) {

			desibledAnalyse = true;
			desibledOrd = true;
			desibledRadio = true;

		} else {
			desibledAnalyse = false;
			desibledOrd = false;
			desibledRadio = false;
		}
	}

	public void goToConsultationGrossesse() {

		consultationmotif = "C. Obst";
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Consultation_Obstetrique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		initialiserConObs();
		
		selectedCons = null;
		selectedConsult = null;
		typeConsultation = "--selectionner--";
	}

	public void goToConsultGenerale(Integer idP) {
		consultationmotif = "C. Générale";
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", idPatient);
		idPatient = idP;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("ConsultationGenerale.xhtml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void retourListePatient() {

		honoraire = 0;
		poids = null;
		tas = null;
		tad = null;
		symptome = null;
		examen = null;
		diagnostique = null;
		cat = null;
		notes = null;
		dateConsultation = null;
		consGrossType = false;
		read = "noeditable";

		this.setRead("noeditable");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public void validateField(FacesContext ctx, UIComponent comp, Object inValue)
			throws ValidatorException {
		FacesContext face = FacesContext.getCurrentInstance();
		int value = (Integer) inValue;

		if (!(value >= 0 && value <= 100) && !(value == -9)) {
			this.blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur", "il faut que entiers"));
		}
	}

	public void changeHonoraireObs1() {
		FacesContext face = FacesContext.getCurrentInstance();
		Boolean testValid = true;
		String msg = "";
		try {

			honorairesobs = Float.parseFloat(honoraireStringobs1);
			setHonoraire(honorairesobs);
			testValid = true;
		} catch (Exception e) {
			honorairesobs = (float) 0;
			testValid = false;
			msg = msg + "L'honoraire ne contient que des chiffres";
			ConsultaionService serf = new ConsultaionService();
			Consultation consf = serf
					.rechercheParConsultation(consultationmotif);
			honorairesobs = consf.getHonoraire();
			honoraireStringobs1 = Double.toString(honorairesobs);
		}

		if (testValid == false) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", msg));
		}

	}

	public void changeHonoraireObs2() {
		FacesContext face = FacesContext.getCurrentInstance();
		Boolean testValid = true;
		String msg = "";
		try {

			honorairesobs2 = Float.parseFloat(honoraireStringobs2);
			setHonoraire(honorairesobs2);
			testValid = true;
		} catch (Exception e) {
			honorairesobs2 = (float) 0;
			testValid = false;
			msg = msg + "L'honoraire ne contient que des chiffres";
			ConsultaionService serf = new ConsultaionService();
			Consultation consf = serf
					.rechercheParConsultation(consultationmotif);
			honorairesobs2 = consf.getHonoraire();
			honoraireStringobs2 = Double.toString(honorairesobs2);
		}

		if (testValid == false) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", msg));
		}

	}

	public void changeHonoraireObs3() {
		FacesContext face = FacesContext.getCurrentInstance();
		Boolean testValid = true;
		String msg = "";
		try {

			honorairesobs3 = Float.parseFloat(honoraireStringobs3);
			setHonoraire(honorairesobs3);
			testValid = true;
		} catch (Exception e) {
			honorairesobs3 = (float) 0;
			testValid = false;
			msg = msg + "L'honoraire ne contient que des chiffres";
			ConsultaionService serf = new ConsultaionService();
			Consultation consf = serf
					.rechercheParConsultation(consultationmotif);
			honorairesobs3 = consf.getHonoraire();
			honoraireStringobs3 = Double.toString(honorairesobs3);
		}

		if (testValid == false) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", msg));
		}

	}

	public String getHonorairestring() {
		return honorairestring;
	}

	public void setHonorairestring(String honorairestring) {

		this.honorairestring = honorairestring;
	}

	public String getHonoraireStringobs1() {
		return honoraireStringobs1;
	}

	public void setHonoraireStringobs1(String honoraireStringobs1) {
		this.honoraireStringobs1 = honoraireStringobs1;
	}

	public String getHonoraireStringobs2() {
		return honoraireStringobs2;
	}

	public void setHonoraireStringobs2(String honoraireStringobs2) {
		this.honoraireStringobs2 = honoraireStringobs2;
	}

	public String getHonoraireStringobs3() {
		return honoraireStringobs3;
	}

	public void setHonoraireStringobs3(String honoraireStringobs3) {
		this.honoraireStringobs3 = honoraireStringobs3;
	}

	public void changeTas() {
		FacesContext face = FacesContext.getCurrentInstance();
		Boolean testValid = true;
		String msg = "";

		try {
			if (tas != "") {
				Integer tass = Integer.parseInt(tas);
				setTas(Integer.toString(tass));
			}

		} catch (Exception e) {
			if (tas != "") {
				testValid = false;
				msg = msg + "Tas ne contient que des chiffres";

				tas = "0";

				if (testValid == false) {
					blocage = true;
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "", msg));
				}
			}
		}

	}

	public void changePoids() {
		FacesContext face = FacesContext.getCurrentInstance();
		Boolean testValid = true;
		String msg = "";

		try {
			if (poids != "")

			{
				Float poidss = Float.parseFloat(poids);
				setPoids(Float.toString(poidss));
			}

		} catch (Exception e) {
			testValid = false;
			msg = msg + "poids ne contient que des chiffres";

			idPatient = (Integer) session.getAttribute("idu");
			CfclientService serclt = new CfclientService();
			Cfclient clt = serclt.RechercheCfclient(idPatient);
			poids = clt.getPoids();
		}
		if (poids != "") {
			if (testValid == false) {
				blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "", msg));
			}
		}

	}

	public void changeTad() {
		FacesContext face = FacesContext.getCurrentInstance();
		Boolean testValid = true;
		String msg = "";

		try {
			if (tad != "") {
				Integer tads = Integer.parseInt(tad);
				setTad(Integer.toString(tads));
			}

		} catch (Exception e) {
			testValid = false;
			msg = msg + "Tad ne contient que des chiffres";

			tad = "0";
		}
		if (tad != "") {
			if (testValid == false) {
				blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "", msg));
			}
		}

	}

	public boolean isDesibledOrd() {
		return desibledOrd;
	}

	public void setDesibledOrd(boolean desibledOrd) {
		this.desibledOrd = desibledOrd;
	}

	public boolean isDesibledRadio() {
		return desibledRadio;
	}

	public void setDesibledRadio(boolean desibledRadio) {
		this.desibledRadio = desibledRadio;
	}

	public boolean isDesibledAnalyse() {
		return desibledAnalyse;
	}

	public void setDesibledAnalyse(boolean desibledAnalyse) {
		this.desibledAnalyse = desibledAnalyse;
	}

	public String getAncienvaleurddr() {
		return ancienvaleurddr;
	}

	public void setAncienvaleurddr(String ancienvaleurddr) {
		this.ancienvaleurddr = ancienvaleurddr;
	}

	@PostConstruct
	public void init() {
		selectedCons = null;
		selectedConsult = null;
		desibledAnalyse = true;
		desibledOrd = true;
		desibledRadio = true;

	}

	public void gotoAcceuil() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean desibledImpr() {
		boolean desi = true;
		if (selectedCons == null) {
			desi = true;
		} else
			desi = false;

		return (desi);
	}

	public void notblocagenotification() {
		blocage = false;
	}

	public String getAncienValeurDDG() {
		return ancienValeurDDG;
	}

	public void setAncienValeurDDG(String ancienValeurDDG) {
		this.ancienValeurDDG = ancienValeurDDG;
	}

	public boolean isDdgCorigee() {
		return ddgCorigee;
	}

	public void setDdgCorigee(boolean ddgCorigee) {
		this.ddgCorigee = ddgCorigee;
	}

	public String getAncienvaleurddg() {
		return ancienvaleurddg;
	}

	public void setAncienvaleurddg(String ancienvaleurddg) {
		this.ancienvaleurddg = ancienvaleurddg;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public DateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(DateFormat formatter) {
		this.formatter = formatter;
	}

	public String getAncianTypeCons() {
		return ancianTypeCons;
	}

	public void setAncianTypeCons(String ancianTypeCons) {
		this.ancianTypeCons = ancianTypeCons;
	}

}
