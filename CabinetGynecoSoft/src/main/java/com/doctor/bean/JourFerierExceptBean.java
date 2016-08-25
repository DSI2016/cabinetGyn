package com.doctor.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.doctor.persistance.JourFrSp;
import com.doctor.service.JourFrSpService;

@ManagedBean(name = "jourFerierExceptBean")
@SessionScoped
public class JourFerierExceptBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idjourFrSp;
	private Date debut;
	private Date fin;
	private String discSp;
	private List<JourFrSp> jourFrSps = new ArrayList<JourFrSp>();
	private String actionSp;

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

	public List<JourFrSp> getJourFrSps() {
		JourFrSpService ser = new JourFrSpService();
		jourFrSps = ser.rechercheTousJourFrSp();
		return jourFrSps;
	}

	public void setJourFrSps(List<JourFrSp> jourFrSps) {
		this.jourFrSps = jourFrSps;
	}

	public String getActionSp() {
		return actionSp;
	}

	public void setActionSp(String actionSp) {
		this.actionSp = actionSp;
	}

	public String getDiscSp() {
		return discSp;
	}

	public void setDiscSp(String discSp) {

		this.discSp = discSp;
	}

	public void ajoutSp() {
		initSp();
		actionSp = "Ajouter";
	}

	public void modifSp(JourFrSp jourFrSp) {
		initSp();
		idjourFrSp = jourFrSp.getIdjourFrSp();
		debut = jourFrSp.getDebut();
		fin = jourFrSp.getFin();
		discSp = jourFrSp.getDisc();

		actionSp = "Modifier";
	}

	public void initSp() {
		idjourFrSp = null;
		debut = null;
		fin = null;
		discSp = null;
		
	}

	public String ValidationSp() {
		if (actionSp.equals("Ajouter")) {
			JourFrSpService ser = new JourFrSpService();
			JourFrSp jfs = new JourFrSp();
			jfs.setDebut(debut);
			jfs.setFin(fin);
			jfs.setDisc(discSp);
			ser.ajoutJourFrSp(jfs);

		} else if (actionSp.equals("Modifier")) {
			JourFrSpService ser = new JourFrSpService();
			JourFrSp jfs = new JourFrSp();
			jfs.setDebut(debut);
			jfs.setFin(fin);
			jfs.setDisc(discSp);

			jfs.setIdjourFrSp(idjourFrSp);
			ser.modifierJourFrSp(jfs);
		}
		initSp();
		return null;
	}

	public void ValidationSpModif() {
		JourFrSpService ser = new JourFrSpService();
		JourFrSp jfs = new JourFrSp();
		jfs.setDebut(debut);
		jfs.setFin(fin);
		jfs.setDisc(discSp);

		jfs.setIdjourFrSp(idjourFrSp);
		ser.modifierJourFrSp(jfs);
		initSp();
	}

	public void supprimerJourFrSp(Integer id) {
		JourFrSpService ser = new JourFrSpService();
		ser.supprimerJourFrSp(id);
	}
}
