package com.doctor.persistance;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AntecedentFam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idantecedentFam;
	private String antFamilial;
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);
	
	public Set<Cfclient> getCfclients() {
		return cfclients;
	}
	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}
	public AntecedentFam(){
		
	}
	public Integer getIdantecedentFam() {
		return idantecedentFam;
	}
	public void setIdantecedentFam(Integer idantecedentFam) {
		this.idantecedentFam = idantecedentFam;
	}
	public String getAntFamilial() {
		return antFamilial;
	}
	public void setAntFamilial(String antFamilial) {
		this.antFamilial = antFamilial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antFamilial == null) ? 0 : antFamilial.hashCode());
		result = prime * result
				+ ((idantecedentFam == null) ? 0 : idantecedentFam.hashCode());
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
		AntecedentFam other = (AntecedentFam) obj;
		if (antFamilial == null) {
			if (other.antFamilial != null)
				return false;
		} else if (!antFamilial.equals(other.antFamilial))
			return false;
		if (idantecedentFam == null) {
			if (other.idantecedentFam != null)
				return false;
		} else if (!idantecedentFam.equals(other.idantecedentFam))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AntecedentFam [idantecedentFam=" + idantecedentFam
				+ ", antFamilial=" + antFamilial + "]";
	}
	
	
	
}
