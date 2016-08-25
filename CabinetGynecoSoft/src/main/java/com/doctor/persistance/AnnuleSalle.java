package com.doctor.persistance;

public class AnnuleSalle {
	private Integer idannuleSalle;
	private String heure;
	private String motif;
	private String notes;
	private String cause;
	private String patient;
	private String village;
	
	private Cfclient cfclient;
	
	
	
	public Cfclient getCfclient() {
		return cfclient;
	}
	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public Integer getIdannuleSalle() {
		return idannuleSalle;
	}
	public void setIdannuleSalle(Integer idannuleSalle) {
		this.idannuleSalle = idannuleSalle;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cause == null) ? 0 : cause.hashCode());
		result = prime * result + ((heure == null) ? 0 : heure.hashCode());
		result = prime * result
				+ ((idannuleSalle == null) ? 0 : idannuleSalle.hashCode());
		result = prime * result + ((motif == null) ? 0 : motif.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((village == null) ? 0 : village.hashCode());
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
		AnnuleSalle other = (AnnuleSalle) obj;
		if (cause == null) {
			if (other.cause != null)
				return false;
		} else if (!cause.equals(other.cause))
			return false;
		if (heure == null) {
			if (other.heure != null)
				return false;
		} else if (!heure.equals(other.heure))
			return false;
		if (idannuleSalle == null) {
			if (other.idannuleSalle != null)
				return false;
		} else if (!idannuleSalle.equals(other.idannuleSalle))
			return false;
		if (motif == null) {
			if (other.motif != null)
				return false;
		} else if (!motif.equals(other.motif))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (village == null) {
			if (other.village != null)
				return false;
		} else if (!village.equals(other.village))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AnnuleSalle [idannuleSalle=" + idannuleSalle + ", heure="
				+ heure + ", motif=" + motif + ", notes=" + notes + ", cause="
				+ cause + ", patient=" + patient + ", village=" + village + "]";
	}
	
}
