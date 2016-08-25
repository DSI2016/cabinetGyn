package com.doctor.persistance;

import java.io.Serializable;

public class MoyenContraception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idmoyenContraception;
	private String libMoyenContraception;
	
	
	public MoyenContraception(){
		
	}
	public MoyenContraception(String libmoyenContraception)
	{
		this.libMoyenContraception=libmoyenContraception;
	}

	public Integer getIdmoyenContraception() {
		return idmoyenContraception;
	}

	public void setIdmoyenContraception(Integer idmoyenContraception) {
		this.idmoyenContraception = idmoyenContraception;
	}

	public String getLibMoyenContraception() {
		return libMoyenContraception;
	}

	public void setLibMoyenContraception(String libMoyenContraception) {
		this.libMoyenContraception = libMoyenContraception;
	}

	
	@Override
	public String toString() {
		return "MoyenContraception [idmoyenContraception=" + idmoyenContraception + ", libMoyenContraception=" + libMoyenContraception
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idmoyenContraception == null) ? 0 : idmoyenContraception.hashCode());
		result = prime * result
				+ ((libMoyenContraception == null) ? 0 : libMoyenContraception.hashCode());
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
		MoyenContraception other = (MoyenContraception) obj;
		if (idmoyenContraception == null) {
			if (other.idmoyenContraception != null)
				return false;
		} else if (!idmoyenContraception.equals(other.idmoyenContraception))
			return false;
		if (libMoyenContraception == null) {
			if (other.libMoyenContraception != null)
				return false;
		} else if (!libMoyenContraception.equals(other.libMoyenContraception))
			return false;
		return true;
	}
	
	
	
}
