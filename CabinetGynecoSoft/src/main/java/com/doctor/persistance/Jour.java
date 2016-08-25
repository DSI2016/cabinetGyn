package com.doctor.persistance;

import java.io.Serializable;

public class Jour implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idjour;
	private String  nom;
	private Horaire horaire;
	private Horaire horaire2;
	private int active;
	
	public Jour() {
	}
	
	public Integer getIdjour() {
		return idjour;
	}
	
	public void setIdjour(Integer idjour) {
		this.idjour = idjour;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + ((horaire == null) ? 0 : horaire.hashCode());
		result = prime * result + ((horaire2 == null) ? 0 : horaire2.hashCode());
		result = prime * result + ((idjour == null) ? 0 : idjour.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Jour other = (Jour) obj;
		if (active != other.active)
			return false;
		if (horaire == null) {
			if (other.horaire != null)
				return false;
		} else if (!horaire.equals(other.horaire))
			return false;
		if (horaire2 == null) {
			if (other.horaire2 != null)
				return false;
		} else if (!horaire2.equals(other.horaire2))
			return false;
		if (idjour == null) {
			if (other.idjour != null)
				return false;
		} else if (!idjour.equals(other.idjour))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Jour [idjour=" + idjour + ", nom=" + nom + ", active=" + active + "]";
	}
	
	public void change(){
		if (active == 1)
			active = 0;
		else
			active = 1;
	}
		
}
