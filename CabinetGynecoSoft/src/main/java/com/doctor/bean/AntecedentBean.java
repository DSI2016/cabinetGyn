package com.doctor.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.AntChirCfclient;
import com.doctor.persistance.AntFamCfclient;
import com.doctor.persistance.AntMedCfclient;
import com.doctor.persistance.AntecedentChir;
import com.doctor.persistance.AntecedentFam;
import com.doctor.persistance.AntecedentMed;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Contraception;
import com.doctor.persistance.EtatBebe;
import com.doctor.persistance.EtatFinGross;
import com.doctor.persistance.HistoriqueGross;
import com.doctor.persistance.MoyenContraception;
import com.doctor.persistance.Sterile;
import com.doctor.service.AntChirCfclientService;
import com.doctor.service.AntFamCfclientService;
import com.doctor.service.AntMedCfclientService;
import com.doctor.service.AntecedentChirService;
import com.doctor.service.AntecedentFamService;
import com.doctor.service.AntecedentMedService;
import com.doctor.service.CfclientService;
import com.doctor.service.ContraceptionService;
import com.doctor.service.EtatBebeService;
import com.doctor.service.EtatFinGrossService;
import com.doctor.service.HistoriqueGrossService;
import com.doctor.service.MoyenContraceptionService;
import com.doctor.service.SterileService;

@ManagedBean(name = "antecedentBean")
@SessionScoped
public class AntecedentBean implements Serializable, LineListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSterile;
	private String sterilite;
	private Date depuis;
	private String cohabitation;
	private String habitude;
	private String titre;
	private int rapport;
	private String antecedentH;
	private String hormoneH;
	private String spermH;
	private String bilanH;
	private String traitementH;
	private String antecedent;
	private String examensH;
	private String examens;
	private String hormone;
	private String echoPelvienne;
	private String hsg;
	private String hysteroscopie;
	private String coelioscopie;
	private String traitement;
	private String coital;
	private Integer idPatient;
	private Cfclient cfclient;
	private List<EtatBebe> etatBebes = new ArrayList<EtatBebe>();
	private List<EtatFinGross> etatFinGrosss = new ArrayList<EtatFinGross>();
	private Integer idhistoriqueGross;
	private String debutGross;
	private String finGross;
	private String notes;
	private String honoraires;
	private String etatFinGross;
	private String terme;
	private String lieu;
	private String prenomBebe;
	private String sexeBebe;
	private String sexeBebeAncien;
	private String etatBebe;
	private String etatBebeAncien;
	private Float poids;

	private String prenomBebe2;
	private String sexeBebe2;
	private String sexeBebe2Ancien;
	private String etatBebe2;
	private String etatBebe2Ancien;
	private Float poids2;

	private String prenomBebe3;
	private String sexeBebe3;
	private String sexeBebe3Ancien;
	private String etatBebe3;
	private String etatBebe3Ancien;
	private Float poids3;
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private List<HistoriqueGross> listHistoriqueGross = new ArrayList<HistoriqueGross>();
	private int index;
	private Integer idcontraception;
	private String dateDebut;
	private String moyen;
	private String remarque;
	private String dateFin;
	private String titrecontraception;
	private String action1;
	private List<MoyenContraception> moyens = new ArrayList<MoyenContraception>();
	private Date dateFinGross;
	private int nbBebe;
	private boolean unBebe;
	private boolean deuxBebe;
	private boolean troisBebe;
	private Integer dpr;
	private String dysmenorhe;
	private String mastodynie;
	private Integer menopose;
	private String consang;
	private int gestite;
	private int partie;
	private int nbrGarcon;
	private int nbrFille;
	private int cesar;
	private boolean spanio;
	private Date mariage;
	private String cycleType;
	private String regleType;
	private String regles;
	private String cycle;
	private String dateFinGrossString;
	private String etatFinGrossAncien;
	private Integer idantecedentMed;
	private List<AntecedentMed> antecedentMeds = new ArrayList<AntecedentMed>();
	private Integer idantecedentFam;
	private List<AntecedentFam> antecedentFams = new ArrayList<AntecedentFam>();

	private Integer idantecedentChir;
	private List<AntecedentChir> antecedentChirs = new ArrayList<AntecedentChir>();
	private List<AntMedCfclient> antecedentms = new ArrayList<AntMedCfclient>();
	private List<AntFamCfclient> antecedentfs = new ArrayList<AntFamCfclient>();
	private List<AntChirCfclient> antecedentcs = new ArrayList<AntChirCfclient>();
	private List<Contraception> contraceptions = new ArrayList<Contraception>();
	private String am;
	private String dateAm;
	private Integer idantmedcfclient;
	private Integer idantchircfclient;
	private Integer idantfamcfclient;
	private int nbBebeAncien;
	private String msgGrowl;

	private String actionAnt;
	private String typeAnt;
	private String nomAntecedent;
	private String etatFG;
	private String etatBB;

	public String getEtatFG() {
		return etatFG;
	}

	public void setEtatFG(String etatFG) {
		this.etatFG = etatFG;
	}

	public String getEtatBB() {
		return etatBB;
	}

	public void setEtatBB(String etatBB) {
		this.etatBB = etatBB;
	}

	public String getNomAntecedent() {
		return nomAntecedent;
	}

	public void setNomAntecedent(String nomAntecedent) {
		this.nomAntecedent = nomAntecedent;
	}

	public String getTypeAnt() {
		return typeAnt;
	}

	public void setTypeAnt(String typeAnt) {
		this.typeAnt = typeAnt;
	}

	public String getActionAnt() {
		return actionAnt;
	}

	public void setActionAnt(String actionAnt) {
		this.actionAnt = actionAnt;
	}

	public List<Contraception> getContraceptions() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		contraceptions = new ContraceptionService()
				.rechercheToutContraception(idPatient);

		return contraceptions;
	}

	public void setContraceptions(List<Contraception> contraceptions) {
		this.contraceptions = contraceptions;
	}

	public String getMsgGrowl() {
		return msgGrowl;
	}

	public void setMsgGrowl(String msgGrowl) {
		this.msgGrowl = msgGrowl;
	}

	public int getNbBebeAncien() {
		return nbBebeAncien;
	}

	public void setNbBebeAncien(int nbBebeAncien) {
		this.nbBebeAncien = nbBebeAncien;
	}

	public String getSexeBebeAncien() {
		return sexeBebeAncien;
	}

	public void setSexeBebeAncien(String sexeBebeAncien) {
		this.sexeBebeAncien = sexeBebeAncien;
	}

	public String getEtatBebeAncien() {
		return etatBebeAncien;
	}

	public void setEtatBebeAncien(String etatBebeAncien) {
		this.etatBebeAncien = etatBebeAncien;
	}

	public String getSexeBebe2Ancien() {
		return sexeBebe2Ancien;
	}

	public void setSexeBebe2Ancien(String sexeBebe2Ancien) {
		this.sexeBebe2Ancien = sexeBebe2Ancien;
	}

	public String getEtatBebe2Ancien() {
		return etatBebe2Ancien;
	}

	public void setEtatBebe2Ancien(String etatBebe2Ancien) {
		this.etatBebe2Ancien = etatBebe2Ancien;
	}

	public String getSexeBebe3Ancien() {
		return sexeBebe3Ancien;
	}

	public void setSexeBebe3Ancien(String sexeBebe3Ancien) {
		this.sexeBebe3Ancien = sexeBebe3Ancien;
	}

	public String getEtatBebe3Ancien() {
		return etatBebe3Ancien;
	}

	public void setEtatBebe3Ancien(String etatBebe3Ancien) {
		this.etatBebe3Ancien = etatBebe3Ancien;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getDateAm() {
		return dateAm;
	}

	public void setDateAm(String dateAm) {
		this.dateAm = dateAm;
	}

	public String getEtatFinGrossAncien() {
		return etatFinGrossAncien;
	}

	public void setEtatFinGrossAncien(String etatFinGrossAncien) {
		this.etatFinGrossAncien = etatFinGrossAncien;
	}

	public String getCycle() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			cycle = c.getCycle();
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getRegles() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			regles = c.getRegles();
		return regles;
	}

	public void setRegles(String regles) {
		this.regles = regles;
	}

	public String getRegleType() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null) {
			regleType = c.getRegleType();
		}
		return regleType;
	}

	public void setRegleType(String regleType) {
		this.regleType = regleType;
	}

	public String getCycleType() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			cycleType = c.getCycleType();

		return cycleType;
	}

	public void setCycleType(String cyleType) {
		this.cycleType = cyleType;
	}

	public Date getMariage() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			mariage = c.getMariage();

		return mariage;
	}

	public void setMariage(Date mariage) {
		this.mariage = mariage;
	}

	public boolean isSpanio() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			spanio = c.isSpanio();

		return spanio;
	}

	public void setSpanio(boolean spanio) {
		this.spanio = spanio;
	}

	public int getCesar() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			cesar = c.getCesar();

		return cesar;
	}

	public void setCesar(int cesar) {
		this.cesar = cesar;
	}

	public String getConsang() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			consang = c.getConsang();
		return consang;
	}

	public void setConsang(String consang) {
		this.consang = consang;
	}

	public int getGestite() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			gestite = c.getGestite();
		return gestite;
	}

	public void setGestite(int gestite) {
		this.gestite = gestite;
	}

	public int getPartie() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			partie = c.getPartie();
		return partie;
	}

	public void setPartie(int partie) {
		this.partie = partie;
	}

	public int getNbrGarcon() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			nbrGarcon = c.getNbrGarcon();
		return nbrGarcon;
	}

	public void setNbrGarcon(int nbrGarcon) {
		this.nbrGarcon = nbrGarcon;
	}

	public int getNbrFille() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			nbrFille = c.getNbrFille();
		return nbrFille;
	}

	public void setNbrFille(int nbrFille) {
		this.nbrFille = nbrFille;
	}

	public String getDysmenorhe() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			dysmenorhe = c.getDysmenorhe();
		return dysmenorhe;
	}

	public void setDysmenorhe(String dysmenorhe) {
		this.dysmenorhe = dysmenorhe;
	}

	public String getMastodynie() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			mastodynie = c.getMastodynie();
		return mastodynie;
	}

	public void setMastodynie(String mastodynie) {
		this.mastodynie = mastodynie;
	}

	public Integer getMenopose() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			menopose = c.getMenopose();
		return menopose;
	}

	public void setMenopose(Integer menopose) {
		this.menopose = menopose;
	}

	public Integer getDpr() {
		Cfclient c = new CfclientService().RechercheCfclient(idPatient);
		if (c != null)
			dpr = c.getDpr();
		return dpr;
	}

	public void setDpr(Integer dpr) {
		this.dpr = dpr;
	}

	public String getPrenomBebe2() {
		return prenomBebe2;
	}

	public void setPrenomBebe2(String prenomBebe2) {
		this.prenomBebe2 = prenomBebe2;
	}

	public String getSexeBebe2() {
		return sexeBebe2;
	}

	public void setSexeBebe2(String sexeBebe2) {
		this.sexeBebe2 = sexeBebe2;
	}

	public String getEtatBebe2() {
		return etatBebe2;
	}

	public void setEtatBebe2(String etatBebe2) {
		this.etatBebe2 = etatBebe2;
	}

	public Float getPoids2() {
		return poids2;
	}

	public void setPoids2(Float poids2) {
		this.poids2 = poids2;
	}

	public String getPrenomBebe3() {
		return prenomBebe3;
	}

	public void setPrenomBebe3(String prenomBebe3) {
		this.prenomBebe3 = prenomBebe3;
	}

	public String getSexeBebe3() {
		return sexeBebe3;
	}

	public void setSexeBebe3(String sexeBebe3) {
		this.sexeBebe3 = sexeBebe3;
	}

	public String getEtatBebe3() {
		return etatBebe3;
	}

	public void setEtatBebe3(String etatBebe3) {
		this.etatBebe3 = etatBebe3;
	}

	public Float getPoids3() {
		return poids3;
	}

	public void setPoids3(Float poids3) {
		this.poids3 = poids3;
	}

	public boolean isUnBebe() {
		return unBebe;
	}

	public void setUnBebe(boolean unBebe) {
		this.unBebe = unBebe;
	}

	public boolean isDeuxBebe() {
		return deuxBebe;
	}

	public void setDeuxBebe(boolean deuxBebe) {
		this.deuxBebe = deuxBebe;
	}

	public boolean isTroisBebe() {
		return troisBebe;
	}

	public void setTroisBebe(boolean troisBebe) {
		this.troisBebe = troisBebe;
	}

	public int getNbBebe() {
		if (nbBebe == 0) {
			unBebe = false;
			deuxBebe = false;
			troisBebe = false;
		}
		if (nbBebe == 1) {
			unBebe = true;
			deuxBebe = false;
			troisBebe = false;
		}
		if (nbBebe == 2) {
			unBebe = true;
			deuxBebe = true;
			troisBebe = false;
		}
		if (nbBebe == 3) {
			unBebe = true;
			deuxBebe = true;
			troisBebe = true;
		}

		return nbBebe;
	}

	public void setNbBebe(int nbBebe) {
		this.nbBebe = nbBebe;
	}

	public Date getDateFinGross() {
		return dateFinGross;
	}

	public void setDateFinGross(Date dateFinGross) {
		this.dateFinGross = dateFinGross;
	}

	public Integer getIdcontraception() {
		return idcontraception;
	}

	public void setIdcontraception(Integer idcontraception) {
		this.idcontraception = idcontraception;
	}

	public List<EtatFinGross> getEtatFinGrosss() {
		EtatFinGrossService ser = new EtatFinGrossService();
		etatFinGrosss = ser.rechercheTousEtatFinGross();
		return etatFinGrosss;
	}

	public void setEtatFinGrosss(List<EtatFinGross> etatFinGrosss) {
		this.etatFinGrosss = etatFinGrosss;
	}

	public String getDateDebut() {
		if (dateDebut == null) {
			Date actuelle = new Date();
			// * Definition du format utilise pour les dates
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			// * Donne la date au format "aaaa-mm-jj"
			dateDebut = dateFormat.format(actuelle);
		}
		return dateDebut;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getMoyen() {
		return moyen;
	}

	public void setMoyen(String moyen) {
		this.moyen = moyen;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public String getDateFin() {

		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public List<MoyenContraception> getMoyens() {
		MoyenContraceptionService ser = new MoyenContraceptionService();
		moyens = ser.rechercheTousMoyenContraception();
		return moyens;
	}

	public void setMoyens(List<MoyenContraception> moyens) {
		this.moyens = moyens;
	}

	public List<EtatBebe> getEtatBebes() {
		EtatBebeService ser = new EtatBebeService();
		etatBebes = ser.rechercheTousEtatBebe();
		return etatBebes;
	}

	public void setEtatBebes(List<EtatBebe> etatBebes) {
		this.etatBebes = etatBebes;
	}

	public Integer getIdantecedentFam() {
		return idantecedentFam;
	}

	public void setIdantecedentFam(Integer idantecedentFam) {
		this.idantecedentFam = idantecedentFam;
	}

	public List<AntecedentFam> getAntecedentFams() {
		AntecedentFamService se = new AntecedentFamService();
		antecedentFams = se.rechercheTousAntecedentFam();
		return antecedentFams;
	}

	public void setAntecedentFams(List<AntecedentFam> antecedentFams) {
		this.antecedentFams = antecedentFams;
	}

	public Integer getIdantecedentChir() {
		return idantecedentChir;
	}

	public void setIdantecedentChir(Integer idantecedentChir) {
		this.idantecedentChir = idantecedentChir;
	}

	public List<AntecedentChir> getAntecedentChirs() {
		AntecedentChirService se = new AntecedentChirService();
		antecedentChirs = se.rechercheTousAntecedentChir();
		return antecedentChirs;
	}

	public void setAntecedentChirs(List<AntecedentChir> antecedentChirs) {
		this.antecedentChirs = antecedentChirs;
	}

	public Integer getIdantecedentMed() {
		return idantecedentMed;
	}

	public void setIdantecedentMed(Integer idantecedentMed) {
		this.idantecedentMed = idantecedentMed;
	}

	public List<AntecedentMed> getAntecedentMeds() {
		AntecedentMedService se = new AntecedentMedService();
		antecedentMeds = se.rechercheTousAntecedentMed();
		return antecedentMeds;
	}

	public void setAntecedentMeds(List<AntecedentMed> antecedentMeds) {
		this.antecedentMeds = antecedentMeds;
	}

	public Cfclient getCfclient() {
		// idPatient = Module.idpatient;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
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

	public Integer getIdSterile() {
		return idSterile;
	}

	public void setIdSterile(Integer idSterile) {
		this.idSterile = idSterile;
	}

	public String getSterilite() {
		return sterilite;
	}

	public void setSterilite(String sterilite) {
		this.sterilite = sterilite;
	}

	public Date getDepuis() {
		return depuis;
	}

	public void setDepuis(Date depuis) {
		this.depuis = depuis;
	}

	public String getCohabitation() {

		return cohabitation;
	}

	public void setCohabitation(String cohabitation) {
		this.cohabitation = cohabitation;
	}

	public String getHabitude() {
		return habitude;
	}

	public void setHabitude(String habitude) {
		this.habitude = habitude;
	}

	public int getRapport() {
		return rapport;
	}

	public void setRapport(int rapport) {
		this.rapport = rapport;
	}

	public String getAntecedentH() {
		return antecedentH;
	}

	public void setAntecedentH(String antecedentH) {
		this.antecedentH = antecedentH;
	}

	public String getHormoneH() {
		return hormoneH;
	}

	public void setHormoneH(String hormoneH) {
		this.hormoneH = hormoneH;
	}

	public String getSpermH() {
		return spermH;
	}

	public void setSpermH(String spermH) {
		this.spermH = spermH;
	}

	public String getBilanH() {
		return bilanH;
	}

	public void setBilanH(String bilanH) {
		this.bilanH = bilanH;
	}

	public String getTraitementH() {
		return traitementH;
	}

	public void setTraitementH(String traitementH) {
		this.traitementH = traitementH;
	}

	public String getAntecedent() {
		return antecedent;
	}

	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}

	public String getExamensH() {
		return examensH;
	}

	public void setExamensH(String examensH) {
		this.examensH = examensH;
	}

	public String getExamens() {
		return examens;
	}

	public void setExamens(String examens) {
		this.examens = examens;
	}

	public String getHormone() {
		return hormone;
	}

	public void setHormone(String hormone) {
		this.hormone = hormone;
	}

	public String getEchoPelvienne() {
		return echoPelvienne;
	}

	public void setEchoPelvienne(String echoPelvienne) {
		this.echoPelvienne = echoPelvienne;
	}

	public String getHsg() {
		return hsg;
	}

	public void setHsg(String hsg) {
		this.hsg = hsg;
	}

	public String getHysteroscopie() {
		return hysteroscopie;
	}

	public void setHysteroscopie(String hysteroscopie) {
		this.hysteroscopie = hysteroscopie;
	}

	public String getCoelioscopie() {
		return coelioscopie;
	}

	public void setCoelioscopie(String coelioscopie) {
		this.coelioscopie = coelioscopie;
	}

	public String getTraitement() {
		return traitement;
	}

	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}

	public String getCoital() {
		return coital;
	}

	public void setCoital(String coital) {
		this.coital = coital;
	}

	public void ajouternouvGross() {

		Date actuelleDate = new Date();
		// * Definition du format utilise pour les dates

		// * Donne la date au format "aaaa-mm-jj"
		dateFinGrossString = dateFormat.format(actuelleDate);

		action1 = "Ajout";
		initialisation();
	}

	public void modifierGross(HistoriqueGross h) {
		etatFinGross = null;
		idhistoriqueGross = h.getIdhistoriqueGross();
		dateFinGross = h.getDateFinGross();
		dateFinGrossString = dateFormat.format(h.getDateFinGross());
		if (h.getEtatFinGross() != null) {
			etatFinGross = h.getEtatFinGross().getEtatFinG();

			etatFinGrossAncien = h.getEtatFinGross().getEtatFinG();

		}
		terme = h.getTerme();
		lieu = h.getLieu();
		nbBebe = 0;
		nbBebeAncien = 0;
		sexeBebe = h.getSexeBebe();
		sexeBebe2 = h.getSexeBebe2();
		sexeBebe3Ancien = h.getSexeBebe3();
		sexeBebeAncien = h.getSexeBebe();
		sexeBebe2Ancien = h.getSexeBebe2();
		sexeBebe3 = h.getSexeBebe3();
		if (h.getEtatBebe() != null)
			etatBebe = h.getEtatBebe().getEtatBebe();
		if (h.getEtatBebe2() != null)
			etatBebe2 = h.getEtatBebe2().getEtatBebe();
		if (h.getEtatBebe3() != null)
			etatBebe3 = h.getEtatBebe3().getEtatBebe();
		prenomBebe = h.getPrenomBebe();
		prenomBebe2 = h.getPrenomBebe2();
		prenomBebe3 = h.getPrenomBebe3();
		if (h.getEtatBebe() != null) {
			etatBebe = h.getEtatBebe().getEtatBebe();
			etatBebeAncien = h.getEtatBebe().getEtatBebe();
			setNbBebe(1);
			nbBebeAncien = 1;
		}

		if (h.getEtatBebe2() != null) {
			setNbBebe(2);
			nbBebeAncien = 2;
			etatBebe2 = h.getEtatBebe2().getEtatBebe();
			etatBebe2Ancien = h.getEtatBebe2().getEtatBebe();
		}

		if (h.getEtatBebe3() != null) {

			etatBebe3 = h.getEtatBebe3().getEtatBebe();
			etatBebe3Ancien = h.getEtatBebe3().getEtatBebe();
			setNbBebe(3);
			nbBebeAncien = 3;
		}

		prenomBebe = h.getPrenomBebe();
		poids = h.getPoids();

		prenomBebe2 = h.getPrenomBebe2();
		poids2 = h.getPoids2();

		prenomBebe3 = h.getPrenomBebe3();
		poids3 = h.getPoids3();

		this.action1 = "Modification";
		if (h.getEtatFinGross() == null) {
			action1 = "Modification Grossese";
			dateFinGross = h.getDateFinGross();
		}

	}

	public void ajouternouvContraception() {
		action1 = "Ajout";
	}

	public void modifierContraception(Contraception c) {

		idcontraception = c.getIdcontraception();
		dateDebut = c.getDateDebut();
		moyen = c.getMoyen();
		remarque = c.getRemarque();
		this.action1 = "Modification";
	}

	public void initialisation() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext()
				.getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		Cfclient  cf = se.RechercheCfclient(idPatient);
		debutGross = null;
		finGross = null;
		notes = null;
		honoraires = null;
		etatFinGross = null;
		etatFinGrossAncien = null;
		terme = cf.gettActuel();
		lieu = null;

		prenomBebe = null;
		sexeBebe = null;
		etatBebe = null;
		sexeBebeAncien = null;
		etatBebeAncien = null;
		poids = null;

		prenomBebe2 = null;
		sexeBebe2 = null;
		etatBebe2 = null;
		sexeBebe2Ancien = null;
		etatBebe2Ancien = null;
		poids2 = null;

		prenomBebe3 = null;
		sexeBebe3 = null;
		etatBebe3 = null;
		sexeBebe3Ancien = null;
		etatBebe3Ancien = null;
		poids3 = null;

		dateDebut = null;
		moyen = null;
		remarque = null;
		unBebe = false;
		deuxBebe = false;
		troisBebe = false;
		nbBebe = 0;
	}

	public void validerBebe() {
		HistoriqueGross hg = new HistoriqueGross();
		HistoriqueGross hg2 = new HistoriqueGross();
		CfclientService se = new CfclientService();

		Cfclient cf = new Cfclient();
		FacesContext face = FacesContext.getCurrentInstance();
		HistoriqueGrossService sere = new HistoriqueGrossService();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if ((dateFinGrossString == null)// converture de date fin grosses
				|| (dateFinGrossString.trim().equals(""))) {

			dateFinGross = null;

		} else {
			try {
				dateFinGross = dateFormat.parse(dateFinGrossString);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// Les controles de saisie sur date fin grosses
		if ((dateFinGross == null) || (dateFinGrossString.trim().length() == 0)
				|| (dateFinGrossString == null)
				|| (dateFinGross.toString().trim().length() == 0)) {
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez donner la date de fin de grossesse", ""));
			addValid = false;
		} else {
			// if (Module.corigerDate(dateFinGrossString) != null) {
			// this.setDateFinGrossString(Module.corigerDate(dateFinGrossString));
			// }
			if (!(Module.verifierDate(dateFinGrossString).equals("")))

			{
				face.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								Module.verifierDate(dateFinGrossString)));
				addValid = false;

			}
		}
		if ((etatFinGross == null) || (etatFinGross.length() == 0)
				|| (etatFinGross.trim().length() == 0)) {
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez donner l'état de fin de grossesse", ""));
			addValid = false;
		}

		if (nbBebe >= 1) {
			if ((sexeBebe == null) || (sexeBebe.trim().length() == 0)) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez spécifier le sexe du prémier bébé", ""));
				addValid = false;
			}
			if ((etatBebe == null) || (etatBebe.trim().length() == 0)) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez choisir un état pour le prémier bébé", ""));
				addValid = false;
			}

		}
		if (nbBebe >= 2) {
			// if ((prenomBebe2 == null) || (prenomBebe2.trim().length() == 0))
			// {
			// face.addMessage(null, new FacesMessage(
			// FacesMessage.SEVERITY_ERROR,
			// "Veuillez donner le prénom du deuxième bébé", ""));
			// addValid = false;
			// }

			if ((sexeBebe2 == null) || (sexeBebe2.trim().length() == 0)) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez spécifier le sexe du deuxième bébé", ""));
				addValid = false;
			}
			if ((etatBebe2 == null) || (etatBebe2.trim().length() == 0)) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez choisir un état pour le deuxième bébé", ""));
				addValid = false;
			}
		}
		if (nbBebe >= 3) {

			if ((sexeBebe3 == null) || (sexeBebe3.trim().length() == 0)) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "",
						"Veuillez spécifier le sexe du troisième bébé"));
				addValid = false;
			}
			if ((etatBebe3 == null) || (etatBebe3.trim().length() == 0)) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "",
						"Veuillez choisir un état pour le troisième bébé"));
				addValid = false;
			}
		}

		if (face.getMessageList().size() == 0) {
			if ((action1).equals("Modification Grossese")) {

				hg = sere.rechercheHistoriqueGrossParId(idhistoriqueGross);

				EtatFinGrossService ser = new EtatFinGrossService();
				EtatFinGross eFinG = ser.rechercheParEtatFinGross(etatFinGross);
				hg.setEtatFinGross(eFinG);
				hg.setLieu(lieu);
				hg.setTerme(terme);
				hg.setDateFinGross(dateFinGross);

				if (nbBebe == 1) {
					hg.setPrenomBebe(prenomBebe);

					try {
						poids = Float.parseFloat(poids + "");
						setPoids(poids);
					} catch (Exception e) {
						poids = (float) 0;

					}
					hg.setPoids(poids);

				}
				if (nbBebe == 2) {
					hg.setPrenomBebe(prenomBebe);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids(poids);
					} catch (Exception e) {
						poids = (float) 0;

					}
					hg.setPoids(poids);

					hg.setPrenomBebe2(prenomBebe2);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids2(poids);
					} catch (Exception e) {
						poids2 = (float) 0;

					}
					hg.setPoids2(poids2);

				}

				if (nbBebe == 3) {
					hg.setPrenomBebe(prenomBebe);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids(poids);
					} catch (Exception e) {
						poids = (float) 0;

					}
					hg.setPoids(poids);

					hg.setPrenomBebe2(prenomBebe2);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids2(poids);
					} catch (Exception e) {
						poids2 = (float) 0;

					}
					hg.setPoids2(poids2);

					hg.setPrenomBebe3(prenomBebe3);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids3(poids);
					} catch (Exception e) {
						poids3 = (float) 0;

					}
					hg.setPoids3(poids3);
				}

				EtatBebeService serb = new EtatBebeService();
				EtatBebe eBebe = serb.rechercheParEtatBebe(etatBebe);
				EtatBebe eBebe2 = serb.rechercheParEtatBebe(etatBebe2);
				EtatBebe eBebe3 = serb.rechercheParEtatBebe(etatBebe3);
				cf = se.RechercheCfclient(idPatient);

				if (eFinG != null) {

					if (eFinG.isIncrementation()) {

						if (eFinG.getEtatFinG().equals("Césarienne")) {
							cf.setCesar(cf.getCesar() + 1);
						}
						if (eBebe != null) {
							hg.setEtatBebe(eBebe);
							if (sexeBebe != null
									&& sexeBebe.trim().length() != 0) {
								hg.setSexeBebe(sexeBebe);
								if (eBebe.isIncrementation()) {
									cf.setPartie(cf.getPartie() + 1);

									if (sexeBebe.equals("Masculin"))
										cf.setNbrGarcon(cf.getNbrGarcon() + 1);

									else if (sexeBebe != null
											&& sexeBebe.equals("Féminin"))
										cf.setNbrFille(cf.getNbrFille() + 1);

								}
							}
							se.modifierPatient(cf);
						}

						if (eBebe2 != null) {
							hg.setEtatBebe2(eBebe2);
							if (eBebe2.isIncrementation())

								cf.setPartie(cf.getPartie() + 1);
							if (sexeBebe2 != null
									&& sexeBebe2.trim().length() != 0) {
								if (sexeBebe2.equals("Masculin"))
									cf.setNbrGarcon(cf.getNbrGarcon() + 1);
								else if (sexeBebe2.equals("Féminin"))
									cf.setNbrFille(cf.getNbrFille() + 1);
							}
							se.modifierPatient(cf);
						}

						if (eBebe3 != null) {
							hg.setEtatBebe3(eBebe3);
							if (eBebe3.isIncrementation())

								cf.setPartie(cf.getPartie() + 1);

							if (sexeBebe3 != null
									&& sexeBebe3.trim().length() != 0) {
								if (sexeBebe3.equals("Masculin"))
									cf.setNbrGarcon(cf.getNbrGarcon() + 1);
								else if (sexeBebe3.equals("Féminin")) {
									cf.setNbrFille(cf.getNbrFille() + 1);

								}
								se.modifierPatient(cf);
							}
							se.modifierPatient(cf);
						}

					}

					se.modifierPatient(cf);
					hg.setEtatBebe(eBebe);
					hg.setEtatBebe2(eBebe2);
					hg.setEtatBebe3(eBebe3);
					hg.setSexeBebe(sexeBebe);
					hg.setSexeBebe2(sexeBebe2);
					hg.setSexeBebe3(sexeBebe3);
					hg.setCfclient(cf);
					hg.setNotes(notes);
					sere.ModifierHistoriqueGross(hg);
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					index = 2;

					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Grosseses Modifié avec succès"));
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					context.addCallbackParam("addValid", addValid);
					try {

						context2.getExternalContext().redirect("Antecedent");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}
			if ((action1).equals("Ajout")) {
				hg.setDateFinGross(dateFinGross);

				EtatFinGrossService ser = new EtatFinGrossService();
				EtatFinGross eFinG = ser.rechercheParEtatFinGross(etatFinGross);
				hg.setEtatFinGross(eFinG);
				hg.setLieu(lieu);
				hg.setTerme(terme);

				if (nbBebe == 1) {
					hg.setPrenomBebe(prenomBebe);

					try {
						poids = Float.parseFloat(poids + "");
						setPoids(poids);
					} catch (Exception e) {
						poids = (float) 0;

					}
					hg.setPoids(poids);

				}
				if (nbBebe == 2) {
					hg.setPrenomBebe(prenomBebe);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids(poids);
					} catch (Exception e) {
						poids = (float) 0;

					}
					hg.setPoids(poids);

					hg.setPrenomBebe2(prenomBebe2);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids2(poids);
					} catch (Exception e) {
						poids2 = (float) 0;

					}
					hg.setPoids2(poids2);

				}

				if (nbBebe == 3) {
					hg.setPrenomBebe(prenomBebe);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids(poids);
					} catch (Exception e) {
						poids = (float) 0;

					}
					hg.setPoids(poids);

					hg.setPrenomBebe2(prenomBebe2);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids2(poids);
					} catch (Exception e) {
						poids2 = (float) 0;

					}
					hg.setPoids2(poids2);

					hg.setPrenomBebe3(prenomBebe3);
					try {
						poids = Float.parseFloat(poids + "");
						setPoids3(poids);
					} catch (Exception e) {
						poids3 = (float) 0;

					}
					hg.setPoids3(poids3);
				}

				EtatBebeService serb = new EtatBebeService();
				EtatBebe eBebe = serb.rechercheParEtatBebe(etatBebe);
				EtatBebe eBebe2 = serb.rechercheParEtatBebe(etatBebe2);
				EtatBebe eBebe3 = serb.rechercheParEtatBebe(etatBebe3);
				cf = se.RechercheCfclient(idPatient);

				if (eFinG != null) {

					if (eFinG.isIncrementation()) {

						if (eFinG.getEtatFinG().equals("Césarienne")) {
							cf.setCesar(cf.getCesar() + 1);
						}
						if (eBebe != null) {
							hg.setEtatBebe(eBebe);
							if (sexeBebe != null
									&& sexeBebe.trim().length() != 0) {
								hg.setSexeBebe(sexeBebe);
								if (eBebe.isIncrementation()) {
									cf.setPartie(cf.getPartie() + 1);

									if (sexeBebe.equals("Masculin"))
										cf.setNbrGarcon(cf.getNbrGarcon() + 1);

									else if (sexeBebe != null
											&& sexeBebe.equals("Féminin"))
										cf.setNbrFille(cf.getNbrFille() + 1);

								}
							}
							se.modifierPatient(cf);
						}

						if (eBebe2 != null) {
							hg.setEtatBebe2(eBebe2);
							if (eBebe2.isIncrementation())

								cf.setPartie(cf.getPartie() + 1);
							if (sexeBebe2 != null
									&& sexeBebe2.trim().length() != 0) {
								if (sexeBebe2.equals("Masculin"))
									cf.setNbrGarcon(cf.getNbrGarcon() + 1);
								else if (sexeBebe2.equals("Féminin"))
									cf.setNbrFille(cf.getNbrFille() + 1);
							}
							se.modifierPatient(cf);
						}

						if (eBebe3 != null) {
							hg.setEtatBebe3(eBebe3);
							if (eBebe3.isIncrementation())

								cf.setPartie(cf.getPartie() + 1);

							if (sexeBebe3 != null
									&& sexeBebe3.trim().length() != 0) {
								if (sexeBebe3.equals("Masculin"))
									cf.setNbrGarcon(cf.getNbrGarcon() + 1);
								else if (sexeBebe3.equals("Féminin")) {
									cf.setNbrFille(cf.getNbrFille() + 1);

								}
								se.modifierPatient(cf);
							}
							se.modifierPatient(cf);
						}

					}
					cf.setGestite(cf.getGestite() + 1);
					se.modifierPatient(cf);
					hg.setEtatBebe(eBebe);
					hg.setEtatBebe2(eBebe2);
					hg.setEtatBebe3(eBebe3);
					hg.setSexeBebe(sexeBebe);
					hg.setSexeBebe2(sexeBebe2);
					hg.setSexeBebe3(sexeBebe3);
					hg.setCfclient(cf);
					hg.setNotes(notes);
					sere.ajouterHistoriqueGross(hg);
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					index = 2;

					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Grosseses Ajouté avec succès"));
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					context.addCallbackParam("addValid", addValid);
					try {

						context2.getExternalContext().redirect("Antecedent");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}

			if (action1.equals("Modification")) {

				hg2 = sere.rechercheHistoriqueGrossParId(idhistoriqueGross);
				EtatFinGrossService ser = new EtatFinGrossService();
				EtatFinGross eFinG = ser.rechercheParEtatFinGross(etatFinGross);
				EtatFinGross eFinGA = ser
						.rechercheParEtatFinGross(etatFinGrossAncien);
				EtatBebeService seretatbebe = new EtatBebeService();

				EtatBebe etatbeb1 = seretatbebe.rechercheParEtatBebe(etatBebe);
				EtatBebe etatbebA1 = seretatbebe
						.rechercheParEtatBebe(etatBebeAncien);
				EtatBebe etatbeb2 = seretatbebe.rechercheParEtatBebe(etatBebe2);
				EtatBebe etatbebA2 = seretatbebe
						.rechercheParEtatBebe(etatBebe2Ancien);
				EtatBebe etatbeb3 = seretatbebe.rechercheParEtatBebe(etatBebe3);
				EtatBebe etatbebA3 = seretatbebe
						.rechercheParEtatBebe(etatBebe3Ancien);
				cf = se.RechercheCfclient(idPatient);
				if (hg2 != null) {
					if (etatFinGross != null && etatFinGrossAncien != null) {

						if ((eFinG.getEtatFinG().equals("Césarienne"))
								&& (eFinGA.getEtatFinG().equals("Césarienne") == false))
							cf.setCesar(cf.getCesar() + 1);
						if ((eFinG.getEtatFinG().equals("Césarienne") == false)
								&& (eFinGA.getEtatFinG().equals("Césarienne")))
							cf.setCesar(cf.getCesar() - 1);

						// etat fi grossesse courant incrimente
						if ((eFinG.isIncrementation()))

						{

							if (eFinGA.isIncrementation()) {

								if (nbBebe == 1) {
									if (nbBebe == nbBebeAncien) {
										if (etatbebA1.isIncrementation()
												&& etatbeb1.isIncrementation() == false) {
											cf.setPartie(cf.getPartie() - 1);
											if (sexeBebe.equals("Féminin")) {
												cf.setNbrFille(cf.getNbrFille() - 1);
											} else if (sexeBebeAncien
													.equals("Masculin"))
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
										}

										if ((etatbebA1.isIncrementation() == false)
												&& (etatbeb1.isIncrementation())) {
											cf.setPartie(cf.getPartie() + 1);
											if (sexeBebe.equals("Féminin")) {
												cf.setNbrFille(cf.getNbrFille() + 1);
											} else if (sexeBebeAncien
													.equals("Masculin"))
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
										}

										if ((etatbebA1.isIncrementation())
												&& (etatbeb1.isIncrementation())) {
											if (sexeBebe.equals(sexeBebeAncien) == false)
												if (sexeBebe.equals("Féminin")
														&& sexeBebeAncien
																.equals("Masculin")) {
													cf.setNbrFille(cf
															.getNbrFille() + 1);
													cf.setNbrGarcon(cf
															.getNbrGarcon() - 1);
												}
											if (sexeBebe.equals("Masculin")
													&& sexeBebeAncien
															.equals("Féminin")) {
												cf.setNbrFille(cf.getNbrFille() - 1);
												cf.setNbrGarcon(cf
														.getNbrGarcon() + 1);
											}
										}

									}

									else

									if (nbBebeAncien == 2) {
										if (etatbebA2.isIncrementation()) {
											cf.setPartie(cf.getPartie() - 1);
											if (sexeBebe2 != null)
												if (sexeBebe2.equals("Féminin"))

													cf.setNbrFille(cf
															.getNbrFille() - 1);
											if (sexeBebe2.equals("Masculin"))
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
										}

									}
									if (nbBebeAncien == 3) {

										if (etatbebA2.isIncrementation()) {
											cf.setPartie(cf.getPartie() - 1);
											if (sexeBebe2 != null)
												if (sexeBebe2.equals("Féminin"))

													cf.setNbrFille(cf
															.getNbrFille() - 1);
											if (sexeBebe2.equals("Masculin"))
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
										}
										if (etatbebA3.isIncrementation()) {
											cf.setPartie(cf.getPartie() - 1);
											if (sexeBebe3.equals("Féminin"))

												cf.setNbrFille(cf.getNbrFille() - 1);
											if (sexeBebe3.equals("Masculin"))
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
										}
									}
								}
								if (nbBebe == 2) {
									if (nbBebe == nbBebeAncien) {

										if (etatbebA1.isIncrementation()
												&& etatbeb1.isIncrementation() == false)
											cf.setPartie(cf.getPartie() - 1);
										if ((etatbebA1.isIncrementation() == false)
												&& (etatbeb1.isIncrementation())) {
											cf.setPartie(cf.getPartie() + 1);
										}
										if (etatbebA2.isIncrementation()
												&& etatbeb2.isIncrementation() == false)
											cf.setPartie(cf.getPartie() - 1);
										if ((etatbebA2.isIncrementation() == false)
												&& (etatbeb2.isIncrementation())) {
											cf.setPartie(cf.getPartie() + 1);
										}

										if ((etatbebA1.isIncrementation())
												&& (etatbeb1.isIncrementation())) {
											if (sexeBebe.equals(sexeBebeAncien) == false)
												if (sexeBebe.equals("Féminin")
														&& sexeBebeAncien
																.equals("Masculin")) {
													cf.setNbrFille(cf
															.getNbrFille() + 1);
													cf.setNbrGarcon(cf
															.getNbrGarcon() - 1);
												}
											if (sexeBebe.equals("Masculin")
													&& sexeBebeAncien
															.equals("Féminin")) {
												cf.setNbrFille(cf.getNbrFille() - 1);
												cf.setNbrGarcon(cf
														.getNbrGarcon() + 1);
											}
										}

										if ((etatbebA2.isIncrementation())
												&& (etatbeb2.isIncrementation())) {
											if (sexeBebe2
													.equals(sexeBebe2Ancien) == false)
												if (sexeBebe2.equals("Féminin")
														&& sexeBebe2Ancien
																.equals("Masculin")) {
													cf.setNbrFille(cf
															.getNbrFille() + 1);
													cf.setNbrGarcon(cf
															.getNbrGarcon() - 1);
												}
											if (sexeBebe2.equals("Masculin")
													&& sexeBebe2Ancien
															.equals("Féminin")) {
												cf.setNbrFille(cf.getNbrFille() - 1);
												cf.setNbrGarcon(cf
														.getNbrGarcon() + 1);
											}
										} else if (nbBebeAncien == 1) {
											if (etatbebA1.isIncrementation()) {
												if (sexeBebe
														.equals(sexeBebeAncien) == false)
													if (sexeBebe
															.equals("Féminin")
															&& sexeBebeAncien
																	.equals("Masculin")) {
														cf.setNbrFille(cf
																.getNbrFille() + 1);
														cf.setNbrGarcon(cf
																.getNbrGarcon() - 1);
													}
												if (sexeBebe.equals("Masculin")
														&& sexeBebeAncien
																.equals("Féminin")) {
													cf.setNbrFille(cf
															.getNbrFille() - 1);
													cf.setNbrGarcon(cf
															.getNbrGarcon() + 1);
												}

											}
										}
									}
									if (nbBebeAncien == 3) {
										if (etatbebA2.isIncrementation()) {
											cf.setPartie(cf.getPartie() - 1);
											if (sexeBebe2 != null)
												if (sexeBebe2.equals("Féminin"))

													cf.setNbrFille(cf
															.getNbrFille() - 1);
											if (sexeBebe2.equals("Masculin"))
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
										}
										if (etatbebA3.isIncrementation()) {
											cf.setPartie(cf.getPartie() - 1);
											if (sexeBebe3.equals("Féminin"))

												cf.setNbrFille(cf.getNbrFille() - 1);
											if (sexeBebe3.equals("Masculin"))
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
										}
									}

								}

								if ((nbBebe == 3)) {
									if (etatbebA1.isIncrementation()
											&& etatbeb1.isIncrementation() == false)
										cf.setPartie(cf.getPartie() - 1);
									if ((etatbebA1.isIncrementation() == false)
											&& (etatbeb1.isIncrementation())) {
										cf.setPartie(cf.getPartie() + 1);
									}

									if (etatbebA2.isIncrementation()
											&& etatbeb2.isIncrementation() == false)
										cf.setPartie(cf.getPartie() - 1);
									if ((etatbebA2.isIncrementation() == false)
											&& (etatbeb2.isIncrementation())) {
										cf.setPartie(cf.getPartie() + 1);
									}
									if (etatbebA3.isIncrementation()
											&& etatbeb3.isIncrementation() == false)
										cf.setPartie(cf.getPartie() - 1);

									if ((etatbebA3.isIncrementation() == false)
											&& (etatbeb3.isIncrementation())) {
										cf.setPartie(cf.getPartie() + 1);
									}
									if ((etatbebA1.isIncrementation())
											&& (etatbeb1.isIncrementation())) {

										if (sexeBebe.equals("Féminin")
												&& sexeBebeAncien
														.equals("Masculin")) {
											cf.setNbrFille(cf.getNbrFille() + 1);
											cf.setNbrGarcon(cf.getNbrGarcon() - 1);
										}
										if (sexeBebe.equals("Masculin")
												&& sexeBebeAncien
														.equals("Féminin")) {
											cf.setNbrFille(cf.getNbrFille() - 1);
											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										}
									}

									if ((etatbebA2.isIncrementation())
											&& (etatbeb2.isIncrementation())) {
										if (sexeBebe2.equals(sexeBebeAncien) == false)
											if (sexeBebe2.equals("Féminin")
													&& sexeBebe2Ancien
															.equals("Masculin")) {
												cf.setNbrFille(cf.getNbrFille() + 1);
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
											}
										if (sexeBebe2.equals("Masculin")
												&& sexeBebe2Ancien
														.equals("Féminin")) {
											cf.setNbrFille(cf.getNbrFille() - 1);
											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										}
									}
									if ((etatbebA3.isIncrementation())
											&& (etatbeb3.isIncrementation())) {
										if (sexeBebe3.equals(sexeBebeAncien) == false)
											if (sexeBebe3.equals("Féminin")
													&& sexeBebe3Ancien
															.equals("Masculin")) {
												cf.setNbrFille(cf.getNbrFille() + 1);
												cf.setNbrGarcon(cf
														.getNbrGarcon() - 1);
											}
										if (sexeBebe3.equals("Masculin")
												&& sexeBebe3Ancien
														.equals("Féminin")) {
											cf.setNbrFille(cf.getNbrFille() - 1);
											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										}
									}

								}

							}
							if (eFinGA.isIncrementation() == false)// ancien
																	// n'icrimente
																	// pas
							{
								if (nbBebe == 1) {
									if (etatbeb1.isIncrementation()) {
										cf.setPartie(cf.getPartie() + 1);
										if (sexeBebe.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										if (sexeBebe.equals("Féminin")) {
											cf.setNbrFille(cf.getNbrFille() + 1);
										}

									}
								}
								if (nbBebe == 2) {
									if (etatbeb1.isIncrementation()) {
										cf.setPartie(cf.getPartie() + 1);
										if (sexeBebe.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										if (sexeBebe.equals("Féminin")) {
											cf.setNbrFille(cf.getNbrFille() + 1);
										}
									}

									if (etatbeb2.isIncrementation()) {
										cf.setPartie(cf.getPartie() + 1);
										if (sexeBebe2.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										if (sexeBebe2.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() + 1);
									}
								}

								if (nbBebe == 3) {
									if (etatbeb1.isIncrementation()) {
										cf.setPartie(cf.getPartie() + 1);
										if (sexeBebe.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										if (sexeBebe.equals("Féminin")) {
											cf.setNbrFille(cf.getNbrFille() + 1);
										}
									}
									if (etatbeb2.isIncrementation()) {
										cf.setPartie(cf.getPartie() + 1);
										if (sexeBebe2.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										if (sexeBebe2.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() + 1);
									}
									if (etatbeb3.isIncrementation()) {
										cf.setPartie(cf.getPartie() + 1);
										if (sexeBebe3.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() + 1);
										if (sexeBebe3.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() + 1);
									}
								}
							}

						}
						// etat fin grossese courant n'icrimente pas

						else if (eFinG.isIncrementation() == false) {
							if (eFinGA.isIncrementation()) {

								if (nbBebe == 1) {
									if (etatbebA1.isIncrementation()) {
										cf.setPartie(cf.getPartie() - 1);
										if (sexeBebe.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() - 1);
										if (sexeBebe.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() - 1);

									}

								}
								if (nbBebe == 2) {
									if (etatbebA1.isIncrementation()) {
										cf.setPartie(cf.getPartie() - 1);

										if (sexeBebe.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() - 1);
										if (sexeBebe.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() - 1);

									}
									if (etatbebA2.isIncrementation()) {
										cf.setPartie(cf.getPartie() - 1);

										if (sexeBebe2.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() - 1);
										if (sexeBebe2.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() - 1);
									}

								}

								if (nbBebe == 3) {
									if (etatbebA1.isIncrementation()) {
										cf.setPartie(cf.getPartie() - 1);
										if (sexeBebe.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() - 1);
										if (sexeBebe.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() - 1);

									}
									if (etatbebA2.isIncrementation()) {
										cf.setPartie(cf.getPartie() - 1);

										if (sexeBebe2.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() - 1);
										if (sexeBebe2.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() - 1);
									}

									if (etatbebA3.isIncrementation()) {
										cf.setPartie(cf.getPartie() - 1);

										if (sexeBebe3.equals("Masculin"))

											cf.setNbrGarcon(cf.getNbrGarcon() - 1);
										if (sexeBebe3.equals("Féminin"))
											cf.setNbrFille(cf.getNbrFille() - 1);

									}

								}
							}
						}

					}
					se.modifierPatient(cf);
					hg2.setEtatFinGross(eFinG);
					hg2.setDateFinGross(dateFinGross);
					hg2.setPoids(poids);
					hg2.setNotes(notes);
					hg2.setPoids2(poids2);
					hg2.setPoids3(poids3);
					hg2.setSexeBebe(sexeBebe);
					hg2.setSexeBebe2(sexeBebe2);
					hg2.setSexeBebe3(sexeBebe3);
					hg2.setEtatBebe(etatbeb1);
					hg2.setEtatBebe2(etatbeb2);
					hg2.setEtatBebe3(etatbeb3);
					hg2.setPrenomBebe(prenomBebe);
					hg2.setPrenomBebe2(prenomBebe2);
					hg2.setPrenomBebe3(prenomBebe3);
					hg2.setTerme(terme);
					hg2.setLieu(lieu);
					sere.ModifierHistoriqueGross(hg2);
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					index = 2;

					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Grosseses modifiée avec succès"));
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					context.addCallbackParam("addValid", addValid);
					try {

						context2.getExternalContext().redirect("Antecedent");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}

			}

		}
	}

	public void validerContraception() {
		CfclientService se = new CfclientService();
		FacesContext face = FacesContext.getCurrentInstance();
		Contraception c = new Contraception();
		Contraception ce = new Contraception();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if ((dateDebut == null) || (dateDebut.trim().length() == 0)) {
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez donner la date de début."));
			addValid = false;

		} else {
			if (Module.corigerDate(dateDebut) != null) {
				this.setDateDebut(Module.corigerDate(dateDebut));
			}
			if (!(Module.verifierDate(dateDebut).equals("")))

			{
				face.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								Module.verifierDate(dateDebut)));
				addValid = false;

			}
		}

		if (face.getMessageList().size() == 0) {
			if (action1.equals("Ajout")) {

				c.setDateDebut(dateDebut);
				c.setMoyen(moyen);
				c.setRemarque(remarque);
				Cfclient cf = new Cfclient();

				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);
				idPatient = (Integer) session.getAttribute("idu");
				cf = se.RechercheCfclient(idPatient);
				c.setCfclient(cf);
				ContraceptionService ser = new ContraceptionService();
				ser.ajouterContraception(c);

				addValid = true;
				initialisation();
				RequestContext.getCurrentInstance().update("f1");
				index = 3;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Contracéption ajoutée avec Succès", ""));
				FacesContext context2 = FacesContext.getCurrentInstance();
				context2.getExternalContext().getFlash().setKeepMessages(true);
				try {

					context2.getExternalContext().redirect("Antecedent");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			if (action1.equals("Modification")) {
				c.setDateDebut(dateDebut);
				c.setMoyen(moyen);
				c.setRemarque(remarque);
				Cfclient cf = new Cfclient();
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);
				idPatient = (Integer) session.getAttribute("idu");
				cf = se.RechercheCfclient(idPatient);
				c.setCfclient(cf);
				ContraceptionService ser = new ContraceptionService();
				ce = ser.rechercheContraceptiParId(idcontraception);
				ce.setDateDebut(dateDebut);
				ce.setMoyen(moyen);
				ce.setRemarque(remarque);
				ser.modifierContraception(ce);
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Contracéption modifié avec succès", ""));
				addValid = true;
				initialisation();
				RequestContext.getCurrentInstance().update("f1");
				index = 3;
				FacesContext context2 = FacesContext.getCurrentInstance();
				context2.getExternalContext().getFlash().setKeepMessages(true);
				try {
					context2.getExternalContext().redirect("Antecedent");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);
		initialiser();
		if (s != null) {
			habitude = s.getHabitude();
			cohabitation = s.getCohabitation();
			sterilite = s.getSterilite();
			depuis = s.getDepuis();

			antecedent = s.getAntecedent();
			antecedentH = s.getAntecedentH();

			examens = s.getExamens();
			examensH = s.getExamensH();

			hormone = s.getHormone();
			hormoneH = s.getHormoneH();

			echoPelvienne = s.getEchoPelvienne();
			spermH = s.getSpermH();

			hsg = s.getHsg();
			bilanH = s.getBilanH();

			hysteroscopie = s.getHysteroscopie();
			traitementH = s.getTraitement();

			coelioscopie = getCoelioscopie();
			coital = s.getCoital();
			traitement = s.getCoital();
		}

	}

	public void initialiser() {
		habitude = null;
		cohabitation = null;
		sterilite = null;
		depuis = null;

		antecedent = null;
		antecedentH = null;

		examens = null;
		examensH = null;

		hormone = null;
		hormoneH = null;

		echoPelvienne = null;
		spermH = null;

		hsg = null;
		bilanH = null;

		hysteroscopie = null;
		traitementH = null;

		coelioscopie = null;
		coital = null;
		traitement = null;
	}

	public List<HistoriqueGross> getListHistoriqueGross() {

		// idPatient = Module.idpatient;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		HistoriqueGrossService ser = new HistoriqueGrossService();
		listHistoriqueGross = ser.rechercheToutHistoriqueGross(idPatient);
		return listHistoriqueGross;
	}

	public void setListHistoriqueGross(List<HistoriqueGross> listHistoriqueGross) {
		this.listHistoriqueGross = listHistoriqueGross;
	}

	public Integer getIdhistoriqueGross() {
		return idhistoriqueGross;
	}

	public void setIdhistoriqueGross(Integer idhistoriqueGross) {
		this.idhistoriqueGross = idhistoriqueGross;
	}

	public String getDebutGross() {
		return debutGross;
	}

	public void setDebutGross(String debutGross) {
		this.debutGross = debutGross;
	}

	public String getFinGross() {
		// Date actuelle = new Date();
		// * Definition du format utilise pour les dates
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// * Donne la date au format "aaaa-mm-jj"
		// finGross = dateFormat.format(actuelle);
		return finGross;
	}

	public void setFinGross(String finGross) {
		this.finGross = finGross;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getHonoraires() {
		return honoraires;
	}

	public void setHonoraires(String honoraires) {
		this.honoraires = honoraires;
	}

	public String getEtatFinGross() {
		return etatFinGross;
	}

	public void setEtatFinGross(String etatFinGross) {
		this.etatFinGross = etatFinGross;
	}

	public String getTerme() {
		return terme;
	}

	public void setTerme(String terme) {
		this.terme = terme;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getPrenomBebe() {
		return prenomBebe;
	}

	public void setPrenomBebe(String prenomBebe) {
		this.prenomBebe = prenomBebe;
	}

	public String getSexeBebe() {
		return sexeBebe;
	}

	public void setSexeBebe(String sexeBebe) {
		this.sexeBebe = sexeBebe;
	}

	public String getEtatBebe() {
		return etatBebe;
	}

	public void setEtatBebe(String etatBebe) {
		this.etatBebe = etatBebe;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	public void supprimerGross(HistoriqueGross h) {
		FacesContext face = FacesContext.getCurrentInstance();
		HistoriqueGrossService ser = new HistoriqueGrossService();
		Cfclient cf = h.getCfclient();
		CfclientService sercf = new CfclientService();
		if (h.getEtatFinGross() != null) {
			if (h.getEtatFinGross().getEtatFinG().equals("Césarienne"))
				cf.setCesar(cf.getCesar() - 1);
			// tester sur la valeur de etatfingross et etatbebe
			if (h.getEtatBebe() != null && h.getEtatBebe().isIncrementation()
					&& h.getEtatFinGross().isIncrementation()) {

				if (cf.getPartie() != 0) {
					cf.setPartie(cf.getPartie() - 1);
				}
				if (h.getSexeBebe() != null
						&& h.getSexeBebe().equals("Masculin"))
					cf.setNbrGarcon(cf.getNbrGarcon() - 1);
				if (h.getSexeBebe() != null
						&& h.getSexeBebe().equals("Féminin")) {
					cf.setNbrFille(cf.getNbrFille() - 1);
				}
			}

			if (h.getEtatBebe2() != null && h.getEtatBebe2().isIncrementation()
					&& h.getEtatFinGross().isIncrementation()) {

				if (cf.getPartie() != 0) {
					cf.setPartie(cf.getPartie() - 1);
				}
				if (h.getSexeBebe2() != null
						&& h.getSexeBebe2().equals("Masculin"))
					cf.setNbrGarcon(cf.getNbrGarcon() - 1);
				if (h.getSexeBebe2() != null
						&& h.getSexeBebe2().equals("Féminin")) {

					cf.setNbrFille(cf.getNbrFille() - 1);
				}
			}

			if (h.getEtatBebe3() != null && h.getEtatBebe3().isIncrementation()
					&& h.getEtatFinGross().isIncrementation()) {

				if (cf.getPartie() != 0) {
					cf.setPartie(cf.getPartie() - 1);
				}
				if (h.getSexeBebe3() != null
						&& h.getSexeBebe3().equals("Masculin"))
					cf.setNbrGarcon(cf.getNbrGarcon() - 1);
				if (h.getSexeBebe3() != null
						&& h.getSexeBebe3().equals("Féminin"))
					cf.setNbrFille(cf.getNbrFille() - 1);
			}
			cf.setGestite(cf.getGestite() - 1);
			sercf.modifierPatient(cf);
		}

		Integer code = h.getIdhistoriqueGross();
		ser.supprimerHistoriqueGross(code);
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Grossesse supprimé avec succés"));

		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);

		index = 2;

	}

	public List<AntFamCfclient> getAntecedentfs() {
		AntFamCfclientService s = new AntFamCfclientService();
		antecedentfs = s.rechercheAntFamParCfclient(idPatient);
		return antecedentfs;
	}

	public void setAntecedentfs(List<AntFamCfclient> antecedentfs) {
		this.antecedentfs = antecedentfs;
	}

	public List<AntChirCfclient> getAntecedentcs() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		AntChirCfclientService s = new AntChirCfclientService();
		antecedentcs = s.rechercheAntChirParCfclient(idPatient);
		return antecedentcs;
	}

	public void setAntecedentcs(List<AntChirCfclient> antecedentcs) {
		this.antecedentcs = antecedentcs;
	}

	public List<AntMedCfclient> getAntecedentms() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		AntMedCfclientService s = new AntMedCfclientService();
		antecedentms = s.rechercheAntMedParCfclient(idPatient);
		return antecedentms;
	}

	public void setAntecedentms(List<AntMedCfclient> antecedentms) {
		this.antecedentms = antecedentms;
	}

	public void onAntChange() {
		AntecedentMedService se = new AntecedentMedService();
		AntecedentMed antM = se.rechercheAntecedentMed(idantecedentMed);
		if (antM != null) {
			am = antM.getAntMedical();
			AntMedCfclient a = new AntMedCfclient();
			a.setCfclient(cfclient);
			a.setAntecedentMedical(am);
			AntMedCfclientService s = new AntMedCfclientService();
			s.ajoutAntMedCfclient(a);
			idantecedentMed = null;
		}

	}

	public Integer getIdantmedcfclient() {
		return idantmedcfclient;
	}

	public void setIdantmedcfclient(Integer idantmedcfclient) {
		this.idantmedcfclient = idantmedcfclient;
	}

	public void ajoutAnt() {
		if (idantecedentMed != null) {
			AntecedentMed a = new AntecedentMedService()
					.rechercheAntecedentMed(idantecedentMed);
			am = a.getAntMedical();
		}

		if (idantecedentChir != null) {
			AntecedentChir a = new AntecedentChirService()
					.rechercheAntecedentChir(idantecedentChir);
			am = a.getAntChirugical();
		}

		if (idantecedentFam != null) {
			AntecedentFam a = new AntecedentFamService()
					.rechercheAntecedentFam(idantecedentFam);
			am = a.getAntFamilial();
		}
	}

	public void ajouterAntMed() {
		if (idantecedentMed != null) {
			AntMedCfclient a = new AntMedCfclient();
			a.setCfclient(cfclient);
			a.setAntecedentMedical(am);
			a.setDate(dateAm);
			AntMedCfclientService s = new AntMedCfclientService();
			s.ajoutAntMedCfclient(a);
			idantecedentMed = null;
		}

		if (idantecedentChir != null) {
			AntChirCfclient a = new AntChirCfclient();
			a.setCfclient(cfclient);
			a.setAntecedentChirugical(am);
			a.setDate(dateAm);
			AntChirCfclientService s = new AntChirCfclientService();
			s.ajoutAntChirCfclient(a);
			idantecedentChir = null;
		}

		if (idantecedentFam != null) {
			AntFamCfclient a = new AntFamCfclient();
			a.setCfclient(cfclient);
			a.setAntecedentFamilial(am);
			a.setDate(dateAm);
			AntFamCfclientService s = new AntFamCfclientService();
			s.ajoutAntFamCfclient(a);
			idantecedentFam = null;
		}
		am = null;
		dateAm = null;
		try {
			index = 0;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validerAntMed() {
		if (am != null) {
			if (idantmedcfclient != null) {

				AntMedCfclient a = new AntMedCfclient();
				a.setCfclient(cfclient);
				a.setAntecedentMedical(am);
				a.setDate(dateAm);
				a.setIdantmedcfclient(idantmedcfclient);

				AntMedCfclientService s = new AntMedCfclientService();
				s.modifierAntMedCfclient(a);
				idantecedentMed = null;
			}
			if (idantchircfclient != null) {
				AntChirCfclient a = new AntChirCfclient();
				a.setCfclient(cfclient);
				a.setAntecedentChirugical(am);
				a.setDate(dateAm);
				a.setIdantchircfclient(idantchircfclient);
				AntChirCfclientService s = new AntChirCfclientService();
				s.modifierAntChirCfclient(a);
				idantecedentChir = null;
			}
			if (idantfamcfclient != null) {
				AntFamCfclient a = new AntFamCfclient();
				a.setCfclient(cfclient);
				a.setAntecedentFamilial(am);
				a.setDate(dateAm);
				a.setIdantfamcfclient(idantfamcfclient);
				AntFamCfclientService s = new AntFamCfclientService();
				s.modifierAntFamCfclient(a);
				idantecedentChir = null;
			}
		}
		dateAm = null;
		am = null;
		try {
			index = 0;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void onAntChirChange() {

		AntecedentChirService se = new AntecedentChirService();
		AntecedentChir antChir = se.rechercheAntecedentChir(idantecedentChir);

		if (antChir != null) {
			am = antChir.getAntChirugical();
			AntChirCfclient a = new AntChirCfclient();
			a.setCfclient(cfclient);
			a.setAntecedentChirugical(am);
			AntChirCfclientService s = new AntChirCfclientService();
			s.ajoutAntChirCfclient(a);
			idantecedentChir = null;
		}
		try {
			index = 0;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void onAntFamChange() {
		AntecedentFamService se = new AntecedentFamService();
		AntecedentFam antFam = se.rechercheAntecedentFam(idantecedentFam);
		if (antFam != null) {
			am = antFam.getAntFamilial();
			AntFamCfclient a = new AntFamCfclient();
			a.setCfclient(cfclient);
			a.setAntecedentFamilial(am);
			AntFamCfclientService s = new AntFamCfclientService();
			s.ajoutAntFamCfclient(a);
			idantecedentFam = null;
		}
		try {
			index = 0;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getTitre() {
		if (Module.action.equals("nouveau")) {
			titre = "Nouvelle Grossesse";
		} else {
			titre = "Modifier Grossesse";
		}
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTitrecontraception() {
		if (Module.action.equals("nouveau")) {
			titrecontraception = "Nouvelle Contraception";
		} else {
			titrecontraception = "Modifier Contraception";
		}

		return titrecontraception;
	}

	public void setTitrecontraception(String titrecontraception) {
		this.titrecontraception = titrecontraception;
	}

	public String getAction1() {
		return action1;
	}

	public void setAction1(String action1) {
		this.action1 = action1;
	}

	public void supprimeAntFam(Integer id) {
		AntFamCfclientService ser = new AntFamCfclientService();
		ser.supprimerAntFamCfclient(id);
		try {
			index = 0;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void supprimeAntMed(Integer id) {
		AntMedCfclientService ser = new AntMedCfclientService();
		ser.supprimerAntMedCfclient(id);
		try {
			index = 0;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void supprimeAntChir(Integer id) {
		AntChirCfclientService ser = new AntChirCfclientService();
		ser.supprimerAntChirCfclient(id);
		try {
			index = 0;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void supprimerContraception(Integer id) {
		ContraceptionService ser = new ContraceptionService();
		ser.supprimerContraception(id);
		FacesContext face = FacesContext.getCurrentInstance();

		index = 3;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Moyen de contraception est supprimé avec succès.", ""));
	}

	public void modifAntMed(AntMedCfclient ant) {
		dateAm = ant.getDate();
		am = ant.getAntecedentMedical();
		idantmedcfclient = ant.getIdantmedcfclient();
		idantfamcfclient = null;
		idantchircfclient = null;
	}

	public Integer getIdantchircfclient() {
		return idantchircfclient;
	}

	public void setIdantchircfclient(Integer idantchircfclient) {
		this.idantchircfclient = idantchircfclient;
	}

	public void modifAntChir(AntChirCfclient ant) {
		dateAm = ant.getDate();
		am = ant.getAntecedentChirugical();
		idantchircfclient = ant.getIdantchircfclient();
		idantfamcfclient = null;
		idantmedcfclient = null;
	}

	public Integer getIdantfamcfclient() {
		return idantfamcfclient;
	}

	public void setIdantfamcfclient(Integer idantfamcfclient) {
		this.idantfamcfclient = idantfamcfclient;
	}

	public void modifAntFam(AntFamCfclient ant) {
		dateAm = ant.getDate();
		am = ant.getAntecedentFamilial();
		idantfamcfclient = ant.getIdantfamcfclient();
		idantchircfclient = null;
		idantmedcfclient = null;
	}

	public void annulation() {
		initialisation();

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Antecedent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// public void verifDate() {
	//
	// // corriger la date
	// // DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	//
	// // String reportDate = df.format(dateFinGross);
	// //
	// // String dateCorrige = Module.corigerDate(reportDate);
	// if (dateFinGross != null) {
	// try {// vérifie la validité de la date
	// // Module.verifierDate(dateCorrige);
	// // calcul et mettre à jour du champs terme
	// // terme= date_Fin_Gross-DDR=X semaines Y jours
	// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//
	// // dateFinGross = sdf.parse(dateCorrige);
	// CfclientService serc = new CfclientService();
	// Cfclient cf = serc.RechercheCfclient(idPatient);
	// Date ddr = null;
	// if (cf != null)
	// if (cf.getDdr() != null) {
	// ddr = sdf.parse(cf.getDdr());
	// long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
	// long diff = Math.abs(ddr.getTime()
	// - dateFinGross.getTime());
	// long numberOfDay = (long) diff / CONST_DURATION_OF_DAY;
	// int semaine = (int) (numberOfDay / 7);
	// int jourr = (int) (numberOfDay % 7);
	// terme = semaine + "s" + jourr + "j";
	// }
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	// }
	// // dateCorrige = null;
	// }

	public void nbrBebeChange() {
		if (nbBebe == 0) {
			unBebe = false;
			deuxBebe = false;
			troisBebe = false;
		}
		if (nbBebe == 1) {
			unBebe = true;
			deuxBebe = false;
			troisBebe = false;

		}
		if (nbBebe == 2) {
			unBebe = true;
			deuxBebe = true;
			troisBebe = false;

		}
		if (nbBebe == 3) {
			unBebe = true;
			deuxBebe = true;
			troisBebe = true;

		}
	}

	public void changeTerme() {
		setTerme(terme);
	}

	public void changeLieu() {
		setLieu(lieu);
	}

	public void changeEtatGross() {
		setEtatFinGross(etatFinGross);
	}

	public void changePrenom() {
		setPrenomBebe(prenomBebe);
	}

	public void changeEtatBebe() {
		setEtatBebe(etatBebe);
	}

	public void changePoids() {
		poids = Float.parseFloat(poids + "");
		setPoids(poids);
	}

	public void changeSexeBebe() {

		setSexeBebe(sexeBebe);
	}

	public void changePrenom2() {
		setPrenomBebe2(prenomBebe2);
	}

	public void changeEtatBebe2() {
		setEtatBebe2(etatBebe2);
	}

	public void changePoids2() {
		setPoids2(poids2);
	}

	public void changeSexeBebe2() {
		setSexeBebe2(sexeBebe2);
	}

	public void changePrenom3() {
		setPrenomBebe3(prenomBebe3);
	}

	public void changeEtatBebe3() {
		setEtatBebe3(etatBebe3);
	}

	public void changePoids3() {
		setPoids3(poids3);
	}

	public void changeSexeBebe3() {
		setSexeBebe3(sexeBebe3);
	}

	public void ageRegleChange() {

		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setDpr(dpr);
			serc.modifierPatient(c);
		}

	}

	public void dysmenorheChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setDysmenorhe(dysmenorhe);
			serc.modifierPatient(c);
		}
	}

	public void mastodynieChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setMastodynie(mastodynie);
			serc.modifierPatient(c);
		}
	}

	public void menoposeChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setMenopose(menopose);
			serc.modifierPatient(c);
		}
	}

	public void consangChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setConsang(consang);
			serc.modifierPatient(c);
		}
	}

	public void gestiteChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setGestite(gestite);
			serc.modifierPatient(c);
		}
	}

	public void partieChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setPartie(partie);
			serc.modifierPatient(c);
		}
	}

	public void nbrGarconChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setNbrGarcon(nbrGarcon);
			serc.modifierPatient(c);
		}
	}

	public void nbrFilleChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setNbrFille(nbrFille);
			serc.modifierPatient(c);
		}
	}

	public void cesarChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setCesar(cesar);
			serc.modifierPatient(c);
		}
	}

	public void spanioChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setSpanio(spanio);
			serc.modifierPatient(c);
		}
	}

	public void mariageChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setMariage(mariage);

			serc.modifierPatient(c);
		}
	}

	public void cycleTypeChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setCycleType(cycleType);
			serc.modifierPatient(c);
		}
	}

	public void regleTypeChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setRegleType(regleType);
			serc.modifierPatient(c);
		}
	}

	public void reglesChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {

			c.setRegles(regles);
			serc.modifierPatient(c);
		}
	}

	public void cycleChange() {
		CfclientService serc = new CfclientService();
		Cfclient c = serc.RechercheCfclient(idPatient);
		if (c != null) {
			c.setCycle(cycle);
			serc.modifierPatient(c);
		}
	}

	public void amChange() {
		setAm(am);
	}

	public void bipSonore() {
		File audioFile = new File("/son/bip.wav");

		try {
			AudioInputStream audioStream = AudioSystem
					.getAudioInputStream(audioFile);

			AudioFormat format = audioStream.getFormat();

			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip audioClip = (Clip) AudioSystem.getLine(info);

			audioClip.addLineListener(this);

			audioClip.open(audioStream);

			audioClip.start();
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void update(LineEvent arg0) {

	}

	public void ajouterAntecedent() {
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		// Controle de saisi nom obligatoire
		if (nomAntecedent == null || nomAntecedent.trim().length() == 0) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de l'antécédent.", ""));
			addValid = false;
		}

		if (faces.getMessageList().size() == 0) {
			if (actionAnt.equals("Ajout")) {
				// Controle de saisie de l'unicité
				if (typeAnt.equals("médical")) {
					AntecedentMed antM = new AntecedentMedService()
							.rechercheParAntecedentMed(nomAntecedent);
					if (antM != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentMed a = new AntecedentMed();
						a.setAntMedical(nomAntecedent);
						new AntecedentMedService().ajoutAntecedentMed(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						idantecedentMed=a.getIdantecedentMed();
						if (idantecedentMed != null) {
							AntMedCfclient an = new AntMedCfclient();
							an.setCfclient(cfclient);
							an.setAntecedentMedical(nomAntecedent);
							AntMedCfclientService s = new AntMedCfclientService();
							s.ajoutAntMedCfclient(an);
							idantecedentMed = null;
						}

						
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext()
									.redirect("Antecedent");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}

				} else if (typeAnt.equals("familial")) {
					AntecedentFam antF = new AntecedentFamService()
							.rechercheParAntecedentFam(nomAntecedent);
					if (antF != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentFam a = new AntecedentFam();
						a.setAntFamilial(nomAntecedent);
						new AntecedentFamService().ajoutAntecedentFam(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						
						idantecedentFam=a.getIdantecedentFam();
						if (idantecedentFam != null) {
							AntFamCfclient an = new AntFamCfclient();
							an.setCfclient(cfclient);
							an.setAntecedentFamilial(nomAntecedent);
							AntFamCfclientService s = new AntFamCfclientService();
							s.ajoutAntFamCfclient(an);
							idantecedentFam = null;
						}
						
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext()
									.redirect("Antecedent");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				} else if (typeAnt.equals("chirugical")) {
					AntecedentChir antC = new AntecedentChirService()
							.rechercheParAntecedentChir(nomAntecedent);
					if (antC != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentChir a = new AntecedentChir();
						a.setAntChirugical(nomAntecedent);
						new AntecedentChirService().ajoutAntecedentChir(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						idantecedentChir=a.getIdantecedentChir();
						if (idantecedentChir != null) {
							AntChirCfclient an = new AntChirCfclient();
							an.setCfclient(cfclient);
							an.setAntecedentChirugical(nomAntecedent);
							AntChirCfclientService s = new AntChirCfclientService();
							s.ajoutAntChirCfclient(an);
							idantecedentChir = null;
						}
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext()
									.redirect("Antecedent");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	// affectation des action et type antécédent lors de gestion
	public void ajouterAntecedentMed() {
		actionAnt = "Ajout";
		typeAnt = "médical";
	}

	public void ajouterAntecedentFam() {
		actionAnt = "Ajout";
		typeAnt = "familial";
	}

	public void ajouterAntecedentChir() {
		actionAnt = "Ajout";
		typeAnt = "chirugical";
	}

	public void validerAntecedent() {
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		// Controle de saisi nom obligatoire
		if (nomAntecedent == null || nomAntecedent.trim().length() == 0) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de l'antécédent.", ""));
			addValid = false;
		}

		if (faces.getMessageList().size() == 0) {
			if (actionAnt.equals("Ajout")) {
				// Controle de saisie de l'unicité
				if (typeAnt.equals("médical")) {
					AntecedentMed antM = new AntecedentMedService()
							.rechercheParAntecedentMed(nomAntecedent);
					if (antM != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentMed a = new AntecedentMed();
						a.setAntMedical(nomAntecedent);
						new AntecedentMedService().ajoutAntecedentMed(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");

					}

				} else if (typeAnt.equals("familial")) {
					AntecedentFam antF = new AntecedentFamService()
							.rechercheParAntecedentFam(nomAntecedent);
					if (antF != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentFam a = new AntecedentFam();
						a.setAntFamilial(nomAntecedent);
						new AntecedentFamService().ajoutAntecedentFam(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");

					}
				} else if (typeAnt.equals("chirugical")) {
					AntecedentChir antC = new AntecedentChirService()
							.rechercheParAntecedentChir(nomAntecedent);
					if (antC != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentChir a = new AntecedentChir();
						a.setAntChirugical(nomAntecedent);
						new AntecedentChirService().ajoutAntecedentChir(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
					}
				}

			} else if (actionAnt.equals("Modification")) {
				if (typeAnt.equals("médical")) {
					AntecedentMed antM = new AntecedentMedService()
							.rechercheParAntecedentMed(nomAntecedent);
					if (antM != null) {
						if (!antM.getIdantecedentMed().equals(idantecedentMed)) {
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Il exist déjà un antécédent sous le nom \" "
											+ nomAntecedent + " \".", ""));
							addValid = false;
						} else {
							AntecedentMed a = new AntecedentMed();
							a.setAntMedical(nomAntecedent);
							a.setIdantecedentMed(idantecedentMed);
							new AntecedentMedService().modifierAntecedentMed(a);
							addValid = true;
							initialisationDialog();
							RequestContext.getCurrentInstance().update("f1");

						}

					} else {
						AntecedentMed a = new AntecedentMed();
						a.setAntMedical(nomAntecedent);
						a.setIdantecedentMed(idantecedentMed);
						new AntecedentMedService().modifierAntecedentMed(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");

					}

				}

				if (typeAnt.equals("familial")) {
					AntecedentFam antF = new AntecedentFamService()
							.rechercheParAntecedentFam(nomAntecedent);
					if (antF != null) {
						if (!antF.getIdantecedentFam().equals(idantecedentFam)) {
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Il exist déjà un antécédent sous le nom \" "
											+ nomAntecedent + " \".", ""));
							addValid = false;
						} else {
							AntecedentFam a = new AntecedentFam();
							a.setAntFamilial(nomAntecedent);
							a.setIdantecedentFam(idantecedentFam);
							new AntecedentFamService().modifierAntecedentFam(a);
							addValid = true;
							initialisationDialog();
							RequestContext.getCurrentInstance().update("f1");

						}

					} else {
						AntecedentFam a = new AntecedentFam();
						a.setAntFamilial(nomAntecedent);
						a.setIdantecedentFam(idantecedentFam);
						new AntecedentFamService().modifierAntecedentFam(a);
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");

					}
				}

				if (typeAnt.equals("chirugical")) {
					AntecedentChir antC = new AntecedentChirService()
							.rechercheParAntecedentChir(nomAntecedent);
					if (antC != null) {
						if (!antC.getIdantecedentChir()
								.equals(idantecedentChir)) {
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Il exist déjà un antécédent sous le nom \" "
											+ nomAntecedent + " \".", ""));
							addValid = false;
						} else {
							AntecedentChir a = new AntecedentChir();
							a.setAntChirugical(nomAntecedent);
							a.setIdantecedentChir(idantecedentChir);
							new AntecedentChirService()
									.modifierAntecedentChir(a);
							addValid = true;
							initialisationDialog();
							RequestContext.getCurrentInstance().update("f1");
						}
					} else {
						AntecedentChir a = new AntecedentChir();
						a.setAntChirugical(nomAntecedent);
						a.setIdantecedentChir(idantecedentChir);
						new AntecedentChirService().modifierAntecedentChir(a);
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
					}
				}
			}
		}
		context.addCallbackParam("addValid", addValid);

	}

	public void initialisationDialog() {
		actionAnt = null;
		typeAnt = null;
		nomAntecedent = null;
		idantecedentChir = null;
		idantecedentFam = null;
		idantecedentMed = null;

	}

	public void suppressionAntMed(AntecedentMed ant) {
		new AntecedentMedService().supprimerAntecedentMed(ant
				.getIdantecedentMed());
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"L'antécédent \" " + ant.getAntMedical()
						+ " \" est supprimé avec succès.", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		index = 0;
		try {

			context2.getExternalContext().redirect("GestionAntecedents");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void suppressionAntFam(AntecedentFam ant) {
		new AntecedentFamService().supprimerAntecedentFam(ant
				.getIdantecedentFam());
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"L'antécédent \" " + ant.getAntFamilial()
						+ " \" est supprimé avec succès.", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		index = 2;
		try {

			context2.getExternalContext().redirect("GestionAntecedents");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void suppressionAntChir(AntecedentChir ant) {
		new AntecedentChirService().supprimerAntecedentChir(ant
				.getIdantecedentChir());
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"L'antécédent \" " + ant.getAntChirugical()
						+ " \" est supprimé avec succès.", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		index = 1;
		try {

			context2.getExternalContext().redirect("GestionAntecedents");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void modificationAntMed(AntecedentMed ant) {
		actionAnt = "Modification";
		typeAnt = "médical";
		nomAntecedent = ant.getAntMedical();
		idantecedentMed = ant.getIdantecedentMed();
	}

	public void modificationAntFam(AntecedentFam ant) {
		actionAnt = "Modification";
		typeAnt = "familial";
		nomAntecedent = ant.getAntFamilial();
		idantecedentFam = ant.getIdantecedentFam();
	}

	public void modificationAntChir(AntecedentChir ant) {
		actionAnt = "Modification";
		typeAnt = "chirugical";
		nomAntecedent = ant.getAntChirugical();
		idantecedentChir = ant.getIdantecedentChir();
	}

	public void ajoutMoyen() {

		MoyenContraceptionService ser = new MoyenContraceptionService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (moyen == null || (moyen.trim().length() == 0)) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom du moyen de contraception.", ""));
			addValid = false;
		} else // tester si cette etat existe déjà
		{

			MoyenContraception d3 = ser
					.rechercheMoyenContraceptionParLibelleMoyenContraception(moyen);
			if (d3 == null) {

				MoyenContraception d1 = new MoyenContraception(moyen);

				ser.ajoutMoyenContraception(d1);
				faces.addMessage(null, new FacesMessage("Le moyen \"" + moyen
						+ "\" ajouté avec succès."));
				addValid = true;
				setMoyen(moyen);

			} else

			{
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Le moyen \"" + moyen
								+ "\" existe déjà.", ""));
				addValid = false;
			}

		}
		context.addCallbackParam("addValid", addValid);
	}

	private boolean increment;

	public boolean isIncrement() {
		return increment;
	}

	public void setIncrement(boolean increment) {
		this.increment = increment;
	}

	public void ajouterEFG() {
		FacesContext faces = FacesContext.getCurrentInstance();
		EtatFinGrossService ser = new EtatFinGrossService();

		EtatFinGross d3 = ser.rechercheParEtatFinGross(etatFG);
		boolean addValid = false;
		RequestContext contextMsg = RequestContext.getCurrentInstance();
		if (d3 == null) { // c-à-d n'existe pas etatFinG avec cette //
							// "etatFinG"
			EtatFinGross d1 = new EtatFinGross();
			d1.setEtatFinG(etatFG);
			d1.setIncrementation(increment);
			ser.ajoutEtatFinGross(d1);
			// RequestContext context = RequestContext.getCurrentInstance();
			contextMsg.execute("PF('diagAjoutEFG').hide();");
			contextMsg.execute("PF('diag2').show();");
			faces.addMessage(null, new FacesMessage("Etat ajouté avec succès."));
			addValid = true;

			faces.getExternalContext().getFlash().setKeepMessages(true);
			etatFinGrosss = getEtatFinGrosss();
			etatFinGross = etatFG;
			etatFG = null;
		} else {
			addValid = false;
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "L'état \"" + etatFG
							+ "\" existe déjà.", null));
			faces.getExternalContext().getFlash().setKeepMessages(true);
		}
		contextMsg.addCallbackParam("addValid", addValid);
	}

	public void moyenChange() {
		setMoyen(moyen);
	}

	public void annulationEFG() {
		etatFG = null;
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('diagAjoutEFG').hide();");
		context.execute("PF('diag2').show();");
	}

	public void initContra() {
		moyen = null;
	}

	public void dateAmChange() {
		setDateAm(dateAm);
	}

	public void etatFGChange() {
		setEtatFG(etatFG);
	}

	private String etBebe;
	private boolean incre;

	public String getEtBebe() {
		return etBebe;
	}

	public void setEtBebe(String etBebe) {
		this.etBebe = etBebe;
	}

	public boolean isIncre() {
		return incre;
	}

	public void setIncre(boolean incre) {
		this.incre = incre;
	}

	public void ajoutPlusEtatBebe() {
		EtatBebeService ebs = new EtatBebeService();
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (etBebe == null || (etBebe.trim().length() == 0)) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de l'état.", null));
			addValid = false;
		} else // tester si cette etatBebe existe déjà
		{
			EtatBebe d3 = ebs.rechercheParEtatBebe(etBebe);
			if (d3 == null) { // c-à-d n'existe pas etatBebe avec cette //
								// "etatBebe"
				EtatBebe d1 = new EtatBebe(etBebe);
				d1.setIncrementation(incre);
				ebs.ajoutEtatBebe(d1);

				faces.addMessage(null, new FacesMessage(
						"Etat bébé ajouté avec succès."));
				addValid = true;
				context.execute("PF('plusEtatBebe').hide();");

				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("Antecedent");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				context.execute("PF('diag2').show();");
				// RequestContext.getCurrentInstance().update("f1");

			} else {

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "L'état \"" + etBebe
								+ "\" existe déjà.", null));
				addValid = false;

			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void gotoAccueuil() {

		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void gotoFiche() {

		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public String getDateFinGrossString() {

		return dateFinGrossString;
	}

	public void setDateFinGrossString(String dateFinGrossString) {
		if (dateFinGrossString != null)
			this.dateFinGrossString = dateFinGrossString;
		try {
			dateFinGross = formatter.parse(dateFinGrossString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
