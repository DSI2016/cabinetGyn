package com.doctor.persistance;

import java.io.Serializable;

public class ExamenComplementaire implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idexamenComplementaire;
	
	private String libExamenComplementaire;
	
	
	public ExamenComplementaire(){
		
	}
	public ExamenComplementaire(String libexamenComplementaire)
	{
		this.libExamenComplementaire=libexamenComplementaire;
	}

	public Integer getIdexamenComplementaire() {
		return idexamenComplementaire;
	}

	public void setIdexamenComplementaire(Integer idexamenComplementaire) {
		this.idexamenComplementaire = idexamenComplementaire;
	}

	public String getLibExamenComplementaire() {
		return libExamenComplementaire;
	}

	public void setLibExamenComplementaire(String libExamenComplementaire) {
		this.libExamenComplementaire = libExamenComplementaire;
	}

	
	@Override
	public String toString() {
		return "ExamenComplementaire [idexamenComplementaire=" + idexamenComplementaire + ", libExamenComplementaire=" + libExamenComplementaire
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idexamenComplementaire == null) ? 0 : idexamenComplementaire.hashCode());
		result = prime * result
				+ ((libExamenComplementaire == null) ? 0 : libExamenComplementaire.hashCode());
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
		ExamenComplementaire other = (ExamenComplementaire) obj;
		if (idexamenComplementaire == null) {
			if (other.idexamenComplementaire != null)
				return false;
		} else if (!idexamenComplementaire.equals(other.idexamenComplementaire))
			return false;
		if (libExamenComplementaire == null) {
			if (other.libExamenComplementaire != null)
				return false;
		} else if (!libExamenComplementaire.equals(other.libExamenComplementaire))
			return false;
		return true;
	}
	
	
	
}
