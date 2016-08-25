package com.doctor.persistance;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AntecedentChir implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idantecedentChir;
	private String antChirugical;
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);
	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	public AntecedentChir(){
		
	}
	
	public Integer getIdantecedentChir() {
		return idantecedentChir;
	}
	public void setIdantecedentChir(Integer idantecedentChir) {
		this.idantecedentChir = idantecedentChir;
	}
	public String getAntChirugical() {
		return antChirugical;
	}
	public void setAntChirugical(String antChirugical) {
		this.antChirugical = antChirugical;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antChirugical == null) ? 0 : antChirugical.hashCode());
		result = prime
				* result
				+ ((idantecedentChir == null) ? 0 : idantecedentChir.hashCode());
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
		AntecedentChir other = (AntecedentChir) obj;
		if (antChirugical == null) {
			if (other.antChirugical != null)
				return false;
		} else if (!antChirugical.equals(other.antChirugical))
			return false;
		if (idantecedentChir == null) {
			if (other.idantecedentChir != null)
				return false;
		} else if (!idantecedentChir.equals(other.idantecedentChir))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AntecedentChir [idantecedentChir=" + idantecedentChir
				+ ", antChirugical=" + antChirugical + "]";
	}
	
	
}
