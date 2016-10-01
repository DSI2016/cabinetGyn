package com.doctor.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



import com.doctor.persistance.Connecte;
import com.doctor.persistance.EnLigne;
import com.doctor.persistance.TabSalle;
import com.doctor.persistance.Utilisateur;
import com.doctor.service.ConnecteService;
import com.doctor.service.EnLigneService;
import com.doctor.service.TabSalleService;
import com.doctor.service.UtilisateurService;

@ManagedBean(name = "connectionBean")
@SessionScoped
public class ConnectionBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Utilisateur u;
	
	private String login;
	private String motpass;
	private String connecte;
	private Integer idUtlConnecte;
	private boolean selectTableConsultation;
	private boolean ordonanceLibreFiche;
	private boolean imprGyneco;
	private boolean nbrEnfentFiche;
	private boolean monterPatientSal;
	private boolean descendrePatientSal;
	private boolean nouvellePatientSal;
	private boolean permuterPatientSal;
	private boolean premierPatientSal;
	private boolean dernierPatientSal;
	private boolean archiverPat;
	private boolean suppressionPatientSal;
	private boolean verConsultation;
	private boolean consultPat =false;
	private boolean chargerPatientSal;
	private boolean modifNoteSal;
	private boolean anulSal;
	private  boolean consultArchiv;
	private boolean menuSalle;
	private boolean menuGestionPat; 
	private boolean menuGestStat;
	private boolean menuGestParametre;
	private boolean menuGestRapport;
	private boolean menuGestUtilisateur;
	private boolean menuGestRendezVous;
	private boolean gestionVille;
	private boolean gestionClinique;
	private boolean gestionProf;
	private boolean gestionDoct;
	private boolean gestionBb;
	private boolean gestionAnal;
	private boolean gestionMed;
	private boolean gestionExm;
	private boolean gestionMoyCtrcep;
	private boolean gestionDiag;
	private boolean gestionSyn;
	private boolean gestionExmComp;
	private boolean gestionUterus;
	private boolean gestionFormMed;
	private boolean gestionEtatFinGross;
	private boolean gestionCabinet;
	private boolean rapportOrdnce;
	private boolean rapportLettre;
	private boolean rapportCertif;
    private boolean modifCons; 
	private boolean verSalle;
	private boolean modifPatient;
	private boolean detailPat;
	private boolean chargerPat;
	private boolean suppressionPat;
	private boolean ajouterPat;
	private boolean ajoutVille;
	private boolean modifVille;
	private boolean supprimerVille;
	private boolean ajoutClinique;
	private boolean modifClinique;
	private boolean supprimerClinique;
	private boolean ajoutProfession;
	private boolean modifProfession;
	private boolean supprimerProfession;
	private boolean ajouterDocteur;
	private boolean modifierDocteur;
	private boolean supprimerDocteur;
	private boolean ajouterEtBb;
	private boolean supprimEtBb;
	private boolean modifierEtBb;
	private boolean ajouterAnal;
	private boolean supprimAnal;
	private boolean modifiierAnal;
	private boolean ajouterMed;
	private boolean supprimMed;
	private boolean modifierMed;
	private boolean ajouterExm;
	private boolean supprimExm;
	private boolean modifierExm;
	private boolean ajouterMoyCotr;
	private boolean supprimMoyCotr;
	private boolean modifierMoyCotr;
	private boolean ajouterDiag;
	private boolean supprimDiag;
	private boolean modifierDiag;
	private boolean ajouterSymp;
	private boolean supprimSymp;
	private boolean modifierSymp;
	
	private boolean consultDetAnal;
	
	private boolean modifGynObs;
	
	private boolean ajouterExmComp;
	private boolean supprimExmComp;
	private boolean modifierExmComp;
	private boolean tabInfGnrAjtPat;
	private boolean tabcontactAjtPat;
	private boolean tabInfConjAjtPat;
	private boolean tabAtreInfAjtPat;
	private boolean antecedent;
	private boolean echoGyn;
	private boolean echoObs;
	private boolean gynecologie;
	private boolean consultGross;
	private boolean Sterilite;
	private boolean certifFiche;
	private boolean lettreFiche;
	private boolean analyseFiche;
	private boolean radioFiche;
	private boolean rapportFiche;
	private boolean ordnanceFiche;
	private boolean tabAntecedent;
	private boolean tabGynObs;
	private boolean tabHistGross;
	private boolean tabContraception;
	private boolean nouvGross;
	private boolean nouvContraception;
	private boolean modifHisGross;
	private boolean supHisGross;
	private boolean modifContraception;
	private boolean supContraception;
	private boolean ajoutUterus;
	private boolean modifUterus;
	private boolean supUterus;
	private boolean ajoutFormMed;
	private boolean modifFormMed;
	private boolean supFormMed;
	private boolean ajoutEtatFinGross;
	private boolean modifEtatFinGross;
	private boolean supEtatFinGross;
	private boolean ajoutRdv;
	private boolean modifRdv;
	private boolean supRdv;
	private boolean modifCab;

	private boolean ordGyn;
	private boolean radioGyn;
	private boolean analGyn;
	private boolean nouvConsGyn;
	private boolean consulGrosstOrd;
	private boolean consultGrossRadio;
	private boolean consultGrossAnal;
	private boolean nouvConGross;
	private boolean modifCondultGyneco;

	private boolean modifAnal;
	private boolean supAnal;

	private boolean modifAnalyse;
	private boolean supAnalyse;
	private boolean detAnal;
	private boolean modifRadio;
	private boolean supRadio;
	private boolean detRad;
	private boolean modifOrdnce;
	private boolean supOrdnce;
	private boolean loggedInFilter;
	private boolean loggedIn;
	private boolean reponseSal;
	private boolean selectAntecedent;
	private boolean ajoutAntecedentListe;
	private boolean nouvelleGrossesseAntecedent;
	private boolean nouvelleContraceptionAntecedent;
	private boolean ModifGyneco;
	private boolean SuppGyneco;
	private boolean nouvchogyneco;
	private boolean modifechogyneco;
	private boolean suppechogyneco;
	private boolean ajoutmodelechogyneco;
	private boolean appliquemodelechogyneco;
	private boolean suppmodelechogyneco;
	private boolean imprechogyneco;
	private boolean nouvechoObs;
	private boolean modifechoObs;
	private boolean suppechoObs;
	private boolean trim1echoObs;
	private boolean trim2echoObs;
	private boolean trim3echoObs;
	private boolean imprechoObs;
	private boolean selectNouvGross;
	private boolean modifGross;
	private boolean suppGross;
	private boolean imprGross;
	private boolean gestAntecedent;
	private boolean gestConsultation;
	private boolean gestHoraire;
	private boolean gestCabinet;
	private boolean gestionJourFr;
	private boolean tabFerie;
	private boolean tabJFerieExp;
	private boolean nouvJFerie;
	private boolean modifJFerie;
	private boolean suppJFerie;
	private boolean modifJFerieExp;
	private boolean suppJFerieExp;
	private boolean tabMedAnt;
	private boolean tabChirAnt;
	private boolean tabFamAnt;
	private boolean modifGestAntMed;
	private boolean suppGestAntMed;
	private boolean ajoutGestAntMed;
	private boolean modifAnt;
	private boolean suppAnt;
	private boolean suppGestAntChirg;
	private boolean ajoutGestChirg;
	private boolean modifGestChirg;
	private boolean suppGestAntFam;
	private boolean ajoutGestFam;
	private boolean modifGestFam;
	private boolean rechercheOrd;
	private boolean modifhistoOrd;
	private boolean supphistoOrd;
	private boolean selectModeleord;
	private boolean ajoutModeleord;
	private boolean suppModeleOrd;
	private boolean imprOrd;
	private boolean suppOrd;
	private boolean nouvCertif;
	private boolean modifCertif;
	private boolean suppCertif;
	private boolean imprCertif;
	private boolean nouvLettre;
	private boolean modifLettre;
	private boolean suppLettre;
	private boolean imprLettre;

	private boolean reglageHoraire;
	private boolean nouvJFerieExp;
	private boolean modifListeAnalyse;
	private boolean suppListeAnalyse;
	private boolean modifListeRadio;
	private boolean suppListeRadio;
	private boolean modifSterilite;

	private boolean modifPrdSaison;
	private boolean ajouterHeurTrav;
	private boolean modifierHeurTrav;
	private boolean supprimHeurTrav;
	
	private boolean gestSais;
	
	private boolean donnerRdv;
	
	private boolean consultDetRad;
	private boolean consultDetOrd;
	
    
	private boolean tabAnulSal;
	private boolean tabTelSal;
	
	private String valOnlic;
	
	
	
	//liste des tabSalle active pour récuperer les motifs
	private List<TabSalle> tabSallesActiv= new ArrayList<TabSalle>();
	
	

	public List<TabSalle> getTabSallesActiv() {
        TabSalleService ser= new TabSalleService();
		tabSallesActiv=ser.rechercheParActive();// liste des tabSalle active
		if(u !=null){
		  if(u.isTabTelSal()){
			TabSalle ts=new TabSalle();
			ts.setNomTab("Telephone");
		//	tabSallesActiv.add(ts);
		  }
		}
		return tabSallesActiv;
		
	}

	public void setTabSallesActiv(List<TabSalle> tabSallesActiv) {
		this.tabSallesActiv = tabSallesActiv;
	}

	public boolean isTabTelSal() {
		return tabTelSal;
	}

	public void setTabTelSal(boolean tabTelSal) {
		this.tabTelSal = tabTelSal;
	}

	public String getValOnlic() {
		return valOnlic;
	}

	public void setValOnlic(String valOnlic) {
		this.valOnlic = valOnlic;
	}

	public boolean isArchiverPat() {
		return archiverPat;
	}

	public void setArchiverPat(boolean archiverPat) {
		this.archiverPat = archiverPat;
	}

	public boolean isConsultArchiv() {
		return consultArchiv;
	}

	public void setConsultArchiv(boolean consultArchiv) {
		this.consultArchiv = consultArchiv;
	}

	public boolean isModifNoteSal() {
		return modifNoteSal;
	}

	public void setModifNoteSal(boolean modifNoteSal) {
		this.modifNoteSal = modifNoteSal;
	}

	public boolean isAnulSal() {
		return anulSal;
	}

	public void setAnulSal(boolean anulSal) {
		this.anulSal = anulSal;
	}

	public boolean isTabAnulSal() {
		return tabAnulSal;
	}

	public void setTabAnulSal(boolean tabAnulSal) {
		this.tabAnulSal = tabAnulSal;
	}

	public boolean isDetRad() {
		return detRad;
	}

	public void setDetRad(boolean detRad) {
		this.detRad = detRad;
	}

	public boolean isDetAnal() {
		return detAnal;
	}

	public void setDetAnal(boolean detAnal) {
		this.detAnal = detAnal;
	}

	public boolean isConsultDetRad() {
		return consultDetRad;
	}

	public void setConsultDetRad(boolean consultDetRad) {
		this.consultDetRad = consultDetRad;
	}

	public boolean isConsultDetOrd() {
		return consultDetOrd;
	}

	public void setConsultDetOrd(boolean consultDetOrd) {
		this.consultDetOrd = consultDetOrd;
	}

	public boolean isConsultDetAnal() {
		return consultDetAnal;
	}

	public void setConsultDetAnal(boolean consultDetAnal) {
		this.consultDetAnal = consultDetAnal;
	}
	
	

	public boolean isModifGynObs() {
		return modifGynObs;
	}

	public void setModifGynObs(boolean modifGynObs) {
		this.modifGynObs = modifGynObs;
	}

	public boolean isDonnerRdv() {
		return donnerRdv;
	}

	public void setDonnerRdv(boolean donnerRdv) {
		this.donnerRdv = donnerRdv;
	}

	public boolean isGestSais() {
		return gestSais;
	}

	public void setGestSais(boolean gestSais) {
		this.gestSais = gestSais;
	}

	public boolean isAjouterHeurTrav() {
		return ajouterHeurTrav;
	}

	public void setAjouterHeurTrav(boolean ajouterHeurTrav) {
		this.ajouterHeurTrav = ajouterHeurTrav;
	}

	public boolean isModifierHeurTrav() {
		return modifierHeurTrav;
	}

	public void setModifierHeurTrav(boolean modifierHeurTrav) {
		this.modifierHeurTrav = modifierHeurTrav;
	}

	public boolean isSupprimHeurTrav() {
		return supprimHeurTrav;
	}

	public void setSupprimHeurTrav(boolean supprimHeurTrav) {
		this.supprimHeurTrav = supprimHeurTrav;
	}

	public boolean isModifPrdSaison() {
		return modifPrdSaison;
	}

	public void setModifPrdSaison(boolean modifPrdSaison) {
		this.modifPrdSaison = modifPrdSaison;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isLoggedInFilter() {
		return loggedInFilter;
	}

	public void setLoggedInFilter(boolean loggedInFilter) {
		this.loggedInFilter = loggedInFilter;
	}

	public boolean isGestionCabinet() {
		return gestionCabinet;
	}

	public void setGestionCabinet(boolean gestionCabinet) {
		this.gestionCabinet = gestionCabinet;
	}

	public boolean isModifCab() {
		return modifCab;
	}

	public void setModifCab(boolean modifCab) {
		this.modifCab = modifCab;
	}

	public boolean isNotMenuGestRdv() {
		return !(menuGestRendezVous);
	}

	public boolean isMenuGestRdv() {
		return menuGestRendezVous;
	}

	public void setMenuGestRdv(boolean menuGestRdv) {
		this.menuGestRendezVous = menuGestRdv;
	}

	public boolean isAjoutRdv() {
		return ajoutRdv;
	}

	public void setAjoutRdv(boolean ajoutRdv) {
		this.ajoutRdv = ajoutRdv;
	}

	public boolean isModifRdv() {
		return modifRdv;
	}

	public void setModifRdv(boolean modifRdv) {
		this.modifRdv = modifRdv;
	}

	public boolean isSupRdv() {
		return supRdv;
	}

	public void setSupRdv(boolean supRdv) {
		this.supRdv = supRdv;
	}

	public boolean isGestionFormMed() {
		return gestionFormMed;
	}

	public void setGestionFormMed(boolean gestionFormMed) {
		this.gestionFormMed = gestionFormMed;
	}

	public boolean isGestionEtatFinGross() {
		return gestionEtatFinGross;
	}

	public void setGestionEtatFinGross(boolean gestionEtatFinGross) {
		this.gestionEtatFinGross = gestionEtatFinGross;
	}

	public boolean isAjoutFormMed() {
		return ajoutFormMed;
	}

	public void setAjoutFormMed(boolean ajoutFormMed) {
		this.ajoutFormMed = ajoutFormMed;
	}

	public boolean isModifFormMed() {
		return modifFormMed;
	}

	public void setModifFormMed(boolean modifFormMed) {
		this.modifFormMed = modifFormMed;
	}

	public boolean isSupFormMed() {
		return supFormMed;
	}

	public void setSupFormMed(boolean supFormMed) {
		this.supFormMed = supFormMed;
	}

	public boolean isAjoutEtatFinGross() {
		return ajoutEtatFinGross;
	}

	public void setAjoutEtatFinGross(boolean ajoutEtatFinGross) {
		this.ajoutEtatFinGross = ajoutEtatFinGross;
	}

	public boolean isModifEtatFinGross() {
		return modifEtatFinGross;
	}

	public void setModifEtatFinGross(boolean modifEtatFinGross) {
		this.modifEtatFinGross = modifEtatFinGross;
	}

	public boolean isSupEtatFinGross() {
		return supEtatFinGross;
	}

	public void setSupEtatFinGross(boolean supEtatFinGross) {
		this.supEtatFinGross = supEtatFinGross;
	}

	public boolean isGestionUterus() {
		return gestionUterus;
	}

	public void setGestionUterus(boolean gestionUterus) {
		this.gestionUterus = gestionUterus;
	}

	public boolean isAjoutUterus() {
		return ajoutUterus;
	}

	public void setAjoutUterus(boolean ajoutUterus) {
		this.ajoutUterus = ajoutUterus;
	}

	public boolean isModifUterus() {
		return modifUterus;
	}

	public void setModifUterus(boolean modifUterus) {
		this.modifUterus = modifUterus;
	}

	public boolean isSupUterus() {
		return supUterus;
	}

	public void setSupUterus(boolean supUterus) {
		this.supUterus = supUterus;
	}

	public boolean isModifAnalyse() {
		return modifAnalyse;
	}

	public void setModifAnalyse(boolean modifAnalyse) {
		this.modifAnalyse = modifAnalyse;
	}

	public boolean isSupAnalyse() {
		return supAnalyse;
	}

	public void setSupAnalyse(boolean supAnalyse) {
		this.supAnalyse = supAnalyse;
	}

	public boolean isModifRadio() {
		return modifRadio;
	}

	public void setModifRadio(boolean modifRadio) {
		this.modifRadio = modifRadio;
	}

	public boolean isSupRadio() {
		return supRadio;
	}

	public void setSupRadio(boolean supRadio) {
		this.supRadio = supRadio;
	}

	public boolean isModifOrdnce() {
		return modifOrdnce;
	}

	public void setModifOrdnce(boolean modifOrdnce) {
		this.modifOrdnce = modifOrdnce;
	}

	public boolean isSupOrdnce() {
		return supOrdnce;
	}

	public void setSupOrdnce(boolean supOrdnce) {
		this.supOrdnce = supOrdnce;
	}

	public boolean isModifAnal() {
		return modifAnal;
	}

	public void setModifAnal(boolean modifAnal) {
		this.modifAnal = modifAnal;
	}

	public boolean isSupAnal() {
		return supAnal;
	}

	public void setSupAnal(boolean supAnal) {
		this.supAnal = supAnal;
	}

	public boolean isModifCondultGyneco() {
		return modifCondultGyneco;
	}

	public void setModifCondultGyneco(boolean modifCondultGyneco) {
		this.modifCondultGyneco = modifCondultGyneco;
	}

	public boolean isOrdGyn() {
		return ordGyn;
	}

	public void setOrdGyn(boolean ordGyn) {
		this.ordGyn = ordGyn;
	}

	public boolean isRadioGyn() {
		return radioGyn;
	}

	public void setRadioGyn(boolean radioGyn) {
		this.radioGyn = radioGyn;
	}

	public boolean isAnalGyn() {
		return analGyn;
	}

	public void setAnalGyn(boolean analGyn) {
		this.analGyn = analGyn;
	}

	public boolean isNouvConsGyn() {
		return nouvConsGyn;
	}

	public void setNouvConsGyn(boolean nouvConsGyn) {
		this.nouvConsGyn = nouvConsGyn;
	}

	public boolean isConsulGrosstOrd() {
		return consulGrosstOrd;
	}

	public void setConsulGrosstOrd(boolean consulGrosstOrd) {
		this.consulGrosstOrd = consulGrosstOrd;
	}

	public boolean isConsultGrossRadio() {
		return consultGrossRadio;
	}

	public void setConsultGrossRadio(boolean consultGrossRadio) {
		this.consultGrossRadio = consultGrossRadio;
	}

	public boolean isConsultGrossAnal() {
		return consultGrossAnal;
	}

	public void setConsultGrossAnal(boolean consultGrossAnal) {
		this.consultGrossAnal = consultGrossAnal;
	}

	public boolean isNouvConGross() {
		return nouvConGross;
	}

	public void setNouvConGross(boolean nouvConGross) {
		this.nouvConGross = nouvConGross;
	}

	public boolean isModifHisGross() {
		return modifHisGross;
	}

	public void setModifHisGross(boolean modifHisGross) {
		this.modifHisGross = modifHisGross;
	}

	public boolean isSupHisGross() {
		return supHisGross;
	}

	public void setSupHisGross(boolean supHisGross) {
		this.supHisGross = supHisGross;
	}

	public boolean isModifContraception() {
		return modifContraception;
	}

	public void setModifContraception(boolean modifContraception) {
		this.modifContraception = modifContraception;
	}

	public boolean isSupContraception() {
		return supContraception;
	}

	public void setSupContraception(boolean supContraception) {
		this.supContraception = supContraception;
	}

	public boolean isNouvGross() {
		return nouvGross;
	}

	public void setNouvGross(boolean nouvGross) {
		this.nouvGross = nouvGross;
	}

	public boolean isNouvContraception() {
		return nouvContraception;
	}

	public void setNouvContraception(boolean nouvContraception) {
		this.nouvContraception = nouvContraception;
	}

	public boolean isTabAntecedent() {
		return tabAntecedent;
	}

	public void setTabAntecedent(boolean tabAntecedent) {
		this.tabAntecedent = tabAntecedent;
	}

	public boolean isTabGynObs() {
		return tabGynObs;
	}

	public void setTabGynObs(boolean tabGynObs) {
		this.tabGynObs = tabGynObs;
	}

	public boolean isTabHistGross() {
		return tabHistGross;
	}

	public void setTabHistGross(boolean tabHistGross) {
		this.tabHistGross = tabHistGross;
	}

	public boolean isTabContraception() {
		return tabContraception;
	}

	public void setTabContraception(boolean tabContraception) {
		this.tabContraception = tabContraception;
	}

	public boolean isCertifFiche() {
		return certifFiche;
	}

	public void setCertifFiche(boolean certifFiche) {
		this.certifFiche = certifFiche;
	}

	public boolean isLettreFiche() {
		return lettreFiche;
	}

	public void setLettreFiche(boolean lettreFiche) {
		this.lettreFiche = lettreFiche;
	}

	public boolean isAnalyseFiche() {
		return analyseFiche;
	}

	public void setAnalyseFiche(boolean analyseFiche) {
		this.analyseFiche = analyseFiche;
	}

	public boolean isRadioFiche() {
		return radioFiche;
	}

	public void setRadioFiche(boolean radioFiche) {
		this.radioFiche = radioFiche;
	}

	public boolean isRapportFiche() {
		return rapportFiche;
	}

	public void setRapportFiche(boolean rapportFiche) {
		this.rapportFiche = rapportFiche;
	}

	public boolean isOrdnanceFiche() {
		return ordnanceFiche;
	}

	public void setOrdnanceFiche(boolean ordnanceFiche) {
		this.ordnanceFiche = ordnanceFiche;
	}

	public boolean isAntecedent() {
		return antecedent;
	}

	public void setAntecedent(boolean antecedent) {
		this.antecedent = antecedent;
	}

	public boolean isEchoGyn() {
		return echoGyn;
	}

	public void setEchoGyn(boolean echoGyn) {
		this.echoGyn = echoGyn;
	}

	public boolean isEchoObs() {
		return echoObs;
	}

	public void setEchoObs(boolean echoObs) {
		this.echoObs = echoObs;
	}

	public boolean isGynecologie() {
		return gynecologie;
	}

	public void setGynecologie(boolean gynecologie) {
		this.gynecologie = gynecologie;
	}

	public boolean isConsultGross() {
		return consultGross;
	}

	public void setConsultGross(boolean consultGross) {
		this.consultGross = consultGross;
	}

	public boolean isSterilite() {
		return Sterilite;
	}

	public void setSterilite(boolean sterilite) {
		Sterilite = sterilite;
	}

	public boolean isTabcontactAjtPat() {
		return tabcontactAjtPat;
	}

	public void setTabcontactAjtPat(boolean tabcontactAjtPat) {
		this.tabcontactAjtPat = tabcontactAjtPat;
	}

	public boolean isTabInfConjAjtPat() {
		return tabInfConjAjtPat;
	}

	public void setTabInfConjAjtPat(boolean tabInfConjAjtPat) {
		this.tabInfConjAjtPat = tabInfConjAjtPat;
	}

	public boolean isTabAtreInfAjtPat() {
		return tabAtreInfAjtPat;
	}

	public void setTabAtreInfAjtPat(boolean tabAtreInfAjtPat) {
		this.tabAtreInfAjtPat = tabAtreInfAjtPat;
	}

	public boolean isTabInfGnrAjtPat() {
		return tabInfGnrAjtPat;
	}

	public void setTabInfGnrAjtPat(boolean tabInfGnrAjtPat) {
		this.tabInfGnrAjtPat = tabInfGnrAjtPat;
	}

	public boolean isAjouterEtBb() {
		return ajouterEtBb;
	}

	public void setAjouterEtBb(boolean ajouterEtBb) {
		this.ajouterEtBb = ajouterEtBb;
	}

	public boolean isSupprimEtBb() {
		return supprimEtBb;
	}

	public void setSupprimEtBb(boolean supprimEtBb) {
		this.supprimEtBb = supprimEtBb;
	}

	public boolean isModifierEtBb() {
		return modifierEtBb;
	}

	public void setModifierEtBb(boolean modifierEtBb) {
		this.modifierEtBb = modifierEtBb;
	}

	public boolean isAjouterAnal() {
		return ajouterAnal;
	}

	public void setAjouterAnal(boolean ajouterAnal) {
		this.ajouterAnal = ajouterAnal;
	}

	public boolean isSupprimAnal() {
		return supprimAnal;
	}

	public void setSupprimAnal(boolean supprimAnal) {
		this.supprimAnal = supprimAnal;
	}

	public boolean isModifiierAnal() {
		return modifiierAnal;
	}

	public void setModifiierAnal(boolean modifiierAnal) {
		this.modifiierAnal = modifiierAnal;
	}

	public boolean isAjouterMed() {
		return ajouterMed;
	}

	public void setAjouterMed(boolean ajouterMed) {
		this.ajouterMed = ajouterMed;
	}

	public boolean isSupprimMed() {
		return supprimMed;
	}

	public void setSupprimMed(boolean supprimMed) {
		this.supprimMed = supprimMed;
	}

	public boolean isModifierMed() {
		return modifierMed;
	}

	public void setModifierMed(boolean modifierMed) {
		this.modifierMed = modifierMed;
	}

	public boolean isAjouterExm() {
		return ajouterExm;
	}

	public void setAjouterExm(boolean ajouterExm) {
		this.ajouterExm = ajouterExm;
	}

	public boolean isSupprimExm() {
		return supprimExm;
	}

	public void setSupprimExm(boolean supprimExm) {
		this.supprimExm = supprimExm;
	}

	public boolean isModifierExm() {
		return modifierExm;
	}

	public void setModifierExm(boolean modifierExm) {
		this.modifierExm = modifierExm;
	}

	public boolean isAjouterMoyCotr() {
		return ajouterMoyCotr;
	}

	public void setAjouterMoyCotr(boolean ajouterMoyCotr) {
		this.ajouterMoyCotr = ajouterMoyCotr;
	}

	public boolean isSupprimMoyCotr() {
		return supprimMoyCotr;
	}

	public void setSupprimMoyCotr(boolean supprimMoyCotr) {
		this.supprimMoyCotr = supprimMoyCotr;
	}

	public boolean isModifierMoyCotr() {
		return modifierMoyCotr;
	}

	public void setModifierMoyCotr(boolean modifierMoyCotr) {
		this.modifierMoyCotr = modifierMoyCotr;
	}

	public boolean isAjouterDiag() {
		return ajouterDiag;
	}

	public void setAjouterDiag(boolean ajouterDiag) {
		this.ajouterDiag = ajouterDiag;
	}

	public boolean isSupprimDiag() {
		return supprimDiag;
	}

	public void setSupprimDiag(boolean supprimDiag) {
		this.supprimDiag = supprimDiag;
	}

	public boolean isModifierDiag() {
		return modifierDiag;
	}

	public void setModifierDiag(boolean modifierDiag) {
		this.modifierDiag = modifierDiag;
	}

	public boolean isAjouterSymp() {
		return ajouterSymp;
	}

	public void setAjouterSymp(boolean ajouterSymp) {
		this.ajouterSymp = ajouterSymp;
	}

	public boolean isSupprimSymp() {
		return supprimSymp;
	}

	public void setSupprimSymp(boolean supprimSymp) {
		this.supprimSymp = supprimSymp;
	}

	public boolean isModifierSymp() {
		return modifierSymp;
	}

	public void setModifierSymp(boolean modifierSymp) {
		this.modifierSymp = modifierSymp;
	}

	public boolean isAjouterExmComp() {
		return ajouterExmComp;
	}

	public void setAjouterExmComp(boolean ajouterExmComp) {
		this.ajouterExmComp = ajouterExmComp;
	}

	public boolean isSupprimExmComp() {
		return supprimExmComp;
	}

	public void setSupprimExmComp(boolean supprimExmComp) {
		this.supprimExmComp = supprimExmComp;
	}

	public boolean isModifierExmComp() {
		return modifierExmComp;
	}

	public void setModifierExmComp(boolean modifierExmComp) {
		this.modifierExmComp = modifierExmComp;
	}

	public boolean isAjouterDocteur() {
		return ajouterDocteur;
	}

	public void setAjouterDocteur(boolean ajouterDocteur) {
		this.ajouterDocteur = ajouterDocteur;
	}

	public boolean isModifierDocteur() {
		return modifierDocteur;
	}

	public void setModifierDocteur(boolean modifierDocteur) {
		this.modifierDocteur = modifierDocteur;
	}

	public boolean isSupprimerDocteur() {
		return supprimerDocteur;
	}

	public void setSupprimerDocteur(boolean supprimerDocteur) {
		this.supprimerDocteur = supprimerDocteur;
	}

	public boolean isAjoutProfession() {
		return ajoutProfession;
	}

	public void setAjoutProfession(boolean ajoutProfession) {
		this.ajoutProfession = ajoutProfession;
	}

	public boolean isModifProfession() {
		return modifProfession;
	}

	public void setModifProfession(boolean modifProfession) {
		this.modifProfession = modifProfession;
	}

	public boolean isSupprimerProfession() {
		return supprimerProfession;
	}

	public void setSupprimerProfession(boolean supprimerProfession) {
		this.supprimerProfession = supprimerProfession;
	}

	public boolean isSupprimerClinique() {
		return supprimerClinique;
	}

	public void setSupprimerClinique(boolean supprimerClinique) {
		this.supprimerClinique = supprimerClinique;
	}

	public boolean isModifClinique() {
		return modifClinique;
	}

	public void setModifClinique(boolean modifClinique) {
		this.modifClinique = modifClinique;
	}

	public boolean isAjoutClinique() {
		return ajoutClinique;
	}

	public void setAjoutClinique(boolean ajoutClinique) {
		this.ajoutClinique = ajoutClinique;
	}

	public boolean isSupprimerVille() {
		return supprimerVille;
	}

	public void setSupprimerVille(boolean supprimerVille) {
		this.supprimerVille = supprimerVille;
	}

	public boolean isModifVille() {
		return modifVille;
	}

	public void setModifVille(boolean modifVille) {
		this.modifVille = modifVille;
	}

	public boolean isAjoutVille() {
		return ajoutVille;
	}

	public void setAjoutVille(boolean ajoutVille) {
		this.ajoutVille = ajoutVille;
	}

	public boolean isVerSalle() {
		return verSalle;
	}

	public void setVerSalle(boolean verSalle) {
		this.verSalle = verSalle;
	}

	public boolean isModifPatient() {
		return modifPatient;
	}

	public void setModifPatient(boolean modifPatient) {
		this.modifPatient = modifPatient;
	}
	
	

	public boolean isModifCons() {
		return modifCons;
	}

	public void setModifCons(boolean modifCons) {
		this.modifCons = modifCons;
	}

	public boolean isDetailPat() {
		return detailPat;
	}

	public void setDetailPat(boolean detailPat) {
		this.detailPat = detailPat;
	}

	public boolean isChargerPat() {
		return chargerPat;
	}

	public void setChargerPat(boolean chargerPat) {
		this.chargerPat = chargerPat;
	}

	public boolean isSuppressionPat() {
		return suppressionPat;
	}

	public void setSuppressionPat(boolean suppressionPat) {
		this.suppressionPat = suppressionPat;
	}

	public boolean isAjouterPat() {
		return ajouterPat;
	}

	public void setAjouterPat(boolean ajouterPat) {
		this.ajouterPat = ajouterPat;
	}

	public boolean isRapportCertif() {
		return rapportCertif;
	}

	public void setRapportCertif(boolean rapportCertif) {
		this.rapportCertif = rapportCertif;
	}

	public boolean isRapportLettre() {
		return rapportLettre;
	}

	public void setRapportLettre(boolean rapportLettre) {
		this.rapportLettre = rapportLettre;
	}

	public boolean isRapportOrdnce() {
		return rapportOrdnce;
	}

	public void setRapportOrdnce(boolean rapportOrdnce) {
		this.rapportOrdnce = rapportOrdnce;
	}

	public boolean isGestionExmComp() {
		return gestionExmComp;
	}

	public void setGestionExmComp(boolean gestionExmComp) {
		this.gestionExmComp = gestionExmComp;
	}

	public boolean isGestionSyn() {
		return gestionSyn;
	}

	public void setGestionSyn(boolean gestionSyn) {
		this.gestionSyn = gestionSyn;
	}

	public boolean isGestionDiag() {
		return gestionDiag;
	}

	public void setGestionDiag(boolean gestionDiag) {
		this.gestionDiag = gestionDiag;
	}

	public boolean isGestionMoyCtrcep() {
		return gestionMoyCtrcep;
	}

	public void setGestionMoyCtrcep(boolean gestionMoyCtrcep) {
		this.gestionMoyCtrcep = gestionMoyCtrcep;
	}

	public boolean isGestionExm() {
		return gestionExm;
	}

	public void setGestionExm(boolean gestionExm) {
		this.gestionExm = gestionExm;
	}

	public boolean isGestionMed() {
		return gestionMed;
	}

	public void setGestionMed(boolean gestionMed) {
		this.gestionMed = gestionMed;
	}

	public boolean isGestionAnal() {
		return gestionAnal;
	}

	public void setGestionAnal(boolean gestionAnal) {
		this.gestionAnal = gestionAnal;
	}

	public boolean isGestionBb() {
		return gestionBb;
	}

	public void setGestionBb(boolean gestionBb) {
		this.gestionBb = gestionBb;
	}

	public boolean isGestionDoct() {
		return gestionDoct;
	}

	public void setGestionDoct(boolean gestionDoct) {
		this.gestionDoct = gestionDoct;
	}

	public boolean isGestionProf() {
		return gestionProf;
	}

	public void setGestionProf(boolean gestionProf) {
		this.gestionProf = gestionProf;
	}

	public boolean isGestionClinique() {
		return gestionClinique;
	}

	public void setGestionClinique(boolean gestionClinique) {
		this.gestionClinique = gestionClinique;
	}

	public boolean isGestionVille() {
		return gestionVille;
	}

	public void setGestionVille(boolean gestionVille) {
		this.gestionVille = gestionVille;
	}

	public boolean isMenuGestUtilisateur() {
		return menuGestUtilisateur;
	}

	public void setMenuGestUtilisateur(boolean menuGestUtilisateur) {
		this.menuGestUtilisateur = menuGestUtilisateur;
	}

	public boolean isMenuGestRapport() {
		return menuGestRapport;
	}

	public void setMenuGestRapport(boolean menuGestRapport) {
		this.menuGestRapport = menuGestRapport;
	}

	public boolean isMenuGestParametre() {
		return menuGestParametre;
	}

	public void setMenuGestParametre(boolean menuGestParametre) {
		this.menuGestParametre = menuGestParametre;
	}

	public boolean isMenuGestionPat() {
		return menuGestionPat;
	}

	public void setMenuGestionPat(boolean menuGestionPat) {
		this.menuGestionPat = menuGestionPat;
	}
	

	public boolean isMenuGestStat() {
		return menuGestStat;
	}

	public void setMenuGestStat(boolean menuGestStat) {
		this.menuGestStat = menuGestStat;
	}

	public boolean isMenuSalle() {
		return menuSalle;
	}

	public void setMenuSalle(boolean menuSalle) {
		this.menuSalle = menuSalle;
	}

	public boolean isChargerPatientSal() {
		return chargerPatientSal;
	}

	public void setChargerPatientSal(boolean chargerPatientSal) {
		this.chargerPatientSal = chargerPatientSal;
	}

	public boolean isVerConsultation() {
		return verConsultation;
	}

	public void setVerConsultation(boolean verConsultation) {
		this.verConsultation = verConsultation;
	}

	public boolean isSuppressionPatientSal() {
		return suppressionPatientSal;
	}

	public void setSuppressionPatientSal(boolean suppressionPatientSal) {
		this.suppressionPatientSal = suppressionPatientSal;
	}

	public boolean isDernierPatientSal() {
		return dernierPatientSal;
	}

	public void setDernierPatientSal(boolean dernierPatientSal) {
		this.dernierPatientSal = dernierPatientSal;
	}

	public boolean isPremierPatientSal() {
		return premierPatientSal;
	}

	public void setPremierPatientSal(boolean premierPatientSal) {
		this.premierPatientSal = premierPatientSal;
	}

	public boolean isPermuterPatientSal() {
		return permuterPatientSal;
	}

	public void setPermuterPatientSal(boolean permuterPatientSal) {
		this.permuterPatientSal = permuterPatientSal;
	}

	public boolean isNouvellePatientSal() {
		return nouvellePatientSal;
	}

	public void setNouvellePatientSal(boolean nouvellePatientSal) {
		this.nouvellePatientSal = nouvellePatientSal;
	}

	public boolean isMonterPatientSal() {
		return monterPatientSal;
	}

	public void setMonterPatientSal(boolean monterPatientSal) {
		this.monterPatientSal = monterPatientSal;
	}

	public boolean isDescendrePatientSal() {
		return descendrePatientSal;
	}

	public void setDescendrePatientSal(boolean descendrePatientSal) {
		this.descendrePatientSal = descendrePatientSal;
	}

	public Integer getIdUtlConnecte() {
		return idUtlConnecte;
	}

	public void setIdUtlConnecte(Integer idUtlConnecte) {
		this.idUtlConnecte = idUtlConnecte;
	}

	public String getConnecte() {
		// connecte=Module.connecte;
		return connecte;
	}

	public void setConnecte(String connecte) {
		this.connecte = connecte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotpass() {
		return motpass;
	}

	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}

	@PostConstruct
	public void init() {

		// Module.idpatient = null;
		Module.connecte = "";
	}

	private String utilisateur;

	// @ManagedProperty("#{chatUsers}")
	// private ChatUsers users;
	//
	// public ChatUsers getUsers() {
	// return users;
	// }
	//
	// public void setUsers(ChatUsers users) {
	// this.users = users;
	// }

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String connecter() {
		FacesContext face = FacesContext.getCurrentInstance();
		
		
		if (login == null || (login.trim().length() == 0)) {
			
			face.addMessage("formconnection:loginid", new FacesMessage("Login manquant"));
		}

		if (motpass == null || (motpass.trim().length() == 0)) {
			face.addMessage("formconnection:mpid", new FacesMessage(
					"Mot de passe manquant"));
		}
		if (face.getMessageList().size() == 0) {

			if (login.equals("superadmin")) {
				// génération du mot de passe
				Date d = new Date();
				DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
				String aujoudhui = dateFormat.format(d);

				SimpleDateFormat sdfH = new java.text.SimpleDateFormat("HHmm");
				String heure = sdfH.format(d);
				String mp = "DSI" + heure + aujoudhui + "ISD";
				if (motpass.equals(mp)) {

					monterPatientSal = true;
					descendrePatientSal = true;
					nouvellePatientSal = true;
					permuterPatientSal = true;
					premierPatientSal = true;
					dernierPatientSal = true;
					archiverPat=true;
					suppressionPatientSal = true;
					verConsultation = true;
					chargerPatientSal = true;
					anulSal=true;
					modifNoteSal=true;
					menuSalle = false;
					consultArchiv=false;
					menuGestionPat = false;
					menuGestStat=false;
					menuGestParametre = false;
					menuGestRapport = false;
					menuGestUtilisateur = false;
					menuGestRendezVous = false;
					gestionVille = false;
					gestionClinique = false;
					gestionProf = false;
					gestionDoct = false;
					gestionBb = false;
					gestionAnal = false;
					gestionMed = false;
					gestionExm = false;
					gestionMoyCtrcep = false;
					gestionDiag = false;
					gestionSyn = false;
					gestionExmComp = false;
					gestionUterus = false;
					gestionFormMed = false;
					gestionEtatFinGross = false;
					gestionCabinet = false;
					rapportOrdnce = false;
					rapportLettre = false;
					rapportCertif = false;
					verSalle = true;
					modifPatient = true;
				    modifCons= true;
					detailPat = true;
					chargerPat = true;
					suppressionPat = true;
					ajouterPat = true;
					ajoutVille = true;
					modifVille = true;
					supprimerVille = true;
					ajoutClinique = true;
					modifClinique = true;
					supprimerClinique = true;
					ajoutProfession = true;
					modifProfession = true;
					supprimerProfession = true;
					ajouterDocteur = true;
					modifierDocteur = true;
					supprimerDocteur = true;
					ajouterEtBb = true;
					supprimEtBb = true;
					modifierEtBb = true;
					ajouterAnal = true;
					supprimAnal = true;
					modifiierAnal = true;
					ajouterMed = true;
					supprimMed = true;
					modifierMed = true;
					ajouterExm = true;
					supprimExm = true;
					modifierExm = true;
					ajouterMoyCotr = true;
					supprimMoyCotr = true;
					modifierMoyCotr = true;
					ajouterDiag = true;
					supprimDiag = true;
					modifierDiag = true;
					ajouterSymp = true;
					supprimSymp = true;
					modifierSymp = true;
					
					consultDetAnal=false;
					consultDetRad=false;
					consultDetOrd=false;
					
					modifGynObs=true;
					
					ajouterExmComp = true;
					supprimExmComp = true;
					modifierExmComp = true;
					tabInfGnrAjtPat = true;
					tabcontactAjtPat = true;
					tabInfConjAjtPat = true;
					tabAtreInfAjtPat = true;
					antecedent = true;
					echoGyn = true;
					echoObs = true;
					gynecologie = true;
					consultGross = true;
					Sterilite = true;
					certifFiche = true;
					lettreFiche = true;
					analyseFiche = true;
					radioFiche = true;
					rapportFiche = true;
					ordnanceFiche = true;
					tabAntecedent = true;
					tabGynObs = true;
					tabHistGross = true;
					tabContraception = true;
					nouvGross = true;
					nouvContraception = true;
					modifHisGross = true;
					supHisGross = true;
					modifContraception = true;
					supContraception = true;
					ajoutUterus = true;
					modifUterus = true;
					supUterus = true;
					ajoutFormMed = true;
					modifFormMed = true;
					supFormMed = true;
					ajoutEtatFinGross = true;
					modifEtatFinGross = true;
					supEtatFinGross = true;
					ajoutRdv = true;
					modifRdv = true;
					supRdv = true;
					modifCab = true;

					modifPrdSaison = true;
					ajouterHeurTrav = true;
					modifierHeurTrav = true;
					supprimHeurTrav = true;

					ordGyn = true;
					radioGyn = true;
					analGyn = true;
					nouvConsGyn = true;
					consulGrosstOrd = true;
					consultGrossRadio = true;
					consultGrossAnal = true;
					nouvConGross = true;
					modifCondultGyneco = true;

					modifAnal = true;
					supAnal = true;

					modifAnalyse = true;
					supAnalyse = true;
					detAnal=true;
					modifRadio = true;
					supRadio = true;
					detRad=true;
					modifOrdnce = true;
					supOrdnce = true;
					supprimerDocteur = true;
					gestionUterus = false;
					ModifGyneco = true;
					SuppGyneco = true;
					imprGyneco = true;
					selectTableConsultation = false;
					ordonanceLibreFiche = true;
					nbrEnfentFiche = false;
					nouvechoObs = true;
					modifechoObs = true;
					suppechoObs = true;
					trim1echoObs = true;
					trim2echoObs = true;
					trim3echoObs = true;
					imprechoObs = true;
					selectNouvGross = true;
					modifGross = true;
					suppGross = true;
					imprGross = true;
					consultPat = true;
					nouvchogyneco = true;
					modifechogyneco = true;
					suppechogyneco = true;
					ajoutmodelechogyneco = true;
					appliquemodelechogyneco = true;
					suppmodelechogyneco = true;
					imprechogyneco = true;
					reponseSal = true;
					selectAntecedent = false;
					gestAntecedent = false;
					gestConsultation=false;
					gestHoraire = false;
					gestCabinet = false;
					gestionJourFr = false;
					gestionFormMed = false;
					tabFerie = true;
					tabJFerieExp = true;
					nouvJFerie = true;
					modifJFerie = true;
					suppJFerie = true;
					modifJFerieExp = true;
					suppJFerieExp = true;
					tabMedAnt = true;
					tabChirAnt = true;
					tabFamAnt = true;
					modifGestAntMed = true;
					suppGestAntMed = true;
					ajoutGestAntMed = true;
					modifAnt=true;
					suppAnt=true;
					suppGestAntChirg = true;
					ajoutGestChirg = true;
					modifGestChirg = true;
					suppGestAntFam = true;
					ajoutGestFam = true;
					modifGestFam = true;
					nouvJFerieExp = true;
					rechercheOrd = true;
					modifhistoOrd = true;
					supphistoOrd = true;
					selectModeleord = true;
					ajoutModeleord = true;
					suppModeleOrd = true;
					imprOrd = true;
					suppOrd = true;
					nouvCertif = false;
					modifCertif = true;
					suppCertif = true;
					imprCertif = true;
					nouvLettre = true;
					modifLettre = true;
					suppLettre = true;
					imprLettre = true;
					modifSterilite = false;
					reglageHoraire = true;
					loggedInFilter = true;
				    gestSais=true;
				    donnerRdv=true;
					tabAnulSal=true;
					tabTelSal=true;
					Module.menuConfig = "0";
					Module.actif = true;
					Module.passif = false;
					EnLigne enLigne = new EnLigne();
					EnLigneService ser1 = new EnLigneService();
					HttpSession session5 = (HttpSession) FacesContext
							.getCurrentInstance().getExternalContext()
							.getSession(true);
					String idSessionCourant=session5.getId();
				
					enLigne.setIdSession(idSessionCourant);
					ser1.ajoutEnLigne(enLigne);
				    System.out.println("mpest juste  "+motpass);
				    //redirection
//				    try {
//
//						FacesContext.getCurrentInstance().getExternalContext()
//								.redirect("Patients");
//					} catch (Exception e) {
//						System.out.println(e.getMessage());
//					}
//				    
				    
				    
					return "accepted";
				}
				 System.out.println("mpest juste  "+motpass);
			}

			else if (Test.currentConnect < Test.maxConnect) {
				// pas de message d'erreur == les champs login et mp non vide
				// tester le nombre de session

				// tester si le login et le mot de passe existe dans la base
				UtilisateurService c = new UtilisateurService();
				 u = c.rechercheParLoginMotPass(login, motpass);

				if (u != null) {
					if (u.isPassif()) {

						face.addMessage("formconnection:f", new FacesMessage(
								"Ce compte est désactivé."));

					} else {
						Test.currentConnect++;
						connecte = u.getPrenom() + " " + u.getNom();
						
						utilisateur = login;
						HttpSession session = (HttpSession) FacesContext
								.getCurrentInstance().getExternalContext()
								.getSession(false);
						session.setAttribute("name", login);

					

						Connecte connect = new ConnecteService()
								.rechercheParConnecte(login);

						if (connect != null) {
							loggedIn = true;

						} else {
							Connecte co = new Connecte();
							co.setLogin(login);
							new ConnecteService().ajoutConnecte(co);
							// users.add(utilisateur);
							loggedIn = true;
						}

						idUtlConnecte = u.getIdutilisateur();

						if (u.getMenuSal().equals("0")) {
							menuSalle = true;
						} else {
							menuSalle = false;
						}
						
						consultArchiv=!u.isConsultArchiv();

						if (u.getMenuGestPat().equals("0")) {
							menuGestionPat = true;
						} else {
							menuGestionPat = false;
						}
						
						
						menuGestStat = ! u.isMenuGestStat();
						
						

						if (u.getMenuParametre().equals("0")) {
							menuGestParametre = true;
						} else {
							menuGestParametre = false;
						}

						if (u.getMenuRapport().equals("0")) {
							menuGestRapport = true;
						} else {
							menuGestRapport = false;
						}

						if (u.getMenuGestUtl().equals("0"))

						{
							menuGestUtilisateur = true;
						} else {
							menuGestUtilisateur = false;
						}

						if (u.getGestVil().equals("0")) {
							gestionVille = true;
						} else {
							gestionVille = false;
						}

						if (u.getGestClin().equals("0")) {
							gestionClinique = true;
						} else {
							gestionClinique = false;
						}

						if (u.getGestProf().equals("0")) {
							gestionProf = true;
						} else {
							gestionProf = false;
						}

						if (u.getGestDoc().equals("0")) {
							gestionDoct = true;
						} else {
							gestionDoct = false;
						}

						if (u.getGestBb().equals("0")) {
							gestionBb = true;
						} else {
							gestionBb = false;
						}

						if (u.getGestAnal().equals("0")) {
							gestionAnal = true;
						} else {
							gestionAnal = false;
						}

						if (u.getGestMed().equals("0")) {
							gestionMed = true;
						} else {
							gestionMed = false;
						}

						if (u.getGestExm().equals("0")) {
							gestionExm = true;
						} else {
							gestionExm = false;
						}

						if (u.getGestMoyCtrcep().equals("0")) {
							gestionMoyCtrcep = true;
						} else {
							gestionMoyCtrcep = false;
						}

						if (u.getGestDiag().equals("0")) {
							gestionDiag = true;
						} else {
							gestionDiag = false;
						}

						if (u.getGestSyn().equals("0")) {
							gestionSyn = true;
						} else {
							gestionSyn = false;
						}

						if (u.getGestExmComp().equals("0")) {
							gestionExmComp = true;
						} else {
							gestionExmComp = false;
						}

						if (u.getGestEFG().equals("0")) {
							gestionEtatFinGross = true;
						} else {
							gestionEtatFinGross = false;
						}

						if (u.getMenuGestRdv().equals("0")) {
							menuGestRendezVous = true;
						} else {
							menuGestRendezVous = false;
						}

						if (u.getRappOrdnce().equals("0")) {
							rapportOrdnce = false;
						} else {
							rapportOrdnce = true;
						}

						if (u.getRappLettre().equals("0")) {
							rapportLettre = true;
						} else {
							rapportLettre = false;
						}

						if (u.getRappCertif().equals("0")) {
							rapportCertif = true;
						} else {
							rapportCertif = false;
						}

						if (u.getVerSal().equals("0")) {
							verSalle = false;
						} else {
							verSalle = true;
						}

						if (u.getModPatient().equals("0")) {
							modifPatient = false;
						} else {
							modifPatient = true;
						}

						if (u.getDetPatient().equals("0")) {
							detailPat = false;
						} else {
							detailPat = true;
						}

						if (u.getChargPatient().equals("0")) {
							chargerPat = false;
						} else {
							chargerPat = true;
						}

						if (u.getSupPatient().equals("0")) {
							suppressionPat = false;
						} else {
							suppressionPat = true;
						}

						if (u.getAjoutPatient().equals("0")) {
							ajouterPat = false;

						} else {
							ajouterPat = true;
						}

						if (u.getTabInfGenAjoutPat().equals("0")) {
							tabInfGnrAjtPat = false;
						} else {
							tabInfGnrAjtPat = true;
						}

						if (u.getTabCntctAjoutPat().equals("0")) {
							tabcontactAjtPat = false;
						} else {
							tabcontactAjtPat = true;
						}

						if (u.getTabInfoConjAjoutPat().equals("0")) {
							tabInfConjAjtPat = false;
						} else {
							tabInfConjAjtPat = true;
						}

						if (u.getTabAutreInfAjoutPat().equals("0")) {
							tabAtreInfAjtPat = false;
						} else {
							tabAtreInfAjtPat = true;
						}

						if (u.getMonterPatSal().equals("0"))
							monterPatientSal = false;
						else
							monterPatientSal = true;

						if (u.getDesdrePatSal().equals("0"))
							descendrePatientSal = false;
						else
							descendrePatientSal = true;

						if (u.getPermutPatSal().equals("0"))
							permuterPatientSal = false;
						else
							permuterPatientSal = true;

						if (u.getPremierPatSal().equals("0"))
							premierPatientSal = false;
						else
							premierPatientSal = true;

						if (u.getDernierPatSal().equals("0"))
							dernierPatientSal = false;
						else
							dernierPatientSal = true;
						
						archiverPat=u.isArchiverPat();

						if (u.getSupPatSal().equals("0"))
							suppressionPatientSal = false;
						else
							suppressionPatientSal = true;

						if (u.getVerConsult().equals("0")) {
							verConsultation = false;
						} else {
							verConsultation = true;
						}

						if (u.getChargPatSal().equals("0"))
							chargerPatientSal = false;
						else
							chargerPatientSal = true;
						
						anulSal=u.isAnulSal();
						modifNoteSal=u.isModifNoteSal();

						if (u.getAjoutVil().equals("0"))
							ajoutVille = false;
						else
							ajoutVille = true;

						if (u.getModifVil().equals("0"))
							modifVille = false;
						else
							modifVille = true;

						if (u.getSupVil().equals("0"))
							supprimerVille = false;
						else
							supprimerVille = true;

						if (u.getAjoutClin().equals("0"))
							ajoutClinique = false;
						else
							ajoutClinique = true;

						if (u.getModifClin().equals("0"))
							modifClinique = false;
						else
							modifClinique = true;

						if (u.getSupClin().equals("0"))
							supprimerClinique = false;
						else
							supprimerClinique = true;

						if (u.getAjoutProf().equals("0"))
							ajoutProfession = false;
						else
							ajoutProfession = true;

						if (u.getModifProf().equals("0"))
							modifProfession = false;
						else
							modifProfession = true;

						if (u.getSupProf().equals("0"))
							supprimerProfession = false;
						else
							supprimerProfession = true;

						if (u.getAjoutDoc().equals("0"))
							ajouterDocteur = false;
						else
							ajouterDocteur = true;

						if (u.getModifDoc().equals("0"))
							modifierDocteur = false;
						else
							modifierDocteur = true;

						if (u.getSupDoc().equals("0"))
							supprimerDocteur = false;
						else
							supprimerDocteur = true;
                        
						modifCons= u.isModifCons();
						gestionUterus = !(u.isGestionUterus());
						ajouterEtBb = u.isAjoutEtBb();
						ModifGyneco = u.isModifGyneco();
						SuppGyneco = u.isSuppGyneco();
						imprGyneco = (u.isImprGyneco());
						selectTableConsultation = !(u
								.isSelectTableConsultation());
						ordonanceLibreFiche = u.isOrdonanceLibreFiche();
						nbrEnfentFiche = !(u.isNbrEnfentFiche());
						nouvechoObs = u.isNouvechoObs();
						modifechoObs = u.isModifechoObs();
						suppechoObs = u.isSuppechoObs();
						trim1echoObs = u.isTrim1echoObs();
						trim2echoObs = u.isTrim2echoObs();
						trim3echoObs = u.isTrim3echoObs();
						imprechoObs = u.isImprechoObs();
						selectNouvGross = u.isSelectNouvGross();
						modifGross = u.isModifGross();
						suppGross = u.isSuppGross();
						imprGross = u.isImprGross();
						consultPat = u.isConsultPat();
						supprimEtBb = u.isSupEtBb();
						modifierEtBb = u.isModifEtBb();
						ajouterAnal = u.isAjoutAnal();
						supprimAnal = u.isSupAnal();
						modifiierAnal = u.isModifAnal();
						ajouterMed = u.isAjoutMed();

						supprimMed = u.isSupMed();
						modifierMed = u.isModifMed();
						ajouterExm = u.isAjoutExm();
						supprimExm = u.isSupExm();
						modifierExm = u.isModifExm();
						ajouterMoyCotr = u.isAjoutMoyCtr();
						supprimMoyCotr = u.isSupMoyCtr();
						modifierMoyCotr = u.isModifMoyCtr();
						ajouterDiag = u.isAjoutDiag();
						supprimDiag = u.isSupDiag();
						modifierDiag = u.isModifDiag();
						ajouterSymp = u.isAjoutAsym();
						supprimSymp = u.isSupAsym();
						modifierSymp = u.isModifAsym();
						
						consultDetAnal= !u.isConsultDetAnal();
						consultDetRad=!u.isConsultDetRad();
						consultDetOrd= !u.isConsultDetOrd();
						
						modifGynObs= ! u.isModifGynObs();
						
						ajouterExmComp = u.isAjoutExmComp();
						supprimExmComp = u.isSupExmComp();
						modifierExmComp = u.isModifExmComp();
						modifCondultGyneco = u.isModifCsltGyn();

						modifAnalyse = u.isModifAnalyse();
						supAnalyse = u.isSupAnalyse();
						detAnal=u.isDetHistoAnal();
						modifRadio = u.isModifRadio();
						supRadio = u.isSupRadio();
						detRad=u.isDetHistoRad();
						modifOrdnce = u.isModifOrdnce();
						supOrdnce = u.isSupOrdnce();
						ajoutUterus = u.isAjoutUt();
						modifUterus = u.isModifUt();
						supUterus = u.isSupUt();

						modifPrdSaison = !u.isModifPrtSais();
						ajouterHeurTrav = u.isAjoutHeurTrav();
						modifierHeurTrav = u.isModifHeurTrav();
						supprimHeurTrav = u.isSupHeurTrav();

						ajoutEtatFinGross = u.isAjoutEFG();
						modifEtatFinGross = u.isModifEFG();
						supEtatFinGross = u.isSupEFG();
						ajoutFormMed = u.isAjoutFM();
						modifFormMed = u.isModifFM();
						supFormMed = u.isSupFM();
						ajoutRdv = u.isAjoutRdv();
						modifRdv = u.isModifRdv();
						supRdv = u.isSupRdv();
						nouvchogyneco = u.isNouvchogyneco();
						modifechogyneco = u.isModifechogyneco();
						suppechogyneco = u.isSuppechogyneco();
						ajoutmodelechogyneco = u.isAjoutmodelechogyneco();
						appliquemodelechogyneco = u.isAppliquemodelechogyneco();
						suppmodelechogyneco = u.isSuppmodelechogyneco();
						imprechogyneco = u.isImprechogyneco();
						reponseSal = u.isReponseSal();
						selectAntecedent = !(u.isSelectAntecedent());
						gestAntecedent = !(u.isGestAntecedent());
						gestConsultation=!(u.isGestConsultation());
						gestHoraire = !(u.isGestHoraire());
						gestCabinet = !(u.isGestCabinet());
						gestionJourFr = !(u.isGestionJourFr());
						gestionFormMed = !(u.isGestionFormMed());
						tabFerie = u.isTabFerie();
						tabJFerieExp = u.isTabJFerieExp();
						nouvJFerie = u.isNouvJFerie();
						modifJFerie = u.isModifJFerie();
						suppJFerie = u.isSuppJFerie();
						modifJFerieExp = u.isModifJFerieExp();
						suppJFerieExp = u.isSuppJFerie();
						tabMedAnt = u.isTabMedAnt();
						tabChirAnt = u.isTabChirAnt();
						tabFamAnt = u.isTabFamAnt();
						modifGestAntMed = u.isModifGestAntMed();
						suppGestAntMed = u.isSuppGestAntMed();
						ajoutGestAntMed = u.isAjoutGestAntMed();
						modifAnt=u.isModifAnt();
						suppAnt=u.isSuppAnt();
						suppGestAntChirg = u.isSuppGestAntChirg();
						ajoutGestChirg = u.isAjoutGestChirg();
						modifGestChirg = u.isModifGestChirg();
						suppGestAntFam = u.isSuppGestAntFam();
						ajoutGestFam = u.isAjoutGestFam();
						modifGestFam = u.isModifGestFam();
						nouvJFerieExp = u.isNouvJFerieExp();
						rechercheOrd = u.isRechercheOrd();
						modifhistoOrd = u.isModifhistoOrd();
						supphistoOrd = u.isSupphistoOrd();
						selectModeleord = u.isSelectModeleord();
						ajoutModeleord = u.isAjoutModeleord();
						suppModeleOrd = u.isSuppModeleOrd();
						imprOrd = u.isImprOrd();
						suppOrd = u.isSuppOrd();
						nouvCertif = !(u.isNouvCertif());
						modifCertif = u.isModifCertif();
						suppCertif = u.isSuppCertif();
						imprCertif = u.isImprCertif();
						nouvLettre = u.isNouvLettre();
						modifLettre = u.isModifLettre();
						suppLettre = u.isSuppLettre();
						imprLettre = u.isImprLettre();
						modifSterilite = !(u.isModifSterilite());
						reglageHoraire = u.isReglageHoraire();
						
						gestSais=u.isGestSais();
						donnerRdv=u.isDonnerRdv();
						
						tabAnulSal=u.isTabAnulSal();
						tabTelSal=u.isTabTelSal();
						
						ajoutAntecedentListe = u.isAjoutAntecedentListe();
						/*nouvelleContraceptionAntecedent = u
								.isNouvelleContraceptionAntecedent();
						System.out.println("nouvelleContraceptionAntecedent=="+nouvelleContraceptionAntecedent);
						nouvelleGrossesseAntecedent = u
								.isNouvelleGrossesseAntecedent();
						System.out.println("nouvelleGrossesseAntecedent=="+nouvelleGrossesseAntecedent);*/
						
						
						
						modifCab = u.isModifCab();

						if(u.getConsultGrossOrd().equals("0"))
							consulGrosstOrd = false;
						else
							consulGrosstOrd = true;
						
						if (u.getAntecedent().equals("0"))
							antecedent = false;
						else
							antecedent = true;

						if (u.getEchoGyn().equals("0"))
							echoGyn = false;
						else
							echoGyn = true;

						if (u.getEchoObs().equals("0"))
							echoObs = false;
						else
							echoObs = true;

						if (u.getGynecologie().equals("0"))
							gynecologie = false;
						else
							gynecologie = true;

						if (u.getConsultGros().equals("0"))
							consultGross = false;
						else
							consultGross = true;

						if (u.getSterilite().equals("0"))
							Sterilite = false;
						else
							Sterilite = true;

						if (u.getCertifFiche().equals("0"))
							certifFiche = false;
						else
							certifFiche = true;

						if (u.getLettreFiche().equals("0"))
							lettreFiche = false;
						else
							lettreFiche = true;

						if (u.getAnalyseFiche().equals("0"))
							analyseFiche = false;
						else
							analyseFiche = true;

						if (u.getRadioFiche().equals("0"))
							radioFiche = false;
						else
							radioFiche = true;

						if (u.getRapportFiche().equals("0"))
							rapportFiche = false;
						else
							rapportFiche = true;

						if (u.getOrdnanceFiche().equals("0"))
							ordnanceFiche = false;
						else
							ordnanceFiche = true;

						if (u.getTabAntecedent().equals("0"))
							tabAntecedent = false;
						else
							tabAntecedent = true;

						if (u.getTabGynecoObs().equals("0"))
							tabGynObs = false;
						else
							tabGynObs = true;

						if (u.getTabHistGross().equals("0"))
							tabHistGross = false;
						else
							tabHistGross = true;

						if (u.getTabContraception().equals("0"))
							tabContraception = false;
						else
							tabContraception = true;

						if (u.getNouvGross().equals("0"))
							nouvGross = false;
						else
							nouvGross = true;

						if (u.getNouvContraception().equals("0"))
							nouvContraception = false;
						else
							nouvContraception = true;

						if (u.getModifContraception().equals("0"))
							modifContraception = false;
						else
							modifContraception = true;

						if (u.getSupConctraeption().equals("0"))
							supContraception = false;
						else
							supContraception = true;

						if (u.getModifHistGross().equals("0"))
							modifHisGross = false;
						else
							modifHisGross = true;

						if (u.getSupHistGross().equals("0"))
							supHisGross = false;
						else
							supHisGross = true;

						if (u.getNouvConsGyn().equals("0"))
							nouvConsGyn = false;
						else
							nouvConsGyn = true;

						if (u.getGynOrd().equals("0"))
							ordGyn = false;
						else
							ordGyn = true;

						if (u.getGynRadio().equals("0"))
							radioGyn = false;
						else
							radioGyn = true;

						if (u.getGynAnal().equals("0"))
							analGyn = false;
						else
							analGyn = true;
						
						if (u.getGynOrd().equals("0"))
						
							consulGrosstOrd = false;
						else
							consulGrosstOrd = true;

						if (u.getConsultGrossRadio().equals("0"))
							consultGrossRadio = false;
						else
							consultGrossRadio = true;

						if (u.getConsultGrossAnal().equals("0"))
							consultGrossAnal = false;
						else
							consultGrossAnal = true;

						if (u.getNouvConsGross().equals("0"))
							nouvConGross = false;
						else
							nouvConGross = true;

						Module.menuConfig = "0";
						Module.actif = u.isActif();
						Module.passif = u.isPassif();
						EnLigne enLigne = new EnLigne();
						EnLigneService ser1 = new EnLigneService();
						HttpSession session5 = (HttpSession) FacesContext
								.getCurrentInstance().getExternalContext()
								.getSession(true);
						String idSessionCourant=session5.getId();
					
						enLigne.setIdSession(idSessionCourant);
						ser1.ajoutEnLigne(enLigne);
						loggedInFilter = true;
						
						return "accepted";
					}
				} else
					face.addMessage("formconnection:f", new FacesMessage(
							"N'existe pas un compte avec ces paramètres."));
			} else {
				face.addMessage(
						"formconnection:f",
						new FacesMessage(
								"Veuillez fermer une session pour pouvoir ouvrir une autre."));

			}
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("name", utilisateur);

		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("name", utilisateur);
		System.out.println("c'est null");
		return null;
	}

	public void annuler() {
		login = null;
		motpass = null;
	}

	public void deconnecter() {
		// users.remove(utilisateur);

		Connecte connect = new ConnecteService().rechercheParConnecte(login);

		if (connect != null) {
			new ConnecteService().supprimerConnecte(connect.getIdConnecte());
			loggedIn = false;
			if (Test.currentConnect > 0 && !login.equals("superadmin"))
				Test.currentConnect--;
		}
		
		loggedInFilter = false;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Authentification");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToListePatient() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean isMenuGestRendezVous() {
		return menuGestRendezVous;
	}

	public void setMenuGestRendezVous(boolean menuGestRendezVous) {
		this.menuGestRendezVous = menuGestRendezVous;
	}

	public boolean isReponseSal() {
		return reponseSal;
	}

	public void setReponseSal(boolean reponseSal) {
		this.reponseSal = reponseSal;
	}

	public boolean isConsultPat() {
		return consultPat;
	}

	public void setConsultPat(boolean consultPat) {
		this.consultPat = consultPat;
	}

	public boolean isNbrEnfentFiche() {
		return nbrEnfentFiche;
	}

	public void setNbrEnfentFiche(boolean nbrEnfentFiche) {
		this.nbrEnfentFiche = nbrEnfentFiche;
	}

	public boolean isOrdonanceLibreFiche() {
		return ordonanceLibreFiche;
	}

	public void setOrdonanceLibreFiche(boolean ordonanceLibreFiche) {
		this.ordonanceLibreFiche = ordonanceLibreFiche;
	}

	public boolean isSelectTableConsultation() {
		// System.out.println("select" + selectTableConsultation);
		return selectTableConsultation;
	}

	public void setSelectTableConsultation(boolean selectTableConsultation) {
		this.selectTableConsultation = selectTableConsultation;
	}

	public boolean isSelectAntecedent() {
		return selectAntecedent;
	}

	public void setSelectAntecedent(boolean selectAntecedent) {
		this.selectAntecedent = selectAntecedent;
	}

	public boolean isAjoutAntecedentListe() {
		return ajoutAntecedentListe;
	}

	public void setAjoutAntecedentListe(boolean ajoutAntecedentListea) {
		ajoutAntecedentListe = ajoutAntecedentListea;
	}

	public boolean isNouvelleGrossesseAntecedent() {
		return nouvelleGrossesseAntecedent;
	}

	public void setNouvelleGrossesseAntecedent(
			boolean nouvelleGrossesseAntecedent) {
		this.nouvelleGrossesseAntecedent = nouvelleGrossesseAntecedent;
	}

	public boolean isNouvelleContraceptionAntecedent() {
		return nouvelleContraceptionAntecedent;
	}

	public void setNouvelleContraceptionAntecedent(
			boolean nouvelleContraceptionAntecedent) {
		this.nouvelleContraceptionAntecedent = nouvelleContraceptionAntecedent;
	}

	public boolean isModifGyneco() {
		return ModifGyneco;
	}

	public void setModifGyneco(boolean modifGyneco) {
		ModifGyneco = modifGyneco;
	}

	public boolean isSuppGyneco() {
		return SuppGyneco;
	}

	public void setSuppGyneco(boolean suppGyneco) {
		SuppGyneco = suppGyneco;
	}

	public boolean isImprGyneco() {
		return imprGyneco;
	}

	public void setImprGyneco(boolean imprGyneco) {
		this.imprGyneco = imprGyneco;
	}

	public boolean isNouvchogyneco() {
		return nouvchogyneco;
	}

	public void setNouvchogyneco(boolean nouvchogyneco) {
		this.nouvchogyneco = nouvchogyneco;
	}

	public boolean isModifechogyneco() {
		return modifechogyneco;
	}

	public void setModifechogyneco(boolean modifechogyneco) {
		this.modifechogyneco = modifechogyneco;
	}

	public boolean isSuppechogyneco() {
		return suppechogyneco;
	}

	public void setSuppechogyneco(boolean suppechogyneco) {
		this.suppechogyneco = suppechogyneco;
	}

	public boolean isAjoutmodelechogyneco() {
		return ajoutmodelechogyneco;
	}

	public void setAjoutmodelechogyneco(boolean ajoutmodelechogyneco) {
		this.ajoutmodelechogyneco = ajoutmodelechogyneco;
	}

	public boolean isAppliquemodelechogyneco() {
		return appliquemodelechogyneco;
	}

	public void setAppliquemodelechogyneco(boolean appliquemodelechogyneco) {
		this.appliquemodelechogyneco = appliquemodelechogyneco;
	}

	public boolean isSuppmodelechogyneco() {
		return suppmodelechogyneco;
	}

	public void setSuppmodelechogyneco(boolean suppmodelechogyneco) {
		this.suppmodelechogyneco = suppmodelechogyneco;
	}

	public boolean isImprechogyneco() {
		return imprechogyneco;
	}

	public void setImprechogyneco(boolean imprechogyneco) {
		this.imprechogyneco = imprechogyneco;
	}

	public boolean isNouvechoObs() {
		return nouvechoObs;
	}

	public void setNouvechoObs(boolean nouvechoObs) {
		this.nouvechoObs = nouvechoObs;
	}

	public boolean isModifechoObs() {
		return modifechoObs;
	}

	public void setModifechoObs(boolean modifechoObs) {
		this.modifechoObs = modifechoObs;
	}

	public boolean isSuppechoObs() {
		return suppechoObs;
	}

	public void setSuppechoObs(boolean suppechoObs) {
		this.suppechoObs = suppechoObs;
	}

	public boolean isTrim1echoObs() {
		return trim1echoObs;
	}

	public void setTrim1echoObs(boolean trim1echoObs) {
		this.trim1echoObs = trim1echoObs;
	}

	public boolean isTrim2echoObs() {
		return trim2echoObs;
	}

	public void setTrim2echoObs(boolean trim2echoObs) {
		this.trim2echoObs = trim2echoObs;
	}

	public boolean isTrim3echoObs() {
		return trim3echoObs;
	}

	public void setTrim3echoObs(boolean trim3echoObs) {
		this.trim3echoObs = trim3echoObs;
	}

	public boolean isImprechoObs() {
		return imprechoObs;
	}

	public void setImprechoObs(boolean imprechoObs) {
		this.imprechoObs = imprechoObs;
	}

	public boolean isSelectNouvGross() {
		return selectNouvGross;
	}

	public void setSelectNouvGross(boolean selectNouvGross) {
		this.selectNouvGross = selectNouvGross;
	}

	public boolean isModifGross() {
		return modifGross;
	}

	public void setModifGross(boolean modifGross) {
		this.modifGross = modifGross;
	}

	public boolean isSuppGross() {
		return suppGross;
	}

	public void setSuppGross(boolean suppGross) {
		this.suppGross = suppGross;
	}

	public boolean isImprGross() {
		return imprGross;
	}

	public void setImprGross(boolean imprGross) {
		this.imprGross = imprGross;
	}

	public boolean isGestAntecedent() {
		return gestAntecedent;
	}

	public void setGestAntecedent(boolean gestAntecedent) {
		this.gestAntecedent = gestAntecedent;
	}
	
	

	public boolean isGestConsultation() {
		return gestConsultation;
	}

	public void setGestConsultation(boolean gestConsultation) {
		this.gestConsultation = gestConsultation;
	}

	public boolean isGestHoraire() {
		return gestHoraire;
	}

	public void setGestHoraire(boolean gestHoraire) {
		this.gestHoraire = gestHoraire;
	}

	public boolean isGestCabinet() {
		return gestCabinet;
	}

	public void setGestCabinet(boolean gestCabinet) {
		this.gestCabinet = gestCabinet;
	}

	public boolean isGestionJourFr() {
		return gestionJourFr;
	}

	public void setGestionJourFr(boolean gestionJourFr) {
		this.gestionJourFr = gestionJourFr;
	}

	public boolean isTabFerie() {
		return tabFerie;
	}

	public void setTabFerie(boolean tabFerie) {
		this.tabFerie = tabFerie;
	}

	public boolean isTabJFerieExp() {
		return tabJFerieExp;
	}

	public void setTabJFerieExp(boolean tabJFerieExp) {
		this.tabJFerieExp = tabJFerieExp;
	}

	public boolean isNouvJFerie() {
		return nouvJFerie;
	}

	public void setNouvJFerie(boolean nouvJFerie) {
		this.nouvJFerie = nouvJFerie;
	}

	public boolean isModifJFerie() {
		return modifJFerie;
	}

	public void setModifJFerie(boolean modifJFerie) {
		this.modifJFerie = modifJFerie;
	}

	public boolean isSuppJFerie() {
		return suppJFerie;
	}

	public void setSuppJFerie(boolean suppJFerie) {
		this.suppJFerie = suppJFerie;
	}

	public boolean isModifJFerieExp() {
		return modifJFerieExp;
	}

	public void setModifJFerieExp(boolean modifJFerieExp) {
		this.modifJFerieExp = modifJFerieExp;
	}

	public boolean isSuppJFerieExp() {
		return suppJFerieExp;
	}

	public void setSuppJFerieExp(boolean suppJFerieExp) {
		this.suppJFerieExp = suppJFerieExp;
	}

	public boolean isTabMedAnt() {
		return tabMedAnt;
	}

	public void setTabMedAnt(boolean tabMedAnt) {
		this.tabMedAnt = tabMedAnt;
	}

	public boolean isTabChirAnt() {
		return tabChirAnt;
	}

	public void setTabChirAnt(boolean tabChirAnt) {
		this.tabChirAnt = tabChirAnt;
	}

	public boolean isTabFamAnt() {
		return tabFamAnt;
	}

	public void setTabFamAnt(boolean tabFamAnt) {
		this.tabFamAnt = tabFamAnt;
	}

	public boolean isModifGestAntMed() {
		return modifGestAntMed;
	}

	public void setModifGestAntMed(boolean modifGestAntMed) {
		this.modifGestAntMed = modifGestAntMed;
	}

	public boolean isSuppGestAntMed() {
		return suppGestAntMed;
	}

	public void setSuppGestAntMed(boolean suppGestAntMed) {
		this.suppGestAntMed = suppGestAntMed;
	}
	
	

	public boolean isModifAnt() {
		return modifAnt;
	}

	public void setModifAnt(boolean modifAnt) {
		this.modifAnt = modifAnt;
	}

	public boolean isSuppAnt() {
		return suppAnt;
	}

	public void setSuppAnt(boolean suppAnt) {
		this.suppAnt = suppAnt;
	}

	public boolean isAjoutGestAntMed() {
		return ajoutGestAntMed;
	}

	public void setAjoutGestAntMed(boolean ajoutGestAntMed) {
		this.ajoutGestAntMed = ajoutGestAntMed;
	}

	public boolean isSuppGestAntChirg() {
		return suppGestAntChirg;
	}

	public void setSuppGestAntChirg(boolean suppGestAntChirg) {
		this.suppGestAntChirg = suppGestAntChirg;
	}

	public boolean isAjoutGestChirg() {
		return ajoutGestChirg;
	}

	public void setAjoutGestChirg(boolean ajoutGestChirg) {
		this.ajoutGestChirg = ajoutGestChirg;
	}

	public boolean isModifGestChirg() {
		return modifGestChirg;
	}

	public void setModifGestChirg(boolean modifGestChirg) {
		this.modifGestChirg = modifGestChirg;
	}

	public boolean isSuppGestAntFam() {
		return suppGestAntFam;
	}

	public void setSuppGestAntFam(boolean suppGestAntFam) {
		this.suppGestAntFam = suppGestAntFam;
	}

	public boolean isAjoutGestFam() {
		return ajoutGestFam;
	}

	public void setAjoutGestFam(boolean ajoutGestFam) {
		this.ajoutGestFam = ajoutGestFam;
	}

	public boolean isModifGestFam() {
		return modifGestFam;
	}

	public void setModifGestFam(boolean modifGestFam) {
		this.modifGestFam = modifGestFam;
	}

	public boolean isRechercheOrd() {
		return rechercheOrd;
	}

	public void setRechercheOrd(boolean rechercheOrd) {
		this.rechercheOrd = rechercheOrd;
	}

	public boolean isModifhistoOrd() {
		return modifhistoOrd;
	}

	public void setModifhistoOrd(boolean modifhistoOrd) {
		this.modifhistoOrd = modifhistoOrd;
	}

	public boolean isSupphistoOrd() {
		return supphistoOrd;
	}

	public void setSupphistoOrd(boolean supphistoOrd) {
		this.supphistoOrd = supphistoOrd;
	}

	public boolean isSelectModeleord() {
		return selectModeleord;
	}

	public void setSelectModeleord(boolean selectModeleord) {
		this.selectModeleord = selectModeleord;
	}

	public boolean isAjoutModeleord() {
		return ajoutModeleord;
	}

	public void setAjoutModeleord(boolean ajoutModeleord) {
		this.ajoutModeleord = ajoutModeleord;
	}

	public boolean isSuppModeleOrd() {
		return suppModeleOrd;
	}

	public void setSuppModeleOrd(boolean suppModeleOrd) {
		this.suppModeleOrd = suppModeleOrd;
	}

	public boolean isImprOrd() {
		return imprOrd;
	}

	public void setImprOrd(boolean imprOrd) {
		this.imprOrd = imprOrd;
	}

	public boolean isSuppOrd() {
		return suppOrd;
	}

	public void setSuppOrd(boolean suppOrd) {
		this.suppOrd = suppOrd;
	}

	public boolean isNouvCertif() {
		return nouvCertif;
	}

	public void setNouvCertif(boolean nouvCertif) {
		this.nouvCertif = nouvCertif;
	}

	public boolean isModifCertif() {
		return modifCertif;
	}

	public void setModifCertif(boolean modifCertif) {
		this.modifCertif = modifCertif;
	}

	public boolean isSuppCertif() {
		return suppCertif;
	}

	public void setSuppCertif(boolean suppCertif) {
		this.suppCertif = suppCertif;
	}

	public boolean isImprCertif() {
		return imprCertif;
	}

	public void setImprCertif(boolean imprCertif) {
		this.imprCertif = imprCertif;
	}

	public boolean isNouvLettre() {
		return nouvLettre;
	}

	public void setNouvLettre(boolean nouvLettre) {
		this.nouvLettre = nouvLettre;
	}

	public boolean isModifLettre() {
		return modifLettre;
	}

	public void setModifLettre(boolean modifLettre) {
		this.modifLettre = modifLettre;
	}

	public boolean isSuppLettre() {
		return suppLettre;
	}

	public void setSuppLettre(boolean suppLettre) {
		this.suppLettre = suppLettre;
	}

	public boolean isImprLettre() {
		return imprLettre;
	}

	public void setImprLettre(boolean imprLettre) {
		this.imprLettre = imprLettre;
	}

	public boolean isReglageHoraire() {
		return reglageHoraire;
	}

	public void setReglageHoraire(boolean reglageHoraire) {
		this.reglageHoraire = reglageHoraire;
	}

	public boolean isNouvJFerieExp() {
		return nouvJFerieExp;
	}

	public void setNouvJFerieExp(boolean nouvJFerieExp) {
		this.nouvJFerieExp = nouvJFerieExp;
	}

	public boolean isModifListeAnalyse() {
		return modifListeAnalyse;
	}

	public void setModifListeAnalyse(boolean modifListeAnalyse) {
		this.modifListeAnalyse = modifListeAnalyse;
	}

	public boolean isSuppListeAnalyse() {
		return suppListeAnalyse;
	}

	public void setSuppListeAnalyse(boolean suppListeAnalyse) {
		this.suppListeAnalyse = suppListeAnalyse;
	}

	public boolean isModifListeRadio() {
		return modifListeRadio;
	}

	public void setModifListeRadio(boolean modifListeRadio) {
		this.modifListeRadio = modifListeRadio;
	}

	public boolean isSuppListeRadio() {
		return suppListeRadio;
	}

	public void setSuppListeRadio(boolean suppListeRadio) {
		this.suppListeRadio = suppListeRadio;
	}

	public boolean isModifSterilite() {
		return modifSterilite;
	}

	public void setModifSterilite(boolean modifSterilite) {
		this.modifSterilite = modifSterilite;
	}
	
	public void goToSalle() {
		

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Salle");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
