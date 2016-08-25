package com.doctor.persistance;

import java.io.Serializable;

public class EtatFinGross implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEtatFinGross;
	private String etatFinG;
	private boolean incrementation;

	public EtatFinGross() {

	}

	public boolean isIncrementation() {
		return incrementation;
	}

	public void setIncrementation(boolean incrementation) {
		this.incrementation = incrementation;
	}

	public Integer getIdEtatFinGross() {
		return idEtatFinGross;
	}

	public void setIdEtatFinGross(Integer idEtatFinGross) {
		this.idEtatFinGross = idEtatFinGross;
	}

	public String getEtatFinG() {
		return etatFinG;
	}

	public void setEtatFinG(String etatFinG) {
		this.etatFinG = etatFinG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((etatFinG == null) ? 0 : etatFinG.hashCode());
		result = prime * result
				+ ((idEtatFinGross == null) ? 0 : idEtatFinGross.hashCode());
		result = prime * result + (incrementation ? 1231 : 1237);
		return result;
	}

	@Override
	public String toString() {
		return "EtatFinGross [idEtatFinGross=" + idEtatFinGross + ", etatFinG="
				+ etatFinG + ", incrementation=" + incrementation + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtatFinGross other = (EtatFinGross) obj;
		if (etatFinG == null) {
			if (other.etatFinG != null)
				return false;
		} else if (!etatFinG.equals(other.etatFinG))
			return false;
		if (idEtatFinGross == null) {
			if (other.idEtatFinGross != null)
				return false;
		} else if (!idEtatFinGross.equals(other.idEtatFinGross))
			return false;
		if (incrementation != other.incrementation)
			return false;
		return true;
	}
}
