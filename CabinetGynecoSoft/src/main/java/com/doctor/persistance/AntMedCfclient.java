package com.doctor.persistance;

import java.io.Serializable;

public class AntMedCfclient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idantmedcfclient;
	private Cfclient cfclient;
	private AntecedentMed antMed;
	private String date;
	private String antecedentMedical;

	public String getAntecedentMedical() {
		return antecedentMedical;
	}

	public void setAntecedentMedical(String antecedentMedical) {
		this.antecedentMedical = antecedentMedical;
	}

	public AntMedCfclient() {

	}

	public AntecedentMed getAntMed() {
		return antMed;
	}

	public void setAntMed(AntecedentMed antMed) {
		this.antMed = antMed;
	}

	public Integer getIdantmedcfclient() {
		return idantmedcfclient;
	}

	public void setIdantmedcfclient(Integer idantmedcfclient) {
		this.idantmedcfclient = idantmedcfclient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	@Override
	public String toString() {
		return "AntMedCfclient [idantmedcfclient=" + idantmedcfclient
				+ ", date=" + date + ", antecedentMedical=" + antecedentMedical
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((antecedentMedical == null) ? 0 : antecedentMedical
						.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime
				* result
				+ ((idantmedcfclient == null) ? 0 : idantmedcfclient.hashCode());
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
		AntMedCfclient other = (AntMedCfclient) obj;
		if (antecedentMedical == null) {
			if (other.antecedentMedical != null)
				return false;
		} else if (!antecedentMedical.equals(other.antecedentMedical))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idantmedcfclient == null) {
			if (other.idantmedcfclient != null)
				return false;
		} else if (!idantmedcfclient.equals(other.idantmedcfclient))
			return false;
		return true;
	}

}
