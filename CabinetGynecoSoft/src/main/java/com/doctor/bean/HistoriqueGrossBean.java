package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.EtatBebe;
import com.doctor.persistance.HistoriqueGross;
import com.doctor.service.CfclientService;
import com.doctor.service.EtatBebeService;
import com.doctor.service.HistoriqueGrossService;


@ManagedBean(name="historiqueGrossBean")
@SessionScoped
public class HistoriqueGrossBean {
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
	private String etatBebe;
	private Float poids;
	private Integer idPatient;
	private Cfclient cfclient;
	private List<HistoriqueGross> listHistoriqueGross=new ArrayList<HistoriqueGross>();
	private List<EtatBebe> etatBebes=new ArrayList<EtatBebe>();
	
	
	
	public List<EtatBebe> getEtatBebes() {
		EtatBebeService ser=new EtatBebeService();
		etatBebes=ser.rechercheTousEtatBebe();
		return etatBebes;
	}
	public void setEtatBebes(List<EtatBebe> etatBebes) {
		this.etatBebes = etatBebes;
	}
	public List<HistoriqueGross> getListHistoriqueGross() {
	
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
	public Integer getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}
	public Cfclient getCfclient() {
		return cfclient;
	}
	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}
	public void initialisation()
	{
		 debutGross=null;
		 finGross=null;
		 notes=null;
		 honoraires=null;
		 etatFinGross=null;
		 terme=null;
		 lieu=null;
		 prenomBebe=null;
		 sexeBebe=null;
		 etatBebe=null;
		 poids=null;
		
	}
	public void validerBebe(){
		HistoriqueGross hg=new HistoriqueGross();
		HistoriqueGross hg2=new HistoriqueGross();
		CfclientService se=new CfclientService();
		Cfclient cf=new Cfclient();
		HistoriqueGrossService sere =new HistoriqueGrossService();
		if((Module.action).equals("nouveau"))
		{   hg.setFinGross(finGross);
			//hg.setEtatFinGross(etatFinGross);
			hg.setLieu(lieu);
			hg.setTerme(terme);
			hg.setPrenomBebe(prenomBebe);
			hg.setPoids(poids);
			hg.setSexeBebe(sexeBebe);
			//hg.setEtatBebe(etatBebe);
	   
			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			idPatient = (Integer) session.getAttribute("idu");
		cf=se.RechercheCfclient(idPatient);
		
		cf.setPartie(cf.getPartie()+1);
		cf.setGestite(cf.getGestite()+1);
	    se.modifierPatient(cf);
		hg.setCfclient(cf);
	    sere.ajouterHistoriqueGross(hg);
		initialisation();
	
	}
		else if(Module.action.equals("modifier"))
		{
			hg2=sere.rechercheHistoriqueGrossParId(idhistoriqueGross);
			if(hg2!=null)
			{
				//hg2.setEtatBebe(etatBebe);
				//hg2.setEtatFinGross(etatFinGross);
				//hg2.setEtatBebe(etatBebe);
				hg2.setLieu(lieu);
				hg2.setPoids(poids);
				hg2.setTerme(terme);
				hg2.setPrenomBebe(prenomBebe);
				hg2.setFinGross(finGross);
				sere.ModifierHistoriqueGross(hg2);
			}
		
		}
		
		
		
	}
	
}
	
