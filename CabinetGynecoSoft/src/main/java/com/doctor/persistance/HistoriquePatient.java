package com.doctor.persistance;

import java.io.Serializable;

public class HistoriquePatient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idhistoriquePatient;
	private String typeConsultation;
	private String dateConsultation;
	private Cfclient cfclient;
	public HistoriquePatient(){
		
	}
	
	
	public Cfclient getCfclient() {
		return cfclient;
	}


	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}


	public HistoriquePatient(Integer idhistoriquePatient,
			String typeConsultation, String dateConsultation) {
		super();
		this.idhistoriquePatient = idhistoriquePatient;
		this.typeConsultation = typeConsultation;
		this.dateConsultation = dateConsultation;
	}

	public Integer getIdhistoriquePatient() {
		return idhistoriquePatient;
	}

	public void setIdhistoriquePatient(Integer idhistoriquePatient) {
		this.idhistoriquePatient = idhistoriquePatient;
	}

	public String getTypeConsultation() {
		return typeConsultation;
	}
	public void setTypeConsultation(String typeConsultation) {
		this.typeConsultation = typeConsultation;
	}
	public String getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(String dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dateConsultation == null) ? 0 : dateConsultation.hashCode());
		result = prime
				* result
				+ ((idhistoriquePatient == null) ? 0 : idhistoriquePatient
						.hashCode());
		result = prime
				* result
				+ ((typeConsultation == null) ? 0 : typeConsultation.hashCode());
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
		HistoriquePatient other = (HistoriquePatient) obj;
		if (dateConsultation == null) {
			if (other.dateConsultation != null)
				return false;
		} else if (!dateConsultation.equals(other.dateConsultation))
			return false;
		if (idhistoriquePatient == null) {
			if (other.idhistoriquePatient != null)
				return false;
		} else if (!idhistoriquePatient.equals(other.idhistoriquePatient))
			return false;
		if (typeConsultation == null) {
			if (other.typeConsultation != null)
				return false;
		} else if (!typeConsultation.equals(other.typeConsultation))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HistoriquePatient [idhistoriquePatient=" + idhistoriquePatient
				+ ", typeConsultation=" + typeConsultation
				+ ", dateConsultation=" + dateConsultation + "]";
	}
	

}
