package com.doctor.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Diagnostique;
import com.doctor.persistance.Examen;
import com.doctor.persistance.Symptome;
import com.doctor.service.CfclientService;
import com.doctor.service.DiagnostiqueService;
import com.doctor.service.ExamenService;
import com.doctor.service.SymptomeService;

@ManagedBean(name = "nouvelleConsultationBean")
public class NouvelleConsultationBean {
	private Integer idConsultationDetail;
	private String dateConsultation;
	private String ddr;
	private String ddg;
	private String termePrevu;
	private String termeActuel;
	private String honoraire;
	private String toxo;
	private String tpha;
	private String rubeole;
	private String poids;
	private String tas;
	private String tad;
	private String hu;
	private String sInf;
	private String leuorhee;
	private String col;
	private String motifCons;
	private String symptome;
	private String examen;
	private String diagnostique;

	private String seins;
	private String tv;
	private String speculum;
	private String dateFrotti;
	private String resultatFrotti;
	private Integer idPatient;

	// c'est le resultat de la sélection qui contient le type de la consultation
	private String consultationmotif;
	private List<Symptome> symptomes = new ArrayList<Symptome>();
	private List<Examen> examens = new ArrayList<Examen>();
	private List<Diagnostique> diagnostiques = new ArrayList<Diagnostique>();
	private Integer idsymptome;
	private Integer idexamen;
	private Integer iddiagnostique;

	public Integer getIdexamen() {
		return idexamen;
	}

	public void setIdexamen(Integer idexamen) {
		this.idexamen = idexamen;
	}

	public Integer getIddiagnostique() {
		return iddiagnostique;
	}

	public void setIddiagnostique(Integer iddiagnostique) {
		this.iddiagnostique = iddiagnostique;
	}

	public Integer getIdsymptome() {
		return idsymptome;
	}

	public void setIdsymptome(Integer idsymptome) {
		this.idsymptome = idsymptome;
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
		return ddr;
	}

	public void setDdr(String ddr) {
		this.ddr = ddr;
	}

	public String getDdg() {
		return ddg;
	}

	public void setDdg(String ddg) {
		this.ddg = ddg;
	}

	public String getTermePrevu() {
		return termePrevu;
	}

	public void setTermePrevu(String termePrevu) {
		this.termePrevu = termePrevu;
	}

	public String getTermeActuel() {
		return termeActuel;
	}

	public void setTermeActuel(String termeActuel) {
		this.termeActuel = termeActuel;
	}

	public String getHonoraire() {
		return honoraire;
	}

	public void setHonoraire(String honoraire) {
		this.honoraire = honoraire;
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

	public void setHu(String hu) {
		this.hu = hu;
	}

	public String getsInf() {
		return sInf;
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

	public String getMotifCons() {
		return motifCons;
	}

	public void setMotifCons(String motifCons) {
		this.motifCons = motifCons;
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

	private Cfclient cfclient;

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		// idPatient = Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		// consultationmotif="Echologie Gynécologique";
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateConsultation = dateFormat.format(date);

	}

	public void onExamChange() {

	}

	public void onDiagChange() {

	}

}
