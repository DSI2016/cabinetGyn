package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;

public class JourFrSp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idjourFrSp;
	private Date debut;
	private Date fin;
	private String disc;
	private int nbjs;
	
	
	public int getNbjs() {
		return nbjs;
	}

	public void setNbjs(int nbjs) {
		this.nbjs = nbjs;
	}

	public JourFrSp(){
		
	}

	public JourFrSp(Date debut, Date fin, String disc) {
		this.debut = debut;
		this.fin = fin;
		this.disc = disc;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debut == null) ? 0 : debut.hashCode());
		result = prime * result + ((disc == null) ? 0 : disc.hashCode());
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result
				+ ((idjourFrSp == null) ? 0 : idjourFrSp.hashCode());
		result = prime * result + nbjs;
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
		JourFrSp other = (JourFrSp) obj;
		if (debut == null) {
			if (other.debut != null)
				return false;
		} else if (!debut.equals(other.debut))
			return false;
		if (disc == null) {
			if (other.disc != null)
				return false;
		} else if (!disc.equals(other.disc))
			return false;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (idjourFrSp == null) {
			if (other.idjourFrSp != null)
				return false;
		} else if (!idjourFrSp.equals(other.idjourFrSp))
			return false;
		if (nbjs != other.nbjs)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JourFrSp [idjourFrSp=" + idjourFrSp + ", debut=" + debut
				+ ", fin=" + fin + ", disc=" + disc + ", nbjs=" + nbjs + "]";
	}
	
}
