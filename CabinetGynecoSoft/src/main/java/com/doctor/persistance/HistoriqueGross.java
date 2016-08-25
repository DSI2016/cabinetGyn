package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;

public class HistoriqueGross implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idhistoriqueGross;
	private String debutGross;
	private String finGross;
	private String notes;
	private String honoraires;
	private String terme;
	private String lieu;
	private String prenomBebe;
	private String sexeBebe;
	private Date dateFinGross;
	private Integer idcons;
	
	private String prenomBebe2;
	private String sexeBebe2;
	private Float poids2;
	private EtatBebe etatBebe2;
	
	private String prenomBebe3;
	private String sexeBebe3;
	private Float poids3;
	private EtatBebe etatBebe3;
	private Float poids;
	private Cfclient cfclient;
	private EtatBebe etatBebe;
	private EtatFinGross etatFinGross;
	
	public Date getDateFinGross() {
		return dateFinGross;
	}

	public void setDateFinGross(Date dateFinGross) {
		this.dateFinGross = dateFinGross;
	}

	public String getPrenomBebe2() {
		return prenomBebe2;
	}

	public void setPrenomBebe2(String prenomBebe2) {
		this.prenomBebe2 = prenomBebe2;
	}

	public String getSexeBebe2() {
		return sexeBebe2;
	}

	public void setSexeBebe2(String sexeBebe2) {
		this.sexeBebe2 = sexeBebe2;
	}

	public Float getPoids2() {
		return poids2;
	}

	public void setPoids2(Float poids2) {
		this.poids2 = poids2;
	}

	public EtatBebe getEtatBebe2() {
		return etatBebe2;
	}

	public void setEtatBebe2(EtatBebe etatBebe2) {
		this.etatBebe2 = etatBebe2;
	}

	public String getPrenomBebe3() {
		return prenomBebe3;
	}

	public void setPrenomBebe3(String prenomBebe3) {
		this.prenomBebe3 = prenomBebe3;
	}

	public String getSexeBebe3() {
		return sexeBebe3;
	}

	public void setSexeBebe3(String sexeBebe3) {
		this.sexeBebe3 = sexeBebe3;
	}

	public Float getPoids3() {
		return poids3;
	}

	public void setPoids3(Float poids3) {
		this.poids3 = poids3;
	}

	public EtatBebe getEtatBebe3() {
		return etatBebe3;
	}

	public void setEtatBebe3(EtatBebe etatBebe3) {
		this.etatBebe3 = etatBebe3;
	}

	public EtatFinGross getEtatFinGross() {
		return etatFinGross;
	}

	public void setEtatFinGross(EtatFinGross etatFinGross) {
		this.etatFinGross = etatFinGross;
	}

	public HistoriqueGross() {

	}

	public EtatBebe getEtatBebe() {
		return etatBebe;
	}

	public void setEtatBebe(EtatBebe etatBebe) {
		this.etatBebe = etatBebe;
	}

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	@Override
	public String toString() {
		return "HistoriqueGross [idhistoriqueGross=" + idhistoriqueGross
				+ ", debutGross=" + debutGross + ", finGross=" + finGross
				+ ", notes=" + notes + ", honoraires=" + honoraires
				+ ", terme=" + terme + ", lieu=" + lieu + ", prenomBebe="
				+ prenomBebe + ", sexeBebe=" + sexeBebe + ", dateFinGross="
				+ dateFinGross + ", prenomBebe2=" + prenomBebe2
				+ ", sexeBebe2=" + sexeBebe2 + ", poids2=" + poids2
				+ ", prenomBebe3=" + prenomBebe3 + ", sexeBebe3=" + sexeBebe3
				+ ", poids3=" + poids3 + ", poids=" + poids + "]";
	}

	public Integer getIdhistoriqueGross() {
		return idhistoriqueGross;
	}

	public void setIdhistoriqueGross(Integer idhistoriqueGross) {
		this.idhistoriqueGross = idhistoriqueGross;
	}

	public String getDebutGross() {
		return debutGross;
	}

	public void setDebutGross(String debutGross) {
		this.debutGross = debutGross;
	}

	public String getFinGross() {
		return finGross;
	}

	public void setFinGross(String finGross) {
		this.finGross = finGross;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getHonoraires() {
		return honoraires;
	}

	public void setHonoraires(String honoraires) {
		this.honoraires = honoraires;
	}

	public String getTerme() {
		return terme;
	}

	public void setTerme(String terme) {
		this.terme = terme;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getPrenomBebe() {
		return prenomBebe;
	}

	public void setPrenomBebe(String prenomBebe) {
		this.prenomBebe = prenomBebe;
	}

	public String getSexeBebe() {
		return sexeBebe;
	}

	public void setSexeBebe(String sexeBebe) {
		this.sexeBebe = sexeBebe;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateFinGross == null) ? 0 : dateFinGross.hashCode());
		result = prime * result
				+ ((debutGross == null) ? 0 : debutGross.hashCode());
		result = prime * result
				+ ((finGross == null) ? 0 : finGross.hashCode());
		result = prime * result
				+ ((honoraires == null) ? 0 : honoraires.hashCode());
		result = prime * result + ((idcons == null) ? 0 : idcons.hashCode());
		result = prime
				* result
				+ ((idhistoriqueGross == null) ? 0 : idhistoriqueGross
						.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((poids == null) ? 0 : poids.hashCode());
		result = prime * result + ((poids2 == null) ? 0 : poids2.hashCode());
		result = prime * result + ((poids3 == null) ? 0 : poids3.hashCode());
		result = prime * result
				+ ((prenomBebe == null) ? 0 : prenomBebe.hashCode());
		result = prime * result
				+ ((prenomBebe2 == null) ? 0 : prenomBebe2.hashCode());
		result = prime * result
				+ ((prenomBebe3 == null) ? 0 : prenomBebe3.hashCode());
		result = prime * result
				+ ((sexeBebe == null) ? 0 : sexeBebe.hashCode());
		result = prime * result
				+ ((sexeBebe2 == null) ? 0 : sexeBebe2.hashCode());
		result = prime * result
				+ ((sexeBebe3 == null) ? 0 : sexeBebe3.hashCode());
		result = prime * result + ((terme == null) ? 0 : terme.hashCode());
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
		HistoriqueGross other = (HistoriqueGross) obj;
		if (dateFinGross == null) {
			if (other.dateFinGross != null)
				return false;
		} else if (!dateFinGross.equals(other.dateFinGross))
			return false;
		if (debutGross == null) {
			if (other.debutGross != null)
				return false;
		} else if (!debutGross.equals(other.debutGross))
			return false;
		if (finGross == null) {
			if (other.finGross != null)
				return false;
		} else if (!finGross.equals(other.finGross))
			return false;
		if (honoraires == null) {
			if (other.honoraires != null)
				return false;
		} else if (!honoraires.equals(other.honoraires))
			return false;
		if (idcons == null) {
			if (other.idcons != null)
				return false;
		} else if (!idcons.equals(other.idcons))
			return false;
		if (idhistoriqueGross == null) {
			if (other.idhistoriqueGross != null)
				return false;
		} else if (!idhistoriqueGross.equals(other.idhistoriqueGross))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (poids == null) {
			if (other.poids != null)
				return false;
		} else if (!poids.equals(other.poids))
			return false;
		if (poids2 == null) {
			if (other.poids2 != null)
				return false;
		} else if (!poids2.equals(other.poids2))
			return false;
		if (poids3 == null) {
			if (other.poids3 != null)
				return false;
		} else if (!poids3.equals(other.poids3))
			return false;
		if (prenomBebe == null) {
			if (other.prenomBebe != null)
				return false;
		} else if (!prenomBebe.equals(other.prenomBebe))
			return false;
		if (prenomBebe2 == null) {
			if (other.prenomBebe2 != null)
				return false;
		} else if (!prenomBebe2.equals(other.prenomBebe2))
			return false;
		if (prenomBebe3 == null) {
			if (other.prenomBebe3 != null)
				return false;
		} else if (!prenomBebe3.equals(other.prenomBebe3))
			return false;
		if (sexeBebe == null) {
			if (other.sexeBebe != null)
				return false;
		} else if (!sexeBebe.equals(other.sexeBebe))
			return false;
		if (sexeBebe2 == null) {
			if (other.sexeBebe2 != null)
				return false;
		} else if (!sexeBebe2.equals(other.sexeBebe2))
			return false;
		if (sexeBebe3 == null) {
			if (other.sexeBebe3 != null)
				return false;
		} else if (!sexeBebe3.equals(other.sexeBebe3))
			return false;
		if (terme == null) {
			if (other.terme != null)
				return false;
		} else if (!terme.equals(other.terme))
			return false;
		return true;
	}

	public Integer getIdcons() {
		return idcons;
	}

	public void setIdcons(Integer idcons) {
		this.idcons = idcons;
	}

}
