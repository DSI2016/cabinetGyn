package com.doctor.bean;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.doctor.persistance.Horaire;
import com.doctor.persistance.Jour;

@ManagedBean(name = "jourBean")
@SessionScoped
public class JourBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private List<Jour> Jours = new ArrayList<Jour>();
	private Integer ID;
	private String nom;
	private Horaire horaire;
	private Horaire horaire2;
	private int active;

	public List<Jour> getJours() {
		return Jours;
	}

	public void setJours(List<Jour> jours) {
		Jours = jours;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	public Horaire getHoraire2() {
		return horaire2;
	}

	public void setHoraire2(Horaire horaire2) {
		this.horaire2 = horaire2;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
