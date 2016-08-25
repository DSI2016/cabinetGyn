package com.doctor.persistance;

import java.io.Serializable;

public class Examen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idexamen;
	private String examen;
	
	public Examen(){
		
	}
public Examen(String examen){
		this.examen=examen;
	}
	
	public Integer getIdexamen() {
		return idexamen;
	}
	public void setIdexamen(Integer idexamen) {
		this.idexamen = idexamen;
	}
	public String getExamen() {
		return examen;
	}
	public void setExamen(String examen) {
		this.examen = examen;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result
				+ ((idexamen == null) ? 0 : idexamen.hashCode());
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
		Examen other = (Examen) obj;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (idexamen == null) {
			if (other.idexamen != null)
				return false;
		} else if (!idexamen.equals(other.idexamen))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Examen [idexamen=" + idexamen + ", examen=" + examen + "]";
	}
	
}
