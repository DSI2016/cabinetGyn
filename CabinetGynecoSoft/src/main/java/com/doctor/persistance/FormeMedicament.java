package com.doctor.persistance;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class FormeMedicament implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idFormeMedicament;
	private String forme;
	private Set<Medicament> medicaments = new HashSet<Medicament>(0);
	
	public FormeMedicament()
	{
		
	}
	
	

	public FormeMedicament(String forme) {
		
		this.forme = forme;
	}



	public Set<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Set<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getIdFormeMedicament() {
		return idFormeMedicament;
	}
	public void setIdFormeMedicament(Integer idFormeMedicament) {
		this.idFormeMedicament = idFormeMedicament;
	}
	public String getForme() {
		return forme;
	}
	public void setForme(String forme) {
		this.forme = forme;
	}
	
	@Override
	public String toString() {
		return "FormeMedicament [idFormeMedicament=" + idFormeMedicament
				+ ", forme=" + forme + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forme == null) ? 0 : forme.hashCode());
		result = prime
				* result
				+ ((idFormeMedicament == null) ? 0 : idFormeMedicament
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
		FormeMedicament other = (FormeMedicament) obj;
		if (forme == null) {
			if (other.forme != null)
				return false;
		} else if (!forme.equals(other.forme))
			return false;
		if (idFormeMedicament == null) {
			if (other.idFormeMedicament != null)
				return false;
		} else if (!idFormeMedicament.equals(other.idFormeMedicament))
			return false;
		return true;
	}
	
	
	
}
