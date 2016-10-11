package com.doctor.persistance;

import java.io.Serializable;

public class Modelutl implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idmodelUtl;
	private String nomModelUtl;
	private String menuSal;
	private String menuGestPat;
	private String menuParametre;
	private String menuRapport;
	private String menuGestUtl;
	private String menuGestRdv;
	private boolean menuGestStat;
	private String ajoutPatient;
	private String verSal;
	private String modPatient;
	private String detPatient;
	private String chargPatient;
	private String supPatient;
	private String tabInfGenAjoutPat;
	
	private String tabCntctAjoutPat;
	private String tabInfoConjAjoutPat;
	private String tabAutreInfAjoutPat;
	private String gestDoc;
	private String gestProf;
	private String gestVil;
	private String gestClin;
	private String rappCertif;
	private String rappOrdnce;
	private String rappLettre;
	private String monterPatSal;
	private String desdrePatSal;
	private String permutPatSal;
	private String premierPatSal;
	private String dernierPatSal;
	private String supPatSal;
	private String chargPatSal;
	private boolean supAnulSal;
	private String ajoutDoc;
	private String modifDoc;
	private String supDoc;
	private String ajoutProf;
	private String modifProf;
	private String supProf;
	private String ajoutVil;
	private String modifVil;
	private String supVil;
	private String ajoutClin;
	private String modifClin;
	private String supClin;
	private String antecedent;
	private String echoGyn;
	private String echoObs;
	private String gynecologie;
	private String consultGros;
	private String sterilite;
	private String tabAntecedent;
	private String tabGynecoObs;
	private String tabHistGross;
	private String tabContraception;
	private String supHistGross;
	private String modifHistGross;
	private String supConctraeption;
	private String modifContraception;
	private String nouvGross;
	private String nouvContraception;
	private String nouvConsGross;
	private String nouvConsGyn;
	private String consultGrossOrd;
	private String consultGrossAnal;
	private String consultGrossRadio;
	private String gynOrd;
	private String gynAnal;
	private String gynRadio;
	private String menuConfig;
	private String nouvPatSal;
	private String verConsult;
	private String certifFiche;
	private boolean gestionUterus;
	private String lettreFiche;
	private String analyseFiche;
	private String radioFiche;
	private String rapportFiche;
	private String ordnanceFiche;
	private String gestBb;
	private String gestAnal;
	private String gestMed;
	private String gestExm;
	private String gestMoyCtrcep;
	private String gestDiag;
	private String gestSyn;
	private String gestExmComp;
	
	
	private String gestEFG;

	private boolean nbrEnfentFiche;
	private boolean ordonanceLibreFiche;
	private boolean selectTableConsultation;

	private boolean modifRadio;
	private boolean supRadio;
	private boolean modifOrdnce;
	private boolean supOrdnce;
	private boolean modifAnalyse;
	private boolean supAnalyse;

	private boolean ajoutEtBb;
	private boolean supEtBb;
	private boolean modifEtBb;
	private boolean ajoutAnal;
	private boolean supAnal;
	private boolean modifAnal;
	private boolean ajoutMed;
	private boolean supMed;
	private boolean modifMed;
	private boolean ajoutExm;
	private boolean supExm;
	private boolean modifExm;
	private boolean ajoutMoyCtr;
	private boolean supMoyCtr;
	private boolean modifMoyCtr;
	private boolean ajoutDiag;
	private boolean supDiag;
	private boolean modifDiag;
	private boolean ajoutAsym;
	private boolean supAsym;
	private boolean modifAsym;
	private boolean ajoutExmComp;
	private boolean supExmComp;
	private boolean modifExmComp;
	private boolean modifCsltGyn;
	private boolean ajoutUt;
	private boolean modifUt;
	private boolean supUt;
	private boolean ajoutFM;
	private boolean modifFM;
	private boolean supFM;
	private boolean ajoutEFG;
	private boolean modifEFG;
	private boolean supEFG;
	private boolean ajoutRdv;
	private boolean modifRdv;
	private boolean selectAntecedent;
	private boolean ajoutAntecedentListe;
	private boolean nouvelleGrossesseAntecedent;
	private boolean nouvelleContraceptionAntecedent;
	private boolean supRdv;
	private boolean consultPat;
	private boolean modifCab;
	private boolean reponseSal;
	private boolean ModifGyneco;
	private boolean imprGyneco;
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
	private boolean modifCons;
	
	private boolean gestHoraire;
	private boolean gestCabinet;
	private boolean gestionJourFr;
	private boolean gestionFormMed;
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
	private boolean suppGestAntChirg;
	private boolean ajoutGestChirg;
	private boolean modifGestChirg;
	private boolean suppGestAntFam;
	private boolean ajoutGestFam;
	private boolean modifGestFam;
	private boolean nouvJFerieExp;
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
	private boolean modifSterilite;

	private boolean reglageHoraire;
	private boolean gestCertif;
	private boolean gestLettre;
	
	private boolean modifPrtSais;
	private boolean ajoutHeurTrav;
	private boolean modifHeurTrav;
	private boolean supHeurTrav;
	
	private boolean gestSais;
	
	private boolean donnerRdv;
	
	private boolean imprmAnal;
	private boolean imprRadio;
	
	
	private boolean consultDetAnal;
	private boolean consultDetRad;
    private boolean consultDetOrd;
	
   
    private boolean detHistoAnal;
    private boolean detHistoRad;
    
    private boolean consultArchiv;
    private boolean archiverPat;
    private boolean tabAnulSal;
    private boolean anulSal;
    private boolean modifNoteSal;
	
    private boolean modifAnt;
    private boolean suppAnt;
    private boolean modifGynObs;
	
    
    private boolean ajoutDemandeOrd;
    private boolean ajoutDemandeRad;
    private boolean ajoutDemandeAnal;
    
    private boolean affectEtoile;
    private boolean confSession;
    
    
    
	public boolean isAffectEtoile() {
		return affectEtoile;
	}
	public void setAffectEtoile(boolean affectEtoile) {
		this.affectEtoile = affectEtoile;
	}
	public boolean isAjoutDemandeOrd() {
		return ajoutDemandeOrd;
	}
	public void setAjoutDemandeOrd(boolean ajoutDemandeOrd) {
		this.ajoutDemandeOrd = ajoutDemandeOrd;
	}
	public boolean isAjoutDemandeRad() {
		return ajoutDemandeRad;
	}
	public void setAjoutDemandeRad(boolean ajoutDemandeRad) {
		this.ajoutDemandeRad = ajoutDemandeRad;
	}
	public boolean isAjoutDemandeAnal() {
		return ajoutDemandeAnal;
	}
	public void setAjoutDemandeAnal(boolean ajoutDemandeAnal) {
		this.ajoutDemandeAnal = ajoutDemandeAnal;
	}
	public boolean isModifGynObs() {
		return modifGynObs;
	}
	public void setModifGynObs(boolean modifGynObs) {
		this.modifGynObs = modifGynObs;
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
	public boolean isModifNoteSal() {
		return modifNoteSal;
	}
	public void setModifNoteSal(boolean modifNoteSal) {
		this.modifNoteSal = modifNoteSal;
	}
	public boolean isConsultArchiv() {
		return consultArchiv;
	}
	public void setConsultArchiv(boolean consultArchiv) {
		this.consultArchiv = consultArchiv;
	}
	public boolean isArchiverPat() {
		return archiverPat;
	}
	public void setArchiverPat(boolean archiverPat) {
		this.archiverPat = archiverPat;
	}
	public boolean isTabAnulSal() {
		return tabAnulSal;
	}
	public void setTabAnulSal(boolean tabAnulSal) {
		this.tabAnulSal = tabAnulSal;
	}
	public boolean isAnulSal() {
		return anulSal;
	}
	public void setAnulSal(boolean anulSal) {
		this.anulSal = anulSal;
	}
	public boolean isDetHistoAnal() {
		return detHistoAnal;
	}
	public void setDetHistoAnal(boolean detHistoAnal) {
		this.detHistoAnal = detHistoAnal;
	}
	public boolean isDetHistoRad() {
		return detHistoRad;
	}
	public void setDetHistoRad(boolean detHistoRad) {
		this.detHistoRad = detHistoRad;
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
	public boolean isImprmAnal() {
		return imprmAnal;
	}
	public void setImprmAnal(boolean imprmAnal) {
		this.imprmAnal = imprmAnal;
	}
	public boolean isImprRadio() {
		return imprRadio;
	}
	public void setImprRadio(boolean imprRadio) {
		this.imprRadio = imprRadio;
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
	public boolean isModifPrtSais() {
		return modifPrtSais;
	}
	public void setModifPrtSais(boolean modifPrtSais) {
		this.modifPrtSais = modifPrtSais;
	}
	public boolean isAjoutHeurTrav() {
		return ajoutHeurTrav;
	}
	public void setAjoutHeurTrav(boolean ajoutHeurTrav) {
		this.ajoutHeurTrav = ajoutHeurTrav;
	}
	public boolean isModifHeurTrav() {
		return modifHeurTrav;
	}
	public void setModifHeurTrav(boolean modifHeurTrav) {
		this.modifHeurTrav = modifHeurTrav;
	}
	public boolean isSupHeurTrav() {
		return supHeurTrav;
	}
	public void setSupHeurTrav(boolean supHeurTrav) {
		this.supHeurTrav = supHeurTrav;
	}
	public Integer getIdmodelUtl() {
		return idmodelUtl;
	}
	public void setIdmodelUtl(Integer idmodelUtl) {
		this.idmodelUtl = idmodelUtl;
	}
	public String getNomModelUtl() {
		return nomModelUtl;
	}
	public void setNomModelUtl(String nomModelUtl) {
		this.nomModelUtl = nomModelUtl;
	}
	public String getMenuSal() {
		return menuSal;
	}
	public void setMenuSal(String menuSal) {
		this.menuSal = menuSal;
	}
	public String getMenuGestPat() {
		return menuGestPat;
	}
	public void setMenuGestPat(String menuGestPat) {
		this.menuGestPat = menuGestPat;
	}
	public String getMenuParametre() {
		return menuParametre;
	}
	public void setMenuParametre(String menuParametre) {
		this.menuParametre = menuParametre;
	}
	public String getMenuRapport() {
		return menuRapport;
	}
	public void setMenuRapport(String menuRapport) {
		this.menuRapport = menuRapport;
	}
	public String getMenuGestUtl() {
		return menuGestUtl;
	}
	public void setMenuGestUtl(String menuGestUtl) {
		this.menuGestUtl = menuGestUtl;
	}
	public String getMenuGestRdv() {
		return menuGestRdv;
	}
	public void setMenuGestRdv(String menuGestRdv) {
		this.menuGestRdv = menuGestRdv;
	}
	
	
	public boolean isMenuGestStat() {
		return menuGestStat;
	}
	public void setMenuGestStat(boolean menuGestStat) {
		this.menuGestStat = menuGestStat;
	}
	public String getAjoutPatient() {
		return ajoutPatient;
	}
	public void setAjoutPatient(String ajoutPatient) {
		this.ajoutPatient = ajoutPatient;
	}
	public String getVerSal() {
		return verSal;
	}
	public void setVerSal(String verSal) {
		this.verSal = verSal;
	}
	public String getModPatient() {
		return modPatient;
	}
	public void setModPatient(String modPatient) {
		this.modPatient = modPatient;
	}
	public String getDetPatient() {
		return detPatient;
	}
	public void setDetPatient(String detPatient) {
		this.detPatient = detPatient;
	}
	public String getChargPatient() {
		return chargPatient;
	}
	public void setChargPatient(String chargPatient) {
		this.chargPatient = chargPatient;
	}
	public String getSupPatient() {
		return supPatient;
	}
	public void setSupPatient(String supPatient) {
		this.supPatient = supPatient;
	}
	public String getTabInfGenAjoutPat() {
		return tabInfGenAjoutPat;
	}
	public void setTabInfGenAjoutPat(String tabInfGenAjoutPat) {
		this.tabInfGenAjoutPat = tabInfGenAjoutPat;
	}
	public String getTabCntctAjoutPat() {
		return tabCntctAjoutPat;
	}
	public void setTabCntctAjoutPat(String tabCntctAjoutPat) {
		this.tabCntctAjoutPat = tabCntctAjoutPat;
	}
	public String getTabInfoConjAjoutPat() {
		return tabInfoConjAjoutPat;
	}
	public void setTabInfoConjAjoutPat(String tabInfoConjAjoutPat) {
		this.tabInfoConjAjoutPat = tabInfoConjAjoutPat;
	}
	public String getTabAutreInfAjoutPat() {
		return tabAutreInfAjoutPat;
	}
	public void setTabAutreInfAjoutPat(String tabAutreInfAjoutPat) {
		this.tabAutreInfAjoutPat = tabAutreInfAjoutPat;
	}
	public String getGestDoc() {
		return gestDoc;
	}
	public void setGestDoc(String gestDoc) {
		this.gestDoc = gestDoc;
	}
	public String getGestProf() {
		return gestProf;
	}
	public void setGestProf(String gestProf) {
		this.gestProf = gestProf;
	}
	public String getGestVil() {
		return gestVil;
	}
	public void setGestVil(String gestVil) {
		this.gestVil = gestVil;
	}
	public String getGestClin() {
		return gestClin;
	}
	public void setGestClin(String gestClin) {
		this.gestClin = gestClin;
	}
	public String getRappCertif() {
		return rappCertif;
	}
	public void setRappCertif(String rappCertif) {
		this.rappCertif = rappCertif;
	}
	public String getRappOrdnce() {
		return rappOrdnce;
	}
	public void setRappOrdnce(String rappOrdnce) {
		this.rappOrdnce = rappOrdnce;
	}
	public String getRappLettre() {
		return rappLettre;
	}
	public void setRappLettre(String rappLettre) {
		this.rappLettre = rappLettre;
	}
	public String getMonterPatSal() {
		return monterPatSal;
	}
	public void setMonterPatSal(String monterPatSal) {
		this.monterPatSal = monterPatSal;
	}
	public String getDesdrePatSal() {
		return desdrePatSal;
	}
	public void setDesdrePatSal(String desdrePatSal) {
		this.desdrePatSal = desdrePatSal;
	}
	public String getPermutPatSal() {
		return permutPatSal;
	}
	public void setPermutPatSal(String permutPatSal) {
		this.permutPatSal = permutPatSal;
	}
	public String getPremierPatSal() {
		return premierPatSal;
	}
	public void setPremierPatSal(String premierPatSal) {
		this.premierPatSal = premierPatSal;
	}
	public String getDernierPatSal() {
		return dernierPatSal;
	}
	public void setDernierPatSal(String dernierPatSal) {
		this.dernierPatSal = dernierPatSal;
	}
	public String getSupPatSal() {
		return supPatSal;
	}
	public void setSupPatSal(String supPatSal) {
		this.supPatSal = supPatSal;
	}
	public String getChargPatSal() {
		return chargPatSal;
	}
	public void setChargPatSal(String chargPatSal) {
		this.chargPatSal = chargPatSal;
	}
	public String getAjoutDoc() {
		return ajoutDoc;
	}
	public void setAjoutDoc(String ajoutDoc) {
		this.ajoutDoc = ajoutDoc;
	}
	public String getModifDoc() {
		return modifDoc;
	}
	public void setModifDoc(String modifDoc) {
		this.modifDoc = modifDoc;
	}
	public String getSupDoc() {
		return supDoc;
	}
	public void setSupDoc(String supDoc) {
		this.supDoc = supDoc;
	}
	public String getAjoutProf() {
		return ajoutProf;
	}
	public void setAjoutProf(String ajoutProf) {
		this.ajoutProf = ajoutProf;
	}
	public String getModifProf() {
		return modifProf;
	}
	public void setModifProf(String modifProf) {
		this.modifProf = modifProf;
	}
	public String getSupProf() {
		return supProf;
	}
	public void setSupProf(String supProf) {
		this.supProf = supProf;
	}
	public String getAjoutVil() {
		return ajoutVil;
	}
	public void setAjoutVil(String ajoutVil) {
		this.ajoutVil = ajoutVil;
	}
	public String getModifVil() {
		return modifVil;
	}
	public void setModifVil(String modifVil) {
		this.modifVil = modifVil;
	}
	public String getSupVil() {
		return supVil;
	}
	public void setSupVil(String supVil) {
		this.supVil = supVil;
	}
	public String getAjoutClin() {
		return ajoutClin;
	}
	public void setAjoutClin(String ajoutClin) {
		this.ajoutClin = ajoutClin;
	}
	public String getModifClin() {
		return modifClin;
	}
	public void setModifClin(String modifClin) {
		this.modifClin = modifClin;
	}
	public String getSupClin() {
		return supClin;
	}
	public void setSupClin(String supClin) {
		this.supClin = supClin;
	}
	public String getAntecedent() {
		return antecedent;
	}
	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}
	public String getEchoGyn() {
		return echoGyn;
	}
	public void setEchoGyn(String echoGyn) {
		this.echoGyn = echoGyn;
	}
	public String getEchoObs() {
		return echoObs;
	}
	public void setEchoObs(String echoObs) {
		this.echoObs = echoObs;
	}
	public String getGynecologie() {
		return gynecologie;
	}
	public void setGynecologie(String gynecologie) {
		this.gynecologie = gynecologie;
	}
	public String getConsultGros() {
		return consultGros;
	}
	public void setConsultGros(String consultGros) {
		this.consultGros = consultGros;
	}
	public String getSterilite() {
		return sterilite;
	}
	public void setSterilite(String sterilite) {
		this.sterilite = sterilite;
	}
	public String getTabAntecedent() {
		return tabAntecedent;
	}
	public void setTabAntecedent(String tabAntecedent) {
		this.tabAntecedent = tabAntecedent;
	}
	public String getTabGynecoObs() {
		return tabGynecoObs;
	}
	public void setTabGynecoObs(String tabGynecoObs) {
		this.tabGynecoObs = tabGynecoObs;
	}
	public String getTabHistGross() {
		return tabHistGross;
	}
	public void setTabHistGross(String tabHistGross) {
		this.tabHistGross = tabHistGross;
	}
	public String getTabContraception() {
		return tabContraception;
	}
	public void setTabContraception(String tabContraception) {
		this.tabContraception = tabContraception;
	}
	public String getSupHistGross() {
		return supHistGross;
	}
	public void setSupHistGross(String supHistGross) {
		this.supHistGross = supHistGross;
	}
	public String getModifHistGross() {
		return modifHistGross;
	}
	public void setModifHistGross(String modifHistGross) {
		this.modifHistGross = modifHistGross;
	}
	public String getSupConctraeption() {
		return supConctraeption;
	}
	public void setSupConctraeption(String supConctraeption) {
		this.supConctraeption = supConctraeption;
	}
	public String getModifContraception() {
		return modifContraception;
	}
	public void setModifContraception(String modifContraception) {
		this.modifContraception = modifContraception;
	}
	public String getNouvGross() {
		return nouvGross;
	}
	public void setNouvGross(String nouvGross) {
		this.nouvGross = nouvGross;
	}
	public String getNouvContraception() {
		return nouvContraception;
	}
	public void setNouvContraception(String nouvContraception) {
		this.nouvContraception = nouvContraception;
	}
	public String getNouvConsGross() {
		return nouvConsGross;
	}
	public void setNouvConsGross(String nouvConsGross) {
		this.nouvConsGross = nouvConsGross;
	}
	public String getNouvConsGyn() {
		return nouvConsGyn;
	}
	public void setNouvConsGyn(String nouvConsGyn) {
		this.nouvConsGyn = nouvConsGyn;
	}
	public String getConsultGrossOrd() {
		return consultGrossOrd;
	}
	public void setConsultGrossOrd(String consultGrossOrd) {
		this.consultGrossOrd = consultGrossOrd;
	}
	public String getConsultGrossAnal() {
		return consultGrossAnal;
	}
	public void setConsultGrossAnal(String consultGrossAnal) {
		this.consultGrossAnal = consultGrossAnal;
	}
	public String getConsultGrossRadio() {
		return consultGrossRadio;
	}
	public void setConsultGrossRadio(String consultGrossRadio) {
		this.consultGrossRadio = consultGrossRadio;
	}
	public String getGynOrd() {
		return gynOrd;
	}
	public void setGynOrd(String gynOrd) {
		this.gynOrd = gynOrd;
	}
	public String getGynAnal() {
		return gynAnal;
	}
	public void setGynAnal(String gynAnal) {
		this.gynAnal = gynAnal;
	}
	public String getGynRadio() {
		return gynRadio;
	}
	public void setGynRadio(String gynRadio) {
		this.gynRadio = gynRadio;
	}
	public String getMenuConfig() {
		return menuConfig;
	}
	public void setMenuConfig(String menuConfig) {
		this.menuConfig = menuConfig;
	}
	public String getNouvPatSal() {
		return nouvPatSal;
	}
	public void setNouvPatSal(String nouvPatSal) {
		this.nouvPatSal = nouvPatSal;
	}
	public String getVerConsult() {
		return verConsult;
	}
	public void setVerConsult(String verConsult) {
		this.verConsult = verConsult;
	}
	public String getCertifFiche() {
		return certifFiche;
	}
	public void setCertifFiche(String certifFiche) {
		this.certifFiche = certifFiche;
	}
	public boolean isGestionUterus() {
		return gestionUterus;
	}
	public void setGestionUterus(boolean gestionUterus) {
		this.gestionUterus = gestionUterus;
	}
	public String getLettreFiche() {
		return lettreFiche;
	}
	public void setLettreFiche(String lettreFiche) {
		this.lettreFiche = lettreFiche;
	}
	public String getAnalyseFiche() {
		return analyseFiche;
	}
	public void setAnalyseFiche(String analyseFiche) {
		this.analyseFiche = analyseFiche;
	}
	public String getRadioFiche() {
		return radioFiche;
	}
	public void setRadioFiche(String radioFiche) {
		this.radioFiche = radioFiche;
	}
	public String getRapportFiche() {
		return rapportFiche;
	}
	public void setRapportFiche(String rapportFiche) {
		this.rapportFiche = rapportFiche;
	}
	public String getOrdnanceFiche() {
		return ordnanceFiche;
	}
	public void setOrdnanceFiche(String ordnanceFiche) {
		this.ordnanceFiche = ordnanceFiche;
	}
	public String getGestBb() {
		return gestBb;
	}
	public void setGestBb(String gestBb) {
		this.gestBb = gestBb;
	}
	public String getGestAnal() {
		return gestAnal;
	}
	public void setGestAnal(String gestAnal) {
		this.gestAnal = gestAnal;
	}
	public String getGestMed() {
		return gestMed;
	}
	public void setGestMed(String gestMed) {
		this.gestMed = gestMed;
	}
	public String getGestExm() {
		return gestExm;
	}
	public void setGestExm(String gestExm) {
		this.gestExm = gestExm;
	}
	public String getGestMoyCtrcep() {
		return gestMoyCtrcep;
	}
	public void setGestMoyCtrcep(String gestMoyCtrcep) {
		this.gestMoyCtrcep = gestMoyCtrcep;
	}
	public String getGestDiag() {
		return gestDiag;
	}
	public void setGestDiag(String gestDiag) {
		this.gestDiag = gestDiag;
	}
	public String getGestSyn() {
		return gestSyn;
	}
	public void setGestSyn(String gestSyn) {
		this.gestSyn = gestSyn;
	}
	public String getGestExmComp() {
		return gestExmComp;
	}
	public void setGestExmComp(String gestExmComp) {
		this.gestExmComp = gestExmComp;
	}
	public String getGestEFG() {
		return gestEFG;
	}
	public void setGestEFG(String gestEFG) {
		this.gestEFG = gestEFG;
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
		return selectTableConsultation;
	}
	public void setSelectTableConsultation(boolean selectTableConsultation) {
		this.selectTableConsultation = selectTableConsultation;
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
	public boolean isAjoutEtBb() {
		return ajoutEtBb;
	}
	public void setAjoutEtBb(boolean ajoutEtBb) {
		this.ajoutEtBb = ajoutEtBb;
	}
	public boolean isSupEtBb() {
		return supEtBb;
	}
	public void setSupEtBb(boolean supEtBb) {
		this.supEtBb = supEtBb;
	}
	public boolean isModifEtBb() {
		return modifEtBb;
	}
	public void setModifEtBb(boolean modifEtBb) {
		this.modifEtBb = modifEtBb;
	}
	public boolean isAjoutAnal() {
		return ajoutAnal;
	}
	public void setAjoutAnal(boolean ajoutAnal) {
		this.ajoutAnal = ajoutAnal;
	}
	public boolean isSupAnal() {
		return supAnal;
	}
	public void setSupAnal(boolean supAnal) {
		this.supAnal = supAnal;
	}
	public boolean isModifAnal() {
		return modifAnal;
	}
	public void setModifAnal(boolean modifAnal) {
		this.modifAnal = modifAnal;
	}
	public boolean isAjoutMed() {
		return ajoutMed;
	}
	public void setAjoutMed(boolean ajoutMed) {
		this.ajoutMed = ajoutMed;
	}
	public boolean isSupMed() {
		return supMed;
	}
	public void setSupMed(boolean supMed) {
		this.supMed = supMed;
	}
	public boolean isModifMed() {
		return modifMed;
	}
	public void setModifMed(boolean modifMed) {
		this.modifMed = modifMed;
	}
	public boolean isAjoutExm() {
		return ajoutExm;
	}
	public void setAjoutExm(boolean ajoutExm) {
		this.ajoutExm = ajoutExm;
	}
	public boolean isSupExm() {
		return supExm;
	}
	public void setSupExm(boolean supExm) {
		this.supExm = supExm;
	}
	public boolean isModifExm() {
		return modifExm;
	}
	public void setModifExm(boolean modifExm) {
		this.modifExm = modifExm;
	}
	public boolean isAjoutMoyCtr() {
		return ajoutMoyCtr;
	}
	public void setAjoutMoyCtr(boolean ajoutMoyCtr) {
		this.ajoutMoyCtr = ajoutMoyCtr;
	}
	public boolean isSupMoyCtr() {
		return supMoyCtr;
	}
	public void setSupMoyCtr(boolean supMoyCtr) {
		this.supMoyCtr = supMoyCtr;
	}
	public boolean isModifMoyCtr() {
		return modifMoyCtr;
	}
	public void setModifMoyCtr(boolean modifMoyCtr) {
		this.modifMoyCtr = modifMoyCtr;
	}
	public boolean isAjoutDiag() {
		return ajoutDiag;
	}
	public void setAjoutDiag(boolean ajoutDiag) {
		this.ajoutDiag = ajoutDiag;
	}
	public boolean isSupDiag() {
		return supDiag;
	}
	public void setSupDiag(boolean supDiag) {
		this.supDiag = supDiag;
	}
	public boolean isModifDiag() {
		return modifDiag;
	}
	public void setModifDiag(boolean modifDiag) {
		this.modifDiag = modifDiag;
	}
	public boolean isAjoutAsym() {
		return ajoutAsym;
	}
	public void setAjoutAsym(boolean ajoutAsym) {
		this.ajoutAsym = ajoutAsym;
	}
	public boolean isSupAsym() {
		return supAsym;
	}
	public void setSupAsym(boolean supAsym) {
		this.supAsym = supAsym;
	}
	public boolean isModifAsym() {
		return modifAsym;
	}
	public void setModifAsym(boolean modifAsym) {
		this.modifAsym = modifAsym;
	}
	public boolean isAjoutExmComp() {
		return ajoutExmComp;
	}
	public void setAjoutExmComp(boolean ajoutExmComp) {
		this.ajoutExmComp = ajoutExmComp;
	}
	public boolean isSupExmComp() {
		return supExmComp;
	}
	public void setSupExmComp(boolean supExmComp) {
		this.supExmComp = supExmComp;
	}
	public boolean isModifExmComp() {
		return modifExmComp;
	}
	public void setModifExmComp(boolean modifExmComp) {
		this.modifExmComp = modifExmComp;
	}
	public boolean isModifCsltGyn() {
		return modifCsltGyn;
	}
	public void setModifCsltGyn(boolean modifCsltGyn) {
		this.modifCsltGyn = modifCsltGyn;
	}
	public boolean isAjoutUt() {
		return ajoutUt;
	}
	public void setAjoutUt(boolean ajoutUt) {
		this.ajoutUt = ajoutUt;
	}
	public boolean isModifUt() {
		return modifUt;
	}
	public void setModifUt(boolean modifUt) {
		this.modifUt = modifUt;
	}
	public boolean isSupUt() {
		return supUt;
	}
	public void setSupUt(boolean supUt) {
		this.supUt = supUt;
	}
	public boolean isAjoutFM() {
		return ajoutFM;
	}
	public void setAjoutFM(boolean ajoutFM) {
		this.ajoutFM = ajoutFM;
	}
	public boolean isModifFM() {
		return modifFM;
	}
	public void setModifFM(boolean modifFM) {
		this.modifFM = modifFM;
	}
	public boolean isSupFM() {
		return supFM;
	}
	public void setSupFM(boolean supFM) {
		this.supFM = supFM;
	}
	public boolean isAjoutEFG() {
		return ajoutEFG;
	}
	public void setAjoutEFG(boolean ajoutEFG) {
		this.ajoutEFG = ajoutEFG;
	}
	public boolean isModifEFG() {
		return modifEFG;
	}
	public void setModifEFG(boolean modifEFG) {
		this.modifEFG = modifEFG;
	}
	public boolean isSupEFG() {
		return supEFG;
	}
	public void setSupEFG(boolean supEFG) {
		this.supEFG = supEFG;
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
	public boolean isSelectAntecedent() {
		return selectAntecedent;
	}
	public void setSelectAntecedent(boolean selectAntecedent) {
		this.selectAntecedent = selectAntecedent;
	}
	public boolean isAjoutAntecedentListe() {
		return ajoutAntecedentListe;
	}
	public void setAjoutAntecedentListe(boolean ajoutAntecedentListe) {
		this.ajoutAntecedentListe = ajoutAntecedentListe;
	}
	public boolean isNouvelleGrossesseAntecedent() {
		return nouvelleGrossesseAntecedent;
	}
	public void setNouvelleGrossesseAntecedent(boolean nouvelleGrossesseAntecedent) {
		this.nouvelleGrossesseAntecedent = nouvelleGrossesseAntecedent;
	}
	public boolean isNouvelleContraceptionAntecedent() {
		return nouvelleContraceptionAntecedent;
	}
	public void setNouvelleContraceptionAntecedent(
			boolean nouvelleContraceptionAntecedent) {
		this.nouvelleContraceptionAntecedent = nouvelleContraceptionAntecedent;
	}
	public boolean isSupRdv() {
		return supRdv;
	}
	public void setSupRdv(boolean supRdv) {
		this.supRdv = supRdv;
	}
	public boolean isConsultPat() {
		return consultPat;
	}
	public void setConsultPat(boolean consultPat) {
		this.consultPat = consultPat;
	}
	public boolean isModifCab() {
		return modifCab;
	}
	public void setModifCab(boolean modifCab) {
		this.modifCab = modifCab;
	}
	public boolean isReponseSal() {
		return reponseSal;
	}
	public void setReponseSal(boolean reponseSal) {
		this.reponseSal = reponseSal;
	}
	public boolean isModifGyneco() {
		return ModifGyneco;
	}
	public void setModifGyneco(boolean modifGyneco) {
		ModifGyneco = modifGyneco;
	}
	public boolean isImprGyneco() {
		return imprGyneco;
	}
	public void setImprGyneco(boolean imprGyneco) {
		this.imprGyneco = imprGyneco;
	}
	public boolean isSuppGyneco() {
		return SuppGyneco;
	}
	public void setSuppGyneco(boolean suppGyneco) {
		SuppGyneco = suppGyneco;
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
	
	
	public boolean isModifCons() {
		return modifCons;
	}
	public void setModifCons(boolean modifCons) {
		this.modifCons = modifCons;
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
	public boolean isGestionFormMed() {
		return gestionFormMed;
	}
	public void setGestionFormMed(boolean gestionFormMed) {
		this.gestionFormMed = gestionFormMed;
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
	public boolean isNouvJFerieExp() {
		return nouvJFerieExp;
	}
	public void setNouvJFerieExp(boolean nouvJFerieExp) {
		this.nouvJFerieExp = nouvJFerieExp;
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
	public boolean isModifSterilite() {
		return modifSterilite;
	}
	public void setModifSterilite(boolean modifSterilite) {
		this.modifSterilite = modifSterilite;
	}
	public boolean isReglageHoraire() {
		return reglageHoraire;
	}
	public void setReglageHoraire(boolean reglageHoraire) {
		this.reglageHoraire = reglageHoraire;
	}
	public boolean isGestCertif() {
		return gestCertif;
	}
	public void setGestCertif(boolean gestCertif) {
		this.gestCertif = gestCertif;
	}
	public boolean isGestLettre() {
		return gestLettre;
	}
	public void setGestLettre(boolean gestLettre) {
		this.gestLettre = gestLettre;
	}
	
	
	
	public boolean isSupAnulSal() {
		return supAnulSal;
	}
	public void setSupAnulSal(boolean supAnulSal) {
		this.supAnulSal = supAnulSal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ModifGyneco ? 1231 : 1237);
		result = prime * result + (SuppGyneco ? 1231 : 1237);
		result = prime * result + (affectEtoile ? 1231 : 1237);
		result = prime * result + (ajoutAnal ? 1231 : 1237);
		result = prime * result + (ajoutAntecedentListe ? 1231 : 1237);
		result = prime * result + (ajoutAsym ? 1231 : 1237);
		result = prime * result
				+ ((ajoutClin == null) ? 0 : ajoutClin.hashCode());
		result = prime * result + (ajoutDemandeAnal ? 1231 : 1237);
		result = prime * result + (ajoutDemandeOrd ? 1231 : 1237);
		result = prime * result + (ajoutDemandeRad ? 1231 : 1237);
		result = prime * result + (ajoutDiag ? 1231 : 1237);
		result = prime * result
				+ ((ajoutDoc == null) ? 0 : ajoutDoc.hashCode());
		result = prime * result + (ajoutEFG ? 1231 : 1237);
		result = prime * result + (ajoutEtBb ? 1231 : 1237);
		result = prime * result + (ajoutExm ? 1231 : 1237);
		result = prime * result + (ajoutExmComp ? 1231 : 1237);
		result = prime * result + (ajoutFM ? 1231 : 1237);
		result = prime * result + (ajoutGestAntMed ? 1231 : 1237);
		result = prime * result + (ajoutGestChirg ? 1231 : 1237);
		result = prime * result + (ajoutGestFam ? 1231 : 1237);
		result = prime * result + (ajoutHeurTrav ? 1231 : 1237);
		result = prime * result + (ajoutMed ? 1231 : 1237);
		result = prime * result + (ajoutModeleord ? 1231 : 1237);
		result = prime * result + (ajoutMoyCtr ? 1231 : 1237);
		result = prime * result
				+ ((ajoutPatient == null) ? 0 : ajoutPatient.hashCode());
		result = prime * result
				+ ((ajoutProf == null) ? 0 : ajoutProf.hashCode());
		result = prime * result + (ajoutRdv ? 1231 : 1237);
		result = prime * result + (ajoutUt ? 1231 : 1237);
		result = prime * result
				+ ((ajoutVil == null) ? 0 : ajoutVil.hashCode());
		result = prime * result + (ajoutmodelechogyneco ? 1231 : 1237);
		result = prime * result
				+ ((analyseFiche == null) ? 0 : analyseFiche.hashCode());
		result = prime * result
				+ ((antecedent == null) ? 0 : antecedent.hashCode());
		result = prime * result + (anulSal ? 1231 : 1237);
		result = prime * result + (appliquemodelechogyneco ? 1231 : 1237);
		result = prime * result + (archiverPat ? 1231 : 1237);
		result = prime * result
				+ ((certifFiche == null) ? 0 : certifFiche.hashCode());
		result = prime * result
				+ ((chargPatSal == null) ? 0 : chargPatSal.hashCode());
		result = prime * result
				+ ((chargPatient == null) ? 0 : chargPatient.hashCode());
		result = prime * result + (confSession ? 1231 : 1237);
		result = prime * result + (consultArchiv ? 1231 : 1237);
		result = prime * result + (consultDetAnal ? 1231 : 1237);
		result = prime * result + (consultDetOrd ? 1231 : 1237);
		result = prime * result + (consultDetRad ? 1231 : 1237);
		result = prime * result
				+ ((consultGros == null) ? 0 : consultGros.hashCode());
		result = prime
				* result
				+ ((consultGrossAnal == null) ? 0 : consultGrossAnal.hashCode());
		result = prime * result
				+ ((consultGrossOrd == null) ? 0 : consultGrossOrd.hashCode());
		result = prime
				* result
				+ ((consultGrossRadio == null) ? 0 : consultGrossRadio
						.hashCode());
		result = prime * result + (consultPat ? 1231 : 1237);
		result = prime * result
				+ ((dernierPatSal == null) ? 0 : dernierPatSal.hashCode());
		result = prime * result
				+ ((desdrePatSal == null) ? 0 : desdrePatSal.hashCode());
		result = prime * result + (detHistoAnal ? 1231 : 1237);
		result = prime * result + (detHistoRad ? 1231 : 1237);
		result = prime * result
				+ ((detPatient == null) ? 0 : detPatient.hashCode());
		result = prime * result + (donnerRdv ? 1231 : 1237);
		result = prime * result + ((echoGyn == null) ? 0 : echoGyn.hashCode());
		result = prime * result + ((echoObs == null) ? 0 : echoObs.hashCode());
		result = prime * result
				+ ((gestAnal == null) ? 0 : gestAnal.hashCode());
		result = prime * result + (gestAntecedent ? 1231 : 1237);
		result = prime * result + ((gestBb == null) ? 0 : gestBb.hashCode());
		result = prime * result + (gestCabinet ? 1231 : 1237);
		result = prime * result + (gestCertif ? 1231 : 1237);
		result = prime * result
				+ ((gestClin == null) ? 0 : gestClin.hashCode());
		result = prime * result + (gestConsultation ? 1231 : 1237);
		result = prime * result
				+ ((gestDiag == null) ? 0 : gestDiag.hashCode());
		result = prime * result + ((gestDoc == null) ? 0 : gestDoc.hashCode());
		result = prime * result + ((gestEFG == null) ? 0 : gestEFG.hashCode());
		result = prime * result + ((gestExm == null) ? 0 : gestExm.hashCode());
		result = prime * result
				+ ((gestExmComp == null) ? 0 : gestExmComp.hashCode());
		result = prime * result + (gestHoraire ? 1231 : 1237);
		result = prime * result + (gestLettre ? 1231 : 1237);
		result = prime * result + ((gestMed == null) ? 0 : gestMed.hashCode());
		result = prime * result
				+ ((gestMoyCtrcep == null) ? 0 : gestMoyCtrcep.hashCode());
		result = prime * result
				+ ((gestProf == null) ? 0 : gestProf.hashCode());
		result = prime * result + (gestSais ? 1231 : 1237);
		result = prime * result + ((gestSyn == null) ? 0 : gestSyn.hashCode());
		result = prime * result + ((gestVil == null) ? 0 : gestVil.hashCode());
		result = prime * result + (gestionFormMed ? 1231 : 1237);
		result = prime * result + (gestionJourFr ? 1231 : 1237);
		result = prime * result + (gestionUterus ? 1231 : 1237);
		result = prime * result + ((gynAnal == null) ? 0 : gynAnal.hashCode());
		result = prime * result + ((gynOrd == null) ? 0 : gynOrd.hashCode());
		result = prime * result
				+ ((gynRadio == null) ? 0 : gynRadio.hashCode());
		result = prime * result
				+ ((gynecologie == null) ? 0 : gynecologie.hashCode());
		result = prime * result
				+ ((idmodelUtl == null) ? 0 : idmodelUtl.hashCode());
		result = prime * result + (imprCertif ? 1231 : 1237);
		result = prime * result + (imprGross ? 1231 : 1237);
		result = prime * result + (imprGyneco ? 1231 : 1237);
		result = prime * result + (imprLettre ? 1231 : 1237);
		result = prime * result + (imprOrd ? 1231 : 1237);
		result = prime * result + (imprRadio ? 1231 : 1237);
		result = prime * result + (imprechoObs ? 1231 : 1237);
		result = prime * result + (imprechogyneco ? 1231 : 1237);
		result = prime * result + (imprmAnal ? 1231 : 1237);
		result = prime * result
				+ ((lettreFiche == null) ? 0 : lettreFiche.hashCode());
		result = prime * result
				+ ((menuConfig == null) ? 0 : menuConfig.hashCode());
		result = prime * result
				+ ((menuGestPat == null) ? 0 : menuGestPat.hashCode());
		result = prime * result
				+ ((menuGestRdv == null) ? 0 : menuGestRdv.hashCode());
		result = prime * result + (menuGestStat ? 1231 : 1237);
		result = prime * result
				+ ((menuGestUtl == null) ? 0 : menuGestUtl.hashCode());
		result = prime * result
				+ ((menuParametre == null) ? 0 : menuParametre.hashCode());
		result = prime * result
				+ ((menuRapport == null) ? 0 : menuRapport.hashCode());
		result = prime * result + ((menuSal == null) ? 0 : menuSal.hashCode());
		result = prime * result
				+ ((modPatient == null) ? 0 : modPatient.hashCode());
		result = prime * result + (modifAnal ? 1231 : 1237);
		result = prime * result + (modifAnalyse ? 1231 : 1237);
		result = prime * result + (modifAnt ? 1231 : 1237);
		result = prime * result + (modifAsym ? 1231 : 1237);
		result = prime * result + (modifCab ? 1231 : 1237);
		result = prime * result + (modifCertif ? 1231 : 1237);
		result = prime * result
				+ ((modifClin == null) ? 0 : modifClin.hashCode());
		result = prime * result + (modifCons ? 1231 : 1237);
		result = prime
				* result
				+ ((modifContraception == null) ? 0 : modifContraception
						.hashCode());
		result = prime * result + (modifCsltGyn ? 1231 : 1237);
		result = prime * result + (modifDiag ? 1231 : 1237);
		result = prime * result
				+ ((modifDoc == null) ? 0 : modifDoc.hashCode());
		result = prime * result + (modifEFG ? 1231 : 1237);
		result = prime * result + (modifEtBb ? 1231 : 1237);
		result = prime * result + (modifExm ? 1231 : 1237);
		result = prime * result + (modifExmComp ? 1231 : 1237);
		result = prime * result + (modifFM ? 1231 : 1237);
		result = prime * result + (modifGestAntMed ? 1231 : 1237);
		result = prime * result + (modifGestChirg ? 1231 : 1237);
		result = prime * result + (modifGestFam ? 1231 : 1237);
		result = prime * result + (modifGross ? 1231 : 1237);
		result = prime * result + (modifGynObs ? 1231 : 1237);
		result = prime * result + (modifHeurTrav ? 1231 : 1237);
		result = prime * result
				+ ((modifHistGross == null) ? 0 : modifHistGross.hashCode());
		result = prime * result + (modifJFerie ? 1231 : 1237);
		result = prime * result + (modifJFerieExp ? 1231 : 1237);
		result = prime * result + (modifLettre ? 1231 : 1237);
		result = prime * result + (modifMed ? 1231 : 1237);
		result = prime * result + (modifMoyCtr ? 1231 : 1237);
		result = prime * result + (modifNoteSal ? 1231 : 1237);
		result = prime * result + (modifOrdnce ? 1231 : 1237);
		result = prime * result
				+ ((modifProf == null) ? 0 : modifProf.hashCode());
		result = prime * result + (modifPrtSais ? 1231 : 1237);
		result = prime * result + (modifRadio ? 1231 : 1237);
		result = prime * result + (modifRdv ? 1231 : 1237);
		result = prime * result + (modifSterilite ? 1231 : 1237);
		result = prime * result + (modifUt ? 1231 : 1237);
		result = prime * result
				+ ((modifVil == null) ? 0 : modifVil.hashCode());
		result = prime * result + (modifechoObs ? 1231 : 1237);
		result = prime * result + (modifechogyneco ? 1231 : 1237);
		result = prime * result + (modifhistoOrd ? 1231 : 1237);
		result = prime * result
				+ ((monterPatSal == null) ? 0 : monterPatSal.hashCode());
		result = prime * result + (nbrEnfentFiche ? 1231 : 1237);
		result = prime * result
				+ ((nomModelUtl == null) ? 0 : nomModelUtl.hashCode());
		result = prime * result + (nouvCertif ? 1231 : 1237);
		result = prime * result
				+ ((nouvConsGross == null) ? 0 : nouvConsGross.hashCode());
		result = prime * result
				+ ((nouvConsGyn == null) ? 0 : nouvConsGyn.hashCode());
		result = prime
				* result
				+ ((nouvContraception == null) ? 0 : nouvContraception
						.hashCode());
		result = prime * result
				+ ((nouvGross == null) ? 0 : nouvGross.hashCode());
		result = prime * result + (nouvJFerie ? 1231 : 1237);
		result = prime * result + (nouvJFerieExp ? 1231 : 1237);
		result = prime * result + (nouvLettre ? 1231 : 1237);
		result = prime * result
				+ ((nouvPatSal == null) ? 0 : nouvPatSal.hashCode());
		result = prime * result + (nouvchogyneco ? 1231 : 1237);
		result = prime * result + (nouvechoObs ? 1231 : 1237);
		result = prime * result
				+ (nouvelleContraceptionAntecedent ? 1231 : 1237);
		result = prime * result + (nouvelleGrossesseAntecedent ? 1231 : 1237);
		result = prime * result
				+ ((ordnanceFiche == null) ? 0 : ordnanceFiche.hashCode());
		result = prime * result + (ordonanceLibreFiche ? 1231 : 1237);
		result = prime * result
				+ ((permutPatSal == null) ? 0 : permutPatSal.hashCode());
		result = prime * result
				+ ((premierPatSal == null) ? 0 : premierPatSal.hashCode());
		result = prime * result
				+ ((radioFiche == null) ? 0 : radioFiche.hashCode());
		result = prime * result
				+ ((rappCertif == null) ? 0 : rappCertif.hashCode());
		result = prime * result
				+ ((rappLettre == null) ? 0 : rappLettre.hashCode());
		result = prime * result
				+ ((rappOrdnce == null) ? 0 : rappOrdnce.hashCode());
		result = prime * result
				+ ((rapportFiche == null) ? 0 : rapportFiche.hashCode());
		result = prime * result + (rechercheOrd ? 1231 : 1237);
		result = prime * result + (reglageHoraire ? 1231 : 1237);
		result = prime * result + (reponseSal ? 1231 : 1237);
		result = prime * result + (selectAntecedent ? 1231 : 1237);
		result = prime * result + (selectModeleord ? 1231 : 1237);
		result = prime * result + (selectNouvGross ? 1231 : 1237);
		result = prime * result + (selectTableConsultation ? 1231 : 1237);
		result = prime * result
				+ ((sterilite == null) ? 0 : sterilite.hashCode());
		result = prime * result + (supAnal ? 1231 : 1237);
		result = prime * result + (supAnalyse ? 1231 : 1237);
		result = prime * result + (supAnulSal ? 1231 : 1237);
		result = prime * result + (supAsym ? 1231 : 1237);
		result = prime * result + ((supClin == null) ? 0 : supClin.hashCode());
		result = prime
				* result
				+ ((supConctraeption == null) ? 0 : supConctraeption.hashCode());
		result = prime * result + (supDiag ? 1231 : 1237);
		result = prime * result + ((supDoc == null) ? 0 : supDoc.hashCode());
		result = prime * result + (supEFG ? 1231 : 1237);
		result = prime * result + (supEtBb ? 1231 : 1237);
		result = prime * result + (supExm ? 1231 : 1237);
		result = prime * result + (supExmComp ? 1231 : 1237);
		result = prime * result + (supFM ? 1231 : 1237);
		result = prime * result + (supHeurTrav ? 1231 : 1237);
		result = prime * result
				+ ((supHistGross == null) ? 0 : supHistGross.hashCode());
		result = prime * result + (supMed ? 1231 : 1237);
		result = prime * result + (supMoyCtr ? 1231 : 1237);
		result = prime * result + (supOrdnce ? 1231 : 1237);
		result = prime * result
				+ ((supPatSal == null) ? 0 : supPatSal.hashCode());
		result = prime * result
				+ ((supPatient == null) ? 0 : supPatient.hashCode());
		result = prime * result + ((supProf == null) ? 0 : supProf.hashCode());
		result = prime * result + (supRadio ? 1231 : 1237);
		result = prime * result + (supRdv ? 1231 : 1237);
		result = prime * result + (supUt ? 1231 : 1237);
		result = prime * result + ((supVil == null) ? 0 : supVil.hashCode());
		result = prime * result + (suppAnt ? 1231 : 1237);
		result = prime * result + (suppCertif ? 1231 : 1237);
		result = prime * result + (suppGestAntChirg ? 1231 : 1237);
		result = prime * result + (suppGestAntFam ? 1231 : 1237);
		result = prime * result + (suppGestAntMed ? 1231 : 1237);
		result = prime * result + (suppGross ? 1231 : 1237);
		result = prime * result + (suppJFerie ? 1231 : 1237);
		result = prime * result + (suppJFerieExp ? 1231 : 1237);
		result = prime * result + (suppLettre ? 1231 : 1237);
		result = prime * result + (suppModeleOrd ? 1231 : 1237);
		result = prime * result + (suppOrd ? 1231 : 1237);
		result = prime * result + (suppechoObs ? 1231 : 1237);
		result = prime * result + (suppechogyneco ? 1231 : 1237);
		result = prime * result + (supphistoOrd ? 1231 : 1237);
		result = prime * result + (suppmodelechogyneco ? 1231 : 1237);
		result = prime * result
				+ ((tabAntecedent == null) ? 0 : tabAntecedent.hashCode());
		result = prime * result + (tabAnulSal ? 1231 : 1237);
		result = prime
				* result
				+ ((tabAutreInfAjoutPat == null) ? 0 : tabAutreInfAjoutPat
						.hashCode());
		result = prime * result + (tabChirAnt ? 1231 : 1237);
		result = prime
				* result
				+ ((tabCntctAjoutPat == null) ? 0 : tabCntctAjoutPat.hashCode());
		result = prime
				* result
				+ ((tabContraception == null) ? 0 : tabContraception.hashCode());
		result = prime * result + (tabFamAnt ? 1231 : 1237);
		result = prime * result + (tabFerie ? 1231 : 1237);
		result = prime * result
				+ ((tabGynecoObs == null) ? 0 : tabGynecoObs.hashCode());
		result = prime * result
				+ ((tabHistGross == null) ? 0 : tabHistGross.hashCode());
		result = prime
				* result
				+ ((tabInfGenAjoutPat == null) ? 0 : tabInfGenAjoutPat
						.hashCode());
		result = prime
				* result
				+ ((tabInfoConjAjoutPat == null) ? 0 : tabInfoConjAjoutPat
						.hashCode());
		result = prime * result + (tabJFerieExp ? 1231 : 1237);
		result = prime * result + (tabMedAnt ? 1231 : 1237);
		result = prime * result + (trim1echoObs ? 1231 : 1237);
		result = prime * result + (trim2echoObs ? 1231 : 1237);
		result = prime * result + (trim3echoObs ? 1231 : 1237);
		result = prime * result
				+ ((verConsult == null) ? 0 : verConsult.hashCode());
		result = prime * result + ((verSal == null) ? 0 : verSal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelutl other = (Modelutl) obj;
		if (ModifGyneco != other.ModifGyneco)
			return false;
		if (SuppGyneco != other.SuppGyneco)
			return false;
		if (affectEtoile != other.affectEtoile)
			return false;
		if (ajoutAnal != other.ajoutAnal)
			return false;
		if (ajoutAntecedentListe != other.ajoutAntecedentListe)
			return false;
		if (ajoutAsym != other.ajoutAsym)
			return false;
		if (ajoutClin == null) {
			if (other.ajoutClin != null)
				return false;
		} else if (!ajoutClin.equals(other.ajoutClin))
			return false;
		if (ajoutDemandeAnal != other.ajoutDemandeAnal)
			return false;
		if (ajoutDemandeOrd != other.ajoutDemandeOrd)
			return false;
		if (ajoutDemandeRad != other.ajoutDemandeRad)
			return false;
		if (ajoutDiag != other.ajoutDiag)
			return false;
		if (ajoutDoc == null) {
			if (other.ajoutDoc != null)
				return false;
		} else if (!ajoutDoc.equals(other.ajoutDoc))
			return false;
		if (ajoutEFG != other.ajoutEFG)
			return false;
		if (ajoutEtBb != other.ajoutEtBb)
			return false;
		if (ajoutExm != other.ajoutExm)
			return false;
		if (ajoutExmComp != other.ajoutExmComp)
			return false;
		if (ajoutFM != other.ajoutFM)
			return false;
		if (ajoutGestAntMed != other.ajoutGestAntMed)
			return false;
		if (ajoutGestChirg != other.ajoutGestChirg)
			return false;
		if (ajoutGestFam != other.ajoutGestFam)
			return false;
		if (ajoutHeurTrav != other.ajoutHeurTrav)
			return false;
		if (ajoutMed != other.ajoutMed)
			return false;
		if (ajoutModeleord != other.ajoutModeleord)
			return false;
		if (ajoutMoyCtr != other.ajoutMoyCtr)
			return false;
		if (ajoutPatient == null) {
			if (other.ajoutPatient != null)
				return false;
		} else if (!ajoutPatient.equals(other.ajoutPatient))
			return false;
		if (ajoutProf == null) {
			if (other.ajoutProf != null)
				return false;
		} else if (!ajoutProf.equals(other.ajoutProf))
			return false;
		if (ajoutRdv != other.ajoutRdv)
			return false;
		if (ajoutUt != other.ajoutUt)
			return false;
		if (ajoutVil == null) {
			if (other.ajoutVil != null)
				return false;
		} else if (!ajoutVil.equals(other.ajoutVil))
			return false;
		if (ajoutmodelechogyneco != other.ajoutmodelechogyneco)
			return false;
		if (analyseFiche == null) {
			if (other.analyseFiche != null)
				return false;
		} else if (!analyseFiche.equals(other.analyseFiche))
			return false;
		if (antecedent == null) {
			if (other.antecedent != null)
				return false;
		} else if (!antecedent.equals(other.antecedent))
			return false;
		if (anulSal != other.anulSal)
			return false;
		if (appliquemodelechogyneco != other.appliquemodelechogyneco)
			return false;
		if (archiverPat != other.archiverPat)
			return false;
		if (certifFiche == null) {
			if (other.certifFiche != null)
				return false;
		} else if (!certifFiche.equals(other.certifFiche))
			return false;
		if (chargPatSal == null) {
			if (other.chargPatSal != null)
				return false;
		} else if (!chargPatSal.equals(other.chargPatSal))
			return false;
		if (chargPatient == null) {
			if (other.chargPatient != null)
				return false;
		} else if (!chargPatient.equals(other.chargPatient))
			return false;
		if (confSession != other.confSession)
			return false;
		if (consultArchiv != other.consultArchiv)
			return false;
		if (consultDetAnal != other.consultDetAnal)
			return false;
		if (consultDetOrd != other.consultDetOrd)
			return false;
		if (consultDetRad != other.consultDetRad)
			return false;
		if (consultGros == null) {
			if (other.consultGros != null)
				return false;
		} else if (!consultGros.equals(other.consultGros))
			return false;
		if (consultGrossAnal == null) {
			if (other.consultGrossAnal != null)
				return false;
		} else if (!consultGrossAnal.equals(other.consultGrossAnal))
			return false;
		if (consultGrossOrd == null) {
			if (other.consultGrossOrd != null)
				return false;
		} else if (!consultGrossOrd.equals(other.consultGrossOrd))
			return false;
		if (consultGrossRadio == null) {
			if (other.consultGrossRadio != null)
				return false;
		} else if (!consultGrossRadio.equals(other.consultGrossRadio))
			return false;
		if (consultPat != other.consultPat)
			return false;
		if (dernierPatSal == null) {
			if (other.dernierPatSal != null)
				return false;
		} else if (!dernierPatSal.equals(other.dernierPatSal))
			return false;
		if (desdrePatSal == null) {
			if (other.desdrePatSal != null)
				return false;
		} else if (!desdrePatSal.equals(other.desdrePatSal))
			return false;
		if (detHistoAnal != other.detHistoAnal)
			return false;
		if (detHistoRad != other.detHistoRad)
			return false;
		if (detPatient == null) {
			if (other.detPatient != null)
				return false;
		} else if (!detPatient.equals(other.detPatient))
			return false;
		if (donnerRdv != other.donnerRdv)
			return false;
		if (echoGyn == null) {
			if (other.echoGyn != null)
				return false;
		} else if (!echoGyn.equals(other.echoGyn))
			return false;
		if (echoObs == null) {
			if (other.echoObs != null)
				return false;
		} else if (!echoObs.equals(other.echoObs))
			return false;
		if (gestAnal == null) {
			if (other.gestAnal != null)
				return false;
		} else if (!gestAnal.equals(other.gestAnal))
			return false;
		if (gestAntecedent != other.gestAntecedent)
			return false;
		if (gestBb == null) {
			if (other.gestBb != null)
				return false;
		} else if (!gestBb.equals(other.gestBb))
			return false;
		if (gestCabinet != other.gestCabinet)
			return false;
		if (gestCertif != other.gestCertif)
			return false;
		if (gestClin == null) {
			if (other.gestClin != null)
				return false;
		} else if (!gestClin.equals(other.gestClin))
			return false;
		if (gestConsultation != other.gestConsultation)
			return false;
		if (gestDiag == null) {
			if (other.gestDiag != null)
				return false;
		} else if (!gestDiag.equals(other.gestDiag))
			return false;
		if (gestDoc == null) {
			if (other.gestDoc != null)
				return false;
		} else if (!gestDoc.equals(other.gestDoc))
			return false;
		if (gestEFG == null) {
			if (other.gestEFG != null)
				return false;
		} else if (!gestEFG.equals(other.gestEFG))
			return false;
		if (gestExm == null) {
			if (other.gestExm != null)
				return false;
		} else if (!gestExm.equals(other.gestExm))
			return false;
		if (gestExmComp == null) {
			if (other.gestExmComp != null)
				return false;
		} else if (!gestExmComp.equals(other.gestExmComp))
			return false;
		if (gestHoraire != other.gestHoraire)
			return false;
		if (gestLettre != other.gestLettre)
			return false;
		if (gestMed == null) {
			if (other.gestMed != null)
				return false;
		} else if (!gestMed.equals(other.gestMed))
			return false;
		if (gestMoyCtrcep == null) {
			if (other.gestMoyCtrcep != null)
				return false;
		} else if (!gestMoyCtrcep.equals(other.gestMoyCtrcep))
			return false;
		if (gestProf == null) {
			if (other.gestProf != null)
				return false;
		} else if (!gestProf.equals(other.gestProf))
			return false;
		if (gestSais != other.gestSais)
			return false;
		if (gestSyn == null) {
			if (other.gestSyn != null)
				return false;
		} else if (!gestSyn.equals(other.gestSyn))
			return false;
		if (gestVil == null) {
			if (other.gestVil != null)
				return false;
		} else if (!gestVil.equals(other.gestVil))
			return false;
		if (gestionFormMed != other.gestionFormMed)
			return false;
		if (gestionJourFr != other.gestionJourFr)
			return false;
		if (gestionUterus != other.gestionUterus)
			return false;
		if (gynAnal == null) {
			if (other.gynAnal != null)
				return false;
		} else if (!gynAnal.equals(other.gynAnal))
			return false;
		if (gynOrd == null) {
			if (other.gynOrd != null)
				return false;
		} else if (!gynOrd.equals(other.gynOrd))
			return false;
		if (gynRadio == null) {
			if (other.gynRadio != null)
				return false;
		} else if (!gynRadio.equals(other.gynRadio))
			return false;
		if (gynecologie == null) {
			if (other.gynecologie != null)
				return false;
		} else if (!gynecologie.equals(other.gynecologie))
			return false;
		if (idmodelUtl == null) {
			if (other.idmodelUtl != null)
				return false;
		} else if (!idmodelUtl.equals(other.idmodelUtl))
			return false;
		if (imprCertif != other.imprCertif)
			return false;
		if (imprGross != other.imprGross)
			return false;
		if (imprGyneco != other.imprGyneco)
			return false;
		if (imprLettre != other.imprLettre)
			return false;
		if (imprOrd != other.imprOrd)
			return false;
		if (imprRadio != other.imprRadio)
			return false;
		if (imprechoObs != other.imprechoObs)
			return false;
		if (imprechogyneco != other.imprechogyneco)
			return false;
		if (imprmAnal != other.imprmAnal)
			return false;
		if (lettreFiche == null) {
			if (other.lettreFiche != null)
				return false;
		} else if (!lettreFiche.equals(other.lettreFiche))
			return false;
		if (menuConfig == null) {
			if (other.menuConfig != null)
				return false;
		} else if (!menuConfig.equals(other.menuConfig))
			return false;
		if (menuGestPat == null) {
			if (other.menuGestPat != null)
				return false;
		} else if (!menuGestPat.equals(other.menuGestPat))
			return false;
		if (menuGestRdv == null) {
			if (other.menuGestRdv != null)
				return false;
		} else if (!menuGestRdv.equals(other.menuGestRdv))
			return false;
		if (menuGestStat != other.menuGestStat)
			return false;
		if (menuGestUtl == null) {
			if (other.menuGestUtl != null)
				return false;
		} else if (!menuGestUtl.equals(other.menuGestUtl))
			return false;
		if (menuParametre == null) {
			if (other.menuParametre != null)
				return false;
		} else if (!menuParametre.equals(other.menuParametre))
			return false;
		if (menuRapport == null) {
			if (other.menuRapport != null)
				return false;
		} else if (!menuRapport.equals(other.menuRapport))
			return false;
		if (menuSal == null) {
			if (other.menuSal != null)
				return false;
		} else if (!menuSal.equals(other.menuSal))
			return false;
		if (modPatient == null) {
			if (other.modPatient != null)
				return false;
		} else if (!modPatient.equals(other.modPatient))
			return false;
		if (modifAnal != other.modifAnal)
			return false;
		if (modifAnalyse != other.modifAnalyse)
			return false;
		if (modifAnt != other.modifAnt)
			return false;
		if (modifAsym != other.modifAsym)
			return false;
		if (modifCab != other.modifCab)
			return false;
		if (modifCertif != other.modifCertif)
			return false;
		if (modifClin == null) {
			if (other.modifClin != null)
				return false;
		} else if (!modifClin.equals(other.modifClin))
			return false;
		if (modifCons != other.modifCons)
			return false;
		if (modifContraception == null) {
			if (other.modifContraception != null)
				return false;
		} else if (!modifContraception.equals(other.modifContraception))
			return false;
		if (modifCsltGyn != other.modifCsltGyn)
			return false;
		if (modifDiag != other.modifDiag)
			return false;
		if (modifDoc == null) {
			if (other.modifDoc != null)
				return false;
		} else if (!modifDoc.equals(other.modifDoc))
			return false;
		if (modifEFG != other.modifEFG)
			return false;
		if (modifEtBb != other.modifEtBb)
			return false;
		if (modifExm != other.modifExm)
			return false;
		if (modifExmComp != other.modifExmComp)
			return false;
		if (modifFM != other.modifFM)
			return false;
		if (modifGestAntMed != other.modifGestAntMed)
			return false;
		if (modifGestChirg != other.modifGestChirg)
			return false;
		if (modifGestFam != other.modifGestFam)
			return false;
		if (modifGross != other.modifGross)
			return false;
		if (modifGynObs != other.modifGynObs)
			return false;
		if (modifHeurTrav != other.modifHeurTrav)
			return false;
		if (modifHistGross == null) {
			if (other.modifHistGross != null)
				return false;
		} else if (!modifHistGross.equals(other.modifHistGross))
			return false;
		if (modifJFerie != other.modifJFerie)
			return false;
		if (modifJFerieExp != other.modifJFerieExp)
			return false;
		if (modifLettre != other.modifLettre)
			return false;
		if (modifMed != other.modifMed)
			return false;
		if (modifMoyCtr != other.modifMoyCtr)
			return false;
		if (modifNoteSal != other.modifNoteSal)
			return false;
		if (modifOrdnce != other.modifOrdnce)
			return false;
		if (modifProf == null) {
			if (other.modifProf != null)
				return false;
		} else if (!modifProf.equals(other.modifProf))
			return false;
		if (modifPrtSais != other.modifPrtSais)
			return false;
		if (modifRadio != other.modifRadio)
			return false;
		if (modifRdv != other.modifRdv)
			return false;
		if (modifSterilite != other.modifSterilite)
			return false;
		if (modifUt != other.modifUt)
			return false;
		if (modifVil == null) {
			if (other.modifVil != null)
				return false;
		} else if (!modifVil.equals(other.modifVil))
			return false;
		if (modifechoObs != other.modifechoObs)
			return false;
		if (modifechogyneco != other.modifechogyneco)
			return false;
		if (modifhistoOrd != other.modifhistoOrd)
			return false;
		if (monterPatSal == null) {
			if (other.monterPatSal != null)
				return false;
		} else if (!monterPatSal.equals(other.monterPatSal))
			return false;
		if (nbrEnfentFiche != other.nbrEnfentFiche)
			return false;
		if (nomModelUtl == null) {
			if (other.nomModelUtl != null)
				return false;
		} else if (!nomModelUtl.equals(other.nomModelUtl))
			return false;
		if (nouvCertif != other.nouvCertif)
			return false;
		if (nouvConsGross == null) {
			if (other.nouvConsGross != null)
				return false;
		} else if (!nouvConsGross.equals(other.nouvConsGross))
			return false;
		if (nouvConsGyn == null) {
			if (other.nouvConsGyn != null)
				return false;
		} else if (!nouvConsGyn.equals(other.nouvConsGyn))
			return false;
		if (nouvContraception == null) {
			if (other.nouvContraception != null)
				return false;
		} else if (!nouvContraception.equals(other.nouvContraception))
			return false;
		if (nouvGross == null) {
			if (other.nouvGross != null)
				return false;
		} else if (!nouvGross.equals(other.nouvGross))
			return false;
		if (nouvJFerie != other.nouvJFerie)
			return false;
		if (nouvJFerieExp != other.nouvJFerieExp)
			return false;
		if (nouvLettre != other.nouvLettre)
			return false;
		if (nouvPatSal == null) {
			if (other.nouvPatSal != null)
				return false;
		} else if (!nouvPatSal.equals(other.nouvPatSal))
			return false;
		if (nouvchogyneco != other.nouvchogyneco)
			return false;
		if (nouvechoObs != other.nouvechoObs)
			return false;
		if (nouvelleContraceptionAntecedent != other.nouvelleContraceptionAntecedent)
			return false;
		if (nouvelleGrossesseAntecedent != other.nouvelleGrossesseAntecedent)
			return false;
		if (ordnanceFiche == null) {
			if (other.ordnanceFiche != null)
				return false;
		} else if (!ordnanceFiche.equals(other.ordnanceFiche))
			return false;
		if (ordonanceLibreFiche != other.ordonanceLibreFiche)
			return false;
		if (permutPatSal == null) {
			if (other.permutPatSal != null)
				return false;
		} else if (!permutPatSal.equals(other.permutPatSal))
			return false;
		if (premierPatSal == null) {
			if (other.premierPatSal != null)
				return false;
		} else if (!premierPatSal.equals(other.premierPatSal))
			return false;
		if (radioFiche == null) {
			if (other.radioFiche != null)
				return false;
		} else if (!radioFiche.equals(other.radioFiche))
			return false;
		if (rappCertif == null) {
			if (other.rappCertif != null)
				return false;
		} else if (!rappCertif.equals(other.rappCertif))
			return false;
		if (rappLettre == null) {
			if (other.rappLettre != null)
				return false;
		} else if (!rappLettre.equals(other.rappLettre))
			return false;
		if (rappOrdnce == null) {
			if (other.rappOrdnce != null)
				return false;
		} else if (!rappOrdnce.equals(other.rappOrdnce))
			return false;
		if (rapportFiche == null) {
			if (other.rapportFiche != null)
				return false;
		} else if (!rapportFiche.equals(other.rapportFiche))
			return false;
		if (rechercheOrd != other.rechercheOrd)
			return false;
		if (reglageHoraire != other.reglageHoraire)
			return false;
		if (reponseSal != other.reponseSal)
			return false;
		if (selectAntecedent != other.selectAntecedent)
			return false;
		if (selectModeleord != other.selectModeleord)
			return false;
		if (selectNouvGross != other.selectNouvGross)
			return false;
		if (selectTableConsultation != other.selectTableConsultation)
			return false;
		if (sterilite == null) {
			if (other.sterilite != null)
				return false;
		} else if (!sterilite.equals(other.sterilite))
			return false;
		if (supAnal != other.supAnal)
			return false;
		if (supAnalyse != other.supAnalyse)
			return false;
		if (supAnulSal != other.supAnulSal)
			return false;
		if (supAsym != other.supAsym)
			return false;
		if (supClin == null) {
			if (other.supClin != null)
				return false;
		} else if (!supClin.equals(other.supClin))
			return false;
		if (supConctraeption == null) {
			if (other.supConctraeption != null)
				return false;
		} else if (!supConctraeption.equals(other.supConctraeption))
			return false;
		if (supDiag != other.supDiag)
			return false;
		if (supDoc == null) {
			if (other.supDoc != null)
				return false;
		} else if (!supDoc.equals(other.supDoc))
			return false;
		if (supEFG != other.supEFG)
			return false;
		if (supEtBb != other.supEtBb)
			return false;
		if (supExm != other.supExm)
			return false;
		if (supExmComp != other.supExmComp)
			return false;
		if (supFM != other.supFM)
			return false;
		if (supHeurTrav != other.supHeurTrav)
			return false;
		if (supHistGross == null) {
			if (other.supHistGross != null)
				return false;
		} else if (!supHistGross.equals(other.supHistGross))
			return false;
		if (supMed != other.supMed)
			return false;
		if (supMoyCtr != other.supMoyCtr)
			return false;
		if (supOrdnce != other.supOrdnce)
			return false;
		if (supPatSal == null) {
			if (other.supPatSal != null)
				return false;
		} else if (!supPatSal.equals(other.supPatSal))
			return false;
		if (supPatient == null) {
			if (other.supPatient != null)
				return false;
		} else if (!supPatient.equals(other.supPatient))
			return false;
		if (supProf == null) {
			if (other.supProf != null)
				return false;
		} else if (!supProf.equals(other.supProf))
			return false;
		if (supRadio != other.supRadio)
			return false;
		if (supRdv != other.supRdv)
			return false;
		if (supUt != other.supUt)
			return false;
		if (supVil == null) {
			if (other.supVil != null)
				return false;
		} else if (!supVil.equals(other.supVil))
			return false;
		if (suppAnt != other.suppAnt)
			return false;
		if (suppCertif != other.suppCertif)
			return false;
		if (suppGestAntChirg != other.suppGestAntChirg)
			return false;
		if (suppGestAntFam != other.suppGestAntFam)
			return false;
		if (suppGestAntMed != other.suppGestAntMed)
			return false;
		if (suppGross != other.suppGross)
			return false;
		if (suppJFerie != other.suppJFerie)
			return false;
		if (suppJFerieExp != other.suppJFerieExp)
			return false;
		if (suppLettre != other.suppLettre)
			return false;
		if (suppModeleOrd != other.suppModeleOrd)
			return false;
		if (suppOrd != other.suppOrd)
			return false;
		if (suppechoObs != other.suppechoObs)
			return false;
		if (suppechogyneco != other.suppechogyneco)
			return false;
		if (supphistoOrd != other.supphistoOrd)
			return false;
		if (suppmodelechogyneco != other.suppmodelechogyneco)
			return false;
		if (tabAntecedent == null) {
			if (other.tabAntecedent != null)
				return false;
		} else if (!tabAntecedent.equals(other.tabAntecedent))
			return false;
		if (tabAnulSal != other.tabAnulSal)
			return false;
		if (tabAutreInfAjoutPat == null) {
			if (other.tabAutreInfAjoutPat != null)
				return false;
		} else if (!tabAutreInfAjoutPat.equals(other.tabAutreInfAjoutPat))
			return false;
		if (tabChirAnt != other.tabChirAnt)
			return false;
		if (tabCntctAjoutPat == null) {
			if (other.tabCntctAjoutPat != null)
				return false;
		} else if (!tabCntctAjoutPat.equals(other.tabCntctAjoutPat))
			return false;
		if (tabContraception == null) {
			if (other.tabContraception != null)
				return false;
		} else if (!tabContraception.equals(other.tabContraception))
			return false;
		if (tabFamAnt != other.tabFamAnt)
			return false;
		if (tabFerie != other.tabFerie)
			return false;
		if (tabGynecoObs == null) {
			if (other.tabGynecoObs != null)
				return false;
		} else if (!tabGynecoObs.equals(other.tabGynecoObs))
			return false;
		if (tabHistGross == null) {
			if (other.tabHistGross != null)
				return false;
		} else if (!tabHistGross.equals(other.tabHistGross))
			return false;
		if (tabInfGenAjoutPat == null) {
			if (other.tabInfGenAjoutPat != null)
				return false;
		} else if (!tabInfGenAjoutPat.equals(other.tabInfGenAjoutPat))
			return false;
		if (tabInfoConjAjoutPat == null) {
			if (other.tabInfoConjAjoutPat != null)
				return false;
		} else if (!tabInfoConjAjoutPat.equals(other.tabInfoConjAjoutPat))
			return false;
		if (tabJFerieExp != other.tabJFerieExp)
			return false;
		if (tabMedAnt != other.tabMedAnt)
			return false;
		if (trim1echoObs != other.trim1echoObs)
			return false;
		if (trim2echoObs != other.trim2echoObs)
			return false;
		if (trim3echoObs != other.trim3echoObs)
			return false;
		if (verConsult == null) {
			if (other.verConsult != null)
				return false;
		} else if (!verConsult.equals(other.verConsult))
			return false;
		if (verSal == null) {
			if (other.verSal != null)
				return false;
		} else if (!verSal.equals(other.verSal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Modelutl [idmodelUtl=" + idmodelUtl + ", nomModelUtl="
				+ nomModelUtl + ", menuSal=" + menuSal + ", menuGestPat="
				+ menuGestPat + ", menuParametre=" + menuParametre
				+ ", menuRapport=" + menuRapport + ", menuGestUtl="
				+ menuGestUtl + ", menuGestRdv=" + menuGestRdv
				+ ", menuGestStat=" + menuGestStat + ", ajoutPatient="
				+ ajoutPatient + ", verSal=" + verSal + ", modPatient="
				+ modPatient + ", detPatient=" + detPatient + ", chargPatient="
				+ chargPatient + ", supPatient=" + supPatient
				+ ", tabInfGenAjoutPat=" + tabInfGenAjoutPat
				+ ", tabCntctAjoutPat=" + tabCntctAjoutPat
				+ ", tabInfoConjAjoutPat=" + tabInfoConjAjoutPat
				+ ", tabAutreInfAjoutPat=" + tabAutreInfAjoutPat + ", gestDoc="
				+ gestDoc + ", gestProf=" + gestProf + ", gestVil=" + gestVil
				+ ", gestClin=" + gestClin + ", rappCertif=" + rappCertif
				+ ", rappOrdnce=" + rappOrdnce + ", rappLettre=" + rappLettre
				+ ", monterPatSal=" + monterPatSal + ", desdrePatSal="
				+ desdrePatSal + ", permutPatSal=" + permutPatSal
				+ ", premierPatSal=" + premierPatSal + ", dernierPatSal="
				+ dernierPatSal + ", supPatSal=" + supPatSal + ", chargPatSal="
				+ chargPatSal + ", supAnulSal=" + supAnulSal + ", ajoutDoc="
				+ ajoutDoc + ", modifDoc=" + modifDoc + ", supDoc=" + supDoc
				+ ", ajoutProf=" + ajoutProf + ", modifProf=" + modifProf
				+ ", supProf=" + supProf + ", ajoutVil=" + ajoutVil
				+ ", modifVil=" + modifVil + ", supVil=" + supVil
				+ ", ajoutClin=" + ajoutClin + ", modifClin=" + modifClin
				+ ", supClin=" + supClin + ", antecedent=" + antecedent
				+ ", echoGyn=" + echoGyn + ", echoObs=" + echoObs
				+ ", gynecologie=" + gynecologie + ", consultGros="
				+ consultGros + ", sterilite=" + sterilite + ", tabAntecedent="
				+ tabAntecedent + ", tabGynecoObs=" + tabGynecoObs
				+ ", tabHistGross=" + tabHistGross + ", tabContraception="
				+ tabContraception + ", supHistGross=" + supHistGross
				+ ", modifHistGross=" + modifHistGross + ", supConctraeption="
				+ supConctraeption + ", modifContraception="
				+ modifContraception + ", nouvGross=" + nouvGross
				+ ", nouvContraception=" + nouvContraception
				+ ", nouvConsGross=" + nouvConsGross + ", nouvConsGyn="
				+ nouvConsGyn + ", consultGrossOrd=" + consultGrossOrd
				+ ", consultGrossAnal=" + consultGrossAnal
				+ ", consultGrossRadio=" + consultGrossRadio + ", gynOrd="
				+ gynOrd + ", gynAnal=" + gynAnal + ", gynRadio=" + gynRadio
				+ ", menuConfig=" + menuConfig + ", nouvPatSal=" + nouvPatSal
				+ ", verConsult=" + verConsult + ", certifFiche=" + certifFiche
				+ ", gestionUterus=" + gestionUterus + ", lettreFiche="
				+ lettreFiche + ", analyseFiche=" + analyseFiche
				+ ", radioFiche=" + radioFiche + ", rapportFiche="
				+ rapportFiche + ", ordnanceFiche=" + ordnanceFiche
				+ ", gestBb=" + gestBb + ", gestAnal=" + gestAnal
				+ ", gestMed=" + gestMed + ", gestExm=" + gestExm
				+ ", gestMoyCtrcep=" + gestMoyCtrcep + ", gestDiag=" + gestDiag
				+ ", gestSyn=" + gestSyn + ", gestExmComp=" + gestExmComp
				+ ", gestEFG=" + gestEFG + ", nbrEnfentFiche=" + nbrEnfentFiche
				+ ", ordonanceLibreFiche=" + ordonanceLibreFiche
				+ ", selectTableConsultation=" + selectTableConsultation
				+ ", modifRadio=" + modifRadio + ", supRadio=" + supRadio
				+ ", modifOrdnce=" + modifOrdnce + ", supOrdnce=" + supOrdnce
				+ ", modifAnalyse=" + modifAnalyse + ", supAnalyse="
				+ supAnalyse + ", ajoutEtBb=" + ajoutEtBb + ", supEtBb="
				+ supEtBb + ", modifEtBb=" + modifEtBb + ", ajoutAnal="
				+ ajoutAnal + ", supAnal=" + supAnal + ", modifAnal="
				+ modifAnal + ", ajoutMed=" + ajoutMed + ", supMed=" + supMed
				+ ", modifMed=" + modifMed + ", ajoutExm=" + ajoutExm
				+ ", supExm=" + supExm + ", modifExm=" + modifExm
				+ ", ajoutMoyCtr=" + ajoutMoyCtr + ", supMoyCtr=" + supMoyCtr
				+ ", modifMoyCtr=" + modifMoyCtr + ", ajoutDiag=" + ajoutDiag
				+ ", supDiag=" + supDiag + ", modifDiag=" + modifDiag
				+ ", ajoutAsym=" + ajoutAsym + ", supAsym=" + supAsym
				+ ", modifAsym=" + modifAsym + ", ajoutExmComp=" + ajoutExmComp
				+ ", supExmComp=" + supExmComp + ", modifExmComp="
				+ modifExmComp + ", modifCsltGyn=" + modifCsltGyn
				+ ", ajoutUt=" + ajoutUt + ", modifUt=" + modifUt + ", supUt="
				+ supUt + ", ajoutFM=" + ajoutFM + ", modifFM=" + modifFM
				+ ", supFM=" + supFM + ", ajoutEFG=" + ajoutEFG + ", modifEFG="
				+ modifEFG + ", supEFG=" + supEFG + ", ajoutRdv=" + ajoutRdv
				+ ", modifRdv=" + modifRdv + ", selectAntecedent="
				+ selectAntecedent + ", ajoutAntecedentListe="
				+ ajoutAntecedentListe + ", nouvelleGrossesseAntecedent="
				+ nouvelleGrossesseAntecedent
				+ ", nouvelleContraceptionAntecedent="
				+ nouvelleContraceptionAntecedent + ", supRdv=" + supRdv
				+ ", consultPat=" + consultPat + ", modifCab=" + modifCab
				+ ", reponseSal=" + reponseSal + ", ModifGyneco=" + ModifGyneco
				+ ", imprGyneco=" + imprGyneco + ", SuppGyneco=" + SuppGyneco
				+ ", nouvchogyneco=" + nouvchogyneco + ", modifechogyneco="
				+ modifechogyneco + ", suppechogyneco=" + suppechogyneco
				+ ", ajoutmodelechogyneco=" + ajoutmodelechogyneco
				+ ", appliquemodelechogyneco=" + appliquemodelechogyneco
				+ ", suppmodelechogyneco=" + suppmodelechogyneco
				+ ", imprechogyneco=" + imprechogyneco + ", nouvechoObs="
				+ nouvechoObs + ", modifechoObs=" + modifechoObs
				+ ", suppechoObs=" + suppechoObs + ", trim1echoObs="
				+ trim1echoObs + ", trim2echoObs=" + trim2echoObs
				+ ", trim3echoObs=" + trim3echoObs + ", imprechoObs="
				+ imprechoObs + ", selectNouvGross=" + selectNouvGross
				+ ", modifGross=" + modifGross + ", suppGross=" + suppGross
				+ ", imprGross=" + imprGross + ", gestAntecedent="
				+ gestAntecedent + ", gestConsultation=" + gestConsultation
				+ ", modifCons=" + modifCons + ", gestHoraire=" + gestHoraire
				+ ", gestCabinet=" + gestCabinet + ", gestionJourFr="
				+ gestionJourFr + ", gestionFormMed=" + gestionFormMed
				+ ", tabFerie=" + tabFerie + ", tabJFerieExp=" + tabJFerieExp
				+ ", nouvJFerie=" + nouvJFerie + ", modifJFerie=" + modifJFerie
				+ ", suppJFerie=" + suppJFerie + ", modifJFerieExp="
				+ modifJFerieExp + ", suppJFerieExp=" + suppJFerieExp
				+ ", tabMedAnt=" + tabMedAnt + ", tabChirAnt=" + tabChirAnt
				+ ", tabFamAnt=" + tabFamAnt + ", modifGestAntMed="
				+ modifGestAntMed + ", suppGestAntMed=" + suppGestAntMed
				+ ", ajoutGestAntMed=" + ajoutGestAntMed
				+ ", suppGestAntChirg=" + suppGestAntChirg
				+ ", ajoutGestChirg=" + ajoutGestChirg + ", modifGestChirg="
				+ modifGestChirg + ", suppGestAntFam=" + suppGestAntFam
				+ ", ajoutGestFam=" + ajoutGestFam + ", modifGestFam="
				+ modifGestFam + ", nouvJFerieExp=" + nouvJFerieExp
				+ ", rechercheOrd=" + rechercheOrd + ", modifhistoOrd="
				+ modifhistoOrd + ", supphistoOrd=" + supphistoOrd
				+ ", selectModeleord=" + selectModeleord + ", ajoutModeleord="
				+ ajoutModeleord + ", suppModeleOrd=" + suppModeleOrd
				+ ", imprOrd=" + imprOrd + ", suppOrd=" + suppOrd
				+ ", nouvCertif=" + nouvCertif + ", modifCertif=" + modifCertif
				+ ", suppCertif=" + suppCertif + ", imprCertif=" + imprCertif
				+ ", nouvLettre=" + nouvLettre + ", modifLettre=" + modifLettre
				+ ", suppLettre=" + suppLettre + ", imprLettre=" + imprLettre
				+ ", modifSterilite=" + modifSterilite + ", reglageHoraire="
				+ reglageHoraire + ", gestCertif=" + gestCertif
				+ ", gestLettre=" + gestLettre + ", modifPrtSais="
				+ modifPrtSais + ", ajoutHeurTrav=" + ajoutHeurTrav
				+ ", modifHeurTrav=" + modifHeurTrav + ", supHeurTrav="
				+ supHeurTrav + ", gestSais=" + gestSais + ", donnerRdv="
				+ donnerRdv + ", imprmAnal=" + imprmAnal + ", imprRadio="
				+ imprRadio + ", consultDetAnal=" + consultDetAnal
				+ ", consultDetRad=" + consultDetRad + ", consultDetOrd="
				+ consultDetOrd + ", detHistoAnal=" + detHistoAnal
				+ ", detHistoRad=" + detHistoRad + ", consultArchiv="
				+ consultArchiv + ", archiverPat=" + archiverPat
				+ ", tabAnulSal=" + tabAnulSal + ", anulSal=" + anulSal
				+ ", modifNoteSal=" + modifNoteSal + ", modifAnt=" + modifAnt
				+ ", suppAnt=" + suppAnt + ", modifGynObs=" + modifGynObs
				+ ", ajoutDemandeOrd=" + ajoutDemandeOrd + ", ajoutDemandeRad="
				+ ajoutDemandeRad + ", ajoutDemandeAnal=" + ajoutDemandeAnal
				+ ", affectEtoile=" + affectEtoile + ", confSession="
				+ confSession + "]";
	}
	public boolean isConfSession() {
		return confSession;
	}
	public void setConfSession(boolean confSession) {
		this.confSession = confSession;
	}

	
	

}
