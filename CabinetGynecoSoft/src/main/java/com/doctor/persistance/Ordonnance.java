package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Ordonnance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idOrdonnance;
	private String notes;
	private ConsultationDetail consult;
	private Set<MedOrd> medOrds = new HashSet<MedOrd>(0);
	private String possesseur;
	private Cfclient patient;
	private Date dateOrd;
	private String type;
	private String proprietaire;

	public String getPossesseur() {
		return possesseur;
	}

	public void setPossesseur(String possesseur) {
		this.possesseur = possesseur;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateOrd() {
		return dateOrd;
	}

	public void setDateOrd(Date dateOrd) {
		this.dateOrd = dateOrd;
	}

	public Cfclient getPatient() {
		return patient;
	}

	public void setPatient(Cfclient patient) {
		this.patient = patient;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getIdOrdonnance() {
		return idOrdonnance;
	}

	public void setIdOrdonnance(Integer idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}

	public ConsultationDetail getConsult() {
		return consult;
	}

	public void setConsult(ConsultationDetail consult) {
		this.consult = consult;
	}

	public Set<MedOrd> getMedOrds() {
		return medOrds;
	}

	public void setMedOrds(Set<MedOrd> medOrds) {
		this.medOrds = medOrds;
	}

	@Override
	public String toString() {
		return "Ordonnance [idOrdonnance=" + idOrdonnance + ", notes=" + notes
				+ ", possesseur=" + possesseur + ", dateOrd=" + dateOrd
				+ ", type=" + type + ", proprietaire=" + proprietaire + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOrd == null) ? 0 : dateOrd.hashCode());
		result = prime * result
				+ ((idOrdonnance == null) ? 0 : idOrdonnance.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result
				+ ((possesseur == null) ? 0 : possesseur.hashCode());
		result = prime * result
				+ ((proprietaire == null) ? 0 : proprietaire.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Ordonnance other = (Ordonnance) obj;
		if (dateOrd == null) {
			if (other.dateOrd != null)
				return false;
		} else if (!dateOrd.equals(other.dateOrd))
			return false;
		if (idOrdonnance == null) {
			if (other.idOrdonnance != null)
				return false;
		} else if (!idOrdonnance.equals(other.idOrdonnance))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (possesseur == null) {
			if (other.possesseur != null)
				return false;
		} else if (!possesseur.equals(other.possesseur))
			return false;
		if (proprietaire == null) {
			if (other.proprietaire != null)
				return false;
		} else if (!proprietaire.equals(other.proprietaire))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
