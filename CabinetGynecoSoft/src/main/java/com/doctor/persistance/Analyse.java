package com.doctor.persistance;

import java.io.Serializable;

public class Analyse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idanalyse;
	private String libAnalyse;
	
	
	public Analyse(){
		
	}
	public Analyse(String libanalyse)
	{
		this.libAnalyse=libanalyse;
	}

	public Integer getIdanalyse() {
		return idanalyse;
	}

	public void setIdanalyse(Integer idanalyse) {
		this.idanalyse = idanalyse;
	}

	public String getLibAnalyse() {
		return libAnalyse;
	}

	public void setLibAnalyse(String libAnalyse) {
		this.libAnalyse = libAnalyse;
	}

	
	@Override
	public String toString() {
		return "Analyse [idanalyse=" + idanalyse + ", libAnalyse=" + libAnalyse
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idanalyse == null) ? 0 : idanalyse.hashCode());
		result = prime * result
				+ ((libAnalyse == null) ? 0 : libAnalyse.hashCode());
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
		Analyse other = (Analyse) obj;
		if (idanalyse == null) {
			if (other.idanalyse != null)
				return false;
		} else if (!idanalyse.equals(other.idanalyse))
			return false;
		if (libAnalyse == null) {
			if (other.libAnalyse != null)
				return false;
		} else if (!libAnalyse.equals(other.libAnalyse))
			return false;
		return true;
	}
	
	
	
}
