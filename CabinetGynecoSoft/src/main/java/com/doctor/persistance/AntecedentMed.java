package com.doctor.persistance;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AntecedentMed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idantecedentMed;
	private String antMedical;
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);
	
	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	public AntecedentMed(){
		
	}

	public Integer getIdantecedentMed() {
		return idantecedentMed;
	}

	public void setIdantecedentMed(Integer idantecedentMed) {
		this.idantecedentMed = idantecedentMed;
	}

	public String getAntMedical() {
		return antMedical;
	}

	public void setAntMedical(String antMedical) {
		this.antMedical = antMedical;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antMedical == null) ? 0 : antMedical.hashCode());
		result = prime * result
				+ ((idantecedentMed == null) ? 0 : idantecedentMed.hashCode());
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
		AntecedentMed other = (AntecedentMed) obj;
		if (antMedical == null) {
			if (other.antMedical != null)
				return false;
		} else if (!antMedical.equals(other.antMedical))
			return false;
		if (idantecedentMed == null) {
			if (other.idantecedentMed != null)
				return false;
		} else if (!idantecedentMed.equals(other.idantecedentMed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AntecedentMed [idantecedentMed=" + idantecedentMed
				+ ", antMedical=" + antMedical + "]";
	}
	
}
