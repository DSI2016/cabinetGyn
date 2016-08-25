package com.doctor.persistance;

import java.io.Serializable;

public class Consultation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idconsultation;
	private String nomConsultation;
	private double honoraire;
	private boolean active;
	
	
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public double getHonoraire() {
		return honoraire;
	}


	public void setHonoraire(double honoraire) {
		this.honoraire = honoraire;
	}


	public Consultation(){}
	
	
	public Integer getIdconsultation() {
		return idconsultation;
	}


	public void setIdconsultation(Integer idconsultation) {
		this.idconsultation = idconsultation;
	}


	public String getNomConsultation() {
		return nomConsultation;
	}
	public void setNomConsultation(String nomConsultation) {
		this.nomConsultation = nomConsultation;
	}
	@Override
	public String toString() {
		return "Consultation [idconsultation=" + idconsultation
				+ ", nomConsultation=" + nomConsultation + ", honoraire="
				+ honoraire + ", active=" + active + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(honoraire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((idconsultation == null) ? 0 : idconsultation.hashCode());
		result = prime * result
				+ ((nomConsultation == null) ? 0 : nomConsultation.hashCode());
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
		Consultation other = (Consultation) obj;
		if (active != other.active)
			return false;
		if (Double.doubleToLongBits(honoraire) != Double
				.doubleToLongBits(other.honoraire))
			return false;
		if (idconsultation == null) {
			if (other.idconsultation != null)
				return false;
		} else if (!idconsultation.equals(other.idconsultation))
			return false;
		if (nomConsultation == null) {
			if (other.nomConsultation != null)
				return false;
		} else if (!nomConsultation.equals(other.nomConsultation))
			return false;
		return true;
	}
	

}
