package com.doctor.persistance;

public class AntFamCfclient {

	private Integer idantfamcfclient;
	private Cfclient cfclient;
	private AntecedentFam antFam;
	private String date;
	private String antecedentFamilial;

	public AntFamCfclient() {

	}

	public String getAntecedentFamilial() {
		return antecedentFamilial;
	}

	public void setAntecedentFamilial(String antecedentFamilial) {
		this.antecedentFamilial = antecedentFamilial;
	}

	public Integer getIdantfamcfclient() {
		return idantfamcfclient;
	}

	public void setIdantfamcfclient(Integer idantfamcfclient) {
		this.idantfamcfclient = idantfamcfclient;
	}

	public String getDate() {
		// System.out.println("getdate  "+date);
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((antecedentFamilial == null) ? 0 : antecedentFamilial
						.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime
				* result
				+ ((idantfamcfclient == null) ? 0 : idantfamcfclient.hashCode());
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
		AntFamCfclient other = (AntFamCfclient) obj;
		if (antecedentFamilial == null) {
			if (other.antecedentFamilial != null)
				return false;
		} else if (!antecedentFamilial.equals(other.antecedentFamilial))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idantfamcfclient == null) {
			if (other.idantfamcfclient != null)
				return false;
		} else if (!idantfamcfclient.equals(other.idantfamcfclient))
			return false;
		return true;
	}

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public AntecedentFam getAntFam() {
		return antFam;
	}

	public void setAntFam(AntecedentFam antFam) {
		this.antFam = antFam;
	}

	@Override
	public String toString() {
		return "AntFamCfclient [idantfamcfclient=" + idantfamcfclient
				+ ", date=" + date + ", antecedentFamilial="
				+ antecedentFamilial + "]";
	}

}
