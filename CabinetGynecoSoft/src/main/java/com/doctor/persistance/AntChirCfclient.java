package com.doctor.persistance;

public class AntChirCfclient {

	private Integer idantchircfclient;
	private Cfclient cfclient;
	private AntecedentChir antChir;
	private String date;
private String antecedentChirugical;

	public String getAntecedentChirugical() {
	return antecedentChirugical;
}

public void setAntecedentChirugical(String antecedentChirugical) {
	this.antecedentChirugical = antecedentChirugical;
}

	public AntChirCfclient() {

	}

	public Integer getIdantchircfclient() {
		return idantchircfclient;
	}

	public void setIdantchircfclient(Integer idantchircfclient) {
		this.idantchircfclient = idantchircfclient;
	}

	public String getDate() {
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
				+ ((antecedentChirugical == null) ? 0 : antecedentChirugical
						.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime
				* result
				+ ((idantchircfclient == null) ? 0 : idantchircfclient
						.hashCode());
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
		AntChirCfclient other = (AntChirCfclient) obj;
		if (antecedentChirugical == null) {
			if (other.antecedentChirugical != null)
				return false;
		} else if (!antecedentChirugical.equals(other.antecedentChirugical))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idantchircfclient == null) {
			if (other.idantchircfclient != null)
				return false;
		} else if (!idantchircfclient.equals(other.idantchircfclient))
			return false;
		return true;
	}

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public AntecedentChir getAntChir() {
		return antChir;
	}

	public void setAntChir(AntecedentChir antChir) {
		this.antChir = antChir;
	}

	@Override
	public String toString() {
		return "AntChirCfclient [idantchircfclient=" + idantchircfclient
				+ ", date=" + date + ", antecedentChirugical="
				+ antecedentChirugical + "]";
	}
	
	
	
}
