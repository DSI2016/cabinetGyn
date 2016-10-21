package com.doctor.bean;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperRunManager;

import org.primefaces.context.RequestContext;

import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.AnalyseDemandee;
import com.doctor.persistance.AntChirCfclient;
import com.doctor.persistance.AntFamCfclient;
import com.doctor.persistance.AntMedCfclient;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Cfclient_view;
import com.doctor.persistance.Clinique;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.Contraception;
import com.doctor.persistance.Docteur;
import com.doctor.persistance.HistoriqueCertif;
import com.doctor.persistance.HistoriqueGross;
import com.doctor.persistance.MedOrd;
import com.doctor.persistance.Mois;
import com.doctor.persistance.Ordonnance;
import com.doctor.persistance.Profession;
import com.doctor.persistance.Radio;
import com.doctor.persistance.RendezVous;
import com.doctor.persistance.Salle;
import com.doctor.persistance.Sterile;
import com.doctor.persistance.TabSalle;
import com.doctor.persistance.Ville;
import com.doctor.persistance.historiqueLettre;
import com.doctor.service.AnalyseDemandeeService;
import com.doctor.service.AnalyseService;
import com.doctor.service.AntChirCfclientService;
import com.doctor.service.AntFamCfclientService;
import com.doctor.service.AntMedCfclientService;
import com.doctor.service.CfclientService;
import com.doctor.service.Cfclient_viewService;
import com.doctor.service.CliniqueService;
import com.doctor.service.ConsultationDetailService;
import com.doctor.service.ContraceptionService;
import com.doctor.service.DocteurService;
import com.doctor.service.HistoriqueCertifService;
import com.doctor.service.HistoriqueGrossService;
import com.doctor.service.MedOrdService;
import com.doctor.service.OrdonnanceService;
import com.doctor.service.ProfessionService;
import com.doctor.service.RadioService;
import com.doctor.service.RendezVousService;
import com.doctor.service.SalleService;
import com.doctor.service.SterileService;
import com.doctor.service.TabSalleService;
import com.doctor.service.VilleService;
import com.doctor.service.historiqueLettreService;
import com.mysql.jdbc.Connection;

@ManagedBean(name = "cfclientBean")
@ViewScoped
public class CfclientBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	// private Integer rating1;
	private String categorieEtoile;

	// private Integer categorieMoyen=0;
	// private Integer categoriePositive=0;
	private Integer idville;
	private boolean rendredNegative1 = false;
	private boolean rendredNegative2 = false;
	private boolean rendredNegative3 = false;
	private boolean rendredMoyen = false;
	private boolean rendredPositive1 = false;
	private boolean rendredPositive2 = false;
	private boolean rendredPositive3 = false;
	private boolean rendredExtra = false;

	private String valeurRechercheArchive;
	private Integer idclinique;
	private Integer idprofessionByProfesscp;
	private Integer iddoctor;
	private Integer idprofessionByProfessp;
	private String prefix;
	private String nomprenom;
	private String prenomnom;
	private String ordre;
	private String ordreArchive;
	private int nbCons;
	private String glycemie;
	private String aghbs;
	private String categorie;
	private String nom;
	private String prenom;
	private String cnss;
	private String sexe;
	private String civil;
	private String dateNaiss;
	private String rue;
	private String codePost;
	private String pays;
	private String telephone;
	private String notes;
	private String typCons;
	// private String nbCons;
	private String dateCons;
	private String datesaisie;
	private String ant11;
	private int dpr;
	private String mariage;
	private String consang;
	private String dureeReg;
	private String regles;
	private String dysmenorhe;
	private String mastodynie;
	private String menopose;
	private String ant3;
	private String dateFr;
	private String resultFr;
	private String ddr;
	private byte spanio;
	private String ddg;
	private String dateMoyen;
	private String moyen;
	private int gestite;
	private int partie;
	private int gviv;
	private int fviv;
	private int cesar;
	private String village;
	private String telephone2;
	private String telC;
	private String gsmC;
	private String gsm1;
	private String gsm2;
	private String eMailP;
	private String eMailC;
	private String nomC;
	private String prenomC;
	private String taille;
	private String poids;
	private String gs;
	private String attributTri;
	private String attributTriArchive;
	private int age;

	private String rh;
	private String dateNaissC;
	private Set<Salle> salles = new HashSet<Salle>(0);
	private String profession;
	private List<Ville> villes;
	private List<Clinique> cliniques;
	private List<Docteur> docteurs;
	private List<Profession> professions;
	private List<Mois> moiss = new ArrayList<Mois>();
	private List<String> jours = new ArrayList<String>();
	private List<Integer> annee = new ArrayList<Integer>();
	private List<String> listesRecherches = new ArrayList<String>();
	private List<String> Listestris = new ArrayList<String>();

	private String jj;
	private String mm;
	private Integer aaaa;
	private String jjC;
	private String mmC;
	private Integer aaaaC;
	private String action;
	private String valeurRecherche;
	private String attribut;
	private String motif;
	private List<Cfclient> patients;
	private List<Cfclient_view> patientsView;

	
	
	private List<Cfclient_view> patientArchives;
	private List<Cfclient> filtred;
	
	private List<Radio> r;
	private List<ConsultationDetail> cons;
	private List<AnalyseDemandee> a;
	private List<Ordonnance> ords;
	private List<Contraception> cont;
	private List<RendezVous> rend;
	private List<AntChirCfclient> antChir;
	private List<AntMedCfclient> antMed;
	private List<AntFamCfclient> antFam;
	private List<HistoriqueCertif> histoCert;
	private List<historiqueLettre> histoLett;
	private List<HistoriqueGross> histoGross;
	private Sterile ste;
	private Salle s;
	private boolean archive;

	private String professionP;
	private String professionC;
	private String dernierVisite;
	private String allergie;
	private String assurance1;
	private String assurance2;
	private String profc;
	private String docLib;
	private String libClin;
	private String vil;
	private String heure;

	private boolean verSalle;
	private boolean modifPatient;
	private boolean detailPat;
	private boolean chargerPat;
	private boolean ajouterPat;
	private boolean suppressionPat;
	private boolean tabInfGnrAjtPat;
	private boolean tabcontactAjtPat;
	private boolean tabInfConjAjtPat;
	private boolean tabAtreInfAjtPat;
	private boolean blocage = false;
	private int tempsface = 3000;
	private String message;

	private String style;

	private int index = 0;
	private int indexInfo = 0;
	
	
	private TabSalle tabsal;
	
	private int idTabSalle;
	
	
	

	public int getIdTabSalle() {
		return idTabSalle;
	}

	public void setIdTabSalle(int idTabSalle) {
		this.idTabSalle = idTabSalle;
	}

	public TabSalle getTabsal() {
		return tabsal;
	}

	public void setTabsal(TabSalle tabsal) {
		this.tabsal = tabsal;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndexInfo() {
		return indexInfo;
	}

	public void setIndexInfo(int indexInfo) {
		this.indexInfo = indexInfo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	

	public List<Cfclient_view> getPatientArchives() {
		patientArchives= new Cfclient_viewService().rechercheTousCfclient_view(true);
		return patientArchives;
	}

	public void setPatientArchives(List<Cfclient_view> patientArchives) {
		this.patientArchives = patientArchives;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isTabInfGnrAjtPat() {
		if (Module.tabInfGenAjoutPat.equals("0")) {
			tabInfGnrAjtPat = false;
		} else {
			tabInfGnrAjtPat = true;
		}
		return tabInfGnrAjtPat;
	}

	public void setTabInfGnrAjtPat(boolean tabInfGnrAjtPat) {
		this.tabInfGnrAjtPat = tabInfGnrAjtPat;
	}

	public boolean isTabcontactAjtPat() {
		if (Module.tabCntctAjoutPat.equals("0")) {
			tabcontactAjtPat = false;
		} else {
			tabcontactAjtPat = true;
		}

		return tabcontactAjtPat;
	}

	public void setTabcontactAjtPat(boolean tabcontactAjtPat) {
		this.tabcontactAjtPat = tabcontactAjtPat;
	}

	public boolean isTabInfConjAjtPat() {
		if (Module.tabInfoConjAjoutPat.equals("0")) {
			tabInfConjAjtPat = false;
		} else {
			tabInfConjAjtPat = true;
		}
		return tabInfConjAjtPat;
	}

	public void setTabInfConjAjtPat(boolean tabInfConjAjtPat) {
		this.tabInfConjAjtPat = tabInfConjAjtPat;
	}

	public boolean isTabAtreInfAjtPat() {
		if (Module.tabAutreInfAjoutPat.equals("0")) {
			tabAtreInfAjtPat = false;
		} else {
			tabAtreInfAjtPat = true;
		}
		return tabAtreInfAjtPat;
	}

	public void setTabAtreInfAjtPat(boolean tabAtreInfAjtPat) {
		this.tabAtreInfAjtPat = tabAtreInfAjtPat;
	}

	public boolean isSuppressionPat() {
		if (Module.supPatient.equals("0")) {
			suppressionPat = false;
		} else {
			suppressionPat = true;
		}
		return suppressionPat;
	}

	public void setSuppressionPat(boolean suppressionPat) {
		this.suppressionPat = suppressionPat;
	}

	public boolean isAjouterPat() {
		if (Module.ajoutPatient.equals("0")) {
			ajouterPat = false;
		} else {
			ajouterPat = true;
		}
		return ajouterPat;
	}

	public void setAjouterPat(boolean ajouterPat) {
		this.ajouterPat = ajouterPat;
	}

	public boolean isVerSalle() {
		if (Module.verSal.equals("0")) {
			verSalle = false;
		} else {
			verSalle = true;
		}
		return verSalle;
	}

	public void setVerSalle(boolean verSalle) {
		this.verSalle = verSalle;
	}

	public boolean isModifPatient() {
		if (Module.modPatient.equals("0")) {
			modifPatient = false;
		} else {
			modifPatient = true;
		}
		return modifPatient;
	}

	public void setModifPatient(boolean modifPatient) {
		this.modifPatient = modifPatient;
	}

	public boolean isDetailPat() {
		if (Module.detPatient.equals("0")) {
			detailPat = false;
		} else {
			detailPat = true;
		}
		return detailPat;
	}

	public void setDetailPat(boolean detailPat) {
		this.detailPat = detailPat;
	}

	public boolean isChargerPat() {
		if (Module.chargPatient.equals("0")) {
			chargerPat = false;
		} else {
			chargerPat = true;
		}
		return chargerPat;
	}

	public void setChargerPat(boolean chargerPat) {
		this.chargerPat = chargerPat;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getVil() {
		return vil;
	}

	public void setVil(String vil) {
		this.vil = vil;
	}

	public String getDocLib() {
		return docLib;
	}

	public void setDocLib(String docLib) {
		this.docLib = docLib;
	}

	public String getLibClin() {
		return libClin;
	}

	public void setLibClin(String libClin) {
		this.libClin = libClin;
	}

	public String getProfc() {
		return profc;
	}

	public void setProfc(String profc) {
		this.profc = profc;
	}

	public String getAssurance1() {
		return assurance1;
	}

	public void setAssurance1(String assurance1) {
		this.assurance1 = assurance1;
	}

	public String getAssurance2() {
		return assurance2;
	}

	public void setAssurance2(String assurance2) {
		this.assurance2 = assurance2;
	}

	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}

	public String getDernierVisite() {
		return dernierVisite;
	}

	public void setDernierVisite(String dernierVisite) {
		this.dernierVisite = dernierVisite;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProfessionP() {
		return professionP;
	}

	public void setProfessionP(String professionP) {
		this.professionP = professionP;
	}

	public String getProfessionC() {
		return professionC;
	}

	public void setProfessionC(String professionC) {
		this.professionC = professionC;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getValeurRecherche() {
		// valeurRecherche = Module.recherchePatient;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		// Module.recherchePatient = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public String getAttribut() {
		return attribut;
	}

	public void setAttribut(String attribut) {
		this.attribut = attribut;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getJj() {
		return jj;
	}

	public void setJj(String jj) {
		this.jj = jj;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public Integer getAaaa() {
		return aaaa;
	}

	public void setAaaa(Integer aaaa) {
		this.aaaa = aaaa;
	}

	public String getDateNaissC() {
		return dateNaissC;
	}

	public void setDateNaissC(String dateNaissC) {
		this.dateNaissC = dateNaissC;
	}

	public String getJjC() {
		return jjC;
	}

	public void setJjC(String jjC) {
		this.jjC = jjC;
	}

	public String getMmC() {
		return mmC;
	}

	public void setMmC(String mmC) {
		this.mmC = mmC;
	}

	public Integer getAaaaC() {
		return aaaaC;
	}

	public void setAaaaC(Integer aaaaC) {
		this.aaaaC = aaaaC;
	}

	public Integer getIdville() {
		return idville;
	}

	public void setIdville(Integer idville) {
		this.idville = idville;
	}

	public List<Ville> getVilles() {
		VilleService sr = new VilleService();
		villes = sr.rechercheTousVille();
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public List<Clinique> getCliniques() {
		CliniqueService sr = new CliniqueService();
		cliniques = sr.rechercheTousClinique();
		return cliniques;
	}

	public void setCliniques(List<Clinique> cliniques) {
		this.cliniques = cliniques;
	}

	public List<Docteur> getDocteurs() {
		DocteurService sr = new DocteurService();
		docteurs = sr.rechercheTousDocteur();
		return docteurs;
	}

	public void setDocteurs(List<Docteur> docteurs) {
		this.docteurs = docteurs;
	}

	public List<Profession> getProfessions() {
		ProfessionService sr = new ProfessionService();
		professions = sr.rechercheTousProfession();
		return professions;
	}

	public void setProfessions(List<Profession> professions) {
		this.professions = professions;
	}

	public Integer getIdclinique() {
		return idclinique;
	}

	public void setIdclinique(Integer idclinique) {
		this.idclinique = idclinique;
	}

	public Integer getIdprofessionByProfesscp() {
		return idprofessionByProfesscp;
	}

	public void setIdprofessionByProfesscp(Integer idprofessionByProfesscp) {
		this.idprofessionByProfesscp = idprofessionByProfesscp;
	}

	public Integer getIddoctor() {
		return iddoctor;
	}

	public void setIddoctor(Integer iddoctor) {
		this.iddoctor = iddoctor;
	}

	public Integer getIdprofessionByProfessp() {
		return idprofessionByProfessp;
	}

	public void setIdprofessionByProfessp(Integer idprofessionByProfessp) {
		this.idprofessionByProfessp = idprofessionByProfessp;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getTelC() {
		return telC;
	}

	public void setTelC(String telC) {
		this.telC = telC;
	}

	public String getGsmC() {
		return gsmC;
	}

	public void setGsmC(String gsmC) {
		this.gsmC = gsmC;
	}

	public String getGsm1() {
		return gsm1;
	}

	public void setGsm1(String gsm1) {
		this.gsm1 = gsm1;
	}

	public String getGsm2() {
		return gsm2;
	}

	public void setGsm2(String gsm2) {
		this.gsm2 = gsm2;
	}

	public String geteMailP() {
		return eMailP;
	}

	public void seteMailP(String eMailP) {
		this.eMailP = eMailP;
	}

	public String geteMailC() {
		return eMailC;
	}

	public void seteMailC(String eMailC) {
		this.eMailC = eMailC;
	}

	public String getNomC() {
		return nomC;
	}

	public void setNomC(String nomC) {
		this.nomC = nomC;
	}

	public String getPrenomC() {
		return prenomC;
	}

	public void setPrenomC(String prenomC) {
		this.prenomC = prenomC;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCnss() {
		return this.cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getCivil() {
		return this.civil;
	}

	public void setCivil(String civil) {
		this.civil = civil;
	}

	public String getDateNaiss() {
		return this.dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePost() {
		return this.codePost;
	}

	public void setCodePost(String codePost) {
		this.codePost = codePost;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTypCons() {
		return this.typCons;
	}

	public void setTypCons(String typCons) {
		this.typCons = typCons;
	}

	// public String getNbCons() {
	// return this.nbCons;
	// }
	//
	// public void setNbCons(String nbCons) {
	// this.nbCons = nbCons;
	// }

	public String getDateCons() {
		return this.dateCons;
	}

	public void setDateCons(String dateCons) {
		this.dateCons = dateCons;
	}

	public String getDatesaisie() {
		return this.datesaisie;
	}

	public void setDatesaisie(String datesaisie) {
		this.datesaisie = datesaisie;
	}

	public String getAnt11() {
		return this.ant11;
	}

	public void setAnt11(String ant11) {
		this.ant11 = ant11;
	}

	public int getDpr() {
		return this.dpr;
	}

	public void setDpr(int dpr) {
		this.dpr = dpr;
	}

	public String getMariage() {
		return this.mariage;
	}

	public void setMariage(String mariage) {
		this.mariage = mariage;
	}

	public String getConsang() {
		return this.consang;
	}

	public void setConsang(String consang) {
		this.consang = consang;
	}

	public String getDureeReg() {
		return this.dureeReg;
	}

	public void setDureeReg(String dureeReg) {
		this.dureeReg = dureeReg;
	}

	public String getRegles() {
		return this.regles;
	}

	public void setRegles(String regles) {
		this.regles = regles;
	}

	public String getDysmenorhe() {
		return this.dysmenorhe;
	}

	public void setDysmenorhe(String dysmenorhe) {
		this.dysmenorhe = dysmenorhe;
	}

	public String getMastodynie() {
		return this.mastodynie;
	}

	public void setMastodynie(String mastodynie) {
		this.mastodynie = mastodynie;
	}

	public String getMenopose() {
		return this.menopose;
	}

	public void setMenopose(String menopose) {
		this.menopose = menopose;
	}

	public String getAnt3() {
		return this.ant3;
	}

	public void setAnt3(String ant3) {
		this.ant3 = ant3;
	}

	public String getDateFr() {
		return this.dateFr;
	}

	public void setDateFr(String dateFr) {
		this.dateFr = dateFr;
	}

	public String getResultFr() {
		return this.resultFr;
	}

	public void setResultFr(String resultFr) {
		this.resultFr = resultFr;
	}

	public String getDdr() {
		return this.ddr;
	}

	public void setDdr(String ddr) {
		this.ddr = ddr;
	}

	public byte getSpanio() {
		return this.spanio;
	}

	public void setSpanio(byte spanio) {
		this.spanio = spanio;
	}

	public String getDdg() {
		return this.ddg;
	}

	public void setDdg(String ddg) {
		this.ddg = ddg;
	}

	public String getDateMoyen() {
		return this.dateMoyen;
	}

	public void setDateMoyen(String dateMoyen) {
		this.dateMoyen = dateMoyen;
	}

	public String getMoyen() {
		return this.moyen;
	}

	public void setMoyen(String moyen) {
		this.moyen = moyen;
	}

	public int getGestite() {
		return this.gestite;
	}

	public void setGestite(int gestite) {
		this.gestite = gestite;
	}

	public int getPartie() {
		return this.partie;
	}

	public void setPartie(int partie) {
		this.partie = partie;
	}

	public int getGviv() {
		return this.gviv;
	}

	public void setGviv(int gviv) {
		this.gviv = gviv;
	}

	public int getFviv() {
		return this.fviv;
	}

	public void setFviv(int fviv) {
		this.fviv = fviv;
	}

	public int getCesar() {
		return this.cesar;
	}

	public void setCesar(int cesar) {
		this.cesar = cesar;
	}

	public Set<Salle> getSalles() {
		return this.salles;
	}

	public void setSalles(Set<Salle> salles) {
		this.salles = salles;
	}

	public void goToAccueil() {
		Module.recherchePatient = "";
		valeurRecherche = null;
		// init();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@PostConstruct
	public void init() {
		//patients = new CfclientService().rechercheParArchive(false);
		patientsView= new Cfclient_viewService().rechercheTousCfclient_view(false);
		
		//patientArchives = new CfclientService().rechercheParArchive(true);
	}




	public List<Cfclient_view> getPatientsView() {
		return patientsView;
	}

	public void setPatientsView(List<Cfclient_view> patientsView) {
		this.patientsView = patientsView;
	}

	public List<Cfclient> getPatients() {

		return patients;
	}

	public void setPatients(List<Cfclient> patients) {
		this.patients = patients;
	}

	public List<Cfclient> getFiltred() {
		return filtred;
	}

	public void setFiltred(List<Cfclient> filtred) {
		this.filtred = filtred;
	}

	public List<String> getJours() {
		jours.clear();
		for (int i = 1; i <= 31; i++)
			if (i < 10)
				jours.add(new String("0" + i));
			else
				jours.add(new String("" + i));

		return jours;
	}

	public void setJours(List<String> jours) {
		this.jours = jours;
	}

	public List<Integer> getAnnee() {
		annee.clear();
		int i;
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		for (i = 1900; i <= year; i++) {
			annee.add(new Integer(i));
		}
		return annee;

	}

	public void setAnnee(List<Integer> annee) {

		this.annee = annee;
	}

	public List<Mois> getMoiss() {
		moiss.clear();
		Mois arg0 = new Mois("01", "janvier");
		moiss.add(arg0);
		Mois arg1 = new Mois("02", "février");
		moiss.add(arg1);
		Mois arg2 = new Mois("03", "mars");
		moiss.add(arg2);
		Mois arg3 = new Mois("04", "avril");
		moiss.add(arg3);
		Mois arg4 = new Mois("05", "mai");
		moiss.add(arg4);
		Mois arg5 = new Mois("06", "juin");
		moiss.add(arg5);
		Mois arg6 = new Mois("07", "juillet");
		moiss.add(arg6);
		Mois arg7 = new Mois("08", "out");
		moiss.add(arg7);
		Mois arg8 = new Mois("09", "septembre");
		moiss.add(arg8);
		Mois arg9 = new Mois("11", "novembre");
		moiss.add(arg9);
		Mois arg10 = new Mois("10", "octobre");
		moiss.add(arg10);
		Mois arg11 = new Mois("12", "décembre");
		moiss.add(arg11);

		return moiss;
	}

	public void setMoiss(List<Mois> moiss) {
		this.moiss = moiss;
	}

	public List<String> getListesRecherches() {
		listesRecherches.clear();

		// listesRecherches.add("CNAM");
		listesRecherches.add("Patiente");
		listesRecherches.add("Nom");
		listesRecherches.add("Prenom");

		listesRecherches.add("Conjoint");
		listesRecherches.add("Tel");

		// listesRecherches.add("Ville");
		// listesRecherches.add("Clinique");
		// listesRecherches.add("Docteur");

		return listesRecherches;
	}

	public void triePatient() {

		ordre = "croissante";
		patientsView = new Cfclient_viewService().rechercherTriePatient(false,attributTri,
				ordre);
		RequestContext.getCurrentInstance().update("f1:patiente");
	}
	
	public void triePatientArchive() {

		ordreArchive = "croissante";

		 patientArchives = new Cfclient_viewService().rechercherTriePatient(true,attributTriArchive,
				ordreArchive);
		RequestContext.getCurrentInstance().update("f1:patiente");
	}

	public List<String> getListestris() {
		Listestris.clear();
		Listestris.add("Patiente");
		Listestris.add("Nom");
		Listestris.add("Prenom");
		// Listestris.add("Conjoint");
		// Listestris.add("Tel");
		Listestris.add("Nbr Consultation");
		Listestris.add("Dernier Consultation");
		// Listestris.add("Age");
		// Listestris.add("Code");

		return Listestris;
	}

	public void setListesRecherches(List<String> listesRecherches) {
		this.listesRecherches = listesRecherches;
	}

	private int nbConsultation;
	private int nbOrdonnance;
	private int nbAnalyse;
	private int nbRadios;
	private int nbAntecedentMed;
	private int nbCertif;
	private int nbLettre;
	private int nbContraception;
	private int nbGross;
	private int nbRDV;
	private int nbSterilite;
	private int nbAntecedentChir;
	private int nbAntecedentFam;

	private boolean afficheConsultation;
	private boolean afficheOrdonnance;
	private boolean afficheAnalyse;
	private boolean afficheRadios;
	private boolean afficheAntecedentMed;
	private boolean afficheCertif;
	private boolean afficheLettre;
	private boolean afficheContraception;
	private boolean afficheGross;
	private boolean afficheRDV;
	private boolean afficheSterilite;
	private boolean afficheAntecedentChir;
	private boolean afficheAntecedentFam;
	private boolean afficheHisto;
	private boolean afficheSalle;

	public boolean isAfficheConsultation() {
		return afficheConsultation;
	}

	public void setAfficheConsultation(boolean afficheConsultation) {
		this.afficheConsultation = afficheConsultation;
	}

	public boolean isAfficheOrdonnance() {
		return afficheOrdonnance;
	}

	public void setAfficheOrdonnance(boolean afficheOrdonnance) {
		this.afficheOrdonnance = afficheOrdonnance;
	}

	public boolean isAfficheAnalyse() {
		return afficheAnalyse;
	}

	public void setAfficheAnalyse(boolean afficheAnalyse) {
		this.afficheAnalyse = afficheAnalyse;
	}

	public boolean isAfficheRadios() {
		return afficheRadios;
	}

	public void setAfficheRadios(boolean afficheRadios) {
		this.afficheRadios = afficheRadios;
	}

	public boolean isAfficheAntecedentMed() {
		return afficheAntecedentMed;
	}

	public void setAfficheAntecedentMed(boolean afficheAntecedentMed) {
		this.afficheAntecedentMed = afficheAntecedentMed;
	}

	public boolean isAfficheCertif() {
		return afficheCertif;
	}

	public void setAfficheCertif(boolean afficheCertif) {
		this.afficheCertif = afficheCertif;
	}

	public boolean isAfficheLettre() {
		return afficheLettre;
	}

	public void setAfficheLettre(boolean afficheLettre) {
		this.afficheLettre = afficheLettre;
	}

	public boolean isAfficheContraception() {
		return afficheContraception;
	}

	public void setAfficheContraception(boolean afficheContraception) {
		this.afficheContraception = afficheContraception;
	}

	public boolean isAfficheGross() {
		return afficheGross;
	}

	public void setAfficheGross(boolean afficheGross) {
		this.afficheGross = afficheGross;
	}

	public boolean isAfficheRDV() {
		return afficheRDV;
	}

	public void setAfficheRDV(boolean afficheRDV) {
		this.afficheRDV = afficheRDV;
	}

	public boolean isAfficheSterilite() {
		return afficheSterilite;
	}

	public void setAfficheSterilite(boolean afficheSterilite) {
		this.afficheSterilite = afficheSterilite;
	}

	public boolean isAfficheAntecedentChir() {
		return afficheAntecedentChir;
	}

	public void setAfficheAntecedentChir(boolean afficheAntecedentChir) {
		this.afficheAntecedentChir = afficheAntecedentChir;
	}

	public boolean isAfficheAntecedentFam() {
		return afficheAntecedentFam;
	}

	public void setAfficheAntecedentFam(boolean afficheAntecedentFam) {
		this.afficheAntecedentFam = afficheAntecedentFam;
	}

	public int getNbConsultation() {
		return nbConsultation;
	}

	public void setNbConsultation(int nbConsultation) {
		this.nbConsultation = nbConsultation;
	}

	public int getNbOrdonnance() {
		return nbOrdonnance;
	}

	public void setNbOrdonnance(int nbOrdonnance) {
		this.nbOrdonnance = nbOrdonnance;
	}

	public int getNbAnalyse() {
		return nbAnalyse;
	}

	public void setNbAnalyse(int nbAnalyse) {
		this.nbAnalyse = nbAnalyse;
	}

	public int getNbRadios() {
		return nbRadios;
	}

	public void setNbRadios(int nbRadios) {
		this.nbRadios = nbRadios;
	}

	public int getNbAntecedentMed() {
		return nbAntecedentMed;
	}

	public void setNbAntecedentMed(int nbAntecedentMed) {
		this.nbAntecedentMed = nbAntecedentMed;
	}

	public int getNbCertif() {
		return nbCertif;
	}

	public void setNbCertif(int nbCertif) {
		this.nbCertif = nbCertif;
	}

	public int getNbLettre() {
		return nbLettre;
	}

	public void setNbLettre(int nbLettre) {
		this.nbLettre = nbLettre;
	}

	public int getNbContraception() {
		return nbContraception;
	}

	public void setNbContraception(int nbContraception) {
		this.nbContraception = nbContraception;
	}

	public int getNbGross() {
		return nbGross;
	}

	public void setNbGross(int nbGross) {
		this.nbGross = nbGross;
	}

	public int getNbRDV() {
		return nbRDV;
	}

	public void setNbRDV(int nbRDV) {
		this.nbRDV = nbRDV;
	}

	public int getNbSterilite() {
		return nbSterilite;
	}

	public void setNbSterilite(int nbSterilite) {
		this.nbSterilite = nbSterilite;
	}

	public int getNbAntecedentChir() {
		return nbAntecedentChir;
	}

	public void setNbAntecedentChir(int nbAntecedentChir) {
		this.nbAntecedentChir = nbAntecedentChir;
	}

	public int getNbAntecedentFam() {
		return nbAntecedentFam;
	}

	public void setNbAntecedentFam(int nbAntecedentFam) {
		this.nbAntecedentFam = nbAntecedentFam;
	}

	private Cfclient patient;

	public Cfclient getPatient() {
		return patient;
	}

	public void setPatient(Cfclient patient) {
		this.patient = patient;
	}

	public boolean isAfficheHisto() {
		return afficheHisto;
	}

	public void setAfficheHisto(boolean afficheHisto) {
		this.afficheHisto = afficheHisto;
	}

	public boolean isAfficheSalle() {
		return afficheSalle;
	}

	public void setAfficheSalle(boolean afficheSalle) {
		this.afficheSalle = afficheSalle;
	}

	public void initNb() {
		nbConsultation = 0;
		nbOrdonnance = 0;
		nbAnalyse = 0;
		nbRadios = 0;
		nbAntecedentMed = 0;
		nbCertif = 0;
		nbLettre = 0;
		nbContraception = 0;
		nbGross = 0;
		nbRDV = 0;
		nbSterilite = 0;
		nbAntecedentChir = 0;
		nbAntecedentFam = 0;

		afficheConsultation = false;
		afficheOrdonnance = false;
		afficheAnalyse = false;
		afficheRadios = false;
		afficheAntecedentMed = false;
		afficheCertif = false;
		afficheLettre = false;
		afficheContraception = false;
		afficheGross = false;
		afficheRDV = false;
		afficheSterilite = false;
		afficheAntecedentChir = false;
		afficheAntecedentFam = false;
		afficheHisto = false;
		afficheSalle = false;
	}

	public void Supprimer(Integer id) {

		
		// si sont code existe dans une autre tabel on ne le supprime pas
		patient = new CfclientService().RechercheCfclient(id);
		archive=patient.isArchive();
		initNb();
		boolean ok = true;
		// Consultationdetail
		 cons = new ConsultationDetailService()
				.rechercheToutConsultation(id);
		if (cons != null && cons.size() > 0) {
			ok = false;
			nbConsultation = cons.size();
			afficheConsultation = true;
		}

		// Ordonnance
		ords = new OrdonnanceService()
				.rechercheOrdonnanceParPatient(id);
		if (ords != null && ords.size() > 0) {
			ok = false;
			nbOrdonnance = ords.size();
			afficheOrdonnance = true;
		}
		//Analyse
		 a = new AnalyseDemandeeService()
				.rechercheAnalyseDemandeeParPatient(id);
		if (a != null && a.size() > 0) {
			ok = false;
			nbAnalyse = a.size();
			afficheAnalyse = true;
		}
		//Radio
				r = new RadioService()
						.rechercheRadioParIdPatient(id);
				
				if (r != null && r.size() > 0) {
					ok = false;
					nbRadios = r.size();
					afficheRadios = true;
				}
		// stérilité
		 ste = new SterileService().rechercheSterilePatient(id);
		if (ste != null) {
			ok = false;
			nbSterilite = 1;
			afficheSterilite = true;
		}

		// Contraception
		 cont = new ContraceptionService()
				.rechercheToutContraception(id);
		if (cont != null && cont.size() > 0) {
			ok = false;
			nbContraception = cont.size();
			afficheContraception = true;
		}

		// Rendez-vous
		rend = new RendezVousService().rechercheParPatient(id);
		if (rend != null && rend.size() > 0) {
			ok = false;
			nbRDV = rend.size();
			afficheRDV = true;
		}

		// antChir
		 antChir = new AntChirCfclientService()
				.rechercheAntChirParCfclient(id);
		if (antChir != null && antChir.size() > 0) {
			ok = false;
			nbAntecedentChir = antChir.size();
			afficheAntecedentChir = true;
		}

		// antMed
		 antMed = new AntMedCfclientService()
				.rechercheAntMedParCfclient(id);
		if (antMed != null && antMed.size() > 0) {
			ok = false;
			nbAntecedentMed = antMed.size();
			afficheAntecedentMed = true;
		}

		// antFam
	    antFam = new AntFamCfclientService()
				.rechercheAntFamParCfclient(id);
		if (antFam != null && antFam.size() > 0) {
			ok = false;
			nbAntecedentFam = antFam.size();
			afficheAntecedentFam = true;
		}

		// historiqueCertif
		 histoCert = new HistoriqueCertifService()
				.rechercheTousHistoriqueCertifByPatient(id);
		if (histoCert != null && histoCert.size() > 0) {
			ok = false;
			nbCertif = histoCert.size();
			afficheCertif = true;
		}

		// historiqueLettres
		histoLett = new historiqueLettreService()
				.rechercheTousHistoriqueLettre(id);
		if (histoLett != null && histoLett.size() > 0) {
			ok = false;
			nbLettre = histoLett.size();
			afficheLettre = true;
		}

		// historiqueGross
		histoGross = new HistoriqueGrossService()
				.rechercheToutHistoriqueGross(id);
		if (histoGross != null && histoGross.size() > 0) {

			ok = false;
			nbGross = histoGross.size();
			afficheGross = true;
		}
		if (!ok)
			afficheHisto = true;

		// salle
		 s = new SalleService().rechercheSalleParPatient(id);
		if (s != null) {
			ok = false;
			afficheSalle = true;
		}

		if (ok) {
			RequestContext.getCurrentInstance().update(
					"f1:formulaire:idSupprimer");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('supprimer').show();");

		} else {

			// ouvrir le dialog de détail
			RequestContext.getCurrentInstance().update(
					"f1:formulaire:idSuppression");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('suppression').show();");

		}

	}
	
	
	public void supprimPatiente() {
		// la suppression avec aucun lien avec d'autres table
		FacesContext face = FacesContext.getCurrentInstance();
		new CfclientService().supprimerPatient(patient.getCode());
		blocage = false;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Patiente supprimée avec succés"));

		if(!archive){
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}else{
			FacesContext context2 = FacesContext.getCurrentInstance();
			context2.getExternalContext().getFlash().setKeepMessages(true);
			try {
				context2.getExternalContext().redirect("PatientArchive");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
		

	public void supprimPatientCascad() {
		
		
		// la suppression cascade
		
		if (afficheOrdonnance) {
			
			if (ords != null && ords.size() > 0) {
				for (int i = 0; i < ords.size(); i++) {// supprimer les lignes
														// de l'ordonnance
					List<MedOrd> l = new MedOrdService().rechercheParIdOrd(ords
							.get(i).getIdOrdonnance());
					for (int j = 0; j < l.size(); j++) {
						new MedOrdService().supprimerMedOrd(l.get(j)
								.getIdMedOrd());
					}
					// supprimer l'ordonnance
					new OrdonnanceService().supprimerOrdonnance(ords.get(i)
							.getIdOrdonnance());
				}
			}
		}
		
		
		if (afficheRadios) {
			
			if (r != null && r.size() > 0) {
				for (int i = 0; i < r.size(); i++){
					new RadioService().supprimerRadio(r.get(i).getIdradio());
					}
			}
		}
		if (afficheAnalyse) {
			if (a != null && a.size() > 0) {
				for (int i = 0; i < a.size(); i++)
					new AnalyseDemandeeService().supprimerAnalyseDemandee(a.get(i)
							.getIdanalyseDemandee());
			}
		}
		if (afficheCertif) {
			 
			if (histoCert != null && histoCert.size() > 0) {
				for (int i = 0; i < histoCert.size(); i++)
					new HistoriqueCertifService().supprimerHistoriqueCertif(histoCert
							.get(i).getIdHistoriqueCertif());
			}

		}
		if (afficheLettre) {
						if ( histoLett != null && histoLett.size() > 0) {
				for (int i = 0; i < histoLett.size(); i++)
					new historiqueLettreService().supprimerHistoriqueLettre(histoLett
							.get(i).getIdHistoriquelettre());
			}
		}
		
		if(afficheGross){
			
			if (histoGross != null && histoGross.size() > 0) {
				for (int i = 0; i < histoGross.size(); i++)
					new HistoriqueGrossService().supprimerHistoriqueGross(histoGross
							.get(i).getIdhistoriqueGross());
			}
		}
		
		
		if (afficheConsultation) {
			
			for (int i = 0; i < cons.size(); i++){
				new ConsultationDetailService()
						.supprimerConsultationDetail(cons.get(i));
				
			}
		}
		if (afficheSterilite) {
			
			if (ste != null)
				new SterileService().supprimerSterile(ste);
		}
       if (afficheContraception) {
			
			if (cont != null && cont.size() > 0)
				for (int i = 0; i < cont.size(); i++)
					new ContraceptionService().supprimerContraception(cont.get(i)
							.getIdcontraception());
		}
		
		if (afficheRDV) {
			
			if (rend != null && rend.size() > 0)
				for (int i = 0; i < rend.size(); i++)
					new RendezVousService().supprimerRendezVous(rend.get(i)
							.getIdrendezVous());
		}
		if (afficheAntecedentChir) {
			
			if (antChir != null && antChir.size() > 0) {
				for (int i = 0; i < antChir.size(); i++)
					new AntChirCfclientService().supprimerAntChirCfclient(antChir
							.get(i).getIdantchircfclient());
			}

		}
		if (afficheAntecedentFam) {
			
			if (antFam != null && antFam.size() > 0) {
				for (int i = 0; i < antFam.size(); i++)
					new AntFamCfclientService().supprimerAntFamCfclient(antFam
							.get(i).getIdantfamcfclient());
			}

		}
		if (afficheAntecedentMed) {
			
			if (antMed != null && antMed.size() > 0) {
				for (int i = 0; i < antMed.size(); i++)
					new AntMedCfclientService().supprimerAntMedCfclient(antMed
							.get(i).getIdantmedcfclient());
			}
		}
		if (afficheSalle) {
			
			if (s != null) {
				int ordre = s.getOrdre();
				String motif = s.getMotif();
				new SalleService().supprimerSalle(s);
				SalleService sl = new SalleService();

				if (motif.equals("Telephone")) {
					List<Salle> sallesAvecJointureTel = sl
							.rechercheSalleAvecMotif("Telephone");
					if (sallesAvecJointureTel != null
							&& sallesAvecJointureTel.size() > 0)
						for (int i = 0; i < sallesAvecJointureTel.size(); i++) {
							if (sallesAvecJointureTel.get(i).getOrdre() > ordre) {
								sallesAvecJointureTel.get(i)
										.setOrdre(
												sallesAvecJointureTel.get(i)
														.getOrdre() - 1);
								new SalleService()
										.modifierSalle(sallesAvecJointureTel
												.get(i));
							}
						}
				} else {
					List<Salle> sallesAvecJointure = sl
							.rechercheAvecJointureSalle("cfclient");
					if (sallesAvecJointure != null
							&& sallesAvecJointure.size() > 0)
						for (int i = 0; i < sallesAvecJointure.size(); i++) {
							if (sallesAvecJointure.get(i).getOrdre() > ordre) {
								sallesAvecJointure.get(i)
										.setOrdre(
												sallesAvecJointure.get(i)
														.getOrdre() - 1);
								new SalleService()
										.modifierSalle(sallesAvecJointure
												.get(i));
							}
						}
				}
			}
		}

		// suppression de la patiente
		CfclientService ser=new CfclientService();
		ser.supprimerPatient(patient.getCode());
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2 .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Patiente supprimée avec succés"));
		
		if(!archive){
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}else{
			
			context2.getExternalContext().getFlash().setKeepMessages(true);
			try {
				context2.getExternalContext().redirect("PatientArchive");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	
	public void supprimPatienteArchi() {
		// la suppression avec aucun lien avec d'autres table
		FacesContext face = FacesContext.getCurrentInstance();
		new CfclientService().supprimerPatient(patient.getCode());
		blocage = false;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Patiente supprimée avec succés"));

		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("PatientArchive");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void supprimPatientCascadArchi() {
		
		
		// la suppression cascade
		
		if (afficheOrdonnance) {
			
			if (ords != null && ords.size() > 0) {
				for (int i = 0; i < ords.size(); i++) {// supprimer les lignes
														// de l'ordonnance
					List<MedOrd> l = new MedOrdService().rechercheParIdOrd(ords
							.get(i).getIdOrdonnance());
					for (int j = 0; j < l.size(); j++) {
						new MedOrdService().supprimerMedOrd(l.get(j)
								.getIdMedOrd());
					}
					// supprimer l'ordonnance
					new OrdonnanceService().supprimerOrdonnance(ords.get(i)
							.getIdOrdonnance());
				}
			}
		}
		if (afficheRadios) {
			List<Radio> r = new RadioService().rechercheRadioParIdPatient(patient
					.getCode());
			if (r != null && r.size() > 0) {
				for (int i = 0; i < r.size(); i++)
					new RadioService().supprimerRadio(r.get(i).getIdradio());
			}
		}
		if (afficheAnalyse) {
			List<AnalyseDemandee> a = new AnalyseDemandeeService()
					.rechercheAnalyseDemandeeParPatient(patient.getCode());
			if (a != null && a.size() > 0) {
				for (int i = 0; i < a.size(); i++)
					new AnalyseService().supprimerAnalyse(a.get(i)
							.getIdanalyseDemandee());
			}
		}
		if (afficheCertif) {
			
			if (histoCert != null && histoCert.size() > 0) {
				for (int i = 0; i < histoCert.size(); i++)
					new HistoriqueCertifService().supprimerHistoriqueCertif(histoCert
							.get(i).getIdHistoriqueCertif());
			}

		}
		if (afficheLettre) {
			List<historiqueLettre> l = new historiqueLettreService()
					.rechercheTousHistoriqueLettre(patient.getCode());
			if (l != null && l.size() > 0) {
				for (int i = 0; i < l.size(); i++)
					new historiqueLettreService().supprimerHistoriqueLettre(l
							.get(i).getIdHistoriquelettre());
			}
		}
		
		if(afficheGross){
			List<HistoriqueGross> histoGross = new HistoriqueGrossService()
			.rechercheToutHistoriqueGross(patient.getCode());
			if (histoGross != null && histoGross.size() > 0) {
				for (int i = 0; i < histoGross.size(); i++)
					new HistoriqueGrossService().supprimerHistoriqueGross(histoGross
							.get(i).getIdhistoriqueGross());
			}
		}
		
		if (afficheConsultation) {
			
			for (int i = 0; i < cons.size(); i++)
				new ConsultationDetailService()
						.supprimerConsultationDetail(cons.get(i));
		}
		if (afficheSterilite) {
			
			if (ste != null)
				new SterileService().supprimerSterile(ste);
		}
		if (afficheRDV) {
			List<RendezVous> r = new RendezVousService()
					.rechercheParPatient(patient.getCode());
			if (r != null && r.size() > 0)
				for (int i = 0; i < r.size(); i++)
					new RendezVousService().supprimerRendezVous(r.get(i)
							.getIdrendezVous());
		}
		if (afficheAntecedentChir) {
			List<AntChirCfclient> a = new AntChirCfclientService()
					.rechercheAntChirParCfclient(patient.getCode());
			if (a != null && a.size() > 0) {
				for (int i = 0; i < a.size(); i++)
					new AntChirCfclientService().supprimerAntChirCfclient(a
							.get(i).getIdantchircfclient());
			}

		}
		if (afficheAntecedentFam) {
			List<AntFamCfclient> a = new AntFamCfclientService()
					.rechercheAntFamParCfclient(patient.getCode());
			if (a != null && a.size() > 0) {
				for (int i = 0; i < a.size(); i++)
					new AntFamCfclientService().supprimerAntFamCfclient(a
							.get(i).getIdantfamcfclient());
			}

		}
		if (afficheAntecedentMed) {
			List<AntMedCfclient> a = new AntMedCfclientService()
					.rechercheAntMedParCfclient(patient.getCode());
			if (a != null && a.size() > 0) {
				for (int i = 0; i < a.size(); i++)
					new AntMedCfclientService().supprimerAntMedCfclient(a
							.get(i).getIdantmedcfclient());
			}
		}
		if (afficheSalle) {
			Salle s = new SalleService().rechercheSalleParPatient(patient
					.getCode());
			if (s != null) {
				int ordre = s.getOrdre();
				String motif = s.getMotif();
				new SalleService().supprimerSalle(s);
				SalleService sl = new SalleService();

				if (motif.equals("Telephone")) {
					List<Salle> sallesAvecJointureTel = sl
							.rechercheSalleAvecMotif("Telephone");
					if (sallesAvecJointureTel != null
							&& sallesAvecJointureTel.size() > 0)
						for (int i = 0; i < sallesAvecJointureTel.size(); i++) {
							if (sallesAvecJointureTel.get(i).getOrdre() > ordre) {
								sallesAvecJointureTel.get(i)
										.setOrdre(
												sallesAvecJointureTel.get(i)
														.getOrdre() - 1);
								new SalleService()
										.modifierSalle(sallesAvecJointureTel
												.get(i));
							}
						}
				} else {
					List<Salle> sallesAvecJointure = sl
							.rechercheAvecJointureSalle("cfclient");
					if (sallesAvecJointure != null
							&& sallesAvecJointure.size() > 0)
						for (int i = 0; i < sallesAvecJointure.size(); i++) {
							if (sallesAvecJointure.get(i).getOrdre() > ordre) {
								sallesAvecJointure.get(i)
										.setOrdre(
												sallesAvecJointure.get(i)
														.getOrdre() - 1);
								new SalleService()
										.modifierSalle(sallesAvecJointure
												.get(i));
							}
						}
				}
			}
		}

		// suppression de la patiente
		new CfclientService().supprimerPatient(patient.getCode());
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("PatientArchive");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	
	
	
	
	
	
	public void ajout() {
		setAction("Ajout");
		action = "Ajout";
		index = 0;
		
	}

	public void ajoutDoublet() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesContext face = FacesContext.getCurrentInstance();
		boolean addValid = false;
		Cfclient cl = new Cfclient();
		String date = jj + "/" + mm + "/" + aaaa;// contient le date
		String dateC;

		if ((jjC == null) || (mmC == null) || (aaaaC == null)) {
			dateC = null;
		} else {
			dateC = jjC + "/" + mmC + "/" + aaaaC;// contient le
			// date
		}
		cl.setPrefix(prefix);
		cl.setAghbs(aghbs);
		cl.setGlycemie(glycemie);
		cl.setCategorie(categorie);
		cl.setCategoriEtoile(categorieEtoile);
		cl.setNom(nom);

		cl.setPrenom(prenom);
		cl.setDateNaiss(date);
		cl.setDateNaissC(dateC);
		if (idprofessionByProfessp != null) {
			Profession profp = new Profession();
			profp.setIdprofession(idprofessionByProfessp);
			cl.setProfessionByProfessp(profp);
		}

		if (idprofessionByProfesscp != null) {
			Profession profc = new Profession();
			profc.setIdprofession(idprofessionByProfesscp);
		}
		cl.setProfessionP(professionP);
		cl.setAssurance1(assurance1);
		cl.setAssurance2(assurance2);
		cl.setCnss(cnss);// CNAM
		cl.setPays(pays);

		if (idville != null) // teste si le liste ville n'est pas
		// selectionner
		{
			Ville v = new Ville();
			v.setIdville(idville);
			cl.setVille(v);
		}
		cl.setVillage(village);
		cl.setCodePost(codePost);
		cl.setRue(rue);
		cl.setTelephone(telephone);
		cl.setTelephone2(telephone2);
		cl.setGsm1(gsm1);
		cl.setGsm2(gsm2);
		cl.seteMailP(eMailP);
		cl.setNomC(nomC);
		cl.setPrenomC(prenomC);
		if (profc != null) {
			Profession profc = new Profession();
			profc.setIdprofession(idprofessionByProfesscp);
			cl.setProfessionByProfesscp(profc);
		}
		cl.setProfessionC(professionC);
		cl.setTelC(telC);
		cl.setGsmC(gsmC);
		cl.seteMailC(eMailC);
		cl.setTaille(taille);
		cl.setPoids(poids);
		cl.setGs(gs);
		cl.setRh(rh);
		cl.setAllergie(allergie);

		if (idclinique != null) {
			Clinique c = new Clinique();
			c.setIdclinique(idclinique);
			cl.setClinique(c);
		}

		if (iddoctor != null) {
			Docteur d = new Docteur();
			d.setIddoctor(iddoctor);
			cl.setDoctor(d);
		}

		cl.setDernierVisite(dernierVisite);

		CfclientService ser = new CfclientService();

		cl.setDernierVisite("Nouveau");
		ser.ajoutPatient(cl);
		addValid = true;
		this.blocage = false;
		tempsface = 2500;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Patiente ajouté avec succés"));

		initialisation();
		RequestContext.getCurrentInstance().update("f1");
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		context.addCallbackParam("addValid", addValid);

	}

	public void ajouter() {
		RequestContext context = RequestContext.getCurrentInstance();
		Boolean b = true;
		Boolean conj = true;

		boolean addValid = false;

		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		FacesContext face = FacesContext.getCurrentInstance();

		Cfclient cl = new Cfclient();

		if (nom == null || (nom.trim().length() == 0)) {
			addValid = false;
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur", "Veulliez donner le nom de la patiente"));
		}

		if (prenom == null || (prenom.trim().length() == 0)) {
			addValid = false;
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur", "Veulliez donner le prenom de la patiente"));
		}

		if (jj == null || mm == null || aaaa == null || jj.equals("")
				|| mm.equals("") || aaaa.equals("")) {

			addValid = false;
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur",
					"Veulliez donner la date de naissance de la patiente"));
		}

		if (eMailP != null && eMailP.trim().length() > 0)
			b = eMailP.matches(EMAIL_REGEX);

		if (!b) {
			addValid = false;
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Format email patiente invalide", "Invalid credentials"));
		}
		if (eMailC != null && eMailC.trim().length() > 0)
			conj = eMailC.matches(EMAIL_REGEX);

		if (!conj) {
			addValid = false;
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Format email conjoint invalide", "Invalid credentials"));
		}

		String date = jj + "/" + mm + "/" + aaaa;// contient le date
		String dateC;
		if (face.getMessageList().size() == 0) {

			if (action.equals("Ajout")) {
				// test de l'unicité

				CfclientService serc = new CfclientService();
				List<Cfclient> listPatient = serc.RechercheCfclient(nom,
						prenom, date);
				if (listPatient != null && listPatient.size() > 0) {
					RequestContext.getCurrentInstance().execute(
							"PF('confirmDlg').show();");
					addValid = false;
				} else {

					if ((jjC == null) || (mmC == null) || (aaaaC == null)) {
						dateC = null;
					} else {
						dateC = jjC + "/" + mmC + "/" + aaaaC;// contient le
																// date
					}

					cl.setCategoriEtoile(categorieEtoile);
					cl.setNom(nom);
					cl.setPrefix(prefix);
					cl.setAghbs(aghbs);
					cl.setGlycemie(glycemie);
					cl.setCategorie(categorie);
					cl.setNomprenom(nom + " " + prenom);
					cl.setPrenomnom(prenom + " " + nom);
					cl.setPrenomNomConjoint(prenom + " " + nomC);
					cl.setPrenom(prenom);
					cl.setDateNaiss(date);
					cl.setDateNaissC(dateC);
					if (idprofessionByProfessp != null) {
						Profession profp = new Profession();
						profp.setIdprofession(idprofessionByProfessp);
						cl.setProfessionByProfessp(profp);
					}

					if (idprofessionByProfesscp != null) {
						Profession profc = new Profession();
						profc.setIdprofession(idprofessionByProfesscp);
						cl.setProfessionByProfesscp(profc);
					}
					cl.setProfessionP(professionP);
					cl.setAssurance1(assurance1);
					cl.setAssurance2(assurance2);
					cl.setCnss(cnss);// CNAM
					cl.setPays(pays);

					if (idville != null) // teste si le liste ville n'est pas
											// selectionner
					{
						Ville v = new Ville();
						v.setIdville(idville);
						cl.setVille(v);
					}
					cl.setVillage(village);
					cl.setCodePost(codePost);
					cl.setRue(rue);
					cl.setTelephone(telephone);
					cl.setTelephone2(telephone2);
					cl.setGsm1(gsm1);
					cl.setGsm2(gsm2);
					cl.seteMailP(eMailP);
					cl.setNomC(nomC);
					cl.setPrenomC(prenomC);
					if (profc != null) {
						Profession profc = new Profession();
						profc.setIdprofession(idprofessionByProfesscp);
						cl.setProfessionByProfesscp(profc);
					}
					cl.setProfessionC(professionC);
					cl.setTelC(telC);
					cl.setGsmC(gsmC);
					cl.seteMailC(eMailC);
					cl.setTaille(taille);
					cl.setPoids(poids);
					cl.setGs(gs);
					cl.setRh(rh);
					cl.setAllergie(allergie);

					if (idclinique != null) {
						Clinique c = new Clinique();
						c.setIdclinique(idclinique);
						cl.setClinique(c);
					}

					if (iddoctor != null) {
						Docteur d = new Docteur();
						d.setIddoctor(iddoctor);
						cl.setDoctor(d);
					}

					cl.setDernierVisite(dernierVisite);

					CfclientService ser = new CfclientService();

					cl.setDernierVisite("Nouveau");
					ser.ajoutPatient(cl);
					addValid = true;
					blocage = false;
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Patiente ajouté avec succés"));
					init();
					RequestContext.getCurrentInstance().update("f1");
					action = ""; 
				}
			} else if (action.equals("Modification")) {
				if ((jjC == null) || (mmC == null) || (aaaaC == null)) {
					dateC = null;
				} else {
					dateC = jjC + "/" + mmC + "/" + aaaaC;// contient le date
				}
				cl.setNom(nom);
				cl.setPrefix(prefix);
				cl.setAghbs(aghbs);
				cl.setGlycemie(glycemie);
				cl.setCategoriEtoile(categorieEtoile);
				cl.setCategorie(categorie);
				cl.setPrenom(prenom);
				cl.setDateNaiss(date);
				cl.setDateNaissC(dateC);
				cl.setNomprenom(nom + " " + prenom);
				cl.setPrenomNomConjoint(prenom + " " + nomC);
				cl.setPrenomnom(prenom + " " + nom);
				if (idprofessionByProfessp != null) {
					Profession profp = new Profession();
					profp.setIdprofession(idprofessionByProfessp);
					cl.setProfessionByProfessp(profp);
				}

				if (idprofessionByProfesscp != null) {
					Profession profc = new Profession();
					profc.setIdprofession(idprofessionByProfesscp);
					cl.setProfessionByProfesscp(profc); 
				}
				cl.setProfessionP(professionP);
				cl.setAssurance1(assurance1);
				cl.setAssurance2(assurance2);
				cl.setCnss(cnss);// CNAM
				cl.setPays(pays);

				if (idville != null) // teste si le liste ville n'est pas
										// selectionner
				{
					Ville v = new Ville();
					v.setIdville(idville);
					cl.setVille(v);
				}
				cl.setVillage(village);
				cl.setCodePost(codePost);
				cl.setRue(rue);
				cl.setTelephone(telephone);
				cl.setTelephone2(telephone2);
				cl.setGsm1(gsm1);
				cl.setGsm2(gsm2);
				cl.seteMailP(eMailP);
				cl.setNomC(nomC);
				cl.setPrenomC(prenomC);
				if (profc != null) {
					Profession profc = new Profession();
					profc.setIdprofession(idprofessionByProfesscp);
					cl.setProfessionByProfesscp(profc);
				}
				cl.setProfessionC(professionC);
				cl.setTelC(telC);
				cl.setGsmC(gsmC);
				cl.seteMailC(eMailC);
				cl.setTaille(taille);
				cl.setPoids(poids);
				cl.setGs(gs);
				cl.setRh(rh);
				cl.setAllergie(allergie);

				if (idclinique != null) {
					Clinique c = new Clinique();
					c.setIdclinique(idclinique);
					cl.setClinique(c);
				}

				if (iddoctor != null) {
					Docteur d = new Docteur();
					d.setIddoctor(iddoctor);
					cl.setDoctor(d);
				}

				cl.setDernierVisite(dernierVisite);

				CfclientService ser = new CfclientService();

				cl.setCode(code);
				ser.modifierPatient(cl);
				addValid = true;
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Patiente modifié avec succés"));
				initialisation();
				init();
				RequestContext.getCurrentInstance().update("f1");

				action = "";
			}
		}

		

		context.addCallbackParam("addValid", addValid);
	}

	@SuppressWarnings("deprecation")
	public void info(Integer  idc) {
		Cfclient c= new Cfclient();
		CfclientService ser= new CfclientService();
		 c= ser.RechercheCfclientAvecId(idc);
		indexInfo = 0;
		code = c.getCode();
		nom = c.getNom();
		prefix = c.getPrefix();
		categorie = c.getCategorie();
		categorieEtoile = c.getCategoriEtoile();
		aghbs = c.getAghbs();
		glycemie = c.getGlycemie();
		prenom = c.getPrenom();
		cnss = c.getCnss();// CNAM
		assurance1 = c.getAssurance1();
		assurance2 = c.getAssurance2();

		pays = c.getPays();
		codePost = c.getCodePost();
		rue = c.getRue();
		telephone = c.getTelephone();
		telephone2 = c.getTelephone2();
		gsm1 = c.getGsm1();
		gsm2 = c.getGsm2();
		eMailP = c.geteMailP();

		nomC = c.getNomC();
		prenomC = c.getPrenomC();
		telC = c.getTelC();
		gsmC = c.getGsmC();
		eMailC = c.geteMailC();
		dernierVisite = c.getDernierVisite();
		taille = c.getTaille();
		poids = c.getPoids();
		gs = c.getGs();
		rh = c.getRh();
		allergie = c.getAllergie();
		if (professionP != null)
			professionP = c.getProfessionP();
		else
			professionP=null;
		if (professionC != null)
			professionC = c.getProfessionC();
		else
			professionC =null;
		village = c.getVillage();
		dateNaiss = c.getDateNaiss();
		if (dateNaiss != null) {
			String[] t = dateNaiss.split("/");
			jj = t[0];
			mm = t[1];
			aaaa = Integer.parseInt(t[2]);
		}

		age = calculAgeEnAns(dateNaiss);

		dateNaissC = c.getDateNaissC();
		if (dateNaissC != null) {
			String[] tC = dateNaissC.split("/");
			jjC = tC[0];
			mmC = tC[1];
			aaaaC = Integer.parseInt(tC[2]);
		}
		if (c.getDoctor() != null) {
			iddoctor = c.getDoctor().getIddoctor();
			docLib = c.getDoctor().getLibdoctor();
		}
		if (c.getVille() != null) {
			idville = c.getVille().getIdville();
			vil = c.getVille().getVille();
		}

		if (c.getProfessionByProfesscp() != null) {
			idprofessionByProfesscp = c.getProfessionByProfesscp()
					.getIdprofession();
			profc = c.getProfessionByProfesscp().getLibprofession();
		}
		
		
		if (c.getProfessionByProfessp() != null) {
			idprofessionByProfessp = c.getProfessionByProfessp()
					.getIdprofession();
			profession = c.getProfessionByProfessp().getLibprofession();
		}
		if (c.getClinique() != null) {
			idclinique = c.getClinique().getIdclinique();
			libClin = c.getClinique().getLibclinique();
		}
		Date v = new Date();
		int h = v.getHours() + 1;
		int min = v.getMinutes();

		heure = avoirHeure(h, min);

		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogInfo').show();");

	}

	@SuppressWarnings("deprecation")
	public void recupererDonnees(Integer  idPat) {
		Cfclient c= new Cfclient();
		CfclientService ser= new CfclientService();
		 c= ser.RechercheCfclientAvecId(idPat);
		
		code = c.getCode();
		index = 0;
		nom = c.getNom();
		prefix = c.getPrefix();
		categorie = c.getCategorie();
		categorieEtoile = c.getCategoriEtoile();
		aghbs = c.getAghbs();
		glycemie = c.getGlycemie();
		prenom = c.getPrenom();
		cnss = c.getCnss();// CNAM
		assurance1 = c.getAssurance1();
		assurance2 = c.getAssurance2();

		pays = c.getPays();
		codePost = c.getCodePost();
		rue = c.getRue();
		telephone = c.getTelephone();
		telephone2 = c.getTelephone2();
		gsm1 = c.getGsm1();
		gsm2 = c.getGsm2();
		eMailP = c.geteMailP();

		nomC = c.getNomC();
		prenomC = c.getPrenomC();
		telC = c.getTelC();
		gsmC = c.getGsmC();
		eMailC = c.geteMailC();
		dernierVisite = c.getDernierVisite();
		taille = c.getTaille();
		poids = c.getPoids();
		gs = c.getGs();
		rh = c.getRh();
		allergie = c.getAllergie();
		if (professionP != null)
			professionP = c.getProfessionP();
		if (professionC != null)
			professionC = c.getProfessionC();
		village = c.getVillage();
		dateNaiss = c.getDateNaiss();
		if (dateNaiss != null) {
			String[] t = dateNaiss.split("/");
			jj = t[0];
			mm = t[1];
			aaaa = Integer.parseInt(t[2]);
		}

		dateNaissC = c.getDateNaissC();
		if (dateNaissC != null) {
			String[] tC = dateNaissC.split("/");
			jjC = tC[0];
			mmC = tC[1];
			aaaaC = Integer.parseInt(tC[2]);
		}
		if (c.getDoctor() != null) {
			iddoctor = c.getDoctor().getIddoctor();
			docLib = c.getDoctor().getLibdoctor();
		}
		if (c.getVille() != null) {
			idville = c.getVille().getIdville();
			vil = c.getVille().getVille();
		}

		if (c.getProfessionByProfesscp() != null) {
			idprofessionByProfesscp = c.getProfessionByProfesscp()
					.getIdprofession();
			profc = c.getProfessionByProfesscp().getLibprofession();
		}
		if (c.getProfessionByProfessp() != null) {
			idprofessionByProfessp = c.getProfessionByProfessp()
					.getIdprofession();
			profession = c.getProfessionByProfessp().getLibprofession();
		}
		if (c.getClinique() != null) {
			idclinique = c.getClinique().getIdclinique();
			libClin = c.getClinique().getLibclinique();
		}
		Date v = new Date();
		int h = v.getHours() + 1;
		int min = v.getMinutes();

		heure = avoirHeure(h, min);
		action = "Modification";

		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgValidation').show();");

	}

	public void lePatient(Integer c) {
		// Module.idpatient = c;

		//création d'une nouvelle sesseion
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", c);
	//  HttpServletRequest request=null ;
	//	HttpSession session= request.getSession(true);
		session.setAttribute("retouraction", "Patients");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void versFiche(Integer c){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", c);

		session.setAttribute("retouraction", "Rendez-Vous");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void hideDialog() {
		initialisation();
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlg1').hide();");
	}
public void initialeSalle()
{
	code = null;
	nom = null;
	prenom=null;
	prefix=null;
	dernierVisite=null;
	motif=null;
	heure=null;
	RequestContext.getCurrentInstance().update(":f1:formulaire:idDlgsalle");

}
	public void initialisation() {
		code = null;
		nom = null;
		prefix = null;
		categorie = null;
		aghbs = null;
		glycemie = null;
		prenom = null;
		cnss = null;// CNAM
		assurance1 = null;
		assurance2 = null;
		categorieEtoile = "etoileMoyen";
		pays = null;
		codePost = null;
		rue = null;
		telephone = null;
		telephone2 = null;
		gsm1 = null;
		gsm2 = null;
		eMailP = null;

		nomC = null;
		prenomC = null;
		telC = null;
		gsmC = null;
		eMailC = null;

		taille = null;
		poids = null;
		gs = null;
		rh = null;
		allergie = null;

		dernierVisite = null;

		// initilialiser les listes vides

		jj = null;
		aaaa = null;
		mm = null;
		idprofessionByProfesscp = null;
		idville = null;
		idclinique = null;
		idprofessionByProfesscp = null;
		iddoctor = null;
		idprofessionByProfessp = null;
		jjC = null;
		mmC = null;
		aaaaC = null;
		profc = null;
		docLib = null;
		libClin = null;
		vil = null;
		profession = null;
		professionP = null;
		professionC = null;
		village = null;
		allergie = null;
		notes = null;
		// initilialiser les listes vides

	}

	private String dateRdv;

	public String getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(String dateRdv) {
		this.dateRdv = dateRdv;
	}

	private boolean aRDV;

	public boolean isaRDV() {
		return aRDV;
	}

	public void setaRDV(boolean aRDV) {
		this.aRDV = aRDV;
	}

	@SuppressWarnings("deprecation")
	public void initVersSalle(Integer idpatient) {
		Cfclient patient= new Cfclient();
		CfclientService cfSer= new CfclientService();
		patient= cfSer.RechercheCfclientSansjointure(idpatient);
		code = patient.getCode();
		
		nom = patient.getNom();
		prenom = patient.getPrenom();
		SalleService serv = new SalleService();
		Salle sal = serv.rechercheSalleParPatient(code);
		if (sal == null) {
			prefix = patient.getPrefix();
		
			dernierVisite = patient.getDernierVisite();
			motif = null;
			Date v = new Date();
			String lheure = v.toLocaleString().substring(
					v.toLocaleString().lastIndexOf(" ") + 1,
					v.toLocaleString().lastIndexOf(" ") + 6);
			heure = lheure;

			// verifier si cette patiente a un RDV
			aRDV = false;
			// tester si cette patiente a RDV ce jour ou dans des jours
			// antérieurs
			List<RendezVous> lRdv = new RendezVousService()
					.rechercheRDVParPatient(patient.getCode(), new Date());
			if (lRdv != null && lRdv.size() > 0) {
				aRDV = true;
				dateRdv = lRdv.get(0).getDate().toLocaleString();

			}
			RequestContext.getCurrentInstance().update(
					":f1:formulaire:idDlgsalle");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgsalle').show();");                 
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention!",
							"" + prenom + " " + nom
									+ " déja dans la salle d'attente"));
			initialeSalle();

		}
	
		
	}

	private RendezVous rdv;

	public RendezVous getRdv() {
		return rdv;
	}

	public void setRdv(RendezVous rdv) {
		this.rdv = rdv;
	}

	public void versSalleAttente() {

		FacesContext face = FacesContext.getCurrentInstance();
		List<TabSalle> tsList= new ArrayList<TabSalle>();
		List<String> motifsList= new ArrayList<String>();
		TabSalleService ser= new TabSalleService();
		boolean addValid = false;
		CfclientService se = new CfclientService();
		Cfclient cl = se.RechercheCfclient(code);
		boolean ordrDiff;
	
		tsList=ser.rechercheParOrdDiff(false);//list tabsalle while orddiff==false
		for(int i=0; i<tsList.size();i++){
			
			motifsList.add(tsList.get(i).getNomTab());
		}
		
		RequestContext context2 = RequestContext.getCurrentInstance();
		if (motif != null && motif.length() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			
			if(motifsList.contains(motif)){
				ordrDiff=false;
			}else{
				ordrDiff=true;
			}

			Salle s = new Salle();
			s.setMotif(motif);
			s.setHeure(heure);
			s.setNotes(notes);

			s.setCfclient(cl);

			new SalleService().ajouterSalle(s, motif,tsList,ordrDiff);
			blocage = false;
			// si elle a un Rdv changer l'état
			List<RendezVous> lRdv = new RendezVousService()
					.rechercheRDVParPatient(cl.getCode(), new Date());
			if (lRdv != null && lRdv.size() > 0) {
				rdv = lRdv.get(0);
				RequestContext ctxt = RequestContext.getCurrentInstance();
				ctxt.execute("PF('descision').show();");
			}

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Patiente ajoutée à la salle d'attente avec succès."));
			context.getExternalContext().getFlash().setKeepMessages(true);

			addValid = true;

			initialeSalle();
			RequestContext.getCurrentInstance().update(":f1:formulaire:idDlgsalle,:f1:growl");

		} else {
			addValid = false;
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"",  "Veuillez choisir un type du salle d'attente"));
			
		}

		context2.addCallbackParam("addValid", addValid);

	}

	private String avoirHeure(int h, int min) {
		String heure = "";
		if (h < 9)
			heure += "0" + h;
		else
			heure += h;

		if (min < 9)
			heure += ":0" + min;
		else
			heure += ":" + min;

		return heure;
	}

	public String versAntecedent(Integer code) {
		return "anteced";
	}

	public String calculAge(String date) {
		if (date != null) {
			return Module.age(date);

		} else {
			Date toDay = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			String DateDuJour = sf.format(toDay);

			return Module.age(DateDuJour);
		}
	}

	// public int nbrConslt(Integer idPatient) {
	// if (idPatient != null) {
	// CfclientService sr = new CfclientService();
	// Cfclient cl = sr.RechercheCfclient(idPatient);
	// nbCons = cl.getNbCons();
	//
	// } else {
	// nbCons = 0;
	// }
	// return (nbCons);
	// }

	public String typeConslt(Integer idPatient) {
		if (idPatient != null) {
			CfclientService sr = new CfclientService();
			Cfclient cl = sr.RechercheCfclient(idPatient);
			typCons = cl.getTypCons();

		} else
			typCons = "";
		return (typCons);
	}

	public void annulerRecherche() {
		// Module.recherchePatient = "";
		valeurRecherche = null;
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		valeurRecherche = "";
	}

	public void annulerRechercheArchive() {
		valeurRecherche = null;
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("PatientArchive");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		valeurRecherche = "";
		// init();

		// patients = new CfclientService().rechercheToutPatients();

	}

	public boolean isBlocage() {
		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}

	public int getTempsface() {
		return tempsface;
	}

	public void setTempsface(int tempsface) {
		this.tempsface = tempsface;
	}

	private boolean elimineRdv;

	public boolean isElimineRdv() {
		return elimineRdv;
	}

	public void setElimineRdv(boolean elimineRdv) {
		this.elimineRdv = elimineRdv;
	}

	public void eliminerRdv() {
		rdv.setEtat(1);
		new RendezVousService().modifierRendezVous((RendezVous) rdv);

	}

	public void garderRdv() {
		elimineRdv = false;
		versSalleAttente();
	}

	public void viewPDF(ActionEvent actionEvent) throws SQLException, Exception {
		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/reports/reporttest.jasper"));
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null,
				connection);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();

	}

	public void onchagejj() {
		setJj(jj);
	}

	public void onchagemm() {
		setMm(mm);
	}

	public void onchageaaaa() {
		setAaaa(aaaa);
	}

	private String libprofession;

	public String getLibprofession() {
		return libprofession;
	}

	public void setLibprofession(String libprofession) {
		this.libprofession = libprofession;
	}

	private String pro;

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public void ajoutProfession() {
		ProfessionService ser = new ProfessionService();
		Profession p = new Profession(libprofession);
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (libprofession == null || (libprofession.trim().length() == 0)) {
			// tester si cette zone de text est vide
			blocage = true;
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de la profession.", null));
			addValid = false;

		} else // tester si cette docteur existe déjà

		{
			Profession p2 = ser.rechercheParProfession(libprofession);
			if (p2 == null) { // c-à-d n'existe pas profession avec cette
								// "libprofession"
				ser.ajoutProfession(p);
				blocage = false;
				tempsface = 50000;
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Proffession ajouté avec sucées"));

				libprofession = null;
				getProfessions();
				Integer pr = professions.get(professions.size() - 1)
						.getIdprofession();
				if (pro.equals("pas"))
					idprofessionByProfessp = pr;
				if (pro.equals("conj"))
					idprofessionByProfesscp = pr;
				addValid = true;
				context.execute("PF('diag2').hide();");
				context.execute("PF('dlgValidation').show();");

			} else {
				blocage = true;

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "", "La profession \""
								+ libprofession + "\" existe déjà."));
				addValid = false;
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void profChange() {
		setLibprofession(libprofession);
	}

	public void ajoutProf() {
		libprofession = null;

		pro = "pas";
	}

	public void ajoutProfConj() {
		libprofession = null;
		pro = "conj";
	}

	private String ville;

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void validationVille() {
		VilleService ser = new VilleService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (ville == null || (ville.trim().length() == 0)) {// tester si
			// cette zone de
			// text est vide
			blocage = true;

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "",
					"Veuillez donner le nom de la ville."));
			addValid = false;
		} else // tester si cette ville existe déjà
		{
			Ville d3 = ser.rechercheParVille(ville);
			if (d3 == null) { // c-à-d n'existe pas ville avec cette //
				// "ville"
				Ville d1 = new Ville(ville);
				ser.ajoutVille(d1);
				blocage = false;
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "", "La ville \"" + ville
								+ "\" est ajoutée avec succès."));

				getVilles();
				idville = villes.get(villes.size() - 1).getIdville();
				// initialisation();
				// RequestContext.getCurrentInstance().update("f1");
				context.execute("PF('dialogVille').hide();");
				context.execute("PF('dlgValidation').show();");
				addValid = true;
			} else {
				blocage = true;
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "", "La ville \"" + ville
								+ "\" existe déjà."));

				addValid = false;
			}
		}

		context.addCallbackParam("addValid", addValid);

	}

	private String libclinique;
	private String libdoctor;

	public String getLibclinique() {
		return libclinique;
	}

	public void setLibclinique(String libclinique) {
		this.libclinique = libclinique;
	}

	public String getLibdoctor() {
		return libdoctor;
	}

	public void setLibdoctor(String libdoctor) {
		this.libdoctor = libdoctor;
	}

	public void validationDocteur() {
		DocteurService ser = new DocteurService();
		Docteur p = new Docteur(libdoctor);
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (libdoctor == null || (libdoctor.trim().length() == 0)) {
			// tester si cette zone de text est vide
			blocage = true;
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "",
					"Veuillez donner le nom du docteur."));

			addValid = false;
		} else {
			// tester si cette doctor existe déjà
			Docteur p2 = ser.rechercheParDocteur(libdoctor);
			if (p2 == null) { // c-à-d n'existe pas doctor avec cette
								// "libdoctor"
				ser.ajoutDocteur(p);

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "", "Le docteur \""
								+ libdoctor + "\" est ajouté avec succès."));

				getDocteurs();
				iddoctor = docteurs.get(docteurs.size() - 1).getIddoctor();
				context.execute("PF('diag3').hide();");
				context.execute("PF('dlgValidation').show();");
				addValid = true;

			} else {
				blocage = true;
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "", "Le docteur \""
								+ libdoctor + "\" existe déjà."));
				addValid = false;
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void validationClinique() {
		CliniqueService ser = new CliniqueService();
		Clinique p = new Clinique(libclinique);
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (libclinique == null || (libclinique.trim().length() == 0)) {
			// tester si cette zone de text est vide
			blocage = true;
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "",
					"Veuillez donner le nom du clinique."));

			addValid = false;
		} else {
			// tester si cette clinique existe déjà
			Clinique p2 = ser.rechercheParClinique(libclinique);
			if (p2 == null) { // c-à-d n'existe pas clinique avec cette
								// "libclinique"
				ser.ajoutClinique(p);

				blocage = false;
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "", "La clinique \""
								+ libclinique + "\"  ajoutée avec succès."));
				getCliniques();
				idclinique = cliniques.get(cliniques.size() - 1)
						.getIdclinique();

				context.execute("PF('diag4').hide();");
				context.execute("PF('dlgValidation').show();");
				addValid = true;

			} else {
				// faces.addMessage(null,new FacesMessage(
				// "Cette clinique existe déja."));
				blocage = true;

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "", "La clinique \""
								+ libclinique + "\" existe déjà."));

				addValid = false;
			}
		}

		context.addCallbackParam("addValid", addValid);
	}

	public void initDialog() {
		libclinique = null;
		libdoctor = null;
		ville = null;
		libprofession = null;
	}

	public String getGlycemie() {
		return glycemie;
	}

	public void setGlycemie(String glycemie) {
		this.glycemie = glycemie;
	}

	public String getAghbs() {
		return aghbs;
	}

	public void setAghbs(String aghbs) {
		this.aghbs = aghbs;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getNbCons() {

		return nbCons;
	}

	public void setNbCons(int nbCons) {
		this.nbCons = nbCons;
	}

	public void goToSalleattente() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("redirectSalle", "Patients");
		Module.recherchePatient = "";
		valeurRecherche = null;
		init();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Salle");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void goToPatientArchive() {

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("PatientArchive");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getNomprenom() {
		return nomprenom;
	}

	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
	}

	public String getPrenomnom() {
		return prenomnom;
	}

	public void setPrenomnom(String prenomnom) {
		this.prenomnom = prenomnom;
	}

	public void goToListePatients() {

		/*HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("retourPatient", "FichePatiente")
		*/
		valeurRecherche = null;

		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void goToListePatientsParRendezVous() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("retourPatient", "Rendez-Vous");
		valeurRecherche = null;

		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void onchagevaleurRecherche() {
		setValeurRecherche(valeurRecherche);
	}

	public void recherchePatient() {
		boolean addValid=false;
		FacesContext face = FacesContext.getCurrentInstance();
		if ((valeurRecherche != null) && (valeurRecherche.trim().length() > 0)
				&& (attribut != null)) {
			addValid=true;

			do {
				valeurRecherche = valeurRecherche.trim().replaceAll("  ", " ");
			} while (valeurRecherche.indexOf("  ") != -1);
			Module.recherchePatient = valeurRecherche;
			if (attribut.equals("Tel")) {
				valeurRecherche = valeurRecherche.replaceAll(" ", "");
				String ch1 = "";
				int l = valeurRecherche.length();
				char c;
				for (int i = 0; i < l; i++) {
					c = valeurRecherche.charAt(i);
					if (c != '.')
						ch1 += c;
				}
				valeurRecherche = ch1;
				// c'est un numero de telephone sans point et sans espace
			}
			patientsView = new Cfclient_viewService().rechercheFiltre(false,attribut,
					valeurRecherche);
		}
		else
		{
			blocage=true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "veullez saisi le valeur à cherché"));
		addValid=false;
		}
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("addValid", addValid);
		RequestContext.getCurrentInstance().update("f1:patiente");
		

	}

	public void recherchePatientArchive() {
		if ((valeurRechercheArchive != null)
				&& (valeurRechercheArchive.trim().length() > 0)
				&& (attribut != null)) {

			do {
				valeurRechercheArchive = valeurRechercheArchive.trim()
						.replaceAll("  ", " ");
			} while (valeurRechercheArchive.indexOf("  ") != -1);
			Module.recherchePatient = valeurRechercheArchive;
			if (attribut.equals("Tel")) {
				valeurRechercheArchive = valeurRechercheArchive.replaceAll(" ",
						"");
				String ch1 = "";
				int l = valeurRechercheArchive.length();
				char c;
				for (int i = 0; i < l; i++) {
					c = valeurRechercheArchive.charAt(i);
					if (c != '.')
						ch1 += c;
				}
				valeurRechercheArchive = ch1;
				// c'est un numero de telephone sans point et sans espace
			}
			patientArchives = new Cfclient_viewService().rechercheFiltre(true,
					attribut, valeurRechercheArchive);
		}

		RequestContext.getCurrentInstance().update("f1:patiente");

	}

	public void getPatCode(Integer idp) {
		FacesContext faces = FacesContext.getCurrentInstance();
		code = idp;
		
		List<RendezVous> rend = new RendezVousService().rechercheParPatient(code);
		Salle s = new SalleService().rechercheSalleParPatient(code);
		
		if (rend != null && rend.size() > 0 && s != null) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Archivage impossible!  Patiente a un rendez-vous et présente dans la salle d'attente.", ""));
			
			
			
		}else if (s != null) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Archivage impossible!  Patiente présente dans la salle d'attente.", ""));
			
			
		}else if (rend != null && rend.size() > 0) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Archivage impossible!  Patiente a un rendez-vous.", ""));
			
			
		}else{
			
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('archivDlg').show();");
		}
				
	}

	public void archiver() {

		FacesContext face = FacesContext.getCurrentInstance();
		CfclientService ser = new CfclientService();
		Cfclient cl = new Cfclient();
		cl = ser.RechercheCfclient(code);
		if (cl != null) {
			cl.setCode(code);
			cl.setArchive(true);
			ser.modifierPatient(cl);
			// RequestContext.getCurrentInstance().update("f1:patiente");
			init();
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Patiente archivée avec succès"));
			FacesContext context2 = FacesContext.getCurrentInstance();
			context2.getExternalContext().getFlash().setKeepMessages(true);

			goToListePatients();

		}

		code = null;

	}

	public void AnulArchivage() {

		FacesContext face = FacesContext.getCurrentInstance();
		CfclientService ser = new CfclientService();
		Cfclient cl = new Cfclient();
		cl = ser.RechercheCfclient(code);
		if (cl != null) {
			cl.setCode(code);
			cl.setArchive(false);
			ser.modifierPatient(cl);
			init();

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Patiente restaurée avec succès"));

			FacesContext context2 = FacesContext.getCurrentInstance();
			context2.getExternalContext().getFlash().setKeepMessages(true);
			goToPatientArchive();

		}

		code = null;
	}

	public String changerColor(String dateConsult) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (!dateConsult.equals("Nouveau")) {
			try {

				Date date1 = sdf.parse(dateConsult);
				GregorianCalendar gc1 = new GregorianCalendar();
				gc1.setTime(date1);

				Date dateSys = new Date();
				String s = sdf.format(dateSys);
				dateSys = sdf.parse(s);

				GregorianCalendar gc2 = new GregorianCalendar();
				gc2.setTime(dateSys);

				int gap = 0;
				gc1.add(GregorianCalendar.MONTH, 1);
				while (gc1.compareTo(gc2) <= 0) {
					gap++;
					gc1.add(GregorianCalendar.MONTH, 1);
				}
				double nbrans = gap / 12;

				if (nbrans < 10) {
					return "font-size:small;font-weight:bold";
				} else {
					return "font-size:small;font-weight:bold;color:#FF0000";
				}

			} catch (ParseException e) {
				return "font-size:small;font-weight:bold";
			}

		}

		return "font-size:small;font-weight:bold";

	}

	public boolean changerRendredNegative1(Cfclient_view cl) throws Exception {

		if (cl != null) {
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileNegative1"))
				return (true);
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileNegative2")) {
				return (true);
			}
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileNegative3")) {
				return (true);
			}

		}
		return (false);
	}

	public boolean changerRendredNegative2(Cfclient_view cl) throws Exception {
		if (cl != null) {
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileNegative2")) {
				return (true);
			}
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileNegative3")) {
				return (true);
			}

		}
		return (false);
	}

	public boolean changerRendredNegative3(Cfclient_view cl) throws Exception {
		if (cl != null) {

			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileNegative3")) {
				return (true);
			}
		}
		return (false);
	}

	public boolean changerRendredMoyen(Cfclient_view cl) throws Exception {
		if (cl != null) {

			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileMoyen")) {
				return (true);
			}
		}
		return (false);

	}

	public boolean changerRendredPositive1(Cfclient_view cl) throws Exception {

		if (cl != null) {
			if (cl.getCategoriEtoile()!=null && cl.getCategoriEtoile().equals("etoilePositive1"))
				return (true);
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoilePositive2")) {
				return (true);
			}
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoilePositive3")) {
				return (true);
			}
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}

		}
		return (false);
	}

	public boolean changerRendredPositive2(Cfclient_view cl) throws Exception {
		if (cl != null) {
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoilePositive2")) {
				return (true);
			}
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoilePositive3")) {
				return (true);
			}
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}
		}
		return (false);
	}

	public boolean changerRendredPositive3(Cfclient_view cl) throws Exception {
		if (cl != null) {
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoilePositive3")) {
				return (true);
			}
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}
		}
		return (false);
	}

	public boolean changerRendredExtra(Cfclient_view cl) throws Exception {
		if (cl != null) {
			if (cl.getCategoriEtoile()!=null &&cl.getCategoriEtoile().equals("etoileExtra")) {
				return (true);
			}
		}
		return (false);
	}

	public int calculAgeEnAns(String dateNaiss) {

		if (dateNaiss != null && dateNaiss.length() > 0) {
			int i = dateNaiss.lastIndexOf("/");
			int j = Integer.parseInt(dateNaiss.substring(i + 1));
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);

			return (year - j);
		}

		return 0;
	}

	public String getValeurRechercheArchive() {
		return valeurRechercheArchive;
	}

	public void setValeurRechercheArchive(String valeurRechercheArchive) {
		this.valeurRechercheArchive = valeurRechercheArchive;
	}

	public void onchagevaleurRechercheArchive() {
		setValeurRechercheArchive(valeurRechercheArchive);
	}

	public void goToRetour() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		String redirectRetour = (String) session.getAttribute("retourPatient");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(redirectRetour);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int nbPatientAct() {

		return new CfclientService().rechercheParArchive(false).size();
	}

	public int nbPatientArch() {
		return new CfclientService().rechercheParArchive(true).size();
	}

	public int TotalPatient() {
		return nbPatientAct() + nbPatientArch();
	}

	public void setListestris(List<String> listestris) {
		Listestris = listestris;
	}

	public String getattributTri() {
		return attributTri;
	}

	public void setattributTri(String attributTri) {
		this.attributTri = attributTri;
	}

	public void croissante() {
		ordre = "croissante";
		if ((attributTri.equals("") == false) || (attribut != null)) {
			patientsView = new Cfclient_viewService().rechercherTriePatient(false,attributTri,
					ordre);
			RequestContext.getCurrentInstance().update("f1:patiente");
		}
	}

	public void decroissante() {
		ordre = "décroissante";
		if ((attributTri.equals("") == false) || (attribut != null)) {
			patientsView = new Cfclient_viewService().rechercherTriePatient(false,attributTri,
					ordre);
			RequestContext.getCurrentInstance().update("f1:patiente");
		}
	}
	public void croissanteArchive() {
		ordreArchive = "croissante";
		if ((attributTriArchive.equals("") == false) || (attributTriArchive != null)) {
			 patientArchives = new Cfclient_viewService().rechercherTriePatient(true,attributTriArchive, ordreArchive);
			RequestContext.getCurrentInstance().update("f1:patiente");
		}
	}

	public void decroissanteArchive() {
		ordreArchive = "décroissante";
		if ((attributTriArchive.equals("") == false) || (attributTriArchive != null)) {
			 patientArchives = new Cfclient_viewService().rechercherTriePatient(true,attributTriArchive,
					ordreArchive);
			RequestContext.getCurrentInstance().update("f1:patiente");
		}
	}

	public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}

	public String getAttributTri() {
		return attributTri;
	}

	public void setAttributTri(String attributTri) {
		this.attributTri = attributTri;
	}

	public String getCategorieEtoile() {
		return categorieEtoile;
	}

	public void setCategorieEtoile(String categorieEtoile) {
		this.categorieEtoile = categorieEtoile;
	}

	public String getAttributTriArchive() {
		return attributTriArchive;
	}

	public void setAttributTriArchive(String attributTriArchive) {
		this.attributTriArchive = attributTriArchive;
	}

	public boolean isRendredNegative1() {
		return rendredNegative1;
	}

	public void setRendredNegative1(boolean rendredNegative1) {
		this.rendredNegative1 = rendredNegative1;
	}

	public boolean isRendredNegative2() {
		return rendredNegative2;
	}

	public void setRendredNegative2(boolean rendredNegative2) {
		this.rendredNegative2 = rendredNegative2;
	}

	public boolean isRendredNegative3() {
		return rendredNegative3;
	}

	public void setRendredNegative3(boolean rendredNegative3) {
		this.rendredNegative3 = rendredNegative3;
	}

	public boolean isRendredMoyen() {
		return rendredMoyen;
	}

	public void setRendredMoyen(boolean rendredMoyen) {
		this.rendredMoyen = rendredMoyen;
	}

	public boolean isRendredPositive1() {
		return rendredPositive1;
	}

	public void setRendredPositive1(boolean rendredPositive1) {
		this.rendredPositive1 = rendredPositive1;
	}

	public boolean isRendredPositive2() {
		return rendredPositive2;
	}

	public void setRendredPositive2(boolean rendredPositive2) {
		this.rendredPositive2 = rendredPositive2;
	}

	public boolean isRendredPositive3() {
		return rendredPositive3;
	}

	public void setRendredPositive3(boolean rendredPositive3) {
		this.rendredPositive3 = rendredPositive3;
	}

	public boolean isRendredExtra() {
		return rendredExtra;
	}

	public void setRendredExtra(boolean rendredExtra) {
		this.rendredExtra = rendredExtra;
	}

	public String getOrdreArchive() {
		return ordreArchive;
	}

	public void setOrdreArchive(String ordreArchive) {
		this.ordreArchive = ordreArchive;
	}
	
	

}
