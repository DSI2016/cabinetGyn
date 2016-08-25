package com.doctor.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Modelutl;
import com.doctor.persistance.Utilisateur;
import com.doctor.service.ModelutlService;
import com.doctor.service.UtilisateurService;

@ManagedBean(name = "utilisateurBean")
@SessionScoped
public class UtilisateurBean implements java.io.Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private int index = 0;
	
	private Integer idUtilisateur;
	private String login;
	private String motPasse;
	private String nom;
	private String prenom;
	private String date_naiss;
	private String adresse;
	private String tel;
	private String email;
	private String civil;
	private Date dateNais;

	private String gestExmComp;
	private boolean ajoutExmComp;
	private boolean modifExmComp;
	private boolean supExmComp;

	private String gestSym;
	private boolean ajoutSym;
	private boolean modifSym;
	private boolean supSym;

	private String gestDiag;
	private boolean ajoutDiag;
	private boolean modifDiag;
	private boolean supDiag;

	private String gestMoyCtr;
	private boolean ajoutMoyCtr;
	private boolean modifMoyCtr;
	private boolean supMoyCtr;

	private String gestExm;
	private boolean ajoutExm;
	private boolean modifExm;
	private boolean supExm;

	private String gestMed;
	private boolean ajoutMed;
	private boolean modifMed;
	private boolean supMed;

	private String gestAnal;
	private boolean ajoutAnal;
	private boolean modifAnal;
	private boolean supAnal;

	private String gestEtbb;
	private boolean ajoutEtbb;
	private boolean modifEtbb;
	private boolean supEtbb;
	
	private boolean gestFrmMedPriv;
	private boolean ajoutFrmMedPriv;
	private boolean modifFrmMedPriv;
	private boolean supFrmMedPriv;
	
	private boolean gestConsPriv;
	private boolean modifConsPriv;

	private String menuSal;
	private String menuGestPat;
	private String menuParametre;
	private String menuRapport;
	private String menuGestUtl;
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
	private String gynRadio;
	private String gynOrd;
	private String gynAnal;
	private String nouvConsGyn;
	private String grossAnal;
	private String grossRadio;
	private String grossOrd;
	private String grossNouvCons;
	private String nouvPatSal;
	private String verConsult;
	private String motpass1;
	private String motpass2;

	private String certifFiche;
	private String lettreFiche;
	private String analyseFiche;
	private String radioFiche;
	private String rapportFiche;
	private String ordnanceFiche;

	
	private boolean verConsultPriv;
	private boolean menuSalPriv;
	private boolean menuGesPatPriv;
	private boolean menuParamPriv;
	private boolean menuRappPriv;
	private boolean menuStatPriv;
	private boolean menuGesUtlPriv;
	private boolean menuRendvousPriv;
	private boolean ajouPatPriv;
	private boolean verSalPriv;
	private boolean modifPatPriv;
	private boolean detPatPriv;
	private boolean chargPatPriv;
	private boolean suppPatPriv;
	private boolean tabInfGnrAjtPatPriv;
	
	private boolean tabContctPatPriv;
	private boolean tabInfoConjAjtPatPriv;
	private boolean tabAtreInfAjtPatPriv;
	private boolean gestDocPriv;
	private boolean gestAntecedentParamPriv;
	
	private boolean paramtabAntMedPriv;
	private boolean supAntMedPriv;
	private boolean ajoutAntMedPriv;
	private boolean modifAntMedPriv;
	private boolean paramtabAntChirgPriv;
	private boolean ajoutAntChirgPriv;
	private boolean modifAntChirgPriv;
	private boolean supAntChirgPriv;
	
	private boolean paramtabAntFamPriv;
	private boolean ajoutAntFamPriv;
	private boolean modifAntFamPriv;
	private boolean supAntFamPriv;
	
	private boolean gestFinGrossPriv;
	private boolean ajoutFinGrossPriv;
	private boolean modifFinGrossPriv;
	private boolean supFinGrossPriv;
	
	private boolean gestUtPriv;
	private boolean ajoutUtPriv;
	private boolean modifUtPriv;
	private boolean supUtPriv;
	
	private boolean gestHorairePriv;
	private boolean gestCabinetPriv;
	
	private boolean modifprdSaisPriv;
	private boolean ajoutHorTravPriv;
	private boolean modifHorTravPriv;
	private boolean supHorTravPriv;
	
	private boolean gestProfPriv;
	private boolean gestVilPriv;
	private boolean gestCliPriv;
	private boolean rappCertifPriv;
	private boolean rappOrdncePriv;
	private boolean rappLettrePriv;
	private boolean montPatSalPriv;
	private boolean descdrePatSalPriv;
	private boolean permutPatSalPriv;
	private boolean premierPatSalPriv;
	private boolean dernierSalPriv;
	private boolean supPatSalPriv;
	private boolean chargPatSalPriv;
	private boolean reponseSalPriv;
	private boolean modifNoteSalPriv;
	private boolean tabAnulSalPriv;
	private boolean anulSalPriv;
	private boolean ajoutDocPriv;
	private boolean modifDocPriv;
	private boolean supDocPriv;
	private boolean ajoutProfPriv;
	private boolean modifProfPriv;
	private boolean supProfPriv;
	private boolean ajoutVilPriv;
	private boolean modifVilPriv;
	private boolean supVilPriv;
	private boolean ajoutClinPriv;
	private boolean modifClinPriv;
	private boolean supClinPriv;
	
	private boolean gestJrFerParamPriv;
	private boolean paramtabJrFerPriv;
	private boolean ajouJrFerStndPriv;
	private boolean modifJrFerStndPriv;
	private boolean supJrFerStndPriv;
	private boolean paramtabJrFerExpPriv;
	private boolean ajouJrFerExpPriv;
	private boolean modifJrFerExpPriv;
	private boolean supJrFerExpPriv;

	private boolean gestExmCompPriv;
	private boolean ajoutExmCompPriv;
	private boolean modifExmCompPriv;
	private boolean supExmCompPriv;

	private boolean gestSymPriv;
	private boolean ajoutSymPriv;
	private boolean modifSymPriv;
	private boolean supSymPriv;

	private boolean gestEtBbPriv;
	private boolean ajoutEtBbPriv;
	private boolean modifEtBbPriv;
	private boolean supEtBbPriv;

	private boolean gestAnalPriv;
	private boolean ajoutAnalPriv;
	private boolean modifAnalPriv;
	private boolean supAnalPriv;

	private boolean gestMedPriv;
	private boolean ajoutMedPriv;
	private boolean modifMedPriv;
	private boolean supMedPriv;

	private boolean gestExmPriv;
	private boolean ajoutExmPriv;
	private boolean modifExmPriv;
	private boolean supExmPriv;

	private boolean gestMoyCtrPriv;
	private boolean ajoutMoyCtrPriv;
	private boolean modifMoyCtrPriv;
	private boolean supMoyCtrPriv;

	private boolean gestDiagPriv;
	private boolean ajoutDiagPriv;
	private boolean modifDiagPriv;
	private boolean supDiagPriv;

	private boolean antecedentPriv;
	private boolean echoGynPriv;
	private boolean echoGynsupConsultPriv;
	private boolean echoGynNouvConsultPriv;
	private boolean echoGynModifConsultPriv;
	private boolean echoGynNouvModeltPriv;
	private boolean echoGynSupModeltPriv;
	private boolean echoGynApplModeltPriv;
	private boolean echoGynImprPriv;
	private boolean echoObstPriv;
	private boolean echoObsNouvConsultPriv;
	private boolean echoObsModifConsultPriv;
	private boolean echoObsSupConsultPriv;
	private boolean echoObsTrim1Priv;
	private boolean echoObsTrim2Priv;
	private boolean echoObsTrim3Priv;
	private boolean echoObsImprPriv;
	private boolean gynecologiePriv;
	private boolean consultGrossPriv;
	private boolean grossSelectNouvConsultPriv;
	private boolean sterilitePriv;
	private boolean steriliteModifPriv;
	private boolean tabAntecedentPriv;
	private boolean modifAntPriv;
	private boolean suppAntPriv;
	private boolean modifGynObsPriv;
	
	private boolean tabGynecoObsPriv;
	private boolean tabHistGrossPriv;
	private boolean tabContracepPriv;
	private boolean nouvGrossPriv;
	private boolean nouvContracepPriv;
	private boolean modifHistGrossPriv;
	private boolean supHistGrossPriv;
	private boolean modifContracepPriv;
	private boolean supContacepPriv;
	private boolean gynRadioPriv;
	private boolean gynAnaPriv;
	private boolean gynOrdPriv;
	
	private boolean consultDetAnalPriv;
	private boolean consultDetRadPriv;
	private boolean consultDetOrdPriv;
	
	private boolean gynNouvConsultPriv;
	private boolean gynModifConsultPriv;
	private boolean gynSupConsultPriv;
	private boolean gynImprConsultPriv;
	private boolean grossRadioPriv;
	private boolean grossModifConsultPriv;
	private boolean grossSupvConsultPriv;
	private boolean grossImprConsultPriv;
	private boolean grossAnaPriv;
	private boolean grossOrdPriv;
	private boolean grossNouvConsultPriv;
	private boolean certifFichePriv;
	private boolean ajoutCertifPriv;
	private boolean modifCertifPriv;
	private boolean supCertifPriv;
	private boolean impCertifPriv;
	
	
	private boolean lettreFichePriv;
	private boolean ajoutLtrPriv;
	private boolean modifLtrPriv;
	private boolean supLtrPriv;
	private boolean impLtrPriv;
	
	private boolean analyseFichePriv;
	private boolean modifHistoAnalPriv;
	private boolean consultHistoAnalPriv;
	private  boolean supHistoAnalPriv;
	
	private boolean rapportFichePriv;
	
	private boolean radioFichePriv;
	private boolean modifHistoRadPriv;
	private boolean consultHistoRadPriv;
	private boolean supHistoRadPriv;
	
	private boolean ordonceFichePriv;
	private boolean consultOrdLibrePriv;
	private boolean modifHistoOrdPriv;
	private boolean supHistoOrdPriv;
	private boolean rechercheOrdPriv;
	private boolean imprOrdPriv;
	
	private boolean ordonceLbreFichePriv;
	private boolean ajoutModeleordPriv;
	private boolean selectModeleordPriv;
	private boolean suppModeleOrdPriv;
	
    
	private boolean consultertHistoConsultationPriv;
	
	private boolean ttcochDecochGen;

	private boolean gestSaisPriv;
	
	private boolean donnerRdvPriv;
	private boolean archiverPatPriv;
	private boolean consultArchivePriv;
	
	private boolean imprAnalPriv;
	private boolean imprRadioPriv;
	
	
	

	private Integer idmodelUtl;
	private String nomModelUtl;
	private boolean applique;
	private boolean nvelMdl;
	private List<Modelutl> modeleUtls = new ArrayList<Modelutl>();

	
	private boolean consultAnalActiv=true;
	
	
	public String getNouvPatSal() {
		return nouvPatSal;
	}

	public void setNouvPatSal(String nouvPatSal) {
		this.nouvPatSal = nouvPatSal;
	}

	public boolean isNvelMdl() {
		return nvelMdl;
	}

	public void setNvelMdl(boolean nvelMdl) {
		this.nvelMdl = nvelMdl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isArchiverPatPriv() {
		return archiverPatPriv;
	}

	public void setArchiverPatPriv(boolean archiverPatPriv) {
		this.archiverPatPriv = archiverPatPriv;
	}

	public boolean isConsultArchivePriv() {
		return consultArchivePriv;
	}

	public void setConsultArchivePriv(boolean consultArchivePriv) {
		this.consultArchivePriv = consultArchivePriv;
	}

	public boolean isTabAnulSalPriv() {
		return tabAnulSalPriv;
	}

	public void setTabAnulSalPriv(boolean tabAnulSalPriv) {
		this.tabAnulSalPriv = tabAnulSalPriv;
	}

	public boolean isAnulSalPriv() {
		return anulSalPriv;
	}

	public void setAnulSalPriv(boolean anulSalPriv) {
		this.anulSalPriv = anulSalPriv;
	}

	public boolean isReponseSalPriv() {
		return reponseSalPriv;
	}

	public void setReponseSalPriv(boolean reponseSalPriv) {
		this.reponseSalPriv = reponseSalPriv;
	}

	public boolean isModifNoteSalPriv() {
		return modifNoteSalPriv;
	}

	public void setModifNoteSalPriv(boolean modifNoteSalPriv) {
		this.modifNoteSalPriv = modifNoteSalPriv;
	}

	public boolean isConsultHistoRadPriv() {
		return consultHistoRadPriv;
	}

	public void setConsultHistoRadPriv(boolean consultHistoRadPriv) {
		this.consultHistoRadPriv = consultHistoRadPriv;
	}

	public boolean isConsultHistoAnalPriv() {
		return consultHistoAnalPriv;
	}

	public void setConsultHistoAnalPriv(boolean consultHistoAnalPriv) {
		this.consultHistoAnalPriv = consultHistoAnalPriv;
	}

	public boolean isConsultDetRadPriv() {
		return consultDetRadPriv;
	}

	public void setConsultDetRadPriv(boolean consultDetRadPriv) {
		this.consultDetRadPriv = consultDetRadPriv;
	}

	public boolean isConsultDetOrdPriv() {
		return consultDetOrdPriv;
	}

	public void setConsultDetOrdPriv(boolean consultDetOrdPriv) {
		this.consultDetOrdPriv = consultDetOrdPriv;
	}

	public boolean isConsultAnalActiv() {
		return consultAnalActiv;
	}

	public void setConsultAnalActiv(boolean consultAnalActiv) {
		this.consultAnalActiv = consultAnalActiv;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isImprAnalPriv() {
		return imprAnalPriv;
	}

	public void setImprAnalPriv(boolean imprAnalPriv) {
		this.imprAnalPriv = imprAnalPriv;
	}

	public boolean isImprRadioPriv() {
		return imprRadioPriv;
	}

	public void setImprRadioPriv(boolean imprRadioPriv) {
		this.imprRadioPriv = imprRadioPriv;
	}

	public boolean isDonnerRdvPriv() {
		return donnerRdvPriv;
	}

	public void setDonnerRdvPriv(boolean donnerRdvPriv) {
		this.donnerRdvPriv = donnerRdvPriv;
	}

	public boolean isGestSaisPriv() {
		return gestSaisPriv;
	}

	public void setGestSaisPriv(boolean gestSaisPriv) {
		this.gestSaisPriv = gestSaisPriv;
	}
	
	
	public boolean isModifprdSaisPriv() {
		return modifprdSaisPriv;
	}

	public void setModifprdSaisPriv(boolean modifprdSaisPriv) {
		this.modifprdSaisPriv = modifprdSaisPriv;
	}

	public boolean isAjoutHorTravPriv() {
		return ajoutHorTravPriv;
	}

	public void setAjoutHorTravPriv(boolean ajoutHorTravPriv) {
		this.ajoutHorTravPriv = ajoutHorTravPriv;
	}

	public boolean isModifHorTravPriv() {
		return modifHorTravPriv;
	}

	public void setModifHorTravPriv(boolean modifHorTravPriv) {
		this.modifHorTravPriv = modifHorTravPriv;
	}

	public boolean isSupHorTravPriv() {
		return supHorTravPriv;
	}

	public void setSupHorTravPriv(boolean supHorTravPriv) {
		this.supHorTravPriv = supHorTravPriv;
	}

	public boolean isConsultertHistoConsultationPriv() {
		return consultertHistoConsultationPriv;
	}

	public void setConsultertHistoConsultationPriv(
			boolean consultertHistoConsultationPriv) {
		this.consultertHistoConsultationPriv = consultertHistoConsultationPriv;
	}

	public String getNomModelUtl() {
		return nomModelUtl;
	}

	public void setNomModelUtl(String nomModelUtl) {
		this.nomModelUtl = nomModelUtl;
	}

	public List<Modelutl> getModeleUtls() {
		
		ModelutlService mdluSer= new ModelutlService();
		modeleUtls= mdluSer.rechercheTousModelutl();
		return modeleUtls;
	}

	public void setModeleUtls(List<Modelutl> modeleUtls) {
		this.modeleUtls = modeleUtls;
	}

	public boolean isApplique() {
		ModelutlService mdluSer= new ModelutlService();
		modeleUtls= mdluSer.rechercheTousModelutl();
		
		if (idmodelUtl != null)
			applique = false;
		else
			applique = true;
		
		if(modeleUtls.size()==0)
			applique = true;
		
		return applique;
	}

	public void setApplique(boolean applique) {
		this.applique = applique;
	}

	public Integer getIdmodelUtl() {
		return idmodelUtl;
	}

	public void setIdmodelUtl(Integer idmodelUtl) {
		this.idmodelUtl = idmodelUtl;
	}

	public boolean isMenuRendvousPriv() {
		return menuRendvousPriv;
	}

	public void setMenuRendvousPriv(boolean menuRendvousPriv) {
		this.menuRendvousPriv = menuRendvousPriv;
	}

	public boolean isOrdonceLbreFichePriv() {
		return ordonceLbreFichePriv;
	}

	public void setOrdonceLbreFichePriv(boolean ordonceLbreFichePriv) {
		this.ordonceLbreFichePriv = ordonceLbreFichePriv;
	}

	public boolean isAjoutModeleordPriv() {
		return ajoutModeleordPriv;
	}

	public void setAjoutModeleordPriv(boolean ajoutModeleordPriv) {
		this.ajoutModeleordPriv = ajoutModeleordPriv;
	}

	public boolean isSelectModeleordPriv() {
		return selectModeleordPriv;
	}

	public void setSelectModeleordPriv(boolean selectModeleordPriv) {
		this.selectModeleordPriv = selectModeleordPriv;
	}

	public boolean isSuppModeleOrdPriv() {
		return suppModeleOrdPriv;
	}

	public void setSuppModeleOrdPriv(boolean suppModeleOrdPriv) {
		this.suppModeleOrdPriv = suppModeleOrdPriv;
	}

	

	

	public boolean isConsultOrdLibrePriv() {
		
		return consultOrdLibrePriv;
	}

	public void setConsultOrdLibrePriv(boolean consultOrdLibrePriv) {
		this.consultOrdLibrePriv = consultOrdLibrePriv;
	}

	public boolean isModifHistoOrdPriv() {
		return modifHistoOrdPriv;
	}

	public void setModifHistoOrdPriv(boolean modifHistoOrdPriv) {
		this.modifHistoOrdPriv = modifHistoOrdPriv;
	}

	public boolean isSupHistoOrdPriv() {
		return supHistoOrdPriv;
	}

	public void setSupHistoOrdPriv(boolean supHistoOrdPriv) {
		this.supHistoOrdPriv = supHistoOrdPriv;
	}

	public boolean isRechercheOrdPriv() {
		return rechercheOrdPriv;
	}

	public void setRechercheOrdPriv(boolean rechercheOrdPriv) {
		this.rechercheOrdPriv = rechercheOrdPriv;
	}

	public boolean isImprOrdPriv() {
		return imprOrdPriv;
	}

	public void setImprOrdPriv(boolean imprOrdPriv) {
		this.imprOrdPriv = imprOrdPriv;
	}

	public boolean isModifHistoRadPriv() {
		return modifHistoRadPriv;
	}

	public void setModifHistoRadPriv(boolean modifHistoRadPriv) {
		this.modifHistoRadPriv = modifHistoRadPriv;
	}

	public boolean isSupHistoRadPriv() {
		return supHistoRadPriv;
	}

	public void setSupHistoRadPriv(boolean supHistoRadPriv) {
		this.supHistoRadPriv = supHistoRadPriv;
	}

	public boolean isModifHistoAnalPriv() {
		return modifHistoAnalPriv;
	}

	public void setModifHistoAnalPriv(boolean modifHistoAnalPriv) {
		this.modifHistoAnalPriv = modifHistoAnalPriv;
	}

	public boolean isSupHistoAnalPriv() {
		return supHistoAnalPriv;
	}

	public void setSupHistoAnalPriv(boolean supHistoAnalPriv) {
		this.supHistoAnalPriv = supHistoAnalPriv;
	}

	public boolean isImpCertifPriv() {
		return impCertifPriv;
	}

	public void setImpCertifPriv(boolean impCertifPriv) {
		this.impCertifPriv = impCertifPriv;
	}

	public boolean isAjoutLtrPriv() {
		return ajoutLtrPriv;
	}

	public void setAjoutLtrPriv(boolean ajoutLtrPriv) {
		this.ajoutLtrPriv = ajoutLtrPriv;
	}

	public boolean isModifLtrPriv() {
		return modifLtrPriv;
	}

	public void setModifLtrPriv(boolean modifLtrPriv) {
		this.modifLtrPriv = modifLtrPriv;
	}

	public boolean isSupLtrPriv() {
		return supLtrPriv;
	}

	public void setSupLtrPriv(boolean supLtrPriv) {
		this.supLtrPriv = supLtrPriv;
	}

	public boolean isImpLtrPriv() {
		return impLtrPriv;
	}

	public void setImpLtrPriv(boolean impLtrPriv) {
		this.impLtrPriv = impLtrPriv;
	}

	public boolean isAjoutCertifPriv() {
		return ajoutCertifPriv;
	}

	public void setAjoutCertifPriv(boolean ajoutCertifPriv) {
		this.ajoutCertifPriv = ajoutCertifPriv;
	}

	public boolean isModifCertifPriv() {
		return modifCertifPriv;
	}

	public void setModifCertifPriv(boolean modifCertifPriv) {
		this.modifCertifPriv = modifCertifPriv;
	}

	public boolean isSupCertifPriv() {
		return supCertifPriv;
	}

	public void setSupCertifPriv(boolean supCertifPriv) {
		this.supCertifPriv = supCertifPriv;
	}

	public boolean isGestFinGrossPriv() {
		return gestFinGrossPriv;
	}

	public void setGestFinGrossPriv(boolean gestFinGrossPriv) {
		this.gestFinGrossPriv = gestFinGrossPriv;
	}

	public boolean isAjoutFinGrossPriv() {
		return ajoutFinGrossPriv;
	}

	public void setAjoutFinGrossPriv(boolean ajoutFinGrossPriv) {
		this.ajoutFinGrossPriv = ajoutFinGrossPriv;
	}

	public boolean isModifFinGrossPriv() {
		return modifFinGrossPriv;
	}

	public void setModifFinGrossPriv(boolean modifFinGrossPriv) {
		this.modifFinGrossPriv = modifFinGrossPriv;
	}

	public boolean isSupFinGrossPriv() {
		return supFinGrossPriv;
	}

	public void setSupFinGrossPriv(boolean supFinGrossPriv) {
		this.supFinGrossPriv = supFinGrossPriv;
	}

	public boolean isGestCabinetPriv() {
		return gestCabinetPriv;
	}

	public void setGestCabinetPriv(boolean gestCabinetPriv) {
		this.gestCabinetPriv = gestCabinetPriv;
	}

	public boolean isGestHorairePriv() {
		return gestHorairePriv;
	}

	public void setGestHorairePriv(boolean gestHorairePriv) {
		this.gestHorairePriv = gestHorairePriv;
	}
	

	public boolean isGestConsPriv() {
		return gestConsPriv;
	}

	public void setGestConsPriv(boolean gestConsPriv) {
		this.gestConsPriv = gestConsPriv;
	}

	public boolean isModifConsPriv() {
		return modifConsPriv;
	}

	public void setModifConsPriv(boolean modifConsPriv) {
		this.modifConsPriv = modifConsPriv;
	}

	public boolean isGestFrmMedPriv() {
		return gestFrmMedPriv;
	}

	public void setGestFrmMedPriv(boolean gestFrmMedPriv) {
		this.gestFrmMedPriv = gestFrmMedPriv;
	}

	public boolean isAjoutFrmMedPriv() {
		return ajoutFrmMedPriv;
	}

	public void setAjoutFrmMedPriv(boolean ajoutFrmMedPriv) {
		this.ajoutFrmMedPriv = ajoutFrmMedPriv;
	}

	public boolean isModifFrmMedPriv() {
		return modifFrmMedPriv;
	}

	public void setModifFrmMedPriv(boolean modifFrmMedPriv) {
		this.modifFrmMedPriv = modifFrmMedPriv;
	}

	public boolean isSupFrmMedPriv() {
		return supFrmMedPriv;
	}

	public void setSupFrmMedPriv(boolean supFrmMedPriv) {
		this.supFrmMedPriv = supFrmMedPriv;
	}

	public boolean isParamtabJrFerExpPriv() {
		return paramtabJrFerExpPriv;
	}

	public void setParamtabJrFerExpPriv(boolean paramtabJrFerExpPriv) {
		this.paramtabJrFerExpPriv = paramtabJrFerExpPriv;
	}

	public boolean isAjouJrFerExpPriv() {
		return ajouJrFerExpPriv;
	}

	public void setAjouJrFerExpPriv(boolean ajouJrFerExpPriv) {
		this.ajouJrFerExpPriv = ajouJrFerExpPriv;
	}

	public boolean isModifJrFerExpPriv() {
		return modifJrFerExpPriv;
	}

	public void setModifJrFerExpPriv(boolean modifJrFerExpPriv) {
		this.modifJrFerExpPriv = modifJrFerExpPriv;
	}

	public boolean isSupJrFerExpPriv() {
		return supJrFerExpPriv;
	}

	public void setSupJrFerExpPriv(boolean supJrFerExpPriv) {
		this.supJrFerExpPriv = supJrFerExpPriv;
	}

	public boolean isAjouJrFerStndPriv() {
		return ajouJrFerStndPriv;
	}

	public void setAjouJrFerStndPriv(boolean ajouJrFerStndPriv) {
		this.ajouJrFerStndPriv = ajouJrFerStndPriv;
	}

	public boolean isGestJrFerParamPriv() {
		return gestJrFerParamPriv;
	}

	public void setGestJrFerParamPriv(boolean gestJrFerParamPriv) {
		this.gestJrFerParamPriv = gestJrFerParamPriv;
	}

	public boolean isParamtabJrFerPriv() {
		return paramtabJrFerPriv;
	}

	public void setParamtabJrFerPriv(boolean paramtabJrFerPriv) {
		this.paramtabJrFerPriv = paramtabJrFerPriv;
	}

	public boolean isModifJrFerStndPriv() {
		return modifJrFerStndPriv;
	}

	public void setModifJrFerStndPriv(boolean modifJrFerStndPriv) {
		this.modifJrFerStndPriv = modifJrFerStndPriv;
	}

	public boolean isSupJrFerStndPriv() {
		return supJrFerStndPriv;
	}

	public void setSupJrFerStndPriv(boolean supJrFerStndPriv) {
		this.supJrFerStndPriv = supJrFerStndPriv;
	}

	public boolean isParamtabAntFamPriv() {
		return paramtabAntFamPriv;
	}

	public void setParamtabAntFamPriv(boolean paramtabAntFamPriv) {
		this.paramtabAntFamPriv = paramtabAntFamPriv;
	}

	public boolean isAjoutAntFamPriv() {
		return ajoutAntFamPriv;
	}

	public void setAjoutAntFamPriv(boolean ajoutAntFamPriv) {
		this.ajoutAntFamPriv = ajoutAntFamPriv;
	}

	public boolean isModifAntFamPriv() {
		return modifAntFamPriv;
	}

	public void setModifAntFamPriv(boolean modifAntFamPriv) {
		this.modifAntFamPriv = modifAntFamPriv;
	}

	public boolean isSupAntFamPriv() {
		return supAntFamPriv;
	}

	public void setSupAntFamPriv(boolean supAntFamPriv) {
		this.supAntFamPriv = supAntFamPriv;
	}

	public boolean isParamtabAntChirgPriv() {
		return paramtabAntChirgPriv;
	}

	public void setParamtabAntChirgPriv(boolean paramtabAntChirgPriv) {
		this.paramtabAntChirgPriv = paramtabAntChirgPriv;
	}

	public boolean isAjoutAntChirgPriv() {
		return ajoutAntChirgPriv;
	}

	public void setAjoutAntChirgPriv(boolean ajoutAntChirgPriv) {
		this.ajoutAntChirgPriv = ajoutAntChirgPriv;
	}

	public boolean isModifAntChirgPriv() {
		return modifAntChirgPriv;
	}

	public void setModifAntChirgPriv(boolean modifAntChirgPriv) {
		this.modifAntChirgPriv = modifAntChirgPriv;
	}

	public boolean isSupAntChirgPriv() {
		return supAntChirgPriv;
	}

	public void setSupAntChirgPriv(boolean supAntChirgPriv) {
		this.supAntChirgPriv = supAntChirgPriv;
	}

	public boolean isParamtabAntMedPriv() {
		return paramtabAntMedPriv;
	}

	public void setParamtabAntMedPriv(boolean paramtabAntMedPriv) {
		this.paramtabAntMedPriv = paramtabAntMedPriv;
	}

	public boolean isSupAntMedPriv() {
		return supAntMedPriv;
	}

	public void setSupAntMedPriv(boolean supAntMedPriv) {
		this.supAntMedPriv = supAntMedPriv;
	}

	public boolean isAjoutAntMedPriv() {
		return ajoutAntMedPriv;
	}

	public void setAjoutAntMedPriv(boolean ajoutAntMedPriv) {
		this.ajoutAntMedPriv = ajoutAntMedPriv;
	}

	public boolean isModifAntMedPriv() {
		return modifAntMedPriv;
	}

	public void setModifAntMedPriv(boolean modifAntMedPriv) {
		this.modifAntMedPriv = modifAntMedPriv;
	}

	public boolean isGestAntecedentParamPriv() {
		return gestAntecedentParamPriv;
	}

	public void setGestAntecedentParamPriv(boolean gestAntecedentParamPriv) {
		this.gestAntecedentParamPriv = gestAntecedentParamPriv;
	}

	public boolean isAjoutUtPriv() {
		return ajoutUtPriv;
	}

	public void setAjoutUtPriv(boolean ajoutUtPriv) {
		this.ajoutUtPriv = ajoutUtPriv;
	}

	public boolean isModifUtPriv() {
		return modifUtPriv;
	}

	public void setModifUtPriv(boolean modifUtPriv) {
		this.modifUtPriv = modifUtPriv;
	}

	public boolean isSupUtPriv() {
		return supUtPriv;
	}

	public void setSupUtPriv(boolean supUtPriv) {
		this.supUtPriv = supUtPriv;
	}
	
	

	public boolean isGestUtPriv() {
		return gestUtPriv;
	}

	public void setGestUtPriv(boolean gestUtPriv) {
		this.gestUtPriv = gestUtPriv;
	}

	public boolean isSteriliteModifPriv() {
		return steriliteModifPriv;
	}

	public void setSteriliteModifPriv(boolean steriliteModifPriv) {
		this.steriliteModifPriv = steriliteModifPriv;
	}

	public boolean isGrossImprConsultPriv() {
		return grossImprConsultPriv;
	}

	public void setGrossImprConsultPriv(boolean grossImprConsultPriv) {
		this.grossImprConsultPriv = grossImprConsultPriv;
	}

	public boolean isGrossSupvConsultPriv() {
		return grossSupvConsultPriv;
	}

	public void setGrossSupvConsultPriv(boolean grossSupvConsultPriv) {
		this.grossSupvConsultPriv = grossSupvConsultPriv;
	}

	public boolean isGrossModifConsultPriv() {
		return grossModifConsultPriv;
	}

	public void setGrossModifConsultPriv(boolean grossModifConsultPriv) {
		this.grossModifConsultPriv = grossModifConsultPriv;
	}

	public boolean isGrossSelectNouvConsultPriv() {
		return grossSelectNouvConsultPriv;
	}

	public void setGrossSelectNouvConsultPriv(boolean grossSelectNouvConsultPriv) {
		this.grossSelectNouvConsultPriv = grossSelectNouvConsultPriv;
	}

	public boolean isEchoObsImprPriv() {
		return echoObsImprPriv;
	}

	public void setEchoObsImprPriv(boolean echoObsImprPriv) {
		this.echoObsImprPriv = echoObsImprPriv;
	}

	public boolean isEchoObsTrim3Priv() {
		return echoObsTrim3Priv;
	}

	public void setEchoObsTrim3Priv(boolean echoObsTrim3Priv) {
		this.echoObsTrim3Priv = echoObsTrim3Priv;
	}

	public boolean isEchoObsTrim2Priv() {
		return echoObsTrim2Priv;
	}

	public void setEchoObsTrim2Priv(boolean echoObsTrim2Priv) {
		this.echoObsTrim2Priv = echoObsTrim2Priv;
	}

	public boolean isEchoObsTrim1Priv() {
		return echoObsTrim1Priv;
	}

	public void setEchoObsTrim1Priv(boolean echoObsTrim1Priv) {
		this.echoObsTrim1Priv = echoObsTrim1Priv;
	}

	public boolean isEchoObsSupConsultPriv() {
		return echoObsSupConsultPriv;
	}

	public void setEchoObsSupConsultPriv(boolean echoObsSupConsultPriv) {
		this.echoObsSupConsultPriv = echoObsSupConsultPriv;
	}

	public boolean isEchoObsModifConsultPriv() {
		return echoObsModifConsultPriv;
	}

	public void setEchoObsModifConsultPriv(boolean echoObsModifConsultPriv) {
		this.echoObsModifConsultPriv = echoObsModifConsultPriv;
	}

	public boolean isEchoObsNouvConsultPriv() {
		return echoObsNouvConsultPriv;
	}

	public void setEchoObsNouvConsultPriv(boolean echoObsNouvConsultPriv) {
		this.echoObsNouvConsultPriv = echoObsNouvConsultPriv;
	}

	public boolean isEchoGynImprPriv() {
		return echoGynImprPriv;
	}

	public void setEchoGynImprPriv(boolean echoGynImprPriv) {
		this.echoGynImprPriv = echoGynImprPriv;
	}

	public boolean isEchoGynApplModeltPriv() {
		return echoGynApplModeltPriv;
	}

	public void setEchoGynApplModeltPriv(boolean echoGynApplModeltPriv) {
		this.echoGynApplModeltPriv = echoGynApplModeltPriv;
	}

	public boolean isEchoGynSupModeltPriv() {
		return echoGynSupModeltPriv;
	}

	public void setEchoGynSupModeltPriv(boolean echoGynSupModeltPriv) {
		this.echoGynSupModeltPriv = echoGynSupModeltPriv;
	}

	public boolean isEchoGynNouvModeltPriv() {
		return echoGynNouvModeltPriv;
	}

	public void setEchoGynNouvModeltPriv(boolean echoGynNouvModeltPriv) {
		this.echoGynNouvModeltPriv = echoGynNouvModeltPriv;
	}

	public boolean isEchoGynsupConsultPriv() {
		return echoGynsupConsultPriv;
	}

	public void setEchoGynsupConsultPriv(boolean echoGynsupConsultPriv) {
		this.echoGynsupConsultPriv = echoGynsupConsultPriv;
	}

	public boolean isEchoGynModifConsultPriv() {
		return echoGynModifConsultPriv;
	}

	public void setEchoGynModifConsultPriv(boolean echoGynModifConsultPriv) {
		this.echoGynModifConsultPriv = echoGynModifConsultPriv;
	}

	public boolean isEchoGynNouvConsultPriv() {
		return echoGynNouvConsultPriv;
	}

	public void setEchoGynNouvConsultPriv(boolean echoGynNouvConsultPriv) {
		this.echoGynNouvConsultPriv = echoGynNouvConsultPriv;
	}

	public boolean isGynImprConsultPriv() {
		return gynImprConsultPriv;
	}

	public void setGynImprConsultPriv(boolean gynImprConsultPriv) {
		this.gynImprConsultPriv = gynImprConsultPriv;
	}

	public boolean isGynSupConsultPriv() {
		return gynSupConsultPriv;
	}

	public void setGynSupConsultPriv(boolean gynSupConsultPriv) {
		this.gynSupConsultPriv = gynSupConsultPriv;
	}

	public boolean isGynModifConsultPriv() {
		return gynModifConsultPriv;
	}

	public void setGynModifConsultPriv(boolean gynModifConsultPriv) {
		this.gynModifConsultPriv = gynModifConsultPriv;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public boolean isGestExmCompPriv() {
		return gestExmCompPriv;
	}

	public void setGestExmCompPriv(boolean gestExmCompPriv) {
		this.gestExmCompPriv = gestExmCompPriv;
	}

	public boolean isAjoutExmCompPriv() {
		return ajoutExmCompPriv;
	}

	public void setAjoutExmCompPriv(boolean ajoutExmCompPriv) {
		this.ajoutExmCompPriv = ajoutExmCompPriv;
	}

	public boolean isModifExmCompPriv() {
		return modifExmCompPriv;
	}

	public void setModifExmCompPriv(boolean modifExmCompPriv) {
		this.modifExmCompPriv = modifExmCompPriv;
	}

	public boolean isSupExmCompPriv() {
		return supExmCompPriv;
	}

	public void setSupExmCompPriv(boolean supExmCompPriv) {
		this.supExmCompPriv = supExmCompPriv;
	}

	public boolean isGestSymPriv() {
		return gestSymPriv;
	}

	public void setGestSymPriv(boolean gestSymPriv) {
		this.gestSymPriv = gestSymPriv;
	}

	public boolean isAjoutSymPriv() {
		return ajoutSymPriv;
	}

	public void setAjoutSymPriv(boolean ajoutSymPriv) {
		this.ajoutSymPriv = ajoutSymPriv;
	}

	public boolean isModifSymPriv() {
		return modifSymPriv;
	}

	public void setModifSymPriv(boolean modifSymPriv) {
		this.modifSymPriv = modifSymPriv;
	}

	public boolean isSupSymPriv() {
		return supSymPriv;
	}

	public void setSupSymPriv(boolean supSymPriv) {
		this.supSymPriv = supSymPriv;
	}

	public boolean isGestDiagPriv() {
		return gestDiagPriv;
	}

	public void setGestDiagPriv(boolean gestDiagPriv) {
		this.gestDiagPriv = gestDiagPriv;
	}

	public boolean isAjoutDiagPriv() {
		return ajoutDiagPriv;
	}

	public void setAjoutDiagPriv(boolean ajoutDiagPriv) {
		this.ajoutDiagPriv = ajoutDiagPriv;
	}

	public boolean isModifDiagPriv() {
		return modifDiagPriv;
	}

	public void setModifDiagPriv(boolean modifDiagPriv) {
		this.modifDiagPriv = modifDiagPriv;
	}

	public boolean isSupDiagPriv() {
		return supDiagPriv;
	}

	public void setSupDiagPriv(boolean supDiagPriv) {
		this.supDiagPriv = supDiagPriv;
	}

	public boolean isGestMoyCtrPriv() {
		return gestMoyCtrPriv;
	}

	public void setGestMoyCtrPriv(boolean gestMoyCtrPriv) {
		this.gestMoyCtrPriv = gestMoyCtrPriv;
	}

	public boolean isAjoutMoyCtrPriv() {
		return ajoutMoyCtrPriv;
	}

	public void setAjoutMoyCtrPriv(boolean ajoutMoyCtrPriv) {
		this.ajoutMoyCtrPriv = ajoutMoyCtrPriv;
	}

	public boolean isModifMoyCtrPriv() {
		return modifMoyCtrPriv;
	}

	public void setModifMoyCtrPriv(boolean modifMoyCtrPriv) {
		this.modifMoyCtrPriv = modifMoyCtrPriv;
	}

	public boolean isSupMoyCtrPriv() {
		return supMoyCtrPriv;
	}

	public void setSupMoyCtrPriv(boolean supMoyCtrPriv) {
		this.supMoyCtrPriv = supMoyCtrPriv;
	}

	public boolean isGestExmPriv() {
		return gestExmPriv;
	}

	public void setGestExmPriv(boolean gestExmPriv) {
		this.gestExmPriv = gestExmPriv;
	}

	public boolean isAjoutExmPriv() {
		return ajoutExmPriv;
	}

	public void setAjoutExmPriv(boolean ajoutExmPriv) {
		this.ajoutExmPriv = ajoutExmPriv;
	}

	public boolean isModifExmPriv() {
		return modifExmPriv;
	}

	public void setModifExmPriv(boolean modifExmPriv) {
		this.modifExmPriv = modifExmPriv;
	}

	public boolean isSupExmPriv() {
		return supExmPriv;
	}

	public void setSupExmPriv(boolean supExmPriv) {
		this.supExmPriv = supExmPriv;
	}

	public boolean isGestMedPriv() {
		return gestMedPriv;
	}

	public void setGestMedPriv(boolean gestMedPriv) {
		this.gestMedPriv = gestMedPriv;
	}

	public boolean isAjoutMedPriv() {
		return ajoutMedPriv;
	}

	public void setAjoutMedPriv(boolean ajoutMedPriv) {
		this.ajoutMedPriv = ajoutMedPriv;
	}

	public boolean isModifMedPriv() {
		return modifMedPriv;
	}

	public void setModifMedPriv(boolean modifMedPriv) {
		this.modifMedPriv = modifMedPriv;
	}

	public boolean isSupMedPriv() {
		return supMedPriv;
	}

	public void setSupMedPriv(boolean supMedPriv) {
		this.supMedPriv = supMedPriv;
	}

	public boolean isGestAnalPriv() {
		return gestAnalPriv;
	}

	public void setGestAnalPriv(boolean gestAnalPriv) {
		this.gestAnalPriv = gestAnalPriv;
	}

	public boolean isAjoutAnalPriv() {
		return ajoutAnalPriv;
	}

	public void setAjoutAnalPriv(boolean ajoutAnalPriv) {
		this.ajoutAnalPriv = ajoutAnalPriv;
	}

	public boolean isModifAnalPriv() {
		return modifAnalPriv;
	}

	public void setModifAnalPriv(boolean modifAnalPriv) {
		this.modifAnalPriv = modifAnalPriv;
	}

	public boolean isSupAnalPriv() {
		return supAnalPriv;
	}

	public void setSupAnalPriv(boolean supAnalPriv) {
		this.supAnalPriv = supAnalPriv;
	}

	public boolean isGestEtBbPriv() {
		return gestEtBbPriv;
	}

	public void setGestEtBbPriv(boolean gestEtBbPriv) {
		this.gestEtBbPriv = gestEtBbPriv;
	}

	public boolean isAjoutEtBbPriv() {
		return ajoutEtBbPriv;
	}

	public void setAjoutEtBbPriv(boolean ajoutEtBbPriv) {
		this.ajoutEtBbPriv = ajoutEtBbPriv;
	}

	public boolean isModifEtBbPriv() {
		return modifEtBbPriv;
	}

	public void setModifEtBbPriv(boolean modifEtBbPriv) {
		this.modifEtBbPriv = modifEtBbPriv;
	}

	public boolean isSupEtBbPriv() {
		return supEtBbPriv;
	}

	public void setSupEtBbPriv(boolean supEtBbPriv) {
		this.supEtBbPriv = supEtBbPriv;
	}

	public boolean isCertifFichePriv() {
		return certifFichePriv;
	}

	public void setCertifFichePriv(boolean certifFichePriv) {
		this.certifFichePriv = certifFichePriv;
	}

	public boolean isLettreFichePriv() {
		return lettreFichePriv;
	}

	public void setLettreFichePriv(boolean lettreFichePriv) {
		this.lettreFichePriv = lettreFichePriv;
	}

	public boolean isAnalyseFichePriv() {
		return analyseFichePriv;
	}

	public void setAnalyseFichePriv(boolean analyseFichePriv) {
		this.analyseFichePriv = analyseFichePriv;
	}

	public boolean isRapportFichePriv() {
		return rapportFichePriv;
	}

	public void setRapportFichePriv(boolean rapportFichePriv) {
		this.rapportFichePriv = rapportFichePriv;
	}

	public boolean isRadioFichePriv() {
		return radioFichePriv;
	}

	public void setRadioFichePriv(boolean radioFichePriv) {
		this.radioFichePriv = radioFichePriv;
	}

	public boolean isOrdonceFichePriv() {
		return ordonceFichePriv;
	}

	public void setOrdonceFichePriv(boolean ordonceFichePriv) {
		this.ordonceFichePriv = ordonceFichePriv;
	}

	

	public boolean isVerConsultPriv() {
		return verConsultPriv;
	}

	public void setVerConsultPriv(boolean verConsultPriv) {
		this.verConsultPriv = verConsultPriv;
	}

	public boolean isGrossRadioPriv() {
		return grossRadioPriv;
	}

	public void setGrossRadioPriv(boolean grossRadioPriv) {
		this.grossRadioPriv = grossRadioPriv;
	}

	public boolean isGrossAnaPriv() {
		return grossAnaPriv;
	}

	public void setGrossAnaPriv(boolean grossAnaPriv) {
		this.grossAnaPriv = grossAnaPriv;
	}

	public boolean isGrossOrdPriv() {
		return grossOrdPriv;
	}

	public void setGrossOrdPriv(boolean grossOrdPriv) {
		this.grossOrdPriv = grossOrdPriv;
	}

	public boolean isGrossNouvConsultPriv() {
		return grossNouvConsultPriv;
	}

	public void setGrossNouvConsultPriv(boolean grossNouvConsultPriv) {
		this.grossNouvConsultPriv = grossNouvConsultPriv;
	}

	public boolean isGynRadioPriv() {
		return gynRadioPriv;
	}

	public void setGynRadioPriv(boolean gynRadioPriv) {
		this.gynRadioPriv = gynRadioPriv;
	}

	public boolean isGynAnaPriv() {
		return gynAnaPriv;
	}

	public void setGynAnaPriv(boolean gynAnaPriv) {
		this.gynAnaPriv = gynAnaPriv;
	}

	public boolean isGynOrdPriv() {
		return gynOrdPriv;
	}

	public void setGynOrdPriv(boolean gynOrdPriv) {
		this.gynOrdPriv = gynOrdPriv;
	}
	
	
	

	public boolean isConsultDetAnalPriv() {
		return consultDetAnalPriv;
	}

	public void setConsultDetAnalPriv(boolean consultDetAnalPriv) {
		this.consultDetAnalPriv = consultDetAnalPriv;
	}

	public boolean isGynNouvConsultPriv() {
		return gynNouvConsultPriv;
	}

	public void setGynNouvConsultPriv(boolean gynNouvConsultPriv) {
		this.gynNouvConsultPriv = gynNouvConsultPriv;
	}

	public String getMotpass1() {
		return motpass1;
	}

	public void setMotpass1(String motpass1) {
		this.motpass1 = motpass1;
	}

	public String getMotpass2() {
		return motpass2;
	}

	public void setMotpass2(String motpass2) {
		this.motpass2 = motpass2;
	}

	public boolean isTtcochDecochGen() {
		return ttcochDecochGen;
	}

	public void setTtcochDecochGen(boolean ttcochDecochGen) {
		this.ttcochDecochGen = ttcochDecochGen;
	}
	

	

	public boolean isModifAntPriv() {
		return modifAntPriv;
	}

	public void setModifAntPriv(boolean modifAntPriv) {
		this.modifAntPriv = modifAntPriv;
	}

	public boolean isSuppAntPriv() {
		return suppAntPriv;
	}

	public void setSuppAntPriv(boolean suppAntPriv) {
		this.suppAntPriv = suppAntPriv;
	}

	public boolean isModifGynObsPriv() {
		return modifGynObsPriv;
	}

	public void setModifGynObsPriv(boolean modifGynObsPriv) {
		this.modifGynObsPriv = modifGynObsPriv;
	}

	public boolean isTabAntecedentPriv() {
		return tabAntecedentPriv;
	}

	public void setTabAntecedentPriv(boolean tabAntecedentPriv) {
		this.tabAntecedentPriv = tabAntecedentPriv;
	}

	public boolean isTabGynecoObsPriv() {
		return tabGynecoObsPriv;
	}

	public void setTabGynecoObsPriv(boolean tabGynecoObsPriv) {
		this.tabGynecoObsPriv = tabGynecoObsPriv;
	}

	public boolean isTabHistGrossPriv() {
		return tabHistGrossPriv;
	}

	public void setTabHistGrossPriv(boolean tabHistGrossPriv) {
		this.tabHistGrossPriv = tabHistGrossPriv;
	}

	public boolean isTabContracepPriv() {
		return tabContracepPriv;
	}

	public void setTabContracepPriv(boolean tabContracepPriv) {
		this.tabContracepPriv = tabContracepPriv;
	}

	public boolean isNouvGrossPriv() {
		return nouvGrossPriv;
	}

	public void setNouvGrossPriv(boolean nouvGrossPriv) {
		this.nouvGrossPriv = nouvGrossPriv;
	}

	public boolean isNouvContracepPriv() {
		return nouvContracepPriv;
	}

	public void setNouvContracepPriv(boolean nouvContracepPriv) {
		this.nouvContracepPriv = nouvContracepPriv;
	}

	public boolean isModifHistGrossPriv() {
		return modifHistGrossPriv;
	}

	public void setModifHistGrossPriv(boolean modifHistGrossPriv) {
		this.modifHistGrossPriv = modifHistGrossPriv;
	}

	public boolean isSupHistGrossPriv() {
		return supHistGrossPriv;
	}

	public void setSupHistGrossPriv(boolean supHistGrossPriv) {
		this.supHistGrossPriv = supHistGrossPriv;
	}

	public boolean isModifContracepPriv() {
		return modifContracepPriv;
	}

	public void setModifContracepPriv(boolean modifContracepPriv) {
		this.modifContracepPriv = modifContracepPriv;
	}

	public boolean isSupContacepPriv() {
		return supContacepPriv;
	}

	public void setSupContacepPriv(boolean supContacepPriv) {
		this.supContacepPriv = supContacepPriv;
	}

	public boolean isAntecedentPriv() {
		return antecedentPriv;
	}

	public void setAntecedentPriv(boolean antecedentPriv) {
		this.antecedentPriv = antecedentPriv;
	}

	public boolean isEchoGynPriv() {
		return echoGynPriv;
	}

	public void setEchoGynPriv(boolean echoGynPriv) {
		this.echoGynPriv = echoGynPriv;
	}

	public boolean isEchoObstPriv() {
		return echoObstPriv;
	}

	public void setEchoObstPriv(boolean echoObstPriv) {
		this.echoObstPriv = echoObstPriv;
	}

	public boolean isGynecologiePriv() {
		return gynecologiePriv;
	}

	public void setGynecologiePriv(boolean gynecologiePriv) {
		this.gynecologiePriv = gynecologiePriv;
	}

	public boolean isConsultGrossPriv() {
		return consultGrossPriv;
	}

	public void setConsultGrossPriv(boolean consultGrossPriv) {
		this.consultGrossPriv = consultGrossPriv;
	}

	public boolean isSterilitePriv() {
		return sterilitePriv;
	}

	public void setSterilitePriv(boolean sterilitePriv) {
		this.sterilitePriv = sterilitePriv;
	}

	public boolean isSupProfPriv() {
		return supProfPriv;
	}

	public void setSupProfPriv(boolean supProfPriv) {
		this.supProfPriv = supProfPriv;
	}

	public boolean isAjoutVilPriv() {
		return ajoutVilPriv;
	}

	public void setAjoutVilPriv(boolean ajoutVilPriv) {
		this.ajoutVilPriv = ajoutVilPriv;
	}

	public String getAjoutPatient() {
		return ajoutPatient;
	}

	public void setAjoutPatient(String ajoutPatient) {
		this.ajoutPatient = ajoutPatient;
	}

	public boolean isAjoutDocPriv() {
		return ajoutDocPriv;
	}

	public void setAjoutDocPriv(boolean ajoutDocPriv) {
		this.ajoutDocPriv = ajoutDocPriv;
	}

	public boolean isModifDocPriv() {
		return modifDocPriv;
	}

	public void setModifDocPriv(boolean modifDocPriv) {
		this.modifDocPriv = modifDocPriv;
	}

	public boolean isSupDocPriv() {
		return supDocPriv;
	}

	public void setSupDocPriv(boolean supDocPriv) {
		this.supDocPriv = supDocPriv;
	}

	public boolean isAjoutProfPriv() {
		return ajoutProfPriv;
	}

	public void setAjoutProfPriv(boolean ajoutProfPriv) {
		this.ajoutProfPriv = ajoutProfPriv;
	}

	public boolean isModifProfPriv() {
		return modifProfPriv;
	}

	public void setModifProfPriv(boolean modifProfPriv) {
		this.modifProfPriv = modifProfPriv;
	}

	public boolean isModifVilPriv() {
		return modifVilPriv;
	}

	public void setModifVilPriv(boolean modifVilPriv) {
		this.modifVilPriv = modifVilPriv;
	}

	public boolean isSupVilPriv() {
		return supVilPriv;
	}

	public void setSupVilPriv(boolean supVilPriv) {
		this.supVilPriv = supVilPriv;
	}

	public boolean isAjoutClinPriv() {
		return ajoutClinPriv;
	}

	public void setAjoutClinPriv(boolean ajoutClinPriv) {
		this.ajoutClinPriv = ajoutClinPriv;
	}

	public boolean isModifClinPriv() {
		return modifClinPriv;
	}

	public void setModifClinPriv(boolean modifClinPriv) {
		this.modifClinPriv = modifClinPriv;
	}

	public boolean isSupClinPriv() {
		return supClinPriv;
	}

	public void setSupClinPriv(boolean supClinPriv) {
		this.supClinPriv = supClinPriv;
	}

	public boolean isPremierPatSalPriv() {
		return premierPatSalPriv;
	}

	public void setPremierPatSalPriv(boolean premierPatSalPriv) {
		this.premierPatSalPriv = premierPatSalPriv;
	}

	public boolean isPermutPatSalPriv() {
		return permutPatSalPriv;
	}

	public void setPermutPatSalPriv(boolean permutPatSalPriv) {
		this.permutPatSalPriv = permutPatSalPriv;
	}

	public boolean isDescdrePatSalPriv() {
		return descdrePatSalPriv;
	}

	public void setDescdrePatSalPriv(boolean descdrePatSalPriv) {
		this.descdrePatSalPriv = descdrePatSalPriv;
	}

	public boolean isDernierSalPriv() {
		return dernierSalPriv;
	}

	public void setDernierSalPriv(boolean dernierSalPriv) {
		this.dernierSalPriv = dernierSalPriv;
	}

	public boolean isSupPatSalPriv() {
		return supPatSalPriv;
	}

	public void setSupPatSalPriv(boolean supPatSalPriv) {
		this.supPatSalPriv = supPatSalPriv;
	}

	public boolean isChargPatSalPriv() {
		return chargPatSalPriv;
	}

	public void setChargPatSalPriv(boolean chargPatSalPriv) {
		this.chargPatSalPriv = chargPatSalPriv;
	}

	public boolean isMontPatSalPriv() {
		return montPatSalPriv;
	}

	public void setMontPatSalPriv(boolean montPatSalPriv) {
		this.montPatSalPriv = montPatSalPriv;
	}

	public boolean isRappLettrePriv() {
		return rappLettrePriv;
	}

	public void setRappLettrePriv(boolean rappLettrePriv) {
		this.rappLettrePriv = rappLettrePriv;
	}

	public boolean isRappOrdncePriv() {
		return rappOrdncePriv;
	}

	public void setRappOrdncePriv(boolean rappOrdncePriv) {
		this.rappOrdncePriv = rappOrdncePriv;
	}

	public boolean isRappCertifPriv() {
		return rappCertifPriv;
	}

	public void setRappCertifPriv(boolean rappCertifPriv) {
		this.rappCertifPriv = rappCertifPriv;
	}

	public boolean isGestCliPriv() {
		return gestCliPriv;
	}

	public void setGestCliPriv(boolean gestCliPriv) {
		this.gestCliPriv = gestCliPriv;
	}

	public boolean isGestVilPriv() {
		return gestVilPriv;
	}

	public void setGestVilPriv(boolean gestVilPriv) {
		this.gestVilPriv = gestVilPriv;
	}

	public boolean isGestProfPriv() {
		return gestProfPriv;
	}

	public void setGestProfPriv(boolean gestProfPriv) {
		this.gestProfPriv = gestProfPriv;
	}

	public boolean isGestDocPriv() {
		return gestDocPriv;
	}

	public void setGestDocPriv(boolean gestDocPriv) {
		this.gestDocPriv = gestDocPriv;
	}

	public boolean isTabAtreInfAjtPatPriv() {
		return tabAtreInfAjtPatPriv;
	}

	public void setTabAtreInfAjtPatPriv(boolean tabAtreInfAjtPatPriv) {
		this.tabAtreInfAjtPatPriv = tabAtreInfAjtPatPriv;
	}

	public boolean isTabInfoConjAjtPatPriv() {
		return tabInfoConjAjtPatPriv;
	}

	public void setTabInfoConjAjtPatPriv(boolean tabInfoConjAjtPatPriv) {
		this.tabInfoConjAjtPatPriv = tabInfoConjAjtPatPriv;
	}

	public boolean isTabContctPatPriv() {
		return tabContctPatPriv;
	}

	public void setTabContctPatPriv(boolean tabContctPatPriv) {
		this.tabContctPatPriv = tabContctPatPriv;
	}

	

	public boolean isTabInfGnrAjtPatPriv() {
		return tabInfGnrAjtPatPriv;
	}

	public void setTabInfGnrAjtPatPriv(boolean tabInfGnrAjtPatPriv) {
		this.tabInfGnrAjtPatPriv = tabInfGnrAjtPatPriv;
	}

	public boolean isSuppPatPriv() {
		return suppPatPriv;
	}

	public void setSuppPatPriv(boolean suppPatPriv) {
		this.suppPatPriv = suppPatPriv;
	}

	public boolean isChargPatPriv() {
		return chargPatPriv;
	}

	public void setChargPatPriv(boolean chargPatPriv) {
		this.chargPatPriv = chargPatPriv;
	}

	public boolean isDetPatPriv() {
		return detPatPriv;
	}

	public void setDetPatPriv(boolean detPatPriv) {
		this.detPatPriv = detPatPriv;
	}

	public boolean isModifPatPriv() {
		return modifPatPriv;
	}

	public void setModifPatPriv(boolean modifPatPriv) {
		this.modifPatPriv = modifPatPriv;
	}

	public boolean isVerSalPriv() {
		return verSalPriv;
	}

	public void setVerSalPriv(boolean verSalPriv) {
		this.verSalPriv = verSalPriv;
	}

	public boolean isAjouPatPriv() {
		return ajouPatPriv;
	}

	public void setAjouPatPriv(boolean ajouPatPriv) {
		this.ajouPatPriv = ajouPatPriv;
	}

	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	public boolean isMenuGesUtlPriv() {
		return menuGesUtlPriv;
	}

	public void setMenuGesUtlPriv(boolean menuGesUtlPriv) {
		this.menuGesUtlPriv = menuGesUtlPriv;
	}

	public boolean isMenuRappPriv() {
		return menuRappPriv;
	}

	public void setMenuRappPriv(boolean menuRappPriv) {
		this.menuRappPriv = menuRappPriv;
	}
	
	

	public boolean isMenuStatPriv() {
		return menuStatPriv;
	}

	public void setMenuStatPriv(boolean menuStatPriv) {
		this.menuStatPriv = menuStatPriv;
	}

	public boolean isMenuParamPriv() {
		return menuParamPriv;
	}

	public void setMenuParamPriv(boolean menuParamPriv) {
		this.menuParamPriv = menuParamPriv;
	}

	public boolean isMenuGesPatPriv() {
		return menuGesPatPriv;
	}

	public void setMenuGesPatPriv(boolean menuGesPatPriv) {
		this.menuGesPatPriv = menuGesPatPriv;
	}

	public boolean isMenuSalPriv() {
		return menuSalPriv;
	}

	public void setMenuSalPriv(boolean menuSalPriv) {
		this.menuSalPriv = menuSalPriv;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCivil() {
		return civil;
	}

	public void setCivil(String civil) {
		this.civil = civil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Utilisateur> getUtilisateurs() {

		UtilisateurService ser = new UtilisateurService();
		utilisateurs = ser.rechercheTousUtilisateur();
		
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public void ajouterUtilisateur() {

		FacesContext faces = FacesContext.getCurrentInstance();
	//	RequestContext context = RequestContext.getCurrentInstance();
		UtilisateurService utlser = new UtilisateurService();
		List<Utilisateur> utlBylog = utlser.rechercheUtilisateurByLogin(login);
//		List<Utilisateur> utlBymotPss = utlser
//				.rechercheUtilisateurByMotPass(motPasse);

		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = true;

		//boolean addValid = false;

		if (email != null && email.trim().length() > 0)
			b = email.matches(EMAIL_REGEX);

		if (login == null || (login.trim().length() == 0)) {// tester// si //
															// login // est //
															// vide

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Login vide",
					"Invalid credentials"));
		} else if (utlBylog.size() > 0) {

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Login existe déja",
					"Invalid credentials"));
		}

		if (motPasse == null || (motPasse.trim().length() == 0)) {// tester// si
																	// //
																	// motPasse
																	// // est //
																	// vide

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Mot de Passe vide",
					"Invalid credentials"));
		}

		if ((nom == null || (nom.trim().length() == 0))
				&& (prenom == null || (prenom.trim().length() == 0))) {// tester//
																		// si //
																		// nom ou pren
																		// //
																		// est
																		// //
																		// vide

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Nom et Prenom vide",
					"Invalid credentials"));
		}

		if (!b) {

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Format email invalide",
					"Invalid credentials"));

		}

		
		
		if (faces.getMessageList().size() == 0) {
			
			UtilisateurService ser = new UtilisateurService();
			Utilisateur u = new Utilisateur();

			//addValid = true;

			SimpleDateFormat formatDateJava = new SimpleDateFormat("dd/MM/yyyy");
			if (dateNais != null)
				date_naiss = formatDateJava.format(dateNais);

			u.setNom(nom);
			u.setPrenom(prenom);
			u.setLogin(login);
			u.setMotPasse(motPasse);
			u.setAdresse(adresse);
			u.setCivil(civil);
			u.setDate_naiss(date_naiss);
			u.setEmail(email);
			u.setTel(tel);
			u.setActif(true);
			u.setPassif(false);

			if (gestExmCompPriv) {
				u.setGestExmComp("1");
			} else {
				u.setGestExmComp("0");
			}
			if (ajoutExmCompPriv) {
				u.setAjoutExmComp(true);
			} else {
				u.setAjoutExmComp(false);
			}
			if (modifExmCompPriv) {
				u.setModifExmComp(true);
			} else {
				u.setModifExmComp(false);
			}

			if (supExmCompPriv) {
				u.setSupExmComp(true);
			} else {
				u.setSupExmComp(false);
			}

			if (gestSymPriv) {
				u.setGestSyn("1");
			} else {
				u.setGestSyn("0");
			}
			if (ajoutSymPriv) {
				u.setAjoutAsym(true);
			} else {
				u.setAjoutAsym(false);
			}
			if (modifSymPriv) {
				u.setModifAsym(true);
				
			} else {
				u.setModifAsym(false);
			}

			if (supSymPriv) {
				u.setSupAsym(true);
			} else {
				u.setSupAsym(false);
			}

			if (gestDiagPriv) {
				u.setGestDiag("1");
			} else {
				u.setGestDiag("0");
			}
			if (ajoutDiagPriv) {
				u.setAjoutDiag(true);
				
			} else {
				u.setAjoutDiag(false);
			}
			if (modifDiagPriv) {
				u.setModifDiag(true);
				
			} else {
				u.setModifDiag(false);
			}

			if (supDiagPriv) {
				u.setSupDiag(true);
			} else {
				u.setSupDiag(false);
			}

			if (gestMoyCtrPriv) {
				u.setGestMoyCtrcep("1");
			} else {
				u.setGestMoyCtrcep("0");
			}
			if (ajoutMoyCtrPriv) {
				u.setAjoutMoyCtr(true);
				;
			} else {
				u.setAjoutMoyCtr(false);
			}
			if (modifMoyCtrPriv) {
				u.setModifMoyCtr(true);
				;
			} else {
				u.setModifMoyCtr(false);
			}

			if (supMoyCtrPriv) {
				u.setSupMoyCtr(true);
			} else {
				u.setSupMoyCtr(false);
			}

			if (gestExmPriv) {
				u.setGestExm("1");
			} else {
				u.setGestExm("0");
			}
			if (ajoutExmPriv) {
				u.setAjoutExm(true);
			} else {
				u.setAjoutExm(false);
			}
			if (modifExmPriv) {
				u.setModifExm(true);
			} else {
				u.setModifExm(false);
			}

			if (supExmPriv) {
				u.setSupExm(true);
			} else {
				u.setSupExm(false);
			}
			
			if(gestJrFerParamPriv){
				u.setGestionJourFr(true);
			}else{
				u.setGestionJourFr(false);
			}
			if(paramtabJrFerPriv){
				u.setTabFerie(true);
			}else{
				u.setTabFerie(false);
			}
			if(ajouJrFerStndPriv){
				u.setNouvJFerie(true);
			}else{
				u.setNouvJFerie(false);
			}
			if(modifJrFerStndPriv){
				u.setModifJFerie(true);
			}else{
				u.setModifJFerie(false);
			}
			if(supJrFerStndPriv){
				u.setSuppJFerie(true);
			}else{
				u.setSuppJFerie(false);
			}
			if(paramtabJrFerExpPriv){
				u.setTabJFerieExp(true);
			}else{
				u.setTabJFerieExp(false);
			}
			if(ajouJrFerExpPriv){
				u.setNouvJFerieExp(true);
			}else{
				u.setNouvJFerieExp(false);
			}
			if(modifJrFerExpPriv){
				u.setModifJFerieExp(true);
			}else{
				u.setModifJFerieExp(false);
			}
			if(supJrFerExpPriv){
				u.setSuppJFerieExp(true);
			}else{
				u.setSuppJFerieExp(false);
			}

			if (gestMedPriv) {
				u.setGestMed("1");
			} else {
				u.setGestMed("0");
			}
			if (ajoutMedPriv) {
				u.setAjoutMed(true);
				
			} else {
				u.setAjoutMed(false);
			}
			if (modifMedPriv) {
				u.setModifMed(true);
				
			} else {
				u.setModifMed(false);
			}

			if (supMedPriv) {
				u.setSupMed(true);
			} else {
				u.setSupMed(false);
			}

			if (gestAnalPriv) {
				u.setGestAnal("1");
			} else {
				u.setGestAnal("0");
			}
			if (ajoutAnalPriv) {
				u.setAjoutAnal(true);
				
			} else {
				u.setAjoutAnal(false);
			}
			if (modifAnalPriv) {
				u.setModifAnal(true);
				
			} else {
				u.setModifAnal(false);
			}

			if (supAnalPriv) {
				u.setSupAnal(true);
			} else {
				u.setSupAnal(false);
			}

			if (gestEtBbPriv) {
				u.setGestBb("1");
			} else {
				u.setGestBb("0");
			}
			if (ajoutEtBbPriv) {
				u.setAjoutEtBb(true);
				
			} else {
				u.setAjoutEtBb(false);
			}
			if (modifEtBbPriv) {
				u.setModifEtBb(true);
				
			} else {
				u.setModifEtBb(false);
			}

			if (supEtBbPriv) {
				u.setSupEtBb(true);
				
			} else {
				u.setSupEtBb(false);
			}

			if (certifFichePriv) {
				u.setCertifFiche("1");
			} else {
				u.setCertifFiche("0");
			}
			if (ajoutCertifPriv) {
				u.setNouvCertif(true);
			} else {
				u.setNouvCertif(false);
			}
			if (modifCertifPriv) {
				u.setModifCertif(true);
			} else {
				u.setModifCertif(false);
			}
			if (supCertifPriv) {
				u.setSuppCertif(true);
			} else {
				u.setSuppCertif(false);
			}
			if (impCertifPriv) {
				u.setImprCertif(true);
			} else {
				u.setImprCertif(false);
			}
			
			
			if (lettreFichePriv) {
				u.setLettreFiche("1");
			} else {
				u.setLettreFiche("0");
			}
			if(ajoutLtrPriv){
				u.setNouvLettre(true);
			}else{
				u.setNouvLettre(false);
			}
			if(modifLtrPriv){
				u.setModifLettre(true);
			}else{
				u.setModifLettre(false);
			}
			if(supLtrPriv){
				u.setSuppLettre(true);
			}else{
				u.setSuppLettre(false);
			}
			if(impLtrPriv){
				u.setImprLettre(true);
			}else{
				u.setImprLettre(false);
			}
			
			if (analyseFichePriv) {
				u.setAnalyseFiche("1");
			} else {
				u.setAnalyseFiche("0");
			}
			if (modifHistoAnalPriv) {
				u.setModifAnalyse(true);
			} else {
				u.setModifAnalyse(false);
			}
			if (consultHistoAnalPriv) {
				u.setDetHistoAnal(true);
			} else {
				u.setDetHistoAnal(false);
			}
			
			if (supHistoAnalPriv) {
				u.setSupAnalyse(true);
			} else {
				u.setSupAnalyse(false);
			}
			
			
					
			if (radioFichePriv) {
				u.setRadioFiche("1");
			} else {
				u.setRadioFiche("0");
			}
			if(modifHistoRadPriv){
				u.setModifRadio(true);
			}else{
				u.setModifRadio(false);
			}
			if(consultHistoRadPriv){
				u.setDetHistoRad(true);
			}else{
				u.setDetHistoRad(false);
			}
			if(supHistoRadPriv){
				u.setSupRadio(true);
			}else{
				u.setSupRadio(false);
			}
			
			if(imprAnalPriv){
				u.setImprmAnal(true);
			}else{
				u.setImprmAnal(false);
			}
			
			if(imprRadioPriv){
				u.setImprRadio(true);
			}else{
				u.setImprRadio(false);
			}

			
			
			if (rapportFichePriv) {
				u.setRapportFiche("1");
			} else {
				u.setRapportFiche("0");
			}
			
				
			if(ajoutModeleordPriv){
				u.setAjoutModeleord(true);
			}else{
				u.setAjoutModeleord(false);
			}
			if(selectModeleordPriv){
				u.setSelectModeleord(true);
			}else{
				u.setSelectModeleord(false);
			}
			if(suppModeleOrdPriv){
				u.setSuppModeleOrd(true);
			}else{
				u.setSuppModeleOrd(false);
			}
			
			if(gestSaisPriv){
				u.setGestSais(true);
			}else{
				u.setGestSais(false);
			}
			
			if(consultertHistoConsultationPriv){
				u.setSelectTableConsultation(true);
			}else{
				u.setSelectTableConsultation(false);
			}
			
			if (ordonceFichePriv) {
				u.setOrdnanceFiche("1");
			} else {
				u.setOrdnanceFiche("0");
			}
			if(consultOrdLibrePriv){
				u.setOrdonanceLibreFiche(true);
			}else{
				u.setOrdonanceLibreFiche(false);
			}
			if(modifHistoOrdPriv){
				u.setModifOrdnce(true);
			}else{
				u.setModifOrdnce(false);
			}
			if(supHistoOrdPriv){
				u.setSupphistoOrd(true);
			}else{
				u.setSupphistoOrd(false);
			}
			if(rechercheOrdPriv){
				u.setRechercheOrd(true);
			}else{
				u.setRechercheOrd(false);
			}
			if(imprOrdPriv){
				u.setImprOrd(true);
			}else{
				u.setImprOrd(false);
			}

			if (verConsultPriv) {
				u.setVerConsult("1");
			} else {
				u.setVerConsult("0");
			}
			if (menuSalPriv) {
				u.setMenuSal("1");
			} else {
				u.setMenuSal("0");
			}

			if (menuGesPatPriv) {
				u.setMenuGestPat("1");
			} else {
				u.setMenuGestPat("0");
			}

			if (menuParamPriv) {
				u.setMenuParametre("1");
			} else {
				u.setMenuParametre("0");
			}
			
			if(menuRendvousPriv){
				u.setMenuGestRdv("1");
			}else{
				u.setMenuGestRdv("0");
			}

			if (menuRappPriv) {
				u.setMenuRapport("1");
			} else {
				u.setMenuRapport("0");
			}
			
			if (menuStatPriv) {
				u.setMenuGestStat(true);
			} else {
				u.setMenuGestStat(false);
			}

			if (menuGesUtlPriv) {
				u.setMenuGestUtl("1");
			} else {
				u.setMenuGestUtl("0");
			}

			if (ajouPatPriv) {
				u.setAjoutPatient("1");
			} else {
				u.setAjoutPatient("0");
			}

			if (verSalPriv) {
				u.setVerSal("1");
			} else {
				u.setVerSal("0");
			}

			if (modifPatPriv) {
				u.setModPatient("1");
			} else {
				u.setModPatient("0");
			}

			if (detPatPriv) {
				u.setDetPatient("1");
			} else {
				u.setDetPatient("0");
			}

			if (chargPatPriv) {
				u.setChargPatient("1");
			} else {
				u.setChargPatient("0");
			}

			if (suppPatPriv) {
				u.setSupPatient("1");
			} else {
				u.setSupPatient("0");
			}

			if (tabInfGnrAjtPatPriv) {
				u.setTabInfGenAjoutPat("1");
			} else {
				u.setTabInfGenAjoutPat("0");
			}

			if (tabContctPatPriv) {
				u.setTabCntctAjoutPat("1");
			} else {
				u.setTabCntctAjoutPat("0");
			}

			if (tabInfoConjAjtPatPriv) {
				u.setTabInfoConjAjoutPat("1");
			} else {
				u.setTabInfoConjAjoutPat("0");
			}

			if (tabAtreInfAjtPatPriv) {
				u.setTabAutreInfAjoutPat("1");
			} else {
				u.setTabAutreInfAjoutPat("0");
			}

			if (gestDocPriv) {
				u.setGestDoc("1");
			} else {
				u.setGestDoc("0");
			}
			
			if (gestAntecedentParamPriv) {
				u.setGestAntecedent(true);
			} else {
				u.setGestAntecedent(false);
			}
			if (paramtabAntMedPriv) {
				u.setTabMedAnt(true);
			} else {
				u.setTabMedAnt(false);
			}
			
			if (ajoutAntMedPriv) {
				u.setAjoutGestAntMed(true);
			} else {
				u.setAjoutGestAntMed(false);
			}
			if (modifAntMedPriv) {
				u.setModifGestAntMed(true);
			} else {
				u.setModifGestAntMed(false);
			}
			if (supAntMedPriv) {
				u.setSuppGestAntMed(true);
			} else {
				u.setSuppGestAntMed(false);
			}
			
			if (paramtabAntChirgPriv) {
				u.setTabChirAnt(true);
			} else {
				u.setTabChirAnt(false);
			}
			if (ajoutAntChirgPriv) {
				u.setAjoutGestChirg(true);
			} else {
				u.setAjoutGestChirg(false);
			}
			if (modifAntChirgPriv) {
				u.setModifGestChirg(true);
			} else {
				u.setModifGestChirg(false);
			}
			if (supAntChirgPriv) {
				u.setSuppGestAntChirg(true);
			} else {
				u.setSuppGestAntChirg(false);
			}
			if (paramtabAntFamPriv) {
				u.setTabFamAnt(true);
			} else {
				u.setTabFamAnt(false);
			}
			if (ajoutAntFamPriv) {
				u.setAjoutGestFam(true);
			} else {
				u.setAjoutGestFam(false);
			}
			if (modifAntFamPriv) {
				u.setModifGestFam(true);
			} else {
				u.setModifGestFam(false);
			}
			if (supAntFamPriv) {
				u.setSuppGestAntFam(true);
			} else {
				u.setSuppGestAntFam(false);
			}
			
			if (gestHorairePriv) {
				u.setGestHoraire(true);
			} else {
				u.setGestHoraire(false);
			}
			
			if (modifprdSaisPriv) {
				u.setModifPrtSais(true);
			} else {
				u.setModifPrtSais(false);
			}
			if (ajoutHorTravPriv) {
				u.setAjoutHeurTrav(true);
			} else {
				u.setAjoutHeurTrav(false);
			}
			if (modifHorTravPriv) {
				u.setModifHeurTrav(true);
			} else {
				u.setModifHeurTrav(false);
			}
			if (supHorTravPriv) {
				u.setSupHeurTrav(true);
			} else {
				u.setSupHeurTrav(false);
			}
			
			
			if(gestCabinetPriv){
				u.setGestCabinet(true);
			}else{
				u.setGestCabinet(false);
			}
			if (gestUtPriv) {
				u.setGestionUterus(true);
			} else {
				u.setGestionUterus(false);
			}
			if (ajoutUtPriv) {
				u.setAjoutUt(true);
			} else {
				u.setAjoutUt(false);
			}
			if (modifUtPriv) {
				u.setModifUt(true);
			} else {
				u.setModifUt(false);
			}
			if (supUtPriv) {
				u.setSupUt(true);
			} else {
				u.setSupUt(false);
			}
			
			
			if (gestFinGrossPriv) {
				u.setGestEFG("1");
			} else {
				u.setGestEFG("0");
			}
			if (ajoutFinGrossPriv) {
				u.setAjoutEFG(true);
			} else {
				u.setAjoutEFG(false);
			}
			if (modifFinGrossPriv) {
				u.setModifEFG(true);
			} else {
				u.setModifEFG(false);
			}
			if (supFinGrossPriv) {
				u.setSupEFG(true);
			} else {
				u.setSupEFG(false);
			}
			
			if (gestConsPriv) {
				u.setGestConsultation(true);
			} else {
				u.setGestConsultation(false);
			}
			if (modifConsPriv) {
				u.setModifCons(true);
			} else {
				u.setModifCons(false);
			}
			
			if (gestFrmMedPriv) {
				u.setGestionFormMed(true);
			} else {
				u.setGestionFormMed(false);
			}
			if (ajoutFrmMedPriv) {
				u.setAjoutFM(true);
			} else {
				u.setAjoutFM(false);
			}
			if (modifFrmMedPriv) {
				u.setModifFM(true);
			} else {
				u.setModifFM(false);
			}
			if (supFrmMedPriv) {
				u.setSupFM(true);
			} else {
				u.setSupFM(false);
			}


			if (gestProfPriv) {
				u.setGestProf("1");
			} else {
				u.setGestProf("0");
			}

			if (gestVilPriv) {
				u.setGestVil("1");
			} else {
				u.setGestVil("0");
			}
			if (gestCliPriv) {
				u.setGestClin("1");
			} else {
				u.setGestClin("0");
			}
			if (rappCertifPriv) {
				u.setRappCertif("1");
			} else {
				u.setRappCertif("0");
			}
			if (rappOrdncePriv) {
				u.setRappOrdnce("1");
			} else {
				u.setRappOrdnce("0");
			}
			if (rappLettrePriv) {
				u.setRappLettre("1");
			} else {
				u.setRappLettre("0");
			}

			if (montPatSalPriv) {
				u.setMonterPatSal("1");
			} else {
				u.setMonterPatSal("0");
			}
			if (descdrePatSalPriv) {
				u.setDesdrePatSal("1");
			} else {
				u.setDesdrePatSal("0");
			}
			if (permutPatSalPriv) {
				u.setPermutPatSal("1");
			} else {
				u.setPermutPatSal("0");
			}
			if (premierPatSalPriv) {
				u.setPremierPatSal("1");
			} else {
				u.setPremierPatSal("0");
			}
			if (dernierSalPriv) {
				u.setDernierPatSal("1");
			} else {
				u.setDernierPatSal("0");
			}
			if (supPatSalPriv) {
				u.setSupPatSal("1");
			} else {
				u.setSupPatSal("0");
			}
			if (chargPatSalPriv) {
				u.setChargPatSal("1");
			} else {
				u.setChargPatSal("0");
			}
			if (modifNoteSalPriv) {
				u.setModifNoteSal(true);
			} else {
				u.setModifNoteSal(false);
			}
			if (reponseSalPriv) {
				u.setReponseSal(true);
			} else {
				u.setReponseSal(false);
			}
			if (tabAnulSalPriv) {
				u.setTabAnulSal(true);
			} else {
				u.setTabAnulSal(false);
			}
			if (anulSalPriv) {
				u.setAnulSal(true);
			} else {
				u.setAnulSal(false);
			}

			if (donnerRdvPriv) {
				u.setDonnerRdv(true);
			} else {
				u.setDonnerRdv(false);
			}
			if (donnerRdvPriv) {
				u.setDonnerRdv(true);
			} else {
				u.setDonnerRdv(false);
			}
			if (archiverPatPriv) {
				u.setArchiverPat(true);
			} else {
				u.setArchiverPat(false);
			}
			if (consultArchivePriv) {
				u.setConsultArchiv(true);
			} else {
				u.setConsultArchiv(false);
			}
			
			
			
			if (ajoutClinPriv) {
				u.setAjoutClin("1");
			} else {
				u.setAjoutClin("0");
			}
			if (modifClinPriv) {
				u.setModifClin("1");
			} else {
				u.setModifClin("0");
			}
			if (supClinPriv) {
				u.setSupClin("1");
			} else {
				u.setSupClin("0");
			}
			if (ajoutDocPriv) {
				u.setAjoutDoc("1");
			} else {
				u.setAjoutDoc("0");
			}
			if (modifDocPriv) {
				u.setModifDoc("1");
			} else {
				u.setModifDoc("0");
			}
			if (supDocPriv) {
				u.setSupDoc("1");
			} else {
				u.setSupDoc("0");
			}
			if (ajoutProfPriv) {
				u.setAjoutProf("1");
			} else {
				u.setAjoutProf("0");
			}
			if (modifProfPriv) {
				u.setModifProf("1");
			} else {
				u.setModifProf("0");
			}
			if (supProfPriv) {
				u.setSupProf("1");
			} else {
				u.setSupProf("0");
			}
			if (ajoutVilPriv) {
				u.setAjoutVil("1");
			} else {
				u.setAjoutVil("0");
			}
			if (modifVilPriv) {
				u.setModifVil("1");
			} else {
				u.setModifVil("0");
			}
			if (supVilPriv) {
				u.setSupVil("1");
			} else {
				u.setSupVil("0");
			}

			if (antecedentPriv) {
				u.setAntecedent("1");
			} else {
				u.setAntecedent("0");
			}
			
			if (echoGynPriv) {
				u.setEchoGyn("1");
			} else {
				u.setEchoGyn("0");
			}
			
			
			if (echoGynNouvConsultPriv) {
				u.setNouvchogyneco(true);
			} else {
				u.setNouvchogyneco(false);
			}
			if (echoGynModifConsultPriv) {
				u.setModifechogyneco(true);
			} else {
				u.setModifechogyneco(false);
			}
			if(echoGynsupConsultPriv){
				u.setSuppechogyneco(true);
			}else{
				u.setSuppechogyneco(false);
			}
			if(echoGynNouvModeltPriv){
				u.setAjoutmodelechogyneco(true);
			}else{
				u.setAjoutmodelechogyneco(false);
			}
			if(echoGynSupModeltPriv){
				u.setSuppmodelechogyneco(true);
			}else{
				u.setSuppmodelechogyneco(false);
			}
			
			if(echoGynApplModeltPriv){
				u.setAppliquemodelechogyneco(true);
			}else{
				u.setAppliquemodelechogyneco(false);
			}
			
			if(echoGynApplModeltPriv){
				u.setAppliquemodelechogyneco(true);
			}else{
				u.setAppliquemodelechogyneco(false);
			}
			if(echoGynImprPriv){
				u.setImprechogyneco(true);
			}else{
				u.setImprechogyneco(false);
			}
			
			if (echoObstPriv) {
				u.setEchoObs("1");
			} else {
				u.setEchoObs("0");
			}
			
			if (echoObsNouvConsultPriv) {
				u.setNouvechoObs(true);
			} else {
				u.setNouvechoObs(false);
			}
			if (echoObsModifConsultPriv) {
				u.setModifechoObs(true);
			} else {
				u.setModifechoObs(false);
			}
			
			if (echoObsSupConsultPriv) {
				u.setSuppechoObs(true);
			} else {
				u.setSuppechoObs(false);
			}
			
			if (echoObsTrim1Priv) {
				u.setTrim1echoObs(true);
			} else {
				u.setTrim1echoObs(false);
			}
			
			if (echoObsTrim2Priv) {
				u.setTrim2echoObs(true);
			} else {
				u.setTrim2echoObs(false);
			}
			
			if (echoObsTrim3Priv) {
				u.setTrim3echoObs(true);
			} else {
				u.setTrim3echoObs(false);
			}
			if (echoObsImprPriv) {
				u.setImprechoObs(true);
			} else {
				u.setImprechoObs(false);
			}
			
			
			if (gynecologiePriv) {
				u.setGynecologie("1");
			} else {
				u.setGynecologie("0");
			}
			if (consultGrossPriv) {
				u.setConsultGros("1");
			} else {
				u.setConsultGros("0");
			}
			if (sterilitePriv) {
				u.setSterilite("1");
			} else {
				u.setSterilite("0");
			}
			if (steriliteModifPriv) {
				u.setModifSterilite(true);
			} else {
				u.setModifSterilite(false);
			}
			
			if (tabAntecedentPriv) {
				u.setTabAntecedent("1");
			} else {
				u.setTabAntecedent("0");
			}
			
			if(modifGynObsPriv){
				u.setModifGynObs(true);;
			}else{
				u.setModifGynObs(false);
			}
			if(modifAntPriv){
				u.setModifAnt(true);;
			}else{
				u.setModifAnt(false);
			}
			if(suppAntPriv){
				u.setSuppAnt(true);
			}else{
				u.setSuppAnt(false);
			}
			
			if (tabGynecoObsPriv) {
				u.setTabGynecoObs("1");
			} else {
				u.setTabGynecoObs("0");
			}
			if (tabHistGrossPriv) {
				u.setTabHistGross("1");
			} else {
				u.setTabHistGross("0");
			}
			if (tabContracepPriv) {
				u.setTabContraception("1");
			} else {
				u.setTabContraception("0");
			}
			if (nouvGrossPriv) {
				u.setNouvGross("1");
			} else {
				u.setNouvGross("0");
			}
			if (nouvContracepPriv) {
				u.setNouvContraception("1");
			} else {
				u.setNouvContraception("0");
			}
			if (modifHistGrossPriv) {
				u.setModifHistGross("1");
			} else {
				u.setModifHistGross("0");
			}
			if (supHistGrossPriv) {
				u.setSupHistGross("1");
			} else {
				u.setSupHistGross("0");
			}
			if (modifContracepPriv) {
				u.setModifContraception("1");
			} else {
				u.setModifContraception("0");
			}
			if (supContacepPriv) {
				u.setSupConctraeption("1");
			} else {
				u.setSupConctraeption("0");
			}

			if (gynRadioPriv) {
				u.setGynRadio("1");
			} else {
				u.setGynRadio("0");
			}
			if (gynAnaPriv) {
				u.setGynAnal("1");
			} else {
				u.setGynAnal("0");
			}
			if (gynOrdPriv) {
				u.setGynOrd("1");
			} else {
				u.setGynOrd("0");
			}
			
			if (consultDetAnalPriv) {
				u.setConsultDetAnal(true);
			} else {
				u.setConsultDetAnal(false);
			}
			if (consultDetRadPriv) {
				u.setConsultDetRad(true);
			} else {
				u.setConsultDetRad(false);
			}
			if (consultDetOrdPriv) {
				u.setConsultDetOrd(true);
			} else {
				u.setConsultDetOrd(false);
			}
			
			
			if (gynNouvConsultPriv) {
				u.setNouvConsGyn("1");
			} else {
				u.setNouvConsGyn("0");
			}
			if(gynModifConsultPriv){
				u.setModifGyneco(true);
				
			}else{
				u.setModifGyneco(false);
			}
			if(gynSupConsultPriv){
				u.setSuppGyneco(true);
				
			}else{
				u.setSuppGyneco(false);
			}
			if(gynImprConsultPriv){
				u.setImprGyneco(true);
				
			}else{
				u.setImprGyneco(false);
			}
			
			if (grossOrdPriv) {
				u.setConsultGrossOrd("1");
			} else {
				u.setConsultGrossOrd("0");
			}
			if (grossSelectNouvConsultPriv) {
				u.setSelectNouvGross(true);
			} else {
				u.setSelectNouvGross(false);
			}
			if (grossModifConsultPriv) {
				u.setModifGross(true);
			} else {
				u.setModifGross(false);
			}
			if (grossSupvConsultPriv) {
				u.setSuppGross(true);
			} else {
				u.setSuppGross(false);
			}
			if (grossImprConsultPriv) {
				u.setImprGross(true);
			} else {
				u.setImprGross(false);
			}
			if (grossAnaPriv) {
				u.setConsultGrossAnal("1");
			} else {
				u.setConsultGrossAnal("0");
			}
			if (grossRadioPriv) {
				u.setConsultGrossRadio("1");
			} else {
				u.setConsultGrossRadio("0");
			}
			if (grossNouvConsultPriv) {
				u.setNouvConsGross("1");
			} else {
				u.setNouvConsGross("0");
			}

			ser.ajoutUtilisateur(u);
			
		/*	try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("GestionUtilisateur.xhtml");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}*/

			initialisation();
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Utilisateur ajouté avec succès",
					"Invalid credentials"));
			redirectvergestUtl();
		}
		
		

	}
	
public void redirectvergestUtl(){
		
		FacesContext context2 = FacesContext.getCurrentInstance();
	    context2.getExternalContext().getFlash().setKeepMessages(true);
	    try {
	     context2.getExternalContext().redirect("Utilisateurs");
	    }catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	/*public void redirectverGestUtl(){
		
		
		FacesContext context2 = FacesContext.getCurrentInstance();
		
		try {
			System.out.println("**********************");
		     context2.getExternalContext().redirect("GestionUtilisateur.xhtml");
		    }catch(Exception e){
				System.out.println(e.getMessage());
			}
			
	}*/
	

	public void modifierUtilisateur() {
		FacesContext face = FacesContext.getCurrentInstance();

		UtilisateurService utlser = new UtilisateurService();
		List<Utilisateur> utlBylog = utlser.rechercheUtilisateurByLogin(login);
//		List<Utilisateur> utlBymotPss = utlser
//				.rechercheUtilisateurByMotPass(motPasse);

		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = true;
		if (email != null && email.trim().length() > 0)
			b = email.matches(EMAIL_REGEX);

		if (login == null || (login.trim().length() == 0)) {// tester// si //
															// login // est //
															// vide

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login vide", "Invalid credentials"));
		} else if ((utlBylog.size() > 0)
				&& (! utlBylog.get(0).getIdutilisateur().equals(idUtilisateur) ) ) {

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login existe déja", "Invalid credentials"));
		}

		if (motPasse == null || (motPasse.trim().length() == 0)) {// tester// si
																	// //
																	// motPasse
																	// // est //
																	// vide

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Mot de Passe vide", "Invalid credentials"));
		}

		if ((nom == null || (nom.trim().length() == 0))
				&& (prenom == null || (prenom.trim().length() == 0))) {// tester//
																		// si //
																		// motPasse
																		// //
																		// est
																		// //
																		// vide

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Non et Prenom vide", "Invalid credentials"));
		}

		if (!b) {

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Format email invalide", "Invalid credentials"));

		}

		if (face.getMessageList().size() == 0) {


			UtilisateurService ser = new UtilisateurService();
			Utilisateur u = ser.rechercheUtilisateur(idUtilisateur);
			if (u != null) {

				SimpleDateFormat formatDateJava = new SimpleDateFormat(
						"dd/MM/yyyy");
				if (dateNais != null)
					date_naiss = formatDateJava.format(dateNais);

				u.setNom(nom);
				u.setPrenom(prenom);
				u.setLogin(login);
				u.setMotPasse(motPasse);
				u.setAdresse(adresse);
				u.setCivil(civil);
				u.setDate_naiss(date_naiss);
				u.setEmail(email);
				u.setTel(tel);

				if (gestExmCompPriv) {
					u.setGestExmComp("1");
				} else {
					u.setGestExmComp("0");
				}
				if (ajoutExmCompPriv) {
					u.setAjoutExmComp(true);
					;
				} else {
					u.setAjoutExmComp(false);
				}
				if (modifExmCompPriv) {
					u.setModifExmComp(true);
					;
				} else {
					u.setModifExmComp(false);
				}

				if (supExmCompPriv) {
					u.setSupExmComp(true);
				} else {
					u.setSupExmComp(false);
				}

				if (gestSymPriv) {
					u.setGestSyn("1");
				} else {
					u.setGestSyn("0");
				}
				if (ajoutSymPriv) {
					u.setAjoutAsym(true);
					;
				} else {
					u.setAjoutAsym(false);
				}
				if (modifSymPriv) {
					u.setModifAsym(true);
					;
				} else {
					u.setModifAsym(false);
				}

				if (supSymPriv) {
					u.setSupAsym(true);
				} else {
					u.setSupAsym(false);
				}

				if (gestDiagPriv) {
					u.setGestDiag("1");
				} else {
					u.setGestDiag("0");
				}
				if (ajoutDiagPriv) {
					u.setAjoutDiag(true);
					;
				} else {
					u.setAjoutDiag(false);
				}
				if (modifDiagPriv) {
					u.setModifDiag(true);
					;
				} else {
					u.setModifDiag(false);
				}

				if (supDiagPriv) {
					u.setSupDiag(true);
				} else {
					u.setSupDiag(false);
				}

				if (gestMoyCtrPriv) {
					u.setGestMoyCtrcep("1");
				} else {
					u.setGestMoyCtrcep("0");
				}
				if (ajoutMoyCtrPriv) {
					u.setAjoutMoyCtr(true);
					;
				} else {
					u.setAjoutMoyCtr(false);
				}
				if (modifMoyCtrPriv) {
					u.setModifMoyCtr(true);
					;
				} else {
					u.setModifMoyCtr(false);
				}

				if (supMoyCtrPriv) {
					u.setSupMoyCtr(true);
				} else {
					u.setSupMoyCtr(false);
				}

				if (gestExmPriv) {
					u.setGestExm("1");
				} else {
					u.setGestExm("0");
				}
				if (ajoutExmPriv) {
					u.setAjoutExm(true);
					;
				} else {
					u.setAjoutExm(false);
				}
				if (modifExmPriv) {
					u.setModifExm(true);
					;
				} else {
					u.setModifExm(false);
				}

				if (supExmPriv) {
					u.setSupExm(true);
				} else {
					u.setSupExm(false);
				}
				
				if(gestJrFerParamPriv){
					u.setGestionJourFr(true);
				}else{
					u.setGestionJourFr(false);
				}
				if(paramtabJrFerPriv){
					u.setTabFerie(true);
				}else{
					u.setTabFerie(false);
				}
				if(ajouJrFerStndPriv){
					u.setNouvJFerie(true);
				}else{
					u.setNouvJFerie(false);
				}
				if(modifJrFerStndPriv){
					u.setModifJFerie(true);
				}else{
					u.setModifJFerie(false);
				}
				if(supJrFerStndPriv){
					u.setSuppJFerie(true);
				}else{
					u.setSuppJFerie(false);
				}
				if(paramtabJrFerExpPriv){
					u.setTabJFerieExp(true);
				}else{
					u.setTabJFerieExp(false);
				}
				if(ajouJrFerExpPriv){
					u.setNouvJFerieExp(true);
				}else{
					u.setNouvJFerieExp(false);
				}
				if(modifJrFerExpPriv){
					u.setModifJFerieExp(true);
				}else{
					u.setModifJFerieExp(false);
				}
				if(supJrFerExpPriv){
					u.setSuppJFerieExp(true);
				}else{
					u.setSuppJFerieExp(false);
				}
				

				if (gestMedPriv) {
					u.setGestMed("1");
				} else {
					u.setGestMed("0");
				}
				if (ajoutMedPriv) {
					u.setAjoutMed(true);
					;
				} else {
					u.setAjoutMed(false);
				}
				if (modifMedPriv) {
					u.setModifMed(true);
					;
				} else {
					u.setModifMed(false);
				}

				if (supMedPriv) {
					u.setSupMed(true);
				} else {
					u.setSupMed(false);
				}

				if (gestAnalPriv) {
					u.setGestAnal("1");
				} else {
					u.setGestAnal("0");
				}
				if (ajoutAnalPriv) {
					u.setAjoutAnal(true);
					;
				} else {
					u.setAjoutAnal(false);
				}
				if (modifAnalPriv) {
					u.setModifAnal(true);
					;
				} else {
					u.setModifAnal(false);
				}

				if (supAnalPriv) {
					u.setSupAnal(true);
					
				} else {
					u.setSupAnal(false);
				}

				if (gestEtBbPriv) {
					u.setGestBb("1");
				} else {
					u.setGestBb("0");
				}
				if (ajoutEtBbPriv) {
					u.setAjoutEtBb(true);
					
				} else {
					u.setAjoutEtBb(false);
				}
				if (modifEtBbPriv) {
					u.setModifEtBb(true);
					
				} else {
					u.setModifEtBb(false);
				}

				if (supEtBbPriv) {
					u.setSupEtBb(true);
					
				} else {
					u.setSupEtBb(false);
				}

				if (certifFichePriv) {
					u.setCertifFiche("1");
				} else {
					u.setCertifFiche("0");
				}
				if (ajoutCertifPriv) {
					u.setNouvCertif(true);
				} else {
					u.setNouvCertif(false);
				}
				if (modifCertifPriv) {
					u.setModifCertif(true);
				} else {
					u.setModifCertif(false);
				}
				if (supCertifPriv) {
					u.setSuppCertif(true);
				} else {
					u.setSuppCertif(false);
				}
				if (impCertifPriv) {
					u.setImprCertif(true);
				} else {
					u.setImprCertif(false);
				}
					
				
				if (lettreFichePriv) {
					u.setLettreFiche("1");
				} else {
					u.setLettreFiche("0");
				}
				if(ajoutLtrPriv){
					u.setNouvLettre(true);
				}else{
					u.setNouvLettre(false);
				}
				if(modifLtrPriv){
					u.setModifLettre(true);
				}else{
					u.setModifLettre(false);
				}
				if(supLtrPriv){
					u.setSuppLettre(true);
				}else{
					u.setSuppLettre(false);
				}
				if(impLtrPriv){
					u.setImprLettre(true);
				}else{
					u.setImprLettre(false);
				}
				

				if (analyseFichePriv) {
					u.setAnalyseFiche("1");
				} else {
					u.setAnalyseFiche("0");
				}
				if (modifHistoAnalPriv) {
					u.setModifAnalyse(true);
				} else {
					u.setModifAnalyse(false);
				}
				if (consultHistoAnalPriv) {
					u.setDetHistoAnal(true);
				} else {
					u.setDetHistoAnal(false);
				}
				
				if (supHistoAnalPriv) {
					u.setSupAnalyse(true);
				} else {
					u.setSupAnalyse(false);
				}
				
				
				if (radioFichePriv) {
					u.setRadioFiche("1");
				} else {
					u.setRadioFiche("0");
				}
				if(modifHistoRadPriv){
					u.setModifRadio(true);
				}else{
					u.setModifRadio(false);
				}
				if(consultHistoRadPriv){
					u.setDetHistoRad(true);
				}else{
					u.setDetHistoRad(false);
				}
				if(supHistoRadPriv){
					u.setSupRadio(true);
				}else{
					u.setSupRadio(false);
				}
				if(imprAnalPriv){
					u.setImprmAnal(true);
				}else{
					u.setImprmAnal(false);
				}
				
				if(imprRadioPriv){
					u.setImprRadio(true);
				}else{
					u.setImprRadio(false);
				}
				
				
				if (rapportFichePriv) {
					u.setRapportFiche("1");
				} else {
					u.setRapportFiche("0");
				}
				if(ajoutModeleordPriv){
					u.setAjoutModeleord(true);
				}else{
					u.setAjoutModeleord(false);
				}
				if(selectModeleordPriv){
					u.setSelectModeleord(true);
				}else{
					u.setSelectModeleord(false);
				}
				if(suppModeleOrdPriv){
					u.setSuppModeleOrd(true);
				}else{
					u.setSuppModeleOrd(false);
				}
				
				if(gestSaisPriv){
					u.setGestSais(true);
				}else{
					u.setGestSais(false);
				}
				
				if(consultertHistoConsultationPriv){
					u.setSelectTableConsultation(true);
				}else{
					u.setSelectTableConsultation(false);
				}
				
				if (ordonceFichePriv) {
					u.setOrdnanceFiche("1");
				} else {
					u.setOrdnanceFiche("0");
				}
				if(consultOrdLibrePriv){
					u.setOrdonanceLibreFiche(true);
				}else{
					u.setOrdonanceLibreFiche(false);
				}
				if(modifHistoOrdPriv){
					u.setModifOrdnce(true);
				}else{
					u.setModifOrdnce(false);
				}
				if(supHistoOrdPriv){
					u.setSupphistoOrd(true);
				}else{
					u.setSupphistoOrd(false);
				}
				if(rechercheOrdPriv){
					u.setRechercheOrd(true);
				}else{
					u.setRechercheOrd(false);
				}
				if(imprOrdPriv){
					u.setImprOrd(true);
				}else{
					u.setImprOrd(false);
				}
				
			

				if (verConsultPriv) {
					u.setVerConsult("1");
				} else {
					u.setVerConsult("0");
				}
				if (menuSalPriv) {
					u.setMenuSal("1");
				} else {
					u.setMenuSal("0");
				}

				if (menuGesPatPriv) {
					u.setMenuGestPat("1");
				} else {
					u.setMenuGestPat("0");
				}

				if (menuParamPriv) {
					u.setMenuParametre("1");
				} else {
					u.setMenuParametre("0");
				}
				if(menuRendvousPriv){
					u.setMenuGestRdv("1");
				}else{
					u.setMenuGestRdv("0");
				}
				
				if (menuStatPriv) {
					u.setMenuGestStat(true);
				} else {
					u.setMenuGestStat(false);
				}

				if (menuRappPriv) {
					u.setMenuRapport("1");
				} else {
					u.setMenuRapport("0");
				}
				

				if (menuGesUtlPriv) {
					u.setMenuGestUtl("1");
				} else {
					u.setMenuGestUtl("0");
				}

				if (ajouPatPriv) {
					u.setAjoutPatient("1");
				} else {
					u.setAjoutPatient("0");
				}

				if (verSalPriv) {
					u.setVerSal("1");
				} else {
					u.setVerSal("0");
				}

				if (modifPatPriv) {
					u.setModPatient("1");
				} else {
					u.setModPatient("0");
				}

				if (detPatPriv) {
					u.setDetPatient("1");
				} else {
					u.setDetPatient("0");
				}

				if (chargPatPriv) {
					u.setChargPatient("1");
				} else {
					u.setChargPatient("0");
				}

				if (suppPatPriv) {
					u.setSupPatient("1");
				} else {
					u.setSupPatient("0");
				}

				if (tabInfGnrAjtPatPriv) {
					u.setTabInfGenAjoutPat("1");
				} else {
					u.setTabInfGenAjoutPat("0");
				}

				

				if (tabContctPatPriv) {
					u.setTabCntctAjoutPat("1");
				} else {
					u.setTabCntctAjoutPat("0");
				}

				if (tabInfoConjAjtPatPriv) {
					u.setTabInfoConjAjoutPat("1");
				} else {
					u.setTabInfoConjAjoutPat("0");
				}

				if (tabAtreInfAjtPatPriv) {
					u.setTabAutreInfAjoutPat("1");
				} else {
					u.setTabAutreInfAjoutPat("0");
				}

				if (gestDocPriv) {
					u.setGestDoc("1");
				} else {
					u.setGestDoc("0");
				}
				
				if (gestAntecedentParamPriv) {
					u.setGestAntecedent(true);
				} else {
					u.setGestAntecedent(false);
				}
				if (paramtabAntMedPriv) {
					u.setTabMedAnt(true);
				} else {
					u.setTabMedAnt(false);
				}
				if (ajoutAntMedPriv) {
					u.setAjoutGestAntMed(true);
				} else {
					u.setAjoutGestAntMed(false);
				}
				if (modifAntMedPriv) {
					u.setModifGestAntMed(true);
				} else {
					u.setModifGestAntMed(false);
				}
				if (supAntMedPriv) {
					u.setSuppGestAntMed(true);
				} else {
					u.setSuppGestAntMed(false);
				}
				if (paramtabAntChirgPriv) {
					u.setTabChirAnt(true);
				} else {
					u.setTabChirAnt(false);
				}
				if (ajoutAntChirgPriv) {
					u.setAjoutGestChirg(true);
				} else {
					u.setAjoutGestChirg(false);
				}
				if (modifAntChirgPriv) {
					u.setModifGestChirg(true);
				} else {
					u.setModifGestChirg(false);
				}
				if (supAntChirgPriv) {
					u.setSuppGestAntChirg(true);
				} else {
					u.setSuppGestAntChirg(false);
				}
				
				if (paramtabAntFamPriv) {
					u.setTabFamAnt(true);
				} else {
					u.setTabFamAnt(false);
				}
				if (ajoutAntFamPriv) {
					u.setAjoutGestFam(true);
				} else {
					u.setAjoutGestFam(false);
				}
				if (modifAntFamPriv) {
					u.setModifGestFam(true);
				} else {
					u.setModifGestFam(false);
				}
				if (supAntFamPriv) {
					u.setSuppGestAntFam(true);
				} else {
					u.setSuppGestAntFam(false);
				}
				
				if (gestHorairePriv) {
					u.setGestHoraire(true);
				} else {
					u.setGestHoraire(false);
				}
				if (modifprdSaisPriv) {
					u.setModifPrtSais(true);
				} else {
					u.setModifPrtSais(false);
				}
				if (ajoutHorTravPriv) {
					u.setAjoutHeurTrav(true);
				} else {
					u.setAjoutHeurTrav(false);
				}
				if (modifHorTravPriv) {
					u.setModifHeurTrav(true);
				} else {
					u.setModifHeurTrav(false);
				}
				if (supHorTravPriv) {
					u.setSupHeurTrav(true);
				} else {
					u.setSupHeurTrav(false);
				}
				
				
				if(gestCabinetPriv){
					u.setGestCabinet(true);
				}else{
					u.setGestCabinet(false);
				}
				
				if (gestUtPriv) {
					u.setGestionUterus(true);
				} else {
					u.setGestionUterus(false);
				}
				if (ajoutUtPriv) {
					u.setAjoutUt(true);
				} else {
					u.setAjoutUt(false);
				}
				if (modifUtPriv) {
					u.setModifUt(true);
				} else {
					u.setModifUt(false);
				}
				if (supUtPriv) {
					u.setSupUt(true);
				} else {
					u.setSupUt(false);
				}
				
				if (gestFinGrossPriv) {
					u.setGestEFG("1");
				} else {
					u.setGestEFG("0");
				}
				if (ajoutFinGrossPriv) {
					u.setAjoutEFG(true);
				} else {
					u.setAjoutEFG(false);
				}
				if (modifFinGrossPriv) {
					u.setModifEFG(true);
				} else {
					u.setModifEFG(false);
				}
				if (supFinGrossPriv) {
					u.setSupEFG(true);
				} else {
					u.setSupEFG(false);
				}
				if (gestConsPriv) {
					u.setGestConsultation(true);
				} else {
					u.setGestConsultation(false);
				}
				if (modifConsPriv) {
					u.setModifCons(true);
				} else {
					u.setModifCons(false);
				}
				
				if (gestFrmMedPriv) {
					u.setGestionFormMed(true);
				} else {
					u.setGestionFormMed(false);
				}
				if (ajoutFrmMedPriv) {
					u.setAjoutFM(true);
				} else {
					u.setAjoutFM(false);
				}
				if (modifFrmMedPriv) {
					u.setModifFM(true);
				} else {
					u.setModifFM(false);
				}
				if (supFrmMedPriv) {
					u.setSupFM(true);
				} else {
					u.setSupFM(false);
				}

				if (gestProfPriv) {
					u.setGestProf("1");
				} else {
					u.setGestProf("0");
				}

				if (gestVilPriv) {
					u.setGestVil("1");
				} else {
					u.setGestVil("0");
				}

				if (gestCliPriv) {
					u.setGestClin("1");
				} else {
					u.setGestClin("0");
				}

				if (rappCertifPriv) {
					u.setRappCertif("1");
				} else {
					u.setRappCertif("0");
				}
				if (rappOrdncePriv) {
					u.setRappOrdnce("1");
				} else {
					u.setRappOrdnce("0");
				}
				if (rappLettrePriv) {
					u.setRappLettre("1");
				} else {
					u.setRappLettre("0");
				}

				if (montPatSalPriv) {
					u.setMonterPatSal("1");
				} else {
					u.setMonterPatSal("0");
				}
				if (descdrePatSalPriv) {
					u.setDesdrePatSal("1");
				} else {
					u.setDesdrePatSal("0");
				}
				if (permutPatSalPriv) {
					u.setPermutPatSal("1");
				} else {
					u.setPermutPatSal("0");
				}
				if (premierPatSalPriv) {
					u.setPremierPatSal("1");
				} else {
					u.setPremierPatSal("0");
				}
				if (dernierSalPriv) {
					u.setDernierPatSal("1");
				} else {
					u.setDernierPatSal("0");
				}
				if (supPatSalPriv) {
					u.setSupPatSal("1");
				} else {
					u.setSupPatSal("0");
				}
				if (chargPatSalPriv) {
					u.setChargPatSal("1");
				} else {
					u.setChargPatSal("0");
				}
				if (modifNoteSalPriv) {
					u.setModifNoteSal(true);
				} else {
					u.setModifNoteSal(false);
				}
				if (reponseSalPriv) {
					u.setReponseSal(true);
				} else {
					u.setReponseSal(false);
				}
				if (tabAnulSalPriv) {
					u.setTabAnulSal(true);
				} else {
					u.setTabAnulSal(false);
				}
				if (anulSalPriv) {
					u.setAnulSal(true);
				} else {
					u.setAnulSal(false);
				}
				if (donnerRdvPriv) {
					u.setDonnerRdv(true);
				} else {
					u.setDonnerRdv(false);
				}
				if (archiverPatPriv) {
					u.setArchiverPat(true);
				} else {
					u.setArchiverPat(false);
				}
				if (consultArchivePriv) {
					u.setConsultArchiv(true);
				} else {
					u.setConsultArchiv(false);
				}
				
				if (ajoutClinPriv) {
					u.setAjoutClin("1");
				} else {
					u.setAjoutClin("0");
				}
				if (modifClinPriv) {
					u.setModifClin("1");
				} else {
					u.setModifClin("0");
				}
				if (supClinPriv) {
					u.setSupClin("1");
				} else {
					u.setSupClin("0");
				}
				if (ajoutDocPriv) {
					u.setAjoutDoc("1");
				} else {
					u.setAjoutDoc("0");
				}
				if (modifDocPriv) {
					u.setModifDoc("1");
				} else {
					u.setModifDoc("0");
				}
				if (supDocPriv) {
					u.setSupDoc("1");
				} else {
					u.setSupDoc("0");
				}
				if (ajoutProfPriv) {
					u.setAjoutProf("1");
				} else {
					u.setAjoutProf("0");
				}
				if (modifProfPriv) {
					u.setModifProf("1");
				} else {
					u.setModifProf("0");
				}
				if (supProfPriv) {
					u.setSupProf("1");
				} else {
					u.setSupProf("0");
				}
				if (ajoutVilPriv) {
					u.setAjoutVil("1");
				} else {
					u.setAjoutVil("0");
				}
				if (modifVilPriv) {
					u.setModifVil("1");
				} else {
					u.setModifVil("0");
				}
				if (supVilPriv) {
					u.setSupVil("1");
				} else {
					u.setSupVil("0");
				}
				if (antecedentPriv) {
					u.setAntecedent("1");
				} else {
					u.setAntecedent("0");
				}
				if (echoGynPriv) {
					u.setEchoGyn("1");
				} else {
					u.setEchoGyn("0");
				}
				if (echoGynNouvConsultPriv) {
					u.setNouvchogyneco(true);
				} else {
					u.setNouvchogyneco(false);
				}
				if (echoGynModifConsultPriv) {
					u.setModifechogyneco(true);
				} else {
					u.setModifechogyneco(false);
				}
				if(echoGynsupConsultPriv){
					u.setSuppechogyneco(true);
				}else{
					u.setSuppechogyneco(false);
				}
				if(echoGynNouvModeltPriv){
					u.setAjoutmodelechogyneco(true);;
				}else{
					u.setAjoutmodelechogyneco(false);
				}
                 
				if(echoGynSupModeltPriv){
					u.setSuppmodelechogyneco(true);
				}else{
					u.setSuppmodelechogyneco(false);
				}
				
				if(echoGynApplModeltPriv){
					u.setAppliquemodelechogyneco(true);
				}else{
					u.setAppliquemodelechogyneco(false);
				}
				if(echoGynImprPriv){
					u.setImprechogyneco(true);
				}else{
					u.setImprechogyneco(false);
				}
				
				if (echoObstPriv) {
					u.setEchoObs("1");
				} else {
					u.setEchoObs("0");
				}
				if (echoObsNouvConsultPriv) {
					u.setNouvechoObs(true);
				} else {
					u.setNouvechoObs(false);
				}
				if (echoObsModifConsultPriv) {
					u.setModifechoObs(true);
				} else {
					u.setModifechoObs(false);
				}
				
				if (echoObsSupConsultPriv) {
					u.setSuppechoObs(true);
				} else {
					u.setSuppechoObs(false);
				}
				if (echoObsTrim1Priv) {
					u.setTrim1echoObs(true);
				} else {
					u.setTrim1echoObs(false);
				}
				if (echoObsTrim2Priv) {
					u.setTrim2echoObs(true);
				} else {
					u.setTrim2echoObs(false);
				}
				
				if (echoObsTrim3Priv) {
					u.setTrim3echoObs(true);
				} else {
					u.setTrim3echoObs(false);
				}
				if (echoObsImprPriv) {
					u.setImprechoObs(true);
				} else {
					u.setImprechoObs(false);
				}
				
				if (gynecologiePriv) {
					u.setGynecologie("1");
				} else {
					u.setGynecologie("0");
				}
				if (consultGrossPriv) {
					u.setConsultGros("1");
				} else {
					u.setConsultGros("0");
				}
				if (sterilitePriv) {
					u.setSterilite("1");
				} else {
					u.setSterilite("0");
				}
				if (steriliteModifPriv) {
					u.setModifSterilite(true);
				} else {
					u.setModifSterilite(false);
				}
				if (tabAntecedentPriv) {
					u.setTabAntecedent("1");
				} else {
					u.setTabAntecedent("0");
				}
				
				if(modifGynObsPriv){
					u.setModifGynObs(true);;
				}else{
					u.setModifGynObs(false);
				}
				if(modifAntPriv){
					u.setModifAnt(true);;
				}else{
					u.setModifAnt(false);
				}
				if(suppAntPriv){
					u.setSuppAnt(true);
				}else{
					u.setSuppAnt(false);
				}
				if (tabGynecoObsPriv) {
					u.setTabGynecoObs("1");
				} else {
					u.setTabGynecoObs("0");
				}
				if (tabHistGrossPriv) {
					u.setTabHistGross("1");
				} else {
					u.setTabHistGross("0");
				}
				if (tabContracepPriv) {
					u.setTabContraception("1");
				} else {
					u.setTabContraception("0");
				}
				if (nouvGrossPriv) {
					u.setNouvGross("1");
				} else {
					u.setNouvGross("0");
				}
				if (nouvContracepPriv) {
					u.setNouvContraception("1");
				} else {
					u.setNouvContraception("0");
				}
				if (modifHistGrossPriv) {
					u.setModifHistGross("1");
				} else {
					u.setModifHistGross("0");
				}
				if (supHistGrossPriv) {
					u.setSupHistGross("1");
				} else {
					u.setSupHistGross("0");
				}
				if (modifContracepPriv) {
					u.setModifContraception("1");
				} else {
					u.setModifContraception("0");
				}
				if (supContacepPriv) {
					u.setSupConctraeption("1");
				} else {
					u.setSupConctraeption("0");
				}
				if (gynRadioPriv) {
					u.setGynRadio("1");
				} else {
					u.setGynRadio("0");
				}
				if (gynAnaPriv) {
					u.setGynAnal("1");
				} else {
					u.setGynAnal("0");
				}
				if (gynOrdPriv) {
					u.setGynOrd("1");
				} else {
					u.setGynOrd("0");
				}
				
				if (consultDetAnalPriv) {
					u.setConsultDetAnal(true);
				} else {
					u.setConsultDetAnal(false);
				}
				if (consultDetRadPriv) {
					u.setConsultDetRad(true);
				} else {
					u.setConsultDetRad(false);
				}
				if (consultDetOrdPriv) {
					u.setConsultDetOrd(true);
				} else {
					u.setConsultDetOrd(false);
				}
				
				if (gynNouvConsultPriv) {
					u.setNouvConsGyn("1");
				} else {
					u.setNouvConsGyn("0");
				}
				if(gynModifConsultPriv){
					u.setModifGyneco(true);
					
				}else{
					u.setModifGyneco(false);
				}
				
				if(gynSupConsultPriv){
					u.setSuppGyneco(true);
					
				}else{
					u.setSuppGyneco(false);
				}
				if(gynImprConsultPriv){
					u.setImprGyneco(true);
					
				}else{
					u.setImprGyneco(false);
				}
				if (grossOrdPriv) {
					u.setConsultGrossOrd("1");
				} else {
					u.setConsultGrossOrd("0");
				}
				if (grossSelectNouvConsultPriv) {
					u.setSelectNouvGross(true);
				} else {
					u.setSelectNouvGross(false);
				}
				if (grossModifConsultPriv) {
					u.setModifGross(true);
				} else {
					u.setModifGross(false);
				}
				if (grossSupvConsultPriv) {
					u.setSuppGross(true);
				} else {
					u.setSuppGross(false);
				}
				if (grossImprConsultPriv) {
					u.setImprGross(true);
				} else {
					u.setImprGross(false);
				}
				if (grossAnaPriv) {
					u.setConsultGrossAnal("1");
				} else {
					u.setConsultGrossAnal("0");
				}
				if (grossRadioPriv) {
					u.setConsultGrossRadio("1");
				} else {
					u.setConsultGrossRadio("0");
				}
				if (grossNouvConsultPriv) {
					u.setNouvConsGross("1");
				} else {
					u.setNouvConsGross("0");
				}

				ser.modifierUtilisateur(u);

				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Utilisateur modifié avec succés",""));

                initialisation();
				
				redirectvergestUtl();

			}
		}
		}
	

	public void modifUtilisateur(Utilisateur u) {
		recupererDonnees(u);
		
		nomModelUtl=null;
		idmodelUtl=null;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("ModifierUtilisateur");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void recupererDonnees(Utilisateur u) {

		
		index=0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		date_naiss = u.getDate_naiss();
		try {

			if (date_naiss != null && !date_naiss.equals(""))
				dateNais = formatter.parse(date_naiss);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		idUtilisateur = u.getIdutilisateur();
		nom = u.getNom();
		prenom = u.getPrenom();
		login = u.getLogin();
		motPasse = u.getMotPasse();

		civil = u.getCivil();
		tel = u.getTel();
		adresse = u.getAdresse();
		email = u.getEmail();

		gestExmComp = u.getGestExmComp();
		ajoutExmComp = u.isAjoutExmComp();
		modifExmComp = u.isModifExmComp();
		supExmComp = u.isSupExmComp();

		gestSym = u.getGestSyn();
		ajoutSym = u.isAjoutAsym();
		modifSym = u.isModifAsym();
		supSym = u.isSupAsym();

		gestDiag = u.getGestDiag();
		ajoutDiag = u.isAjoutDiag();
		modifDiag = u.isModifDiag();
		supDiag = u.isSupDiag();

		gestMoyCtr = u.getGestMoyCtrcep();
		ajoutMoyCtr = u.isAjoutMoyCtr();
		modifMoyCtr = u.isModifMoyCtr();
		supMoyCtr = u.isSupMoyCtr();

		gestExm = u.getGestExm();
		ajoutExm = u.isAjoutExm();
		modifExm = u.isModifExm();
		supExm = u.isSupExm();

		gestMed = u.getGestMed();
		ajoutMed = u.isAjoutMed();
		modifMed = u.isModifMed();
		supMed = u.isSupMed();

		gestEtbb = u.getGestBb();
		ajoutEtbb = u.isAjoutEtBb();
		modifEtbb = u.isModifEtBb();
		supEtbb = u.isSupEtBb();

		gestAnal = u.getGestAnal();
		ajoutAnal = u.isAjoutAnal();
		modifAnal = u.isModifAnal();
		supAnal = u.isSupAnal();

		verConsult = u.getVerConsult();
		nouvPatSal = u.getNouvPatSal();
		menuSal = u.getMenuSal();
		menuGestPat = u.getMenuGestPat();
		menuParametre = u.getMenuParametre();
		menuRapport = u.getMenuRapport();
		menuGestUtl = u.getMenuGestUtl();
		ajoutPatient = u.getAjoutPatient();
		verSal = u.getVerSal();
		;
		modPatient = u.getModPatient();
		detPatient = u.getDetPatient();
		chargPatient = u.getChargPatient();
		supPatient = u.getSupPatient();
		tabInfGenAjoutPat = u.getTabInfGenAjoutPat();

		tabCntctAjoutPat = u.getTabCntctAjoutPat();
		tabInfoConjAjoutPat = u.getTabInfoConjAjoutPat();
		tabAutreInfAjoutPat = u.getTabAutreInfAjoutPat();
		gestDoc = u.getGestDoc();
		gestProf = u.getGestProf();
		gestVil = u.getGestVil();
		gestClin = u.getGestClin();
		rappCertif = u.getRappCertif();
		rappOrdnce = u.getRappOrdnce();
		rappLettre = u.getRappLettre();
		monterPatSal = u.getMonterPatSal();
		desdrePatSal = u.getDesdrePatSal();
		permutPatSal = u.getPermutPatSal();
		premierPatSal = u.getPremierPatSal();
		dernierPatSal = u.getDernierPatSal();
		supPatSal = u.getSupPatSal();
		chargPatSal = u.getChargPatSal();
		antecedent = u.getAntecedent();

		ajoutDoc = u.getAjoutDoc();
		modifDoc = u.getModifDoc();
		supDoc = u.getSupDoc();
		ajoutClin = u.getAjoutClin();
		modifClin = u.getModifClin();
		supClin = u.getSupClin();
		ajoutProf = u.getAjoutProf();
		modifProf = u.getModifProf();
		supProf = u.getSupProf();
		ajoutVil = u.getAjoutVil();
		modifVil = u.getModifVil();
		supVil = u.getSupVil();

		echoGyn = u.getEchoGyn();
		echoObs = u.getEchoObs();
		gynecologie = u.getGynecologie();
		consultGros = u.getConsultGros();
		sterilite = u.getSterilite();

		tabAntecedent = u.getTabAntecedent();
		tabGynecoObs = u.getTabGynecoObs();
		tabHistGross = u.getTabHistGross();
		tabContraception = u.getTabContraception();
		supHistGross = u.getSupHistGross();
		modifHistGross = u.getModifHistGross();
		supConctraeption = u.getSupConctraeption();
		modifContraception = u.getModifContraception();
		nouvGross = u.getNouvGross();
		nouvContraception = u.getNouvContraception();

		gynRadio = u.getGynRadio();
		gynOrd = u.getGynOrd();
		gynAnal = u.getGynAnal();
		nouvConsGyn = u.getNouvConsGyn();

		grossAnal = u.getConsultGrossAnal();
		grossOrd = u.getConsultGrossOrd();
		grossRadio = u.getConsultGrossRadio();
		grossNouvCons = u.getNouvConsGross();

		certifFiche = u.getCertifFiche();
		lettreFiche = u.getLettreFiche();
		analyseFiche = u.getAnalyseFiche();
		radioFiche = u.getRadioFiche();
		rapportFiche = u.getRapportFiche();
		ordnanceFiche = u.getOrdnanceFiche();

		if (gestExmComp.equals("1")) {
			gestExmCompPriv = true;
		} else {
			gestExmCompPriv = false;
		}

		if (ajoutExmComp) {
			ajoutExmCompPriv = true;
		} else {
			ajoutExmCompPriv = false;
		}

		if (modifExmComp) {
			modifExmCompPriv = true;
		} else {
			modifSymPriv = false;
		}

		if (supExmComp) {
			supExmCompPriv = true;
		} else {
			supExmCompPriv = false;
		}

		if (gestSym.equals("1")) {
			gestSymPriv = true;
		} else {
			gestSymPriv = false;
		}

		if (ajoutSym) {
			ajoutSymPriv = true;
		} else {
			ajoutSymPriv = false;
		}

		if (modifSym) {
			modifSymPriv = true;
		} else {
			modifSymPriv = false;
		}

		if (supSym) {
			supSymPriv = true;
		} else {
			supSymPriv = false;
		}

		if (gestDiag.equals("1")) {
			gestDiagPriv = true;
		} else {
			gestDiagPriv = false;
		}

		if (ajoutDiag) {
			ajoutDiagPriv = true;
		} else {
			ajoutDiagPriv = false;
		}

		if (modifDiag) {
			modifDiagPriv = true;
		} else {
			modifDiagPriv = false;
		}

		if (supDiag) {
			supDiagPriv = true;
		} else {
			supDiagPriv = false;
		}

		if (gestMoyCtr.equals("1")) {
			gestMoyCtrPriv = true;
		} else {
			gestMoyCtrPriv = false;
		}

		if (ajoutMoyCtr) {
			ajoutMoyCtrPriv = true;
		} else {
			ajoutMoyCtrPriv = false;
		}

		if (modifMoyCtr) {
			modifMoyCtrPriv = true;
		} else {
			modifMoyCtrPriv = false;
		}

		if (supMoyCtr) {
			supMoyCtrPriv = true;
		} else {
			supMoyCtrPriv = false;
		}

		if (gestExm.equals("1")) {
			gestExmPriv = true;
		} else {
			gestExmPriv = false;
		}

		if (ajoutExm) {
			ajoutExmPriv = true;
		} else {
			ajoutExmPriv = false;
		}

		if (modifExm) {
			modifExmPriv = true;
		} else {
			modifExmPriv = false;
		}

		if (supExm) {
			supExmPriv = true;
		} else {
			supExmPriv = false;
		}
		
		if(u.isGestionJourFr()){
			gestJrFerParamPriv=true;
		}else{
			gestJrFerParamPriv=false;
		}
		if(u.isTabFerie()){
			paramtabJrFerPriv=true;
		}else{
			paramtabJrFerPriv=false;
		}
		if(u.isNouvJFerie()){
			ajouJrFerStndPriv=true;
		}else{
			ajouJrFerStndPriv=false;
		}
		if(u.isModifJFerie()){
			modifJrFerStndPriv=true;
		}else{
			modifJrFerStndPriv=false;
		}
		if(u.isSuppJFerie()){
			supJrFerStndPriv=true;
		}else{
			supJrFerStndPriv=false;
		}
		if(u.isTabJFerieExp()){
			paramtabJrFerExpPriv=true;
		}else{
			paramtabJrFerExpPriv=false;
		}
		if(u.isNouvJFerieExp()){
			ajouJrFerExpPriv=true;
		}else{
			ajouJrFerExpPriv=false;
		}
		if(u.isModifJFerieExp()){
			modifJrFerExpPriv=true;
		}else{
			modifJrFerExpPriv=false;
		}
		if(u.isSuppJFerieExp()){
			supJrFerExpPriv=true;
		}else{
			supJrFerExpPriv=false;
		}
		
		

		if (gestMed.equals("1")) {
			gestMedPriv = true;
		} else {
			gestMedPriv = false;
		}

		if (ajoutMed) {
			ajoutMedPriv = true;
		} else {
			ajoutMedPriv = false;
		}

		if (modifMed) {
			modifMedPriv = true;
		} else {
			modifMedPriv = false;
		}

		if (supMed) {
			supMedPriv = true;
		} else {
			supMedPriv = false;
		}

		if (gestAnal.equals("1")) {
			gestAnalPriv = true;
		} else {
			gestAnalPriv = false;
		}

		if (ajoutAnal) {
			ajoutAnalPriv = true;
		} else {
			ajoutAnalPriv = false;
		}

		if (modifAnal) {
			modifAnalPriv = true;
		} else {
			modifAnalPriv = false;
		}

		if (supAnal) {
			supAnalPriv = true;
		} else {
			supAnalPriv = false;
		}

		if (gestEtbb.equals("1")) {
			gestEtBbPriv = true;
		} else {
			gestEtBbPriv = false;
		}

		if (ajoutEtbb) {
			ajoutEtBbPriv = true;
		} else {
			ajoutEtBbPriv = false;
		}

		if (modifEtbb) {
			modifEtBbPriv = true;
		} else {
			modifEtBbPriv = false;
		}

		if (supEtbb) {
			supEtBbPriv = true;
		} else {
			supEtBbPriv = false;
		}

		if (certifFiche.equals("1")) {
			certifFichePriv = true;
		} else {
			certifFichePriv = false;
		}
		if(u.isNouvCertif()){
			ajoutCertifPriv=true;
		}else{
			ajoutCertifPriv=false;
		}
		if(u.isModifCertif()){
			modifCertifPriv=true;
		}else{
			modifCertifPriv=false;
		}
		if(u.isSuppCertif()){
			supCertifPriv=true;
		}else{
			supCertifPriv=false;
		}
		if(u.isImprCertif()){
			impCertifPriv=true;
		}else{
			impCertifPriv=false;
		}
		

		if (lettreFiche.equals("1")) {
			lettreFichePriv = true;
		} else {
			lettreFichePriv = false;
		}
		if(u.isNouvLettre()){
			ajoutLtrPriv=true;
		}else{
			ajoutLtrPriv=false;
		}
		if(u.isModifLettre()){
			modifLtrPriv=true;
		}else{
			modifLtrPriv=false;
		}
		if(u.isSuppLettre()){
			supLtrPriv=true;
		}else{
			supLtrPriv=false;
		}
		if(u.isImprLettre()){
			impLtrPriv=true;
		}else{
			impLtrPriv=false;
		}
		
		

		if (analyseFiche.equals("1")) {
			analyseFichePriv = true;
		} else {
			analyseFichePriv = false;
		}
		if(u.isModifAnalyse()){
			modifHistoAnalPriv=true;
		}else{
			modifHistoAnalPriv=false;
		}
		if(u.isDetHistoAnal()){
			consultHistoAnalPriv=true;
		}else{
			consultHistoAnalPriv=false;
		}
		
		if(u.isSupAnalyse()){
			supHistoAnalPriv=true;
		}else{
			supHistoAnalPriv=false;
		}
		
		
		
		if (radioFiche.equals("1")) {
			radioFichePriv = true;
		} else {
			radioFichePriv = false;
		}
		if(u.isModifRadio()){
			modifHistoRadPriv=true;
		}else{
			modifHistoRadPriv=false;
		}
		if(u.isDetHistoRad()){
			consultHistoRadPriv=true;
		}else{
			consultHistoRadPriv=false;
		}
		if(u.isSupRadio()){
			supHistoRadPriv=true;
		}else{
			supHistoRadPriv=false;
		}
		if(u.isImprmAnal()){
			imprAnalPriv=true;
		}else{
			imprAnalPriv=false;
		}
		if(u.isImprRadio()){
			imprRadioPriv=true;
		}else{
			imprRadioPriv=false;
		}
		
		
		
		if (rapportFiche.equals("1")) {
			rapportFichePriv = true;
		} else {
			rapportFichePriv = false;
		}
		
		if(u.isAjoutModeleord()){
			ajoutModeleordPriv=true;
		}else{
			ajoutModeleordPriv=false;
		}
		if(u.isSelectModeleord()){
			selectModeleordPriv=true;
		}else{
			selectModeleordPriv=false;
		}
		if(u.isSuppModeleOrd()){
			suppModeleOrdPriv=true;
		}else{
			suppModeleOrdPriv=false;
		}
		
		if(u.isGestSais()){
			gestSaisPriv=true;
		}else{
			gestSaisPriv=false;
		}
		
		if(u.isSelectTableConsultation()){
			consultertHistoConsultationPriv=true;
		}else{
			consultertHistoConsultationPriv=false;
		}

		if (ordnanceFiche.equals("1")) {
			ordonceFichePriv = true;
		} else {
			ordonceFichePriv = false;
		}
		if(u.isOrdonanceLibreFiche()){
			consultOrdLibrePriv=true;
		}else{
			consultOrdLibrePriv=false;
		}
		if(u.isModifOrdnce()){
			modifHistoOrdPriv=true;
		}else{
			modifHistoOrdPriv=false;
		}
		if(u.isSupphistoOrd()){
			supHistoOrdPriv=true;
		}else{
			supHistoOrdPriv=false;
		}
		if(u.isRechercheOrd()){
			rechercheOrdPriv=true;
		}else{
			rechercheOrdPriv=false;
		}
		if(u.isImprOrd()){
			imprOrdPriv=true;
		}else{
			imprOrdPriv=false;
		}
		
		
		
		if (verConsult.equals("1")) {
			verConsultPriv = true;
		} else {
			verConsultPriv = false;
		}
		

		if (menuSal.equals("1")) {
			menuSalPriv = true;
		} else {
			menuSalPriv = false;
		}

		if (menuGestPat.equals("1")) {
			menuGesPatPriv = true;
		} else {
			menuGesPatPriv = false;
		}

		if (menuGestUtl.equals("1")) {
			menuGesUtlPriv = true;
		} else {
			menuGesUtlPriv = false;
		}

		if (menuParametre.equals("1")) {
			menuParamPriv = true;
		} else {
			menuParamPriv = false;
		}
		
		if(u.getMenuGestRdv().equals("1")){
			menuRendvousPriv=true;
		}else{
			menuRendvousPriv=false;
		}

		if (menuRapport.equals("1")) {
			menuRappPriv = true;
		} else {
			menuRappPriv = false;
		}
		
		if (u.isMenuGestStat()) {
			menuStatPriv = true;
		} else {
			menuStatPriv = false;
		}

		if (ajoutPatient.equals("1")) {
			ajouPatPriv = true;
		} else {
			ajouPatPriv = false;
		}

		if (verSal.equals("1")) {
			verSalPriv = true;
		} else {
			verSalPriv = false;
		}

		if (modPatient.equals("1")) {
			modifPatPriv = true;
		} else {
			modifPatPriv = false;
		}

		if (detPatient.equals("1")) {
			detPatPriv = true;
		} else {
			detPatPriv = false;
		}

		if (chargPatient.equals("1")) {
			chargPatPriv = true;
		} else {
			chargPatPriv = false;
		}

		if (supPatient.equals("1")) {
			suppPatPriv = true;
		} else {
			suppPatPriv = false;
		}

		if (tabInfGenAjoutPat.equals("1")) {
			tabInfGnrAjtPatPriv = true;
		} else {
			tabInfGnrAjtPatPriv = false;
		}

		if (tabCntctAjoutPat.equals("1")) {
			tabContctPatPriv = true;
		} else {
			tabContctPatPriv = false;
		}

		if (tabInfoConjAjoutPat.equals("1")) {
			tabInfoConjAjtPatPriv = true;
		} else {
			tabInfoConjAjtPatPriv = false;
		}
		if (tabAutreInfAjoutPat.equals("1")) {
			tabAtreInfAjtPatPriv = true;
		} else {
			tabAtreInfAjtPatPriv = false;
		}

		if (gestDoc.equals("1")) {
			gestDocPriv = true;
		} else {
			gestDocPriv = false;
		}
		
		if(u.isGestAntecedent()){
			gestAntecedentParamPriv=true;
		}else{
			gestAntecedentParamPriv=false;
		}
		if(u.isTabMedAnt()){
			paramtabAntMedPriv=true;
		}else{
			paramtabAntMedPriv=false;
		}
		
		if(u.isAjoutGestAntMed()){
			ajoutAntMedPriv=true;
		}else{
			ajoutAntMedPriv=false;
		}
		if(u.isModifGestAntMed()){
			modifAntMedPriv=true;
		}else{
			modifAntMedPriv=false;
		}
		if(u.isSuppGestAntMed()){
			supAntMedPriv=true;
		}else{
			supAntMedPriv=false;
		}
		if(u.isTabChirAnt()){
			paramtabAntChirgPriv=true;
		}else{
			paramtabAntChirgPriv=false;
		}
		if(u.isAjoutGestChirg()){
			ajoutAntChirgPriv=true;
		}else{
			ajoutAntChirgPriv=false;
		}
		if(u.isModifGestChirg()){
			modifAntChirgPriv=true;
		}else{
			modifAntChirgPriv=false;
		}
		if(u.isSuppGestAntChirg()){
			supAntChirgPriv=true;
		}else{
			supAntChirgPriv=false;
		}
		
		if(u.isTabFamAnt()){
			paramtabAntFamPriv=true;
		}else{
			paramtabAntFamPriv=false;
		}
		if(u.isAjoutGestFam()){
			ajoutAntFamPriv=true;
		}else{
			ajoutAntFamPriv=false;
		}
		if(u.isModifGestFam()){
			modifAntFamPriv=true;
		}else{
			modifAntFamPriv=false;
		}
		if(u.isSuppGestAntFam()){
			supAntFamPriv=true;
		}else{
			supAntFamPriv=false;
		}
		

		if(u.isGestHoraire()){
			gestHorairePriv=true;
		}else{
			gestHorairePriv=false;
		}
		if(u.isModifPrtSais()){
			modifprdSaisPriv=true;
		}else{
			modifprdSaisPriv=false;
		}
		if(u.isAjoutHeurTrav()){
			ajoutHorTravPriv=true;
		}else{
			ajoutHorTravPriv=false;
		}
		if(u.isAjoutHeurTrav()){
			modifHorTravPriv=true;
		}else{
			modifHorTravPriv=false;
		}
		if(u.isSupHeurTrav()){
			supHorTravPriv=true;
		}else{
			supHorTravPriv=false;
		}
		
		
		if(u.isGestCabinet()){
			gestCabinetPriv=true;
		}else{
			gestCabinetPriv=false;
		}
		
		if(u.isGestionUterus()){
			gestUtPriv=true;
		}else{
			gestUtPriv=false;
		}
        if(u.isAjoutUt()){
        	ajoutUtPriv=true;
        }else{
        	ajoutUtPriv=false;
        }
        if(u.isModifUt()){
        	modifUtPriv=true;
        }else{
        	modifUtPriv=false;
        }
        if(u.isSupUt()){
        	supUtPriv=true;
        }else{
        	supUtPriv=false;
        }
        
        if(u.getGestEFG().equals("1")){
        	gestFinGrossPriv=true;
        }else{
        	gestFinGrossPriv=false;
        }
        if(u.isAjoutEFG()){
        	ajoutFinGrossPriv=true;
        }else{
        	ajoutFinGrossPriv=false;
        }
        if(u.isModifEFG()){
        	modifFinGrossPriv=true;
        }else{
        	modifFinGrossPriv=false;
        }
        if(u.isSupEFG()){
        	supFinGrossPriv=true;
        }else{
        	supFinGrossPriv=false;
        }
        
        if(u.isGestConsultation()){
        	gestConsPriv=true;
        }else{
        	gestConsPriv=false;
        }
        if(u.isModifCons()){
        	modifConsPriv=true;
        }else{
        	modifConsPriv=false;
        }
        
        if(u.isGestionFormMed()){
        	gestFrmMedPriv=true;
        }else{
        	gestFrmMedPriv=false;
        }
        if(u.isAjoutFM()){
        	ajoutFrmMedPriv=true;
        }else{
        	ajoutFrmMedPriv=false;
        }
        if(u.isModifFM()){
        	modifFrmMedPriv=true;
        }else{
        	modifFrmMedPriv=false;
        }
        if(u.isSupFM()){
        	supFrmMedPriv=true;
        }else{
        	supFrmMedPriv=false;
        }
        
        
		
		if (gestProf.equals("1")) {
			gestProfPriv = true;
		} else {
			gestProfPriv = false;
		}

		if (gestVil.equals("1")) {

			gestVilPriv = true;
		} else {
			gestVilPriv = false;
		}
		if (gestClin.equals("1")) {

			gestCliPriv = true;
		} else {

			gestCliPriv = false;
		}
		if (rappCertif.equals("1")) {
			rappCertifPriv = true;
		} else {
			rappCertifPriv = false;
		}
		if (rappOrdnce.equals("1")) {
			rappOrdncePriv = true;
		} else {
			rappOrdncePriv = false;
		}
		if (rappLettre.equals("1")) {
			rappLettrePriv = true;
		} else {
			rappLettrePriv = false;
		}
		if (monterPatSal.equals("1")) {
			montPatSalPriv = true;
		} else {
			montPatSalPriv = false;
		}

		if (desdrePatSal.equals("1")) {
			descdrePatSalPriv = true;
		} else {
			descdrePatSalPriv = false;
		}
		if (permutPatSal.equals("1")) {
			permutPatSalPriv = true;
		} else {
			permutPatSalPriv = false;
		}
		if (premierPatSal.equals("1")) {
			premierPatSalPriv = true;
		} else {
			premierPatSalPriv = false;
		}
		if (dernierPatSal.equals("1")) {
			dernierSalPriv = true;
		} else {
			dernierSalPriv = false;
		}
		if (supPatSal.equals("1")) {
			supPatSalPriv = true;
		} else {
			supPatSalPriv = false;
		}

		if (chargPatSal.equals("1")) {
			chargPatSalPriv = true;
		} else {
			chargPatSalPriv = false;
		}
		if (u.isModifNoteSal()) {
			modifNoteSalPriv = true;
		} else {
			modifNoteSalPriv = false;
		}
		if (u.isReponseSal()) {
			reponseSalPriv= true;
		} else {
			reponseSalPriv = false;
		}
		if (u.isTabAnulSal()) {
			tabAnulSalPriv= true;
		} else {
			tabAnulSalPriv = false;
		}
		if (u.isAnulSal()) {
			anulSalPriv= true;
		} else {
			anulSalPriv = false;
		}
		
		
		if (u.isDonnerRdv()) {
			donnerRdvPriv= true;
		} else {
			donnerRdvPriv = false;
		}
		if (u.isArchiverPat()) {
			archiverPatPriv= true;
		} else {
			archiverPatPriv = false;
		}
		if (u.isConsultArchiv()) {
			consultArchivePriv= true;
		} else {
			consultArchivePriv = false;
		}

		if (ajoutDoc.equals("1")) {
			ajoutDocPriv = true;
		} else {
			ajoutDocPriv = false;
		}
		if (modifDoc.equals("1")) {
			modifDocPriv = true;
		} else {
			modifDocPriv = false;
		}
		if (supDoc.equals("1")) {
			supDocPriv = true;
		} else {
			supDocPriv = false;
		}
		if (ajoutProf.equals("1")) {
			ajoutProfPriv = true;
		} else {
			ajoutProfPriv = false;
		}
		if (modifProf.equals("1")) {
			modifProfPriv = true;
		} else {
			modifProfPriv = false;
		}
		if (supProf.equals("1")) {
			supProfPriv = true;
		} else {
			supProfPriv = false;
		}
		if (ajoutVil.equals("1")) {
			ajoutVilPriv = true;
		} else {
			ajoutVilPriv = false;
		}
		if (modifVil.equals("1")) {
			modifVilPriv = true;
		} else {
			modifVilPriv = false;
		}
		if (supVil.equals("1")) {
			supVilPriv = true;
		} else {
			supVilPriv = false;
		}
		if (ajoutClin.equals("1")) {
			ajoutClinPriv = true;
		} else {
			ajoutClinPriv = false;
		}
		if (modifClin.equals("1")) {
			modifClinPriv = true;
		} else {
			modifClinPriv = false;
		}
		if (supClin.equals("1")) {
			supClinPriv = true;
		} else {
			supClinPriv = false;
		}
		if (antecedent.equals("1")) {
			antecedentPriv = true;
		} else {
			antecedentPriv = false;
		}
		if (echoGyn.equals("1")) {
			echoGynPriv = true;
		} else {
			echoGynPriv = false;
		}
		if(u.isNouvchogyneco()){
			echoGynNouvConsultPriv=true;
		}else{
			echoGynNouvConsultPriv=false;
		}
		
		if(u.isModifechogyneco()){
			echoGynModifConsultPriv=true;
		}else{
			echoGynModifConsultPriv=false;
		}
		
		if(u.isSuppechogyneco()){
			echoGynsupConsultPriv=true;
		}else{
			echoGynsupConsultPriv=false;
		}
		
		if(u.isAjoutmodelechogyneco()){
			echoGynNouvModeltPriv=true;
		}else{
			echoGynNouvModeltPriv=false;
		}
		
		if(u.isSuppmodelechogyneco()){
			echoGynSupModeltPriv=true;
		}else{
			echoGynSupModeltPriv=false;
		}
		
		if(u.isAppliquemodelechogyneco()){
			echoGynApplModeltPriv=true;
		}else{
			echoGynApplModeltPriv=false;
		}
		
		if(u.isImprechogyneco()){
			echoGynImprPriv=true;
		}else{
			echoGynImprPriv=false;
		}
		
		if (echoObs.equals("1")) {
			echoObstPriv = true;
		} else {
			echoObstPriv = false;
		}
		if(u.isModifechoObs()){
			echoObsModifConsultPriv=true;
		}else{
			echoObsModifConsultPriv=false;
		}
		if(u.isNouvechoObs()){
			echoObsNouvConsultPriv=true;
		}else{
			echoObsNouvConsultPriv=false;
		}
		if(u.isSuppechoObs()){
			echoObsSupConsultPriv=true;
		}else{
			echoObsSupConsultPriv=false;
		}
		if(u.isTrim1echoObs()){
			echoObsTrim1Priv=true;
		}else{
			echoObsTrim1Priv=false;
		}
		if(u.isTrim2echoObs()){
			echoObsTrim2Priv=true;
		}else{
			echoObsTrim2Priv=false;
		}
		if(u.isImprechoObs()){
			echoObsImprPriv=true;
		}else{
			echoObsImprPriv=false;
		}
		
		if(u.isTrim3echoObs()){
			echoObsTrim3Priv=true;
		}else{
			echoObsTrim3Priv=false;
		}
		
		
		if (gynecologie.equals("1")) {
			gynecologiePriv = true;
		} else {
			gynecologiePriv = false;
		}
		if (consultGros.equals("1")) {
			consultGrossPriv = true;
		} else {
			consultGrossPriv = false;
		}
		if (sterilite.equals("1")) {
			sterilitePriv = true;
		} else {
			sterilitePriv = false;
		}
		if(u.isModifSterilite()){
			steriliteModifPriv=true;
		}else{
			steriliteModifPriv=false;
		}
		if (tabAntecedent.equals("1")) {
			tabAntecedentPriv = true;
		} else {
			tabAntecedentPriv = false;
		}
		
		if(u.isModifGynObs()){
			modifGynObsPriv=true;
		}else{
			modifGynObsPriv=false;
		}
		if(u.isModifAnt()){
			modifAntPriv=true;
		}else{
			modifAntPriv=false;
		}
		if(u.isSuppAnt()){
			suppAntPriv=true;
		}else{
			suppAntPriv=false;
		}
		
		if (tabGynecoObs.equals("1")) {
			tabGynecoObsPriv = true;
		} else {
			tabGynecoObsPriv = false;
		}
		if (tabHistGross.equals("1")) {
			tabHistGrossPriv = true;
		} else {
			tabHistGrossPriv = false;
		}
		if (tabContraception.equals("1")) {
			tabContracepPriv = true;
		} else {
			tabContracepPriv = false;
		}
		if (nouvGross.equals("1")) {
			nouvGrossPriv = true;
		} else {
			nouvGrossPriv = false;
		}
		if (nouvContraception.equals("1")) {
			nouvContracepPriv = true;
		} else {
			nouvContracepPriv = false;
		}
		if (modifHistGross.equals("1")) {
			modifHistGrossPriv = true;
		} else {
			modifHistGrossPriv = false;
		}
		if (supHistGross.equals("1")) {
			supHistGrossPriv = true;
		} else {
			supHistGrossPriv = false;
		}
		if (modifContraception.equals("1")) {
			modifContracepPriv = true;
		} else {
			modifContracepPriv = false;
		}
		if (supConctraeption.equals("1")) {
			supContacepPriv = true;
		} else {
			supContacepPriv = false;
		}
		if (gynAnal.equals("1")) {
			gynAnaPriv = true;
		} else {
			gynAnaPriv = false;
		}
		if (gynOrd.equals("1")) {
			gynOrdPriv = true;
		} else {
			gynOrdPriv = false;
		}
		
		if (u.isConsultDetAnal()) {
			consultDetAnalPriv = true;
		} else {
			consultDetAnalPriv = false;
		}
		if (u.isConsultDetRad()) {
			consultDetRadPriv = true;
		} else {
			consultDetRadPriv = false;
		}
		if (u.isConsultDetOrd()) {
			consultDetOrdPriv = true;
		} else {
			consultDetOrdPriv = false;
		}
		
		if (gynRadio.equals("1")) {
			gynRadioPriv = true;
		} else {
			gynRadioPriv = false;
		}
		if (nouvConsGyn.equals("1")) {
			gynNouvConsultPriv = true;
		} else {
			gynNouvConsultPriv = false;
		}
		if(u.isModifGyneco()){
			gynModifConsultPriv=true;
		}else{
			gynModifConsultPriv=false;
		}
		
		if(u.isSuppGyneco()){
			gynSupConsultPriv=true;
		}else{
			gynSupConsultPriv=false;
		}
		
		if(u.isImprGyneco()){
			gynImprConsultPriv=true;
		}else{
			gynImprConsultPriv=false;
		}
			
		if (grossRadio.equals("1")) {
			grossRadioPriv = true;
		} else {
			grossRadioPriv = false;
		}
		if (grossOrd.equals("1")) {
			grossOrdPriv = true;
		} else {
			grossOrdPriv = false;
		}
		if(u.isSelectNouvGross()){
			grossSelectNouvConsultPriv=true;
		}else{
			grossSelectNouvConsultPriv=false;
		}
		if(u.isModifGross()){
			grossModifConsultPriv=true;
		}else{
			grossModifConsultPriv=false;
		}
		if(u.isSuppGross()){
			grossSupvConsultPriv=true;
		}else{
			grossSupvConsultPriv=false;
		}
		if(u.isImprGross()){
			grossImprConsultPriv=true;
		}else{
			grossImprConsultPriv=false;
		}
        
		if (grossAnal.equals("1")) {
			grossAnaPriv = true;
		} else {
			grossAnaPriv = false;
		}
		if (grossNouvCons.equals("1")) {
			grossNouvConsultPriv = true;
		} else {
			grossNouvConsultPriv = false;
		}
	}

	public String Supprimer(Integer id) {

		
		FacesContext faces = FacesContext.getCurrentInstance();
		UtilisateurService ser = new UtilisateurService();
		ser.supprimerUtilisateur(id);
		//RequestContext.getCurrentInstance().update("f1");
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Utilisateur supprimé avec succè", "Invalid credentials"));

		return null;
	}

	public void initialisation() {

		index=0;
		
		
		idUtilisateur = null;
		login = null;
		motPasse = null;
		nom = null;
		prenom = null;
		date_naiss = null;
		dateNais = null;
		adresse = null;
		tel = null;
		email = null;
		civil = null;
		
		nomModelUtl=null;
		idmodelUtl=null;

		gestExmCompPriv = false;
		ajoutExmCompPriv = false;
		modifExmCompPriv = false;
		supExmCompPriv = false;

		gestSymPriv = false;
		ajoutSymPriv = false;
		modifSymPriv = false;
		supSymPriv = false;

		gestDiagPriv = false;
		ajoutDiagPriv = false;
		modifDiagPriv = false;
		supDiagPriv = false;

		gestMoyCtrPriv = false;
		ajoutMoyCtrPriv = false;
		modifMoyCtrPriv = false;
		supMoyCtrPriv = false;

		gestExmPriv = false;
		ajoutExmPriv = false;
		modifExmPriv = false;
		supExmPriv = false;

		gestMedPriv = false;
		ajoutMedPriv = false;
		modifMedPriv = false;
		supMedPriv = false;

		gestAnalPriv = false;
		ajoutAnalPriv = false;
		modifAnalPriv = false;
		supAnalPriv = false;

		gestEtBbPriv = false;
		ajoutEtBbPriv = false;
		modifEtBbPriv = false;
		supEtBbPriv = false;

		gestJrFerParamPriv=false;
		paramtabJrFerPriv=false;
		ajouJrFerStndPriv=false;
		modifJrFerStndPriv=false;
		supJrFerStndPriv=false;
		paramtabJrFerExpPriv=false;
		ajouJrFerExpPriv=false;
		modifJrFerExpPriv=false;
		supJrFerExpPriv=false;
		
		verConsultPriv = false;
        menuSalPriv=false;
		menuGesPatPriv = false;
		menuParamPriv = false;
		menuRendvousPriv=false;
		menuRappPriv = false;
		menuStatPriv=false;
		menuGesUtlPriv = false;
		ajouPatPriv = false;
		verSalPriv = false;
		modifPatPriv = false;
		detPatPriv = false;
		chargPatPriv = false;
		suppPatPriv = false;
		tabInfGnrAjtPatPriv = false;
		
		tabContctPatPriv = false;
		tabInfoConjAjtPatPriv = false;
		tabAtreInfAjtPatPriv = false;
		gestDocPriv = false;
		gestAntecedentParamPriv=false;
		paramtabAntMedPriv=false;
		ajoutAntMedPriv=false;
		modifAntMedPriv=false;
		supAntMedPriv=false;
		paramtabAntChirgPriv=false;
		ajoutAntChirgPriv=false;
		modifAntChirgPriv=false;
		supAntChirgPriv=false;
		paramtabAntFamPriv=false;
		ajoutAntFamPriv=false;
		modifAntFamPriv=false;
		supAntFamPriv=false;
		gestHorairePriv=false;
		modifprdSaisPriv=false;
		ajoutHorTravPriv=false;
		modifHorTravPriv=false;
		supHorTravPriv=false;
		
		gestCabinetPriv=false;
		gestUtPriv=false;
		ajoutUtPriv=false;
		modifUtPriv=false;
		supUtPriv=false;
		
		gestFinGrossPriv=false;
		ajoutFinGrossPriv=false;
		modifFinGrossPriv=false;
		supFinGrossPriv=false;
		
		gestConsPriv=false;
		modifConsPriv=false;
		
		gestFrmMedPriv=false;
		ajoutFrmMedPriv=false;
		modifFrmMedPriv=false;
		supFrmMedPriv=false;
		gestProfPriv = false;
		gestVilPriv = false;
		gestCliPriv = false;
		rappCertifPriv = false;
		rappLettrePriv = false;
		rappOrdncePriv = false;
		montPatSalPriv = false;
		descdrePatSalPriv = false;
		permutPatSalPriv = false;
		premierPatSalPriv = false;
		dernierSalPriv = false;
		supPatSalPriv = false;
		chargPatSalPriv = false;
		modifNoteSalPriv=false;
		reponseSalPriv=false;
		tabAnulSalPriv=false;
		anulSalPriv=false;
		donnerRdvPriv=false;
		archiverPatPriv=false;
		consultArchivePriv=false;
		ajoutDocPriv = false;
		modifDocPriv = false;
		supDocPriv = false;
		ajoutProfPriv = false;
		modifProfPriv = false;
		supProfPriv = false;
		ajoutVilPriv = false;
		modifVilPriv = false;
		supVilPriv = false;
		ajoutClinPriv = false;
		modifClinPriv = false;
		supClinPriv = false;
		antecedentPriv = false;
		echoGynPriv = false;
		echoGynsupConsultPriv=false;
		echoGynModifConsultPriv=false;
		echoGynNouvConsultPriv=false;
		echoGynNouvModeltPriv=false;
		echoGynSupModeltPriv=false;
		echoGynApplModeltPriv=false;
		echoGynImprPriv=false;
		echoObstPriv = false;
		echoObsTrim3Priv=false;
		echoObsNouvConsultPriv=false;
		echoObsModifConsultPriv=false;
		echoObsSupConsultPriv=false;
		echoObsTrim1Priv=false;
		echoObsTrim2Priv=false;
		echoObsImprPriv=false;
		gynecologiePriv = false;
		consultGrossPriv = false;
		sterilitePriv = false;
		steriliteModifPriv=false;
		tabAntecedentPriv = false;
		modifGynObsPriv=false;
		modifAntPriv=false;
		suppAntPriv=false;
		tabGynecoObsPriv = false;
		tabHistGrossPriv = false;
		tabContracepPriv = false;
		nouvGrossPriv = false;
		nouvContracepPriv = false;
		modifHistGrossPriv = false;
		supHistGrossPriv = false;
		modifContracepPriv = false;
		supContacepPriv = false;
		gynRadioPriv = false;
		gynAnaPriv = false;
		gynOrdPriv = false;
		consultDetAnalPriv=false;
		consultDetRadPriv=false;
		consultDetOrdPriv=false;
		gynNouvConsultPriv = false;
		gynModifConsultPriv= false;
		gynSupConsultPriv=false;
		gynImprConsultPriv=false;
		grossSelectNouvConsultPriv=false;
		grossModifConsultPriv=false;
		grossSupvConsultPriv=false;
		grossImprConsultPriv=false;
		grossRadioPriv = false;
		grossAnaPriv = false;
		grossOrdPriv = false;
		grossNouvConsultPriv = false;
		certifFichePriv = false;
		ajoutCertifPriv=false;
		modifCertifPriv=false;
		supCertifPriv=false;
		impCertifPriv=false;
		
		lettreFichePriv = false;
		ajoutLtrPriv=false;
		modifLtrPriv=false;
		supLtrPriv=false;
	    impLtrPriv=false;
		
		analyseFichePriv = false;
		modifHistoAnalPriv=false;
		consultHistoAnalPriv=false;
		supHistoAnalPriv=false;
		
		radioFichePriv = false;
		modifHistoRadPriv=false;
		consultHistoRadPriv=false;
		supHistoRadPriv=false;
		imprAnalPriv=false;
		imprRadioPriv=false;
		
		rapportFichePriv = false;
		
		ordonceFichePriv = false;
		consultOrdLibrePriv=false;
		modifHistoOrdPriv=false;
		supHistoOrdPriv=false;
		rechercheOrdPriv=false;
		imprOrdPriv=false;
		
		ajoutModeleordPriv=false;
		selectModeleordPriv=false;
		suppModeleOrdPriv=false;
		consultertHistoConsultationPriv=false;
		
		gestSaisPriv=false;
		

		/*try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("AjouterUtilisateur.xhtml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/

	}
	
	public void redirectverajoututl(){
		
		
		try {
			FacesContext context2 = FacesContext.getCurrentInstance();
		    context2.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("AjoutUtilisateur");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
public void redirectverModifutl(){
		
		try {
			FacesContext context2 = FacesContext.getCurrentInstance();
		    context2.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("ModifierUtilisateur");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void hideDialog() {
		initialisation();
		//redirectUtl();
	}

	public void touCocherGeneral() {

		menuSalPriv = true;
		menuGesPatPriv = true;
		menuParamPriv = true;
		menuRendvousPriv=true;
		menuStatPriv = true;
		menuGesUtlPriv = true;


	}

	public void toudeocherGeneral() {

		menuSalPriv = false;
		menuGesPatPriv = false;
		menuParamPriv = false;
		menuRendvousPriv=false;
		menuStatPriv = false;
		menuGesUtlPriv = false;
		

	}

	public void touCochersal() {
		
		verConsultPriv = true;
		montPatSalPriv = true;
		descdrePatSalPriv = true;
		permutPatSalPriv = true;
		premierPatSalPriv = true;
		dernierSalPriv = true;
		supPatSalPriv = true;
		chargPatSalPriv = true;
		modifNoteSalPriv=true;
		reponseSalPriv=true;
		tabAnulSalPriv=true;
		anulSalPriv=true;
        //donnerRdvPriv=true;
        

	}

	public void toudeochersal() {
		verConsultPriv = false;
		montPatSalPriv = false;
		descdrePatSalPriv = false;
		permutPatSalPriv = false;
		premierPatSalPriv = false;
		dernierSalPriv = false;
		supPatSalPriv = false;
		chargPatSalPriv = false;
		modifNoteSalPriv=false;
		reponseSalPriv=false;
		tabAnulSalPriv=false;
		anulSalPriv=false;
		//donnerRdvPriv=false;
		

	}

	public void touCocherPat() {

		ajouPatPriv = true;
		tabInfGnrAjtPatPriv = true;

		tabContctPatPriv = true;
		tabInfoConjAjtPatPriv = true;
		tabAtreInfAjtPatPriv = true;
		verSalPriv = true;
		modifPatPriv = true;
		detPatPriv = true;
		chargPatPriv = true;
		suppPatPriv = true;
		donnerRdvPriv=true;
		archiverPatPriv=true;
        consultArchivePriv=true;

	}

	public void toudeCocherPat() {

		ajouPatPriv = false;
		tabInfGnrAjtPatPriv = false;

		tabContctPatPriv = false;
		tabInfoConjAjtPatPriv = false;
		tabAtreInfAjtPatPriv = false;
		verSalPriv = false;
		modifPatPriv = false;
		detPatPriv = false;
		chargPatPriv = false;
		suppPatPriv = false;
		donnerRdvPriv=false;
		archiverPatPriv=false;
        consultArchivePriv=false;

	}
	
	
	public void touCocherParam(){
		gestDocPriv=true;
		ajoutDocPriv=true;
		modifDocPriv=true;
		supDocPriv=true;
		
		gestCliPriv=true;
		ajoutClinPriv=true;
		modifClinPriv=true;
		supClinPriv=true;
		
		gestProfPriv=true;
		ajoutProfPriv=true;
		modifProfPriv=true;
		supProfPriv=true;
		
		gestVilPriv=true;
		ajoutVilPriv=true;
		modifVilPriv=true;
		supVilPriv=true;
		
		gestFinGrossPriv=true;
		ajoutFinGrossPriv=true;
		modifFinGrossPriv=true;
		supFinGrossPriv=true;
		
		gestEtBbPriv=true;
		ajoutEtBbPriv=true;
		modifEtBbPriv=true;
		supEtBbPriv=true;
		
		gestAnalPriv=true;
		ajoutAnalPriv=true;
		modifAnalPriv=true;
		supAnalPriv=true;
		
		gestMedPriv=true;
		ajoutMedPriv=true;
		modifMedPriv=true;
		supMedPriv=true;
		
		gestExmPriv=true;
		ajoutExmPriv=true;
		modifExmPriv=true;
		supExmPriv=true;
		
		gestMoyCtrPriv=true;
		ajoutMoyCtrPriv=true;
		modifMoyCtrPriv=true;
		supMoyCtrPriv=true;
		
		gestDiagPriv=true;
		ajoutDiagPriv=true;
		modifDiagPriv=true;
		supDiagPriv=true;
		
		gestSymPriv=true;
		ajoutSymPriv=true;
		modifSymPriv=true;
		supSymPriv=true;
		
		gestExmCompPriv=true;
		ajoutExmCompPriv=true;
		modifExmCompPriv=true;
		supExmCompPriv=true;
		
		gestUtPriv=true;
		ajoutUtPriv=true;
		modifUtPriv=true;
		supUtPriv=true;
		
		gestAntecedentParamPriv=true;
		paramtabAntMedPriv=true;
		ajoutAntMedPriv=true;
		modifAntMedPriv=true;
		supAntMedPriv=true;
		paramtabAntChirgPriv=true;
		ajoutAntChirgPriv=true;
		modifAntChirgPriv=true;
		supAntChirgPriv=true;
		paramtabAntFamPriv=true;
		ajoutAntFamPriv=true;
		modifAntFamPriv=true;
		supAntFamPriv=true;
		
		gestJrFerParamPriv=true;
		paramtabJrFerPriv=true;
		ajouJrFerStndPriv=true;
		modifJrFerStndPriv=true;
		supJrFerStndPriv=true;
		paramtabJrFerExpPriv=true;
		ajouJrFerExpPriv=true;
		modifJrFerExpPriv=true;
		supJrFerExpPriv=true;
		
		gestConsPriv=true;
		modifConsPriv=true;
		
		gestFrmMedPriv=true;
		ajoutFrmMedPriv=true;
		modifFrmMedPriv=true;
		supFrmMedPriv=true;
		
		gestHorairePriv=true;
		modifprdSaisPriv=true;
		ajoutHorTravPriv=true;
		modifHorTravPriv=true;
		supHorTravPriv=true;
		gestSaisPriv=true;
		
		gestCabinetPriv=true;
		
		
	}
	
	public void touDecocherParam(){
		
		gestDocPriv=false;
		ajoutDocPriv=false;
		modifDocPriv=false;
		supDocPriv=false;
		
		gestCliPriv=false;
		ajoutClinPriv=false;
		modifClinPriv=false;
		supClinPriv=false;
		
		gestProfPriv=false;
		ajoutProfPriv=false;
		modifProfPriv=false;
		supProfPriv=false;
		
		gestVilPriv=false;
		ajoutVilPriv=false;
		modifVilPriv=false;
		supVilPriv=false;
		
		gestFinGrossPriv=false;
		ajoutFinGrossPriv=false;
		modifFinGrossPriv=false;
		supFinGrossPriv=false;
		
		gestEtBbPriv=false;
		ajoutEtBbPriv=false;
		modifEtBbPriv=false;
		supEtBbPriv=false;
		
		gestAnalPriv=false;
		ajoutAnalPriv=false;
		modifAnalPriv=false;
		supAnalPriv=false;
		
		gestMedPriv=false;
		ajoutMedPriv=false;
		modifMedPriv=false;
		supMedPriv=false;
		
		gestExmPriv=false;
		ajoutExmPriv=false;
		modifExmPriv=false;
		supExmPriv=false;

		gestMoyCtrPriv=false;
		ajoutMoyCtrPriv=false;
		modifMoyCtrPriv=false;
		supMoyCtrPriv=false;
		
		gestDiagPriv=false;
		ajoutDiagPriv=false;
		modifDiagPriv=false;
		supDiagPriv=false;
		
		gestSymPriv=false;
		ajoutSymPriv=false;
		modifSymPriv=false;
		supSymPriv=false;
		
		gestExmCompPriv=false;
		ajoutExmCompPriv=false;
		modifExmCompPriv=false;
		supExmCompPriv=false;
		
		gestUtPriv=false;
		ajoutUtPriv=false;
		modifUtPriv=false;
		supUtPriv=false;
		
		gestAntecedentParamPriv=false;
		paramtabAntMedPriv=false;
		ajoutAntMedPriv=false;
		modifAntMedPriv=false;
		supAntMedPriv=false;
		paramtabAntChirgPriv=false;
		ajoutAntChirgPriv=false;
		modifAntChirgPriv=false;
		supAntChirgPriv=false;
		paramtabAntFamPriv=false;
		ajoutAntFamPriv=false;
		modifAntFamPriv=false;
		supAntFamPriv=false;
		
		gestJrFerParamPriv=false;
		paramtabJrFerPriv=false;
		ajouJrFerStndPriv=false;
		modifJrFerStndPriv=false;
		supJrFerStndPriv=false;
		paramtabJrFerExpPriv=false;
		ajouJrFerExpPriv=false;
		modifJrFerExpPriv=false;
		supJrFerExpPriv=false;
		
		gestConsPriv=false;
		modifConsPriv=false;
		
		gestFrmMedPriv=false;
		ajoutFrmMedPriv=false;
		modifFrmMedPriv=false;
		supFrmMedPriv=false;
		
		gestHorairePriv=false;
		modifprdSaisPriv=false;
		ajoutHorTravPriv=false;
		modifHorTravPriv=false;
		supHorTravPriv=false;
		gestSaisPriv=false;
		
		
		gestCabinetPriv=false;
		
		
	}
	
	

	public void touCocherAnt() {
		antecedentPriv = true;
		tabAntecedentPriv = true;
		tabGynecoObsPriv = true;
		tabHistGrossPriv = true;
		tabContracepPriv = true;
		nouvGrossPriv = true;
		nouvContracepPriv = true;
		modifHistGrossPriv = true;
		supHistGrossPriv = true;
		modifContracepPriv = true;
		supContacepPriv = true;
		modifGynObsPriv=true;
		modifAntPriv=true;
		suppAntPriv=true;

	}

	public void toudeCocherAnt() {

		antecedentPriv = false;
		tabAntecedentPriv = false;
		tabGynecoObsPriv = false;
		tabHistGrossPriv = false;
		tabContracepPriv = false;
		nouvGrossPriv = false;
		nouvContracepPriv = false;
		modifHistGrossPriv = false;
		supHistGrossPriv = false;
		modifContracepPriv = false;
		supContacepPriv = false;
		modifGynObsPriv=false;
		modifAntPriv=false;
		suppAntPriv=false;

	}

	public void touCocherGyn() {

		gynecologiePriv = true;
		
       
		gynNouvConsultPriv = true;
		gynModifConsultPriv= true;
		gynSupConsultPriv=true;
		gynImprConsultPriv=true;

	}

	public void toudeCocherGyn() {

		gynecologiePriv = false;
		
		gynNouvConsultPriv = false;
		gynModifConsultPriv= false;
		gynSupConsultPriv=false;
		gynImprConsultPriv=false;
	}
	
	public void touCocherEcoGyn(){
		
		echoGynPriv=true;
		echoGynNouvConsultPriv=true;
		echoGynModifConsultPriv=true;
		echoGynsupConsultPriv=true;
		echoGynNouvModeltPriv=true;
		echoGynSupModeltPriv=true;
		echoGynApplModeltPriv=true;
		echoGynImprPriv=true;
	}
	
	public void touDecocherEcoGyn(){
		
		echoGynPriv=false;
		echoGynNouvConsultPriv=false;
		echoGynModifConsultPriv=false;
		echoGynsupConsultPriv=false;
		echoGynNouvModeltPriv=false;
		echoGynSupModeltPriv=false;
		echoGynApplModeltPriv=false;
		echoGynImprPriv=false;
	}
	
	public void touCocherEcoOst(){
		
		echoObstPriv = true;
		echoObsNouvConsultPriv=true;
		echoObsModifConsultPriv=true;
		echoObsSupConsultPriv=true;
		echoObsTrim1Priv=true;
		echoObsTrim2Priv=true;
		echoObsTrim3Priv=true;
		echoObsImprPriv=true;
		
	}
	
	public void touDecocherEcoObst(){
		
		echoObstPriv = false;
		echoObsNouvConsultPriv=false;
		echoObsModifConsultPriv=false;
		echoObsSupConsultPriv=false;
		echoObsTrim1Priv=false;
		echoObsTrim2Priv=false;
		echoObsTrim3Priv=false;
		echoObsImprPriv=false;
		
	}

	public void touCocherGross() {
		consultGrossPriv = true;
		
		grossNouvConsultPriv = true;
		grossSelectNouvConsultPriv=true;
		grossModifConsultPriv=true;
		grossSupvConsultPriv=true;
		grossImprConsultPriv=true;

	}

	public void toudeCocherGross() {
		consultGrossPriv = false;
		
		grossNouvConsultPriv = false;
		grossSelectNouvConsultPriv=false;
		grossModifConsultPriv=false;
		grossSupvConsultPriv=false;
		grossImprConsultPriv=false;

	}
	
	public void touCocherPramRap(){
		menuRappPriv=true;
		rappCertifPriv=true;
		rappLettrePriv=true;
	}
	
	public void touDecocherPramRap(){
		menuRappPriv=false;
		rappCertifPriv=false;
		rappLettrePriv=false;
		
	}
	
	public void touCocherPramInf(){
		
		sterilitePriv=true;
		steriliteModifPriv=true;
	}
	
	public void touDecocherPramInf(){
		sterilitePriv=false;
		steriliteModifPriv=false;
		
	}
	
	public void touCocherCertifFich(){
		certifFichePriv=true;
		ajoutCertifPriv=true;
		modifCertifPriv=true;
		supCertifPriv=true;
		impCertifPriv=true;
		
	}
	
	public void touDecocherCertifFich(){
		certifFichePriv=false;
		ajoutCertifPriv=false;
		modifCertifPriv=false;
		supCertifPriv=false;
		impCertifPriv=false;
		
	}
	
	public void touCocherLtrFich(){
		
		lettreFichePriv= true;
		ajoutLtrPriv= true;
		modifLtrPriv= true;
		supLtrPriv= true;
		impLtrPriv= true;
		
	}
	
	
	public void touDecocherLtrFich(){
		lettreFichePriv=false;
		ajoutLtrPriv=false;
		modifLtrPriv=false;
		supLtrPriv=false;
		impLtrPriv=false;
		
	}

	
	public void touCocherAnalFich(){
		
		analyseFichePriv=true;
		modifHistoAnalPriv=true;
		consultHistoAnalPriv=true;
		supHistoAnalPriv=true;
		imprAnalPriv=true;
	}
	
	public void touDecocherAnalFich(){
		analyseFichePriv=false;
		modifHistoAnalPriv=false;
		consultHistoAnalPriv=false;
		supHistoAnalPriv=false;
		imprAnalPriv=false;
		
	}
	
	public void touCocherRadFich(){
		radioFichePriv=true;
		modifHistoRadPriv=true;
		consultHistoRadPriv=true;
		supHistoRadPriv=true;
		imprAnalPriv=true;
		imprRadioPriv=true;
		
	}
	
	public void touDecocherRadFich(){
		radioFichePriv=false;
		modifHistoRadPriv=false;
		consultHistoRadPriv=false;
		supHistoRadPriv=false;
		imprRadioPriv=false;
		imprAnalPriv=false;
	}
	
	public void touCocherOrdFich(){
		
		ordonceFichePriv=true;
		modifHistoOrdPriv=true;
		supHistoOrdPriv=true;
		rechercheOrdPriv=true;
		imprOrdPriv=true;
		
	}
	
	public void touDecocherOrdFich(){
		ordonceFichePriv=false;
		modifHistoOrdPriv=false;
		supHistoOrdPriv=false;
		rechercheOrdPriv=false;
		imprOrdPriv=false;	
	}
	
	public void touCocherOrdLbreFich(){
		
		consultOrdLibrePriv=true;
		ajoutModeleordPriv=true;
		selectModeleordPriv=true;
		suppModeleOrdPriv=true;
		
	}
	
	public void touDecocherOrdLbreFich(){
		
		consultOrdLibrePriv=false;
		ajoutModeleordPriv=false;
		selectModeleordPriv=false;
		suppModeleOrdPriv=false;
		
	}
	
	
	
	public void touCocherPramAntecedent(){
		gestAntecedentParamPriv=true;
		paramtabAntMedPriv=true;
		ajoutAntMedPriv=true;
		modifAntMedPriv=true;
		supAntMedPriv=true;
		paramtabAntChirgPriv=true;
		ajoutAntChirgPriv=true;
		modifAntChirgPriv=true;
		supAntChirgPriv=true;
		paramtabAntFamPriv=true;
		ajoutAntFamPriv=true;
		modifAntFamPriv=true;
		supAntFamPriv=true;
	}
	
	public void touDecocherParamAntecedent(){
		gestAntecedentParamPriv=false;
		paramtabAntMedPriv=false;
		ajoutAntMedPriv=false;
		modifAntMedPriv=false;
		supAntMedPriv=false;
		paramtabAntChirgPriv=false;
		ajoutAntChirgPriv=false;
		modifAntChirgPriv=false;
		supAntChirgPriv=false;
		paramtabAntFamPriv=false;
		ajoutAntFamPriv=false;
		modifAntFamPriv=false;
		supAntFamPriv=false;
	}

	
	
	public void touCocherPramJrFer(){
		gestJrFerParamPriv=true;
		paramtabJrFerPriv=true;
		ajouJrFerStndPriv=true;
		modifJrFerStndPriv=true;
		supJrFerStndPriv=true;
		paramtabJrFerExpPriv=true;
		ajouJrFerExpPriv=true;
		modifJrFerExpPriv=true;
		supJrFerExpPriv=true;
		
	}
	
	
	public void touDecocherPramJrFer(){
		gestJrFerParamPriv=false;
		paramtabJrFerPriv=false;
		ajouJrFerStndPriv=false;
		modifJrFerStndPriv=false;
		supJrFerStndPriv=false;
		paramtabJrFerExpPriv=false;
		ajouJrFerExpPriv=false;
		modifJrFerExpPriv=false;
		supJrFerExpPriv=false;
		
	}
	
	
	public void recupererUtls(Utilisateur u) {

		idUtilisateur = u.getIdutilisateur();

	}
	


	public void modifMotPass() {
		FacesContext face = FacesContext.getCurrentInstance();
		//boolean addValid = false;

		UtilisateurService ser = new UtilisateurService();
		Utilisateur u = ser.rechercheUtilisateur(idUtilisateur);
		if (u != null) {
             
			if (motpass1.equals(motpass2)) {
			//	addValid=true;
				u.setMotPasse(motpass1);
				ser.modifierUtilisateur(u);
				//face.getPartialViewContext().getRenderIds().add("f1");
				face.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Mots de passe modifié avec succès", " "));
				idUtilisateur = null;
				motpass1 = null;
				motpass1 = null;
				
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dialogMotPass').hide();");
			
			} else {
				face.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Les deux mots de passe ne sont pas conformes", " "));

			}
		}
	}

	public void hideDialog2() {

		idUtilisateur = null;
		motpass1 = null;
		motpass1 = null;
	}

	public void desactiveUtl(Utilisateur u) {
       
		FacesContext face = FacesContext.getCurrentInstance();
		UtilisateurService ser = new UtilisateurService();
		u.setActif(false);
		u.setPassif(true);
		ser.modifierUtilisateur(u);
		face.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur désactivé avec succès", " "));
		
		

	}

	public void activeUtl(Utilisateur u) {
		FacesContext face = FacesContext.getCurrentInstance();
		UtilisateurService ser = new UtilisateurService();
		u.setActif(true);
		u.setPassif(false);
		ser.modifierUtilisateur(u);
		face.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur activé avec succès", " "));

	}

	public void redirectUtl() {
		
		/*try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionUtilisateur.xhtml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		FacesContext context2 = FacesContext.getCurrentInstance();
	    context2.getExternalContext().getFlash().setKeepMessages(true);
	    try {
	     context2.getExternalContext().redirect("Utilisateurs");
	    }catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	   // return "../pages/GestionUtilisateur.xhtml?faces-redirect=true";
		
	}
	
	
	public void modeleSelectionChanged(final AjaxBehaviorEvent event) {
		
		if (idmodelUtl != null)
			applique = false;
		else
			applique = true;
	}
	
	
	public void ajouterModelUtl() {
		FacesContext face = FacesContext.getCurrentInstance();
		//boolean addValid = false;
		
		// tester si existe un modèle avec le meme nom
		ModelutlService ser = new ModelutlService();
		Modelutl m = ser.rechercheParNomModelutl(nomModelUtl);
		
		if (nomModelUtl == null || (nomModelUtl.trim().length() == 0)) {
			face.addMessage(null, new FacesMessage(
			FacesMessage.SEVERITY_ERROR, "Nom Modèle vide",
			"Invalid credentials"));
			}
		
		if (m != null)// model existe déjà
		{
			face.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existe déjà un Modèle sous ce nom", " "));
			
		}
		
		if (face.getMessageList().size() == 0){
			
			Modelutl u= new Modelutl();
			u.setNomModelUtl(nomModelUtl);
			
			if (gestExmCompPriv) {
				u.setGestExmComp("1");
			} else {
				u.setGestExmComp("0");
			}
			if (ajoutExmCompPriv) {
				u.setAjoutExmComp(true);
				
			} else {
				u.setAjoutExmComp(false);
			}
			if (modifExmCompPriv) {
				u.setModifExmComp(true);
				
			} else {
				u.setModifExmComp(false);
			}

			if (supExmCompPriv) {
				u.setSupExmComp(true);
			} else {
				u.setSupExmComp(false);
			}

			if (gestSymPriv) {
				u.setGestSyn("1");
			} else {
				u.setGestSyn("0");
			}
			if (ajoutSymPriv) {
				u.setAjoutAsym(true);
				
			} else {
				u.setAjoutAsym(false);
			}
			if (modifSymPriv) {
				u.setModifAsym(true);
				
			} else {
				u.setModifAsym(false);
			}

			if (supSymPriv) {
				u.setSupAsym(true);
			} else {
				u.setSupAsym(false);
			}

			if (gestDiagPriv) {
				u.setGestDiag("1");
			} else {
				u.setGestDiag("0");
			}
			if (ajoutDiagPriv) {
				u.setAjoutDiag(true);
				
			} else {
				u.setAjoutDiag(false);
			}
			if (modifDiagPriv) {
				u.setModifDiag(true);
				
			} else {
				u.setModifDiag(false);
			}

			if (supDiagPriv) {
				u.setSupDiag(true);
			} else {
				u.setSupDiag(false);
			}

			if (gestMoyCtrPriv) {
				u.setGestMoyCtrcep("1");
			} else {
				u.setGestMoyCtrcep("0");
			}
			if (ajoutMoyCtrPriv) {
				u.setAjoutMoyCtr(true);
				
			} else {
				u.setAjoutMoyCtr(false);
			}
			if (modifMoyCtrPriv) {
				u.setModifMoyCtr(true);
				
			} else {
				u.setModifMoyCtr(false);
			}

			if (supMoyCtrPriv) {
				u.setSupMoyCtr(true);
			} else {
				u.setSupMoyCtr(false);
			}

			if (gestExmPriv) {
				u.setGestExm("1");
			} else {
				u.setGestExm("0");
			}
			if (ajoutExmPriv) {
				u.setAjoutExm(true);
				
			} else {
				u.setAjoutExm(false);
			}
			if (modifExmPriv) {
				u.setModifExm(true);
				
			} else {
				u.setModifExm(false);
			}

			if (supExmPriv) {
				u.setSupExm(true);
			} else {
				u.setSupExm(false);
			}
			
			if(gestJrFerParamPriv){
				u.setGestionJourFr(true);
			}else{
				u.setGestionJourFr(false);
			}
			if(paramtabJrFerPriv){
				u.setTabFerie(true);
			}else{
				u.setTabFerie(false);
			}
			if(ajouJrFerStndPriv){
				u.setNouvJFerie(true);
			}else{
				u.setNouvJFerie(false);
			}
			if(modifJrFerStndPriv){
				u.setModifJFerie(true);
			}else{
				u.setModifJFerie(false);
			}
			if(supJrFerStndPriv){
				u.setSuppJFerie(true);
			}else{
				u.setSuppJFerie(false);
			}
			if(paramtabJrFerExpPriv){
				u.setTabJFerieExp(true);
			}else{
				u.setTabJFerieExp(false);
			}
			if(ajouJrFerExpPriv){
				u.setNouvJFerieExp(true);
			}else{
				u.setNouvJFerieExp(false);
			}
			if(modifJrFerExpPriv){
				u.setModifJFerieExp(true);
			}else{
				u.setModifJFerieExp(false);
			}
			if(supJrFerExpPriv){
				u.setSuppJFerieExp(true);
			}else{
				u.setSuppJFerieExp(false);
			}
			

			if (gestMedPriv) {
				u.setGestMed("1");
			} else {
				u.setGestMed("0");
			}
			if (ajoutMedPriv) {
				u.setAjoutMed(true);
				
			} else {
				u.setAjoutMed(false);
			}
			if (modifMedPriv) {
				u.setModifMed(true);
				
			} else {
				u.setModifMed(false);
			}

			if (supMedPriv) {
				u.setSupMed(true);
			} else {
				u.setSupMed(false);
			}

			if (gestAnalPriv) {
				u.setGestAnal("1");
			} else {
				u.setGestAnal("0");
			}
			if (ajoutAnalPriv) {
				u.setAjoutAnal(true);
				
			} else {
				u.setAjoutAnal(false);
			}
			if (modifAnalPriv) {
				u.setModifAnal(true);
				
			} else {
				u.setModifAnal(false);
			}

			if (supAnalPriv) {
				u.setSupAnal(true);
				
			} else {
				u.setSupAnal(false);
			}

			if (gestEtBbPriv) {
				u.setGestBb("1");
			} else {
				u.setGestBb("0");
			}
			if (ajoutEtBbPriv) {
				u.setAjoutEtBb(true);
				
			} else {
				u.setAjoutEtBb(false);
			}
			if (modifEtBbPriv) {
				u.setModifEtBb(true);
				
			} else {
				u.setModifEtBb(false);
			}

			if (supEtBbPriv) {
				u.setSupEtBb(true);
				
			} else {
				u.setSupEtBb(false);
			}

			if (certifFichePriv) {
				u.setCertifFiche("1");
			} else {
				u.setCertifFiche("0");
			}
			if (ajoutCertifPriv) {
				u.setNouvCertif(true);
			} else {
				u.setNouvCertif(false);
			}
			if (modifCertifPriv) {
				u.setModifCertif(true);
			} else {
				u.setModifCertif(false);
			}
			if (supCertifPriv) {
				u.setSuppCertif(true);
			} else {
				u.setSuppCertif(false);
			}
			if (impCertifPriv) {
				u.setImprCertif(true);
			} else {
				u.setImprCertif(false);
			}
				
			
			if (lettreFichePriv) {
				u.setLettreFiche("1");
			} else {
				u.setLettreFiche("0");
			}
			if(ajoutLtrPriv){
				u.setNouvLettre(true);
			}else{
				u.setNouvLettre(false);
			}
			if(modifLtrPriv){
				u.setModifLettre(true);
			}else{
				u.setModifLettre(false);
			}
			if(supLtrPriv){
				u.setSuppLettre(true);
			}else{
				u.setSuppLettre(false);
			}
			if(impLtrPriv){
				u.setImprLettre(true);
			}else{
				u.setImprLettre(false);
			}
			

			if (analyseFichePriv) {
				u.setAnalyseFiche("1");
			} else {
				u.setAnalyseFiche("0");
			}
			if (modifHistoAnalPriv) {
				u.setModifAnalyse(true);
			} else {
				u.setModifAnalyse(false);
			}
			if (consultHistoAnalPriv) {
				u.setDetHistoAnal(true);
			} else {
				u.setDetHistoAnal(false);
			}
			if (supHistoAnalPriv) {
				u.setSupAnalyse(true);
			} else {
				u.setSupAnalyse(false);
			}
			
			
			if (radioFichePriv) {
				u.setRadioFiche("1");
			} else {
				u.setRadioFiche("0");
			}
			if(modifHistoRadPriv){
				u.setModifRadio(true);
			}else{
				u.setModifRadio(false);
			}
			if(consultHistoRadPriv){
				u.setDetHistoRad(true);
			}else{
				u.setDetHistoRad(false);
			}
			if(supHistoRadPriv){
				u.setSupRadio(true);
			}else{
				u.setSupRadio(false);
			}
			if(imprAnalPriv){
				u.setImprmAnal(true);
			}else{
				u.setImprRadio(false);
			}
			if(imprRadioPriv){
				u.setImprRadio(true);
			}else{
				u.setImprRadio(false);
			}
			
			
			if (rapportFichePriv) {
				u.setRapportFiche("1");
			} else {
				u.setRapportFiche("0");
			}
			if(ajoutModeleordPriv){
				u.setAjoutModeleord(true);
			}else{
				u.setAjoutModeleord(false);
			}
			if(selectModeleordPriv){
				u.setSelectModeleord(true);
			}else{
				u.setSelectModeleord(false);
			}
			if(suppModeleOrdPriv){
				u.setSuppModeleOrd(true);
			}else{
				u.setSuppModeleOrd(false);
			}
			
			if(gestSaisPriv){
				u.setGestSais(true);
			}else{
				u.setGestSais(false);
			}
			
			
			if(consultertHistoConsultationPriv){
				u.setSelectTableConsultation(true);
			}else{
				u.setSelectTableConsultation(false);
			}
			
			if (ordonceFichePriv) {
				u.setOrdnanceFiche("1");
			} else {
				u.setOrdnanceFiche("0");
			}
			if(consultOrdLibrePriv){
				u.setOrdonanceLibreFiche(true);
			}else{
				u.setOrdonanceLibreFiche(false);
			}
			if(modifHistoOrdPriv){
				u.setModifOrdnce(true);
			}else{
				u.setModifOrdnce(false);
			}
			if(supHistoOrdPriv){
				u.setSupphistoOrd(true);
			}else{
				u.setSupphistoOrd(false);
			}
			if(rechercheOrdPriv){
				u.setRechercheOrd(true);
			}else{
				u.setRechercheOrd(false);
			}
			if(imprOrdPriv){
				u.setImprOrd(true);
			}else{
				u.setImprOrd(false);
			}
			
		

			if (verConsultPriv) {
				u.setVerConsult("1");
			} else {
				u.setVerConsult("0");
			}
			if (menuSalPriv) {
				u.setMenuSal("1");
			} else {
				u.setMenuSal("0");
			}

			if (menuGesPatPriv) {
				u.setMenuGestPat("1");
			} else {
				u.setMenuGestPat("0");
			}

			if (menuParamPriv) {
				u.setMenuParametre("1");
			} else {
				u.setMenuParametre("0");
			}
			if(menuRendvousPriv){
				u.setMenuGestRdv("1");
			}else{
				u.setMenuGestRdv("0");
			}

			if (menuRappPriv) {
				u.setMenuRapport("1");
			} else {
				u.setMenuRapport("0");
			}
			
			if(menuStatPriv){
				u.setMenuGestStat(true);
			}else{
				u.setMenuGestStat(false);
			}

			if (menuGesUtlPriv) {
				u.setMenuGestUtl("1");
			} else {
				u.setMenuGestUtl("0");
			}

			if (ajouPatPriv) {
				u.setAjoutPatient("1");
			} else {
				u.setAjoutPatient("0");
			}

			if (verSalPriv) {
				u.setVerSal("1");
			} else {
				u.setVerSal("0");
			}

			if (modifPatPriv) {
				u.setModPatient("1");
			} else {
				u.setModPatient("0");
			}

			if (detPatPriv) {
				u.setDetPatient("1");
			} else {
				u.setDetPatient("0");
			}

			if (chargPatPriv) {
				u.setChargPatient("1");
			} else {
				u.setChargPatient("0");
			}

			if (suppPatPriv) {
				u.setSupPatient("1");
			} else {
				u.setSupPatient("0");
			}

			if (tabInfGnrAjtPatPriv) {
				u.setTabInfGenAjoutPat("1");
			} else {
				u.setTabInfGenAjoutPat("0");
			}

			

			if (tabContctPatPriv) {
				u.setTabCntctAjoutPat("1");
			} else {
				u.setTabCntctAjoutPat("0");
			}

			if (tabInfoConjAjtPatPriv) {
				u.setTabInfoConjAjoutPat("1");
			} else {
				u.setTabInfoConjAjoutPat("0");
			}

			if (tabAtreInfAjtPatPriv) {
				u.setTabAutreInfAjoutPat("1");
			} else {
				u.setTabAutreInfAjoutPat("0");
			}

			if (gestDocPriv) {
				u.setGestDoc("1");
			} else {
				u.setGestDoc("0");
			}
			
			if (gestAntecedentParamPriv) {
				u.setGestAntecedent(true);
			} else {
				u.setGestAntecedent(false);
			}
			if (paramtabAntMedPriv) {
				u.setTabMedAnt(true);
			} else {
				u.setTabMedAnt(false);
			}
			if (ajoutAntMedPriv) {
				u.setAjoutGestAntMed(true);
			} else {
				u.setAjoutGestAntMed(false);
			}
			if (modifAntMedPriv) {
				u.setModifGestAntMed(true);
			} else {
				u.setModifGestAntMed(false);
			}
			if (supAntMedPriv) {
				u.setSuppGestAntMed(true);
			} else {
				u.setSuppGestAntMed(false);
			}
			if (paramtabAntChirgPriv) {
				u.setTabChirAnt(true);
			} else {
				u.setTabChirAnt(false);
			}
			if (ajoutAntChirgPriv) {
				u.setAjoutGestChirg(true);
			} else {
				u.setAjoutGestChirg(false);
			}
			if (modifAntChirgPriv) {
				u.setModifGestChirg(true);
			} else {
				u.setModifGestChirg(false);
			}
			if (supAntChirgPriv) {
				u.setSuppGestAntChirg(true);
			} else {
				u.setSuppGestAntChirg(false);
			}
			
			if (paramtabAntFamPriv) {
				u.setTabFamAnt(true);
			} else {
				u.setTabFamAnt(false);
			}
			if (ajoutAntFamPriv) {
				u.setAjoutGestFam(true);
			} else {
				u.setAjoutGestFam(false);
			}
			if (modifAntFamPriv) {
				u.setModifGestFam(true);
			} else {
				u.setModifGestFam(false);
			}
			if (supAntFamPriv) {
				u.setSuppGestAntFam(true);
			} else {
				u.setSuppGestAntFam(false);
			}
			
			if (gestHorairePriv) {
				u.setGestHoraire(true);
			} else {
				u.setGestHoraire(false);
			}
			if (modifprdSaisPriv) {
				u.setModifPrtSais(true);
			} else {
				u.setModifPrtSais(false);
			}
			if (ajoutHorTravPriv) {
				u.setAjoutHeurTrav(true);
			} else {
				u.setAjoutHeurTrav(false);
			}
			if (modifHorTravPriv) {
				u.setModifHeurTrav(true);
			} else {
				u.setModifHeurTrav(false);
			}
			if (supHorTravPriv) {
				u.setSupHeurTrav(true);
			} else {
				u.setSupHeurTrav(false);
			}
			
			
			if(gestCabinetPriv){
				u.setGestCabinet(true);
			}else{
				u.setGestCabinet(false);
			}
			
			if (gestUtPriv) {
				u.setGestionUterus(true);
			} else {
				u.setGestionUterus(false);
			}
			if (ajoutUtPriv) {
				u.setAjoutUt(true);
			} else {
				u.setAjoutUt(false);
			}
			if (modifUtPriv) {
				u.setModifUt(true);
			} else {
				u.setModifUt(false);
			}
			if (supUtPriv) {
				u.setSupUt(true);
			} else {
				u.setSupUt(false);
			}
			
			if (gestFinGrossPriv) {
				u.setGestEFG("1");
			} else {
				u.setGestEFG("0");
			}
			if (ajoutFinGrossPriv) {
				u.setAjoutEFG(true);
			} else {
				u.setAjoutEFG(false);
			}
			if (modifFinGrossPriv) {
				u.setModifEFG(true);
			} else {
				u.setModifEFG(false);
			}
			if (supFinGrossPriv) {
				u.setSupEFG(true);
			} else {
				u.setSupEFG(false);
			}
			
			if (gestConsPriv) {
				u.setGestConsultation(true);
			} else {
				u.setGestConsultation(false);
			}
			if (modifConsPriv) {
				u.setModifCons(true);
			} else {
				u.setModifCons(false);
			}
			
			if (gestFrmMedPriv) {
				u.setGestionFormMed(true);
			} else {
				u.setGestionFormMed(false);
			}
			if (ajoutFrmMedPriv) {
				u.setAjoutFM(true);
			} else {
				u.setAjoutFM(false);
			}
			if (modifFrmMedPriv) {
				u.setModifFM(true);
			} else {
				u.setModifFM(false);
			}
			if (supFrmMedPriv) {
				u.setSupFM(true);
			} else {
				u.setSupFM(false);
			}

			if (gestProfPriv) {
				u.setGestProf("1");
			} else {
				u.setGestProf("0");
			}

			if (gestVilPriv) {
				u.setGestVil("1");
			} else {
				u.setGestVil("0");
			}

			if (gestCliPriv) {
				u.setGestClin("1");
			} else {
				u.setGestClin("0");
			}

			if (rappCertifPriv) {
				u.setRappCertif("1");
			} else {
				u.setRappCertif("0");
			}
			if (rappOrdncePriv) {
				u.setRappOrdnce("1");
			} else {
				u.setRappOrdnce("0");
			}
			if (rappLettrePriv) {
				u.setRappLettre("1");
			} else {
				u.setRappLettre("0");
			}

			if (montPatSalPriv) {
				u.setMonterPatSal("1");
			} else {
				u.setMonterPatSal("0");
			}
			if (descdrePatSalPriv) {
				u.setDesdrePatSal("1");
			} else {
				u.setDesdrePatSal("0");
			}
			if (permutPatSalPriv) {
				u.setPermutPatSal("1");
			} else {
				u.setPermutPatSal("0");
			}
			if (premierPatSalPriv) {
				u.setPremierPatSal("1");
			} else {
				u.setPremierPatSal("0");
			}
			if (dernierSalPriv) {
				u.setDernierPatSal("1");
			} else {
				u.setDernierPatSal("0");
			}
			if (supPatSalPriv) {
				u.setSupPatSal("1");
			} else {
				u.setSupPatSal("0");
			}
			if (chargPatSalPriv) {
				u.setChargPatSal("1");
			} else {
				u.setChargPatSal("0");
			}
			if (modifNoteSalPriv) {
				u.setModifNoteSal(true);;
			} else {
				u.setModifNoteSal(false);
			}
			if (reponseSalPriv) {
				u.setReponseSal(true);;
			} else {
				u.setReponseSal(false);
			}
			if (tabAnulSalPriv) {
				u.setTabAnulSal(true);;
			} else {
				u.setTabAnulSal(false);
			}
			if (anulSalPriv) {
				u.setAnulSal(true);;
			} else {
				u.setAnulSal(false);
			}
			
			if (donnerRdvPriv) {
				u.setDonnerRdv(true);
			} else {
				u.setDonnerRdv(false);
			}
			if (archiverPatPriv) {
				u.setArchiverPat(true);
			} else {
				u.setArchiverPat(false);
			}
			if (consultArchivePriv) {
				u.setConsultArchiv(true);
			} else {
				u.setConsultArchiv(false);
			}
			
			if (ajoutClinPriv) {
				u.setAjoutClin("1");
			} else {
				u.setAjoutClin("0");
			}
			if (modifClinPriv) {
				u.setModifClin("1");
			} else {
				u.setModifClin("0");
			}
			if (supClinPriv) {
				u.setSupClin("1");
			} else {
				u.setSupClin("0");
			}
			if (ajoutDocPriv) {
				u.setAjoutDoc("1");
			} else {
				u.setAjoutDoc("0");
			}
			if (modifDocPriv) {
				u.setModifDoc("1");
			} else {
				u.setModifDoc("0");
			}
			if (supDocPriv) {
				u.setSupDoc("1");
			} else {
				u.setSupDoc("0");
			}
			if (ajoutProfPriv) {
				u.setAjoutProf("1");
			} else {
				u.setAjoutProf("0");
			}
			if (modifProfPriv) {
				u.setModifProf("1");
			} else {
				u.setModifProf("0");
			}
			if (supProfPriv) {
				u.setSupProf("1");
			} else {
				u.setSupProf("0");
			}
			if (ajoutVilPriv) {
				u.setAjoutVil("1");
			} else {
				u.setAjoutVil("0");
			}
			if (modifVilPriv) {
				u.setModifVil("1");
			} else {
				u.setModifVil("0");
			}
			if (supVilPriv) {
				u.setSupVil("1");
			} else {
				u.setSupVil("0");
			}
			if (antecedentPriv) {
				u.setAntecedent("1");
			} else {
				u.setAntecedent("0");
			}
			if (echoGynPriv) {
				u.setEchoGyn("1");
			} else {
				u.setEchoGyn("0");
			}
			if (echoGynNouvConsultPriv) {
				u.setNouvchogyneco(true);
			} else {
				u.setNouvchogyneco(false);
			}
			if (echoGynModifConsultPriv) {
				u.setModifechogyneco(true);
			} else {
				u.setModifechogyneco(false);
			}
			if(echoGynsupConsultPriv){
				u.setSuppechogyneco(true);
			}else{
				u.setSuppechogyneco(false);
			}
			if(echoGynNouvModeltPriv){
				u.setAjoutmodelechogyneco(true);;
			}else{
				u.setAjoutmodelechogyneco(false);
			}
             
			if(echoGynSupModeltPriv){
				u.setSuppmodelechogyneco(true);
			}else{
				u.setSuppmodelechogyneco(false);
			}
			
			if(echoGynApplModeltPriv){
				u.setAppliquemodelechogyneco(true);
			}else{
				u.setAppliquemodelechogyneco(false);
			}
			if(echoGynImprPriv){
				u.setImprechogyneco(true);
			}else{
				u.setImprechogyneco(false);
			}
			
			if (echoObstPriv) {
				u.setEchoObs("1");
			} else {
				u.setEchoObs("0");
			}
			if (echoObsNouvConsultPriv) {
				u.setNouvechoObs(true);
			} else {
				u.setNouvechoObs(false);
			}
			if (echoObsModifConsultPriv) {
				u.setModifechoObs(true);
			} else {
				u.setModifechoObs(false);
			}
			
			if (echoObsSupConsultPriv) {
				u.setSuppechoObs(true);
			} else {
				u.setSuppechoObs(false);
			}
			if (echoObsTrim1Priv) {
				u.setTrim1echoObs(true);
			} else {
				u.setTrim1echoObs(false);
			}
			if (echoObsTrim2Priv) {
				u.setTrim2echoObs(true);
			} else {
				u.setTrim2echoObs(false);
			}
			
			if (echoObsTrim3Priv) {
				u.setTrim3echoObs(true);
			} else {
				u.setTrim3echoObs(false);
			}
			if (echoObsImprPriv) {
				u.setImprechoObs(true);
			} else {
				u.setImprechoObs(false);
			}
			
			if (gynecologiePriv) {
				u.setGynecologie("1");
			} else {
				u.setGynecologie("0");
			}
			if (consultGrossPriv) {
				u.setConsultGros("1");
			} else {
				u.setConsultGros("0");
			}
			if (sterilitePriv) {
				u.setSterilite("1");
			} else {
				u.setSterilite("0");
			}
			if (steriliteModifPriv) {
				u.setModifSterilite(false);
			} else {
				u.setModifSterilite(true);
			}
			if (tabAntecedentPriv) {
				u.setTabAntecedent("1");
			} else {
				u.setTabAntecedent("0");
			}
			if(modifGynObsPriv){
				u.setModifGynObs(true);;
			}else{
				u.setModifGynObs(false);
			}
			if(modifAntPriv){
				u.setModifAnt(true);;
			}else{
				u.setModifAnt(false);
			}
			if(suppAntPriv){
				u.setSuppAnt(true);
			}else{
				u.setSuppAnt(false);
			}
			
			
			if (tabGynecoObsPriv) {
				u.setTabGynecoObs("1");
			} else {
				u.setTabGynecoObs("0");
			}
			if (tabHistGrossPriv) {
				u.setTabHistGross("1");
			} else {
				u.setTabHistGross("0");
			}
			if (tabContracepPriv) {
				u.setTabContraception("1");
			} else {
				u.setTabContraception("0");
			}
			if (nouvGrossPriv) {
				u.setNouvGross("1");
			} else {
				u.setNouvGross("0");
			}
			if (nouvContracepPriv) {
				u.setNouvContraception("1");
			} else {
				u.setNouvContraception("0");
			}
			if (modifHistGrossPriv) {
				u.setModifHistGross("1");
			} else {
				u.setModifHistGross("0");
			}
			if (supHistGrossPriv) {
				u.setSupHistGross("1");
			} else {
				u.setSupHistGross("0");
			}
			if (modifContracepPriv) {
				u.setModifContraception("1");
			} else {
				u.setModifContraception("0");
			}
			if (supContacepPriv) {
				u.setSupConctraeption("1");
			} else {
				u.setSupConctraeption("0");
			}
			if (gynRadioPriv) {
				u.setGynRadio("1");
			} else {
				u.setGynRadio("0");
			}
			if (gynAnaPriv) {
				u.setGynAnal("1");
			} else {
				u.setGynAnal("0");
			}
			if (gynOrdPriv) {
				u.setGynOrd("1");
			} else {
				u.setGynOrd("0");
			}
			if (consultDetAnalPriv) {
				u.setConsultDetAnal(true);
			} else {
				u.setConsultDetAnal(false);
			}
			if (consultDetRadPriv) {
				u.setConsultDetRad(true);
			} else {
				u.setConsultDetRad(false);
			}
			if (consultDetOrdPriv) {
				u.setConsultDetOrd(true);
			} else {
				u.setConsultDetOrd(false);
			}
			
			if (gynNouvConsultPriv) {
				u.setNouvConsGyn("1");
			} else {
				u.setNouvConsGyn("0");
			}
			if(gynModifConsultPriv){
				u.setModifGyneco(true);
				
			}else{
				u.setModifGyneco(false);
			}
			
			if(gynSupConsultPriv){
				u.setSuppGyneco(true);
				
			}else{
				u.setSuppGyneco(false);
			}
			if(gynImprConsultPriv){
				u.setImprGyneco(true);
				
			}else{
				u.setImprGyneco(false);
			}
			if (grossOrdPriv) {
				u.setConsultGrossOrd("1");
			} else {
				u.setConsultGrossOrd("0");
			}
			if (grossSelectNouvConsultPriv) {
				u.setSelectNouvGross(true);
			} else {
				u.setSelectNouvGross(false);
			}
			if (grossModifConsultPriv) {
				u.setModifGross(true);
			} else {
				u.setModifGross(false);
			}
			if (grossSupvConsultPriv) {
				u.setSuppGross(true);
			} else {
				u.setSuppGross(false);
			}
			if (grossImprConsultPriv) {
				u.setImprGross(true);
			} else {
				u.setImprGross(false);
			}
			if (grossAnaPriv) {
				u.setConsultGrossAnal("1");
			} else {
				u.setConsultGrossAnal("0");
			}
			if (grossRadioPriv) {
				u.setConsultGrossRadio("1");
			} else {
				u.setConsultGrossRadio("0");
			}
			if (grossNouvConsultPriv) {
				u.setNouvConsGross("1");
			} else {
				u.setNouvConsGross("0");
			}
       
			ser.ajoutModelutl(u);	
			
			face.addMessage(null, new FacesMessage(
			FacesMessage.SEVERITY_INFO, "Modèle ajouté avec succès",""));
		//	addValid = true;
			
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('ajoutModel').hide();");
			
			
	}
		
		
		
	}

	
	
    public void applierModelutl(){
		
		if(idmodelUtl != null){
			
			ModelutlService ser= new ModelutlService();
			Modelutl u= new Modelutl();
			u=ser.rechercheModelutlbyId(idmodelUtl);
			
			gestExmComp = u.getGestExmComp();
			ajoutExmComp = u.isAjoutExmComp();
			modifExmComp = u.isModifExmComp();
			supExmComp = u.isSupExmComp();

			gestSym = u.getGestSyn();
			ajoutSym = u.isAjoutAsym();
			modifSym = u.isModifAsym();
			supSym = u.isSupAsym();

			gestDiag = u.getGestDiag();
			ajoutDiag = u.isAjoutDiag();
			modifDiag = u.isModifDiag();
			supDiag = u.isSupDiag();

			gestMoyCtr = u.getGestMoyCtrcep();
			ajoutMoyCtr = u.isAjoutMoyCtr();
			modifMoyCtr = u.isModifMoyCtr();
			supMoyCtr = u.isSupMoyCtr();

			gestExm = u.getGestExm();
			ajoutExm = u.isAjoutExm();
			modifExm = u.isModifExm();
			supExm = u.isSupExm();

			gestMed = u.getGestMed();
			ajoutMed = u.isAjoutMed();
			modifMed = u.isModifMed();
			supMed = u.isSupMed();

			gestEtbb = u.getGestBb();
			ajoutEtbb = u.isAjoutEtBb();
			modifEtbb = u.isModifEtBb();
			supEtbb = u.isSupEtBb();

			gestAnal = u.getGestAnal();
			ajoutAnal = u.isAjoutAnal();
			modifAnal = u.isModifAnal();
			supAnal = u.isSupAnal();

			verConsult = u.getVerConsult();
			nouvPatSal = u.getNouvPatSal();
			menuSal = u.getMenuSal();
			menuGestPat = u.getMenuGestPat();
			menuParametre = u.getMenuParametre();
			menuRapport = u.getMenuRapport();
			menuGestUtl = u.getMenuGestUtl();
			ajoutPatient = u.getAjoutPatient();
			verSal = u.getVerSal();
			;
			modPatient = u.getModPatient();
			detPatient = u.getDetPatient();
			chargPatient = u.getChargPatient();
			supPatient = u.getSupPatient();
			tabInfGenAjoutPat = u.getTabInfGenAjoutPat();

			tabCntctAjoutPat = u.getTabCntctAjoutPat();
			tabInfoConjAjoutPat = u.getTabInfoConjAjoutPat();
			tabAutreInfAjoutPat = u.getTabAutreInfAjoutPat();
			gestDoc = u.getGestDoc();
			gestProf = u.getGestProf();
			gestVil = u.getGestVil();
			gestClin = u.getGestClin();
			rappCertif = u.getRappCertif();
			rappOrdnce = u.getRappOrdnce();
			rappLettre = u.getRappLettre();
			monterPatSal = u.getMonterPatSal();
			desdrePatSal = u.getDesdrePatSal();
			permutPatSal = u.getPermutPatSal();
			premierPatSal = u.getPremierPatSal();
			dernierPatSal = u.getDernierPatSal();
			supPatSal = u.getSupPatSal();
			chargPatSal = u.getChargPatSal();
			antecedent = u.getAntecedent();

			ajoutDoc = u.getAjoutDoc();
			modifDoc = u.getModifDoc();
			supDoc = u.getSupDoc();
			ajoutClin = u.getAjoutClin();
			modifClin = u.getModifClin();
			supClin = u.getSupClin();
			ajoutProf = u.getAjoutProf();
			modifProf = u.getModifProf();
			supProf = u.getSupProf();
			ajoutVil = u.getAjoutVil();
			modifVil = u.getModifVil();
			supVil = u.getSupVil();

			echoGyn = u.getEchoGyn();
			echoObs = u.getEchoObs();
			gynecologie = u.getGynecologie();
			consultGros = u.getConsultGros();
			sterilite = u.getSterilite();

			tabAntecedent = u.getTabAntecedent();
			tabGynecoObs = u.getTabGynecoObs();
			tabHistGross = u.getTabHistGross();
			tabContraception = u.getTabContraception();
			supHistGross = u.getSupHistGross();
			modifHistGross = u.getModifHistGross();
			supConctraeption = u.getSupConctraeption();
			modifContraception = u.getModifContraception();
			nouvGross = u.getNouvGross();
			nouvContraception = u.getNouvContraception();

			gynRadio = u.getGynRadio();
			gynOrd = u.getGynOrd();
			gynAnal = u.getGynAnal();
			nouvConsGyn = u.getNouvConsGyn();

			grossAnal = u.getConsultGrossAnal();
			grossOrd = u.getConsultGrossOrd();
			grossRadio = u.getConsultGrossRadio();
			grossNouvCons = u.getNouvConsGross();

			certifFiche = u.getCertifFiche();
			lettreFiche = u.getLettreFiche();
			analyseFiche = u.getAnalyseFiche();
			radioFiche = u.getRadioFiche();
			rapportFiche = u.getRapportFiche();
			ordnanceFiche = u.getOrdnanceFiche();

			if (gestExmComp.equals("1")) {
				gestExmCompPriv = true;
			} else {
				gestExmCompPriv = false;
			}

			if (ajoutExmComp) {
				ajoutExmCompPriv = true;
			} else {
				ajoutExmCompPriv = false;
			}

			if (modifExmComp) {
				modifExmCompPriv = true;
			} else {
				modifSymPriv = false;
			}

			if (supExmComp) {
				supExmCompPriv = true;
			} else {
				supExmCompPriv = false;
			}

			if (gestSym.equals("1")) {
				gestSymPriv = true;
			} else {
				gestSymPriv = false;
			}

			if (ajoutSym) {
				ajoutSymPriv = true;
			} else {
				ajoutSymPriv = false;
			}

			if (modifSym) {
				modifSymPriv = true;
			} else {
				modifSymPriv = false;
			}

			if (supSym) {
				supSymPriv = true;
			} else {
				supSymPriv = false;
			}

			if (gestDiag.equals("1")) {
				gestDiagPriv = true;
			} else {
				gestDiagPriv = false;
			}

			if (ajoutDiag) {
				ajoutDiagPriv = true;
			} else {
				ajoutDiagPriv = false;
			}

			if (modifDiag) {
				modifDiagPriv = true;
			} else {
				modifDiagPriv = false;
			}

			if (supDiag) {
				supDiagPriv = true;
			} else {
				supDiagPriv = false;
			}

			if (gestMoyCtr.equals("1")) {
				gestMoyCtrPriv = true;
			} else {
				gestMoyCtrPriv = false;
			}

			if (ajoutMoyCtr) {
				ajoutMoyCtrPriv = true;
			} else {
				ajoutMoyCtrPriv = false;
			}

			if (modifMoyCtr) {
				modifMoyCtrPriv = true;
			} else {
				modifMoyCtrPriv = false;
			}

			if (supMoyCtr) {
				supMoyCtrPriv = true;
			} else {
				supMoyCtrPriv = false;
			}

			if (gestExm.equals("1")) {
				gestExmPriv = true;
			} else {
				gestExmPriv = false;
			}

			if (ajoutExm) {
				ajoutExmPriv = true;
			} else {
				ajoutExmPriv = false;
			}

			if (modifExm) {
				modifExmPriv = true;
			} else {
				modifExmPriv = false;
			}

			if (supExm) {
				supExmPriv = true;
			} else {
				supExmPriv = false;
			}
			
			if(u.isGestionJourFr()){
				gestJrFerParamPriv=true;
			}else{
				gestJrFerParamPriv=false;
			}
			if(u.isTabFerie()){
				paramtabJrFerPriv=true;
			}else{
				paramtabJrFerPriv=false;
			}
			if(u.isNouvJFerie()){
				ajouJrFerStndPriv=true;
			}else{
				ajouJrFerStndPriv=false;
			}
			if(u.isModifJFerie()){
				modifJrFerStndPriv=true;
			}else{
				modifJrFerStndPriv=false;
			}
			if(u.isSuppJFerie()){
				supJrFerStndPriv=true;
			}else{
				supJrFerStndPriv=false;
			}
			if(u.isTabJFerieExp()){
				paramtabJrFerExpPriv=true;
			}else{
				paramtabJrFerExpPriv=false;
			}
			if(u.isNouvJFerieExp()){
				ajouJrFerExpPriv=true;
			}else{
				ajouJrFerExpPriv=false;
			}
			if(u.isModifJFerieExp()){
				modifJrFerExpPriv=true;
			}else{
				modifJrFerExpPriv=false;
			}
			if(u.isSuppJFerieExp()){
				supJrFerExpPriv=true;
			}else{
				supJrFerExpPriv=false;
			}
			
			

			if (gestMed.equals("1")) {
				gestMedPriv = true;
			} else {
				gestMedPriv = false;
			}

			if (ajoutMed) {
				ajoutMedPriv = true;
			} else {
				ajoutMedPriv = false;
			}

			if (modifMed) {
				modifMedPriv = true;
			} else {
				modifMedPriv = false;
			}

			if (supMed) {
				supMedPriv = true;
			} else {
				supMedPriv = false;
			}

			if (gestAnal.equals("1")) {
				gestAnalPriv = true;
			} else {
				gestAnalPriv = false;
			}

			if (ajoutAnal) {
				ajoutAnalPriv = true;
			} else {
				ajoutAnalPriv = false;
			}

			if (modifAnal) {
				modifAnalPriv = true;
			} else {
				modifAnalPriv = false;
			}

			if (supAnal) {
				supAnalPriv = true;
			} else {
				supAnalPriv = false;
			}

			if (gestEtbb.equals("1")) {
				gestEtBbPriv = true;
			} else {
				gestEtBbPriv = false;
			}

			if (ajoutEtbb) {
				ajoutEtBbPriv = true;
			} else {
				ajoutEtBbPriv = false;
			}

			if (modifEtbb) {
				modifEtBbPriv = true;
			} else {
				modifEtBbPriv = false;
			}

			if (supEtbb) {
				supEtBbPriv = true;
			} else {
				supEtBbPriv = false;
			}

			if (certifFiche.equals("1")) {
				certifFichePriv = true;
			} else {
				certifFichePriv = false;
			}
			if(u.isNouvCertif()){
				ajoutCertifPriv=true;
			}else{
				ajoutCertifPriv=false;
			}
			if(u.isModifCertif()){
				modifCertifPriv=true;
			}else{
				modifCertifPriv=false;
			}
			if(u.isSuppCertif()){
				supCertifPriv=true;
			}else{
				supCertifPriv=false;
			}
			if(u.isImprCertif()){
				impCertifPriv=true;
			}else{
				impCertifPriv=false;
			}
			

			if (lettreFiche.equals("1")) {
				lettreFichePriv = true;
			} else {
				lettreFichePriv = false;
			}
			if(u.isNouvLettre()){
				ajoutLtrPriv=true;
			}else{
				ajoutLtrPriv=false;
			}
			if(u.isModifLettre()){
				modifLtrPriv=true;
			}else{
				modifLtrPriv=false;
			}
			if(u.isSuppLettre()){
				supLtrPriv=true;
			}else{
				supLtrPriv=false;
			}
			if(u.isImprLettre()){
				impLtrPriv=true;
			}else{
				impLtrPriv=false;
			}
			
			

			if (analyseFiche.equals("1")) {
				analyseFichePriv = true;
			} else {
				analyseFichePriv = false;
			}
			if(u.isModifAnalyse()){
				modifHistoAnalPriv=true;
			}else{
				modifHistoAnalPriv=false;
			}
			if(u.isDetHistoAnal()){
				consultHistoAnalPriv=true;
			}else{
				consultHistoAnalPriv=false;
			}
			
			if(u.isSupAnalyse()){
				supHistoAnalPriv=true;
			}else{
				supHistoAnalPriv=false;
			}
			
			
			
			if (radioFiche.equals("1")) {
				radioFichePriv = true;
			} else {
				radioFichePriv = false;
			}
			if(u.isModifRadio()){
				modifHistoRadPriv=true;
			}else{
				modifHistoRadPriv=false;
			}
			if(u.isDetHistoRad()){
				consultHistoRadPriv=true;
			}else{
				consultHistoRadPriv=false;
			}
			if(u.isSupRadio()){
				supHistoRadPriv=true;
			}else{
				supHistoRadPriv=false;
			}
			if(u.isImprRadio()){
				imprRadioPriv=true;
			}else{
				imprRadioPriv=false;
			}
			if(u.isImprmAnal()){
				imprAnalPriv=true;
			}else{
				imprAnalPriv=false;
			}
			
			
			if (rapportFiche.equals("1")) {
				rapportFichePriv = true;
			} else {
				rapportFichePriv = false;
			}
			
			if(u.isAjoutModeleord()){
				ajoutModeleordPriv=true;
			}else{
				ajoutModeleordPriv=false;
			}
			if(u.isSelectModeleord()){
				selectModeleordPriv=true;
			}else{
				selectModeleordPriv=false;
			}
			if(u.isSuppModeleOrd()){
				suppModeleOrdPriv=true;
			}else{
				suppModeleOrdPriv=false;
			}
			
			if(u.isGestSais()){
				gestSaisPriv=true;
			}else{
				gestSaisPriv=false;
			}
			
			if(consultertHistoConsultationPriv){
				u.setSelectTableConsultation(true);
			}else{
				u.setSelectTableConsultation(false);
			}

			if (ordnanceFiche.equals("1")) {
				ordonceFichePriv = true;
			} else {
				ordonceFichePriv = false;
			}
			if(u.isOrdonanceLibreFiche()){
				consultOrdLibrePriv=true;
			}else{
				consultOrdLibrePriv=false;
			}
			if(u.isModifOrdnce()){
				modifHistoOrdPriv=true;
			}else{
				modifHistoOrdPriv=false;
			}
			if(u.isSupphistoOrd()){
				supHistoOrdPriv=true;
			}else{
				supHistoOrdPriv=false;
			}
			if(u.isRechercheOrd()){
				rechercheOrdPriv=true;
			}else{
				rechercheOrdPriv=false;
			}
			if(u.isImprOrd()){
				imprOrdPriv=true;
			}else{
				imprOrdPriv=false;
			}
			
			
			
			if (verConsult.equals("1")) {
				verConsultPriv = true;
			} else {
				verConsultPriv = false;
			}
			

			if (menuSal.equals("1")) {
				menuSalPriv = true;
			} else {
				menuSalPriv = false;
			}

			if (menuGestPat.equals("1")) {
				menuGesPatPriv = true;
			} else {
				menuGesPatPriv = false;
			}

			if (menuGestUtl.equals("1")) {
				menuGesUtlPriv = true;
			} else {
				menuGesUtlPriv = false;
			}

			if (menuParametre.equals("1")) {
				menuParamPriv = true;
			} else {
				menuParamPriv = false;
			}
			
			if(u.getMenuGestRdv().equals("1")){
				menuRendvousPriv=true;
			}else{
				menuRendvousPriv=false;
			}

			if (menuRapport.equals("1")) {
				menuRappPriv = true;
			} else {
				menuRappPriv = false;
			}
			
			if (u.isMenuGestStat()) {
				menuStatPriv = true;
			} else {
				menuStatPriv = false;
			}

			if (ajoutPatient.equals("1")) {
				ajouPatPriv = true;
			} else {
				ajouPatPriv = false;
			}

			if (verSal.equals("1")) {
				verSalPriv = true;
			} else {
				verSalPriv = false;
			}

			if (modPatient.equals("1")) {
				modifPatPriv = true;
			} else {
				modifPatPriv = false;
			}

			if (detPatient.equals("1")) {
				detPatPriv = true;
			} else {
				detPatPriv = false;
			}

			if (chargPatient.equals("1")) {
				chargPatPriv = true;
			} else {
				chargPatPriv = false;
			}

			if (supPatient.equals("1")) {
				suppPatPriv = true;
			} else {
				suppPatPriv = false;
			}

			if (tabInfGenAjoutPat.equals("1")) {
				tabInfGnrAjtPatPriv = true;
			} else {
				tabInfGnrAjtPatPriv = false;
			}

			if (tabCntctAjoutPat.equals("1")) {
				tabContctPatPriv = true;
			} else {
				tabContctPatPriv = false;
			}

			if (tabInfoConjAjoutPat.equals("1")) {
				tabInfoConjAjtPatPriv = true;
			} else {
				tabInfoConjAjtPatPriv = false;
			}
			if (tabAutreInfAjoutPat.equals("1")) {
				tabAtreInfAjtPatPriv = true;
			} else {
				tabAtreInfAjtPatPriv = false;
			}

			if (gestDoc.equals("1")) {
				gestDocPriv = true;
			} else {
				gestDocPriv = false;
			}
			
			if(u.isGestAntecedent()){
				gestAntecedentParamPriv=true;
			}else{
				gestAntecedentParamPriv=false;
			}
			if(u.isTabMedAnt()){
				paramtabAntMedPriv=true;
			}else{
				paramtabAntMedPriv=false;
			}
			
			if(u.isAjoutGestAntMed()){
				ajoutAntMedPriv=true;
			}else{
				ajoutAntMedPriv=false;
			}
			if(u.isModifGestAntMed()){
				modifAntMedPriv=true;
			}else{
				modifAntMedPriv=false;
			}
			if(u.isSuppGestAntMed()){
				supAntMedPriv=true;
			}else{
				supAntMedPriv=false;
			}
			if(u.isTabChirAnt()){
				paramtabAntChirgPriv=true;
			}else{
				paramtabAntChirgPriv=false;
			}
			if(u.isAjoutGestChirg()){
				ajoutAntChirgPriv=true;
			}else{
				ajoutAntChirgPriv=false;
			}
			if(u.isModifGestChirg()){
				modifAntChirgPriv=true;
			}else{
				modifAntChirgPriv=false;
			}
			if(u.isSuppGestAntChirg()){
				supAntChirgPriv=true;
			}else{
				supAntChirgPriv=false;
			}
			
			if(u.isTabFamAnt()){
				paramtabAntFamPriv=true;
			}else{
				paramtabAntFamPriv=false;
			}
			if(u.isAjoutGestFam()){
				ajoutAntFamPriv=true;
			}else{
				ajoutAntFamPriv=false;
			}
			if(u.isModifGestFam()){
				modifAntFamPriv=true;
			}else{
				modifAntFamPriv=false;
			}
			if(u.isSuppGestAntFam()){
				supAntFamPriv=true;
			}else{
				supAntFamPriv=false;
			}
			

			if(u.isGestHoraire()){
				gestHorairePriv=true;
			}else{
				gestHorairePriv=false;
			}
			
			if(u.isModifPrtSais()){
				modifprdSaisPriv=true;
			}else{
				modifprdSaisPriv=false;
			}
			if(u.isAjoutHeurTrav()){
				ajoutHorTravPriv=true;
			}else{
				ajoutHorTravPriv=false;
			}
			if(u.isAjoutHeurTrav()){
				modifHorTravPriv=true;
			}else{
				modifHorTravPriv=false;
			}
			if(u.isSupHeurTrav()){
				supHorTravPriv=true;
			}else{
				supHorTravPriv=false;
			}
			
			
			if(u.isGestCabinet()){
				gestCabinetPriv=true;
			}else{
				gestCabinetPriv=false;
			}
			
			if(u.isGestionUterus()){
				gestUtPriv=true;
			}else{
				gestUtPriv=false;
			}
	        if(u.isAjoutUt()){
	        	ajoutUtPriv=true;
	        }else{
	        	ajoutUtPriv=false;
	        }
	        if(u.isModifUt()){
	        	modifUtPriv=true;
	        }else{
	        	modifUtPriv=false;
	        }
	        if(u.isSupUt()){
	        	supUtPriv=true;
	        }else{
	        	supUtPriv=false;
	        }
	        
	        if(u.getGestEFG().equals("1")){
	        	gestFinGrossPriv=true;
	        }else{
	        	gestFinGrossPriv=false;
	        }
	        if(u.isAjoutEFG()){
	        	ajoutFinGrossPriv=true;
	        }else{
	        	ajoutFinGrossPriv=false;
	        }
	        if(u.isModifEFG()){
	        	modifFinGrossPriv=true;
	        }else{
	        	modifFinGrossPriv=false;
	        }
	        if(u.isSupEFG()){
	        	supFinGrossPriv=true;
	        }else{
	        	supFinGrossPriv=false;
	        }
	        
	        if(u.isGestConsultation()){
	        	gestConsPriv=true;
	        }else{
	        	gestConsPriv=false;
	        }
	        if(u.isModifCons()){
	        	modifConsPriv=true;
	        }else{
	        	modifConsPriv=false;
	        }
	        
	        if(u.isGestionFormMed()){
	        	gestFrmMedPriv=true;
	        }else{
	        	gestFrmMedPriv=false;
	        }
	        if(u.isAjoutFM()){
	        	ajoutFrmMedPriv=true;
	        }else{
	        	ajoutFrmMedPriv=false;
	        }
	        if(u.isModifFM()){
	        	modifFrmMedPriv=true;
	        }else{
	        	modifFrmMedPriv=false;
	        }
	        if(u.isSupFM()){
	        	supFrmMedPriv=true;
	        }else{
	        	supFrmMedPriv=false;
	        }
	        
	        
			
			if (gestProf.equals("1")) {
				gestProfPriv = true;
			} else {
				gestProfPriv = false;
			}

			if (gestVil.equals("1")) {

				gestVilPriv = true;
			} else {
				gestVilPriv = false;
			}
			if (gestClin.equals("1")) {

				gestCliPriv = true;
			} else {

				gestCliPriv = false;
			}
			if (rappCertif.equals("1")) {
				rappCertifPriv = true;
			} else {
				rappCertifPriv = false;
			}
			if (rappOrdnce.equals("1")) {
				rappOrdncePriv = true;
			} else {
				rappOrdncePriv = false;
			}
			if (rappLettre.equals("1")) {
				rappLettrePriv = true;
			} else {
				rappLettrePriv = false;
			}
			if (monterPatSal.equals("1")) {
				montPatSalPriv = true;
			} else {
				montPatSalPriv = false;
			}

			if (desdrePatSal.equals("1")) {
				descdrePatSalPriv = true;
			} else {
				descdrePatSalPriv = false;
			}
			if (permutPatSal.equals("1")) {
				permutPatSalPriv = true;
			} else {
				permutPatSalPriv = false;
			}
			if (premierPatSal.equals("1")) {
				premierPatSalPriv = true;
			} else {
				premierPatSalPriv = false;
			}
			if (dernierPatSal.equals("1")) {
				dernierSalPriv = true;
			} else {
				dernierSalPriv = false;
			}
			if (supPatSal.equals("1")) {
				supPatSalPriv = true;
			} else {
				supPatSalPriv = false;
			}

			if (chargPatSal.equals("1")) {
				chargPatSalPriv = true;
			} else {
				chargPatSalPriv = false;
			}
			if (u.isModifNoteSal()) {
				modifNoteSalPriv = true;
			} else {
				modifNoteSalPriv = false;
			}
			if (u.isReponseSal()) {
				reponseSalPriv = true;
			} else {
				reponseSalPriv = false;
			}
			if (u.isTabAnulSal()) {
				tabAnulSalPriv = true;
			} else {
				tabAnulSalPriv = false;
			}
			if (u.isAnulSal()) {
				anulSalPriv = true;
			} else {
				anulSalPriv = false;
			}
			
			if (u.isDonnerRdv()) {
				donnerRdvPriv = true;
			} else {
				donnerRdvPriv = false;
			}
			if (u.isArchiverPat()) {
				archiverPatPriv= true;
			} else {
				archiverPatPriv = false;
			}
			if (u.isConsultArchiv()) {
				consultArchivePriv= true;
			} else {
				consultArchivePriv = false;
			}	

			if (ajoutDoc.equals("1")) {
				ajoutDocPriv = true;
			} else {
				ajoutDocPriv = false;
			}
			if (modifDoc.equals("1")) {
				modifDocPriv = true;
			} else {
				modifDocPriv = false;
			}
			if (supDoc.equals("1")) {
				supDocPriv = true;
			} else {
				supDocPriv = false;
			}
			if (ajoutProf.equals("1")) {
				ajoutProfPriv = true;
			} else {
				ajoutProfPriv = false;
			}
			if (modifProf.equals("1")) {
				modifProfPriv = true;
			} else {
				modifProfPriv = false;
			}
			if (supProf.equals("1")) {
				supProfPriv = true;
			} else {
				supProfPriv = false;
			}
			if (ajoutVil.equals("1")) {
				ajoutVilPriv = true;
			} else {
				ajoutVilPriv = false;
			}
			if (modifVil.equals("1")) {
				modifVilPriv = true;
			} else {
				modifVilPriv = false;
			}
			if (supVil.equals("1")) {
				supVilPriv = true;
			} else {
				supVilPriv = false;
			}
			if (ajoutClin.equals("1")) {
				ajoutClinPriv = true;
			} else {
				ajoutClinPriv = false;
			}
			if (modifClin.equals("1")) {
				modifClinPriv = true;
			} else {
				modifClinPriv = false;
			}
			if (supClin.equals("1")) {
				supClinPriv = true;
			} else {
				supClinPriv = false;
			}
			if (antecedent.equals("1")) {
				antecedentPriv = true;
			} else {
				antecedentPriv = false;
			}
			if (echoGyn.equals("1")) {
				echoGynPriv = true;
			} else {
				echoGynPriv = false;
			}
			if(u.isNouvchogyneco()){
				echoGynNouvConsultPriv=true;
			}else{
				echoGynNouvConsultPriv=false;
			}
			
			if(u.isModifechogyneco()){
				echoGynModifConsultPriv=true;
			}else{
				echoGynModifConsultPriv=false;
			}
			
			if(u.isSuppechogyneco()){
				echoGynsupConsultPriv=true;
			}else{
				echoGynsupConsultPriv=false;
			}
			
			if(u.isAjoutmodelechogyneco()){
				echoGynNouvModeltPriv=true;
			}else{
				echoGynNouvModeltPriv=false;
			}
			
			if(u.isSuppmodelechogyneco()){
				echoGynSupModeltPriv=true;
			}else{
				echoGynSupModeltPriv=false;
			}
			
			if(u.isAppliquemodelechogyneco()){
				echoGynApplModeltPriv=true;
			}else{
				echoGynApplModeltPriv=false;
			}
			
			if(u.isImprechogyneco()){
				echoGynImprPriv=true;
			}else{
				echoGynImprPriv=false;
			}
			
			if (echoObs.equals("1")) {
				echoObstPriv = true;
			} else {
				echoObstPriv = false;
			}
			if(u.isModifechoObs()){
				echoObsModifConsultPriv=true;
			}else{
				echoObsModifConsultPriv=false;
			}
			if(u.isNouvechoObs()){
				echoObsNouvConsultPriv=true;
			}else{
				echoObsNouvConsultPriv=false;
			}
			if(u.isSuppechoObs()){
				echoObsSupConsultPriv=true;
			}else{
				echoObsSupConsultPriv=false;
			}
			if(u.isTrim1echoObs()){
				echoObsTrim1Priv=true;
			}else{
				echoObsTrim1Priv=false;
			}
			if(u.isTrim2echoObs()){
				echoObsTrim2Priv=true;
			}else{
				echoObsTrim2Priv=false;
			}
			if(u.isImprechoObs()){
				echoObsImprPriv=true;
			}else{
				echoObsImprPriv=false;
			}
			
			if(u.isTrim3echoObs()){
				echoObsTrim3Priv=true;
			}else{
				echoObsTrim3Priv=false;
			}
			
			
			if (gynecologie.equals("1")) {
				gynecologiePriv = true;
			} else {
				gynecologiePriv = false;
			}
			if (consultGros.equals("1")) {
				consultGrossPriv = true;
			} else {
				consultGrossPriv = false;
			}
			if (sterilite.equals("1")) {
				sterilitePriv = true;
			} else {
				sterilitePriv = false;
			}
			if(u.isModifSterilite()){
				steriliteModifPriv=true;
			}else{
				steriliteModifPriv=false;
			}
			if (tabAntecedent.equals("1")) {
				tabAntecedentPriv = true;
			} else {
				tabAntecedentPriv = false;
			}
			
			if(u.isModifGynObs()){
				modifGynObsPriv=true;
			}else{
				modifGynObsPriv=false;
			}
			if(u.isModifAnt()){
				modifAntPriv=true;
			}else{
				modifAntPriv=false;
			}
			if(u.isSuppAnt()){
				suppAntPriv=true;
			}else{
				suppAntPriv=false;
			}
			if (tabGynecoObs.equals("1")) {
				tabGynecoObsPriv = true;
			} else {
				tabGynecoObsPriv = false;
			}
			if (tabHistGross.equals("1")) {
				tabHistGrossPriv = true;
			} else {
				tabHistGrossPriv = false;
			}
			if (tabContraception.equals("1")) {
				tabContracepPriv = true;
			} else {
				tabContracepPriv = false;
			}
			if (nouvGross.equals("1")) {
				nouvGrossPriv = true;
			} else {
				nouvGrossPriv = false;
			}
			if (nouvContraception.equals("1")) {
				nouvContracepPriv = true;
			} else {
				nouvContracepPriv = false;
			}
			if (modifHistGross.equals("1")) {
				modifHistGrossPriv = true;
			} else {
				modifHistGrossPriv = false;
			}
			if (supHistGross.equals("1")) {
				supHistGrossPriv = true;
			} else {
				supHistGrossPriv = false;
			}
			if (modifContraception.equals("1")) {
				modifContracepPriv = true;
			} else {
				modifContracepPriv = false;
			}
			if (supConctraeption.equals("1")) {
				supContacepPriv = true;
			} else {
				supContacepPriv = false;
			}
			if (gynAnal.equals("1")) {
				gynAnaPriv = true;
			} else {
				gynAnaPriv = false;
			}
			if (gynOrd.equals("1")) {
				gynOrdPriv = true;
			} else {
				gynOrdPriv = false;
			}
			
			if (u.isConsultDetAnal()) {
				consultDetAnalPriv = true;
			} else {
				consultDetAnalPriv = false;
			}
			if (u.isConsultDetRad()) {
				consultDetRadPriv = true;
			} else {
				consultDetRadPriv = false;
			}
			if (u.isConsultDetOrd()) {
				consultDetOrdPriv = true;
			} else {
				consultDetOrdPriv = false;
			}
			
			if (gynRadio.equals("1")) {
				gynRadioPriv = true;
			} else {
				gynRadioPriv = false;
			}
			if (nouvConsGyn.equals("1")) {
				gynNouvConsultPriv = true;
			} else {
				gynNouvConsultPriv = false;
			}
			if(u.isModifGyneco()){
				gynModifConsultPriv=true;
			}else{
				gynModifConsultPriv=false;
			}
			
			if(u.isSuppGyneco()){
				gynSupConsultPriv=true;
			}else{
				gynSupConsultPriv=false;
			}
			
			if(u.isImprGyneco()){
				gynImprConsultPriv=true;
			}else{
				gynImprConsultPriv=false;
			}
				
			if (grossRadio.equals("1")) {
				grossRadioPriv = true;
			} else {
				grossRadioPriv = false;
			}
			if (grossOrd.equals("1")) {
				grossOrdPriv = true;
			} else {
				grossOrdPriv = false;
			}
			if(u.isSelectNouvGross()){
				grossSelectNouvConsultPriv=true;
			}else{
				grossSelectNouvConsultPriv=false;
			}
			if(u.isModifGross()){
				grossModifConsultPriv=true;
			}else{
				grossModifConsultPriv=false;
			}
			if(u.isSuppGross()){
				grossSupvConsultPriv=true;
			}else{
				grossSupvConsultPriv=false;
			}
			if(u.isImprGross()){
				grossImprConsultPriv=true;
			}else{
				grossImprConsultPriv=false;
			}
	        
			if (grossAnal.equals("1")) {
				grossAnaPriv = true;
			} else {
				grossAnaPriv = false;
			}
			if (grossNouvCons.equals("1")) {
				grossNouvConsultPriv = true;
			} else {
				grossNouvConsultPriv = false;
			}

			FacesContext face = FacesContext.getCurrentInstance();
			face.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Modèle appliqué avec succès",""));
		}
		
		
		
			
		}
	
	
    public void init(){
    	nomModelUtl=null;
    }
	
	public void supprimerModelutl(Integer idm){
		FacesContext face = FacesContext.getCurrentInstance();
		ModelutlService ser = new ModelutlService();
		ser.supprimerModelutl(idm);
		
		face.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Modèle supprimé avec succès",
				""));
		           
		         index=1;
	             redirectverajoututl();
	}
	
	public void supprimerModelutlfromModif(Integer idm){
		FacesContext face = FacesContext.getCurrentInstance();
		ModelutlService ser = new ModelutlService();
		ser.supprimerModelutl(idm);
		
		face.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Modèle supprimé avec succès",
				""));
		           
		         index=1;
		         redirectverModifutl();
	}
	
	
	public void gotoAcceuil() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void gotoGestionUtl() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Utilisateurs");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void updateF1(){
		
		
		
		RequestContext.getCurrentInstance().update("f1");
	}
	
	
	public void activerSousArbre(){
		
		
		
		
		if(gynAnaPriv){
			
			consultAnalActiv=false;
		}else{
			consultAnalActiv=true;
		}
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
