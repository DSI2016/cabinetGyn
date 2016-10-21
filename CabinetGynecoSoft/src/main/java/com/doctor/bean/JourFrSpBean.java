package com.doctor.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.doctor.persistance.JourFrSp;
import com.doctor.service.JourFrSpService;

@ManagedBean(name = "jourFrSpBean")
@SessionScoped
public class JourFrSpBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idjourFrSp;
	private Date debut;
	private Date fin;
	private String disc;
	private List<JourFrSp> jourFrSps = new ArrayList<JourFrSp>();

	public List<JourFrSp> getJourFrSps() {
		JourFrSpService ser = new JourFrSpService();
		jourFrSps = ser.rechercheTousJourFrSp();
		return jourFrSps;
	}

	public void setJourFrSps(List<JourFrSp> jourFrSps) {
		this.jourFrSps = jourFrSps;
	}

	public Integer getIdjourFrSp() {
		return idjourFrSp;
	}

	public void setIdjourFrSp(Integer idjourFrSp) {
		this.idjourFrSp = idjourFrSp;
	}
	
	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}



	/*private boolean ajoutJourFr;
	private boolean modifJourFr;
	private boolean supprimerJourFr;
	private String valeurRecherche;
	
	public String getValeurRecherche() {
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		valeurRecherche = null;
	}

	/*public boolean isAjoutJourFr() {
		if(Module.ajoutJf.equals("0"))
			ajoutJourFr=false;
		else
			ajoutJourFr=true;
		return ajoutJourFr;
	}

	public void setAjoutJourFr(boolean ajoutJourFr) {
		this.ajoutJourFr = ajoutJourFr;
	}

	/*public boolean isModifJourFr() {
		if(Module.modifJf.equals("0"))
			modifJourFr=false;
		else
			modifJourFr=true;
		return modifJourFr;
	}

	public void setModifJourFr(boolean modifJourFr) {
		this.modifJourFr = modifJourFr;
	}

	/*public boolean isSupprimerJourFr() {
		if(Module.supJf.equals("0"))
			supprimerRenderVous=false;
		else
			supprimerRendzVous=true;
		return supprimerJourFr;
	}

	public void setSupprimerJourFr(boolean supprimerJourFr) {
		this.supprimerJourFr = supprimerJourFr;
	}
	*/
	// action est un attribut pour différencier l'ajout de la modification
	private String action = "";

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public void init(){
		idjourFrSp = 0;
		debut = null;
		fin = null;
		disc = "";
	}
	
	public void ajout(){
		init();
		action = "Ajouter";
	}
	
	public void ajouterJourFrSp(){
		//JourFrSpService ser = new JourFrSpService();
		//ser.ajoutJourFrSp(new JourFrSp(debut, fin, disc));
		
	}
	
	public void supprimerJourFrSp(Integer id){
		JourFrSpService ser = new JourFrSpService();
		ser.supprimerJourFrSp(id);
	}
	
	public void modif(JourFrSp obj){
		idjourFrSp = obj.getIdjourFrSp();
		debut = obj.getDebut();
		fin = obj.getFin();
		disc = obj.getDisc();
		action = "Modifier";
	}
	
	public void modifierJourFrSp(){
		JourFrSpService ser = new JourFrSpService();
		JourFrSp obj = new JourFrSp();
		obj.setIdjourFrSp(idjourFrSp);
		obj.setDebut(debut);
		obj.setFin(fin);
		obj.setDisc(disc);
		ser.modifierJourFrSp(obj);
		init();
	}
	
	public void Validation(){
		FacesContext faces = FacesContext.getCurrentInstance();

		if(action.equals("Ajouter")){
			ajouterJourFrSp();
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Succès !","Jour férier personelle ajoté !"));
		}
		else{
			modifierJourFrSp();
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Succès !","Jour férier personelle modifié !"));
		}
	}
	
}
