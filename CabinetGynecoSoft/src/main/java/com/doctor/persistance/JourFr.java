package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;

public class JourFr implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idjourFr;
	private Date date;
	private String disc;
	private Date dateFin;
	private int nbj;
	
	public int getNbj() {
		return nbj;
	}

	public void setNbj(int nbj) {
		this.nbj = nbj;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public JourFr(){
		
	}

	public JourFr(Date date, String disc) {
		this.date = date;
		this.disc = disc;
	}

	public Integer getIdjourFr() {
		return idjourFr;
	}

	public void setIdjourFr(Integer idjourFr) {
		this.idjourFr = idjourFr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((disc == null) ? 0 : disc.hashCode());
		result = prime * result
				+ ((idjourFr == null) ? 0 : idjourFr.hashCode());
		result = prime * result + nbj;
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
		JourFr other = (JourFr) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (disc == null) {
			if (other.disc != null)
				return false;
		} else if (!disc.equals(other.disc))
			return false;
		if (idjourFr == null) {
			if (other.idjourFr != null)
				return false;
		} else if (!idjourFr.equals(other.idjourFr))
			return false;
		if (nbj != other.nbj)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JourFr [idjourFr=" + idjourFr + ", date=" + date + ", disc="
				+ disc + ", dateFin=" + dateFin + ", nbj=" + nbj + "]";
	}
	
}
